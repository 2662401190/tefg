<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: 曾敬伟
  Date: 2018/11/24
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/images/logo.png" type="image/x-icon" rel="shortcut icon" />
    <title>电商-个人中心</title>
    <link rel="stylesheet" type="text/css" href="/css/portal/order.css">
    <link rel="stylesheet" type="text/css" href="/css/portal/style.css">
    <%
        request.setAttribute("path", request.getContextPath());
    %>
    <script src="http://libs.baidu.com/jquery/1.8.0/jquery.js"></script>
    <%--<script src="/js/jquery.min.js"></script>--%>
    <script src="/js/portal/order-form.js"></script>

    <script>

        $.ajax({
            url:"${path}/order/list.do?",
            type:"GET",
            //data:data,
            success: function (result) {


                var orders=result.data.list;
                $.each(orders,function (index,order) {


                    var orderName;
                    var createTime = $("<td class='ddsj'>"+order.createTime+"</td>");
                    var orderNo= $("<td class='spdd'>"+"订单号:"+order.orderNo+"</td>");
                    var payment= $("<td class='zje'>"+"￥"+order.payment+"</td>");
                    var cksp = $("<td class='cksp'>订单详情</td>");
                    var shanchu= $("<td class='scsp'>删除</td>");
                    var statusDesc = $("<td class='jyzta'>"+"交易状态:"+order.statusDesc+"</td>");
                    var hezi= $("<div class='hezijj'></div>");

                    var orderTr = $("<div class='spdh'></div>").append(createTime).append(orderNo)
                        .append(statusDesc).append(payment).append(cksp).append(shanchu);

                    hezi.appendTo($("#ddyq tbody")).append(orderTr);
                    $.each(order.orderItemVoList,function(index,imageItem){

                        var tpdz= $("<td class='tpdza'><img src='/image/peijian6.png' class='tpwz'></td>")
                        var productName= $("<td class='spmca' >"+imageItem.productName+"</td>");
                        var currentUnitPrice= $("<td class='spdj'>"+"￥"+imageItem.currentUnitPrice+"</td>");
                        var quantity= $("<td class='spdj'>"+imageItem.quantity+"</td>");
                        var totalPrice= $("<td class='spdj'>"+"￥"+imageItem.totalPrice+"</td>");
                        var orderdetails= $("<td class='spdj'>查看商品</td>");
                        var byuagain= $("<td class='spdj'>再次购买</td>");

                        orderName=$("<tr class='ddfl'></tr>").append(tpdz).append(productName).append(currentUnitPrice)
                            .append(quantity).append(totalPrice).append(orderdetails).append(byuagain)

                        hezi.appendTo($("#ddyq tbody")).append(orderName);
                    })

                });

            }
        });








    </script>
</head>
<body>
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
                <li>|</li>
                <li><a href="">MIUI</a></li>
                <li>|</li>
                <li><a href="">米聊</a></li>
                <li>|</li>
                <li><a href="">游戏</a></li>
                <li>|</li>
                <li><a href="">多看阅读</a></li>
                <li>|</li>
                <li><a href="">云服务</a></li>
                <li>|</li>
                <li><a href="">金融</a></li>
                <li>|</li>
                <li><a href="">小米商城移动版</a></li>
                <li>|</li>
                <li><a href="">问题反馈</a></li>
                <li>|</li>
                <li><a href="">Select Region</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <div class="gouwuche fr"><a href="">我的订单</a></div>
            <div class="fr">
                <ul id="">
                    <li><a href="/view/user-login.jsp" target="_blank">登录</a></li>
                    <li>|</li>
                    <li><a href="./register.html" target="_blank" >注册</a></li>
                    <li>|</li>
                    <li><a href="./self_info.html">个人中心</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<!--end header -->
<!-- start banner_x -->
<div class="banner_x center">
    <a href="./index.html" target="_blank"><div class="logo fl"></div></a>
    <a href=""><div class="ad_top fl"></div></a>
    <div class="nav fl">
        <ul>
            <li><a href="">小米手机</a></li>
            <li><a href="">红米</a></li>
            <li><a href="">平板·笔记本</a></li>
            <li><a href="">电视</a></li>
            <li><a href="">盒子·影音</a></li>
            <li><a href="">路由器</a></li>
            <li><a href="">智能硬件</a></li>
            <li><a href="">服务</a></li>
            <li><a href="">社区</a></li>
        </ul>
    </div>
    <div class="search fr">
        <form action="" method="post">
            <div class="text fl">
                <input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
            </div>
            <div class="submit fl">
                <input type="submit" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>
</div>
<!-- end banner_x -->
<!-- self_info -->
<div class="grzxbj">
    <div class="selfinfo center">
        <div class="lfnav fl">
            <div class="ddzx">订单中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
                    <li><a href="">意外保</a></li>
                    <li><a href="">团购订单</a></li>
                    <li><a href="">评价晒单</a></li>
                </ul>
            </div>
            <div class="ddzx">个人中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="./self_info.html">我的个人中心</a></li>
                    <li><a href="">消息通知</a></li>
                    <li><a href="">优惠券</a></li>
                    <li><a href="">收货地址</a></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="ddzxbt">交易订单</div>

            <table id="orderTable" >
                <tr class="order">
                    <td class="baby">宝贝</td>
                    <td class="dj">单价</td>
                    <td class="sl">数量</td>
                    <td class="sfk">总金额</td>
                    <td class="jyzt">交易状态</td>
                    <td class="jycz">交易操作</td>
                </tr>
            </table>
            <div id="ddyq">

                    <table class="spmc" cellpadding="10px">
                        <tbody>

                        </tbody>
                    </table>

            </div>




        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- self_info -->

<footer class="mt20 center">
    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>
</body>



</body>
</html>
