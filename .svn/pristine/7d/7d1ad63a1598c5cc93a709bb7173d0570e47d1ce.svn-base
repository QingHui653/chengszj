<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../../common/head.jsp"%>
<head>
<!-- <meta http-equiv='refresh' content='0;url=newss.action'> -->
<%-- <link href="<%=path %>/Css/style.css" rel="stylesheet" type="text/css"> --%>
<title>帖子</title>
 <style>
body{ margin:0; padding:0;}
a{ text-decoration:none; color:#666666; display:block;}
.welcome a:hover{color:red;}
.Information1024 a:hover{color:#fb8b01;}
.fr{ float:right;}
.fl{ float:left;}
ul{ margin:0; padding:0;}
li{ list-style:none;}
h1,h2{ margin:0; padding:0; font-weight:normal; font-size:100%;}

.huanying{ width:96%; padding:3% 2%; font-size:20px; color:#339a65;}
.centerbox{ width:96%; height:270px; padding:0 1%;}
.centerleft{ width:61%;}
.centerright{ width:35%; background-color:;}
.sqfy{ font-size:20px; color:#919191;}
.gundongbox{ padding:5% 0; height:34px; border-bottom:1px solid #919191;}
.head{ width:25%;}
.head img{ border-radius:10px;}
.neirong{ width:73%; padding-left:2%; font-size:10px; color:#919191;}
.fujin{ width:96%; padding:3% 2%; font-size:20px; color:#909090; border-bottom:1px solid #d2d2d2;}

.popelbox{ padding:2%;  border-bottom:1px solid #d2d2d2; height:82px;}
.bighead{ width:25%;}
.popelbox img{ width:100%; border-radius:20px;}
.xmxb{ padding-left:5%;}
.xingming{ font-size:15px; color:black; padding-top: 5px;}
/* .xingbie{ width:30px; padding-left:75%; height:25px; background-color:#f4abbc; border-radius:10px; background-repeat:no-repeat; background-position:10px; font-size:20px; color:white; text-align:center; line-height:20px; margin-top:15px;}
.xingbie-man{ width:30px; padding-left:28%; height:25px; background-color:#2c6dfd; border-radius:10px; background-repeat:no-repeat; background-position:10px; font-size:20px; color:white; text-align:center; line-height:20px; margin-top:15px;}
 */
 .jlrq{ font-size:10px; color:#919191;padding-top: 5px;}

</style>
</head>

<body>
	<div class="huanying">欢迎加入城市之间</div>
    <div class="centerbox">
    	<div class="fl centerleft">
        	<a href="fatieUI.action?userid=${userid}" ><img src="<%=path %>/images/shequbanner.png"; width="100%" height="270px">	</a>
        </div>	
    	
        <div class="fr centerright">
        	<div class="sqfy">社区发言</div>
        	
        	<c:forEach items="${list}" var="post">
          <a href="TieziDetail.action?id=${post.id}&userid=${userid}">  <div class="gundongbox">
            	<div class="fl head">
            	<c:if test="${post.content!=null}">
            	<img src="<%=path %>${post.content}" width="100%">
            	</c:if>
            	
            	<c:if test="${post.content==null}">
            	<img src="<%=path %>/images/moren.jpg" width="100%">
            	</c:if>
            	
            	</div>
                <div class="fr neirong">${fn:substring(post.title, 0, 14)}</div>
            </div>
            </a>
            </c:forEach>
  
        </div>
    </div>
	<div class="fujin">附近自由快递人</div>
	<c:forEach items="${users}" var="user">
  	<c:if test="${user.userid!=userid}">
    <div class="popelbox">
    <c:if test="${user.workPhoto=='null'}">
    	<div class="fl bighead">
    	<img src="<%=path %>/images/moren.jpg" >
    	</div>
    </c:if>
    <c:if test="${user.workPhoto!=null}">
    	<div class="fl bighead">
    	<img src="<%=path %>${user.workPhoto}" >
    	</div>
    </c:if>
        <div class="fl xmxb">
        	<div class="xingming">${user.realName}</div>
         
        </div>
        <div class="fr jlrq">
            <div class="fr riqi">${user.dengrutime}</div>   
            <div class="fr">&nbsp;|&nbsp;</div>                 
        	<div class="fr juli">${fn:substring(user.juli, 0, 4)}km</div>
        </div>
    </div>
    </c:if>
    </c:forEach>
<%--     
    <div class="popelbox">
    	<div class="fl bighead"><img src="<%=path %>/images/moren.jpg" ></div>
        <div class="fl xmxb">
        	<div class="xingming">男神男神男神</div>
            <div class="xingbie-man" style="background-size:20px 20px;background-image:url('<%=path %>/images/xb-nan_03.png');">30</div>
        </div>
        <div class="fr jlrq">
            <div class="fr riqi">3天前</div>   
            <div class="fr">&nbsp;|&nbsp;</div>                 
        	<div class="fr juli">0.111km</div>
        </div>
    </div>  --%>
     
     
    
</body>
</html>
