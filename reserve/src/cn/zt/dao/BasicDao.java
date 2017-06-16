package cn.zt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("basicdao")
public class BasicDao
{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	public Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	public Session openSession()
	{
		return sessionFactory.openSession();
	}
	
	

}
