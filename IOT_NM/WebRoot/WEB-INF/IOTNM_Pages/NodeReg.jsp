<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>节点注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="IOTReg.css">
	<script type='text/javascript' src='../dwr/engine.js'></script>  
    <script type='text/javascript' src='../dwr/util.js'></script>  
    <script type='text/javascript' src='../dwr/interface/globalDataReg.js'></script>  
	<script language="javascript">
	
	function addNodeType()
	{
	    var str = window.prompt("请输入节点类型名称",""); 
		globalDataReg.addNodeTypeItem(str,function(data)
		{
			if(data)
			{
				var obj=document.getElementById("nodeType");
                obj.add(new Option(str,str));   
			}
			else
			{
				alert("该节点类型已经存在");
			}
		});
	}
	
	function NodeInitFun()
		{

		var val = document.getElementById("success").value;
        if (val == "1")
        {
        	alert("子网注册成功！");
        }
		var index=0;
			globalDataReg.getNetMap(function(data)
		 	{
		 		for(var key in data)
		 		{
		 		  var netName=document.getElementById("netName");
		 			netName.add(new Option(key,key));
		 			if(index==0)
		 			{
		 				var subnetNameTag=document.getElementById("subnetName");
		 				var subnetSet=data[key].subnetMap;
		 				for(var subnetData in subnetSet)
		 				{
		 					subnetNameTag.add(new Option(subnetData,subnetSet[subnetData].m_nSubnetId));//填的是子网ID
		 				}
		 			}
		 			index++;
		 		}
		 	});
		   
			globalDataReg.getNodeTypeMap(function(data){
			 var obj=document.getElementById("nodeType");
			 for(var key in data)
             {
                obj.add(new Option(key,key));   
             }
			});
		};
		
		  function removeAll(selTag){
           var obj=document.getElementById(selTag);
            obj.options.length=0;
         }
         
	    function selNetChange()
	    {
	       var netName=document.getElementById("netName");
	       var keyValue=netName.options[netName.selectedIndex].value;
	       globalDataReg.getNetByName(keyValue,function(data)
	       {
	       		var subnetSet=data.subnetMap;
	       		var subnetNameTag=document.getElementById("subnetName");
	       		removeAll("subnetName");
	       		for(var key in subnetSet)
	       		{	
	       		    subnetNameTag.add(new Option(key,subnetSet[key].m_nSubnetId));
	       		}
	       });
	    }
	</script>

  </head>
  
  <body onload="NodeInitFun()">
  <div >
  <ul id="nav" >
  <li><a href="NetReg.jsp">网络注册</a></li>
    <li><a href="SubnetReg.jsp">子网注册</a></li>
    <li><a href="NodeReg.jsp">节点注册</a></li>
    <li><a href="SensorReg.jsp">传感器注册</a></li>
    <li><a href="NodeBindSensor.jsp">节点与传感器绑定</a></li>
    <li><a href="#">协议注册</a></li>
  </ul>
  </div>
  <div  id="addNodeType">

</div>
<div id="banner" >
     节点注册
</div>
  <form action="../NodeReg_Servlet" method="post" >
<table  width="920" height="306">
<tr>
	<td>&nbsp;网络名称</td>
	<td>&nbsp;<select size="1" name="netName" id="netName" onchange="selNetChange()">
		</select>
	</td>
	<td>&nbsp;节点描述信息</td>
	<td>&nbsp;<input type="text" name="nodeDesc" value="6"></td>
</tr>
<tr>
	<td>&nbsp;子网名称</td>
	<td>&nbsp;<select size="1" name="subnetName" id="subnetName" onchange="selSubnetChange()">
</select>
</td>
	<td>&nbsp;节点物理地址</td>
	<td>&nbsp;<input type="text" value="7" name="nodeAddress"></td>
</tr>
<tr>
	<td>&nbsp;发射功率</td>
	<td>&nbsp;<input type="text" name="transPower" value="3"> <br></td>
	<td>&nbsp;节点位置经度</td>
	<td>&nbsp;<input type="text" name="LCTN_X" value="8"></td>
</tr>
<tr>
	<td>&nbsp;生产厂商<br></td>
	<td>&nbsp;<input type="text" name="producer" value="4"></td>
	<td>&nbsp;节点位置纬度</td>
	<td >&nbsp;<input type="text" name="LCTN_Y" value="9"> <br></td>
</tr>
<tr>
	<td>&nbsp;节点类型</td>
	<td>&nbsp;<select size="1" name="nodeType" id="nodeType">
	</select>
	
	<input type="button" value="添加" name="addType" onclick="addNodeType()"></td>
	<td>&nbsp;规格型号和软件版本</td>
	<td>&nbsp;<input type="text" name="version" value="10"></td>
</tr>
<tr>
	<td >&nbsp;备注<input type="hidden" id = "success" value = "<%=request.getParameter("a")%>"></td><td><input type="text" name="memo" value="5"></td>
	<td></td>
	<td></td></tr>
<tr>
	<td colspan="4" align="right">&nbsp;<input type="submit" value="提交并下一步" name="commit" id="button"/>
		<input type="reset" value="重置" name="reset" id="button"> 
	</td>
</tr>
</table>
  </form>
  </body>
</html>
