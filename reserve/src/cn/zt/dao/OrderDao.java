package cn.zt.dao;

import java.util.List;

import cn.zt.domain.Food;
import cn.zt.domain.Orders;
import cn.zt.domain.Orders_Detail;

public interface OrderDao
{
	/**
	 * 添加订单记录
	 * @param order
	 */
	public void addorder(Orders order);

	/**
	 * 查询到所有订单记录
	 * @return
	 */
	public List<Orders> findall();

	/**
	 * 添加关系记录
	 * @param or_fd
	 */
	public void addorders_food(Orders_Detail or_fd);

	/**
	 * 根据ID查询订单记录
	 * @param user_id
	 * @return
	 */
	public List<Orders> FindById(int user_id);

	/**
	 * 根据订单ID查询记录
	 * @param order_id
	 * @return
	 */
	public Orders findByOrder_id(int order_id);

	/**
	 * 通过订单编号查到相关所有菜品
	 * @param odt
	 * @return
	 */
	public Orders FindByOrder_number(String odt);

	/**
	 * 删除订单
	 * @param order
	 * @return
	 */
	public void deleteorder(Orders order);

	/**
	 * 删除菜品关系记录
	 */
	public void deleteor_Foods(Orders_Detail or_fd);

	//添加订单明细
	public void addOrder_detail(Orders_Detail od);
	//根据订单ID查询明细
	public List<Orders_Detail> selectByOrder_id(int id);

	/**
	 * 修改订单状态
	 */
	public void update(Orders order);
	/**
	 * 统计所用订单
	 */
	public List<Orders> findall2();
	/**
	 * 根据条件查询
	 */

	public List<Orders> findBytiaojian(String tiaojian);

}
