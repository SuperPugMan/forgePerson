<%@ page language="java" import="java.util.*,com.beans.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="Generator" content="EditPlus®">
	<meta name="Author" content="">
	<meta name="Keywords" content="">
	<meta name="Description" content="">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<meta name="renderer" content="webkit">
	<title>云购物商城-巴黎欧莱雅官方旗舰店</title>
	<link rel="shortcut icon" type="image/x-icon" href="img/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<link rel="stylesheet" type="text/css" href="css/home.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/modernizr-custom-v2.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
	<script type="text/javascript">

        var intDiff = parseInt(90000);//倒计时总秒数量

        function timer(intDiff){
            window.setInterval(function(){
                var day=0,
                    hour=0,
                    minute=0,
                    second=0;//时间默认值
                if(intDiff > 0){
                    day = Math.floor(intDiff / (60 * 60 * 24));
                    hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
                    minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
                    second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
                }
                if (minute <= 9) minute = '0' + minute;
                if (second <= 9) second = '0' + second;
                $('#day_show').html(day+"天");
                $('#hour_show').html('<s id="h"></s>'+hour+'时');
                $('#minute_show').html('<s></s>'+minute+'分');
                $('#second_show').html('<s></s>'+second+'秒');
                intDiff--;
            }, 1000);
        }

        $(function(){
            timer(intDiff);
        });//倒计时结束

        $(function(){
	        /*======右按钮======*/
            $(".you").click(function(){
                nextscroll();
            });
            function nextscroll(){
                var vcon = $(".v_cont");
                var offset = ($(".v_cont li").width())*-1;
                vcon.stop().animate({marginLeft:offset},"slow",function(){
                    var firstItem = $(".v_cont ul li").first();
                    vcon.find(".flder").append(firstItem);
                    $(this).css("margin-left","0px");
                });
            };
	        /*========左按钮=========*/
            $(".zuo").click(function(){
                var vcon = $(".v_cont");
                var offset = ($(".v_cont li").width()*-1);
                var lastItem = $(".v_cont ul li").last();
                vcon.find(".flder").prepend(lastItem);
                vcon.css("margin-left",offset);
                vcon.animate({marginLeft:"0px"},"slow")
            });
        });

	</script>
	<script type="text/javascript">
        $(function(){
        $(".pc-header-link").hover(
            function () {
            $(".topDown").show();//慢
            },
            function () {
            $(".topDown").hide();//快
            }
        );
        

        
            var $miaobian=$('.Xcontent08>div');
            var $huantu=$('.Xcontent06>img');
            var $miaobian1=$('.Xcontent26>div');
            $miaobian.mousemove(function(){miaobian(this);});
            $miaobian1.click(function(){miaobian1(this);});
            function miaobian(thisMb){
                for(var i=0; i<$miaobian.length; i++){
                    $miaobian[i].style.borderColor = '#dedede';
                }
                thisMb.style.borderColor = '#cd2426';

                $huantu[0].src = thisMb.children[0].src;
            }
            function miaobian1(thisMb1){
                for(var i=0; i<$miaobian1.length; i++){
                    $miaobian1[i].style.borderColor = '#dedede';
                }
//		thisMb.style.borderColor = '#cd2426';
                $miaobian.css('border-color','#dedede');
                thisMb1.style.borderColor = '#cd2426';
                $huantu[0].src = thisMb1.children[0].src;
            }
            $(".Xcontent33").click(function(){
                var value=parseInt($('.input').val())+1;
                $(".input").val(value);
                $(".input").attr("value",value);
            })

            $(".Xcontent32").click(function(){
                var num = $(".input").val()
                if(num>0){
                var value  =parseInt($(".input").val())-1;
                 $(".input").val(value);
                 $(".input").attr("value",value);
                }

            })

        })
	</script>

	<style>
		.li-ul-ss l{
			width:200px;
		}
		.topDown{
			position: absolute;
			background-color:rgba(128,128,128.8);
			z-index:5;
			width:200px;
			border:1px red solid;
		}
	</style>
</head>
<body>

