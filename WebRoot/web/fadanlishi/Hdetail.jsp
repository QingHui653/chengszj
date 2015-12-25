<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../../common/head.jsp"%>
<head>
<!-- <meta http-equiv='refresh' content='0;url=newss.action'> -->
<title>帖子</title>
<style type="text/css">
/* body { background-color: #DCDCDC}*/
.a{background-color: white;} 
.a td{border-bottom: 2px solid #DCDCDC;}
.b{border-top: 15px solid #DCDCDC; border-bottom: 15px solid #DCDCDC; }
.b td{border-bottom: 2px solid #DCDCDC;}
.c td{border-bottom: 2px solid #DCDCDC;}
.c {border-bottom: 15px solid #DCDCDC; }
.d {border-bottom: 15px solid #DCDCDC; }
.e a{text-decoration: none; }
.e{ text-align: center; height: 50px;border-bottom: 3px solid #DCDCDC; background-color: red;}
</style>
  </head>
  
  <body>

	<table width="100%"  cellspacing="0" cellpadding="0" class="a">
	
		<tr ><td width="25%" height="35px;"  >预计送达</td><td >${helpmebuy.sendTime}</td></tr>
		<tr><td width="25%" height="35px;">费用</td><td>${helpmebuy.reward}元</td></tr>
		</table>
		<table width="100%"  cellspacing="0" cellpadding="0" class="b">
		<tr><td width="25%" height="35px;">收货电话</td><td>${helpmebuy.userid}</td></tr>
		<tr><td width="25%" height="35px;">购买地</td><td>${helpmebuy.purchaseLand}</td></tr>
		<tr><td width="25%" height="35px;">收货地</td><td>${helpmebuy.receivingLand}</td></tr>
		</table>
	
		<table width="100%"  cellspacing="0" cellpadding="0" class="d">
		<tr><td width="25%" height="35px;">购买要求</td><td>${helpmebuy.purchaseAsk}</td></tr>
			</table>
	
	<table width="100%"  cellspacing="0" cellpadding="0" class="f">
		<tr><td  height="25px;" colspan="2" style="border-bottom: 1px solid;">物品信息</td></tr>
		<tr><td  height="35px;" colspan="2">物品名称:${helpmebuy.goodsname}</td></tr>
		
		</table>
		 <c:if test="${helpmebuy.status=='1'}">
		<table width="100%"  cellspacing="0" cellpadding="0" class="e">
	

	<tr>
	<td>
			<a href="HquxUI.action?userid=${userid}&id=${helpmebuy.id}">取消订单</a>
	</td>
	</tr>
	
	</table>
  	</c:if>   
  </body>
</html>
