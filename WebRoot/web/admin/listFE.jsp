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
                    <td height="20" colspan="6" align="center" bgcolor="#EEEEEE"class="tablestyle_title" style="text-align:center;">自由快递人审核表</td>
                    </tr>
                  <tr>
			<!-- 	    <td width="5%" align="center" bgcolor="#EEEEEE">
                    <input  class="btn btn-default" type="checkbox" id="operAll" />
                    
                    选择</td> -->
                    <td width="5%" height="20" align="center" bgcolor="#EEEEEE">用户账号</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">真实姓名人</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">身份证号</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">具体详情</td>

                    <td width="8%" align="center" bgcolor="#EEEEEE">状态</td>
                     <td width="8%" align="center" bgcolor="#EEEEEE">申请时间</td>
                      <!--  <td width="8%" align="center" bgcolor="#EEEEEE">操作</td> -->
                  </tr>
               <c:forEach items="${pageSupport.result}" var="freeexpress">
 
    			 
                 <tr align="center">
	 			<%-- 	 <td bgcolor="#FFFFFF">
	 				 <input type="checkbox" name="adminid" value="${freeexpress.id}" ></td> --%>
        			  <td height="20" bgcolor="#FFFFFF">${freeexpress.userid}</td>
        			 <td height="20" bgcolor="#FFFFFF">${freeexpress.realName}</td>
                      <td bgcolor="#FFFFFF">${freeexpress.idcard}</td>
                       <td bgcolor="#FFFFFF"><a href="FEdetail.action?id=${freeexpress.id}">查看内容</a></td>
                         <td bgcolor="#FFFFFF"><c:if test="${freeexpress.status=='1'}">未审核</c:if></td>
                    <td bgcolor="#FFFFFF">${freeexpress.time}</td>


                     
                  <%--   <td bgcolor="#FFFFFF">  <a href="feedbackC.action?id=${feekback.id}&types=S&userid=${feekback.userid}" onclick="return del()">采纳</a>| <a href="feedbackC.action?id=${feekback.id}&types=F&userid=${feekback.userid}"  onclick="return del()">不采纳</a></td> --%>
                  </tr>  
                  </c:forEach>  
                  </table>
                  	<table width="100%" class="sxye">
    	<tr>
    		<td align="right" width="50%">
    			<c:choose>
    	<c:when test="${pageSupport.startPage!=1}"><a href="listFEW.action?pageNo=${pageSupport.prePage}">上一页</a></c:when>	
    	</c:choose></td>
    	<td width="50%" align="left"> 
    	<c:choose><c:when test="${pageSupport.nextPage<=pageSupport.totalPages}"><a href="listFEW.action?pageNo=${pageSupport.nextPage}">下一页</a></c:when>
    	</c:choose>
    	</td>
    	</tr>
    	</table>  
   </div>
</body>
</html>