<header id="pc-header">
	<div class="pc-header-nav">
		<div class="pc-header-con">
			<div class="fl pc-header-link" >
			<c:choose>
				<c:when test="${not empty sessionScope.user}">
					您好！，<a href="#" class="menu-btn"><c:out value="${sessionScope.user.userName}"></c:out></a>
					<ul class="topDown" style="display:none"><!-- style="display:none" -->
					<c:if test="${sessionScope.user.type==1}">
					<li><a href="back/index.jsp">进入管理</a></li>
					</c:if>
                    <li><a href="#">我的账号</a></li>
                    <li><a href="#">我的余额</a></li>
                    <li><a href="exit.jsp">退出登录</a></li>
                   <!--  <li><a href="">我的评论</a></li>
                    <li><a href="">电子书架</a></li> -->
                </ul>欢迎来云购物
				</c:when>
				<c:when test="${empty sessionScope.user}">
					您好！，欢迎来云购物 <a href="login.jsp" target="_blank">请登录</a> <a href="register.jsp" target="_blank"> 免费注册</a>
				</c:when>
			</c:choose>
			<!-- 您好！，欢迎来云购物 <a href="login.jsp" target="_blank">请登录</a> <a href="register.jsp" target="_blank"> 免费注册</a> -->
			</div>
			<div class="fr pc-header-list top-nav">
				<ul>
					<li>
						<div class="nav"><i class="pc-top-icon"></i><a href="#">我的订单</a></div>
						<div class="con">
							<dl>
								<dt><a href="">批发进货</a></dt>
								<dd><a href="">已买到货品</a></dd>
								<dd><a href="">优惠券</a></dd>
								<dd><a href="">店铺动态</a></dd>
							</dl>
						</div>
					</li>
					<li>
						<div class="nav"><i class="pc-top-icon"></i><a href="#">我的商城</a></div>
						<div class="con">
							<dl>
								<dt><a href="">批发进货</a></dt>
								<dd><a href="">已买到货品</a></dd>
								<dd><a href="">优惠券</a></dd>
								<dd><a href="">店铺动态</a></dd>
							</dl>
						</div>
					</li>
					<li><a href="#">我的云购</a></li>
					<li><a href="#">我的收藏</a></li>
					<li><a href="#">会员中心</a></li>
					<li><a href="#">客户服务</a></li>
					<li><a href="#">帮助中心</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="pc-header-logo clearfix">
		<div class="pc-fl-logo fl">
			<h1>
				<a href="index.jsp"></a>
			</h1>
		</div>
		<div class="head-form fl">
			<form class="clearfix">
				<input class="search-text" accesskey="" id="key" autocomplete="off" placeholder="洗衣机" type="text">
				<button class="button" onclick="search('key');return false;">搜索</button>
			</form>
			<div class="words-text clearfix">
				<a href="#" class="red">1元秒爆</a>
				<a href="#">低至五折</a>
				<a href="#">农用物资</a>
				<a href="#">佳能相机</a>
				<a href="#">服装城</a>
				<a href="#">买4免1</a>
				<a href="#">家电秒杀</a>
				<a href="#">农耕机械</a>
				<a href="#">手机新品季</a>
			</div>
		</div>
		<div class="fr pc-head-car">
			<i class="icon-car"></i>
			<a href="my-car.jsp">我的购物车</a>
			<em>10</em>
		</div>
	</div>
	<!--  顶部    start-->
	<div class="yHeader">
		<!-- 导航   start  -->
		<div class="yNavIndex">
			<ul class="yMenuIndex" style="margin-left:0">
				<li style="background:#d1201e"><a href="" target="_blank">云购首页</a></li>
				<li><a href="" target="_blank">女士护肤 </a></li>
				<li><a href="" target="_blank">男士护肤</a></li>
				<li><a href="" target="_blank">洗护染发</a></li>
				<li><a href="" target="_blank">染发</a></li>
				<li><a href="" target="_blank">彩妆</a></li>
				<li><a href="" target="_blank">品牌故事</a></li>
			</ul>
		</div>
		<!-- 导航   end  -->
	</div>

</header>
<nav>
	<div class="pc-nav-d">
		<div class="center">
			<a href="#">美妆个护</a> >
			<a href="#">面部护肤</a> >
			<a href="#">套装</a> >
			<a href="#">欧莱雅（LOREAL）</a> >
			<a href="#">欧莱雅套装</a>
		</div>
	</div>
</nav>

