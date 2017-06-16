package cn.zt.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cn.zt.dao.BasicDao;
import cn.zt.dao.UserDao;
import cn.zt.domain.User;
import cn.zt.domain.Cart_detail;
@Repository("UserDao")
public class UserDaoImpl implements UserDao
{
	@Resource(name="basicdao")
	private BasicDao bs;

	//添加用户
	public void adduser(User user)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.save(user);
		tr.commit();
		session.close();

	}
	
	//查询所有用户
	public List<User> findall()
	{
		Session session=bs.openSession();
		Query query=session.createQuery("from User");
		List<User> li=query.list();
		session.close();
		return li;
	}

	//更新用户信息
	public void updateuser(User user)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.update(user);
		tr.commit();
		session.close();
		
	}

	//删除用户
	public void deleteuser(User user)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(user);
		tr.commit();
		session.close();
		
	}

	//根据ID查询用户信息
	public User findByID(int id)
	{
		Session session=bs.openSession();
		Query query=session.createQuery("from User where id=?");
		query.setParameter(0, id);
		User uu=(User) query.uniqueResult();
		session.close();
		return uu;
	}

	//根据电话查询记录
	public User findByPhone(String phone)
	{
		Session session=bs.openSession();
		Query query=session.createQuery("from User where phone=?");
		query.setParameter(0, phone);
		User uu=(User) query.uniqueResult();
		session.close();
		return uu;
	}

	//用户登录
	public User longin(User user)
	{
		Session session=bs.openSession();
		Query query=session.createQuery("from User where phone=? and password=?");
		query.setParameter(0, user.getPhone());
		query.setParameter(1, user.getPassword());
		List<User> li=query.list();
		if(li.size()>0)
		{
			User uu=li.get(0);
			session.close();
			return uu;
		}
		session.close();
		return null;
	}

	//添加用菜品关系记录
	public void addUser_food(Cart_detail user_food)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.save(user_food);
		tr.commit();
		session.close();
	}

	//更新用菜品关系记录
	public void updateUser_food(Cart_detail user_food)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.update(user_food);
		tr.commit();
		session.close();
	}
	
	//根据用户ID和菜品ID查询出关系记录
	public Cart_detail findByUidfid(int uid,int fid)
	{
		Session session=bs.openSession();
		Query query=session.createQuery("from User_food where user_id=? and food_id=?");
		query.setParameter(0, uid);
		query.setParameter(1, fid);
		if(query.list().size()>0)
		{
			Cart_detail uu=(Cart_detail) query.uniqueResult();
			session.close();
			return uu;
		}
		else
		{
			session.close();
			return null;
		}
	}

	//删除用户菜品关系记录
	public void deleteUser_food(Cart_detail user_food)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(user_food);
		tr.commit();
		session.close();
		
	}

}
