<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link href="${pageContext.request.contextPath }/app/style/css/index.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	// 参数： 当前页
	function gotoPage(page){
				
		// 先获取当前表单对象
		var frm = document.forms[0];
		frm.action = "${pageContext.request.contextPath }/food?method=foodDetail" + "&currentPage="+page ;
		alert(frm.action);
		frm.submit();
	
	}

</script>
</head>

<body style="text-align: center">
	<div id="all">
	<!-- 页面标题 -->
	<div id="menu">
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif" /> 菜品详细
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content" style="text-align: right;">
				 <a style="font-size: 22;font-family: fantasy;" href="javascript:history.go(-1);">返回</a>
			</div>
		</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" style="text-align: center;" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜名</td>
					<td>单价</td>
					<td>数量</td>
					<td>小计</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach items="${foods }" var="fd">
			 		<tr height="60" align="center" valign="middle">
				 		<td>${fd.food.foodName }</td>
				 		<td>${fd.food.price }</td>
				 		<td>${fd.food_number }</td>
				 		<td>${fd.xiaoji }</td>
			 		</tr>
			 	</c:forEach>
			 	
			</tbody>
		</table>
		
	</div></div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
		
			<div id="dish_top">
				<ul>
				<li class="dish_num"></li>
					<li>
						<a href="${pageContext.request.contextPath }/cart/clientCart.do?user_id=${us.id}">
							<img src="${pageContext.request.contextPath }/app/style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>
	<form action="${pageContext.request.contextPath }/food?method=foodDetail" method="post">
	
			<div id="dish_2">
				<ul>
						<li>
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/orders/orderList2.do?user_id=${us.id}">查看我的订单</a>
							
						</li>
					
				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				
					
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>
