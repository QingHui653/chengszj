<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../../common/head.jsp"%>
<title>会员列表</title>


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
                    <td height="20" colspan="10" align="center" bgcolor="#EEEEEE"class="tablestyle_title" style="text-align:center;">会员信息列表</td>
                    </tr>
                  <tr>
				   <!--  <td width="5%" align="center" bgcolor="#EEEEEE">
                    <input  class="btn btn-default" type="checkbox" id="operAll" />选择</td> -->
                    <td width="5%" height="20" align="center" bgcolor="#EEEEEE">ID</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">登入账号</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">昵称</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">积分</td>
					 <td width="8%" align="center" bgcolor="#EEEEEE">余额</td>
					<td width="8%" align="center" bgcolor="#EEEEEE">诚信等级</td>
					<td width="8%" align="center" bgcolor="#EEEEEE">手机号码</td>
					<td width="8%" align="center" bgcolor="#EEEEEE">职业</td>
					<td width="8%" align="center" bgcolor="#EEEEEE">是否为快递人</td>
                  
                       <td width="8%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
               <c:forEach items="${pageSupport.result}" var="User">
 
    			 
                 <tr align="center">
	 				 <%-- <td bgcolor="#FFFFFF">
	 				 <input type="checkbox" name="adminid" value="${User.id}" ></td> --%>
        			  <td height="20" bgcolor="#FFFFFF">${User.id}</td>
        			 <td height="20" bgcolor="#FFFFFF">${User.userid}</td>
        			 <td bgcolor="#FFFFFF">${User.name}</td>
                      <td bgcolor="#FFFFFF">${User.integral}</td>
                    <td bgcolor="#FFFFFF">${User.balance}</td>
						 <td bgcolor="#FFFFFF">${User.creditrating}</td>
						 <td bgcolor="#FFFFFF">${User.phone}</td>
						 <td bgcolor="#FFFFFF">${User.zhiye}</td>
						 <td bgcolor="#FFFFFF"><c:if test="${User.status=='N'}">不是</c:if><c:if test="${User.status=='Y'}">是</c:if> </td>
						 
						
						

                       
                    <td bgcolor="#FFFFFF">  <a href="UserDetail.action?type=${type}&id=${User.id}" onclick="return del()">修改</a>
                    
                   <%--  | <a href="feedbackC.action?id=${feekback.id}&types=F&userid=${feekback.userid}"  onclick="return del()">不采纳</a></td>
                  --%>
                  </tr>  
                  </c:forEach>  
                  </table>
      
     	<table width="100%" class="sxye">
    	<tr>
    		<td align="right" width="50%">
    			<c:choose>
    	<c:when test="${pageSupport.startPage!=1}"><a href="findAllUser.action?type=${type}&pageNo=${pageSupport.prePage}">上一页</a></c:when>	
    	</c:choose></td>
    	<td width="50%" align="left"> 
    	<c:choose><c:when test="${pageSupport.nextPage<=pageSupport.totalPages}"><a href="findAllUser.action?type=${type}&pageNo=${pageSupport.nextPage}">下一页</a></c:when>
    	</c:choose>
    	</td>
    	</tr>
    	</table>  
   </div>
</body>
</html>
