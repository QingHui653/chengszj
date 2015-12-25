<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script language=JavaScript>
//表单验证

function isChinese(name) //中文值检测
{
if(name.length == 0)
return false;
for(i = 0; i < name.length; i++) {
if(name.charCodeAt(i) > 128)
return true;
}
return false;
}

function changDu(name) //长度判断
{
if(name.length > 50)
return false;
else
return true;
}

function isNumber(String)
{
var Letters = "1234567890-"; //可以自己增加可输入值
var i;
var c;
if(String.charAt( 0 )=='-')
return false;
if( String.charAt( String.length - 1 ) == '-' )
return false;
for( i = 0; i < String.length; i ++ )
{
c = String.charAt( i );
if (Letters.indexOf( c ) < 0)
return false;
}

return true;
}

function Check( reg, str )
{
 if( reg.test( str ) )
 {
  return true;
 }
 return false;
}


function CheckCharOrNum(str)
{
 var reg = /^\w+$/;
 return Check(reg,str);
}
//tuxiliang 2009.10.10修改与firefox不兼容问题
function checkForm(){
var loginForm = document.loginForm;
	if(loginForm.userid.value.length==0){
 		alert("登陆名不能为空");
   	 	loginForm.userid.focus();
    	return(false);
 	}
	
	if(!CheckCharOrNum(loginForm.userid.value)){
	    alert("登陆名必须是数字和字母组合");
   	 	loginForm.userid.focus();
		return(false);	
	}
 	if(loginForm.password.value.length==0){
 		alert("密码不能为空"+loginForm.password.value);
   	 	loginForm.password.focus();
    	return(false);
 		}
 		// alert("密码必须是数字和字母组合"+loginForm.password.value);
		if(!CheckCharOrNum(loginForm.password.value)){
	    alert("密码必须是数字和字母组合");
   	 	loginForm.password.focus();
		return(false);	
	}		
	loginForm.submit();
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
 
<title>城市之间后台登入</title>


</head>

<body onLoad="javascript:document.loginForm.userid.focus();onloadCheck()">
	<div align="center">
	<div style="padding-top:10%;text-align: center; padding-left: 40%">
      <form action="login-lo.action" method="post" name="loginForm">
      <table>
      <tr>
      <td>账号:</td>
      <td><input type="text"  name="name" value="${hh.userid}" style="margin-top:10px"/></td>
      <td>${error}</td>
      </tr>
    <tr>
    <td>密码:</td>
    <td><input type="password" name="password" style="margin-top: 10px" /></td>
   	<td>${pass}</td>
    </tr>
    <tr>
    <td><input type="submit" value="确定" onclick="return checkForm()" />
    </td>
    <td><input type="reset" value="重置"/></td>
     </tr>
      	</table>
      </form>
      </div>
      </div>
</body>
</html>
