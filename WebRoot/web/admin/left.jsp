<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<title>左侧导航</title>


<link rel="stylesheet" href="../../Css/left.css" type="text/css" />

</head>

<body id="bg">

<div class="container">
	
	<div class="leftsidebar_box">
		<div class="line"></div>
		<c:if test="${user.type=='A'}">
		<dl class="custom">
			<dt onClick="changeImage()">系统管理<img src="<%= path%>/images//select_xl01.png"></dt>
			 <dd class="first_dd"><a href="listfeek.action?pageNo=1" target="body">建议反馈</a></dd>
            
            	<dd><a href="tishenhe.action?pageNo=1" target="body">提现审核</a></dd>
            <dd><a href="cityManage.action?pageNo=1" target="body">城市管理</a></dd>
            <dd><a href="backsetPrice.action?pageNo=1" target="body">快递价格管理</a></dd>
             <dd><a href="listImageL.action" target="body">轮播图片管理</a></dd>
              <dd><a href="listImageG.action" target="body">广告图片管理</a></dd>
              <dd><a href="findJuli.action?pageNo=1" target="body">附近距离</a></dd>
           		
			
			
		</dl>
		
		<dl class="custom">
			<dt onClick="changeImage()">管理员管理<img src="<%= path%>/images//select_xl01.png"></dt>
			 <dd class="first_dd"><a href="findAdmin.action?type=N&pageNo=1" target="body">会员信息</a></dd>
        </dl>
        </c:if>
        
		<dl class="custom">
			<dt onClick="changeImage()">会员管理<img src="<%= path%>/images//select_xl01.png"></dt>
			 <c:if test="${user.type=='A'}">
			 <dd class="first_dd"><a href="findAllUser.action?type=N&pageNo=1" target="body">会员信息</a></dd>
			 </c:if>
			 
			 <c:if test="${user.type!='A'}">
			 <dd class="first_dd"><a href="findCityAllUser.action?type=N&pageNo=1" target="body">会员信息</a></dd>
			 </c:if>
      
        </dl>
        <dl class="接单管理">
			<dt onClick="changeImage()">接单人信息表<img src="<%= path%>/images//select_xl01.png"></dt>
<!-- 			 <dd class="first_dd"><a href="findAllUser.action?type=Y&pageNo=1" target="body">接单人信息</a></dd> -->
    		
    		  <c:if test="${user.type=='A'}">
			 <dd class="first_dd"><a href="findAllUser.action?type=Y&pageNo=1" target="body">接单人信息</a></dd>
			 </c:if>
			 <c:if test="${user.type!='A'}">
			 <dd class="first_dd"><a href="findCityAllUser.action?type=Y&pageNo=1" target="body">接单人信息</a></dd>
			 </c:if>
			 <dd><a href="listFE.action?pageNo=1" target="body">自由快递人列表</a></dd>
           <dd><a href="listFEW.action?pageNo=1" target="body">自由快递人审核</a></dd>
			 
        </dl>
         <dl class="订单管理">
			<dt onClick="changeImage()">订单管理<img src="<%= path%>/images//select_xl01.png"></dt>
			 <dd class="first_dd"><a href="listReceiptss.action?pageNo=1" target="body">帮我送订单</a></dd>
     		 <dd class="first_dd"><a href="listHelpRW.action?status=H&pageNo=1" target="body">发任务订单</a></dd>
     	
        </dl>
         <c:if test="${user.type=='A'}">
         <dl class="custom">
			<dt onClick="changeImage()">资金管理<img src="<%= path%>/images//select_xl01.png"></dt>
			 <dd class="first_dd"><a href="listZiJin.action?type=N&pageNo=1" target="body">资金列表</a></dd>
     		
        </dl>
        </c:if>
	
		
</div>

</div>

<script type="text/javascript" src="../../JS/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
$(".leftsidebar_box dt img").attr("src","../../images/select_xl01.png");
$(function(){
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#3992d0"})
		$(this).css({"background-color": "#317eb4"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src","../../images/select_xl01.png");
		$(this).parent().find('img').attr("src","../../images/select_xl.png");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
})
</script>

</div>
</body>
</html>
