<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<head>

<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
<style type="text/css">
body{margin: 0}
.heart{border-radius:6px}
.imgsty{padding-left:2px;}
.trsty{background-color: #EAEAEA;height:40px;width: 100%;}

.table1{width: 100%; background-color:#DCDCDC;position:fixed;bottom: 0px;left:0px;/* position: absolute;  */}
.table2{width: 100%; background-color:#DCDCDC;height: 30px;/* position: absolute;  */}
.table2 td{text-align: center;width: 50%;}
#left{border-right: 2px solid white;}
 .button{background-color:#DCDCDC; width: 100%;height: 40px;border: none;font-size:16px;color: white;}

</style>
<title>帖子内容</title>
</head>
<script  src="<%=path%>/JS/jquery-1.9.1.min.js" type="text/javascript" ></script>

<script>
	$(function(){
	
		$("#bji").click(function(){
		
			$("#liuy").toggle();
			$("#text").focus();
			
		})
		
		$("#text").focus(function(){
			$(".table2").hide();
		
		});
		
		
		$("#liuy").blur(function(){
			$("#liuy").hide();
			$(".table2").show();
		})
		
	})
	
	
	
 
</script>



<body>
		


		<table  cellspacing="0" rowspacing="0" style="width:100%;margin-top:15px;">
			<tr>
				
				<td rowspan="2" width="17%" style="padding-left:10px">
				<c:if test="${P.headphoto!=null}">
				<img src="<%=path%>${P.headphoto}" width="99%" height="45px;" class="heart">
				</c:if>
				<c:if test="${P.headphoto==null}">
				<img src="<%=path%>/images/moren.jpg" width="99%" height="45px;" class="heart">
				</c:if>
				</td>
		
				<td style="padding-left: 7px">${P.name}</td>
				<td style="vertical-align: middle;padding-right:10px;" align="right">楼主</td>
			</tr>
			<tr>
			<td colspan="2" style="padding-left: 7px">${fn:substring(P.time,5,18)}</td>
			</tr>
			<tr>
			<td style="padding-top: 3px"></td>
				<td colspan="2" style="padding-top: 3px;">${P.content}</td>
			</tr>
			<c:if test="${P.image!=null}">
			<tr>
			<td></td>
				<td colspan="3" style="padding-top: 5px;padding-bottom: 5px;">
			
				<c:forEach var="num" items="${fn:split(P.image,'|')}">
			<img src="<%=path%>${num}" width="23%" height="70px;" class="imgsty" > 
			</c:forEach>
				<%-- <img src="<%=path%>/images/moren.jpg" width="23%" height="70px;"  class="imgsty"> --%>
			
				</td>
			</tr>
			</c:if>
			<tr>
				<td style="border-right: 1px solid #C6C5C6; border-bottom:1px solid #C6C5C6;text-align: center;font-size: 12px;color:#B1B0B1">留言评论${P.number}</td>
				<td colspan="2" align="right" style="border-bottom:1px solid #C6C5C6;font-size: 12px;color:#B1B0B1;padding-right:10px">赞${P.zan}</td>
			</tr>
			</table>
			
			
			<c:forEach items="${list}" var="P">
			<table  cellspacing="0" rowspacing="0" style="width:100%;margin-top:10px;border-bottom: 1px solid #B1B0B1;">
			<tr>
			<td rowspan="2" width="17%" style="padding-left:10px">
				<c:if test="${P.headphoto!=null}">
				<img src="<%=path%>${P.headphoto}" width="99%" height="45px;" class="heart">
				</c:if>
				<c:if test="${P.headphoto==null}">
				<img src="<%=path%>/images/moren.jpg" width="99%" height="45px;" class="heart">
				</c:if>
			</td>
		
				<td style="padding-left: 7px" width="75%">${P.name}</td>
				<td style="vertical-align: middle;" align="right" width="7%"><!-- 楼主 --></td>
			</tr>
			<tr>
			<td colspan="2" style="padding-left: 7px">${fn:substring(P.time,5,17)}</td>
			</tr>
			<tr>
			<td></td>
				<td colspan="3" style="padding-top: 3px;padding-bottom: 5px;padding-left: 5px;word-break:break-all">${P.content}</td>
			</tr>
			</table>
		</c:forEach>
			
				
			
		<div style="height: 50px"></div>
			<div class="table1">
			<div style="display: none;" id="liuy">
			  <form action="huitie.action?id=${P.id}&userid=${userid}" method="post">
			<table  cellspacing="0" rowspacing="0" style="width:100%;margin-top:10px;">
			<tr>
			<td width="17%" style="padding-left:10px">留言</td>
			<td> <textarea rows="" cols="" style="width:98%;height: 60px" id="text" name="content"></textarea></td>
			<td align="center"><input type="submit" value="提交" style=""></td>
			</tr>
			</table>
			</form>
			</div>
		
		
		<table class="table2">
			<tr> <td id="left"><button class="button" id="bji">留言</button></td><td><button class="button" id="baoc">赞</button></td></tr>
   		</table>
		</div>
</body>
</html>
