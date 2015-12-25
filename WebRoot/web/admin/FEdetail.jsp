<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<title>无标题文档</title>
<style type="text/css">
.a{text-align: center; padding-left: 20%}
.a td{border: 1px solid ; padding: 3px; text-align: center;}
.b{text-align: center; padding-left: 20%; width: 840px}
.b td{border: 1px solid ; padding: 3px;}
</style>
</head>

<body>

		<table class="a" cellspacing="0" cellpadding="0" >
		<%-- 	<tr><td>真实姓名</td><td>${freeexpress.realName}</td><tr>
			<tr><td>身份证号</td><td>${freeexpress.idcard}</td><tr> --%>
			<tr><td>工作照</td><td>正面照片</td></tr>
			<tr>
			<td width="300px" height="300px"><img alt="" src="<%=path%>${freeexpress.workPhoto}" width="300px" height="300px">  </td>
			<td width="300px" height="300px"><img alt="" src="<%=path%>${freeexpress.positivePhoto}" width="300px" height="300px"></td>
			</tr>
			<tr>
			<td>身份证正面</td><td>身份证反面</td>
			</tr>
			<tr>
			<td width="300px" height="300px"><img alt="" src="<%=path%>${freeexpress.positiveCard}" width="300px" height="300px"></td>
			<td width="300px" height="300px"><img alt="" src="<%=path%>${freeexpress.conCard}" width="300px" height="300px"></td><tr>
		</table>
			<table class="b" cellspacing="0" cellpadding="0">
			<tr><td>申请人账号</td><td>${freeexpress.userid}</td><td>申请状态</td><td><c:if test="${freeexpress.status=='1'}">未审核</c:if>  </td></tr>
			<tr><td>真实姓名</td><td>${freeexpress.realName}</td><td>身份证号</td><td>${freeexpress.idcard}</td><tr>
				<tr><td>紧急联络人</td><td>${freeexpress.contact}</td><td>联络人手机</td><td>${freeexpress.contactPhone}</td><tr>
			<tr><td>所在地区</td><td>${freeexpress.area}</td><td>可接单区域</td><td>${freeexpress.singleArea}</td><tr>
			<tr><td>邀请码或手机号</td><td>${freeexpress.inviting}</td><td>接单时间</td><td>${freeexpress.singleTime}</td></tr>
			<tr><td>学历</td><td>${freeexpress.education}</td><td>职业</td><td>${freeexpress.occupation}</td><tr>
			<tr><td>公司类型</td><td>${freeexpress.company}</td><td>交通工具</td><td>${freeexpress.vehicle}</td><tr>
			<tr><td>余额</td><td>${freeexpress.balance}</td><td>申请时间</td><td>${freeexpress.time}</td><tr>
			<tr><td colspan="2"><a href="FEshenhe.action?userid=${freeexpress.userid}&id=${freeexpress.id}&type=S">通过</a></td><td colspan="2"><a href="FEshenhe.action?userid=${freeexpress.userid}&id=${freeexpress.id}&type=F">不通过</a></td></td><tr>
			
			</table>
    
 
</body>
</html>
