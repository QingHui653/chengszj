<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<title>添加管理员</title>
<style type="text/css">
.a{text-align: center;margin-left: 30%;margin-top: 10%}
.a td{border:1px solid; padding: 3px; text-align: center;}

</style>
 <script type="text/javascript" src="<%=path%>/JS/jquery-1.9.1.min.js"></script>  
 <script>
 	$(function(){
 			$(".divC").toggle();
 			$("#selectA").change(function(){
 			  var type=$("#selectA").val();
 			   if(type=='A'){
 			    $(".divC").hide();
 			   }
 			  if(type=='B'){
 				  $(".divC").toggle();
 			  }
 			})
 	})
 	
 
 </script>
</head>

<body>
		<form action="addAdmin.action" method="post" id="forms">
			<table class="a" cellspacing="0" cellpadding="0" >
				<tr><td>账号</td><td><input type="text" name="name"/></td></tr>
				<tr><td>密码</td><td><input type="text" name="password"/></td></tr>
				<tr><td>姓名</td><td><input type="text" name="nickname"/></td></tr>
				<tr><td>联系方式</td><td><input type="text" name="phone"/></td></tr>
				<tr><td>类型</td><td><select name="type" id="selectA" ><option value="A" selected="selected">总管理员</option><option value="B">区域管理员</option></select></td></tr>
				
				<tr class="divC"><td>城市</td><td> <select name="city" ><c:forEach items="${list}" var="B"><option value="${B.name}">${B.name}</option>   </c:forEach></select>   </td></tr>
				<tr class="divC"><td>区域</td><td><input type="text" name="area" /><div style="font-size:3px;color: red;">如岳麓区</div></td></tr>
				
				<tr><td colspan="2"><input type="submit" value="确定" id="btn"></td></tr>
			</table>
   		 </form>
 
</body>
</html>
