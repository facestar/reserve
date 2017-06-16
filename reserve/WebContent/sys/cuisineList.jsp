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
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif" /> 火锅种类列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		
	</div>
<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton" align="center" >
				<a  href="${pageContext.request.contextPath }/sys/saveCuisine.jsp">添加</a>
			</div>
		</div>
		
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>种类编号</td>
					<td>种类名称</td>
					<td>种类图片</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach items="${ftype }" var="f" varStatus="ji">
					<tr  valign="middle">
						<td align="center">${ji.index+1 }</td>
						<td align="center">${f.typeName }</td>
						<td align="center"><img alt="" src="${f.picture }" style="width:214px; height:145px;" title="${f.typeName }"></img></td>
						<td align="center">
							<a href="${pageContext.request.contextPath }/foodtype/tiaoUpdate.do?id=${f.id}" class="FunctionButton">修改</a> 
							<a href="${pageContext.request.contextPath }/foodtype/delete.do?id=${f.id}" class="FunctionButton">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>
