<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">

<title>登录.云购物商城</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
 <meta charset="UTF-8" /> 
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<head>


<link rel="shortcut icon" type="image/x-icon"
	href="img/icon/favicon.ico">
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/home.css">

<style>
/* 表示提示字的颜色 */
.error {

  /*   display:block;
    border:1px; */

	color: red;
	
	
	
}

#remind{
  color:red;
}
</style>


<script src="js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
 <script type="text/javascript" src="js/login.js" ></script> 


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
						<h2>用户注册</h2>
					</div>

					<!-- 使用到jquery.validate.js框架  myForm 看login.js  -->
					<form action="UserServlet?method=add" method="post" id="myForm">
						<div class="pc-sign">
							<input name="userName"  id="uname" placeholder="请输入用户名"><br />
							<span id="remind" ></span>
						</div>

						<div class="pc-sign">
							<input id="pwd" name="passWord" type="password"
								placeholder="请输入密码"><br />
						</div>

						<div class="pc-sign">
							<input name="rePwd" type="password" placeholder="请再输入密码"><br />
						</div>

						<div class="pc-sign">
							<input name="email" placeholder="请再输入邮箱"><br />
						</div>

						<div class="pc-sign">
							<input name="phone" placeholder="请再输入手机"><br />
						</div>

						是否同意协议：<input name="context" type="checkbox"><br />

						<!-- <button type="submit">立即注册</button> -->

						<div class="pc-submit-ss">
							<input type="submit" value="立即注册">
						</div>

					</form>










					<!-- <form action="" method="post" id="myForm">
						<div class="pc-sign">
							<input name="userName" placeholder="邮箱/手机号">
						</div>
						<div class="pc-sign">
							<input name="password" placeholder="请输入您的密码">
						</div>
						<div class="pc-sign">
							<input name="password" placeholder="请确认您的密码">
						</div>
						<div class="pc-sign">
							<input type="password" placeholder="请输入您的验证码">
						</div>
						<div class="pc-submit-ss">
							<input type="submit" value="立即注册" placeholder="">
							<button type="submit">立即注册</button>
						</div> -->

					<div class="pc-item-san clearfix">
						<a href="#"><img src="img/icon/weixin.png" alt="">微信登录</a> <a
							href="#"><img src="img/icon/weibo.png" alt="">微博登录</a> <a
							href="#" style="margin-right:0"><img
							src="img/icon/tengxun.png" alt="">QQ登录</a>
					</div>
					<div class="pc-reg">

						<a href="login.jsp" class="red">如已有账号 请登录</a>



					</div>
					</form>
				</div>
			</div>
		</div>
	</section>
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
	
	
	
	<script type="text/javascript"  >
	
	
	
	
	
	


//正则框架===================================================================
 /*  $(function () {
    	       $("#form").validate({
    	       
    	           rules:{//验证规则
    	              user:{//user是对应的form表单  input标签的name值
    	                required:true
    	              },
    	              pwd:{
    	                required:true,
    	                minlength:6,
    	                maxlength:60
    	              }
    	           },
    	           messages:{//提示信息或者是要求 
    	        	   user:{
    	                   required:"用户名不能为空！"
    	               },
    	               pwd:{
    	                   required:"密码不能为空",
    	                   minlength:"密码长度不能小于6",
    	                   maxlength:"密码长度不能大于60"
    	               }
    	           },
    	           onfocusout:function (e) {//文本框失去焦点就验证
    	               // e:相当于下标，即this.index
    	               $(e).valid();
    	           }
    	       });
    	       
    	    
    	   });


*/



   /*  $(function () {
    
    
 
    
       $("#myForm").validate({
           rules:{//验证规则          
                userName:{             
                required: true,  //不允许为空            
                remote: {        //验证用户是否存在validate自带的
         		  type: "post",  //提交方式
        		  url: "UserServlet?method=uname",//@WebServlet("/UserServlet")
        		  data: {//传输数据到后台  @WebServlet("/UserServlet")
          		  username: function() {//
            		  return $("#uname").val();//获取到表单的值发送过去取对比数据库jdbc
           		  }
          		  },    
       	       } 
      		  },
       
      		  passWord:{
                required:true,
                minlength:6,
                maxlength:10
              },
               rePwd:{
                   required:true,
                   minlength:6,
                   maxlength:10,
                   equalTo:"#pwd"//必须和某值相同
               },
               email:{
                   required:true,
                   email:true
               },
               phone:{
                   required:true,
                   checkPhone:true//自定义方法可以用作做逻辑
               },
               context:{
                   required:true,
               }
           },
                    
           messages:{//提示信息或者是要求 
               userName:{
                   required:"请输入用户名！",
                   remote: "用户名已经被注册"
                     //remote: jQuery.format("用户名已经被注册")
               },
               passWord:{
                   required:"密码不能为空",
                   minlength:"密码长度不能小于6",
                   maxlength:"密码长度不能大于10"
               },
               rePwd:{
                   required:"请重复输入密码",
                   minlength:"密码长度不能小于6",
                   maxlength:"密码长度不能大于10",
                   equalTo:"两次密码不一致"
               },
               email:{
                   required:"请输入邮箱",
                   email:"邮箱格式不正确"
               },
               phone:{
                   required:"请输入手机号 "
               },
               context:{
                   required:"必须同意协议",
               }
           },
           onfocusout:function (e) {//文本框失去焦点就验证
               // e:相当于下标，即this.index
               $(e).valid();
           }
       });
       
      // 验证手机号的方法
       jQuery.validator.addMethod("checkPhone",function (value,element) {
          var phone2=/^1[3|4|5|8][0-9]\d{4,8}$/;
           return this.optional(element)||phone2.test(value);//this.optional(element)用于表单输入值不为空时验证，当field为空时，即element的值为空
       },"手机号码不正确")
   });
    */
    
   
    
    
   //Ajax
   
   
    /*Ajax验证是否有这个用户名*/
        /* $(function(){
            $("#uname").blur(function(){//失去焦点
            
                var uname = $(this).val();//获input的value值

                if(uname==""){//判断输入的值
                    //$("#remind").html("用户名不能为空");//
                }else{
                    // $.ajax方法实现
                    $.ajax({
                        url:"UserServlet?method=uname",//提交的服务器、就是一个@WebServlet("/UserServlet")
                        type:"post",
                        data:"uname="+uname,//要传输的数据！也就是用户的名字
                        dataType:"text",//类型json
                        async:false,
                        success:function(result){//servlet返回的响应resp.getWriter().write("用户主");
                            $("#remind").html(result);
                        }
                    });

                    // $.get()方法实现，$.post方法也是一样的，post方法不能在地址后面直接传值
                    //$.get("IsUserServlet","uname=" + uname, function(result){
                    //  $("#remind").html(result);
                    //},"text");

                    // load()方式实现
                   //$("#remind").load("IsUserServlet","uname=" + uname);
                }
            });

        }); */
        
        
           
    /*
    
     txtUserName: {
                required: true,
                minlength: 3,
                maxlength: 16,
                remote: {
                    type: "post",
                    url: "/tools/ValidateUserName.ashx",
                    data: {
                        username: function() {
                            return $("#txtUserName").val();
                        }
                    },
                    dataType: "html",
                    dataFilter: function(data, type) {
                        if (data == "true")
                            return true;
                        else
                            return false;
                    }
                }
            }
        },
        success: function(label) {
            //正确时的样式
            label.text(" ").addClass("success");
        },
    
    
    */







    	  
	 
	
	
	
   
	</script>

</body>
</html>