<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>网络注册</title>
	<link rel="stylesheet" type="text/css" href="IOTReg.css">
	<script language="javascript">
	
	</script>
</head>
<body>
<div>
  <ul id="nav" >
  <li><a href="NetReg.jsp">网络注册</a></li>
    <li><a href="SubnetReg.jsp">子网注册</a></li>
    <li><a href="NodeReg.jsp">节点注册</a></li>
    <li><a href="SensorReg.jsp">传感器注册</a></li>
    <li><a href="NodeBindSensor.jsp">节点与传感器绑定</a></li>
    <li><a href="#">协议注册</a></li>
  </ul>
  </div>
  <div id="banner" >
     网络注册
</div>
<form method="post" action="../NetReg_Servlet">
<table  align="center" width="920" height="306" bgColor="#ffffff">
<tr>
	<td>网络名称:</td>
	<td><input type="text" name="netName" value="1"></td>
	<td>网络描述：</td>
	<td><input type="text" name="netDes" value="2"></td>
</tr>
<tr>
	<td>所属单位：</td>
	<td><input type="text" name="addr" value="3"></td>
	<td>地点：</td>
	<td><input type="text" name="organUnit" value="4"></td>
</tr>
<tr>
	<td>维护单位：</td>
	<td><input type="text" name="maintenace" value="5"></td>
	<td>联系人:</td>
	<td><input type="text" name="cntct" value="6"></td>
</tr>
<tr>
	<td>联系电话：</td>
	<td><input type="text" name="phone" value="7"></td>
	<td>备注：</td>
	<td><input type="text" name="memo" value="8"></td>
</tr>
<tr>
	<td>覆盖范围左下点经度：</td>
	<td><input type="text" name="LBX" value="9"></td>
	<td>覆盖范围左下点纬度：</td> 
	<td><input type="text" name="LBY" value="10"></td>
</tr>
<tr>
	<td>覆盖范围右上点经度：</td>
	<td><input type="text" name="RUX" value="11"></td>
	<td>覆盖范围右上点纬度：</td>
	<td><input type="text" name="RUY" value="12"></td>
</tr>
<tr>
	<td  colspan="2" ></td>
	<td align="right" colspan="2" ><input type="submit" value="提交并下一步" id="button">
	<input type="reset"    value="重置" id="button"></td>
</tr>

</table>
</form>
 </body>
</html>