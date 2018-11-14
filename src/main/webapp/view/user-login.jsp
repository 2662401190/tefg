<%--
  Created by IntelliJ IDEA.
  User: HeWei
  Date: 2018/11/10
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
      request.setAttribute("path", request.getContextPath());
    %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Tefg登录</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="/css/style.css" />

<body>

<div class="login-container">
    <h1>前台登录</h1>

    <form   id="loginForm">
        <div>
            <input type="text" name="userName" class="username" placeholder="用户名" autocomplete="off"/>
        </div>
        <div>
            <input type="password" name="passWord" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
        </div>
        <button id="submit" type="submit">登 录</button>
    </form>

    <a href="user-register.jsp">
        <button type="button" class="register-tis">还有没有账号？</button>
    </a>

</div>

<script src="/js/jquery.min.js"></script>
<script src="/js/common.js"></script>
<!--背景图片自动更换-->
<script src="/js/supersized.3.2.7.min.js"></script>
<script src="/js/supersized-init.js"></script>
<!--表单验证-->
<script src="/js/jquery.validate.min.js?var1.14.0"></script>

<script>

    $(function () {
        $("#submit").click(function () {
            var data=$("#loginForm").serialize();
            data=decodeURIComponent(data,true);
            $.ajax({
                url:"${path}/user/login.do",
                type:"post",
                data:data,
                success: function (result) {
                    console.log(result);
                   if (result.status==0){
                       // todo  跳转到主页
                   }else{
                       alert("没有此用户或密码错误");
                       result;
                   }
                }
            });
        });
    })

</script>

</body>
</html>
