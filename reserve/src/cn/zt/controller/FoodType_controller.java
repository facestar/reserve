package cn.zt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zt.domain.Food;
import cn.zt.domain.FoodType;
import cn.zt.domain.Pagebean;
import cn.zt.service.FoodService;
import cn.zt.service.FoodTypeService;

@Controller
@RequestMapping("/foodtype")
public class FoodType_controller
{
	//注入service层
	@Resource(name="FoodTypeService")
	private FoodTypeService foodTypeService;
	@Resource(name="FoodService")
	private FoodService foodService;
	/**添加火锅种类
	 * 
	 * @param ftype
	 * @return
	 */
	@RequestMapping("/addftype")
	public String addftype(FoodType ftype)
	{
		foodTypeService.addftype(ftype);
		
		return "/foodtype/findalltype.do";
	}
	
	//查询到所有的火锅种类
	@RequestMapping("/findalltype")
	public String findallftype(Model mav)
	{
		List<FoodType> li=foodTypeService.fintype();
		mav.addAttribute("ftype", li);
		return "/sys/cuisineList.jsp";
	}
	
	//更新火锅种类
	@RequestMapping("/update")
	public String updateftype(Model mav,FoodType ftype)
	{
		foodTypeService.updateftype(ftype);
		return "/foodtype/findalltype.do";
	}
	
	//删除火锅种类
	@RequestMapping("/delete")
	public String deleteftype(int id)
	{
		FoodType ftype=foodTypeService.FindById(id);
		foodTypeService.deleteftype(ftype);
		return "/foodtype/findalltype.do";
	}
	
	//跳转到种类更新页面
	@RequestMapping("/tiaoUpdate")
	public String taiouupdate(Model mav,int id)
	{
		mav.addAttribute("fty", foodTypeService.FindById(id));
		return "/sys/updateCuisine.jsp";
	}
	
	
	
	
	//返回种类界面
	@RequestMapping("/tiaofoodtype")
	public String tiaofoodtype(Model mav)
	{
		Pagebean<FoodType> pagebean=foodTypeService.findByPage(1, 0);
		mav.addAttribute("foty", pagebean);
		return "/app/guodicaidan.jsp";
	}
	
	/**
	 * 分页
	 */
	@RequestMapping("/fenye")
	public String fenye(int nowpage,int allpage,Model mav)
	{
		Pagebean<FoodType> pagebean=foodTypeService.findByPage(nowpage, allpage);
		mav.addAttribute("foty", pagebean);
		return "/app/guodicaidan.jsp";
	}

}
