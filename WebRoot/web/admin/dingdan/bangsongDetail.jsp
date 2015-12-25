<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../../common/head.jsp"%>
<title>帮我送详情</title>
<style type="text/css">
.ta{background-color: activecaption; width: 626px;}
.ta tr td{ padding-top: 5px; }
.ipt{width: 460px;}
</style>

  </head>
 
  
  <body>
    <div>
	 <table  class="ta" align="center">
     <input type="hidden" name="id" value="${receipt.id}">
    <tr><td width="100px;">单发布时间:</td><td><input  type="text" name=userid value="${receipt.time}" disabled="true"></td>
   <td>当前城市:</td><td><input  type="text" name=userid value="${receipt.currentCity}" disabled="true"></td>
  
   </tr>
     <tr>
    <td>取货时间:</td><td><input type="text" name=userid value="${receipt.pickupTime}" disabled="true"></td>
   <td>物品类型:</td><td><input type="text" name=userid value="${receipt.itemType}" disabled="true"></td>
   
   <tr>
  <td>物品名称:</td><td><input type="text" name=userid value="${receipt.itemName}" disabled="true"></td>
   <td>物品重量:</td><td><input type="text" name=userid value="${receipt.itemWeight}  kg" disabled="true"></td>
    
   </tr>
     <tr>
     <td>物品价值:</td><td><input type="text" name=userid value="${receipt.itemValue}  元" disabled="true"></td>
   <td>支付方式:</td><td><input type="text" name=userid value="<c:if test="${receipt.paymentType=='O'}">在线支付</c:if><c:if test="${receipt.paymentType=='X'}">现金支付</c:if>" disabled="true"></td>
    </tr>
   
  
    
    <tr>
    <td>费用:</td><td><input type="text" name=userid value="${receipt.unitprice}  元" disabled="true"></td>
    <td>加价:</td><td><input type="text" name=userid value="${receipt.premium}  元" disabled="true"></td>
    </tr>
    <tr>
    <td>总费用:</td><td><input type="text" name=userid value="${receipt.shippingCost}  元" disabled="true"></td>
    <td>快递:</td><td><input type="text" name=userid value="${receipt.company}" disabled="true"></td>
   
    </tr>
    <tr>
   <td>交通工具:</td><td><input type="text" name=userid value="${receipt.vehicle}" disabled="true"></td>
    <td>身份证号码:</td><td><input type="text" name=userid value="${receipt.idCard}" disabled="true"></td>
    </tr>
    
    <tr>
    <td>发货人:</td><td><input type="text" name=userid value="${receipt.shipper}" disabled="true"></td>
    <td>手机号码:</td><td><input type="text" name=userid value="${receipt.shipperPhone}" disabled="true"></td>
  
    <tr>
    
    <td>收货人:</td><td><input type="text" name=userid value="${receipt.consignee}" disabled="true"></td>
     
     <td>手机号码:</td><td><input type="text" name=userid value="${receipt.consigneePhone}" disabled="true"></td>
   
  
      <tr>
      
    <td>收货地:</td><td colspan="3"><input class="ipt" type="text" name=userid value="${receipt.receivingLand}" disabled="true"></td>
    </tr>
   <tr> 
    <td>发货地:</td><td colspan="3"><input class="ipt" type="text" name=userid value="${receipt.deliveryPlace}" disabled="true"></td>
	 </tr>
	<tr>
    <td>订单状态:</td><td colspan="3"><input type="text" class="ipt"   name=userid value="<c:if test="${receipt.status=='1'}">已发单未支付</c:if><c:if test="${receipt.status=='2'}">单未被接</c:if><c:if test="${receipt.status=='3'}">单已被接</c:if><c:if test="${receipt.status=='4'}">已送达</c:if><c:if test="${receipt.status=='5'}">订单完成</c:if><c:if test="${receipt.status=='6'}">订单取消</c:if><c:if test="${receipt.status=='7'}">客服处理结束</c:if>" disabled="true"></td>
    </tr>
   
   <c:if test="${receipt.textExplain!=null&&receipt.textExplain!=''}"> 
     <tr> 
    <td>文字说明:</td>
    <td colspan="3" >
    <div style="background-color:white;width:465px;word-wrap:break-word;word-break:break-all;overflow: hidden" >${receipt.textExplain}</div>
	</td>
	</tr>
	 </c:if>
   <c:if test="${receipt.fpingjia!=null}"> 
	<tr>														
	<td>发单人评价:</td>
  	<td colspan="3" >
    <div style="background-color:white;width:465px;word-wrap:break-word;word-break:break-all;overflow: hidden" >${receipt.fpingjia}</div>
	</td>
    </tr>
   </c:if>
   
     <c:if test="${receipt.jpingjia!=null}"> 
	<tr>														
	<td>接单人评价:</td>
	<td colspan="3" >
    <div style="background-color:white;width:465px;word-wrap:break-word;word-break:break-all;overflow: hidden" >${receipt.jpingjia}</div>
	</td>
    </tr>
   </c:if>
   
     <c:if test="${receipt.cancel!=null}">
    <tr>
      <td>取消原因:</td>
      <td colspan="3"><input type="text" class="ipt"  name=userid value="${receipt.cancel}" disabled="true"></td>
    </tr>
    </c:if>
     
     <c:if test="${receipt.liuyan!=null}">
    <tr>
      <td>发单人留言:</td>
     <td colspan="3" >
    <div style="background-color:white;width:465px;word-wrap:break-word;word-break:break-all;overflow: hidden" >${receipt.liuyan}</div>
	</td>
    </tr>
    </c:if>
    
   </table>
    
 

			
    </form>
    </div>
  </body>
</html>
