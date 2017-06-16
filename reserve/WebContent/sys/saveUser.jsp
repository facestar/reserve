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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
</head>
<script type="text/javascript">
var msg="${msg}";
if(msg!="")
{
alert(msg);
}
</script>
<script type="text/javascript">
$(function(){
	$(":input[name='phone']").change(function(){
		var val=$(this).val();
		val=$.trim(val);
		
		if(val!="")
		{
			url="${pageContext.request.contextPath }/user/ipone.do";
			args={"phone":val,"time":new Date()};
			$.post(url,args,function(data){
				
				$("#message").html(data);
			
			})
		}
	});

})


</script>

<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif"/>  添加新会员
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form id="myform" action="${pageContext.request.contextPath }/user/adduser.do" method="post" >
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="${pageContext.request.contextPath }/sys/style/images/item_point.gif"> 会员信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
                    
							
							
						<tr>
							<td width="80px">姓名</td>
							<td><input type="text" name="username" class="InputStyle" /> *</td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td><input type="text"  name="phone" class="InputStyle" /> *
							<div id="message"></div></td>
						</tr>
						<tr>
							<td>性别</td>
							<td><input type="text" name="sex" class="InputStyle"/> *</td>
						</tr>
						<tr>
							<td>地址</td>
							<td><input type="text" name="address" class="InputStyle"/> *</td>
						</tr>
						<tr>
							<td>密码</td>
							<td><input type="text" name="password" class="InputStyle" /> *</td>
						</tr>
						
						
					</table>
				</div>
            </div>
        </div>
		
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
            
				
				
					 <input type="submit" value="添加" id="sha" class="FunctionButtonInput">
				
			
            
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
</div>

</body>
</html>