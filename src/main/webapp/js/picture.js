$(function(){
				$("#show").hide();
				var node;
				$(".dh,#show").hover(
					function(){
						var id;
						if($(this).attr("id")!="show"){
						node = $(this).attr("id");
						id = $(this).attr("iid");
						
						$.ajax({
							"type":"Post",
							"url":"productservlet.do",
							"data":{"fm":"selemateid","id":id},
							"datatype":"Json",
							success:function(result){
							//将字符串转换成Json对象
							//result=JSON.parse(result);
						//	alert(result);
							}
						})
						}
						$("#"+node+"").css({"background-color":"white","color":"black"});
						//alert(id);
						$("#show").show();
					},function(){
					$(".dh").css({"color":"white","background-color":"black"});
					$("#show").hide();
					
				})
				$("#xx").click(
					function(){
					$("#top-banner").hide();
					$("#show").css({"top":"173px"});
				})
			})

			
$(function(){
	var boridx=0;
	var borclass="";
	var borcidx=0;
	$(".divctr-div img,.divctr-div1-ctr img").hover(function(){
		boridx=$(this).parent().parent().attr("index");
		borclass=$(this).parent().parent().attr("class");
		$("."+borclass+":eq("+boridx+") span").eq(0).stop().animate({width:'50%',left:'0px'},500);
		$("."+borclass+":eq("+boridx+") span").eq(1).stop().animate({width:'50%'},500);
	},function(){
			$("."+borclass+":eq("+boridx+") span").eq(0).stop().animate({width:'0',left:'50%'},500);
			$("."+borclass+":eq("+boridx+") span").eq(1).stop().animate({width:'0'},500);
	})

	$(".pictran div").hover(function(){
		$(".divctr1>div:eq(0) div").eq($(this).index()).css("box-shadow","0px 50px 100px black");
		$(this).stop().animate({height:"+=2px",marginTop:"-2px"},300);
		$(this).css({"clip-path":"polygon(25% 1%, 75% 1%, 100% 3%, 100% 93%, 94% 100%, 7% 100%, 0 94%, 0 4%)","transform":"rotateX(0deg) rotateY(0deg) rotateZ(0deg)"," transform":"rotate3D(0,0,0,0deg)"});		
	},function(){
		$(this).stop().animate({height:"200px",marginTop:"8px"},300);
		$(".divctr1>div:eq(0) div").eq($(this).index()).css({"box-shadow":"0px 0px 0px black"});
		$(this).css({"clip-path":"polygon(12% 0, 87% 0, 100% 10%, 100% 88%, 88% 100%, 12% 100%, 0 90%, 0 11%)","transform":"rotateX(20deg) rotateY(2deg) rotateZ(0deg)"});		
	})
	//鐐瑰嚮鎹竴鎵圭殑鏃跺�鍑虹幇鍙︿竴涓插浘鐗�
	 var xclick=0;
	 var xbool=-1;
	 $(".dvirctr-x").click(function(){
	 	if(xclick==0){
		 	xclick=1;
		 	$(this).css({"background":"#33CCCC","clip-path":"polygon(16% 15%, 50% 8%, 88% 16%, 90% 54%, 83% 89%, 51% 94%, 19% 88%, 9% 49%)"})
		 	setTimeout(function(){
		 		$(".dvirctr-x").css({"background":"#000","clip-path":"polygon(23% 8%, 63% 2%, 96% 28%, 94% 72%, 71% 94%, 29% 97%, 5% 74%, 4% 34%)"})
		 	},600)
		 	
		 	$(".pictran>div").css({"opacity":"0","clip-path":"polygon(44% 47%, 53% 44%, 60% 49%, 63% 55%, 61% 64%, 51% 67%, 43% 63%, 41% 55%)"})
		 	  setTimeout(function(){
		 	  	$(".pictran>div img").show();
		 	  	for(var i=0;i<$(".pictran>div").length;i++){
		 	  		if(xbool==-1){
		 	  			$(".pictran>div:eq("+i+") img").eq(0).hide();
		 	  		}else{
		 	  			$(".pictran>div:eq("+i+") img").eq(1).hide();
		 	  		}
		 	  	}
		 	  	xbool=xbool==-1?1:-1;
		 	  	$(".pictran>div").css({"opacity":"1","clip-path":"polygon(20% 0%, 80% 0%, 100% 0, 100% 100%, 73% 100%, 32% 100%, 0 100%, 0 0)"});
		 	 	setTimeout(function(){
		 	 		$(".pictran>div").css({"clip-path":"polygon(12% 0, 87% 0, 100% 10%, 100% 88%, 88% 100%, 12% 100%, 0 90%, 0 11%)"});
		 	 		xclick=0;
		 	 	},400);
		 	  },500);
	 	  }
	 })
	})

//*****************杞挱鍥�
$(function () {
				//鎵嬪姩鎺у埗杞挱鍥�
				$('#one li').eq(0).show();

				$('#two li').mouseover(function () {
		$(this).addClass('on').siblings().removeClass('on');
		var index = $(this).index();
		i = index;
		$('#one li').eq(index).stop().fadeIn(300).siblings().stop().fadeOut(300);
				})
				//鑷姩鎾斁
				var i = 0;
				var t = setInterval(move, 1500);
				//鑷姩鎾斁鏍稿績鍑芥暟
				function move() {
		i++;
		if (i == 5) {
			i = 0;
		}
		$('#two li').eq(i).addClass('on').siblings().removeClass('on');
		$('#one li').eq(i).fadeIn(300).siblings().fadeOut(300);
				}

				//鍚戝彸鎾斁鏍稿績鍑芥暟
				function moveL() {
		i--;
		if (i == -1) {
			i = 4;
		}
		$('#two li').eq(i).addClass('on').siblings().removeClass('on');
		$('#one li').eq(i).fadeIn(300).siblings().fadeOut(300);
				}
				$('#left1').click(function () {
		moveL();
				})
				$('#right1').click(function () {
		move();
				})
				//榧犳爣绉诲叆绉婚櫎
				$('#lunbo').hover(function () {
		clearInterval(t);
				}, function () {
		t = setInterval(move, 1500);
				})


//涓嬮潰鐨勮疆鎾浘
$(function () {
	var xhRight = null;
	//scroll news
	var scrnews = $(".slider-main");

	if (scrnews.children().length < 4) { return false; }

	var newst = setInterval(scro, 3500);

	scrnews.hover(function () {
		clearInterval(newst);
	}, function () {
		newst = setInterval(scro, 3500);
	})

	function scro() {
		scrnews.animate({ left: -1000 }, 1500, function () {
			$(this).children("li:first").appendTo(this);
			$(this).css("left", 0);
		});
	}


	$('.slider-page li').hover(function () {
		clearInterval(newst);
	}, function () {
		newst = setInterval(scro, 3500);
	})

	$('.slider-prev').click(function () {
		scrnews.children("li:first").appendTo(scrnews);

	})
	$('.slider-next').click(function () {
		scrnews.children("li:last").prependTo(scrnews);

	})

})

$(function () {

	$("#jdm-tbar-tab-top").click(function () {
		$('body,html').animate({ scrollTop: 0 }, 2000);
		return false;
	});
});
})
//固定搜索
