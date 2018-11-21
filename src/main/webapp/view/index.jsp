<%--
  Created by IntelliJ IDEA.
  User: HeWei
  Date: 2018/11/19
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style>

    </style>
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
<!-- end banner_x -->

<!-- start banner_y -->
<div class="banner_y center" style="position:relative;">
    <!--伦坡图****************************************-->
   <div id="hideDiv" onmouseleave="divout(this)">
       <!--这里是一级的导航图-->
       <div id="left" >
           <ul id="leftul" >

           </ul>
       </div>
       <!--这里显示二级的导航图
       -->
       <div id="showDiv" divindex="-1" onmouseover="showDivOver(this)" onmouseleave="showDivLeave(this)" style="position: absolute;left:232px;z-index: 555;width: 500px;height: 460px;background-color: white">
            <ul id="sp">

            </ul>
       </div>
   </div>
    <div id="lbt" style="z-index: 10" >
        <ul id="one" >
            <li style="opacity: 1; display: none;">
                <a href=""><img src="/img/lunbo1.jpg" ></a>
            </li>
            <li style="opacity: 1; display: none;">
                <a href=""><img src="/img/lunbo2.jpg"></a>
            </li>
            <li style="opacity: 1; display: none;">
                <a href=""><img src="/img/lunbo3.jpg"></a>
            </li>
            <li style="opacity: 1; display: list-item;">
                <a href=""><img src="/img/lunbo4.jpg"></a>
            </li>
            <li style="opacity: 1; display: none;">
                <a href=""><img src="/img/lunbo5.jpg"></a>
            </li>
        </ul>
        <ul id="two">
            <li class="on">1</li>
            <li class="">2</li>
            <li class="">3</li>
            <li class="">4</li>
            <li class="">5</li>
        </ul>

    </div>
</div>
    <%--<div id="show">
    </div>--%>
    <!--这里是轮播的图片，样式-->



