package cn.zt.dao;

import java.util.List;

import cn.zt.domain.Food;

public interface FoodDao
{

	//添加新菜品
	public void addfood(Food food);

	//查询到所有的菜品
	public List<Food> findall();
	//删除菜品
	public void deletefood(int id);
	//根据ID查询菜品
	public Food FindById(int id);
	//更新菜品信息
	public void updatefood(Food food);

	//查询到所有的数量
	public int foodfindcount(String hql);

	//分页数据
	public List<Food> foodfindBypage(int begin, int pagesize,String leixing);
}
