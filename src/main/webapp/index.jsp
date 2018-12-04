<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

    <form method="post" action="/manage/user/login.do">
        <input type="text" name="username"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="sdf">
    </form>

    前台登录
    <form method="post" action="/user/login.do">
        <input type="text" name="userName"><br>
        <input type="password" name="passWord"><br>
        <input type="submit" value="登录">
    </form>

    <h3>个人中心</h3>
    <form method="post" action="/view/order/list.jsp">

        <input type="submit" value="个人中心">
    </form>


    <h3>创建订单</h3>
    <form method="post" action="/order/create.do">
        <input type="text" name="shippingId">
        <input type="submit" value="创建订单">
    </form>

    <h1>${message}</h1>
    <h3>支付订单</h3>
    <form method="post" action="/order/pay.do">
        <input type="text" name="orderNo">
        <input type="submit" value="创建订单">
    </form>

    <h3>订单详情</h3>
    <form method="post" action="/vied/order/create.jsp">
        <input type="text" name="orderNo">
        <input type="submit" value="订单详情">
    </form>







    mvc 上传文件
    <form method="post" action="/manage/product/product_upload.do" enctype="multipart/form-data" >
        <input  type="file" name="upload_file"/>
        <input type="submit" value="上传文件">
    </form>
    <br>








富文本
<form method="post" action="/manage/product/richtext_img_upload.do" enctype="multipart/form-data" >
    <input  type="file" name="upload_file"/>
    <input type="submit" value="富文本上传">
</form>
<br>




</body>
</html>
