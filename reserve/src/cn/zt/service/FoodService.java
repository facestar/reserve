package cn.zt.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zt.dao.FoodDao;
import cn.zt.domain.Food;
import cn.zt.domain.Pagebean;



@Service("FoodService")
public class FoodService
{
	@Resource(name="FoodDao")
	private FoodDao fooddao;
	@Resource(name="pagebean")
	Pagebean<Food> pagebean;
	//添加菜品
	public void addfood(Food food)
	{
		fooddao.addfood(food);
	}
	
	//查询到所有菜品
	public List<Food> findall()
	{
		return fooddao.findall();
	}
	
	
	//删除菜品
	public void deletefood(int id)
	{
		fooddao.deletefood(id);
	}
	
	//根据ID查询菜品
	public Food FindById(int id)
	{
		return fooddao.FindById(id);
	}

	//更新菜品信息
	public void updatefood(Food food)
	{
		fooddao.updatefood(food);
		
	}
	/**
	 * 菜品分页
	 */
	public Pagebean<Food> findByPage(int nowpage,int allpage, String leixing)
    {
    	
		int pagesize=6;
		pagebean.setPagesize(pagesize);//每页显示多少条
		pagebean.setAllcount(fooddao.foodfindcount(leixing));//总记录数
		//设置 总页数
		if(fooddao.foodfindcount(leixing)%pagesize==0)
		{
			pagebean.setAllpage(fooddao.foodfindcount(leixing)/pagesize);//总页数
		}
		else
		{
			pagebean.setAllpage(fooddao.foodfindcount(leixing)/pagesize+1);//总页数
		}
		
		/**
		 * 根据allpage不是尾页nowpage传入的页数保证是正数
		 */
		if(allpage==0&&nowpage>0)//
		{
			//如果nowpage为一就是第一页
			if(nowpage==1)
			{
				int begin=0;
				List<Food> list=fooddao.foodfindBypage(begin, pagesize,leixing);
				pagebean.setList(list);
				pagebean.setNowpage(nowpage);
				return pagebean;
			}
			//如果不为1且小于总页数
			else if(nowpage<=pagebean.getAllpage())
			 {
				 int begin=(nowpage-1)*pagesize;
				List<Food> list=fooddao.foodfindBypage(begin, pagesize,leixing);
				pagebean.setList(list);
				pagebean.setNowpage(nowpage);
				
				return pagebean;
			 }
			//如果大于总页数默认为最大页
			 else
			 {
				 int begin=(pagebean.getAllpage()-1)*pagesize;
				 List<Food> list=fooddao.foodfindBypage(begin, pagesize,leixing);
				 pagebean.setList(list);
				 pagebean.setNowpage(pagebean.getAllpage());
				 pagebean.setAllpage(pagebean.getAllpage());//总页数
				 return pagebean;
			 }
		}		 
				 
		/**
		 * 是尾页
		 */
		else if(allpage==1)
		{
			 int begin=(pagebean.getAllpage()-1)*pagesize;
			 List<Food> list=fooddao.foodfindBypage(begin, pagesize,leixing);
			 pagebean.setList(list);
			 pagebean.setNowpage(pagebean.getAllpage());
			 pagebean.setAllpage(pagebean.getAllpage());//总页数
			 return pagebean;
		}
			
		/**
		 * 如果nowpage小于或等于0则默认第一页
		 */
		else if(nowpage<=0)
		{
			int begin=0;
			List<Food> list=fooddao.foodfindBypage(begin, pagesize,leixing);
			pagebean.setList(list);
			pagebean.setNowpage(1);
			return pagebean;
		}
		//此情况没有
		else
		{
			return pagebean;
		}
		
		
    }

}
