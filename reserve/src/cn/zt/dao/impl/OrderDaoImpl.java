package cn.zt.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cn.zt.dao.BasicDao;
import cn.zt.dao.OrderDao;
import cn.zt.domain.Orders;
import cn.zt.domain.Orders_Detail;
@Repository("ordersDao")
/**
 * 订单dao层
 * @author Administrator
 *
 */
public class OrderDaoImpl implements OrderDao
{
	@Resource(name="basicdao")
	private BasicDao bs;
	/**
	 * 添加订单记录
	 * 
	 */
	public void addorder(Orders order)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.save(order);
		tr.commit();
		session.close();
	}
	/**
	 * 查询到所有的订单记录
	 */
	public List<Orders> findall()
	{
		Session session=bs.openSession();
		//String st="已预定";
		Query query=session.createQuery(" from Orders as od where od.status='已预订'");
		//query.setParameter(0, st);
		List<Orders> li=query.list();
		session.close();
		return li;
	}
	/**
	 *添加关系记录
	 */
	public void addorders_food(Orders_Detail or_fd)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.save(or_fd);
		tr.commit();
		session.close();
		
	}
	/**
	 * 根据ID查询订单记录
	 */
	public List<Orders> FindById(int user_id)
	{
		Session session=bs.openSession();
		Query query=session.createQuery(" from Orders where user_id=? ");
		query.setParameter(0, user_id);
		List<Orders> li=query.list();
		session.close();
		return li;
	}
	/**
	 * 根据订单ID查询记录
	 */
	public Orders findByOrder_id(int order_id)
	{
		Session session=bs.openSession();
		Query query=session.createQuery(" from Orders where id=?");
		query.setParameter(0, order_id);
		Orders li=(Orders) query.uniqueResult();
		session.close();
		return li;
	}
	/**
	 * 通过订单编号查到订单
	 */
	public Orders FindByOrder_number(String odt)
	{
		Session session=bs.openSession();
		Query query=session.createQuery(" from Orders where orderNumber=?");
		query.setParameter(0, odt);
		Orders li= (Orders) query.uniqueResult();
		session.close();
		return li;
	}
	/**
	 * 删除订单记录
	 */
	public void deleteorder(Orders order) {
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(order);
		tr.commit();
		session.close();
	}
	/**
	 * 删除 菜品订单关系记录
	 */
	public void deleteor_Foods(Orders_Detail or_fd) {
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(or_fd);
		tr.commit();
		session.close();
		
	}
	/**
	 * 添加订单明细
	 */
	public void addOrder_detail(Orders_Detail od)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.save(od);
		tr.commit();
		session.close();
		
	}
	/**
	 * 根据订单ID查询明细
	 */
	public  List<Orders_Detail> selectByOrder_id(int id)
	{
		Session session=bs.openSession();
		Query query=session.createQuery(" from Orders_Detail where order_id=? ");
		query.setParameter(0, id);
		
		if(query.list().size()>0)
		{
			 List<Orders_Detail> li= query.list();
			session.close();
			return li;
		}	
		session.close();
		return null;
	}
	/**
	 * 修改订单状态
	 */
	public void update(Orders order)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.update(order);
		tr.commit();
		session.close();
		
	}
	/**
	 * 查询订单统计
	 */
	public List<Orders> findall2()
	{
		Session session=bs.openSession();
		//String st="已预定";
		Query query=session.createQuery(" from Orders ");
		//query.setParameter(0, st);
		List<Orders> li=query.list();
		session.close();
		return li;
	}
	/**
	 * 根据条件查询
	 */
	public List<Orders> findBytiaojian(String tiaojian)
	{
		Session session=bs.openSession();
		Query query=session.createQuery(" from Orders where riqi=? ");
		query.setParameter(0, tiaojian);
		List<Orders> li=query.list();
		session.close();
		return li;
	}

}