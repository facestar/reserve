package cn.zt.controller;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.input.DataFormat;

import javax.annotation.Resource;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zt.domain.Cart;
import cn.zt.domain.Cart_detail;
import cn.zt.domain.Food;
import cn.zt.domain.FoodType;
import cn.zt.domain.Orders;
import cn.zt.domain.Orders_Detail;
import cn.zt.domain.User;
import cn.zt.service.CartService;
import cn.zt.service.FoodService;
import cn.zt.service.FoodTypeService;
import cn.zt.service.OrderService;
import cn.zt.service.UserService;

/**
 * 订单控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/orders")
public class Orders_controller
{
	/**
	 * 注入service层
	 */
	@Resource(name="orderService")
	private OrderService orderService;
	@Resource(name="cartService")
	private CartService cartService;
	@Resource(name="FoodService")
	private FoodService foodService;
	@Resource(name="UserService")
	private UserService userService;
	@Resource(name="FoodTypeService")
	private FoodTypeService foodTypeService;
	/**
	 * 订单添加
	 * @throws ParseException 
	 */
	@RequestMapping("/addOrders")
	public String addorders(Integer user_id,Integer foodtype_id,String riqia,Model mav,Orders order) throws ParseException
	{
		/*String renshu,
		String jutishijian,	String totalprice,String kouwei,String size
		,String ordertime*/
		//获取预定人信息
		User user=userService.findByID(user_id);
		//获取火锅种类信息
		FoodType foodtype=foodTypeService.FindById(foodtype_id);
		
		//生成订单
		DateFormat dateFormat=DateFormat.getDateInstance();
		Date today=dateFormat.parse(riqia);
		String dier=dateFormat.format(today);
		order.setFoodtype(foodtype);
		order.setUser(user);
		order.setRiqi(dier);
		int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
		int r2=(int)(Math.random()*(10));
		long now = System.currentTimeMillis();//一个13位的时间戳
		String paymentID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
		order.setOrderNumber(paymentID);
		order.setOrderstime(""+new Timestamp(new Date().getTime()));
		orderService.addorders(order);
				
		//根据用户获取到cart，再获取掉cd
		Cart cart = cartService.FindByUId(user);
		List<Cart_detail> cds = cartService.selectByCart_id(cart);
		List<Integer> cdids=new ArrayList<>();
		List<Integer> fdids=new ArrayList<>();
		for(Cart_detail cd:cds)
		{
			cdids.add(cd.getId());
			fdids.add(cd.getFood().getId());
		}
		//删除cd,添加order——details
		for(int i=0;i<fdids.size();i++)
		{
			for(int j=0;j<cdids.size();j++)
			{
				//添加
				Cart_detail cd = cartService.fidByCd_id(cdids.get(j));
				Food fd = foodService.FindById(fdids.get(i));
				if(cd!=null&&fd!=null)
				{
					Orders_Detail od=new Orders_Detail();
					od.setFood(fd);
					od.setFood_number(cd.getFood_number());
					od.setOder(orderService.FindByOrder_number(paymentID));
					od.setXiaoji(cd.getXiaoji());
					orderService.addOrder_detail(od);
					//删除
					cartService.deleteCart_detail(cd);
				}
				else
				{
					break;
				}
			}
		}
		
		
		mav.addAttribute("msg", "下单成功!");
		return "/orders/orderList2.do?user_id="+user_id;
	}
	
	/**
	 * 后台显示订单列表
	 */
	@RequestMapping("/orderList")
	public String orderList(Model mav)
	{
		
		mav.addAttribute("orderlist",orderService.Findall());
		return "/sys/orderList.jsp";
	}
	/**
	 * 前台查看订单列表
	 */
	@RequestMapping("/orderList2")
	public String orderList2(Model mav,Integer user_id)
	{
		//获取所有订单信息，修改订单信息
		List<Orders> oderlist = orderService.FindById(user_id);
		
		
		mav.addAttribute("orderlist",oderlist);
		return "/app/orderl.jsp";
	}
	/**
	 * 前台查看订单详细
	 */
	@RequestMapping("/orderDetail")
	public String orderDetail(Model mav,Integer order_id)
	{
		//获取订单
		Orders order=orderService.FindByOrder_id(order_id);
		//获取明细表
		 List<Orders_Detail> li=orderService.findByOd_id(order_id);
		
		mav.addAttribute("foods",li);
		return "/app/orderDetail.jsp";
	}
	/**
	 * 后台页面查看订单详细
	 */
	@RequestMapping("/orderDetail2")
	public String orderDetail2(Model mav,Integer order_id)
	{
		//获取订单
		Orders order=orderService.FindByOrder_id(order_id);
		//获取所有明细
		 List<Orders_Detail> li=orderService.findByOd_id(order_id);
		mav.addAttribute("foods",li);
		return "/sys/orderDetail.jsp";
	}
	/**
	 * 退订，修改订单状态订单
	 */
	@RequestMapping("/deleteOrders")
	public String deleteOrders(Model mav,Integer order_id,Integer user_id)
	{
		//获取订单记录
		Orders order=orderService.FindByOrder_id(order_id);
		
		order.setStatus("已退订");
		orderService.update(order);
		return "/orders/orderList2.do?user_id="+user_id;
	}
	/**
	 *删除订单
	 */
	@RequestMapping("/shanchuOrders")
	public String shanchuorders(Model mav,Integer order_id,Integer user_id)
	{
		//获取订单记录
		Orders order=orderService.FindByOrder_id(order_id);
		
		List<Orders_Detail> od_details = orderService.findByOd_id(order_id);
		Map<Integer,Orders_Detail> map=new HashedMap<Integer, Orders_Detail>();
		List<Integer> ids=new ArrayList<>();
		for(Orders_Detail od:od_details)
		{
			map.put(od.getId(), od);
			ids.add(od.getId());
		}
		for(int i=0;i<ids.size();i++)
		{
			orderService.deteteor_Foods(map.get(ids.get(i)));
		}
		orderService.deteteOrders(order);
		return "/orders/orderList2.do?user_id="+user_id;
	}
	/**
	 * 当日汇总
	 */
	@SuppressWarnings("null")
	@RequestMapping("/dhuiz")
	public String danti(Model mav)
	{
		/**
		 * 今日收入，从orders表找中查取所有记录sum总价
		 */
		Date date=new Date();
		DateFormat dateFormat=DateFormat.getDateInstance();
		String today=dateFormat.format(date);
		List<Orders> orderlist = orderService.findBytiaojian(today);
		Map<String,Object> dataMap=new HashMap<>();
		Double sum =0.0;
		if(orderlist!=null){
			for (Orders od:orderlist)
			{
					sum=sum+Double.parseDouble(od.getTotalprice());
				
			}	}
		//订单总数
		dataMap.put("dzongshu", orderlist==null?0:orderlist.size());
		dataMap.put("shouru", sum);
		
		/**
		 * 菜品统计
		 */
		//获取所有菜品
		List<Orders_Detail> foods=new ArrayList<>();
		Map<Integer,List<Orders_Detail>> cal=new HashMap<>();
		List<Integer> ids=new ArrayList<>();
		for (Orders od:orderlist)
		{
			//此为所有菜品
			List<Orders_Detail> odlist = orderService.findByOd_id(od.getId());
			cal.put(od.getId(), odlist);
			ids.add(od.getId());
		}
		Map<String,Integer> ss=new HashMap<>();
		for (Integer od:ids)
		{
			for(Orders_Detail ods:cal.get(od))
			{
				if(ss.size()>0)
				{
					for(int i=0;i<foods.size();i++)
					{
						Orders_Detail ds=foods.get(i);
						//菜品相同的时候和
						if(ds.getFood().getFoodName().contains(ods.getFood().getFoodName()))
						{
							ds.setFood_number(ds.getFood_number()+ods.getFood_number());
							ds.setXiaoji(ds.getXiaoji()+ods.getXiaoji());
						}
						else if(i<foods.size()-1)
						{
							foods.add(ds);
							break;
						}
					}
				
				}
				else
				{
					foods.add(ods);
					ss.put("d", ods.getId());
				}
				
			}
		}
		dataMap.put("foods", foods);
		dataMap.put("foodsize", foods.size());
		/**
		 * 锅底的次数统计
		 */
		List<Orders> fts=new ArrayList<>();
		Map<String,Integer> ftl=new HashMap<>();
		
		for (Orders od:orderlist)
		{
			//判断它是什么火锅
			if(ftl.size()>0)
			{
				for(Orders ft:fts)
				{
					if(od.getFoodtype().getTypeName().equals(ft.getFoodtype().getTypeName()))
					{
						ft.setRenshu(""+(Integer.parseInt(od.getRenshu())+Integer.parseInt(ft.getRenshu())));
					}
					else
					{
						Orders of=new Orders();
						of.setFoodtype(od.getFoodtype());
						of.setRenshu(""+1);
						of.setSize(od.getSize());
						fts.add(of);
						break;
					}
				}		
			}
			else
			{
				Orders of=new Orders();
				of.setFoodtype(od.getFoodtype());
				of.setRenshu(""+1);
				of.setSize(od.getSize());
				fts.add(of);
				ftl.put("c", od.getId());
			}
				
		}
		for(Orders od:fts)
		{
			if(od.getSize().contains("小锅"))
			{
				od.setTotalprice(Double.parseDouble(od.getRenshu())*38.0+"");
			}
			else if(od.getSize().contains("中锅"))
			{
				od.setTotalprice(Double.parseDouble(od.getRenshu())*48.0+"");
			}
			else if(od.getSize().contains("大锅"))
			{
				od.setTotalprice(Double.parseDouble(od.getRenshu())*58.0+"");
			}
			
		}
		dataMap.put("huoguo", fts);
		dataMap.put("huoguosize", fts.size());
		mav.addAttribute("dataMap", dataMap);
		return "/sys/Summary.jsp";
	}

}
