<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<title>无标题文档</title>


<script type="text/javascript" src="<%=path%>/JS/check.js"></script>
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
                    <td height="20" colspan="9" align="center" bgcolor="#EEEEEE"class="tablestyle_title" style="text-align:center;">提现信息列表</td>
                    </tr>
                  <tr>
				    <td width="5%" align="center" bgcolor="#EEEEEE">
                    <input  class="btn btn-default" type="checkbox" id="operAll" />
                    
                    选择</td>
                    <td width="5%" height="20" align="center" bgcolor="#EEEEEE">ID</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">支付宝账号</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">支付宝名字</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">金额</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">登入人账号</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">申请时间</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">状态</td>
                       <td width="8%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
               <c:forEach items="${pageSupport.result}" var="Withdrawals">
 
    			 
                 <tr align="center">
	 				 <td bgcolor="#FFFFFF">
	 				 <input type="checkbox" name="adminid" value="${Withdrawals.id}" ></td>
        			 <td height="20" bgcolor="#FFFFFF">${Withdrawals.id}</td>
                      <td bgcolor="#FFFFFF">${Withdrawals.cardNumber}</td>
                    <td bgcolor="#FFFFFF">${Withdrawals.name}</td>
                    <td bgcolor="#FFFFFF">${Withdrawals.money}</td>
                    <td bgcolor="#FFFFFF">${Withdrawals.userid}</td>
                    <td bgcolor="#FFFFFF">${Withdrawals.time}</td>
                       <td bgcolor="#FFFFFF"><c:if test="${Withdrawals.status=='Z'}">审核中</c:if></td>
                    <td bgcolor="#FFFFFF">  <a href="tixianshenhe.action?id=${Withdrawals.id}&types=S&userid=${Withdrawals.userid}" onclick="return del()">通过</a>| <a href="tixianshenhe.action?id=${Withdrawals.id}&types=F&userid=${Withdrawals.userid}"  onclick="return del()">不通过</a></td>
                  </tr>  
                  </c:forEach>  
                  </table>
                  	<table width="100%" class="sxye">
    	<tr>
    		<td align="right" width="50%">
    			<c:choose>
    	<c:when test="${pageSupport.startPage!=1}"><a href="tishenhe.action?pageNo=${pageSupport.prePage}">上一页</a></c:when>	
    	</c:choose></td>
    	<td width="50%" align="left"> 
    	<c:choose><c:when test="${pageSupport.nextPage<=pageSupport.totalPages}"><a href="tishenhe.action?pageNo=${pageSupport.nextPage}">下一页</a></c:when>
    	</c:choose>
    	</td>
    	</tr>
    	</table>  
   </div>
</body>
</html>
