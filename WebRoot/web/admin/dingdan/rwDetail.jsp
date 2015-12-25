<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../../common/head.jsp"%>
<title>发任务详情</title>
<style type="text/css">
.ta{background-color: activecaption; width: 550px;}
.ta tr td{ padding-top: 5px;}
.ipt{width: 450px;}
</style>

  </head>
	
  <body>
    <div>
	 <table  class="ta" align="center">
     <input type="hidden" name="id" value="${helpmebuy.id}">
    <c:if test="${helpmebuy.goodsname==null}">
      <tr>
      <td>语音发任务</td>
   		<td style="text-align: center;"> <a href="downyuyin.action?yuying=${helpmebuy.yuying}" >点击下载语音</a></td>
   		</tr>
    </c:if>
    
    <c:if test="${helpmebuy.goodsname!=null}">
     <tr>
      <td>任务名称:</td><td><input  class="ipt" type="text" name=userid value="${helpmebuy.goodsname}" disabled="true"> </td>
   </tr>
   </c:if>
   <c:if test="${helpmebuy.purchaseAsk!=null}">
    <tr>
    <td>任务要求:</td>
    <td><div style="background-color:white;width:455px;word-wrap:break-word;word-break:break-all;overflow: hidden">${helpmebuy.purchaseAsk}</div>
     </td>
     </tr>
     </c:if>
        <c:if test="${helpmebuy.remark!=null}">
    <tr>
    <td>任务说明:</td>
    <td><div style="background-color:white;width:455px;word-wrap:break-word;word-break:break-all;overflow: hidden">${helpmebuy.remark}</div>
     </td>
     </tr> 
     </c:if>
     <tr>
   <td>酬劳:</td><td><input  class="ipt" type="text" name=userid value="${helpmebuy.reward}  元" disabled="true"></td>
    </tr>
       <tr>
     <td>收货地:</td><td><input class="ipt" type="text" name=userid value="${helpmebuy.receivingLand}" disabled="true"></td>
    </tr>
    <tr>
     <td>手机号码:</td><td><input class="ipt" type="text" name=userid value="${helpmebuy.phone}" disabled="true"></td>
    </tr>
    <tr>
     <td>支付方式:</td><td><input class="ipt" type="text" name=userid value=" <c:if test="${helpmebuy.paymenttype=='X'}">现金支付</c:if><c:if test="${helpmebuy.paymenttype=='O'}">在线支付</c:if>" disabled="true"></td>
    </tr>
 	<td>订单状态:</td><td><input type="text" class="ipt"   name=userid value="<c:if test="${helpmebuy.status=='1'}">已发单未支付</c:if><c:if test="${helpmebuy.status=='2'}">单未被接</c:if><c:if test="${helpmebuy.status=='3'}">单已被接</c:if><c:if test="${helpmebuy.status=='4'}">已送达</c:if><c:if test="${helpmebuy.status=='5'}">订单完成</c:if><c:if test="${helpmebuy.status=='6'}">已取消</c:if><c:if test="${helpmebuy.status=='7'}">客服处理结束</c:if>" disabled="true"></td>
    </tr>
   <c:if test="${helpmebuy.fpingjia!=null}"> 
	 <tr>														
	<td>发单人评价:</td><td><input type="text" class="ipt"  name=userid value="${helpmebuy.fpingjia}" disabled="true"></td>
  </tr> 
    </c:if>
    <c:if test="${helpmebuy.jpingjia!=null}"> 
	 <tr>														
	<td>接单人评价:</td><td><input type="text" class="ipt"  name=userid value="${helpmebuy.jpingjia}" disabled="true"></td>
  </tr> 
    </c:if>  
   <c:if test="${helpmebuy.cancel!=null}">
    <tr>
      <td>取消原因:</td><td><input type="text" class="ipt"  name=userid value="${helpmebuy.cancel}" disabled="true"></td>
    </tr>
    </c:if>
   <c:if test="${helpmebuy.liuyan!=null}">
    <tr>
    <td>留言:</td>
    <td><div style="background-color:white;width:455px;word-wrap:break-word;word-break:break-all;overflow: hidden">${helpmebuy.liuyan}</div>
     </td>
     </tr> 
     </c:if>
   </table>
    
 

			
    </form>
    </div>
  </body>
</html>