package cn.zt.dao;

import java.util.List;

import cn.zt.domain.Cart;
import cn.zt.domain.Cart_detail;
import cn.zt.domain.Food;
import cn.zt.domain.User;


public interface CartDao
{
	/**
	 * 餐车添加记录
	 */
	public void addcart(Cart cart);
	/**
	 * 根据用户ID查询记录
	 * @param id
	 * @return
	 */
	public Cart FindByUId(User uu);
	/**
	 * 更新餐车信息
	 * @param cart
	 */
	public void updateCart(Cart cart);
	
	public void updateCart2(Cart cart,Food food);
	//查询藏车明细表
	public List<Cart_detail> selectByCart_id(Cart cart);
	//添加明细表
	public void addCart_detail(Cart_detail cd);
	//更新明细表
	public void updateCart_detail(Cart_detail cd);
	//根据菜品ID查询明细记录
	public Cart_detail findByFd_ID(Food food);
	//根据明细ID查询出记录
	public Cart_detail findByCd_id(int id);
	//删除闽西表
	public void deleteCart_detail(Cart_detail cd);

}
