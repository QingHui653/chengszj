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
  				<td  align="center" style="background-color: #DDDDDD">充值记录</td>
  			</tr>
  			
  			<c:forEach items="${list}" var="Recharge">
  			
  			<tr>
  			
  				<td width="100%" style=" border-bottom: 3px solid #DDDDDD; padding-left:13%;line-height: 22px;"><div>${fn:substring(Recharge.time, 0, 16)}</div>
  				<div style="color: red;">
  				充值${Recharge.money}元【城市之间】</div> 
  				</td>
  			</tr>
  			</c:forEach>
  			
  		</table>
  
  </body>
</html>
