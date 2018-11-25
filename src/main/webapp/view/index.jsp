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
</head>
<body>

<jsp:include page="navigation.jsp"/>
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

       </div>
   </div>
    <div id="lbt" style="z-index: 1" >
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
    <div id="three">

    </div>
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
    <div class="pictran"  style="position: relative;">
        <!--图片更换-->


    </div>
</div>


<!-- start danpin -->
<div class="danpin center">
    <div class="biaoti center">数码明星单品</div>
    <div class="main center">


    </div>
</div>
<%--<div class="peijian w">--%>
    <%--<div class="biaoti center">配件</div>--%>
    <%--<div class="main center">--%>
        <%--<div class="content">--%>
            <%--<div class="remen fl"><a href=""><img src="./image/peijian1.jpg"></a>--%>
            <%--</div>--%>
            <%--<div class="remen fl">--%>
                <%--<div class="xinpin"><span>新品</span></div>--%>
                <%--<div class="tu"><a href=""><img src="./image/peijian2.jpg"></a></div>--%>
                <%--<div class="miaoshu"><a href="">小米6 硅胶保护套</a></div>--%>
                <%--<div class="jiage">49元</div>--%>
                <%--<div class="pingjia">372人评价</div>--%>
                <%--<div class="piao">--%>
                    <%--<a href="">--%>
                        <%--<span>发货速度很快！很配小米6！</span>--%>
                        <%--<span>来至于mi狼牙的评价</span>--%>
                    <%--</a>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="remen fl">--%>
                <%--<div class="xinpin"><span style="background:#fff"></span></div>--%>
                <%--<div class="tu"><a href=""><img src="./image/peijian3.jpg"></a></div>--%>
                <%--<div class="miaoshu"><a href="">小米手机4c 小米4c 智能</a></div>--%>
                <%--<div class="jiage">29元</div>--%>
                <%--<div class="pingjia">372人评价</div>--%>
            <%--</div>--%>
            <%--<div class="remen fl">--%>
                <%--<div class="xinpin"><span style="background:red">享6折</span></div>--%>
                <%--<div class="tu"><a href=""><img src="./image/peijian4.jpg"></a></div>--%>
                <%--<div class="miaoshu"><a href="">红米NOTE 4X 红米note4X</a></div>--%>
                <%--<div class="jiage">19元</div>--%>
                <%--<div class="pingjia">372人评价</div>--%>
                <%--<div class="piao">--%>
                    <%--<a href="">--%>
                        <%--<span>发货速度很快！很配小米6！</span>--%>
                        <%--<span>来至于mi狼牙的评价</span>--%>
                    <%--</a>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="remen fl">--%>
                <%--<div class="xinpin"><span style="background:#fff"></span></div>--%>
                <%--<div class="tu"><a href=""><img src="./image/peijian5.jpg"></a></div>--%>
                <%--<div class="miaoshu"><a href="">小米支架式自拍杆</a></div>--%>
                <%--<div class="jiage">89元</div>--%>
                <%--<div class="pingjia">372人评价</div>--%>
                <%--<div class="piao">--%>
                    <%--<a href="">--%>
                        <%--<span>发货速度很快！很配小米6！</span>--%>
                        <%--<span>来至于mi狼牙的评价</span>--%>
                    <%--</a>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="clear"></div>--%>
        <%--</div>--%>
        <%--<div class="content">--%>
            <%--<div class="remen fl"><a href=""><img src="./image/peijian6.png"></a>--%>
            <%--</div>--%>
            <%--<div class="remen fl">--%>
                <%--<div class="xinpin"><span style="background:#fff"></span></div>--%>
                <%--<div class="tu"><a href=""><img src="./image/peijian7.jpg"></a></div>--%>
                <%--<div class="miaoshu"><a href="">小米指环支架</a></div>--%>
                <%--<div class="jiage">19元</div>--%>
                <%--<div class="pingjia">372人评价</div>--%>
                <%--<div class="piao">--%>
                    <%--<a href="">--%>
                        <%--<span>发货速度很快！很配小米6！</span>--%>
                        <%--<span>来至于mi狼牙的评价</span>--%>
                    <%--</a>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="remen fl">--%>
                <%--<div class="xinpin"><span style="background:#fff"></span></div>--%>
                <%--<div class="tu"><a href=""><img src="./image/peijian8.jpg"></a></div>--%>
                <%--<div class="miaoshu"><a href="">米家随身风扇</a></div>--%>
                <%--<div class="jiage">19.9元</div>--%>
                <%--<div class="pingjia">372人评价</div>--%>
            <%--</div>--%>
            <%--<div class="remen fl">--%>
                <%--<div class="xinpin"><span style="background:#fff"></span></div>--%>
                <%--<div class="tu"><a href=""><img src="./image/peijian9.jpg"></a></div>--%>
                <%--<div class="miaoshu"><a href="">红米4X 高透软胶保护套</a></div>--%>
                <%--<div class="jiage">59元</div>--%>
                <%--<div class="pingjia">775人评价</div>--%>
            <%--</div>--%>
            <%--<div class="remenlast fr">--%>
                <%--<div class="hongmi"><a href=""><img src="./image/hongmin4.png" alt=""></a></div>--%>
                <%--<div class="liulangengduo"><a href=""><img src="./image/liulangengduo.png" alt=""></a></div>--%>
            <%--</div>--%>
            <%--<div class="clear"></div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<footer class="mt20 center">
    <div class="mt20">TEFG商城|服装城|米聊|多看书城|tefg路由器|视频电话|tefg天猫店|tefg淘宝直营店|tefg网盟|tefg移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>
