package cn.zt.domain;
/**
 * 订单明细表
 * @author Administrator
 *
 */
public class Orders_Detail
{
	private Integer id;//主键
	private Orders oder;//d对应的订单
	private Food food;//菜品名称
	private Integer food_number;//菜品数量
	private Double xiaoji;//小计
	public Double getXiaoji()
	{
		return xiaoji;
	}
	public void setXiaoji(Double xiaoji)
	{
		this.xiaoji = xiaoji;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	
	
	
	public Orders getOder()
	{
		return oder;
	}
	public void setOder(Orders oder)
	{
		this.oder = oder;
	}
	
	public Food getFood()
	{
		return food;
	}
	public void setFood(Food food)
	{
		this.food = food;
	}
	public Integer getFood_number()
	{
		return food_number;
	}
	public void setFood_number(Integer food_number)
	{
		this.food_number = food_number;
	}
	
	

}
