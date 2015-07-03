<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>子网注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="IOTReg.css">

	<script type='text/javascript' src='../dwr/engine.js'></script>  
    <script type='text/javascript' src='../dwr/util.js'></script>  
    <script type='text/javascript' src='../dwr/interface/subnetReg.js'></script>  
     <script type='text/javascript' src='../dwr/interface/globalDataReg.js'></script>  
	<script type="text/javascript">
	 function acsMethodAdd()
	 {
	    var str = window.prompt("请输入接入方式名称",""); 
	 	globalDataReg.addAscMethod(str,function(data)
	 	{
		 	if(data)
			{
					var obj=document.getElementById("acsMethodName");
	                obj.add(new Option(str,str));   
				}
				else
				{
					alert("该接入方式已经存在");
				}
	 	});
	 }
	 function showNetName()
	 {

        var val = document.getElementById("success").value;
        if (val == "1")
        {
        	alert("网络注册成功！");
        }
		
	 	var netName=document.getElementById("netName");
	 	globalDataReg.getNetMap(function(data)
	 	{
	 		for(var key in data)
	 		{
	 			netName.add(new Option(key,key));
	 		}
	 	});
	 	
	 	var acsName=document.getElementById("acsMethodName");
	    globalDataReg.getAscMethodMap(function(acsMethodList)
	 	{
	 		for(var key in acsMethodList)
	 		{
	 			acsName.add(new Option(key,key));
	 		}
	 	});
	 	
	 }
	</script>
  </head>
 
  <body onload="showNetName()" >
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
   子网注册
</div>
  <form action="../SubnetReg_Servlet" method="post"  >
  <table  width="920" height="196" align="center" bgColor="#ffffff">
	<tr>
		<td>&nbsp;网络名称</td><td><select size="1" name="netName" id="netName">
		    <option selected="selected" value="<%=request.getParameter("netID")%>"></option>
		</select>
		</td><td>&nbsp;覆盖范围左下点经度</td><td><input type="text" name="CVRG_LB_X" value="8"/></td></tr>
	<tr>
		<td>&nbsp;子网编号</td><td><input type="text" name="subnetId" value="2"></td>
		<td>&nbsp;覆盖范围左下点纬度</td><td><input type="text" name="CVRG_LB_Y" value="9"></td></tr>
	<tr>
		<td>&nbsp;子网名称</td><td><input type="text" name="subnetName" value="3"></td>
		<td>&nbsp;覆盖范围右上点经度</td><td><input type="text" name="CVRG_RU_X" value="10"></td>
	</tr>
	<tr>
		<td>&nbsp;子网描述</td><td><input type="text" name="subnetDesc" value="4"></td>
		<td>&nbsp;覆盖范围右上点纬度</td><td><input type="text" name="CVRG_RU_Y" value="11"></td></tr>
	<tr>
		<td>&nbsp;子网地址</td><td><input type="text" name="sinkAddress" value="127.0.0.1"></td>
		<td>&nbsp;接入方式</td><td>
		<select name="acsMethodName" size="1" id="acsMethodName"></select>
		<input type="button" onclick="acsMethodAdd()" value="添加">
		</td>
	</tr>
	<tr>
		<td>&nbsp;工作信道</td><td><input type="text" name="channel" width="200" value="6"></td>
		<td>&nbsp;工作周期</td><td><input type="text" name="workCycle" value="13">（单位：秒）</td></tr>
	<tr>
		<td >&nbsp;备注<input type="hidden" id = "success" value = "<%=request.getParameter("a")%>"></td><td colspan="3"><input type="text" name="memo" value="7"></td>
	<tr>
		<td colspan="3">&nbsp;</td>
		<td align="right">&nbsp;<input type="submit" value="提交并下一步" id="button"/>
		<input type="reset" value="重置" name="reset" id="button"></td>
	</tr>
</table>
  </form>
  </body>
</html>
