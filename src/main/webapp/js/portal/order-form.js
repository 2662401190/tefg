


$(document).ready(function(){
   /* $(".hezijj").live("mouseenter",function(){
        $(this).css({"border":"1px solid  #FF00FF"});
    });
    $(".hezijj").live("mouseleave",function(){
        $(this).css({"border":"1px solid  #B0E0E6"});
    });*/




    $(document).on("click","#ddys",function () {
        var zz = $("#zz").attr("zz");
        var order;
        var qthis=$(this);
        $.ajax({
            url:"/order/cancel.do",
            data:{"orderNo":zz},
            type:"POST",
            success:function (result) {
                console.log(result);
                 order=result.status;
                if(order == 0){
                    qthis.parent().siblings(".zfzt").children(".jyztspan").text("已取消");

                }

            }

        });
    })









});

