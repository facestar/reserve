package cn.zt.domain;
/**
 * 餐车明细表
 * @author Administrator
 *
 */
public class Cart_detail
{
	private Integer id;//主键
	private Cart cart;//对应的餐车
	private Food food;//菜品的名称
	private Integer food_number;//菜品的数量
	private Double xiaoji;//小计
	
	
	
	
	
	public Double getXiaoji()
	{
		return xiaoji;
	}
	public void setXiaoji(Double xiaoji)
	{
		this.xiaoji = xiaoji;
	}
	public Food getFood()
	{
		return food;
	}
	public void setFood(Food food)
	{
		this.food = food;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	
	
	public Cart getCart()
	{
		return cart;
	}
	public void setCart(Cart cart)
	{
		this.cart = cart;
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
