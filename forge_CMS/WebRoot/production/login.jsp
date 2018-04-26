<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentelella Alela! | </title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="../vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form  action="/forge_CMS/userlogin?method=login" method="post">
              <h1>后台登录</h1>
              <div>
                <input name="name" type="text" class="form-control" placeholder="请输入管理员登录名" required="" />
              </div>
              <div>
                <input name="password" type="password" class="form-control" placeholder="请输入管理员登录密码" required="" />
              </div>
              <div>
                <button class="btn btn-default submit" type="submit">登录</button>
                <a class="reset_pass" href="#">忘记密码</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">没有账号？？
                  <a href="#signup" class="to_register"> 点此留下信息，等待管理员联系 </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> forge后台登录!</h1>
                  <p>Â©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form>
              <h1>留下你的信息</h1>
              <div>
                <input type="text" class="form-control" placeholder="请留下你的名字" required="" />
              </div>
              <div>
                <input type="email" class="form-control" placeholder="请留下你的Email" required="" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="请留下你的联系电话" required="" />
              </div>
              <div>
                <button class="btn btn-default submit" href="index.jsp">确认提交</button>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">拥有管理员账号 ?
                  <a href="#signin" class="to_register"> 去登陆 </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> 请留下信息，等待管理员联系!</h1>
                  <p>Â©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>
