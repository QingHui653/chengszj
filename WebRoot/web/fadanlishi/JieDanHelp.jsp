<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../../common/head.jsp"%>
<head>
<!-- <meta http-equiv='refresh' content='0;url=newss.action'> -->
<title></title>
<style type="text/css">
.table{border:2px solid #D2D2D2; margin-top: 5px; }
.table td{border: none;padding-top: 7px;}
.sp{color: #FE9C09}
.as{border:2px solid #D2D2D2; border-top: none; }
.as td{padding:7px; text-align: center;}
</style>
  </head>
  
  <body>
  	<c:forEach items="${helpmebuys}" var="Helpmebuy">
  	 <a href="Hdetail.action?id=${Helpmebuy.id}&userid=${userid}" style="color: #000000">
       <table width="100%"  cellspacing="0" cellpadding="0"  height="100%" align="center" id="ttt" class="table">
			<tr>
				<td><img src="<%=path%>/images/mai.png"></td><td><span class="sp">

				<c:if test="${Helpmebuy.status=='2'}">[配送中]</c:if>
				<c:if test="${Helpmebuy.status=='3' }">[已取消]</c:if>
				<c:if test="${Helpmebuy.status=='4' }">[已送达]</c:if>
				<c:if test="${Helpmebuy.status=='5' }">[未送达]</c:if>
				</span>两地距离${fn:substring(Helpmebuy.jingwei, 0, 4)}千米</td><td><span class="sp"><%-- ${fn:substring(Helpmebuy.reward, 0, 2)} --%>${Helpmebuy.reward} 元</span></td>
			</tr>
			<tr>
				<td align="right">&nbsp;起:&nbsp;</td><td style="color: #B0B0B0">${Helpmebuy.purchaseLand }</td>
			</tr>
			<tr>
				<td align="right">&nbsp;到:&nbsp;</td><td style="color: #B0B0B0">${Helpmebuy.receivingLand }</td>
			</tr>
			<c:if test="${Helpmebuy.status=='2'||Helpmebuy.status=='4'||Helpmebuy.status=='5'}">
				<tr><td colspan="3" align="right" style="padding-right: 15px;"><span class="sp">联系订单主人<img src="<%=path%>/images/dh.png"><%-- :${receipt.userid } --%></span> </td></tr>
				</c:if>
         </table>
          </a>
         <c:if test="${Helpmebuy.status=='2'||Helpmebuy.status=='4'||Helpmebuy.status=='5'}">
		 
  		  <table width="100%"  cellspacing="0" cellpadding="0"  height="100%" align="center" id="ttt" class="as">
		
				<tr>
		<td colspan="3" align="center">发单时间 ${Helpmebuy.time }</td>
		 	
		 	
		 	 </tr>
		
		</table>
		</c:if>
	</c:forEach>
  </body>
</html>
