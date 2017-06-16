package cn.zt.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 餐车实体类
 * */
public class Cart 
{
	private int id;//主键
	private Set<Cart_detail> cart_details=new HashSet<>();
	private Integer user_id;//对应谁的餐车
	private FoodType foodtype;//多对一
	private Double ftprice=0.0;
	private String size;//火锅大小中锅
	private String kouwei;//火锅清淡，麻辣//。。。
	
	
	
	public String getSize()
	{
		return size;
	}
	public void setSize(String size)
	{
		this.size = size;
	}
	public String getKouwei()
	{
		return kouwei;
	}
	public void setKouwei(String kouwei)
	{
		this.kouwei = kouwei;
	}
	public Double getFtprice()
	{
		return ftprice;
	}
	public void setFtprice(Double ftprice)
	{
		this.ftprice = ftprice;
	}
	public FoodType getFoodtype()
	{
		return foodtype;
	}
	public void setFoodtype(FoodType foodtype)
	{
		this.foodtype = foodtype;
	}
	public Set<Cart_detail> getCart_details()
	{
		return cart_details;
	}
	public void setCart_details(Set<Cart_detail> cart_details)
	{
		this.cart_details = cart_details;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public Integer getUser_id()
	{
		return user_id;
	}
	public void setUser_id(Integer user_id)
	{
		this.user_id = user_id;
	}
	

	
}
