<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>节点绑定传感器</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="IOTReg.css">
 	<style type="text/css">

	#sensor
	{
		position:absolute;left:450px;top:0px;width:400px;
	}
	
	#showDiv
	{
		position:absolute;left:0px;top:150px;width:1200px;
	}
	
	hr
	{
		width:100%;
	}
	#bind
	{
		background:#FFEFDB;
		width:400px;
	
	}
	#selectNode
	{
		background:#FFEFDB;
	}
	#selectSensor
	{
		background:#FFEFDB;
	}
    </style>

    <script type='text/javascript' src='../dwr/engine.js'></script>  
    <script type='text/javascript' src='../dwr/util.js'></script>  
    <script type='text/javascript' src='../dwr/interface/globalDataReg.js'></script>  
    <script type="text/javascript" src="../dwr/interface/subnetReg.js"></script>
    <script type="text/javascript" src="../dwr/interface/netReg.js"></script>
    <script type="text/javascript">
    
    //初始化数据
   function initBindFun()
   {

	   var val = document.getElementById("success").value;
       if (val == "1")
       {
       	alert("传感器注册成功！");
       }

	   
	    var netNameList=document.getElementById("netNameList");
	    var subnetNameList=document.getElementById("subnetNameList");
	    var nodeNameList=document.getElementById("nodeNameList");
	    var sensorNameList=document.getElementById("sensorNameList");
		var nodeDesc=document.getElementById("nodeDesc");
		var snsrTypeTag=document.getElementById("sensorType");
	    var snsrDesc=document.getElementById("sensorDesc");
	    var nodeBind=document.getElementById("bindNode");
	    var index=0;
	
	     removeAll("netNameList");//移除网络信息
	    removeAll("subnetNameList");//移除子网信息
	    removeAll("nodeNameList");
	    removeAll("sensorNameList");
		  globalDataReg.getNetMap(function(data)
		 	{
		 		for(var netKey in data)
		 		{
		 			netNameList.add(new Option(netKey,netKey));
		 			if(index==0)
		 			{
		 			    var subnetIndex=0;
		 				var subnetSet=data[netKey].subnetMap;
		    		    	for(var subnetKey in subnetSet)
		    		    	{
		    		    		subnetNameList.add(new Option(subnetKey,subnetSet[subnetKey].m_nSubnetId));
		    		    		if(subnetIndex==0)
		    		    		{
		    		    		    var nodeSet=subnetSet[subnetKey].nodeMap;
		    		    		    var nodeKeyIndex=0;
		    		    		    for(var nodeKey in nodeSet)
		    		    		    {
		    		    		    	nodeNameList.add(new Option(nodeKey,nodeSet[nodeKey].m_nNodeAddress));
		    		    		    	if(nodeKeyIndex==0)
		    		    		    	{
		    		    		    		nodeDesc.value=nodeSet[nodeKey].m_strNodeDescription;
		    		    		    	}
		    		    		    	nodeKeyIndex++;
		    		    		    }
	    		    			}
	    		    			subnetIndex++;		
		 			}
		 			index++;
		 		}
		 		}
    	  });
    	  
    	   globalDataReg.getSensorMap(function(data)
    		{
    			if(data)
    			{
    				var index=0;
    				for(var sensorKey in data)
    				{
    				    sensorNameList.add(new Option(sensorKey,sensorKey)); 
    					if(index==0)
    					{
    						var snsrType=data[sensorKey].m_nSensorType;
    						globalDataReg.getSensorTypeNameByTypeId(snsrType,function(sensorTypeName)
    						{	
    							snsrTypeTag.value=sensorTypeName;
    						});
    						snsrDesc.value=data[sensorKey].m_strSensorDescription;
    					}
    					index++;
    				}
    			}
    		});
       }
    	
    	//选择网络下拉框触发事件
    	function selNet()
    	{
    		var netNameList=document.getElementById("netNameList");
		    var subnetNameList=document.getElementById("subnetNameList");
		    var nodeNameList=document.getElementById("nodeNameList");
			var nodeDesc=document.getElementById("nodeDesc");
		    var nodeBind=document.getElementById("bindNode");
    		var keyValue=netNameList.options[netNameList.selectedIndex].value;
    		 removeAll("subnetNameList");//移除子网信息
    		globalDataReg.getNetByName(keyValue,function(netData)
    		{
    		  
    		    removeAll("nodeNameList");
    			var subnetSet=netData.subnetMap;
    		    var innerIndex=0;
    			for(var subnetKey in subnetSet)
    			{
    				subnetNameList.add(new Option(subnetKey,subnetKey));
    				if(innerIndex==0)
    				{
    				  removeAll("nodeNameList");
    				  nodeSet=subnetSet[subnetKey].nodeMap;
    				  var nodeIndex=0;
    				  for(var nodeKey in nodeSet)
    				  {
    					nodeNameList.add(new Option(nodeKey,nodeKey));
    					if(nodeIndex==0)
    					{
    						nodeDesc.value=nodeSet[nodeKey].m_strNodeDescription;
    						var showNodeData=netData.m_strNetName+"号网络"+subnetKey+"号子网"
    						+nodeSet[nodeKey].m_nNodeAddress+"号节点";
    						nodeBind.value=showNodeData;
    					}
    					nodeIndex++;
    				  }
    				}
    				innerIndex++;
    			}
    		});
    	}
    	
    	//选择子网下拉框触发事件
    	function selSubnet()
    	{
    	    var netNameList=document.getElementById("netNameList");
            var subnetNameList=document.getElementById("subnetNameList");
            var nodeNameList=document.getElementById("nodeNameList");
	        var nodeDesc=document.getElementById("nodeDesc");
            var nodeBind=document.getElementById("bindNode");
    		var subnetKeyValue=subnetNameList.options[subnetNameList.selectedIndex].value;//子网ID
    		var netKeyValue=netNameList.options[netNameList.selectedIndex].value;//网络ID
    		globalDataReg.getNetByName(netKeyValue,function(netData)
    		{
    		   var intSubnetKey=parseInt(subnetKeyValue);
    		   var subnetData=netData.subnetMap[intSubnetKey];
    			
    				removeAll("nodeNameList");
    				var nodeSet=subnetData.nodeMap;
    				var nodeIndex=0;
    				for(var nodeKey in nodeSet)
    				{
    					nodeNameList.add(new Option(nodeKey,nodeSet[nodeKey].m_nNodeAddress));
    					if(nodeIndex==0)
    					{
    						nodeDesc.value=nodeSet[nodeKey].m_strNodeDescription;
    						var showNodeData=netData.m_strNetName+"网络"+intSubnetKey+"子网"
    						+nodeSet[nodeKey].m_nNodeAddress+"节点";
    						nodeBind.value=showNodeData;
    					}
    					nodeIndex++;
    				}
    			});
    		
    	}
    	//选择节点下拉框触发事件
    	function selNode()
    	{
    	 	var netNameList=document.getElementById("netNameList");
		    var subnetNameList=document.getElementById("subnetNameList");
		    var nodeNameList=document.getElementById("nodeNameList");
		    var sensorNameList=document.getElementById("sensorNameList");
			var nodeDesc=document.getElementById("nodeDesc");
			var snsrTypeTag=document.getElementById("sensorType");
		    var snsrDesc=document.getElementById("sensorDesc");
		    var nodeBind=document.getElementById("bindNode");
    		var subnetKeyValue=subnetNameList.options[subnetNameList.selectedIndex].value;//子网ID
    		var netKeyValue=netNameList.options[netNameList.selectedIndex].value;//网络ID
    		var nodeKeyValue=nodeNameList.options[nodeNameList.selectedIndex].value;//节点ID
    		
    		globalDataReg.getNetByName(netKeyValue,function(net)
    		{
    			var intSubnetKey=parseInt(subnetKeyValue);
    			var subnet=net.subnetMap[intSubnetKey];
    			var intNodeKey=parseInt(nodeKeyValue);
    			var node=subnet.nodeMap[intNodeKey];
    			nodeDesc.value=node.m_strNodeDescription;
    		    var showNodeData=net.m_strNetName+"网络"+intSubnetKey+"子网"
    						+node.m_nNodeAddress+"节点";
    			nodeBind.value=showNodeData;
    		});
    	}
    	
    	//选择传感器名称下拉框触发事件
    	function selSensor()
    	{
		    var sensorNameList=document.getElementById("sensorNameList");
			var snsrTypeTag=document.getElementById("sensorType");
		    var snsrDesc=document.getElementById("sensorDesc");
		    
		    var sensorKeyValue=sensorNameList.options[sensorNameList.selectedIndex].value;
		    
		    globalDataReg.getSensorBySensorName(sensorKeyValue,function(sensorData)
		    {
		    	var typeId=sensorData.m_nSensorType;
		    	globalDataReg.getSensorTypeNameByTypeId(typeId,function(sensorTypeName)
		    	{	
		    	   var sensorType=document.getElementById("sensorType");
		    	   var sensorDesc=document.getElementById("sensorDesc");
		    		sensorType.value=sensorTypeName;
		    		sensorDesc.value=sensorData.m_strSensorDescription;
		    	});
		    });
    	}
    	
    	//删除option
    	function removeAll(selTag){
           var obj=document.getElementById(selTag);
            obj.options.length=0;
         }
         
         function bindNodeSensorData()
         {
             var bindSensor=document.getElementById("bindSensor");
             var oldData=bindSensor.value;
         	 var sensorKeyValue=sensorNameList.options[sensorNameList.selectedIndex].value;
         	 var showData=sensorKeyValue;
         	 if(oldData.length>0)
         	 {
         	 	showData=oldData+"<br\>"+showData;
         	 }
         	 
         	 bindSensor.value=showData;
         }
    </script>
  </head>
  
  <body onload="initBindFun()">
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
     绑定节点与传感器
