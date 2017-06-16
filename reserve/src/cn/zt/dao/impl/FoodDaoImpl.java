package cn.zt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cn.zt.dao.BasicDao;
import cn.zt.dao.FoodDao;
import cn.zt.domain.Food;

@Repository("FoodDao")
public class FoodDaoImpl implements FoodDao
{
	@Resource(name="basicdao")
	private BasicDao bs;

	//添加菜品
	public void addfood(Food food)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.save(food);
		tr.commit();
		session.close();
	}

	//查询到所有的菜品
	public List<Food> findall()
	{
		Session session=bs.openSession();
		Query query=session.createQuery("from Food");
		List<Food> li=query.list();
		session.close();
		return li;
	}
	

	//删除菜品
	public void deletefood(int id)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery(" delete from Food where id=?");
		query.setParameter(0, id);
		query.executeUpdate();
		tr.commit();
		session.close();
		
	}

	//根据ID查询出来
	public Food FindById(int id)
	{
		Session session=bs.openSession();
		Query query=session.createQuery("from Food where id=?");
		query.setParameter(0, id);
		Food li=(Food) query.uniqueResult();
		session.close();
		return li;
	}

	//更新菜品信息
	public void updatefood(Food food)
	{
		Session session=bs.openSession();
		Transaction tr=session.beginTransaction();
		session.update(food);
		tr.commit();
		session.close();
		
	}
	/**
	 * 查询菜品总的数量
	 */
	public int foodfindcount(String hql)
	{
		
		Session session=bs.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("select count(*) from Food as fd where fd.leixing=?");
		query.setParameter(0, hql);
		List<Long> list=query.list();
		transaction.commit();
		if(list.size()>0)
			return list.get(0).intValue();
		return 0;
	}

	//分页数据
	public List<Food> foodfindBypage(int begin, int pagesize ,String leixing) {
		// 分页查询
		Session session=bs.openSession();
		Query query=session.createQuery(" from Food as fd where fd.leixing=?");
		query.setParameter(0, leixing);
		query.setFirstResult(begin);
		query.setMaxResults(pagesize);
		List<Food> li=query.list();
		/*List<Food> ly=new ArrayList<>();
		for(Food fd:li)
		{
			if(fd.getLeixing().equals(leixing))
			{
				ly.add(fd);
			}
		}*/
		session.close();
		return li;
	}

}
