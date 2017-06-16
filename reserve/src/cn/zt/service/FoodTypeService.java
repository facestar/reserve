package cn.zt.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zt.dao.FoodTypeDao;
import cn.zt.domain.Food;
import cn.zt.domain.FoodType;
import cn.zt.domain.Pagebean;

@Service("FoodTypeService")
public class FoodTypeService
{
	@Resource(name="FoodTypeDao")
	private FoodTypeDao typedao;
	@Resource(name="pagebean")
	Pagebean<FoodType> pagebean;
	//添加火锅种类
	public void addftype(FoodType ftype)
	{
		typedao.addtype(ftype);
	}
	
	//查询到所有的火锅种类
	public List<FoodType> fintype()
	{
		return typedao.findall();
	}
	
	//更新火锅的种类信息
	public void updateftype(FoodType ftype)
	{
		typedao.updateftype(ftype);
	}
	
	//删除火锅种类
	public void deleteftype(FoodType ftype)
	{
		typedao.deleteftype(ftype);
	}
	
	//根据ID查询到火锅种类
	public FoodType FindById(int id)
	{
		return typedao.FindById(id);
	}
	/**
	 * 火锅种类分页
	 * @param nowpage
	 * @param allpage
	 * @return
	 */
	public Pagebean<FoodType> findByPage(int nowpage, int allpage)
	{
		int pagesize=6;
		pagebean.setPagesize(pagesize);//每页显示多少条
		pagebean.setAllcount(typedao.Typefindcount());//总记录数
		//设置 总页数
		if(typedao.Typefindcount()%pagesize==0)
		{
			pagebean.setAllpage(typedao.Typefindcount()/pagesize);//总页数
		}
		else
		{
			pagebean.setAllpage(typedao.Typefindcount()/pagesize+1);//总页数
		}
		
		/**
		 * 根据allpage不是尾页nowpage传入的页数保证是正数
		 */
		if(allpage==0&&nowpage>0)//
		{
			//如果nowpage为一就是第一页
			if(nowpage==1)
			{
				int begin=0;
				List<FoodType> list=typedao.typefindBypage(begin, pagesize);
				pagebean.setList(list);
				pagebean.setNowpage(nowpage);
				return pagebean;
			}
			//如果不为1且小于总页数
			else if(nowpage<=pagebean.getAllpage())
			 {
				 int begin=(nowpage-1)*pagesize;
				List<FoodType> list=typedao.typefindBypage(begin, pagesize);
				pagebean.setList(list);
				pagebean.setNowpage(nowpage);
				
				return pagebean;
			 }
			//如果大于总页数默认为最大页
			 else
			 {
				 int begin=(pagebean.getAllpage()-1)*pagesize;
				 List<FoodType> list=typedao.typefindBypage(begin, pagesize);
				 pagebean.setList(list);
				 pagebean.setNowpage(pagebean.getAllpage());
				 pagebean.setAllpage(pagebean.getAllpage());//总页数
				 return pagebean;
			 }
		}		 
				 
		/**
		 * 是尾页
		 */
		else if(allpage==1)
		{
			 int begin=(pagebean.getAllpage()-1)*pagesize;
			 List<FoodType> list=typedao.typefindBypage(begin, pagesize);
			 pagebean.setList(list);
			 pagebean.setNowpage(pagebean.getAllpage());
			 pagebean.setAllpage(pagebean.getAllpage());//总页数
			 return pagebean;
		}
			
		/**
		 * 如果nowpage小于或等于0则默认第一页
		 */
		else if(nowpage<=0)
		{
			int begin=0;
			List<FoodType> list=typedao.typefindBypage(begin, pagesize);
			pagebean.setList(list);
			pagebean.setNowpage(1);
			return pagebean;
		}
		//此情况没有
		else
		{
			return pagebean;
		}
	}

}
