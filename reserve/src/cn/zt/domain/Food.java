package cn.zt.domain;

import java.util.HashSet;
import java.util.Set;

/**火锅荤菜实体类
 * 
 * */
public class Food
{
	private int id;//主键
	private String foodName;// VARCHAR(20), -- 菜名称
	private double price;// DOUBLE, -- 价格
	private String introduce;// VARCHAR(200), -- 简介
	private String img;// VARCHAR(100) -- 图片
	
	private Set<Cart_detail> cds=new HashSet<Cart_detail>();//对应的餐车
	private Set<Orders_Detail> ods=new HashSet<Orders_Detail>();
	private String leixing;//素菜，荤菜类型
	
	
	public Set<Orders_Detail> getOds()
	{
		return ods;
	}
	public void setOds(Set<Orders_Detail> ods)
	{
		this.ods = ods;
	}
	public String getLeixing()
	{
		return leixing;
	}
	public void setLeixing(String leixing)
	{
		this.leixing = leixing;
	}
	
	
	
	public Set<Cart_detail> getCds()
	{
		return cds;
	}
	public void setCds(Set<Cart_detail> cds)
	{
		this.cds = cds;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getFoodName()
	{
		return foodName;
	}
	public void setFoodName(String foodName)
	{
		this.foodName = foodName;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public String getIntroduce()
	{
		return introduce;
	}
	public void setIntroduce(String introduce)
	{
		this.introduce = introduce;
	}
	public String getImg()
	{
		return img;
	}
	public void setImg(String img)
	{
		this.img = img;
	}
	
	
}
