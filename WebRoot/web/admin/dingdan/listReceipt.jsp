<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../../common/head.jsp"%>
<title>帮我送发单列表</title>


  <script language="javascript"> 
  function del(){
if(confirm("确定?")){
return true;
}else{
return false;
}
}
</script>
</head>

<body>
 <div class="lists">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0"></table>
<!-- 
          	 <tr>
               <td height="20"><span>
               <input id="selAll" type="button" value="全选" />
               <input id="reverSel" type="button" value="反选" />
                <input id="unSelAll" type="button" value="全不选" /></span>
                 <input  type="button"  value="添加管理员" id="add"/>
	              <input  type="button"  value="删除管理员" id="del" />
	             
                  </td>
          	 </tr> -->
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="10" align="center" bgcolor="#EEEEEE"class="tablestyle_title" style="text-align:center;">帮我送发单列表</td>
                    </tr>
                  <tr>
				   <!--  <td width="5%" align="center" bgcolor="#EEEEEE">
                    <input  class="btn btn-default" type="checkbox" id="operAll" />选择</td> -->
                    <td width="5%" height="20" align="center" bgcolor="#EEEEEE">ID</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">物品名称</td>
                  
                    <td width="8%" align="center" bgcolor="#EEEEEE">城市</td>
					 <td width="8%" align="center" bgcolor="#EEEEEE">总费用</td>
					<td width="8%" align="center" bgcolor="#EEEEEE">发货人账号</td>
					  <td width="8%" align="center" bgcolor="#EEEEEE">支付方式</td>
					<td width="8%" align="center" bgcolor="#EEEEEE">订单状态</td>
				<!-- 	<td width="8%" align="center" bgcolor="#EEEEEE">评价</td> -->
					<td width="8%" align="center" bgcolor="#EEEEEE">接单人账号</td>
                 	 <td width="8%" align="center" bgcolor="#EEEEEE">订单详情</td>
                 	  <td width="8%" align="center" bgcolor="#EEEEEE">客服处理</td>
                     <!--   <td width="8%" align="center" bgcolor="#EEEEEE">操作</td> -->
                  </tr>
               <c:forEach items="${list}" var="Receipt">
 
    			 
                 <tr align="center">
	 				 <%-- <td bgcolor="#FFFFFF">
	 				 <input type="checkbox" name="adminid" value="${User.id}" ></td> --%>
        			  <td height="20" bgcolor="#FFFFFF">${Receipt.id}</td>
        			 <td height="20" bgcolor="#FFFFFF">${Receipt.itemName}</td>
                      <td bgcolor="#FFFFFF">${Receipt.currentCity}</td>
                    <td bgcolor="#FFFFFF">${Receipt.shippingCost}</td>
                     <td bgcolor="#FFFFFF"><a href="UserDetail.action?type=D&userid=${Receipt.userid}" target="_blank">${Receipt.userid}</a></td>
                     <td bgcolor="#FFFFFF"> 
                     <c:if test="${Receipt.paymentType=='X'}">现付</c:if>
                     <c:if test="${Receipt.paymentType=='O'}">在线支付</c:if>
                     </td>
						 <td bgcolor="#FFFFFF">
						 <c:if test="${Receipt.status=='1'}">已发单未支付</c:if>
						  <c:if test="${Receipt.status=='2'&&Receipt.paymentType=='O'}">已支付未被接</c:if>
						  <c:if test="${Receipt.status=='2'&&Receipt.paymentType=='X'}">单未被接</c:if>
						   <c:if test="${Receipt.status=='3'}">已接单</c:if>
						    <c:if test="${Receipt.status=='4'}">已送达</c:if>
						     <c:if test="${Receipt.status=='5'}">订单完成</c:if>
						      <c:if test="${Receipt.status=='6'}">已取消</c:if>
						       <c:if test="${Receipt.status=='7'}">客服处理结束</c:if>
						 </td>
						 <td bgcolor="#FFFFFF"><a href="UserDetail.action?type=D&userid=${Receipt.liuyan}" target="_blank">${Receipt.liuyan}</a></td>
						<td bgcolor="#FFFFFF"><a href="Rdetail.action?id=${Receipt.id}" target="_blank">具体详情</a></td>
						<td bgcolor="#FFFFFF">
						<c:if test="${Receipt.status=='3'||Receipt.status=='4'}">
						<a href="RkefuCancel.action?id=${Receipt.id}&type=F&userid=${Receipt.liuyan}" onclick="return del()">发单人过错</a><br><a href="RkefuCancel.action?id=${Receipt.id}&type=J" onclick="return del()">接单人过错</a>
						</c:if>
						<c:if test="${Receipt.status=='7'}">
						客服已处理
						</c:if>
						
						</td>
						
						
						

                       
                  <%--   <td bgcolor="#FFFFFF">  <a href="UserDetail.action?type=${type}&id=${User.id}" onclick="return del()">修改</a>
                    
                    --%><%--  | <a href="feedbackC.action?id=${feekback.id}&types=F&userid=${feekback.userid}"  onclick="return del()">不采纳</a></td>
                  --%>
                  </tr>  
                  </c:forEach>  
                  </table>
      
     	<table width="100%" class="sxye">
    	<tr>
    		<td align="right" width="50%">
    			<c:choose>
    	<c:when test="${pageSupport.startPage!=1}"><a href="listReceiptss.action?pageNo=${pageSupport.prePage}">上一页</a></c:when>	
    	</c:choose></td>
    	<td width="50%" align="left"> 
    	<c:choose><c:when test="${pageSupport.nextPage<=pageSupport.totalPages}"><a href="listReceiptss.action?pageNo=${pageSupport.nextPage}">下一页</a></c:when>
    	</c:choose>
    	</td>
    	</tr>
    	</table>  
   </div>
</body>
</html>
