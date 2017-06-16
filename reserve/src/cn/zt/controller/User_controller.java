package cn.zt.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zt.domain.Food;
import cn.zt.domain.FoodType;
import cn.zt.domain.Pagebean;
import cn.zt.domain.User;
import cn.zt.service.FoodService;
import cn.zt.service.FoodTypeService;
import cn.zt.service.OrderService;
import cn.zt.service.UserService;

@Controller
@RequestMapping("/user")
public class User_controller
{
	//注入service层
	@Resource(name="UserService")
	private UserService userService;
	@Resource(name="FoodTypeService")
	private FoodTypeService foodTypeService;
	@Resource(name="FoodService")
	private FoodService foodService;
	//添加用户
	@RequestMapping("/adduser")
	public String adduser(User user,Model mav)
	{
		if(userService.findByPhone(user.getPhone())!=null)
		{
			mav.addAttribute("msg", "手机号已被注册，请重试！");
			return "/sys/saveUser.jsp";
		}
		userService.adduser(user);
		return "/user/findalluser.do";
	}
	
	/**
	 * 前台注册
	 */
	@RequestMapping("/adduser2")
	public String adduser2(User user,Model mav)
	{
		if(userService.findByPhone(user.getPhone())!=null)
		{
			mav.addAttribute("msg", "手机号已被注册，请重试！");
			return "/app/register.jsp";
		}
		userService.adduser(user);
		return "/app/login.jsp";
	}
	
	/**
	 * 查询所有用户
	 * @param mav
	 * @return
	 */
	@RequestMapping("/findalluser")
	public String findall(Model mav)
	{
		mav.addAttribute("userlist", userService.finall());
		return "/sys/userlist.jsp";
	}
	
	/**
	 * 后台更新用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateuser")
	public String updateuser(User user)
	{
		userService.updateuser(user);
		return "/user/findalluser.do";
	}
	/**
	 * 前台更新用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/xiugaiuser")
	public String updateuser1(User user,HttpSession session,Model mav)
	{
		userService.updateuser(user);
		session.removeAttribute("us");
		session.setMaxInactiveInterval(0);
		session.setAttribute("us", userService.findByID(user.getId()));
		mav.addAttribute("msg", "修改成功！！！");
		return "/app/personal.jsp";
	}
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteuser")
	public String deleteuser(int id)
	{
		User user=userService.findByID(id);
		userService.deleteuser(user);
		return "/user/findalluser.do";
	}
	
	/**
	 * 个人信息更新跳转
	 * @param mav
	 * @param id
	 * @return
	 */
	@RequestMapping("/person")
	public String personuser(Model mav,int id)
	{
		User user=userService.findByID(id);
		
		mav.addAttribute("u", user);
		return "/sys/updateUser.jsp";
	}
	
	/**
	 * 根据用户的手机号查询
	 * @param phone
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/ipone")
	public void chax(String phone,HttpServletResponse response) throws IOException
	{
		User uu=userService.findByPhone(phone);
		String result=null;
		if(uu!=null)
		{
			result="<font color='red'>该手机号已被注册</font>";
		}
		else
		{
			result="<font color='green'>该手机号可用</font>";
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
		
	}
	
	/**
	 * 用户登录
	 * @param mav
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String login(Model mav,User user,HttpSession session)
	{
		User uu=userService.longin(user);
		/*if(uu!=null&&uu.getPhone().equals("admin"))
		{
			return "/sys/index.jsp";
		}*/
		 if(uu!=null)
		{
			
			session.setMaxInactiveInterval(0);
			session.setAttribute( "us", uu);
			Pagebean<FoodType> pagebean=foodTypeService.findByPage(1, 0);
			mav.addAttribute("foty", pagebean);
			return "/app/guodicaidan.jsp";
		}
		else
		{
			mav.addAttribute("msg", "手机号或密码错误!");
			return "/app/login.jsp";
		}
		
	}
	/**
	 *退出系统
	 */
	@RequestMapping("/exit")
	public String tuichu(HttpSession session)
	{
		session.removeAttribute("us");
		return "/app/login.jsp";
	}
	

}