<div class="Xcontent">
	<ul class="Xcontent01">

		<div class="Xcontent06"><img src="images/shangpinxiangqing/X1.png"></div>
		<ol class="Xcontent08">
			<div class="Xcontent07"><img src="images/shangpinxiangqing/X1.png"></div>
			<div class="Xcontent09"><img src="images/shangpinxiangqing/X7.png"></div>
			<div class="Xcontent10"><img src="images/shangpinxiangqing/X8.png"></div>
			<div class="Xcontent11"><img src="images/shangpinxiangqing/X9.png"></div>
			<div class="Xcontent12"><img src="images/shangpinxiangqing/X10.png"></div>
		</ol>
		<ol class="Xcontent13 clearfix">
			<div class="Xcontent14 clearfix"></div>
			<div class="Xcontent15 clearfix red fl" style="margin-top:2px">新品上架</div>
			<div class="Xcontent16 clearfix"><p style="margin:0">美妆护肤放肆购，你值得拥有！更多惊喜</p></div>
			<div class="Xcontent17">
				<p class="Xcontent18">售价</p>
				<p class="Xcontent19"></p>
				<div class="Xcontent20">
					<p class="Xcontent21">促销</p>
					<img src="images/shangpinxiangqing/X12.png">
					<p class="Xcontent22">领610元新年礼券，满再赠好礼</p>
				</div>
				<div class="Xcontent23">
					<p class="Xcontent24">服务</p>
					<p class="Xcontent25">30天无忧退货&nbsp;&nbsp;&nbsp;&nbsp;       48小时快速退款 &nbsp;&nbsp;&nbsp;&nbsp;        满88元免邮</p>
				</div>

			</div>
			<div class="Xcontent26">
				<p class="Xcontent27">颜色</p>
				<div class="Xcontent28"><img  src="images/shangpinxiangqing/X14.png"></div>
				<div class="Xcontent29"><img  src="images/shangpinxiangqing/X1.png"></div>
			</div>
			<div class="Xcontent30">
				<p class="Xcontent31">数量</p>
				<div class="Xcontent32"><img src="images/shangpinxiangqing/X15.png"></div>
				<form>
					<input class="input"  id="sc" value="1"></form>
				<div class="Xcontent33"><img src="images/shangpinxiangqing/16.png"></div>

			</div>
			<%
				String id=request.getParameter("id");
 			%>
			<div class="Xcontent34"><a href='#' onclick="sclick(<%=id %>)">立即购买</a></div><%-- click(<%=id %>) --%>
			<div class="Xcontent35"><a href='#' onclick="sclick(<%=id %>)">加入购物车</a></div><%-- click(<%=id %>) --%>

		</ol>

	</ul>
