package cn.zt.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import cn.zt.domain.Cart;
import cn.zt.domain.Food;
import cn.zt.domain.FoodType;
import cn.zt.domain.Pagebean;
import cn.zt.domain.User;
import cn.zt.domain.Cart_detail;
import cn.zt.service.CartService;
import cn.zt.service.FoodService;
import cn.zt.service.FoodTypeService;
import cn.zt.service.UserService;

/**
 * 餐车控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cart")
public class Cart_controller
{
	/**
	 * 注入service层
	 */
	@Resource(name="cartService")
	private CartService cartService;
	@Resource(name="FoodService")
	private FoodService foodService;
	@Resource(name="UserService")
	private UserService userService;
	@Resource(name="FoodTypeService")
	private FoodTypeService foodTypeService;
	/**
	 * 餐车里添加数据
	 * @param response
	 * @param food_id
	 * @param user_id
	 */
	@RequestMapping("/addcart")
	public void addcart(HttpServletResponse response,int food_id,int user_id)
	{
		User uu=userService.findByID(user_id);

		Cart cart=cartService.FindByUId(uu);//根据用户ID查询餐车记录
		Food food=foodService.FindById(food_id);//根据food id查询到菜品
		String result=null;
		result="<font color='green'>"+food.getFoodName()+"已加入餐车"+"</font>";
		if(cart!=null&&food!=null)//说明已有该餐车-
		{
			//查询所有明细表
			List<Cart_detail> cdli=cartService.selectByCart_id(cart);
			//有记录的时候
			if(cdli!=null)
			{
				for(int i=0;i<cdli.size();i++)
				{
					//相同说明已经存在，则家数量
					if(cdli.get(i).getFood().getId()==food_id)
					{
						cdli.get(i).setFood_number(cdli.get(i).getFood_number()+1);
						cartService.updateCart_detail(cdli.get(i));
						break;
					}
					//到最后一个仍不是,添加新的明细表
					if(i==cdli.size()-1&&cdli.get(i).getFood().getId()!=food_id)
					{
						Cart_detail cd=new Cart_detail();
						cd.setCart(cart);
						cd.setFood(food);
						cd.setFood_number(1);
						cartService.addCart_detail(cd);
					}
				}
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				try
				{
					response.getWriter().print(result);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				Cart_detail cd=new Cart_detail();
				cd.setCart(cart);
				cd.setFood(food);
				cd.setFood_number(1);
				cartService.addCart_detail(cd);
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				try
				{
					response.getWriter().print(result);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		else//没有餐车记录的时候新建餐车
		{
			Cart ca=new Cart();
			ca.setUser_id(user_id);
			cartService.addcart(ca);
			//添加明细表
			Cart_detail cd=new Cart_detail();
			cd.setCart(cartService.FindByUId(uu));
			cd.setFood(food);
			cd.setFood_number(1);
			cartService.addCart_detail(cd);
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			try
			{
				response.getWriter().print(result);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@RequestMapping("addcart2")
	public void addcart2(HttpServletResponse response,String kouwei,String size,int foodtype_id,int user_id)
	{
		User uu=userService.findByID(user_id);

		Cart cart=cartService.FindByUId(uu);//根据用户ID查询餐车记录
		FoodType foodtype = foodTypeService.FindById(foodtype_id);//火锅锅底
		
		String result=null;
		result="<font color='green'>"+foodtype.getTypeName()+"已加入餐车"+"</font>";
		if(cart!=null&&foodtype!=null)
		{
			cart.setSize(size);
			cart.setKouwei(kouwei);
			if(size.equals("小锅"))
			{
				cart.setFtprice(38.0);
			}
			else if(size.equals("中锅"))
			{
				cart.setFtprice(48.0);
			}
			else if(size.equals("大锅"))
			{
				cart.setFtprice(58.0);
			}
			if (cart.getFoodtype()!=null&&cart.getFoodtype().getId()==foodtype.getId())//说明已经添加了
			{
				cartService.updateCart(cart);
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				try
				{
					response.getWriter().print(result);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				cart.setFoodtype(foodtype);
				
				cartService.updateCart(cart);
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				try
				{
					response.getWriter().print(result);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else//没有这个餐车
		{
			Cart ca=new Cart();
			ca.setUser_id(user_id);
			ca.setFoodtype(foodtype);
			ca.setSize(size);
			ca.setKouwei(kouwei);
			if(size.equals("小锅"))
			{
				ca.setFtprice(38.0);
			}
			else if(size.equals("中锅"))
			{
				ca.setFtprice(48.0);
			}
			else if(size.equals("大锅"))
			{
				ca.setFtprice(58.0);
			}
			
			cartService.addcart(ca);
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			try
			{
				response.getWriter().print(result);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	/**
	 * 跳转到餐车清单页面
	 */
	@RequestMapping("/clientCart")
	public  ModelAndView clientCart(Model mav,int user_id)
	{
		User uu=userService.findByID(user_id);
		//查询到相应的餐车
		Cart cart=cartService.FindByUId(uu);
		//获取相应的foods
		Map<String,Object> dataMap=new HashMap<String,Object>();
		//总价
		Double totalprice=0.0;
		//这个人有餐车时
		if(cart!=null&&cartService.selectByCart_id(cart)!=null)
		{
			//查询他的明细表
			List<Cart_detail> cds = cartService.selectByCart_id(cart);
			dataMap.put("mingxi", cds);
			//计算出小计与总价
			for(Cart_detail cd:cds)
			{
				cd.setXiaoji(cd.getFood_number()*cd.getFood().getPrice());
				cartService.updateCart_detail(cd);
				totalprice=totalprice+cd.getXiaoji();	
			}
			totalprice=totalprice+cart.getFtprice();
			dataMap.put("totalprice", totalprice);
			
			//存入火锅种类信息,餐车信息
			dataMap.put("cart", cart);
			
			return new ModelAndView("/app/clientCart.jsp",dataMap);
		}
		mav.addAttribute("msg", "餐车里什么还没有菜品！请添加菜品！");
		Pagebean<FoodType> pagebean=foodTypeService.findByPage(1, 0);
		mav.addAttribute("foty", pagebean);
		return new ModelAndView("/app/guodicaidan.jsp");
		
		
		
	}
	
	/**
	 * 删除购物车里的菜品
	 */
	@RequestMapping("/deleteCart")
	public String deleteCart(Model mav,int food_id,int user_id)
	{
		
		User uu=userService.findByID(user_id);//当前用户
		Cart cart=cartService.FindByUId(uu);//用户对应的餐车
		Food food=foodService.FindById(food_id);
		//删除明细表
		Cart_detail cd = cartService.findByFd_ID(food);
		if(cd!=null)
		{
			cartService.deleteCart_detail(cd);
		}
		cart.setFoodtype(null);
		cartService.updateCart(cart);
		return "/cart/clientCart.do?user_id="+user_id;
			
		
		
	}
	
	/**
	 * 购物车改变数量
	 */
	@RequestMapping("/changeCount")
	public ModelAndView changeCount(Integer cd_id,Integer user_id,Integer num)
	{
		//获取此用户
		User uu=userService.findByID(user_id);
		//获取其餐车
		Cart cart=cartService.FindByUId(uu);
		
		//获取餐车明细表
		Cart_detail cd=cartService.fidByCd_id(cd_id);
		cd.setFood_number(num);
		cartService.updateCart_detail(cd);
		//往map里边存数据
		Map<String,Object> dataMap=new HashMap<String,Object>();
		List<Cart_detail> cds = cartService.selectByCart_id(cart);
		dataMap.put("mingxi", cds);
		Double totalprice =0.0;
		for(Cart_detail cda:cds)
		{
			cda.setXiaoji(cda.getFood_number()*cda.getFood().getPrice());
			cartService.updateCart_detail(cd);
			totalprice=totalprice+cda.getXiaoji();	
		}
		totalprice=totalprice+cart.getFtprice();
		dataMap.put("totalprice", totalprice);
		//存入火锅种类信息
		dataMap.put("cart", cart);
		return new ModelAndView("/app/clientCart.jsp",dataMap);
	}
	
	
	
}
