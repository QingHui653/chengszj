<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../../common/head.jsp"%>
<title>在线支付成功列表</title>


<%-- <script type="text/javascript" src="<%=path%>/JS/check.js"></script> --%>
<script type="text/javascript" src="<%=path%>/JS/jquery-1.9.1.min.js"></script>
<script>
$(function(){
	$("#buttons").click(function(){
	
				var ks=$("#ks").val();
				var js=$("#js").val();
				if(ks==''){
				alert("请选择开始时间");
				return false;
				}
				if(js==''){
				alert("请选择结束时间");
				return false;
				}
				
				
				
			 var yeare=parseInt(js.substring(0,4),10);
   			 var monthe=parseInt(js.substring(5,7)-1,10);
   		 	var daye=parseInt(js.substring(8,10),10);
			var endDate = new Date(yeare, monthe, daye); 
			
			var d = new Date();// 当前时间
			//var vYear = d.getFullYear();
			// vMon = d.getMonth();
			//var vDay = d.getDate();
			//var CurrentDate = new Date(vYear, vMon, vDay); 
			var leftTime1=endDate.getTime()-d.getTime(); 
			var leftsecond1 = parseInt(leftTime1/1000); 
			var day2=Math.floor(leftsecond1/(60*60*24)); //计算结束时间是否大于当前时间
			var dd2= day2*1;
			if(dd2>=0){
			alert("结束时间不能大于当前日期");
			return false;
			}
			var yearb=parseInt(ks.substring(0,4),10);
   		    var monthb=parseInt(ks.substring(5,7)-1,10);
    	    var dayb=parseInt(ks.substring(8,10),10);
			
			 var beginDate = new Date(yearb, monthb, dayb); 
			 var leftTime=endDate.getTime()-beginDate.getTime(); 
			var leftsecond = parseInt(leftTime/1000); 
			var day1=Math.floor(leftsecond/(60*60*24)); 
			
			var dd= day1*1;
			//alert(dd);
			if(dd<0){
				alert("结束时间不能早于开始时间");
				return false;
			}else{
				$("#forms").submit(); 
			}
			
	
	
	})
	
})
	
			


</script>
</head>

<body>
 <div class="lists">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0"></table>

          	 <tr>
          	 <td>总共收入:${count}</td>
               <td height="20"><span>
              <!--  <input id="selAll" type="button" value="全选" />
               <input id="reverSel" type="button" value="反选" />
                <input id="unSelAll" type="button" value="全不选" /></span>
                 <input  type="button"  value="添加管理员" id="add"/>
	              <input  type="button"  value="删除管理员" id="del" /> -->
	              <form action="listZiJin.action?type=Y" method="post" id="forms">
	             	 开始时间:<input type="date" name="kstime" value="${kstime}" id="ks" >    结束时间:<input type="date" name="jstime" value="${jstime}" id="js"> <input type="button" name="" value="查询" id="buttons">
			        </form>    
                  </td>
          	 </tr> 
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="11" align="center" bgcolor="#EEEEEE"class="tablestyle_title" style="text-align:center;">在线支付成功列表</td>
                    </tr>
                  <tr>
				   <!--  <td width="5%" align="center" bgcolor="#EEEEEE">
                    <input  class="btn btn-default" type="checkbox" id="operAll" />选择</td> -->
                    <td width="5%" height="20" align="center" bgcolor="#EEEEEE">ID</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">支付人</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">金额</td>
                   <!--  <td width="8%" align="center" bgcolor="#EEEEEE">收货地</td> -->
					<td width="8%" align="center" bgcolor="#EEEEEE">所支付的订单</td>
						 <td width="8%" align="center" bgcolor="#EEEEEE">状态</td>
                 	  	 <td width="8%" align="center" bgcolor="#EEEEEE">时间</td>
                 	  	 <td width="8%" align="center" bgcolor="#EEEEEE">支付宝交易订单</td>
                     <!--   <td width="8%" align="center" bgcolor="#EEEEEE">操作</td> -->
                  </tr>
               <c:forEach items="${list}" var="Onlinepayment">
 
    			 
                 <tr align="center">
	 				 <%-- <td bgcolor="#FFFFFF">
	 				 <input type="checkbox" name="adminid" value="${User.id}" ></td> --%>
        			  <td height="20" bgcolor="#FFFFFF">${Onlinepayment.id}</td>
        			   <td bgcolor="#FFFFFF"><a href="UserDetail.action?type=D&userid=${Onlinepayment.userid}" target="_blank">${Onlinepayment.userid}</a></td>
        			<%--  <td height="20" bgcolor="#FFFFFF">${Onlinepayment.userid}</td> --%>
        			 <td bgcolor="#FFFFFF">${Onlinepayment.money}</td>
              
                    <%-- <td bgcolor="#FFFFFF">${Onlinepayment.receiptId}</td> --%>
                    	<td bgcolor="#FFFFFF"><a href="Rdetail.action?id=${Onlinepayment.receiptId}" target="_blank">${Onlinepayment.receiptId}</a></td>
                      <td bgcolor="#FFFFFF">
                      <c:if test="${Onlinepayment.status=='S'}">支付成功</c:if>
                        <c:if test="${Onlinepayment.status=='F'}">未支付</c:if>
                     </td>
                       <td bgcolor="#FFFFFF">${Onlinepayment.time}</td>
                         <td bgcolor="#FFFFFF">${Onlinepayment.orderNumber}</td>
                  
						
						
						

                       
                  <%--   <td bgcolor="#FFFFFF">  <a href="UserDetail.action?type=${type}&id=${User.id}" onclick="return del()">修改</a>
                    
                    --%><%--  | <a href="feedbackC.action?id=${feekback.id}&types=F&userid=${feekback.userid}"  onclick="return del()">不采纳</a></td>
                  --%>
                  </tr>  
                  </c:forEach>  
                  </table>
      
      <c:if test="${type=='N'}">
     	<table width="100%" class="sxye">
    	<tr>
    		<td align="right" width="50%">
    			<c:choose>
    			<c:when test="${pageSupport.startPage!=1}"><a href="listZiJin.action?type=N&pageNo=${pageSupport.prePage}">上一页</a></c:when>	
    			<c:when test="${pageSupport.startPage!=1}"><a href="listZiJin.action?type=Y&kstime=${kstime}&jstime=${jstime}&pageNo=${pageSupport.prePage}">上一页</a></c:when>	
    			</c:choose></td>
    	<td width="50%" align="left"> 
    	<c:choose>
   	 <c:when test="${pageSupport.nextPage<=pageSupport.totalPages}"><a href="listZiJin.action?type=N&pageNo=${pageSupport.nextPage}">下一页</a></c:when>
   	 </c:choose>
    	</td>
    	</tr>
    	</table>  
    	</c:if>
    	
    	
    	<c:if test="${type=='Y'}">
    	<table width="100%" class="sxye">
    	<tr>
    		<td align="right" width="50%">
    			<c:choose>
    			<c:when test="${pageSupport.startPage!=1}"><a href="listZiJin.action?type=Y&kstime=${kstime}&jstime=${jstime}&pageNo=${pageSupport.prePage}">上一页</a></c:when>	
    			</c:choose></td>
    	<td width="50%" align="left"> 
    	<c:choose>
    	<c:when test="${pageSupport.nextPage<=pageSupport.totalPages}"><a href="listZiJin.action?type=Y&kstime=${kstime}&jstime=${jstime}&pageNo=${pageSupport.nextPage}">下一页</a></c:when>
  	  </c:choose>
    	</td>
    	</tr>
    	</table>  
    	</c:if>
    	
   </div>
</body>
</html>
