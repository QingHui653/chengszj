<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<title>快递人列表</title>

<script  src="<%=path%>/JS/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script type="text/javascript" src="<%=path%>/JS/checks.js"></script>
</head>

<body>
 <div class="lists">
		<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0"></table>

          	 <tr>
               <td height="20"><span>
               <input id="selAllss" type="button" value="全选" />
               <input id="reverSel" type="button" value="反选" />
                <input id="unSelAll" type="button" value="全不选" /></span>
                
   
	              <input  type="button"  value="删除" id="del" />
	             
                  </td>
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="9" align="center" bgcolor="#EEEEEE"class="tablestyle_title" style="text-align:center;">自由快递人信息列表</td>
                    </tr>
                  <tr>
				    <td width="5%" align="center" bgcolor="#EEEEEE">
                    <input  class="btn btn-default" type="checkbox" id="operAll" />
                    
                    选择</td>
                    <!-- <td width="5%" height="20" align="center" bgcolor="#EEEEEE">ID</td> -->
                    <td width="8%" align="center" bgcolor="#EEEEEE">账号</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">真实姓名</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">身份证号</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">所在地区</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">紧急联络人</td>
                    <td width="8%" align="center" bgcolor="#EEEEEE">联络人号码</td>
      				<td width="8%" align="center" bgcolor="#EEEEEE">点击详细内容</td>
      
                       <td width="8%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                 <c:forEach items="${pageSupport.result}" var="freeexpress">
 
    			 
                 <tr align="center">
	 				 <td bgcolor="#FFFFFF"><input type="checkbox" name="id" value="${freeexpress.id}" ></td>
                    <td height="20" bgcolor="#FFFFFF">${freeexpress.userid}</td>
                    <td bgcolor="#FFFFFF">${freeexpress.realName}</td>
         			  <td bgcolor="#FFFFFF">${freeexpress.idcard}</td>
                    <td bgcolor="#FFFFFF">${freeexpress.area}</td>
                    <td bgcolor="#FFFFFF">${freeexpress.contact}</td>
                    <td bgcolor="#FFFFFF">${freeexpress.contactPhone}</td>
                     <td bgcolor="#FFFFFF"><a href="FEdetailss.action?id=${freeexpress.id}" target="_blank" >查看内容</a></td>
                   
                    <td bgcolor="#FFFFFF"> <a href="deleteFE.action?id=${freeexpress.id}"  onclick="return del()">删除</a></td>
                  </tr>  
    		</c:forEach>    
                </table>
                
            <table width="100%" class="sxye">
    	<tr>
    		<td align="right" width="50%">
    			<c:choose>
    		<c:when test="${pageSupport.startPage!=1}">
    		
    			<a href="listFE.action?pageNo=${pageSupport.prePage}">上一页</a>
    					</c:when>	
    	</c:choose>
    			</td>
    	
    	<td width="50%" align="left"> 
    	<c:choose>
    		<c:when test="${pageSupport.nextPage<=pageSupport.totalPages}">
    		
    			<a href="listFE.action?pageNo=${pageSupport.nextPage}">下一页</a>
    			</c:when>
    			</c:choose>
    			</td>
    			
    	</tr>
    
     </table> 
               
   </div>
</body>
</html>
