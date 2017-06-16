<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/app/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/app/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app/style/css/index_1.css" />
	<style type="text/css">
	* {
		margin: 0px;
		padding: 0px
	}
	#dish_2 a{
		text-decoration:none;
		font-size:36px;
		color:#000;
	}
	#dish_2 ul { 
		list-style:none;
	} 
	#dish_2 li{
		background:url(style/images/img/btn.gif);
		width:164px;
		height:47px;
		text-align:center;
		padding-top:5px;
	}
	</style>
</head>
<body style="text-align: center">
	<!--外部的大层-->
	<div class="index_all" style="text-align:center;">
		<!--上面的背景层-->
		<div>
			<img src="${pageContext.request.contextPath }/app/style/images/flower.gif" />
		</div>
		<!--中间层-->
		<div id="index_center">
			<!--中间层的空白层-->
			<div id="space">
				
			</div>
			<!--中间层的菜单层-->
			<div>
				<!--菜单层的左边-->
				<div id="index_centerleft"></div>
				<!--菜单层的中间-->
				<div class="bg_middle">
				<% 
							java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd ");
							
							java.util.Date currentTime = new java.util.Date();//得到当前系统时间
							
							String str_date1 = formatter.format(currentTime); //将日期时间格式化 
							String str_date2 = currentTime.toString(); //将Date型日期时间转换成字符串形式 
							
						%>
					<div style="width:100%;float: left;height: 200px;padding-left: 10px;padding-right: 20px;">
						<div style="border: 2px solid red;width: 155px;height: 50px;float: left;">
							<a style="font-size: 22px;background-color: #fe02fd;">2017-03-31(今天)</a>
						</div>
						<div style="border: 2px solid red;width: 155px;height: 50px;float: left;">
							<a style="font-size: 22px;background-color: red;">2017-04-01(明天)</a>
						</div >
						<div style="border: 2px solid red;width: 155px;height: 50px;float: left;">
							<a style="font-size: 22px;background-color: #eaeaea;">2017-03-02(后天)</a>
						</div>
						<div style="border: 2px solid red;width: 155px;height: 50px;float: left;">
							<a style="font-size: 22px;background-color: #ff6704;">2017-03-03</a>
						</div>
						<div style="border: 2px solid red;width: 155px;height: 50px;float: left;">
							<a style="font-size: 22px;background-color: #3fb121">2017-03-04</a>
						</div>
					</div>
					<!--放桌子的层-->
					<div id="center_bottom">
						<ul style=" display:inline-table">
							<c:forEach var="dt" items="${requestScope.listDinnerTable}">
								<li >
									<a href="${pageContext.request.contextPath }/table/toCaidaoUI.do?dt_id=${dt.id}">
										${dt.tableName }
									</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<!--中间层的右边-->
				<div id="index_centerright"></div>
			</div>

			
		</div>
		
		<!--下面的背景层-->
		<div>
			<img src="${pageContext.request.contextPath }/app/style/images/flower.gif" />
		</div>
	</div>
</body>
</html>