<!--下面的伦坡图样式-->
<div class="sub_banner center">
    <div class="sidebar fl">
        <div class="fl"><a href=""><img src="./image/hjh_01.gif"></a></div>
        <div class="fl"><a href=""><img src="./image/hjh_02.gif"></a></div>
        <div class="fl"><a href=""><img src="./image/hjh_03.gif"></a></div>
        <div class="fl"><a href=""><img src="./image/hjh_04.gif"></a></div>
        <div class="fl"><a href=""><img src="./image/hjh_05.gif"></a></div>
        <div class="fl"><a href=""><img src="./image/hjh_06.gif"></a></div>
        <div class="clear"></div>
    </div>
    <!--<div class="datu fl"><a href=""><img src="./image/hongmi4x.png" alt=""></a></div>
    <div class="datu fl"><a href=""><img src="./image/xiaomi5.jpg" alt=""></a></div>
    <div class="datu fr"><a href=""><img src="./image/pinghengche.jpg" alt=""></a></div>-->

    <div id="centwo">
        <div class="slider clearfix" style="position: relative;">
            <ul class="slider-main" data-lazyload-fn="done" style="width: 6000px;  position: absolute;">
                <li class="slider-panel fore4" style="float: left; display: list-item;" data-switchable-clone="1">
                    <div class="fore1">
                        <a href="#">
                            <img data-lazy-img="done" width="250px" height="264" src="/img/56cc2972Nd3c58b17.jpg" class="">
                        </a>
                    </div>
                    <div class="fore2">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56cc2a94Ne97db95a.jpg" class="">
                        </a>
                    </div>
                    <div class="fore3">
                        <a href="#"><img data-lazy-img="done" width="250" height="264" src="/img/5510d809N70c3eb71.jpg" class="">                                    </a>
                    </div>
                    <div class="fore4">
                        <a href="#"><img data-lazy-img="done" width="250" height="264" src="/img/56cd812eNa0c82edd.jpg" class="">                                    </a>
                    </div>
                </li>
                <li class="slider-panel fore1 ui-switchable-panel-selected" style="float: left; display: list-item;">
                    <div class="fore1">
                        <a href="#" target="_blank">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56c6d8ccN7258f6ab.jpg" class="">                                    </a>
                    </div>
                    <div class="fore2" data-source="2" clstag="h|keycount|2015|11c02">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56cd14b3N935ecf9b.jpg" class="">                                    </a>
                    </div>
                    <div class="fore3" data-source="2" clstag="h|keycount|2015|11c03">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56cab9a6N0691903e.jpg" class="">                                    </a>
                    </div>
                    <div class="fore4" data-source="2" clstag="h|keycount|2015|11c04">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56ce9dceN61e549d4.jpg" class="">                                    </a>
                    </div>
                </li>
                <li class="slider-panel fore2" style="float: left; display: list-item;">
                    <div class="fore1">
                        <a href="">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56c67930Nc3e724b8.jpg" class="">                                    </a>
                    </div>
                    <div class="fore2">
                        <a href="" target="_blank">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56c6d936N0b16afd4.jpg" class="">                                    </a>
                    </div>
                    <div class="fore3" data-source="3" clstag="h|keycount|2015|11c07">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56c6b8b3Nfc9e3f91.jpg" class="">                                    </a>
                    </div>
                    <div class="fore4" data-source="3" clstag="h|keycount|2015|11c08">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56c2d4f5Nb5b12e5e.jpg" class="">                                    </a>
                    </div>
                </li>
                <li class="slider-panel fore3" style="float: left; display: list-item;">
                    <div class="fore1">
                        <a href="" target="_blank">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56cbfe05N09f9352a.jpg" class="">                                    </a>
                    </div>
                    <div class="fore2">
                        <a href="" target="_blank">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56c6bfefN0f89bdde.jpg" class="">                                    </a>
                    </div>
                    <div class="fore3" data-source="3" clstag="h|keycount|2015|11c11">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56cc3414N0ef21671.jpg" class="">                                    </a>
                    </div>
                    <div class="fore4" data-source="3" clstag="h|keycount|2015|11c12">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/5510e394N7d91092f.jpg" class="">                                    </a>
                    </div>
                </li>
                <li class="slider-panel fore4" style="float: left; display: list-item;">
                    <div class="fore1">
                        <a href="" target="_blank">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56cc2972Nd3c58b17.jpg" class="">                                    </a>
                    </div>
                    <div class="fore2">
                        <a href="" target="_blank">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56cc2a94Ne97db95a.jpg" class="">                                    </a>
                    </div>
                    <div class="fore3" data-source="3" clstag="h|keycount|2015|11c15">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/5510d809N70c3eb71.jpg" class="">                                    </a>
                    </div>
                    <div class="fore4" data-source="3" clstag="h|keycount|2015|11c16">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56cd812eNa0c82edd.jpg" class="">                                    </a>
                    </div>
                </li>
                <li class="slider-panel fore1" style="float: left; display: list-item;" data-switchable-clone="1">
                    <div class="fore1">
                        <a href="" target="_blank">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56c6d8ccN7258f6ab.jpg" class="">                                    </a>
                    </div>
                    <div class="fore2" data-source="2" clstag="h|keycount|2015|11c02">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56cd14b3N935ecf9b.jpg" class="">                                    </a>
                    </div>
                    <div class="fore3" data-source="2" clstag="h|keycount|2015|11c03">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56cab9a6N0691903e.jpg" class="">                                    </a>
                    </div>
                    <div class="fore4" data-source="2" clstag="h|keycount|2015|11c04">
                        <a href="#">
                            <img data-lazy-img="done" width="250" height="264" src="/img/56ce9dceN61e549d4.jpg" class="">                                    </a>
                    </div>
                </li>
            </ul>
            <div class="slider-page">
                <a href="javascript:void(0)" class="slider-prev" clstag="h|keycount|2015|11b1">&lt;</a>
                <a href="javascript:void(0)" class="slider-next" clstag="h|keycount|2015|11b2">&gt;</a>
            </div>
        </div></div>
    <div class="clear"></div>
