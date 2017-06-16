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
<script type="text/javascript">
	var mssg="${msg}";
	if(mssg!="")
	{
		alert(mssg);
	}
</script>

<script type="text/javascript">
function checkp(){
var phone=document.getElementsByName("phone")[0].value;

if(!(/^1[3|4|5|7|8][0-9]{9}$/).test(phone))
	{
		alert("手机号格式错误！！！！");
		
		document.getElementsByName("phone")[0].value="";
		return;
	}
}

</script>

<script type="text/javascript">
function ssub(){
	var phone=document.getElementsByName("phone")[0].value;
	var username=document.getElementsByName("username")[0].value;
	var password=document.getElementsByName("password")[0].value;
	var sex=document.getElementsByName("sex")[0].value;
	var address=document.getElementsByName("address")[0].value;
if(phone==null||phone=="")
	{
		alert("电话不能为空！");
	}
else if(username==null||username=="")
{
	alert("用户名不能为空！");
}
else if(password==null||password=="")
{
	alert("密码不能为空！");
}
else if(sex==null||sex=="")
{
	alert("性别不能为空！");
}
else if(address==null||address=="")
{
	alert("地址不能为空！");
}

else
	{
	form1.submit();
	}
}

</script>

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
				<p style="color: #D24925;"><font size="19" >火锅店注册页面</font></p>
			</div>
			<div class="" style="color: #099AD1;font-size: 26px;">
			
			<form name="form1" action="${pageContext.request.contextPath }/user/adduser2.do" method="post">
              <div class="inp">
               	<label for="user-name" class="">手机号：</label>
               	<input type="text" name="phone"  id="phone" placeholder="请输入你的手机号。" onblur="checkp()"><br>
              </div>
              <br>
              <div class="inp">
               	<label for="user-name" class="">&nbsp;姓名：</label>
               	
               	<input type="text"  class="sex" name="username" placeholder="请输入你的真实姓名。"><br>
              </div>
          <br>
				<div class="inp">
               	<label for="user-name" >&nbsp;密码：</label>
               	<input type="password"  name="password" placeholder="请输入你的密码。"><br>
                </div>
                <br>
                <div class="i2" >
               	<label for="user-name" class="" style="margin-left: -130px;">&nbsp;&nbsp;性别：</label>
               	<input  type="radio" name="sex" checked="checked">男
               	<input type="radio"  name="sex" >女<br>
              </div><br>
              <div class="inp">
               	<label for="user-name" class="">&nbsp;地址：</label>
               	<input type="text" name="address" placeholder="请输入你的地址。" ><br>
              </div><br>
               
                <div class="smt">
               	<label for="user-name" class="">&nbsp;&nbsp;&nbsp;</label>
               	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onclick="ssub()" value="注册">
               	已注册？请<a style="font-size: 25px;color: red;" href="${pageContext.request.contextPath }/app/login.jsp">登录</a>
                </div>
                </form>
			</div>
			<div style="width:1024px;
	height:60px;">
			
			</div>
			

			
		</div>
		
		<!--下面的背景层-->
		<div>
			<img src="${pageContext.request.contextPath }/app/style/images/flower1.gif" />
		</div>
	</div>
</body>
</html>