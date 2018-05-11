<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<meta name="renderer" content="webkit">
<title>登录.云购物商城</title>
<link rel="shortcut icon" type="image/x-icon"
	href="img/icon/favicon.ico">
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/home.css">
<script src="js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="js/jquery.slideunlock.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript" src="js/login.js"></script>

<style>
/* 表示提示字的颜色 */
.error { /*   display:block;
    border:1px; */
	color: red;
}
</style>
</head>
<body>

	<header id="pc-header">
		<div class="center">
			<div class="pc-fl-logo">
				<h1>
					<a href="index.html"></a>
				</h1>
			</div>
		</div>
	</header>
	<section>
		<div class="pc-login-bj">
			<div class="center clearfix">
				<div class="fl"></div>
				<div class="fr pc-login-box">
					<div class="pc-login-title">
						<h2>用户登录</h2>
					</div>
					<%-- 
			<% 
					
				 //获取cookie对象
 				String userName="";
 				String userPwd="";				
 				Cookie[] cos=request.getCookies();
 				   
 				 if(cos!=null){
  
 				 for(int i=0;i<cos.length;i++){
 				
 					 if("user".equals(cos[i].getName())){
 					 
 					  userName=cos[i].getValue();										
 					  
 					 }
 					 
  					if("pwd".equals(cos[i].getName())){
  
 					 userPwd=cos[i].getValue();
 					 
 					 }
  
 					 }
 					} 
 					 
 				%>	 --%>

					<script type="text/javascript">
 					
 					$(function(){
 					
 					/* 记得jsp的 脚本的值的值<%--  <%=jsp的变量%> --%>*/	
 							
 					$("#user").attr("value", "${cookie.user.value}");
 					$("#pwd").attr("value",  "${cookie.pwd.value}");

 					
 					});
		
 					</script>




					<form action="UserServlet?method=login" id="form" method="post">
						<div class="pc-sign">
							<input type="text" name="user" id="user" placeholder="用户名/邮箱/手机号">
						</div>
						<div class="pc-sign">
							<input type="password" name="pwd" id="pwd" placeholder="请输入您的密码">
						</div>

						<div class="pc-jizhu">
							<input type="checkbox" name="jizhu" checked>记住密码
						</div>



						<div class="pc-submit-ss">
							<input type="button" value="登录" onclick="clicks()">
						</div>




						<div id="demo">
							<div id="slider">
								<div id="slider_bg"></div>
								<span id="label">>></span> <span id="labelTip">拖动滑块验证</span>
							</div>


						</div>



						<div class="pc-item-san clearfix">
							<a href="#"><img src="img/icon/weixin.png" alt="">微信登录</a>
							<a href="#"><img src="img/icon/weibo.png" alt="">微博登录</a> <a
								href="#" style="margin-right:0"><img
								src="img/icon/tengxun.png" alt="">QQ登录</a>
						</div>
						<div class="pc-reg">
							<a href="#">忘记密码</a> <a href="register.jsp" class="red">免费注册</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>


	<!--页面的尾部  -->
	<footer>
		<div class="center">
			<div class="pc-footer-login">
				<p>关于我们 招聘信息 联系我们 商家入驻 商家后台 商家社区 ©2017 Yungouwu.com 北京云购物网络有限公司</p>
				<p style="color:#999">营业执照注册号：990106000129004 |
					网络文化经营许可证：北网文（2016）0349-219号 | 增值电信业务经营许可证：京2-20110349 | 安全责任书 |
					京公网安备 99010602002329号</p>
			</div>
		</div>
	</footer>

	<script>
	
	
	$(document).keydown(function (event) {//这个参数是键盘的对象
       //alert(event.keyCode)
      if (event.keyCode == "13") {//按回车键
         if($("#form").valid()){     
         $("#demo").css({"display":"block"});    
       }   
  	}
   });
							
							
	function clicks(){
             
       if($("#form").valid()){
       
         $("#demo").css({"display":"block"});    
       }   
    }
        
    $(function () {
        var slider = new SliderUnlock("#slider",{
				successLabelTip : "验证成功"	
			},function(){
				/* alert("验证成功,即将跳转至百度");
            	window.location.href="http://www.baidu.com" */
            	$("#form").submit();
            	
        	});
        slider.init();
    })
    
    
    
    
    
    
</script>



</body>
</html>