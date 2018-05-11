<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'M.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <script src="js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
  
  <body>
  
  
  
  
  <form name="form1" id="form1" method="post" action="">
<dl>
 <dt>用户名：</dt>
 <dd><input name="txtUserName" id="txtUserName" type="text" class="input1" /></dd>
  <dd><input  type="text" class="ccc" /></dd>
  <dd><input  type="submit" class="input1"  value="提交"/></dd>
</dl>
</form>



	<script type="text/javascript"  >
$(function() {
//表单验证JS
  $("#form1").validate({
    //出错时添加的标签
   // errorElement: "span", 
    rules: {
      txtUserName: {
        required: true,
        minlength: 3,
        maxlength: 16,
        remote: {
          type: "post",
          url: "UserServlet?method=uname",
          data: {//传输数据到后台
            username: function() {//
              return $("#txtUserName").val();//获取到表单的值
            }
          },
         /*  dataType: "html",
          dataFilter: function(data, type) {
            if (data == "true")
              return true;
            else
              return false;
          } */
        } 
      }
    },
    /*  success: function(label) {
      //正确时的样式
      label.text(" ").addClass("success");
    },  */
    messages: {
      txtUserName: {
        required: "请输入用户名，3-16个字符（字母、数字、下划线），注册后不能更改",
        minlength: "用户名长度不能小于3个字符",
        maxlength: "用户名长度不能大于16个字符",
        remote: "4444444用户名已经被注册44"
        //jQuery.format("用户名已经被注册")
      }
    }
  });
  
  
});
  
  </script>
  
  
  
  
  
  
  
  
  
  
  
  </body>
</html>
