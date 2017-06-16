<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="${pageContext.request.contextPath }/app/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/style/js/page_common.js"></script>

<link href="${pageContext.request.contextPath }/app/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app/style/css/index_1.css" />
<link href="${pageContext.request.contextPath }/app/style/css/index1.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/app/style/css/common_style_blue.css" rel="stylesheet" type="text/css">

<link href="${pageContext.request.contextPath }/app/style/css/index.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app/style/css/index_1.css" />

</head>

<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 显示菜品的div -->
			<div style="color:#0E94CF;">亲爱的${us.username}选择一个你喜欢的火锅底料吧！<a style="float: right;width:50px;height: 30px;font-size: 25px;color:green;" href="javascript:history.go(-1);" >返回</a></div>
			
			<div id="top">
				<ul>
					<!-- 循环列出火锅种类 -->
					<c:forEach  items="${foty}" var="fjd">
						<li>
						
							<dl>
								<dt>
									<a >
										<img width="214px" height="145px" src="${fjd.picture }" />
									</a>
								</dt>
								<dd class="f1">
									<a >${fjd.typeName }</a>
								</dd>
								<dd class="f2" style="margin-top: 70px;">
									<a style="font-size: 14;">${fjd.introduce }</a>
								</dd>
							</dl>
						</li>
						</c:forEach>
					
				</ul>
			</div>
			
			
			
		</div>
		
		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
		
			<div id="dish_top">
				<ul>
				<li class="dish_num"></li>
					<li>
					<!-- 跳转到餐车的清单页面 -->
						<a href="${pageContext.request.contextPath }/cart/clientCart.do?user_id=${us.id}">
							<img src="${pageContext.request.contextPath }/app/style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>
	
			<div id="dish_2">
				<ul>
						<li>
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/foodtype/tiaofoodtype.do">火锅锅底</a>
							
						</li>
						
						<li>
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/user/exit.do">荤菜</a>
							
						</li>
						
						<li>
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/user/exit.do">素菜</a>
							
						</li>
						
						<li>
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/orders/orderList2.do?user_id=${us.id}">查看我的订单</a>
							
						</li>
						<li>
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/user/exit.do">退出</a>
							
						</li>
				</ul>
			</div>
			
		</div>
				
			
			</div>
		
	
</body>
</html>
