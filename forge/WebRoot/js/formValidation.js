/**
 * Created by Administrator on 2018/3/23.
 */
$(function(){
    $("#register").validate({
        rules:{
            firstName:{
                required:true,
                minlength:1,
                maxlength:2
            },
            lastName:{
                required:true
            },
            country:{
                required:true
            },
            state:{
                required:true
            },
          
            city:{
                required:true
            },
            address:{
                required:true
            },
            phone:{
                required:true,
                checkPhone:true//checkPhone需要自己书写
            },
            email:{
                required:true,
                email:true
            },
            pwd:{
                required:true,
                minlength:6,
                maxlength:10
            },
            repwd:{
                required:true,
                minlength:6,
                maxlength:10,
                equelT0:"myPwd"
            }
        },
        messages:{
            firstName:{
                required: "Please enter your first name",
                minlength: "The length of the first name cannot be less than 1",
                maxlength: "The length of the first name cannot be greater than 2"
            },
            lastName:{
                required: "Please enter your last name"
            },
            country:{
                required: "Please select your country"
            },
            state:{
                required: "Please select your province"
            },
            city:{
                required: "Please select your city"
            },
            address:{
                required: "Please enter your detailed address"
            },
            phone:{
                required: "Please enter the phone number",
                checkPhone: "Incorrect mobile number format"//checkPhone需要自己书写
            },
            email:{
                required: "please input your email",
               
            },
            pwd:{
                required: "Please enter your password",
                minlength: "Password length cannot be less than 6",
                maxlength: "Password length cannot be greater than 10"
            },
            repwd:{
                required: "Please enter your password again",
                minlength: "Password length cannot be less than 6",
                maxlength: "Password length cannot be greater than 10",
                equelT0: "Two passwords must be the same"
            }
        },
        onfocusout:function(e){
            $(e).valid();
        }
    });
    /*增加手机验证规则*/
    jQuery.validator.addMethod("checkPhone",function(value,element){
        var  phone=/^1[3|4|5|8][0-9]\d{4,8}$/;
        return this.optional(element)||(phone.test(value));
    },"手机号码格式不正确")
    $("#login").validate({
        rules:{
            email:{
                required:true,
            },
            password:{
                required:true,
                minlength:6,
                maxlength:10
            },  
            slider_block:{
            	 required:true
            }
        },
        messages:{
            email:{
                required: "please input your email",
            },
            password: {
                required: "Please enter your password",
                minlength: "Password length cannot be less than 6",
                maxlength: "Password length cannot be greater than 10"
            }, 
            slider_block:{
            	required: "Slide block"
            },
        },
        onfocusout:function(e){
            $(e).valid();
        }
    });

});