<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/sys/style/css/index_1.css" />
	<script type="text/javascript">
		setInterval(function(){
			window.location.href = "";
		},1000 * 50);
	</script>
</head>
<body>
	<!-- 页面标题 -->
	
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif" /> 餐厅订单列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>订单编号</td>
					<td>下单日期</td>
					<td>总金额</td>
					<td>预定人</td>
					<td>联系电话</td>
					<td>赴餐时间</td>
					<td>赴餐人数</td>
					<td>菜品详细</td>
					<td>锅底</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach items="${orderlist }" var="od">
			 		<tr height="60">
				 		<td align="center">${od.orderNumber }</td>
				 		<td align="center">${od.orderstime }</td>
				 		<td align="center">${od.totalprice }</td>
				 		<td align="center">${od.user.username }&nbsp;&nbsp;&nbsp;</td>
				 		<td align="center">${od.user.phone }</td>
				 		<td align="center">${od.riqi}&nbsp;&nbsp;${od.jutishijian}</td>
				 		<td align="center">${od.renshu }</td>
				 		<td align="center"><a href="${pageContext.request.contextPath }/orders/orderDetail2.do?order_id=${od.id}" class="FunctionButton">菜品详细</a></td>
				 		<td align="center">
				 				${od.foodtype.typeName}&nbsp;${od.kouwei }&nbsp;${od.size }
				 		</td>
			 		</tr>
			 	</c:forEach>
			 	
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
		</div>
	</div>
</body>
</html>
