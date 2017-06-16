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
	<!-- 页面标题 -->
	<div id="menu">
	
	
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content" style="text-align: right;">
				 <!-- <a style="font-size: 22;font-family: fantasy;" href="javascript:history.go(-1);">返回</a> -->
			</div>
		</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	
			<form action="${pageContext.request.contextPath }/user/xiugaiuser.do" method="post">
			<div class="inp" style="margin-top: 70px;">
               	<label for="user-name" class="">手机号：</label>
               	<input type="text" name="phone" value="${us.phone }"><br>
              </div>
              <input name="id" type="hidden" value="${us.id }"/>
              <br>
              <div class="inp">
               	<label for="user-name" class="">&nbsp;姓名：</label>
               	
               	<input type="text" name="username" value="${us.username }"><br>
              </div>
          <br>
				
                <div class="inp">
               	<label for="user-name" >&nbsp;密码：</label>
               	<input type="password" name="password" value="${us.password }"><br>
                </div>
                <br>
                <div class="inp">
               	<label for="user-name" class="">&nbsp;性别：</label>
               	<input type="text" name="sex" value="${us.sex }"><br>
              </div><br>
              <div class="inp">
               	<label for="user-name" class="">&nbsp;地址：</label>
               	<input type="text" name="address" value="${us.address }"><br>
              </div><br>
               
                <div class="smt">
               	<label for="user-name" class="">&nbsp;&nbsp;&nbsp;</label>
               	&nbsp;<input type="submit"  value="修改">
               
                </div>
		</form>
	</div>

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
						<li>
							<a style="font-size: 18;" href="${pageContext.request.contextPath }/foodtype/tiaofoodtype.do">返回菜单</a>
							
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
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				
					
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>
