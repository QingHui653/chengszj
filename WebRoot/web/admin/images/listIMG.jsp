<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<title>轮播图</title>
<style type="text/css">
.content{text-align: center;}
.a td{text-align: center;}
</style>

  </head>
  <script  src="<%=path%>/JS/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script language="javascript"> 
	//window.navigate("本页面url"); 
	
	$(function(){
		$("#bu").click(function(){
		
		window.location.reload();
		})
	})
	
</script> 

  <body>
  <div style="font-size: 10px;color: red;">（如果修改的图片没有立即刷新,点击旁边刷新按钮）<button id="bu">刷新图片</button></div>
  <table class="a">
  	<tr><td colspan="3" style="background-color:#68ACDB;padding-bottom: 5px"><c:if test="${list[0].type=='M'}">轮播图设置</c:if><c:if test="${list[0].type=='G'}">广告图设置</c:if><td>  </tr>
  <tr><td>第一张图</td><td>第二张图</td><td>第三张图</td></tr>
  	<tr>
  	<c:forEach items="${list}" var="IMG">
  
  	<td style="padding-left: 10px">
  		<a href="cityDetail.action?id=${IMG.id}" style="color: #000000;text-decoration: none;">
  	<div style="border:2px double  red">
  	<div style="border:2px double  #D7D7C9 "><img src="<%=path%>${IMG.name}" width="350" height="300"></div>
  	<div style="margin-top: 15px;">${IMG.intro}</div></a>
  	</div>
  	</td>
  	
  	</c:forEach>
  	</tr> 
  </table>
  </body>
</html>
