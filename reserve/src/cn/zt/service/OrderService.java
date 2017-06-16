package cn.zt.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zt.dao.OrderDao;
import cn.zt.domain.Food;
import cn.zt.domain.Orders;
import cn.zt.domain.Orders_Detail;
/**
 * 餐车业务逻辑层
 * @author Administrator
 *
 */
/**
 * 餐车业务逻辑层
 * @author Administrator
 *
 */
@Service("orderService")
public class OrderService
{
	/**
	 * 注入Dao层
	 */
	@Resource(name="ordersDao")
	private OrderDao ordersDao;
	
	/**
	 * 添加订单记录
	 */
	public void addorders(Orders order)
	{
		ordersDao.addorder(order);
	}
	/**
	 * 查询到所有的订单记录
	 */
	public List<Orders> Findall()
	{
		return ordersDao.findall();
	}
	/**
	 * 统计所用订单
	 */
	public List<Orders> Findall2()
	{
		return ordersDao.findall2();
	}
	/**
	 * 添加关系记录
	 */
	public void addOrder_food(Orders_Detail or_fd)
	{
		ordersDao.addorders_food(or_fd);
	}
	
	/**
	 * 根据用户ID查询用户订单记录
	 */
	public List<Orders> FindById(int user_id)
	{
		return ordersDao.FindById(user_id);
	}
	/**
	 * 根据订单ID获取订单记录
	 */
	public  Orders FindByOrder_id(int order_id)
	{
		return ordersDao.findByOrder_id(order_id);
	}
	/**
	 * 通过订单编号查到订单
	 */
	public Orders FindByOrder_number(String odt)
	{
		return ordersDao.FindByOrder_number(odt);
	}
	/**
	 * 删除订单
	 * @param order
	 */
	public void deteteOrders(Orders order) {
		ordersDao.deleteorder(order);
	}
	/**
	 * 删除菜品关系记录
	 */
	public void deteteor_Foods(Orders_Detail or_fd)
	{
		ordersDao.deleteor_Foods(or_fd);
	}
	/**
	 * 添加订单明细
	 * @param od
	 */
	public void addOrder_detail(Orders_Detail od)
	{
		ordersDao.addOrder_detail(od);
	}
	/**
	 * 根据订单ID查询详细
	 * @param id
	 * @return
	 */
	public List<Orders_Detail> findByOd_id(int id)
	{
		return ordersDao.selectByOrder_id(id);
	}
	/**
	 * 修改订单状态
	 */
	public void update(Orders order)
	{
		ordersDao.update(order);
	}
	/**
	 * 根据条件查询到记录
	 */
	public List<Orders> findBytiaojian(String tiaojian)
	{
		return ordersDao.findBytiaojian(tiaojian);
	}

}
