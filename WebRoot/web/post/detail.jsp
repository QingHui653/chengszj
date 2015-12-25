<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../../common/head.jsp"%>
<head>
<meta name="viewport" content="target-densitydpi=device-dpi, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<script type='text/javascript'> 

</script>

<title>帖子</title>
  </head>
  
  <body>
  	
  	<table width="100%" border="0" height="100%" align="center" id="ttt">
        	 <th align="center" width="100%" colspan="2" bgcolor="#E3E3E3" id="one">${post.title}</th>
            
        	<tr >
            	<td width="70%" align="left">用户:${post.name}</td>
               	
                <td width="30%"  align="right">楼主</td>
            </tr>
            <tr>
            	<td colspan="2">${post.content}</td>
            </tr>
            	
            <tr>
            	<td>${post.time}</td>
                <td></td>
            </tr>
             <th align="center" width="100%" colspan="2" bgcolor="#E3E3E3" id="one" ></th>
          
            </table>
           
           
          
           <c:forEach items="${listTiezis}" var="Reply">
           <table width="100%">
          	<tr >
            	<td width="100%" align="left" colspan="2">用户:${Reply.name}</td>
              	  <td width="30%"  align="right"></td>
            </tr>
            <tr>
            	<td width="100%" style="word-break:break-word">${Reply.content}</td><td></td>
            </tr>
           
             <tr>
            	<td colspan="2">${Reply.time}</td>
                
            </tr> 
           <th align="center" width="100%" colspan="2" bgcolor="#E3E3E3" id="one" ></th>
        </c:forEach>
        </table>
        
        	<table width="100%" class="sxye">
    	<tr>
    		<td align="right" width="50%">
    			<c:choose>
    	<c:when test="${pageSupport.startPage!=1}"><a href="TieziDetail.action?id=${post.id}&userid=${userid}&pageNo=${pageSupport.prePage}">上一页</a></c:when>	
    	</c:choose></td>
    	<td width="50%" align="left"> 
    	<c:choose><c:when test="${pageSupport.nextPage<=pageSupport.totalPages}"><a href="TieziDetail.action?id=${post.id}&userid=${userid}&pageNo=${pageSupport.nextPage}">下一页</a></c:when>
    	</c:choose>
    	</td>
    	</tr>
    	</table>  
        <form action="huitie.action?id=${post.id}&userid=${userid}" method="post">
       <table width="100%" border="0" height="100%" align="center" id="ttt">
        	<tr>
        	<td><textarea rows="" cols="" name="content" style="width: 98%;height:150px;"  ></textarea></td>
        	</tr>
        	<tr> <td align="center"><input type="submit" value="回复"></input><td> </tr>
        </table>
  	</form>
  </body>
</html>
