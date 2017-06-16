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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/sys/style/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/sys/style/css/theme.css">
  <style type="text/css">
  .table th{
  		border: 1px solid;
  		vertical-align: middle
  }
  .table td{
  		border: 1px solid;
  }
  
  </style>
  
    <link rel="stylesheet" href="${pageContext.request.contextPath }/sys/style/css/font-awesome.css">
</head>
<body style="background-color: #d8edfc;">
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif"/> 当日统计
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 过滤条件 -->
<div id="QueryArea">
	
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea" style="background-color: #d8edfc;">
    <div class="row-fluid" style="background-color: #d8edfc;">
    <div class="block span6" style="width:100%;">
        
        <div id="tablewidget" class="block-body collapse in">
            <table class="table" style="width:100%;">
              
                <tr>
                  <th style="text-align: center;">今日收入:</th>
                  <th style="text-align: center;">${dataMap.shouru }元</th>
                </tr>
              
               <tr style="border: 0px;">
               	  <th style="border: 0px;"></th>
                 
                </tr>
              
                <tr >
                  <th style="text-align: center;">订单总数:</th>
                  <th style="text-align: center;">${dataMap.dzongshu }单</th>
                </tr>
             
             
                <tr style="border: 0px;">
               	  <th style="border: 0px;"></th>
                 
                </tr>
            
               
              
                <tr align="center" valign="middle">
               	  <th rowspan="${dataMap.foodsize +1}" style="text-align: center;">菜品统计：</th>
                  <th>菜品名称</th>
                  <th>菜品数量</th>
                  <th>菜品小计</th>
                </tr>
             
              <c:forEach items="${dataMap.foods }" var="odt">
                <tr>
               	  
                  <th>${odt.food.foodName }</th>
                  <th>${odt.food_number }盘</th>
                  <th>${odt.xiaoji }元</th>
                </tr>
              </c:forEach>
              
               
              
                <tr style="border: 0px;">
               	  <th style="border: 0px;"></th>
                 
                </tr>
              
            
                <tr align="center">
               	  <th rowspan="${dataMap.huoguosize+1 }" style="text-align: center;" >锅底统计：</th>
                  <th>锅底名称</th>
                  <th>数量</th>
                  <th>小计</th>
                </tr>
             
           <c:forEach items="${dataMap.huoguo }" var="od">
                <tr>
               	  
                  <th>${od.foodtype.typeName }</th>
                  <th>${od.renshu }</th>
                  <th>${od.totalprice }元</th>
                </tr>
              </c:forEach>
            
                
            </table>
            
        </div>
    </div>
    
   
</div>

	
   
</div>

</body>
</html>