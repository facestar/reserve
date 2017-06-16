package cn.zt.domain;


import java.util.HashSet;
import java.util.Set;

/**
 * 订单实体类
 * @author Administrator
 *
 */
public class Orders
{
	
	private int id;//主键
	private String orderNumber;//订单编号
	private User user;//预定人
	private FoodType foodtype;//火锅种类
	private String riqi;//预定日期
	private String orderstime;//下单时间
	private String size;//火锅大小中锅
	private String kouwei;//火锅清淡，麻辣//。。。
	private String jutishijian;//具体时间
	private String renshu;//赴餐人数
	private String totalprice;//总金额.
	private String status="已预订";//订单状态：已退订，
	private Set<Orders_Detail> orderes_details=new HashSet<>();
	
	
	
	
	public String getRiqi()
	{
		return riqi;
	}
	public void setRiqi(String riqi)
	{
		this.riqi = riqi;
	}
	public String getOrderstime()
	{
		return orderstime;
	}
	public void setOrderstime(String orderstime)
	{
		this.orderstime = orderstime;
	}
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
	public Set<Orders_Detail> getOrderes_details()
	{
		return orderes_details;
	}
	public void setOrderes_details(Set<Orders_Detail> orderes_details)
	{
		this.orderes_details = orderes_details;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRenshu() {
		return renshu;
	}
	public void setRenshu(String renshu) {
		this.renshu = renshu;
	}
	public String getTotalprice()
	{
		return totalprice;
	}
	public void setTotalprice(String totalprice)
	{
		this.totalprice = totalprice;
	}
	
	public String getJutishijian()
	{
		return jutishijian;
	}
	public void setJutishijian(String jutishijian)
	{
		this.jutishijian = jutishijian;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getOrderNumber()
	{
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}
	
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public FoodType getFoodtype()
	{
		return foodtype;
	}
	
	
	public void setFoodtype(FoodType foodtype)
	{
		this.foodtype = foodtype;
	}
	
	
	
	
	
	

}
