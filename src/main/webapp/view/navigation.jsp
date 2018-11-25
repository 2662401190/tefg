<%--
  Created by IntelliJ IDEA.
  User: HeWei
  Date: 2018/11/24
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        request.setAttribute("path", request.getContextPath());
    %>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>TEFG商城</title>
    <link rel="stylesheet" type="text/css" href="/css/indexCss/style.css">


    <!-- Bootstrap -->
    <%--<link rel="stylesheet" href="/css/indexCss/jz.css" />--%>
    <!--<link rel="stylesheet"  href="css/index.css"/>-->

    <script src="/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
    <script type="text/javascript" src="/js/jquery.jqzoom.js"></script>
    <script type="text/javascript" src="/js/picture.js"></script>
    <script>
        $(function(){
            $(window).bind("scroll",function(){
                var stop=$(window).scrollTop();
                var stop=parseInt(stop);
                if(stop>=100){
                    $("#banner").css({"z-index":"10","position":"fixed","background-color":"white","top": "0","padding-right":"300px"})
                }
                if(stop<=100){
                    $("#banner").css({"z-index":"0","position":"relative"})
                }
            })
        })
    </script>
</head>
<body>
        <%--通用导航栏--%>
        <header>
            <div class="top center">
                <div class="left fl">
                    <ul>
                        <li><a href="" target="_blank">TEFG商城</a></li>
                        <li>|</li>
                        <li><a href="">TEGF</a></li>
                        <li>|</li>
                        <li><a href="">游戏</a></li>
                        <li>|</li>
                        <li><a href="">多看阅读</a></li>
                        <li>|</li>
                        <li><a href="">云服务</a></li>
                        <li>|</li>
                        <li><a href="">金融</a></li>
                        <li>|</li>
                        <li><a href="">TEFG商城移动版</a></li>
                        <li>|</li>
                        <li><a href="">问题反馈</a></li>
                        <li>|</li>
                        <li><a href="">客服服务</a></li>
                        <div class="clear"></div>
                    </ul>
                </div>
                <div class="right fr">
                    <div class="gouwuche fr"><a href="">购物车</a></div>
                    <div class="fr">
                        <ul>
                            <li><a href="./login.html" target="_blank">登录</a></li>
                            <li>|</li>
                            <li><a href="./register.html" target="_blank" >注册</a></li>
                            <li>|</li>
                            <li><a href="dingdanzhongxin.html">我的订单</a></li>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </header>

        <!-- start banner_x -->
        <div class="banner_x center" id="banner" >
            <a href="./index.html" target="_blank"><div class="logo fl"></div></a>
            <a href=""><div class="ad_top fl"></div></a>
            <div class="nav fl">
                <ul id="nine">
                    <%--数据九条--%>
                </ul>
            </div>
            <div class="search fr" id="ss">
                <form action="" method="post">
                    <div class="text fl" >
                        <input type="text" class="shuru"  placeholder="请输入搜索">
                    </div>
                    <%-- todo 搜索 待定--%>
                    <div class="submit fl">
                        <input type="submit" class="sousuo" value="搜索"/>
                    </div>
                    <div class="clear"></div>
                </form>
                <div class="clear"></div>
            </div>
        </div>

</body>
</html>
