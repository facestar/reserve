package cn.zt.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cn.zt.dao.BasicDao;
import cn.zt.dao.CartDao;
import cn.zt.domain.Cart;
import cn.zt.domain.Cart_detail;
import cn.zt.domain.Food;
import cn.zt.domain.User;
@Repository("cartDao")
public class CartDaoImpl implements CartDao
{

	@Resource(name="basicdao")
	private BasicDao bs;

	/**
	 * 餐车添加记录
	 */
	public void addcart(Cart cart)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.save(cart);
		tr.commit();
		session.close();
	}
	/**
	 * 根据用户ID查询记录
	 */
	public Cart FindByUId(User uu)
	{
		Session session=bs.openSession();
		Query query=session.createQuery("from Cart where user_id=?");
		query.setParameter(0, uu.getId());
		if(query.list().size()>0)
		{
			Cart cart=(Cart) query.list().get(0);
			session.close();
			return cart;
		}
		session.close();
		return null;
			
	}
	/**
	 * 更新餐车信息
	 * @param cart
	 */
	public void updateCart(Cart cart)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.update(cart);
		tr.commit();
		session.close();
		
	}
	//更新餐车2
	public void updateCart2(Cart cart,Food food)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		
	}
	/**
	 * 查询餐车明细表
	 */
	public List<Cart_detail> selectByCart_id(Cart cart)
	{
		Session session=bs.openSession();
		Query query=session.createQuery("from Cart_detail where cart_id=?");
		query.setParameter(0, cart.getId());
		if(query.list().size()>0)
		{
			List<Cart_detail> cartli= query.list();
			session.close();
			return cartli;
		}
		session.close();
		return null;
		
	}
	/**
	 * 添加明细表
	 */
	public void addCart_detail(Cart_detail cd)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.save(cd);
		tr.commit();
		session.close();
		
	}
	/**
	 * 更新明细表
	 */
	public void updateCart_detail(Cart_detail cd)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		
		session.update(cd);
		tr.commit();
		session.close();
		
	}
	/**
	 * 根据菜品ID查询明细记录
	 */
	public Cart_detail findByFd_ID(Food food)
	{
		Session session=bs.openSession();
		Query query=session.createQuery("from Cart_detail where food_id=?");
		query.setParameter(0, food.getId());
		if(query.list().size()>0)
		{
			Cart_detail cartli= (Cart_detail) query.uniqueResult();
			session.close();
			return  cartli;
		}
		session.close();
		return null;
	}
	/**
	 * 根据明细ID查询出记录
	 */
	public Cart_detail findByCd_id(int id)
	{
		Session session=bs.openSession();
		Query query=session.createQuery("from Cart_detail where id=?");
		query.setParameter(0, id);
		if(query.list().size()>0)
		{
			Cart_detail cart=(Cart_detail) query.list().get(0);
			session.close();
			return cart;
		}
		session.close();
		return null;
	}
	/**
	 * 删除明细表
	 */
	public void deleteCart_detail(Cart_detail cd)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(cd);
		tr.commit();
		session.close();
		
	}
		
}