<script>




    $.ajax({
        url: "${path}/product/electronics_top_five.do",
        type: "get",
        success: function (result) {

            console.log(result);

            $.each(result.data,function (index,item) {
            // <div class="mingxing fl" id="electronics">
            //         <div class="sub_mingxing"><a href=""><img src="./image/pinpai5.png" alt=""></a></div>
            //     <div class="pinpai"><a href="">小米笔记本</a></div>
            //     <div class="youhui">更轻更薄，像杂志一样随身携带</div>
            //     <div class="jiage">3599元起</div>
            //     </div>
                // todo  商品详情
                var sub=$("<div>").addClass("sub_mingxing").append($("<a href=''>").append("<img src='"+item.imageHost+"' title='"+item.imageHost+"'>"));
                var pinpai=$("<div>").addClass("pinpai").append("<a href=''> "+item.name+"<a/>");
                var youhui=$("<div> "+item.subtitle+"<div/>").addClass("youhui");
                var jiage=$("<div>"+item.price+"</div>")
                $("#electronics").append(sub).append(pinpai).append(youhui).append(jiage);
            });  
        }
    });

    // 给钱的十件商品
    $.ajax({
        url:"${path}/product/money_ten.do",
        type:"get",
        success: function (result) {
            console.log(result)
            $.each(result.data,function (index,item) {
                // todo 详情
            // <div><img src="/img/T18eLTByKg1RCvBVdK.jpg"><img src="/img/T16wCTBjDg1RCvBVdK.jpeg"></div>
                $(".pictran").append($("<div>").append("<a href=''><img src='"+item.mainImage+"' /></a> ").append("<a href=''><img src='"+item.imageHost+"' /></a>"));
            })
        }
    })

    //三件商品
    $.ajax({
        url:"${path}/product/new_three_product.do",
        type:"get",
        success: function (result) {
            console.log(result);
            $.each(result, function (index, item) {
                // todo  去商品详情
                $("#three").append($("<div>").addClass("datu fl").append($("<a href=''>").append("<img src='"+item.mainImage+"' title='"+item.subtitle+"'>")));
            });
        }
    });
    //查询最后九条数据
    $.ajax({
        url:"${path}/category/category_desc.do",
        type:"get",
        success:function (result) {
            console.log(result);
            $.each(result,function (index,item) {
                $("#nine").append($("<li>").append("<a href='/product/search_two.do?productName="+item.name+"&categoryId="+item.id+"'>"+item.name+"</a>"));
            })
        }
    });
    $("#showDiv").hide();
    //加载数据
    $.ajax({
        url:"${path}/category/get_category_parentId.do",
        type:"get",
        success:function (result) {
            console.log(result);
            $.each(result.data,function (index,item) {
                $("#leftul").append($("<li onmouseover='liover(this)' onmouseleave='liout(this)' >").attr("indexs",index).attr("categoryId",item.id).append("<a href='/product/search.do?productName="+item.name+"&categoryId="+item.id+"'>"+item.name+" </a>"));
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
                $("#showDiv ul").remove();

                $.each(result.data,function (index,item) {
                    $("#showDiv").append($("<ul>").append($("<li>").append("<img src='"+item.img+"'><a href='/product/search_two.do?productName="+item.name+"&categoryId="+item.id+"'>"+item.name+"</a>")));
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
