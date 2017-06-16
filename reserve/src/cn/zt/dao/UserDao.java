package cn.zt.dao;

import java.util.List;

import cn.zt.domain.User;
import cn.zt.domain.Cart_detail;

public interface UserDao
{
	//添加用户
	public void adduser(User user);
	
	//查询所有用户
	public List<User> findall();
	
	//更新用户信息
	public void updateuser(User user);

	//删除用户
	public void deleteuser(User user);

	//根据ID查询
	public User findByID(int id);

	//根据电话查询
	public User findByPhone(String phone);

	//用户登录
	public User longin(User user);

	//添加用菜品关系记录
	public void addUser_food(Cart_detail user_food);
	
	//更新用菜品关系记录
	public void updateUser_food(Cart_detail user_food);

	//根据用户ID和菜品ID查询出关系记录
	public Cart_detail findByUidfid(int uid,int fid);

	//删除用户菜品关系记录
	public void deleteUser_food(Cart_detail user_food);
}
