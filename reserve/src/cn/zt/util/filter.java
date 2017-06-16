package cn.zt.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class filter implements Filter
{

	//销毁
	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}

	//过滤方法
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		// 对request和response进行一些预处理
		
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		System.out.println("FilterDemo执行前！");
		Object obj = ((HttpServletRequest) request).getSession().getAttribute("us");
		if(obj==null)
		{
			request.setAttribute("msg", "登录信息已过期，请重新登录！");
			 request.getRequestDispatcher("/app/login.jsp").forward(request,response);
		}
		else
		{
			chain.doFilter(req, resp);//让目标资源执行，放过
		}
		
		 
		
	}

	//初始化方法
	public void init(FilterConfig arg0) throws ServletException
	{
		System.out.println("初始化过滤器");
		
	}

	
	
}
