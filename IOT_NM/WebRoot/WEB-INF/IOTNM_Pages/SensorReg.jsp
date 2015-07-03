<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>传感器注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="IOTReg.css">
	<style type="text/css">
		
	</style>
	
	<script type='text/javascript' src='../dwr/engine.js'></script>  
    <script type='text/javascript' src='../dwr/util.js'></script>  
    <script type='text/javascript' src='../dwr/interface/globalDataReg.js'></script>  

    <script language="javascript">
    
    //初始化传感器类型
    function showNetName()
    {
    	var val = document.getElementById("success").value;
        if (val == "1")
        {
        	alert("节点注册成功！");
        }
		
    }
    function SensorRegInitFun()
    {
	    var sensorTypeName=document.getElementById("sensorType");
	    globalDataReg.initSensorTypeData(function(data)
	    {
	    	if(data)
	    	{
	    		alert("hi");
	    		
	    		globalDataReg.getNetMap(function(data)
				{
				 	alert("hi");
				 	for(var key in data)
				 	{
				 		sensorTypeName.add(new Option(key,key));
				 	}
				});
	    	}
	    });
    }
    
    //跳转至传感器与节点绑定的页面
    function BindData()
    {
    	   window.location.href="NodeBindSensor.jsp"; 
    }
    
    </script>
  </head>
  
  <body onload="showNetName()">
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
  <div id="banner">
  传感器注册
  </div>
  <form action="../SensorReg_Servlet" method="post" >
  <table align="center"  height="190" style="left: 0px;" width="920">
<tr>
	<td>&nbsp;传感器名称</td>
	<td><input type="text" value="1" name="sensorName"></td>
	<td>规格型号与版本号<br></td>
	<td><input type="text" value="6" name="version"> <br></td>
</tr>
<tr >
	<td>&nbsp;传感器类型</td>
	<td>
		<select size="1" name="sensorType" id="sensorType"  >		
		<option value="1">温度</option>
		
		<option value="2">湿度</option>
		<option value="3">光照</option>
		<option value="4">水位</option>
		<option value="5">加速度</option>
		<option value="6">指南针</option>
		</select>
		
		
	<br></td>
	<td>计量单位<br></td>
	<td><input type="text" value="7" name="unit"></td>
</tr>
<tr>
	<td>&nbsp;传感器描述信息</td>
	<td><input type="text" value="2" name="sensorDesc"></td>
	<td>转换公式</td>
	<td><input type="text" value="8" name="formulary"></td>
</tr>
<tr>
	<td>&nbsp;生产厂商</td>
	<td><input type="text" value="3" name="producer"></td>
	<td>精度 <br></td>
	<td><input type="text" value="9" name="precision"></td>
</tr>
<tr>
	<td>&nbsp;转换公式参数列表</td>
	<td><input type="text" value="4" name="Prms"></td>
	<td>数据最小值</td>
	<td><input type="text" value="5" name="dataMin"></td>
</tr>
<tr>
	<td  align="left">&nbsp;数据最大值</td><input type="hidden" id = "success" value = "<%=request.getParameter("a")%>">
	<td><input type="text" value="10" name="dataMax"></td>
	<td></td>
	<td></td>
</tr>
<tr>
	<td colspan="4" align="right">
		<!-- <input type="button" value="绑定节点与传感器" name="bindNodeAndSensor" onclick="BindData()">  -->
		<input type="submit" name="submit" value="提交注册" id="button"/>
		<input type="reset" name="reset" value="重置" id="button"/>
	</td></tr>
</table>
  </form>
  </body>
</html>
