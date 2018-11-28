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
