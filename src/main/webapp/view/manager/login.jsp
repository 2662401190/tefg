<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\10\13 0013
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/login.css">

    <style>

    </style>
</head>
<body>


<div class="container">

    <form id="LoginForm" method="post" action="doLogin.do" class="form-signin" role="form">
        <%--${exception.message}--%>
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="username" name="loginacct"  placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="password" class="form-control" id="password" name="userpswd" placeholder="请输入登录密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <select id="ftype" class="form-control" name="type" >
                <option value="member" selected="selected">会员</option>
                <option value="user">管理</option>
            </select>
        </div>
        <div class="checkbox">
            <label>
                <input id="rememberme" type="checkbox" value="1"> 记住我
            </label>
            <br>
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="reg.html">我要注册</a>
            </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()" > 登录</a>
    </form>
</div>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/jquery/layer/layer.js"></script>
<script>
    function dologin(){
        var username=$("#username");
        var password=$("#password");
        var loadingIndex;
        if($.trim(username.val())==""){
            layer.msg("用户账号不能为空,请重新输入!", {time:1000, icon:5, shift:6}, function () {
                username.val("");
                username.focus();
            });
            return false ;
        }

            if($.trim(password.val())==""){
            layer.msg("用户密码不能为空,请重新输入!", {time:1000, icon:5, shift:6}, function () {
                password.val("");
                password.focus();
            });
            return false ;
        }

        $.ajax({
            type:"POST",
            data:{
                username: username.val(),
                password: password.val()
            },
            url:"${APP_PATH}/login/doLogin.do",
            beforeSend:function () {
                loadingIndex = layer.msg('处理中', {icon: 16});
            },
            success:function (result) {
                layer.close(loadingIndex);
                if(result.success){
                    window.location.href="${APP_PATH}/view/manager/main.jsp"
                }else{
                    layer.msg(result.message, {time:1000, icon:5, shift:6});
                }
            },
            error:function () {
                layer.msg("登录失败！", {time:1000, icon:5, shift:6});
            }
        })

    }

</script>


</body>
</html>