package cn.zt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cn.zt.dao.BasicDao;
import cn.zt.dao.FoodTypeDao;
import cn.zt.domain.Food;
import cn.zt.domain.FoodType;

@Repository("FoodTypeDao")
public class FoodTypeDaoImpl implements FoodTypeDao
{
	@Resource(name="basicdao")
	private BasicDao bs;
	
	//添加火锅种类
	public void addtype(FoodType ftype)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.save(ftype);
		tr.commit();
		session.close();
	}

	

	//查询所有的火锅种类
	public List<FoodType> findall()
	{
		Session session=bs.openSession();
		Query query=session.createQuery("from FoodType");
		List<FoodType> li=query.list();
		session.close();
		return li;
	}
	
	//更新火锅的种类
	public void updateftype(FoodType ftype)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.update(ftype);
		tr.commit();
		session.close();
	}
	
	//删除火锅种类
	public void deleteftype(FoodType ftype)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(ftype);
		tr.commit();
		session.close();
	}



	//根据ID查询到火锅种类
	public FoodType FindById(int id)
	{
		Session session=bs.openSession();
		FoodType th=(FoodType)session.get(FoodType.class, id);
		session.close();
		return th;
	}



	/**
	 * 查询数量
	 */
	public int Typefindcount()
	{
		Session session=bs.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("select count(*) from FoodType");
		
		List<Long> list=query.list();
		transaction.commit();
		if(list.size()>0)
			return list.get(0).intValue();
		return 0;
	}



	/**
	 * 分页数据查询
	 */
	public List<FoodType> typefindBypage(int begin, int pagesize)
	{
		Session session=bs.openSession();
		Query query=session.createQuery(" from FoodType ");
		
		query.setFirstResult(begin);
		query.setMaxResults(pagesize);
		List<FoodType> li=query.list();
		
		session.close();
		return li;
	}

}
