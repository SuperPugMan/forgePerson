<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'DD.jsp' starting page</title>
    
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
  
  
  
  
  <!--  
  
   昵称：<input type="text" name="userName" onblur="validate();" required />
     <div id="result"></div>
   
   
   
   
   <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
   <script type="text/javascript">
    
    /**
                     昵称失去焦点时的事件
    */
     function validate(){
       //获取用户输入的昵称
       var  userName=$("[name='userName']").val();
     
       //创建ajax核心对象
       var  xhr=null;
       
       if(window.XMLHttpRequest){//高版本的浏览器
           xhr=new   XMLHttpRequest();
       }else{ //低版本的浏览器
          xhr=new ActiveXObject("Microsoft.XMLHTTP");
       }
       
       //在 readyState发生变化的时候都会触发这个个属性（回调函数）
       xhr.onreadystatechange=function(){
          if (xhr.readyState==4&&xhr.status==200) { //响应成功
			 //获取后台数据之后处理
			var data= xhr.responseText;
			if (data.match("true")) {  //证明用户名存在
				$("#result").html("<span style='color:red'>用户名已经存在</span>")
			}else{
				$("#result").html("<span style='color:green'>可以使用</span>")
			}
		  }
       }
       
       //初始化组件 xhr.open("GET", "validateServlet?userName="+userName);
       xhr.open("POST", "validateServlet");
       //如果是post请求 务必设置请求头
       xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
       
       //发送数据
       xhr.send("userName="+userName); 
       
        
        
        
     
     
     }
  
  
  
  
  
  
  
  
  
  
  
  -->
  
    昵称：<input type="text" name="userName" onblur="validate();" required />
     <div id="result"></div>
  
  
  
  
  <script type="text/javascript">
  
 function validate(){
 
var userName=$("[name='userName']").val();

var xhr=null;

if(window.XMLHttpRequest){//高版本的浏览器
   xhr=new XMLHttpRequest();
}else{//低版本的浏览器
   xhr=new ActiveXObject()
}

  //在 readyState发生变化的时候都会触发这个个属性（回调函数）
       xhr.onreadystatechange=function(){
          if (xhr.readyState==4&&xhr.status==200) { //响应成功
			 //获取后台数据之后处理
			var data= xhr.responseText;
			if (data.match("true")) {  //证明用户名存在(后台返回boolean类型，逻辑自己定)
				$("#result").html("<span style='color:red'>用户名已经存在</span>");//动态的添加内容样式
			}else{
				$("#result").html("<span style='color:green'>可以使用</span>")
			}
		  }
       }


 	 //初始化组件 
 	 xhr.open("GET", "validateServlet?userName="+userName);
     /*   xhr.open("POST", "validateServlet");
       //如果是post请求 务必设置请求头
       xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
       
       //发送数据
       xhr.send("userName="+userName);  */
       

 
 
 }
  
  </script>
  
  
  
  </body>
</html>
