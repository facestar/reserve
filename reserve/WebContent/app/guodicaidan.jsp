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

<link href="${pageContext.request.contextPath }/app/style/css/index.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app/style/css/index_1.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>



<script type="text/javascript">
	function addcart(res){
		var size=$("#size").val();
		var kouwei=$("#kouwei").val();
		
		var url="${pageContext.request.contextPath }/cart/addcart2.do";
		args={"foodtype_id":res,"time":new Date(),"user_id":${us.id},
				"size":size,"kouwei":kouwei};
		$.post(url,args,function(data){
				alert('已经添加!');
				$("#message").html(data);
			
			})
	}
</script>
<script type="text/javascript">
var msg="${msg}";
if(msg!="")
{
	alert(msg);
}
</script>
</head>

<body style="text-align: center">
	<div id="all">
		<div id="menu" >
			<!-- 显示菜品的div -->
			<div style="color:#0E94CF;">
			<div id="message"></div>
			</div>
			<div id="top" >
				<ul>
					<!-- 循环列出火锅种类 -->
					<c:forEach  items="${foty.list}" var="fjd">
						<li>
						
							<dl>
								<dt>
									<a >
										<img width="214px" height="145px" src="${fjd.picture }" />
									</a>
								</dt>
								<dd class="f1" >
									<a style="font-size: 15px;">${fjd.typeName }</a>
								</dd>
								<dd class="f2">
								<select  id="size" >
									<option   value="小锅">小锅</option>
									<option   value="中锅">中锅</option>
									<option   value="大锅">大锅</option>
								</select>	
								<select id="kouwei">
									<option   value="清汤">清汤</option>
									<option   value="麻辣">麻辣</option>
									<option   value="酸辣">酸辣</option>
								</select>
								<input type="button" value="放入餐车" onclick="addcart('${fjd.id }')">
								</dd>
							</dl>
							
						</li>
						</c:forEach>
					
					
				</ul>
			</div>
			
			<!-- 底部分页导航条div -->
			<div id="foot">
				<span style="float:left; line-height:53PX; margin-left:-50px; font-weight:bold; ">
							<span style="font-weight:bold;cursor: pointer;">&lt;&lt;</span>
						</span>
				<div id="btn" >
					
						<!-- 参看 百度, 谷歌是 左 5 右 4 -->
					当前${foty.nowpage}/${foty.allpage}页 &nbsp;	
					 <a href="${pageContext.request.contextPath }/foodtype/fenye.do?nowpage=1&&allpage=0">首页</a>
					 <a href="${pageContext.request.contextPath }/foodtype/fenye.do?nowpage=${foty.nowpage-1}&&allpage=0">上一页</a>
					 <a href="${pageContext.request.contextPath }/foodtype/fenye.do?nowpage=${foty.nowpage+1}&&allpage=0">下一页</a>
					 <a href="${pageContext.request.contextPath }/foodtype/fenye.do?nowpage=1&&allpage=1">尾页</a>
						
					
				</div>
				<span style="float:right; line-height:53px; margin-right:10px; margin-top: -30px; font-weight:bold; ">
							<span
							style=" color:#000000; font-weight:bold;cursor: pointer;">
							&gt;&gt;</span>
						</span>
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
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/food/fenye.do?leixing=荤菜&&nowpage=1&&allpage=0">荤菜</a>
							
						</li>
						
						<li>
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/food/fenye.do?leixing=素菜&&nowpage=1&&allpage=0">素菜</a>
							
						</li>
						
						<li>
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/orders/orderList2.do?user_id=${us.id}">查看我的订单</a>
							
						</li>
						<li>
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/app/personal.jsp">修改个人信息</a>
							
						</li>
						<c:if test="${us.phone=='admin' }">
						<li>
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/sys/index.jsp" target="_blank">后台管理</a>
							
						</li></c:if>
						<li>
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/user/exit.do">退出</a>
							
						</li>
				</ul>
			</div>
			
		</div>
		
	</div>
</body>
</html>
