<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<title>网吧详情</title>
<style type="text/css">

</style>
<script  src="<%=path%>/JS/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script  src="<%=path%>/JS/image.js" type="text/javascript" ></script>
<script>
$(function(){	
		$("#uploadImage").hide();
		$("#uploadPreview").click(function(){
		$("#uploadImage").click();
		}) 
		})
</script>
  </head>
  <body>
  <form action="updateimg.action" method="post" enctype="multipart/form-data">
  <input type="hidden" name="id" value="${backset.id}">
   <input type="hidden" name="type" value="${backset.type}">
  	<table style="margin-left: 30%;text-align: center;">
  	<tr><td colspan="2">
  	<input type="file" name="image" id="uploadImage" onchange="loadImageFile();"  >
  	<img id="uploadPreview" style="width: 350px; height: 300px;border-radius:10px;" src="<c:if test="${!empty backset.name}"><%=path%>${backset.name}</c:if>" alt="Image preview" />
	</td></tr>
  		<tr><td colspan="2" style="font-size: 10px;color: red; padding-bottom: 5px">点击图片可修改</td></tr>
  		<tr><td>说明</td><td><textarea rows="8"  cols="" name="intro" style="width: 300px;height: 100px" >${backset.intro}</textarea>  <%-- <input   type="text" name="imagename" value="${imagess.imagename}" > --%></td></tr>
  		<tr><td colspan="2"> <input type=submit value="确 定"/></td></tr>
  	</table>
 	 
    </form>
  
  </body>
</html>
