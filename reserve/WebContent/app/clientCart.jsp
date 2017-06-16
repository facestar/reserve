<%@ page language="java" import="java.util.*,cn.zt.domain.Food" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="htmlEdit.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app/style/css/index.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<script type="text/javascript">

var msg="${msg}";
if(msg!="")
{
	alert(msg);
}

</script>
<!-- 数量改变ajax时间 -->
<script type="text/javascript">
	function count(res){
		var num=$(":input[name='"+res+"']").val();
		
		if(num>0)
		{
			//alert(num);
			window.location.href="${pageContext.request.contextPath }/cart/changeCount.do?user_id=${us.id}&&cd_id="+res+"&&num="+num;
		}
		else 
		{
			alert("菜品数量必须大于0！");
			
		}
	}
	
</script>


</head>

<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 餐车div -->
			<div id="count" >
			<form action="${pageContext.request.contextPath }/orders/addOrders.do" method="post">
				<table align="center" width="100%" >
					<tr height="40">
				 		<td align="center" >菜名</td>
				 		<td align="center" >单价</td>
				 		<td align="center" >数量</td>
				 		<td align="center" >小计</td>
				 		<td align="center" >操作</td>
				 	</tr>
				 	
				 	
					
					<c:forEach items="${mingxi }" var="cd" >
					
					<tr height="60" >
							
					 		<td  align="center" >${cd.food.foodName }</td>
					 		<td align="center" >${cd.food.price }</td>
					 		<td align="center" >
					 			
					 			<input type="text" name="${cd.id }" value="${cd.food_number }" size="3" lang="3" onchange="count('${cd.id }')"/>
						
					<input type="hidden" name="user_id" value="${us.id}"/>
					 			
					
					 <input type="hidden" name="foodtype_id" value="${cart.foodtype.id}"/>			
					 		</td>
					 		
					 		
					 		<td align="center" >
					 		${cd.xiaoji }
					 			 	 
					 		</td>
					 	
						 		
					 		<td align="center" >
					 			<input type="button"  value="删除" class="btn_next" onclick="window.location.href='${pageContext.request.contextPath }/cart/deleteCart.do?food_id=${cd.food.id }&&user_id=${us.id}'" />
					 		</td>
				 	</tr>
				 	</c:forEach>
				 	<tr><td>----------------</td>
				 	<td>-----------------</td><td>---------</td>
				 	<td>--------------------------</td><td>----------------------</td>
				 	</tr>
				 	<tr height="40">
				 		<td align="center" >锅底名称</td>
				 		<td align="center" >大小</td>
				 		<td align="center" >口味</td>
				 		<td align="center" >价格</td>
				 		<td align="center" >操作</td>
				 	</tr>	
					<tr>
						<!-- <td  style="text-align: center;">选择锅底</td> -->
						<td style=" text-align: center;">
							${cart.foodtype.typeName }
							<%-- <select name="foodtype_id">
							<c:forEach items="${foodtype }" var="fdy">
								<option   value="${fdy.id }">${fdy.typeName }</option>
							</c:forEach>
							</select> --%>
						</td>
						<td align="center">${cart.size }<input type="hidden" name="size" value="${cart.size}"/>
						</td>
						<td align="center" colspan="">
							${cart.kouwei } <input type="hidden" name="kouwei" value="${cart.kouwei}"/>
						</td>
						<td align="center" >${cart.ftprice }</div>
						<%-- <a href="${pageContext.request.contextPath }/foodtype/tiaofoodtype.do">火锅锅底详情</a> --%></td>
						<td align="center" >
						<input type="button"  value="更换" class="btn_next" onclick="window.location.href='${pageContext.request.contextPath }/foodtype/tiaofoodtype.do'" />
						</td>
					</tr>
					<tr>
						<td colspan="3" style=" text-align: right;"align="right">选择赴餐日期</td>
						<td style=" text-align: center;">
							<input style="cursor: pointer;"
							 name="riqia" class="Wdate" onClick="WdatePicker({minDate:'%y-%M-{%d}',maxDate:'%y-%M-{%d+4}'})"
							 ><!-- class="datainp wicon" id="date03" -->
							 <!--  -->
						</td>
						
					</tr>
					
					<tr>
						<td colspan="3" align="right">赴餐时间：
						</td>
						<td align="center">
							<input class="Wdate"  name="jutishijian" id="test" title="赴餐时间" onclick="WdatePicker({dateFmt:' HH:mm'})"  readonly 
							    style="cursor: pointer;">
							    
							<input type="hidden" name="totalprice" value="${totalprice }"/>
						</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="3" align="right">赴餐人数&nbsp;&nbsp;</td>	
						<td style=" text-align: center;">
							<input type="text" name="renshu">
						</td>
					
					</tr>

					<tr>
						<td colspan="6" align="right">总计:
							<span style="font-size:36px;">&yen;&nbsp;${totalprice }</span>
									<label	id="counter" style="font-size:36px;"></label>
						</td>
					</tr>
					
					<tr><td colspan="6"></td></tr>
					<tr><td colspan="6"></tr>
					<tr><td colspan="6"></tr>
					<tr>
						<td colspan="6" style="margin-left: 100px; text-align: center;"align="right">
							
									<input type="submit" value="下单" class="btn_next"   />
						</td>
					</tr>
				</table></form>
			</div>
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
				
			</div>
		</div>
	</div>
</body>


</html>
