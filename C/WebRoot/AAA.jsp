<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AAAjsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
    
    "<td>"
									+"<div class='c_s_img'>"
									+"<img src='images/c_1.jpg' width='73' height='73' />"
									+"</div>
									${cartItem.value.product.name}"
									+"</td>"
									+"<td align='center'>颜色：灰色</td>"
									+"<td align='center'>"
									+"<div class='c_num'>"
									+"	<input type='button' value='' onclick='jianUpdate1(jq(this));' class='car_btn_1' />"
									+"	<input type='text' value='${cartItem.value.num}' name='' class='car_ipt' />"
									+"	<input type='button' value='' onclick='addUpdate1(jq(this));' class='car_btn_2' />"
									+"</div>"
									+"</td>"
									+"<td align='center' style='color: #ff4e00;'>￥${cartItem.value.price}</td>"
									+"<td align='center'>26R</td>"
									+"<td align='center'><a href='productServlet?method=del&id=${cartItem.key}'>删除</a>&nbsp;&nbsp;<a href='#'>加入收藏</a>"
									+"</td>"
    
    
  </body>
</html>
