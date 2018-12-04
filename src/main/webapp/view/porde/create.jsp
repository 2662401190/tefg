<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 曾敬伟
  Date: 2018/11/30
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付页面</title>
    <link rel="stylesheet" type="text/css" href="/css/portal/zfym.css">
    <link rel="stylesheet" type="text/css" href="/css/portal/style.css">
    <%
        request.setAttribute("path", request.getContextPath());
    %>
    <script src="http://libs.baidu.com/jquery/1.8.0/jquery.js"></script>


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
<div id="dingdan">
    <div class="qrdd">
        <span class="qrddzt">确认订单</span>
    </div>

    <table class="peisong">
        <tr class="peisonga"><td class="fangshi" colspan="5">配送方式</td></tr>
        <tr class="kuidi"><td class="kdys" colspan="2">快递运输</td></tr>
        <tr class="kuidi">
            <td class="pssj" colspan="2">配送时间</td>
            <td class="songhuo" colspan="1">工作日双休日与节假日均可送货</td>
        </tr>
        <tr class="kuidi">
            <td colspan="5"><hr class="hangxian"></td>
        </tr>
        <tr class="kuidi">
            <td class="yunfei" colspan="2">运费险</td>
            <td class="tuihuo" colspan="1">tefg商城七天可换货15天可退货</td>
        </tr>
    </table>
    <div class="shangpin">
        <s:forEach items="${orderDetail.data.orderItemVoList}" var="user">
            <div class="shangpina">
                <table class="shangpinsd">

                    <tr><td class="shangjia" colspan="4">商家:tefg</td></tr>
                    <tr>
                        <td class="shxinxi-tp"> <a href="javascript:void(0)"> <img src="/image/login.index.jpg" class="tpdx"></a></td>
                        <td class="shxinxi-shangping"><a href="javascript:void(0)" class="spmzys">${user.productName}</a></td>
                        <td class="shxinxi-shuliang">￥${user.currentUnitPrice}</td>
                        <td class="shxinxi-jg">件数：${user.quantity}</td>
                    </tr>


                </table>
            </div>
        </s:forEach>
    </div>
    <hr class="fenggexian">
    <div class="ddpg">
        <table>
            <tr>
                <td colspan="1"><span class="fpxi">发票信息</span></td>
                <td colspan="3">开企业抬头发票须填写纳税人识别号,以免影响报销</td>
            </tr>
            <tr >
                <td class="dzpg">电子普通发票</td>
                <td class="gr">个人</td>
                <td class="spmx">商品明细 </td>
                <td class="xiugai">修改</td>
            </tr>
        </table>
    </div>

</div>

<div class="jehezi">

    <table class="shangpingje">
        <tr>
            <td class="mckd">总商品金额:</td>
            <td class="jqkd">￥${orderDetail.data.payment}</td>
        </tr>
        <tr>
            <td class="mckd">返现:</td>
            <td class="jqkd">-￥0.00</td>
        </tr>
        <tr>
            <td class="mckd">运费:</td>
            <td class="jqkd">￥0.00</td>
        </tr>
        <tr>
            <td class="mckd">退换无忧:</td>
            <td class="jqkd">￥0.00</td>
        </tr>
    </table>
    <div class="zhif">
        <div class="fukuanhezi">

            <table class="fkje">
                <tr>
                    <td class="mckda">应付金额:</td>
                    <td class="jqkda">￥${orderDetail.data.payment}</td>
                </tr>
            </table>

            <table class="yfje">
                <tr>
                    <td class="shdz">收货地址:</td>
                    <td class="dzxinxi">
                        ${orderDetail.data.shippingVo.receiverProvince}
                        ${orderDetail.data.shippingVo.receiverCity}
                        ${orderDetail.data.shippingVo.receiverDistrict}
                        ${orderDetail.data.shippingVo.receiverAddress}
                    </td>
                </tr>
                <tr>
                    <td>收货人:</td>
                    <td>
                        ${orderDetail.data.shippingVo.receiverName}tikgvvvvvvvvuv
                        ${orderDetail.data.shippingVo.receiverMobile}
                    </td>
                </tr>
            </table>


        </div>
    </div>
    <div id="xyb">
        <form action="/order/pay.do" method="post">
            <input type="text" name="orderNo" value="${orderDetail.data.orderNo}" style="display: none!important;">
            <input type="submit" value="支付订单" class="xybb">
        </form>


    </div>


</div>


<footer class="mt20 center">
    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>


</body>
</html>
