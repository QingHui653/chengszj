<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../../common/head.jsp"%>
<head>
<!-- <meta http-equiv='refresh' content='0;url=newss.action'> -->
<%-- <link href="<%=path %>/Css/style.css" rel="stylesheet" type="text/css"> --%>
<title>帖子</title>
  </head>
  
  <body>
  		<table width="100%">
  			<tr>
  				<td  align="center" style="background-color: #DDDDDD">提现记录</td>
  			</tr>
  			
  			<c:forEach items="${list}" var="Withdrawals">
  			
  			<tr>
  			
  				<td width="100%" style=" border-bottom: 3px solid #DDDDDD; padding-left:13%;line-height: 22px;"><div>${fn:substring(Withdrawals.time, 0, 16)}<span style="padding-left: 30px;color: red;"><c:if test="${Withdrawals.status=='Z'}">提现审核中</c:if><c:if test="${Withdrawals.status=='S'}">提现成功</c:if><c:if test="${Withdrawals.status=='F'}">提现失败</c:if></span></div>
  				<div style="color: red;">
  				提现${Withdrawals.money}元【城市之间】</div> 
  				</td>
  			</tr>
  			</c:forEach>
  			
  		</table>
  
  </body>
</html>
