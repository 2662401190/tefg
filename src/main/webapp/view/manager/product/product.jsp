<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\10\15 0015
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/main.css">
    <link rel="stylesheet" href="${APP_PATH}/css/pagination.css">
    <style>
        .tree li {
            list-style-type: none;
            cursor:pointer;
        }
        table tbody tr:nth-child(odd){background:#F4F4F4;}
        table tbody td:nth-child(even){color:#C00;}
    </style>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="#">TFG - 用户维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <jsp:include page="/view/manager/common/top.jsp"/>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>
<%--<jsp:include page="/common/top.jsp"></jsp:include>--%>
<%--<%@include file="/common/top.jsp"%>--%>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="tree">
                <jsp:include page="/view/manager/common/menu.jsp"/>
            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input class="form-control has-success" id="queryText" type="text" placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button id="queryBtn" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
                    </form>
                    <button id="deleteBatchBtn" type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
                    <button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='${APP_PATH}/user/toAdd.htm'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr >
                                <th width="30">#</th>
                                <th width="30"><input type="checkbox" id="check_all"></th>
                                <th>账号</th>
                                <th>邮箱地址</th>
                                <th>电话号码</th>
                                <th width="150">操作</th>
                            </tr>
                            </thead>
                            <tbody>


                            </tbody>
                            <tfoot>
                            <tr >
                                <td colspan="6" align="center">
                                    <%--<ul class="pagination">--%>

                                    <%--</ul>--%>
                                        <div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
                                </td>
                            </tr>

                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/script/docs.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/jquery/layer/layer.js"></script>
<script src="${APP_PATH}/jquery/pagination/jquery.pagination.js"></script>

<script type="text/javascript">
    $(function () {
        $(".list-group-item").click(function(){
            if ( $(this).find("ul") ) {
                $(this).toggleClass("tree-closed");
                if ( $(this).hasClass("tree-closed") ) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });
        showMenu();
        queryUserPage(0);
    });


        var jsonobj={
            "pageno":1,
            "pagesize":10
        }
        var loadingIndex;
        function queryUserPage(pageIndex) {
            jsonobj.pageno=pageIndex+1;
            $.ajax({
                type:"POST",
                data:jsonobj,
                url:"${APP_PATH}/user/index.do",
                beforeSend:function () {
                    loadingIndex=layer.load(2,{time:10*1000});
                    return true;
                },
                success:function (result) {
                    layer.close(loadingIndex);
                    if(result.success){
                        var page=result.page;
                        var datas=page.datas;

                        //定义数据表
                        var content="";
                        $.each(datas,function (i,user) {
                           content+='<tr>';
                           content+='<td>'+(i+1)+'</td>';
                           content+='<td><input type="checkbox" id="'+user.id+'" name="'+user.name+'" class="check_item"></td>';
                           content+='<td>'+user.username+'</td>';
                           content+='<td>'+user.email+'</td>';
                           content+='<td>'+user.phone+'</td>';
                           content+='<td>';
                           content+=' <button type="button" class="btn btn-primary btn-xs"><i class="glyphicon glyphicon-usd"></i></button>';
                           content+=' <button type="button" class="btn btn-success btn-xs"><i class="glyphicon glyphicon-shopping-cart"></i></button>';
                           content+=' <button type="button" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-pencil"></i></i></button>';
                           content+=' <button type="button" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-remove"></i></button>';
                           content+='</td>';
                           content+='</tr>';
                        });
                        //表数据
                        $("tbody").html(content);

                        //分页数据
                        $("#Pagination").pagination(page.totalsize, {
                            num_edge_entries: 2, //边缘页数
                            num_display_entries: 4, //主体页数
                            callback: queryUserPage,
                            items_per_page:10, //每页显示1项,
                            current_page: (page.pageno - 1),
                            prev_text: "上一页",
                            next_text: "下一页"
                        });
                    }else{
                        layer.msg(result.message, {time:1000, icon:5, shift:6});
                    }
                },
                error:function () {
                    layer.msg("加载数据失败", {time:1000, icon:5, shift:6});
                }
            })
        }



        //点击查询
        $("#queryBtn").click(function () {
            var queryText=$("#queryText").val();
            jsonobj.queryTest=queryText;
            queryUserPage(0);
        })

</script>

<script src="${APP_PATH}/script/menu.js"></script>
</body>
</html>