</div>

<!--今日推荐-->
<div class="divctr1" style="position: relative;">
    <div class="divctr-h1">推荐 · 商品<font>CRAKING</font>
        <div class="div1" ></div>
        <div class="div2" ></div>
        <div class="div3" ></div>
        <div class="div4" ></div>
        <div class="div5" ></div>
        <div class="dvirctr-x">换一批！</div>
    </div>
    <div class="pictran" style="position: relative;">
        <!--图片更换-->
        <div><img src="/img/T18eLTByKg1RCvBVdK.jpg"><img src="/img/T16wCTBjDg1RCvBVdK.jpeg"></div>
        <div><img src="/img/T1gVVTBjJv1RCvBVdK.jpeg"><img src="/img/T13dWTBb_v1RCvBVdK.jpeg"></div>
        <div><img src="/img/T1T.JTB5Jv1RCvBVdK.jpeg"><img src="/img/T1AGCTBQAT1RCvBVdK.jpeg"></div>
        <div><img src="/img/T1SkxTBvx_1RCvBVdK.jpeg"><img src="/img/T1J9JTB7Yv1RCvBVdK.jpg"></div>
        <div><img src="/img/T1kmbTB5dT1RCvBVdK.jpeg"><img src="/img/T1onhTB4hv1RCvBVdK.jpg"></div>
        <span class="custom">
			</span>
    </div>
</div>

<!-- end banner -->
<div class="tlinks">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>

<!-- start danpin -->
<div class="danpin center">

    <div class="biaoti center">小米明星单品</div>
    <div class="main center">
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="./image/pinpai1.png" alt=""></a></div>
            <div class="pinpai"><a href="">小米MIX</a></div>
            <div class="youhui">5月9日-21日享花呗12期分期免息</div>
            <div class="jiage">3499元起</div>
        </div>
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="./image/pinpai2.png" alt=""></a></div>
            <div class="pinpai"><a href="">小米5s</a></div>
            <div class="youhui">5月9日-10日，下单立减200元</div>
            <div class="jiage">1999元</div>
        </div>
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="./image/pinpai3.png" alt=""></a></div>
            <div class="pinpai"><a href="">小米手机5 64GB</a></div>
            <div class="youhui">5月9日-10日，下单立减100元</div>
            <div class="jiage">1799元</div>
        </div>
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="./image/pinpai4.png" alt=""></a></div>
            <div class="pinpai"><a href="">小米电视3s 55英寸</a></div>
            <div class="youhui">5月9日，下单立减200元</div>
            <div class="jiage">3999元</div>
        </div>
        <div class="mingxing fl">
            <div class="sub_mingxing"><a href=""><img src="./image/pinpai5.png" alt=""></a></div>
            <div class="pinpai"><a href="">小米笔记本</a></div>
            <div class="youhui">更轻更薄，像杂志一样随身携带</div>
            <div class="jiage">3599元起</div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="peijian w">
    <div class="biaoti center">配件</div>
    <div class="main center">
        <div class="content">
            <div class="remen fl"><a href=""><img src="./image/peijian1.jpg"></a>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span>新品</span></div>
                <div class="tu"><a href=""><img src="./image/peijian2.jpg"></a></div>
                <div class="miaoshu"><a href="">小米6 硅胶保护套</a></div>
                <div class="jiage">49元</div>
                <div class="pingjia">372人评价</div>
                <div class="piao">
                    <a href="">
                        <span>发货速度很快！很配小米6！</span>
                        <span>来至于mi狼牙的评价</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src="./image/peijian3.jpg"></a></div>
                <div class="miaoshu"><a href="">小米手机4c 小米4c 智能</a></div>
                <div class="jiage">29元</div>
                <div class="pingjia">372人评价</div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:red">享6折</span></div>
                <div class="tu"><a href=""><img src="./image/peijian4.jpg"></a></div>
                <div class="miaoshu"><a href="">红米NOTE 4X 红米note4X</a></div>
                <div class="jiage">19元</div>
                <div class="pingjia">372人评价</div>
                <div class="piao">
                    <a href="">
                        <span>发货速度很快！很配小米6！</span>
                        <span>来至于mi狼牙的评价</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src="./image/peijian5.jpg"></a></div>
                <div class="miaoshu"><a href="">小米支架式自拍杆</a></div>
                <div class="jiage">89元</div>
                <div class="pingjia">372人评价</div>
                <div class="piao">
                    <a href="">
                        <span>发货速度很快！很配小米6！</span>
                        <span>来至于mi狼牙的评价</span>
                    </a>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="content">
            <div class="remen fl"><a href=""><img src="./image/peijian6.png"></a>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src="./image/peijian7.jpg"></a></div>
                <div class="miaoshu"><a href="">小米指环支架</a></div>
                <div class="jiage">19元</div>
                <div class="pingjia">372人评价</div>
                <div class="piao">
                    <a href="">
                        <span>发货速度很快！很配小米6！</span>
                        <span>来至于mi狼牙的评价</span>
                    </a>
                </div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src="./image/peijian8.jpg"></a></div>
                <div class="miaoshu"><a href="">米家随身风扇</a></div>
                <div class="jiage">19.9元</div>
                <div class="pingjia">372人评价</div>
            </div>
            <div class="remen fl">
                <div class="xinpin"><span style="background:#fff"></span></div>
                <div class="tu"><a href=""><img src="./image/peijian9.jpg"></a></div>
                <div class="miaoshu"><a href="">红米4X 高透软胶保护套</a></div>
                <div class="jiage">59元</div>
                <div class="pingjia">775人评价</div>
            </div>
            <div class="remenlast fr">
                <div class="hongmi"><a href=""><img src="./image/hongmin4.png" alt=""></a></div>
                <div class="liulangengduo"><a href=""><img src="./image/liulangengduo.png" alt=""></a></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<footer class="mt20 center">
    <div class="mt20">TEFG商城|服装城|米聊|多看书城|tefg路由器|视频电话|tefg天猫店|tefg淘宝直营店|tefg网盟|tefg移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>

