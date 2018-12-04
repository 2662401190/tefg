<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 曾敬伟
  Date: 2018/11/24
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="/images/logo.png" type="image/x-icon" rel="shortcut icon"/>
    <title>电商-个人中心</title>

    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/portal/order.css">
    <link rel="stylesheet" type="text/css" href="/css/portal/style.css">
    <link rel="stylesheet" type="text/css" href="/layui/layui/css/layui.css">
    <script src="/layui/layui/layui.js" charset="utf-8"></script>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/portal/order-form.js"></script>


    <%
        request.setAttribute("path", request.getContextPath());
    %>




    <script>
        $(function () {
            //去首页
            to_page(1);
        });
        
        function to_page(pageNum) {
            $.ajax({
                url:"/order/list.do",
                data:"pageNum="+pageNum,
                type:"POST",
                success:function (result) {

                    build_order_table(result);
                    //解析显示分页信息
                   /* build_page_info(result);*/
                    //解析显示分页条
                    build_page_nav(result);
                }
            }) ;
        }

        function build_order_table(result) {
            //构建之前,清空table表格
            $("#shuchu").empty();
            var orders=result.data.list;
            $.each(orders,function (index,order) {

                var zfdda= $("<button>支付订单</button>").addClass("layui-btn layui-btn-danger");
                var form=$("<form method=\"post\" action=\"/porde/pay.do\"></form>")
                    .append($("<input type='text' name=\"orderNo\" value='"+order.orderNo+"' style='display: none!important;' >"))
                    .append(zfdda);

                var zfdd= $("<td></td>").addClass("zfdd").append(form);
                var qxdda= $("<button id='ddys'>取消订单</button>").addClass("layui-btn layui-btn-normal");
                var qxdd= $("<td></td>").addClass("qxdd").append(qxdda);

                var ddzje= $("<td>￥</td>").append(order.payment).addClass("ddzje");
                var jyztspan= $("<span></span>").append(order.statusDesc).addClass("jyztspan")
                var zfzt= $("<td>交易状态:</td>").addClass("zfzt").append(jyztspan);
                var ddh= $("<td id='zz'>订单号:</td>").append(order.orderNo).addClass("ddh").attr("zz",order.orderNo);
                var sj= $("<td></td>").append(order.createTime).addClass("sj");


                if(order.statusDesc == "未支付"){
                    var spbqa= $("<tr></tr>").append(sj).append(ddh).append(zfzt)
                        .append(ddzje).append(qxdd).append(zfdd);
                }else {
                    var spbqa= $("<tr></tr>").append(sj).append(ddh).append(zfzt)
                        .append(ddzje).append(qxdd);
                }

                var spbq= $("<table></table>").addClass("spbq").append(spbqa);
                var hezi= $("<div></div>").addClass("hezi").append(spbq);
                var biankuang= $("<div></div>").addClass("biankuang").append(hezi);

                $.each(order.orderItemVoList,function (index,list) {

                    var zzcgb= $("<button>再次购买</button>").addClass("layui-btn layui-btn-danger");
                    var zzcga= $("<td></td>").addClass("zzcg").append(zzcgb);
                    var ckspa= $("<button>查看商品</button>").addClass("layui-btn layui-btn-normal");
                    var cksp= $("<td></td>").addClass("cksp").append(ckspa);

                    var spjg= $("<td>￥</td>").addClass("spjg").append(list.totalPrice);
                    var spsl= $("<td></td>").addClass("spsl").append(list.quantity);
                    var spdj= $("<td>￥</td>").addClass("spdj").append(list.currentUnitPrice);
                    var spmz= $("<td></td>").addClass("spmz").append(list.productName);

                    var zzcg= $("<img src=\"/images/logo.png\">").addClass("tupian");
                    var tphezi= $("<td></td>").addClass("tphezi").append(zzcg);
                    var juzhong= $("<tr></tr>").addClass("juzhong").append(tphezi)
                        .append(spmz).append(spdj).append(spsl).append(spjg)
                        .append(cksp).append(zzcga);
                    var sphezi= $("<table></table>").addClass("sphezi").append(juzhong);
                    var spbk= $("<div></div>").addClass("spbk").append(sphezi);
                    biankuang.append(spbk);
                })

                biankuang.appendTo("#shuchu");


            })

        }

        //解析显示分页信息
       /* function build_page_info(result) {
            $(".fenyexinxi").empty();
            $(".fenyexinxi").append("当前"+result.data.pageNum+"页,总"
                +result.data.pages+"页,总"+result.data.total+"条记录");
        }*/


        //解析显示分页条,点击分页到下一页
        function build_page_nav(result) {

            $(".fenye").empty();
            var ul= $("<ul></ul>").addClass("pagination");

            //构建元素
            var firstPageLi= $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
            var prePageLi= $("<li></li>").append($("<a></a>").append("&laquo;"));
            //没有前一页就不能点击首页和上一页
            if(result.data.hasPreviousPage == false){
                firstPageLi.addClass("disabled");
                prePageLi.addClass("disabled");
            }else {
                //为元素添加点击翻页的事件
                firstPageLi.click(function () {
                    to_page(1);
                });
                prePageLi.click(function () {
                    to_page(result.data.pageNum -1);
                });
            }


            var nextPageLi= $("<li></li>").append($("<a></a>").append("&raquo;"));
            var lastPageLi= $("<li></li>").append($("<a></a>").append("尾页").attr("href","#"));
            //没有下一页就不能点击尾页和下一页
            if(result.data.hasNextPage == false){
                nextPageLi.addClass("disabled");
                lastPageLi.addClass("disabled");
            }else {
                nextPageLi.click(function () {
                    to_page(result.data.pageNum +1);
                });
                lastPageLi.click(function () {
                    to_page(result.data.pages);
                });
            }



            //添加首页和前一页的提示
            ul.append(firstPageLi).append(prePageLi);

            //遍历给ul中添加页码提示 navigatepageNums当前导航页
            $.each(result.data.navigatepageNums,function (index,item) {

                var numLi= $("<li></li>").append($("<a></a>").append(item));
                if(result.data.pageNum == item){
                    numLi.addClass("active");
                }
                numLi.click(function () {
                    to_page(item);
                });
                ul.append(numLi);
            })
            //添加下一页和尾页的提示
            ul.append(nextPageLi).append(lastPageLi);
            //把ul加入到nav
            var navEle= $("<nav></nav>").append(ul);
            navEle.appendTo(".fenye");

        }

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
                    <li><a href="./register.html" target="_blank">注册</a></li>
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
    <a href="./index.html" target="_blank">
        <div class="logo fl"></div>
    </a>
    <a href="">
        <div class="ad_top fl"></div>
    </a>
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
                <input type="text" class="shuru" placeholder="小米6&nbsp;小米MIX现货">
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

            <div class="btys">
                <table id="orderTable" class="spmc">
                    <tr class="order">
                        <td class="baby">宝贝</td>
                        <td class="dj">单价</td>
                        <td class="sl">数量</td>
                        <td class="sfk">总金额</td>
                        <td class="jycz">操作</td>
                    </tr>
                </table>
            </div>

            <div id="shuchu"></div>
            <%--<div class="fenyexinxi"></div>--%>
            <div class="fenye"></div>

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


</html>
