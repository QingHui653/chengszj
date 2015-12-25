<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<title>无标题文档</title>
<style type="text/css">
.condiv{margin-left:2%}
.a{text-align: center; padding-left: 20%}
.a td{border: 1px solid #000000;; padding: 3px; text-align: center;}
.b{ width: 1140px;border: 1px solid #000000;margin-left: 2%;margin-top: 20px}
.b td{border: 1px solid ; padding: 3px;padding-left:30px;}
.input{text-align: center;color: red;border:1px solid #000000;}
</style>
</head>
<script  src="<%=path%>/JS/jquery-1.9.1.min.js" type="text/javascript" ></script>

<script>
	$(function(){
	$("#xiugai").click(function(){
	 	if(confirm("确定修改？")){
		 	 $("#form").submit();  
		 	 
/* 			window.opener=null;      
window.open("","_self");  */ 
		window.close();   
		 window.opener.location.reload();   
		 }else{
		return false;
		}
	 })
	})
	
</script>
<body>
	<div class="condiv">
		<table class="a" cellspacing="0" cellpadding="0" >
			<tr><td>工作照</td><td>正面照片</td><td>身份证正面</td><td>身份证反面</td></tr>
			<tr>
			<td width="300px" height="300px"><img alt="" src="<%=path%>${freeexpress.workPhoto}" width="300px" height="300px">  </td>
			<td width="300px" height="300px"><img alt="" src="<%=path%>${freeexpress.positivePhoto}" width="300px" height="300px"></td>
			
			<td width="300px" height="300px"><img alt="" src="<%=path%>${freeexpress.positiveCard}" width="300px" height="300px"></td>
			<td width="300px" height="300px"><img alt="" src="<%=path%>${freeexpress.conCard}" width="300px" height="300px"></td><tr>
		</table>	
		<form action="xiugaiFE.action" method="post" id="form">
		<input type="hidden" name="id" value="${freeexpress.id}">
			<table class="b" cellspacing="0" cellpadding="0">
			<tr><td>快递人账号:<input type="text"  disabled="true" value="${freeexpress.userid}" class="input" ></td><td>真&nbsp;实&nbsp;姓&nbsp;名&nbsp;:<input type="text" name="realName" value="${freeexpress.realName}" class="input"></td><td>身份证号:<input type="text" name="idcard" value="${freeexpress.idcard}" class="input"></td>
			<tr><td>紧急联络人:<input type="text" name="contact" value="${freeexpress.contact}" class="input"></td> <td>联络人手机:<input type="text" name="contactPhone" value="${freeexpress.contactPhone}" class="input"></td><td>所在地区:<input type="text" name="area" value="${freeexpress.area}" class="input"></td></tr>
			<tr><td>可接单时间:<input type="text" name="singleTime" value="${freeexpress.singleTime}" class="input"></td><td>可接单区域:<input type="text" name="singleArea" value="${freeexpress.singleArea}" class="input"></td><td>公司类型:<select class="input" name="company"> <option value="顺风快递" <c:if test="${freeexpress.company=='顺风快递'}"> selected="selected"</c:if> >顺风快递</option><option value="圆通快递" <c:if test="${freeexpress.company=='圆通快递'}"> selected="selected"</c:if> >圆通快递</option><option value="中通快递" <c:if test="${freeexpress.company=='中通快递'}"> selected="selected"</c:if> >中通快递</option></select><%-- <input type="text" name="" value="${freeexpress.company}" class="input"> --%></td></tr>
			<tr><td>交通工具:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="vehicle" value="${freeexpress.vehicle}" class="input"></td><td>&nbsp;&nbsp;&nbsp;&nbsp;职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:&nbsp;&nbsp;&nbsp;<input type="text" name="occupation" value="${freeexpress.occupation}" class="input"></td><td>&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;历:&nbsp;&nbsp;&nbsp;<input type="text" name="education" value="${freeexpress.education}" class="input"></td></tr>
			<tr><td>邀请码或邀请人手机号:<input type="text" name="inviting" value="${freeexpress.inviting}" class="input"></td><td>申&nbsp;请&nbsp;状&nbsp;态:<select class="input" name="status"> <option value="1" <c:if test="${freeexpress.status=='1'}"> selected="selected"</c:if> >未审核</option><option value="2" <c:if test="${freeexpress.status=='2'}"> selected="selected"</c:if> >审核通过</option><option value="3" <c:if test="${freeexpress.status=='3'}"> selected="selected"</c:if> >审核未通过</option></select></td></tr>
		
			 <tr><td colspan="3" style="text-align: center;"><span><input type="button" value="修改信息" id="xiugai"></span><span style="padding-left: 50px"><input type="button" onclick="javascript:self.close()" value="关闭窗口"></span></td><tr>
			
			</table>
    	</form>
 </div>
</body>
</html>