package cn.zt.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zt.dao.UserDao;
import cn.zt.domain.User;
import cn.zt.domain.Cart_detail;

@Service("UserService")
public class UserService
{
	@Resource(name="UserDao")
	private UserDao userdao;
	
	//添加用户
	public void adduser(User user)
	{
		userdao.adduser(user);
	}
	
	//查询所有用户
	public List<User> finall()
	{
		return userdao.findall();
	}
	
	//更新用户信息
	public void updateuser(User user)
	{
		userdao.updateuser(user);
	}
	
	//删除用户
	public void deleteuser(User user)
	{
		userdao.deleteuser(user);
	}
	
	//根据id查询用户信息
	public User findByID(int id)
	{
		return userdao.findByID(id);
	}
	
	//根据用户的手机号查询
	public User findByPhone(String phone)
	{
		return userdao.findByPhone( phone);
	}
	
	//用户登录
	public User longin(User user)
	{
		return userdao.longin(user);
	}
	
	//添加用菜品关系记录
	public void addUser_food(Cart_detail user_food)
	{
		userdao.addUser_food(user_food);
	}
	
	//更新用菜品关系记录
	public void updateUser_food(Cart_detail user_food)
	{
		userdao.updateUser_food(user_food);
	}
	
	//根据用户ID和菜品ID查询出关系记录
	public Cart_detail findByUidfid(int uid,int fid)
	{
		return userdao.findByUidfid(uid, fid);
	}
	
	//删除用菜品关系记录
	public void deleteUser_food(Cart_detail user_food)
	{
		userdao.deleteUser_food(user_food);
	}

}