</div>

  <form style="top: 48px; left: 182px;">
  <div id="selectNode">
  请选择节点
  </div>
  <div >
  <table width="400px">
  <tr>
	<td>&nbsp;网络名称</td>
	<td>&nbsp;<select size="1" name="netNameList" id="netNameList" onchange="selNet()"></select></td></tr>

	<tr><td>&nbsp;子网名称</td>
	<td>&nbsp;<select size="1" name="sunetNameList" id="subnetNameList" onchange="selSubnet()"></select></td></tr>

	<tr><td>&nbsp;节点地址</td>
	<td>&nbsp;<select size="1" name="nodeNameList" id="nodeNameList" onchange="selNode()"></select></td></tr>
   <tr><td>节点描述信息：</td>
	<td><input type="text" name="nodeDesc" id="nodeDesc"></td></tr>
	</table>
	</div>
	<div id="sensor" style="top: 3px; left: 464px;">
	<div id="selectSensor">
	传感器信息
	</div>
	<table style="left: 0px; width: 399px;">
	<tr>
		<td>传感器名称</td>
		<td>
			<select name="sensorNameList" id="sensorNameList" size="1" onchange="selSensor()">
			</select>
		</td>
	</tr>
	<tr>
		<td>传感器类型
		</td>
		<td><input type="text" name="sensorType" id="sensorType"/>
		</td>
	</tr>
		<tr>
			<td>传感器描述信息</td>
			<td><input type="text"  name="sensorDesc" id="sensorDesc"></td>
		</tr>
		<tr>
		<td colspan="2">
		<input type="Button" name="bindData" value="添加绑定" style="width:80px; align:center;" onclick="bindNodeSensorData()"/>
		</td>
		</tr>
	</table>
	
	</div>
	<div id="showDiv">
	<div id="bind">绑定详细信息<input type="hidden" id = "success" value = "<%=request.getParameter("a")%>"></div>
	<table style="left: 0px; width: 849px; top: 18px; height: 73px;">
		<tr>
			<td>节点</td>
			<td><textarea name="bindNode" id="bindNode"></textarea></td>
			<td>传感器</td>
			<td><textarea name="bindSensor" id="bindSensor" ></textarea></td>
		</tr>
	</table>
	</div>
</form>
  
  </body>
</html>