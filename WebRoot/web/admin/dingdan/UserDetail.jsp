<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../../../common/head.jsp"%>
<title>会员个人信息</title>
<style type="text/css">
.ta{background-color: activecaption;}
.ta tr td{ padding-top: 5px; padding-left: 5px;}
</style>

  </head>
  
  <body>
    <div>
 <!-- private Integer id;
	private String userid;
	private String password;
	private String name;
	private String tixianPassword;
	private Integer integral;
	private Double balance;
	private String creditrating;
	private String phone;
	private String headphoto;
	private String verifycode;
	private String dizhi;
	private String weizhi;
	private String dengrutime;
	private String status;
	private String qianmin;
	private String zhiye;
	private String ip; -->

    <table  class="ta" align="center">
     	<input type="hidden" name="id" value="${user.id}">
    <tr><td>登入账号:</td><td><input type="text" name=userid value="${user.userid}" disabled="true"></td></tr>
    
    <tr> <td>昵称：</td><td><input type="text" name="name" value="${user.name}" disabled="true"></td></tr>
    <tr><td>积分：</td><td><input type="text" name="integral" value="${user.integral}" disabled="true"></td></tr>
    <tr> <td> 余额：</td><td><input type="text" name="balance" value="${user.balance}" disabled="true"></td></tr>
     <tr><td>诚信等级：</td><td><input type="text" name="creditrating" value="${user.creditrating}" disabled="true"></td></tr>
      <tr><td>手机号码：</td><td><input type="text" name="phone" value="${user.phone}" disabled="true"></td></tr>
    <tr><td>职业：</td><td><input type="text" name="zhiye" value="${user.zhiye}" disabled="true"></td></tr>
    <tr><td>是否为快递人：</td><td><input type="text" name="zhiye" value="<c:if test="${user.status=='Y'}">是</c:if><c:if test="${user.status=='N'}">不是</c:if>" disabled="true"></td>
    
  
   <%--  <input type="text" name="status" value="${user.status}"> --%></td></tr>
    
    
      <tr> <td>签名：</td><td><textarea cols="40" rows="5" class="input" name="qianmin"  id="content" disabled="true" > ${user.qianmin}</textarea></td></tr>
       
   </table>
    
 

			
    </form>
    </div>
  </body>
</html>