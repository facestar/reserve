<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>

<script type="text/javascript">
$(function()
{
	$("a").click(function()
	{
		var url=this.href;
		var args={"time":new Date()};
		$("#zl").load(url,args);
		return false;
	});
});
</script>
<script type="text/javascript">

</script>

<!-- <script type="text/javascript">
	window.onload=function()
	{
		document.getElementsByTagName("a")[0].onclick=function()
		{
			var request=new XMLHttpRequest();
			
			var url=this.href;
			var method="post";
			
			request.open(method, url);
			request.send(null);//发送请求
			
			request.onreadystatechange=function()//请求状态的响应时间
			{
				if(request.readyState==4&&request.status==200)//readyState==4时，表示响应发送完成，
				//request.status表示状态码，404，没有找到页面。。。304没有被修改，403禁止访问，200一切正常
				{
					alert(request.responseText);
				}
			}
			return false;
		}
	}


</script> -->
<body>

<a href="${pageContext.request.contextPath }/ajax.txt">你好ajax</a>
<div style="width:100px;height: 200px;background-color:#76b502 ;margin-left: 500px;">
	<div></div>
	<a href="app/login.jsp">跳</a>
</div>
<div id="zl"></div>
</body>
</html>