</div>
<div class="center" style="background:#fff">
	<div class="tabox">
		<div class="hd">
			<ul class="li-ul-ss">
				<li class=" " style="width:233px">疯狂抢购</li>
				<li class=" ">猜您喜欢</li>
				<li class=" ">热卖商品</li>
				<li class=" ">热评商品</li>
				<li class="">新品上架</li></ul>
		</div>
		<div class="bd">
			<ul class="lh" style="display: none;">
				<li>
					<div class="p-img ld">
						<a href="">
							<img src="images/shangpinxiangqing/X-1.png"></a>
					</div>
					<div class="p-name">
						<a href="#">艾家纺全棉加厚磨毛四件套</a></div>
					<div class="p-price">京东价：
						<strong>￥399.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/shangpinxiangqing/X-1.png"></a>
					</div>
					<div class="p-name">
						<a href="#">优曼真丝提花奢华四件套</a></div>
					<div class="p-price">京东价：
						<strong>￥1299.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/shangpinxiangqing/X1.png"></a>
					</div>
					<div class="p-name">
						<a href="#">3999！大金1.5匹变频空调更安静！</a></div>
					<div class="p-price">京东价：
						<strong>￥3999.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/shangpinxiangqing/X2.png"></a>
					</div>
					<div class="p-name">
						<a href="#">爸爸爱喜禾（犬子在，不远游！感动无数读者的电子书</a></div>
					<div class="p-price">京东价：
						<strong>￥1.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/shangpinxiangqing/X3.png"></a>
					</div>
					<div class="p-name">
						<a href="#">【超值】飞利浦21.5英寸LED背光宽屏液晶显示</a></div>
					<div class="p-price">京东价：
						<strong>￥809.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/shangpinxiangqing/X4.png"></a>
					</div>
					<div class="p-name">
						<a href="#">爸爸爱喜禾（犬子在，不远游！感动无数读者的电子书</a></div>
					<div class="p-price">京东价：
						<strong>￥1.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/shangpinxiangqing/X5.png"></a>
					</div>
					<div class="p-name">
						<a href="#">【超值】飞利浦21.5英寸LED背光宽屏液晶显示</a></div>
					<div class="p-price">京东价：
						<strong>￥809.00</strong></div>
				</li>
			</ul>
			<ul class="lh" style="display: none;">
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/shangpinxiangqing/X-1.png"></a>
					</div>
					<div class="p-name">
						<a href="#">安钛克（Antec）VP 550P 额定550W 120mm静音风扇 主动PFC 黑化外型设计电源</a></div>
					<div class="p-price">京东价：
						<strong>￥399.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.2.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">G.SKILL（芝奇）RipjawsX DDR3 1600 8G(4G×2条)台式机内存(F3-12800CL9D-8GBXL )</a></div>
					<div class="p-price">京东价：
						<strong>￥235.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.3.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">希捷（Seagate）1TB ST1000DM003 7200转64M SATA 6Gb/秒 台式机硬盘 建达蓝德 盒装正品</a></div>
					<div class="p-price">京东价：
						<strong>￥438.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.4.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">华硕(ASUS)P8Z77-V LK主板(Intel Z77/LGA 1155)</a></div>
					<div class="p-price">京东价：
						<strong>￥899.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.5.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">大水牛（BUBALUS）电脑机箱 经典-A1008 灰黑色（不含电源）</a></div>
					<div class="p-price">京东价：
						<strong>￥112.00</strong></div>
				</li>
			</ul>
			<ul class="lh" style="display: none;">
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/3.1.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">冬季健身TOP1！瑞亚特仰卧板加送俯卧撑架</a></div>
					<div class="p-price">京东价：
						<strong>￥187.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/3.2.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">HTC Z715e!双核！魔音耳机！</a></div>
					<div class="p-price">京东价：
						<strong>￥2399.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/3.3.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">下单返现150元！格力9片电油汀</a></div>
					<div class="p-price">京东价：
						<strong>￥449.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/3.4.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">绿之源净味宝2居室除味超值套装 4000克</a></div>
					<div class="p-price">京东价：
						<strong>￥449.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/3.5.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">宏碁i5 4G GT630M 1G独显 月销量破</a></div>
					<div class="p-price">京东价：
						<strong>￥3599.00</strong></div>
				</li>
			</ul>
			<ul class="lh" style="display: none;">
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.3.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">希捷（Seagate）1TB ST1000DM003 7200转64M SATA 6Gb/秒 台式机硬盘 建达蓝德 盒装正品</a></div>
					<div class="p-price">京东价：
						<strong>￥438.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.3.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">希捷（Seagate）1TB ST1000DM003 7200转64M SATA 6Gb/秒 台式机硬盘 建达蓝德 盒装正品</a></div>
					<div class="p-price">京东价：
						<strong>￥438.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.3.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">希捷（Seagate）1TB ST1000DM003 7200转64M SATA 6Gb/秒 台式机硬盘 建达蓝德 盒装正品</a></div>
					<div class="p-price">京东价：
						<strong>￥438.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.3.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">希捷（Seagate）1TB ST1000DM003 7200转64M SATA 6Gb/秒 台式机硬盘 建达蓝德 盒装正品</a></div>
					<div class="p-price">京东价：
						<strong>￥438.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.3.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">希捷（Seagate）1TB ST1000DM003 7200转64M SATA 6Gb/秒 台式机硬盘 建达蓝德 盒装正品</a></div>
					<div class="p-price">京东价：
						<strong>￥438.00</strong></div>
				</li>
			</ul>
			<ul class="lh" style="display: block;">
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.5.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">大水牛（BUBALUS）电脑机箱 经典-A1008 灰黑色（不含电源）</a></div>
					<div class="p-price">京东价：
						<strong>￥112.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.5.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">大水牛（BUBALUS）电脑机箱 经典-A1008 灰黑色（不含电源）</a></div>
					<div class="p-price">京东价：
						<strong>￥112.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.5.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">大水牛（BUBALUS）电脑机箱 经典-A1008 灰黑色（不含电源）</a></div>
					<div class="p-price">京东价：
						<strong>￥112.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.5.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">大水牛（BUBALUS）电脑机箱 经典-A1008 灰黑色（不含电源）</a></div>
					<div class="p-price">京东价：
						<strong>￥112.00</strong></div>
				</li>
				<li>
					<div class="p-img ld">
						<a href="#">
							<img src="images/2.5.jpg"></a>
					</div>
					<div class="p-name">
						<a href="#">大水牛（BUBALUS）电脑机箱 经典-A1008 灰黑色（不含电源）</a></div>
					<div class="p-price">京东价：
						<strong>￥112.00</strong></div>
				</li>
			</ul>
		</div>
	</div>
	<script type="text/javascript">
        jQuery(".tabox").slide({delayTime: 0});
	</script>

