package cn.zt.domain;

import java.util.Set;

/**用户实体类
 * 
 * */
public class User
{
	/**
	 * 用户表主键
	 */
	private int id;
	/**
	 * 用户的真实姓名
	 */
	private String username;
	/**
	 * 用户的联系电话
	 */
	private String phone;
	/**
	 * 用户的登录密码
	 */
	private String password;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 用户的地址信息
	 */
	private String address;
	/**
	 * 用户和订单确定一对多映射关系
	 */
	private Set<Orders> orders; 
	
	/**
	 * 
	 * 无参构造函数
	 */
	public User()
	{
		super();
	}
	
	public Set<Orders> getOrders()
	{
		return orders;
	}
	
	public void setOrders(Set<Orders> orders)
	{
		this.orders = orders;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
}
