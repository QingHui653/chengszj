<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<head>

<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
<style type="text/css">
body{margin: 0}
.heart{border-radius:6px}
.imgsty{padding-left:4px;}
.trsty{background-color: #EAEAEA;height:40px;width: 100%;}
.btnS{border: none;background-color:#EAEAEA; }
.btnP{border: none;background-color:#EAEAEA; }
.btnZ{border: none;background-color:#EAEAEA; }
</style>
<title>社区</title>
</head>
<script  src="<%=path%>/JS/jquery-1.9.1.min.js" type="text/javascript" ></script>

<script>
$(function(){
		$(".btnZ").click(function(){
		var id = $(this).attr("id");
		var flag =$("#f"+id).val();
		if(flag=='true'){
					var x=$("#i"+id).val();
					var url="Zan.action";
							$.ajax({
							url:url,
							type:"post",
							data:{id:x},
							dataType:"json",
							 success : function(data) {
							if(data.mess=='OK'){
						var Z= parseInt($("#Z"+id).text());
							$("#Z"+id).text(Z+1);
							$("#f"+id).val("false");
							  var u = '<%=request.getContextPath()%>';
						$("#Zimg"+id).attr('src',u+'/images/jinshouzhi.png'); 
							}
							else{
							alert("失败");
							}
						},
				       		 error:function(){  
				           			 alert("发送失败"); 
				           		  }
				            } )	
										
			}else{
		/* 	alert("已赞"); */
			}			
		})
		
		$(".btnP").click(function(){
					var id = $(this).attr("id");
					
					var x=$("#i"+id).val();
					alert("评论"+x);
		})


})
	
 
</script>

 <script type="text/javascript">
        //全局变量，动态的文章ID
        var ShareId = "";
        var context="";
      
        //绑定所有分享按钮所在A标签的鼠标移入事件，从而获取动态ID
        $(function () {
            $(".bdsharebuttonbox a").mouseover(function () {
         		var id = $(this).attr("data-id");
                   ShareId =$("#i"+id).val();
                   context=$("#n"+id).text();
                  
            });
        });

        /* 
        * 动态设置百度分享URL的函数,具体参数
        * cmd为分享目标id,此id指的是插件中分析按钮的ID
        *，我们自己的文章ID要通过全局变量获取
        * config为当前设置，返回值为更新后的设置。
        */
        function SetShareUrl(cmd, config) {            
            if (ShareId) {
                config.bdUrl = "http://192.168.1.203:8080/chengszj/TieziDetail.action?id="+ShareId;   
                if(context.length>60){
               context=context.substring(0,60);
                   config.bdText= context+"......";
                }else{
                config.bdText= context;
                }
                
              }
            return config;
        }

        //插件的配置部分，注意要记得设置onBeforeClick事件，主要用于获取动态的文章ID
        window._bd_share_config = {
            "common": {
                onBeforeClick:SetShareUrl,"bdSnsKey":{},"bdText":"","bdMini":"2"
                ,"bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"24"
            }, "share": {}
        };
        //插件的JS加载部分
        with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+ ~(-new Date() / 36e5)];
    </script>

<body>
		

<c:forEach items="${list}" var="P"  varStatus="C">
 
		<table  cellspacing="0" rowspacing="0" style="width: 100%;margin-top:15px;">
			<input type="hidden" value="${P.id}" id="i${C.count}">
			<input type="hidden" value="true" id="f${C.count}">
		<tr>
		<c:if test="${P.headphoto==null}">
		<td rowspan="3" width="23%" style="padding-left:10px"><img src="<%=path%>/images/moren.jpg" width="99%" height="70px;" class="heart"></td>
		</c:if>
		<c:if test="${P.headphoto!=null}">
		<td rowspan="3" width="23%" style="padding-left:10px"><img src="<%=path%>${P.headphoto}" width="99%" height="70px;" class="heart"></td>
	   </c:if>
		
		<td valign="top" width="45%"><c:if test="${P.name!=null}">${P.name}</c:if>
		<c:if test="${P.integral<5001}">
		<c:forEach var="i" begin="1000" end="${P.integral}" step="1000">
				<img src="<%=path%>/images/xing.png" height="15px;" class="heart">
    		 </c:forEach>
		</c:if>
		<c:if test="${P.integral>=5001}">
			<c:forEach var="i" begin="5001" end="${P.integral}" step="2000" varStatus="n">
			<c:if test="${n.count<=5}">
			<c:if test="${i>(5000+(n.count-1)*2000)}">
				<img src="<%=path%>/images/zuanshi.png" height="12px;" class="heart">
			</c:if>
			</c:if>
			</c:forEach>
    				
    	</c:if>
		
	
		</td>
		<td valign="top" width="8%" style="font-size: 12px;">${fn:substringBefore(P.weizhi, ".")}km</td>
		<td valign="top" width="10%" style="border-left: 1px solid #A1A1A1;font-size: 12px">${fn:substring(P.time,10,16)}</td>
			</tr>
			<tr>
				<td colspan="3" style="padding-top: 3px;padding-left: 5px;">
				<c:if test="${P.sex=='男'}">
				<img src="<%=path%>/images/nan.png" height="15px;" class="heart">
				</c:if>
				<c:if test="${P.sex=='女'}">
				<img src="<%=path%>/images/nv.png" height="15px;" class="heart">
				</c:if>
				</td>
				
			</tr>
				<tr>
			<td colspan="3" style="font-size: 12px;padding-left: 5px;">个人签名:${fn:substring(P.qianmin,0,34)}<c:if test="${fn:length(P.qianmin)>34}">...</c:if></td>
			</tr>
	
	 	<tr>
		<td colspan="4" style="padding-top: 5px;font-size: 16px;padding-left:10px;padding-bottom: 5px;" id="n${C.count}">
		  <a href="TieziDetail.action?id=${P.id}&userid=${userid}" style="color: black;">	
		${P.content}
		</a>
		</td>
		</tr>
		<c:if test="${P.image!=null}">
		<tr>
		<td colspan="4" style="padding-top: 5px;padding-left:5px;padding-bottom: 5px;">
			<c:forEach var="num" items="${fn:split(P.image,'|')}">
			<img src="<%=path%>${num}" width="23%" height="70px;" class="imgsty" > 
			</c:forEach>
		</td>
		</tr>
		</c:if>
	
		<tr class="trsty">
		<td valign="middle">
		<button class="btnS" id="${C.count}">
	<div class="bdsharebuttonbox" data-tag="share_1" style="font-size: 10px;">
	<a class="bds_more" data-cmd="more" data-id="${C.count}">分享:</a><!-- <a class="bds_count" data-cmd="count"></a> --> </div>
		</button>
		</td>
		
		<td style="padding-left: 15%"><button class="btnP" id="${C.count}"><img src="<%=path%>/images/pingjia.png" height="14px;">&nbsp;评论${P.number}</button></td>
			<td align="right" colspan="2" ><button class="btnZ" id="${C.count}"><img src="<%=path%>/images/dianzan.png" height="14px;" id="Zimg${C.count}">&nbsp;<span id="Z${C.count}">${P.zan}</span></button></td>
		</tr>
		</table>
	
	</c:forEach>
		
	
</body>
</html>
