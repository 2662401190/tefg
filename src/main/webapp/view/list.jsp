<%--
  Created by IntelliJ IDEA.
  User: HeWei
  Date: 2018/11/22
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <%
        request.setAttribute("path", request.getContextPath());
    %>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/indexCss/style.css">
</head>
<body>
<!-- start header -->
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="http://www.mi.com/" target="_blank">TEFG商城</a></li>
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
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center" id="banner">
    <a href="./index.html" target="_blank"><div class="logo fl"></div></a>
    <a href=""><div class="ad_top fl"></div></a>
    <div class="nav fl">
        <ul>
            <li><a href="./liebiao.html" target="_blank">服装城</a></li>
            <li><a href="">美妆馆</a></li>
            <li><a href="">平板·笔记本</a></li>
            <li><a href="">家居装</a></li>
            <li><a href="">超市</a></li>
            <li><a href="">全球购</a></li>
            <li><a href="">海外购</a></li>
            <li><a href="">闪购</a></li>
            <li><a href="">社区</a></li>
        </ul>
    </div>
    <div class="search fr">
        <form action="" method="post">
            <div class="text fl">
                <input type="text" class="shuru"  placeholder="请输入搜索">
            </div>

            <div class="submit fl">
                <input type="submit" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>
</div>

<!-- start banner_y -->
<!-- end banner -->
<%-- todo 分页暂时没做--%>
<!-- start danpin -->
<div class="danpin center">

    <div class="biaoti center">${productName}</div>
    <div class="main center">
        
        <c:choose>
            <c:when test="${products.list != null}">
                <c:forEach items="${products.list}" var="p">
                    <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
                        <div class="sub_mingxing"><a href="./xiangqing.html" target="_blank"><img src="${p.mainImage}" title="<c:if test="${p.status eq 0}">已售完</c:if><c:if test="${p.status eq 1}">在售</c:if>"></a></div>
                        <div class="pinpai"><a href="./xiangqing.html" target="_blank">${p.name}</a></div>
                        <div class="youhui">${p.subtitle}</div>
                        <div class="jiage">${p.price}</div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h1> 你搜搜的商品不存在</h1>
            </c:otherwise>
        </c:choose>






    </div>
</div>


<footer class="mt20 center">
    <div class="mt20">TEFG商城|服装城|米聊|多看书城|tefg路由器|视频电话|tefg天猫店|tefg淘宝直营店|tefg网盟|tefg移动|隐私政策|Select Region</div>
    <div>©TEFG.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>

<!-- end danpin -->
</body>
</html>
