function showMenu() {
    var href=window.location.href;
    var host=window.location.host;
    var index=href.indexOf(host);
    var path=href.substring(index+host.length);

    var alink=$(".list-group a[href*='"+path+"']");
    alink.css("color","red");
    alink.parent().parent().parent().toggleClass("tree-closed");
    if (  alink.parent().parent().parent().hasClass("tree-closed") ) {
        alink.parent().parent().hide();
    } else {
        alink.parent().parent().show();
    }
}


function showHref() {

    var alink=$(".list-group a[href*='/user/toIndex.htm']");
    alink.css("color","red");
    alert(alink);

}


