package cn.zt.domain;

import java.util.HashSet;
import java.util.Set;

/*火锅种类实体类
 * 
 * */
public class FoodType
{
	private int id;//-- 类别主键
	private String typeName;// -- 类别名称
	private String picture;//火锅图片
	
	private Set<Orders> orders=new HashSet<Orders>();//对应多个订单
	
	private Set<Cart> carts=new HashSet<>();
	
	
	
	
	
	public Set<Cart> getCarts()
	{
		return carts;
	}
	public void setCarts(Set<Cart> carts)
	{
		this.carts = carts;
	}
	
	public Set<Orders> getOrders()
	{
		return orders;
	}
	public void setOrders(Set<Orders> orders)
	{
		this.orders = orders;
	}
	public String getPicture()
	{
		return picture;
	}
	public void setPicture(String picture)
	{
		this.picture = picture;
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTypeName()
	{
		return typeName;
	}
	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}
	
	
}
