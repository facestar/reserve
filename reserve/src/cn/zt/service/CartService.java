package cn.zt.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zt.dao.CartDao;
import cn.zt.domain.Cart;
import cn.zt.domain.Cart_detail;
import cn.zt.domain.Food;
import cn.zt.domain.User;

/**
 * 餐车业务逻辑层
 * @author Administrator
 *
 */
@Service("cartService")
public class CartService
{
	/**
	 * 注入dao层
	 */
	@Resource(name="cartDao")
	private CartDao cartDao;
	
	/**
	 * 餐车添加记录
	 */
	public void addcart(Cart cart)
	{
		cartDao.addcart(cart);
	}
	/**
	 * 根据用户ID查询记录
	 */
	public Cart FindByUId(User uu)
	{
		return cartDao.FindByUId(uu);
	}
	/**
	 * 更新餐车信息
	 */
	public void updateCart(Cart cart)
	{
		cartDao.updateCart(cart);
	}
	/**
	 * 更新餐车信息2
	 */
	public void updateCart2(Cart cart,Food food)
	{
		cartDao.updateCart2(cart,food);
	}
	/**
	 * 根据餐车id查询所有餐车明细记录
	 */
	public List<Cart_detail> selectByCart_id(Cart cart)
	{
		return cartDao.selectByCart_id(cart);
	}
	/**
	 * 添加明细表
	 */
	public void addCart_detail(Cart_detail cd)
	{
		cartDao.addCart_detail(cd);
	}
	
	/**
	 * 更新明细表数据
	 */
	public void updateCart_detail(Cart_detail cd)
	{
		cartDao.updateCart_detail(cd);
	}
	/**
	 * 根据菜品ID查询明细记录
	 */
	public Cart_detail findByFd_ID(Food food)
	{
		return cartDao.findByFd_ID(food);
	}
	/**
	 * 根据明细ID查询出记录
	 */
	public Cart_detail fidByCd_id(int id)
	{
		return cartDao.findByCd_id(id);
	}
	/**
	 * 删除明细记录
	 */
	public void deleteCart_detail(Cart_detail cd)
	{
		cartDao.deleteCart_detail(cd);
	}

}
