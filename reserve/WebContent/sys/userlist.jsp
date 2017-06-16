<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/sys/style/css/index_1.css" />
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif"/> 会员列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 过滤条件 -->
<div id="QueryArea">
	
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>编号</td>
				<td>姓名</td>
				<td>联系电话</td>
				<td>地址</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
			<c:forEach items="${userlist }" var="u" varStatus="j">
			<tr class="TableDetail1">
				<td align="center">${j.index+1 }&nbsp;</td>
				<td align="center"> ${u.username }&nbsp;</td>
				<td align="center"> ${u.phone }</td>
				<td align="center"> ${u.address }</td>
				<td >
					<a  href="${pageContext.request.contextPath }/user/person.do?id=${u.id}" class="FunctionButton">修改</a>
					<a  href="${pageContext.request.contextPath }/user/deleteuser.do?id=${u.id}" onClick="return delConfirm();"class="FunctionButton">删除</a>				
				</td>
			</tr>
			</c:forEach>
        
        
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="${pageContext.request.contextPath }/sys/saveUser.jsp">添加</a></div>
    </div> 
</div>

</body>
</html>