

$(document).ready(function(){
    $(".hezijj ").live("mouseenter",function(){
        console.log('123')
        $(this).css({"border":"1px solid red"});
    });
    $(".hezijj").live("mouseleave",function(){
        $(this).css({"border":"1px solid #FFFFFF"});
    });
});
