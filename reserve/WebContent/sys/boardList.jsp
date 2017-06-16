<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



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
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif"/> 餐桌列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
	
</div>

<!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="${pageContext.request.contextPath }/sys/saveBoard.jsp">添加</a></div>
    </div> 
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>编号</td>
				<td>桌名</td>
				<td>状态</td>
				<td>预定时间</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
        	<c:forEach items="${dinnerlist}" var="tab" varStatus="ji">
			<tr class="TableDetail1">
				<td align="center">${ji.index+1 }&nbsp;</td>
				<td align="center"> ${tab.tableName }&nbsp;</td>
				<td align="center">${tab.tableState }</td>
				<td align="center">${tab.dtime}</td>
				<td>
					<%-- <c:if test="${tab.tableState =='空闲'}"><a class="FunctionButton" href="${pageContext.request.contextPath }/table/updatetable.do?sta=${tab.id}">预定</a></c:if>
					<c:if test="${tab.tableState !='空闲'}"><a class="FunctionButton" href="${pageContext.request.contextPath }/table/updatetable.do?sta=${tab.id}">退桌</a></c:if> --%>
									
					<a href="${pageContext.request.contextPath }/table/deleteTable.do?id=${tab.id}" onClick="return delConfirm();"class="FunctionButton">删除</a>				
				</td>
			</tr>
			</c:forEach>
        
        </tbody>
    </table>
	
   
</div>
</body>
</html>