<script>

    $("#showDiv").hide();

    //加载数据
    $.ajax({
        url:"${path}/category/get_category_parentId.do",
        type:"get",
        success:function (result) {
            console.log(result);


            $.each(result.data,function (index,item) {
                // todo 跳转
                $("#leftul").append($("<li onmouseover='liover(this)' onmouseleave='liout(this)' >").attr("indexs",index).attr("categoryId",item.id).append("<a href=''>"+item.name+" </a>"));
            })
        }
    });

    //分类数据
    function getfl(categoryId){

        $.ajax({
            url:"${path}/category/get_category_id.do",
            type:"get",
            data:"categoryId="+categoryId,
            success: function (result) {
                console.log(result);
                $("#sp li").remove();
                $.each(result.data,function (index,item) {

                    // todo  跳转
                    $("#sp").append($("<li>").append("<a href=''>"+item.name+"</a>"));
                })

                

            }
        });
    }
    function liover(data) {


        $("#showDiv").attr("divindex",$(data).attr("indexs"));
        $(data).css("background-color","#FF5A0B");
        $("#showDiv").css("display","block");
        var categoryId=$(data).attr("categoryid");
        getfl(categoryId);

    }

    function showDivLeave(data) {
        $.each($("#leftul li"),function () {
            $(this).css("background-color","black");
        })
    }
    function showDivOver(data) {
        $.each($("#leftul li"),function () {
            $(this).css("background-color","black");
        })
        var index = $(data).attr("divIndex");
        $("li[indexs="+index+"]").css("background-color","#FF5A0B");
    }
    function liout(data) {
        $(data).css("background-color","black");
    }
    function divout(data) {
        $.each($("#leftul li"),function () {
            $(this).css("background-color","black");
        })
        $("#showDiv").attr("divindex",$(data).attr("indexs"));
        $("#showDiv").css("display","none")
    }

</script>
</body>
</html>