package cn.zt.dao;

import java.util.List;

import cn.zt.domain.Food;
import cn.zt.domain.FoodType;

public interface FoodTypeDao
{
	//添加火锅种类
	public void addtype(FoodType ftype);

	//查询所有的火锅种类
	public List<FoodType> findall();
	
	//更新火锅的种类信息
	public void updateftype(FoodType ftype);
	
	//删除火锅种类
	public void deleteftype(FoodType ftype);

	//根据ID查询到火锅种类
	public FoodType FindById(int id);

	/**
	 * 查询种类所有数
	 * @return
	 */
	public int Typefindcount();
	/**
	 * 分页查询
	 * @param begin
	 * @param pagesize
	 * @return
	 */
	public List<FoodType> typefindBypage(int begin, int pagesize);

}
