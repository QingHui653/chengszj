<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<title>管理员列表</title>



</head>

 <script type="text/javascript" src="<%=path%>/JS/jquery-1.9.1.min.js"></script>  
  <script language="javascript"> 
  function del(){
if(confirm("确定删除?")){
return true;
}else{
return false;
}
}
  $(function(){
  	$("#addA").click(function(){
  	location.href="addAUI.action"; 
  	})
  
  })
  
	
</script>

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
          	  <input  type="button"  value="添加管理员" id="addA"/>
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="8" align="center" bgcolor="#EEEEEE"class="tablestyle_title" style="text-align:center;">管理员列表</td>
                    </tr>
                  <tr>
				   <!--  <td width="5%" align="center" bgcolor="#EEEEEE">
                    <input  class="btn btn-default" type="checkbox" id="operAll" />
                    
                    选择</td> -->
                    <td width="8%" height="8" align="center" bgcolor="#EEEEEE">用户账号</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">姓名</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">密码</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">类型</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">联系方式</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">城市</td>
                     <td width="8%" align="center" bgcolor="#EEEEEE">区域</td>
					<td width="8%" align="center" bgcolor="#EEEEEE">操作</td>
                  
                  </tr>
               <c:forEach items="${pageSupport.result}" var="Admin">
 
    			 
                 <tr align="center">
	 				<%--  <td bgcolor="#FFFFFF">
	 				 <input type="checkbox" name="adminid" value="${Admin.id}" ></td> --%>
        			  <td height="20" bgcolor="#FFFFFF">${Admin.name}</td>
        			 <td height="20" bgcolor="#FFFFFF">${Admin.nickname}</td>
                      <td bgcolor="#FFFFFF">${Admin.password}</td>
                       <td bgcolor="#FFFFFF"><c:if test="${Admin.type=='A'}">总管理员</c:if><c:if test="${Admin.type=='B'}">区域管理员</c:if>  </td>
                      <td bgcolor="#FFFFFF">${Admin.phone}</td>
                      <td bgcolor="#FFFFFF">${Admin.city}</td>
                      <td bgcolor="#FFFFFF">${Admin.area}</td>
                      <td bgcolor="#FFFFFF"><a href="updateAdminUI.action?id=${Admin.id}">修改</a>|<a href="deleteAdmin.action?id=${Admin.id}" onclick="return del()">删除</a></td>
                    </tr>  
                  </c:forEach>  
                  </table>
                  	<table width="100%" class="sxye">
    	<tr>
    		<td align="right" width="50%">
    			<c:choose>
    	<c:when test="${pageSupport.startPage!=1}"><a href="findAdmin.action?pageNo=${pageSupport.prePage}">上一页</a></c:when>	
    	</c:choose></td>
    	<td width="50%" align="left"> 
    	<c:choose><c:when test="${pageSupport.nextPage<=pageSupport.totalPages}"><a href="findAdmin.action?pageNo=${pageSupport.nextPage}">下一页</a></c:when>
    	</c:choose>
    	</td>
    	</tr>
    	</table>  
   </div>
</body>
</html>
