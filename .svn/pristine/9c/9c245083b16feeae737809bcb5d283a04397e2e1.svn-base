<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<title>城市列表</title>

<style type="text/css">
.aa {text-decoration: none;color: #000}
.divss{ 
width: 130px;height:30px;background-color:orange;line-height:30px; text-align: center;vertical-align: middle;
  }
.divs{ 
width: 150px;height:30px;background-color:#E0E0E0;line-height:30px; text-align: center;vertical-align: middle;
  }
 .divOver{
  background:#3992D0;

 } 
</style>
<script type="text/javascript" src="<%=path%>/JS/jquery-1.9.1.min.js"></script>  
 





<script language="javascript">
  $(function(){
   //当鼠标滑入时将div的class换成divOver
   $('.divs').hover(function(){
     $(this).addClass('divOver');  
   },function(){
     //鼠标离开时移除divOver样式
     $(this).removeClass('divOver'); 
   }
   );
  });
 </script>
 
</head>

<body>
		<a href="addCityUI.action?type=C" class="aa"><div class="divss" style="margin-left:420px;">新增城市</div></a>
 		<table style="margin-left: 100px;">
 	
 		<tr>
 		<c:forEach items="${list}" var="G" varStatus="NA">
 			<td><a href="cityDetail.action?id=${G.id}&type=C" class="aa"><div class="divs">${fn:substring(G.name, 0, 7)}<c:if test="${G.name.length()>9}">...</c:if></div></a></td>
 			  <c:if test="${NA.count%6==0}">
				</tr>
			<tr>
			</c:if>
 		</c:forEach>
 			
 			
 		</tr>
 		
 		</table>
  
</body>
</html>