</div>
<div class="containers center clearfix" style="margin-top:20px; background:#fff;">
	<div class="fl" style="padding-left:10px; padding-top:20px">
		<div class="pc-menu-in">
			<h2>店内搜索</h2>
			<form>
				<p>关键词:<input type="text" class="pc-input1"></p>
				<p>价  格：<input class="pc-input2"> 到 <input class="pc-input2"></p>
				<p><a href="#">搜索</a> </p>
			</form>
		</div>
		<div class="menu_list" id="firstpane">
			<h2>店内分类</h2>
			<h3 class="menu_head current">电玩</h3>
			<div class="menu_body" style="">
				<a href="#">耳机耳麦</a>
				<a href="#">游戏机</a>
			</div>
			<h3 class="menu_head">手机</h3>
			<div class="menu_body" style="display: none;">
				<a href="#">手机</a>
				<a href="#">手机</a>
				<a href="#">手机</a>
			</div>

			<h3 class="menu_head">耳机耳麦</h3>
			<div class="menu_body" style="display: none;">
				<a href="#">耳机耳麦</a>
				<a href="#">耳机耳麦</a>
				<a href="#">耳机耳麦</a>
				<a href="#">耳机耳麦</a>
			</div>
		</div>
	</div syu>
	<div class="pc-info fr" style="padding-left:10px; padding-top:20px">
		<div class="pc-overall">
			<ul id="H-table1" class="brand-tab H-table1 H-table-shop clearfix ">
				<li class="cur"><a href="javascript:void(0);">商品介绍</a></li>
				<li><a href="javascript:void(0);">商品评价<em class="reds">(91)</em></a></li>
				<li><a href="javascript:void(0);">售后保障</a></li>
			</ul>
			<div class="pc-term clearfix">
				<div class="H-over1 pc-text-word clearfix">
					<ul class="clearfix">
						<li>
							<p>屏幕尺寸：4.8英寸</p>
							<p>分辨率：1280×720(HD,720P) </p>
						</li>
						<li>
							<p>后置摄像头：800万像素</p>
							<p>分辨率：1280×720(HD,720P) </p>
						</li>
						<li>
							<p>前置摄像头：190万像素</p>
							<p>分辨率：1280×720(HD,720P) </p>
						</li>
						<li>
							<p>3G：电信(CDMA2000)</p>
							<p>2G：移动/联通(GSM)/电信(CDMA </p>
						</li>
					</ul>
					<div class="pc-line"></div>
					<ul class="clearfix">
						<li>
							<p>商品名称：三星I939I</p>
							<p>商品毛重：360.00g </p>
						</li>
						<li>
							<p>商品编号：1089266</p>
							<p>商品产地：中国大陆</p>
						</li>
						<li>
							<p>品牌： 三星（SAMSUNG）</p>
							<p>系统：安卓（Android </p>
						</li>
						<li>
							<p>上架时间：2015-03-30 09:07:18</p>
							<p>机身颜色：白色</p>
						</li>
					</ul>
					<div>
						<div style="text-align:center"><img src="images/shangpinxiangqing/X1.png" width="50%"></div>
						<div style="text-align:center"><img src="images/shangpinxiangqing/X2.png" width="50%"></div>
						<div style="text-align:center"><img src="images/shangpinxiangqing/X3.png" width="50%"></div>
						<div style="text-align:center"><img src="images/shangpinxiangqing/X1.png" width="50%"></div>
					</div>
				</div>
				<div class="H-over1" style="display:none">
					<div class="pc-comment fl"><strong>86<span>%</span></strong><br> <span>好评度</span></div>
					<div class="pc-percent fl">
						<dl>
							<dt>好评<span>(86%)</span></dt>
							<dd><div style="width:86px"></div></dd>
						</dl>
						<dl>
							<dt>中评<span>(86%)</span></dt>
							<dd><div style="width:86px"></div></dd>
						</dl>
						<dl>
							<dt>好评<span>(86%)</span></dt>
							<dd><div style="width:86px"></div></dd>
						</dl>
					</div>
				</div>
				<div class="H-over1 pc-text-title" style="display:none">
					<p>本产品全国联保，享受三包服务，质保期为：一年质保
						如因质量问题或故障，凭厂商维修中心或特约维修点的质量检测证明，享受7日内退货，15日内换货，15日以上在质保期内享受免费保修等三包服务！
						(注:如厂家在商品介绍中有售后保障的说明,则此商品按照厂家说明执行售后保障服务。) 您可以查询本品牌在各地售后服务中心的联系方式，请点击这儿查询......</p>
					<div class="pc-line"></div>
				</div>
			</div>
		</div>
		<div class="pc-overall">
			<ul class="brand-tab H-table H-table-shop clearfix " id="H-table" style="margin-left:0;">
				<li class="cur"><a href="javascript:void(0);">全部评价（199）</a></li>
				<li><a href="javascript:void(0);">好评<em class="reds">（33）</em></a></li>
				<li><a href="javascript:void(0);">中评<em class="reds">（02）</em></a></li>
				<li><a href="javascript:void(0);">差评<em class="reds">（01）</em></a></li>
			</ul>
			<div class="pc-term clearfix">
				<div class="pc-column">
					<span class="column1">评价心得</span>
					<span class="column2">顾客满意度</span>
					<span class="column3">购买信息</span>
					<span class="column4">评论者</span>
				</div>
				<div class="H-over  pc-comments clearfix">
					<ul class="clearfix">
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
					</ul>
				</div>
				<div style="display:none" class="H-over pc-comments">
					<ul class="clearfix">
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
					</ul>
				</div>
				<div style="display:none" class="H-over pc-comments">
					<ul class="clearfix">
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
					</ul>
				</div>
				<div style="display:none" class="H-over pc-comments">
					<ul class="clearfix">
						<li class="clearfix">
							<div class="column1">
								<p class="clearfix"><a href="#">回复<em>（90）</em></a> <a href="#">赞<em>（90）</em></a> </p>
								<p>一次用三星，不是很顺手，但咨询客服后终于上手了，感觉性价比相当不错，值得购买。但最想说的是京东客服更好，产品信得过，正品行货，买的放心。</p>
								<p class="column5">2014-11-25 14:32</p>
							</div>
							<div class="column2"><img src="img/icon/star.png"></div>
							<div class="column3">颜色：云石白</div>
							<div class="column4">
								<p><img src="img/icon/user.png"></p>
								<p>2014-11-23 22:37 购买</p>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="clearfix">
			<div class="fr pc-search-g pc-search-gs">
				<a href="#" class="fl " style="display:none">上一页</a>
				<a class="current" href="#">1</a>
				<a href="javascript:;">2</a>
				<a href="javascript:;">3</a>
				<a href="javascript:;">4</a>
				<a href="javascript:;">5</a>
				<a href="javascript:;">6</a>
				<a href="javascript:;">7</a>
				<span class="pc-search-di">…</span>
				<a href="javascript:;">1088</a>
				<a href="javascript:;" class="" title="使用方向键右键也可翻到下一页哦！">下一页</a>
			</div>
		</div>
	</div>
</div>
<div style="height:100px"></div>
<footer>
	<div class="pc-footer-top">
		<div class="center">
			<ul class="clearfix">
				<li>
					<span>关于我们</span>
					<a href="#">关于我们</a>
					<a href="#">诚聘英才</a>
					<a href="#">用户服务协议</a>
					<a href="#">网站服务条款</a>
					<a href="#">联系我们</a>
				</li>
				<li class="lw">
					<span>购物指南</span>
					<a href="#">新手上路</a>
					<a href="#">订单查询</a>
					<a href="#">会员介绍</a>
					<a href="#">网站服务条款</a>
					<a href="#">帮助中心</a>
				</li>
				<li class="lw">
					<span>消费者保障</span>
					<a href="#">人工验货</a>
					<a href="#">退货退款政策</a>
					<a href="#">运费补贴卡</a>
					<a href="#">无忧售后</a>
					<a href="#">先行赔付</a>
				</li>
				<li class="lw">
					<span>商务合作</span>
					<a href="#">人工验货</a>
					<a href="#">退货退款政策</a>
					<a href="#">运费补贴卡</a>
					<a href="#">无忧售后</a>
					<a href="#">先行赔付</a>
				</li>
				<li class="lss">
					<span>下载手机版</span>
					<div class="clearfix lss-pa">
						<div class="fl lss-img"><img src="img/icon/code.png" alt=""></div>
						<div class="fl" style="padding-left:20px">
							<h4>扫描下载云购APP</h4>
							<p>把优惠握在手心</p>
							<P>把潮流带在身边</P>
							<P></P>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="pc-footer-lin">
			<div class="center">
				<p>友情链接：
					卡宝宝信用卡
					梦芭莎网上购物
					手游交易平台
					法律咨询
					深圳地图
					P2P网贷导航
					名鞋库
					万表网
					叮当音乐网
					114票务网
					儿歌视频大全
				</p>
				<p>
					京ICP证1900075号  京ICP备20051110号-5  京公网安备110104734773474323  统一社会信用代码 91113443434371298269B  食品流通许可证SP1101435445645645640352397
				</p>
				<p style="padding-bottom:30px">版物经营许可证 新出发京零字第朝160018号  Copyright©2011-2015 版权所有 ZHE800.COM </p>
			</div>
		</div>
	</div>
</footer>

			<%-- <%
				String id=request.getParameter("id");
 			%> --%>
<script type="text/javascript">


var num=$(".input").val();
/*  动态获取数据，并拼接      */  
load(0);  //默认初始化,pageNum为0
var data;
function  load(pageNum) {
       $.ajax({
           url: "ProductServlet?method=finId&id=<%=id%>",  //需要提交的服务器地址
           type: "post",  //请求的方式
           data: {"pageNum": pageNum},  //传递给服务器的参数
           success: function (data) {  //回调函数
           data=$.parseJSON(data);//从数据库获得的json对象，已经包含查询回来的数据                       
               //清空数据
		 $(".Xcontent14").html('');
		 $(".Xcontent19").html('');
/* 		 $(".Xcontent34").html('');
		  $(".Xcontent35").html(''); */
		 $(".Xcontent19").append("￥<span>"+data.price+"</span></p>");//通过中转页面判断是否登录，如果不登录直接存进cookie,否则存进数据库
		 $(".Xcontent14").append("<a href='#'><p>"+data.name+"</p></a>");
		/*  $(".Xcontent34").append("<a href='ShoppingCartServlet?method=addcar&id="+data.id+"&name="+data.name+"&price="+data.price+"'>立即购买</a>");
		 $(".Xcontent35").append("<a href='ShoppingCartServlet?method=addcar&id="+data.id+"&name="+data.name+"&price="+data.price+"'>加入购物车</a>"); */
		/*   $(".Xcontent34").append("<a href='' onclick='click("+data.id+","+data.name+","+data.price+")'>立即购买</a>");
		 $(".Xcontent35").append("<a href='' onclick='click("+data.id+","+data.name+","+data.price+")'>加入购物车</a>"); */ 
           }
       });
   };


</script>
<script type="text/javascript">
/* var num=$("#sc").val(); */

function sclick(id){
alert("已成功加入购物车");
var num = $(".input").val();
alert(id+"  "+num);
window.location.href="ShoppingCartServlet?method=addcar&id="+id+"&num="+num;
}
</script>
<script type="text/javascript">
    //hover 触发两个事件，鼠标移上去和移走
    //mousehover 只触发移上去事件
    $(".top-nav ul li").hover(function(){
        $(this).addClass("hover").siblings().removeClass("hover");
        $(this).find("li .nav a").addClass("hover");
        $(this).find(".con").show();
    },function(){
        //$(this).css("background-color","#f5f5f5");
        $(this).find(".con").hide();
        //$(this).find(".nav a").removeClass("hover");
        $(this).removeClass("hover");
        $(this).find(".nav a").removeClass("hover");
    })
</script>
</body>
</html>