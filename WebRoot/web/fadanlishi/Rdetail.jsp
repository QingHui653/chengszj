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
	
		<tr ><td width="25%" height="35px;"  >预计送达</td><td >${receipt.finishTime}小时内</td></tr>
		<tr><td width="25%" height="35px;"  >付款方式</td><td>现付(取货时现金支付)</td></tr>
		<tr><td width="25%" height="35px;">费用</td><td>${receipt.shippingCost}元</td></tr>
		</table>
		<table width="100%"  cellspacing="0" cellpadding="0" class="b">
		<tr><td width="25%" height="35px;">发货人</td><td>${receipt.shipper}</td></tr>
		<tr><td width="25%" height="35px;">电话</td><td>${receipt.shipperPhone}</td></tr>
		<tr><td width="25%" height="35px;">发货地</td><td>${receipt.deliveryPlace}</td></tr>
		</table>
			<table width="100%"  cellspacing="0" cellpadding="0" class="c">
		<tr><td width="25%" height="35px;">收货人</td><td>${receipt.consignee}</td></tr>
		<tr><td width="25%" height="35px;">电话</td><td>${receipt.consigneePhone}</td></tr>
		<tr><td width="25%" height="35px;">收货地</td><td>${receipt.receivingLand}</td></tr>
		</table>
		<table width="100%"  cellspacing="0" cellpadding="0" class="d">
		<tr><td width="25%" height="35px;">重要说明</td><td>${receipt.textExplain}</td></tr>
			</table>
	
	<table width="100%"  cellspacing="0" cellpadding="0" class="f">
		<tr><td  height="25px;" colspan="2" style="border-bottom: 1px solid;">物品信息</td></tr>
		<tr><td  height="35px;" colspan="2">物品名称:${receipt.itemName}</td></tr>
		<tr><td width="50%" height="35px;">物品类型:${receipt.itemType}</td><td>物品价值:${receipt.itemValue}</td></tr>
		<tr><td width="50%" height="35px;" >物品重量:${receipt.itemWeight}</td><td>交通工具:${receipt.vehicle}</td></tr>
		
		</table>
		 <c:if test="${receipt.status=='1'}">
		<table width="100%"  cellspacing="0" cellpadding="0" class="e">
	

	<tr>
	<td>
			<a href="RquxUI.action?userid=${userid}&id=${receipt.id}">取消发货</a>
	</td>
	</tr>
	
	</table>
  	</c:if>   
  </body>
</html>
