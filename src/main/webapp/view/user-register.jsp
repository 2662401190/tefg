<%--
  Created by IntelliJ IDEA.
  User: HeWei
  Date: 2018/11/10
  Time: 15:03
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
    <title>用户注册</title>
    <link rel="stylesheet" href="/css/style.css" />

        <script src="/js/jquery-3.2.1.min.js"></script>
<body>

<div class="register-container">
    <h1>新用户注册</h1>

    <div class="connect">
        <p>Link the world. Share to world.</p>
    </div>

    <form action="/user/register.do" method="post" id="registerForm">
        <div>
            <input type="text" name="username" id="username" class="username" placeholder="您的用户名" autocomplete="off"/>
        </div>
        <div>
            <input type="password" name="password" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
        </div>
        <div>
            <input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
        </div>
        <div>
            <input type="text" name="phone" class="phone_number" placeholder="输入手机号码" autocomplete="off" id="number"/>
        </div>
        <div>
            <input type="email" name="email" class="email" id="email" placeholder="输入邮箱地址" oncontextmenu="return false" onpaste="return false" />
        </div>

        <div>
            <input type="text" name="question" class="question" placeholder="请输入密码提示问题" oncontextmenu="return false" onpaste="return false" />
        </div>
        <div>
            <input type="text" name="answer" class="answer" placeholder="请输入密码提示答案" oncontextmenu="return false" onpaste="return false" />
        </div>

        <button id="submit" type="button">注 册</button>
    </form>

    <a href="user-login.jsp">
        <button type="button" class="register-tis">已经有账号？</button>
    </a>



</div>


<script src="/js/jquery.min.js"></script>
<%--<script src="/js/common.js"></script>--%>
<!--背景图片自动更换-->
<script src="/js/supersized.3.2.7.min.js"></script>
<script src="/js/supersized-init.js"></script>
<!--表单验证-->
<script src="/js/jquery.validate.min.js?var1.14.0"></script>
<script>
    $(document).off('mouseout','#username').on('mouseout','#username',function () {
        //发送 AJAX 请求，校验用户是否可用
        var str=this.value;
        check_user(str,"username");
    })

    $(document).off('mouseout','#email').on('mouseout','#email',function () {
        //发送 AJAX 请求，校验用户是否可用
        var str=this.value;
        var regEamil=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

        if (!regEamil.test(str)){
            alert("邮箱格式不正确");
            return false;
        }

        check_user(str,"username");

    })
    function check_user(str,type){
        $.ajax({
            url:"${path}/user/check_Valid.do",
            type:"post",
            data:{"var":str,"type":type},
            success:function (result) {
                if(result.msg=="email已存在"){
                    alert("email已存在");
                    $(".email").focus();
                    return  false;
                }else if (result.msg=="用户名以存在") {
                    alert("用户名以存在");
                    $(".username").focus();
                    return false;
                }else{

                   // todo 成功
                 }
            }
        });
    }
    $(document).off('mouseout','.confirm_password').on('mouseout','.confirm_password',function () {
        var pass=$(".password").val();
        if (this.value != pass) {
            alert("两次密码不一致");
            return $(this).focus();
        }
    })


    $("#submit").click(function () {

        var data=$("#registerForm").serialize();
        data=decodeURIComponent(data,true);

        $.ajax({
            url:"${path}/user/register.do",
            type: "post",
            data:data,
            success:function (result) {

                if (result.status == 0) {
                    alert("注册成功");
                }else {
                    alert("注册失败");
                    return false;
                }
            }
        });


    });



</script>
</body>
</html>
<!--
本代码由js代码收集并编辑整理;
尊重他人劳动成果;
转载请保留js代码链接 - www.jsdaima.com
-->
