package cn.zt.controller;



import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zt.domain.Food;
import cn.zt.domain.Pagebean;
import cn.zt.service.FoodService;

@Controller
@RequestMapping("/food")
public class Food_controller
{
	//注入service层
	@Resource(name="FoodService")
	private FoodService foodService;
	
	//添加菜品
	@RequestMapping("/addfood")
	public String addfood(Food food,HttpServletRequest request)
	{
		String nn=request.getParameter("foodName");
		System.out.println(nn);
		foodService.addfood(food);
		return "/food/findallfood.do";
	}
	
	//查询到所有的菜品
	@RequestMapping("/findallfood")
	public String findall(Model mav)
	{
		mav.addAttribute("foodlist", foodService.findall());
		
		return "/sys/foodList.jsp";
		
	}
	
	//删除菜品
	@RequestMapping("/deletefood")
	public String deletefood(int id)
	{
		foodService.deletefood(id);
		return "/food/findallfood.do";
	}
	
	//跳转更新页面
	@RequestMapping("/updatejsp")
	public String tiaozhan(int id,Model mav)
	{
		Food fd=foodService.FindById(id);
		mav.addAttribute("fd", fd);
		return "/sys/updateFood.jsp";
	}
	
	//更新菜品信息
	@RequestMapping("/updatefood")
	public String genxincai(Food food)
	{
		
		foodService.updatefood(food);
		return "/food/findallfood.do";
	}
	
	//跳转菜详细页面
	@RequestMapping("/tiaocaix")
	public String tiapxiganxi(int id,Model mav)
	{
		mav.addAttribute("caixx", foodService.FindById(id));
		return "/app/caixiangxi.jsp";
	}
	/**
	 * 菜品分页
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/fenye")
	public 	String fenye(int nowpage,int allpage,String leixing,Model mav) throws UnsupportedEncodingException
	{
		
		String ss=new String(leixing.getBytes("ISO-8859-1"),"utf-8");
		Pagebean<Food> pagebean=foodService.findByPage(nowpage, allpage,ss);
		mav.addAttribute("pagebean", pagebean);
		if(ss.equals("荤菜"))
			return "/app/huncaidan.jsp";
		else
			return "/app/sucaidan.jsp";
	}

}
