package cn.zt.domain;

import java.util.List;

import org.springframework.stereotype.Component;
@Component("pagebean")
public class Pagebean<L>//<L>泛型
{
	private int nowpage;//当前页
	private int pagesize;//每页显示多少记录数(几条记录)
	private int allcount;//数据库中的所有记录数
	private int allpage;//总页数
	private List<L> list;//每页显示的数据
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getAllcount() {
		return allcount;
	}
	public void setAllcount(int allcount) {
		this.allcount = allcount;
	}
	public int getAllpage() {
		return allpage;
	}
	public void setAllpage(int allpage) {
		this.allpage = allpage;
		if(allpage==0)
		{
			allpage=1;
		}
	}
	public List<L> getList() {
		return list;
	}
	public void setList(List<L> list) {
		this.list = list;
	}
}
