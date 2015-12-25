<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<title>距离设置</title>
<style type="text/css">
.tas{background-color: activecaption; margin-top: 5%}
.tas tr td{ padding-top: 5px;}

</style>
 <script type="text/javascript" src="<%=path%>/JS/jquery-1.9.1.min.js"></script>  
	<script>
		$(function(){
			$("#btn1").click(function(){
			var xx= $("#t1").val();
			var ex = /^\d+$/;
			if (!ex.test(xx)) {
  				alert("请输入正确的距离...整数");
      			return false;
			}
			if((xx+"").length>3){
				alert("距离范围太广了，请重新设置");
      			return false;
			}
			if(confirm("确定修改?")){
				return true;
			}else{
				return false;
			}
		})	
		
		
		
		
		})
	
	</script>
  </head>
	
  <body>
    <div>
    <form action="updateCity.action" method="post" id="form1">
	 <table  class="tas" align="center">
     <input type="hidden" name="id" value="${list.id}">
      <tr><td>附近人距离</td>
    <td><textarea rows="8"  cols="" name="name" style="width:200px;height: 18px;resize:none" maxlength="15" id="t1" >${list.name}</textarea>
    </td><td><input type="submit" value="修改" id="btn1" ></td>
     </tr>
    </form>
   
    
    
    </div>
 </td>
 

  
   
  
    
  
   </table>
    
 

			
    </form>
    </div>
  </body>
</html>
