<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../common/head.jsp"%>
<title>价格设置</title>
<style type="text/css">
.tas{background-color: activecaption; margin-top: 5%}
.tas tr td{ padding-top: 5px;}
.ta{background-color: activecaption; margin-top: 1%}
.ta tr td{ padding-top: 5px;}
</style>
 <script type="text/javascript" src="<%=path%>/JS/jquery-1.9.1.min.js"></script>  
	<script>
		$(function(){
			$("#btn1").click(function(){
			var xx= $("#t1").val();
      	 	var re = /^\d+(?=\.{0,1}\d+$|$)/;
  		  if (xx!= "") {
      		  if (!re.test(xx)) {
            alert("请输入正确的数字");
        	 return false;
         	}
         	if((xx+"").length>4){
         	 alert("请输入正确的数字");
         	 return false;
         	}
         } 
			if(confirm("确定修改?")){
				return true;
			}else{
				return false;
			}
		})	
		
		$("#btn2").click(function(){
			var xx= $("#t2").val();
      	 	var re = /^\d+(?=\.{0,1}\d+$|$)/;
  		  if (xx!= "") {
      		  if (!re.test(xx)) {
            alert("请输入正确的数字");
        	 return false;
         	}
         	if((xx+"").length>4){
         	 alert("请输入正确的数字");
         	 return false;
         	}
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
    <form action="updatePrice.action" method="post" id="form1">
	 <table  class="tas" align="center">
     <input type="hidden" name="id" value="${listD.id}">
      <tr><td>起步价</td>
    <td><textarea rows="8"  cols="" name="name" style="width:200px;height: 18px;resize:none" maxlength="15" id="t1" >${listD.name}</textarea>
    </td><td><input type="submit" value="修改" id="btn1" ></td>
     </tr>
    </form>
    <form action="updatePrice.action" method="post" id="form2">
	 <table  class="ta" align="center">
     <input type="hidden" name="id" value="${listQ.id}">
      <tr><td>单价&nbsp;&nbsp;</td>
    <td><textarea rows="8"  cols="" name="name" style="width:200px;height: 18px;resize:none" maxlength="15" id="t2" >${listQ.name}</textarea>
    </td><td><input type="submit" value="修改" id="btn2" ></td>
     </tr>
    </form>
    
    
    </div>
 </td>
 

  
   
  
    
  
   </table>
    
 

			
    </form>
    </div>
  </body>
</html>
