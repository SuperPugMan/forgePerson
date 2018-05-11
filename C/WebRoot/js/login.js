


 $(function () {
	 
	 
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
                   required:"请输入用户名",
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