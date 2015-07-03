
var Map;
var netID;


var net=new Array();
var subnet=new Array();
var node=new Array();
var sensor=new Array();

//覆盖范围的经纬度
var lngR;
var latR;
var lngL;
var latL;



var OldZoomLevel;

var Nets;





function dataChange(Nets){

	for(var i in Nets.NET)
	{
		net.push(Nets.NET[i]);
		if(net[i].SUBNET!=null)
		for(var j in Nets.NET[i].SUBNET)
		{
			subnet.push(net[i].SUBNET[j]);
			if(subnet[j].NODE!=null)
			for(var k in Nets.NET[i].SUBNET[j].NODE)
			{
			node.push(subnet[j].NODE[k]);
			if(node[k].SENSOR!=null)
				for(var m in Nets.NET[i].SUBNET[j].NODE[k].SENSOR)
				{
					sensor.push(node[k].SENSOR[m]);	
				}
			}
		}
	}
	
}


	
	
function showNet(net,i)
{
	var index='0'; //子网数量
	if(net[i].SUBNET!=null)
		index=net[i].SUBNET.length;
	var points = new Array();
		var point={

			"lngL":net[i].CVRG_LB_X,//网络纬度
			"latL":net[i].CVRG_LB_Y,//网络经度
		}
			points.push(point);
	
	
	var position = new BMap.Point(net[i].CVRG_LB_Y,net[i].CVRG_LB_X);
	var netIcon = new BMap.Icon("img/net.ico",new BMap.Size(25,25));
	 
	var marker = new BMap.Marker(position,{icon:netIcon});
	
	var marklabel = new BMap.Label(net[i].NTID+"号网络",{offset:new BMap.Size(-20,-20)});
	

	Map.addOverlay(marker);//添加覆盖物
	marker.setLabel(marklabel);	//增加标签
	var circle = new BMap.Circle(position,radius(net[i].CVRG_LB_X,net[i].CVRG_LB_Y,net[i].CVRG_RU_X,net[i].CVRG_RU_Y
	));//覆盖区域
	Map.addOverlay(circle);
	circle.hide();
	marker.addEventListener("click",function(e){ //

		
	
		Map.openInfoWindow(info,e.point);
		Map.panTo(e.point);
		console.log("经度:"+e.point.lng,"纬度:"+e.point.lat);
		updateGridData(net[i]);
		
		setTimeout(function(){Map.closeInfoWindow(info,e.point)},3000);	
	});
	
	var opts = {
			width:240,
			height:120,
			title:"       网络基本信息",
		
	}
	var info = new BMap.InfoWindow("网络ID:  "+net[i].NTID+"<br>"+
			"网络描述："+net[i].NTDSCRPT+"<br>"+"经纬度:"+net[i].CVRG_LB_X+","+net[i].CVRG_LB_Y+"<br>"+"子网数量:"+index,opts);

	marker.addEventListener("mouseover",function(e){


	circle.show();
	
	});
	marker.addEventListener("mouseout",function(e){
	

	circle.hide();})
	
}


	
function showSubnet(subnet,i)        //子网显示
	{
	var index='0'; //节点数量
	if(subnet[i].NODE!=null)
		index=subnet[i].NODE.length;
	var points = new Array();            //热力图需要
		var point={
			"lngR":subnet[i].CVRG_RU_X ,
			"latR":subnet[i].CVRG_RU_Y,
			"lngL":subnet[i].CVRG_LB_X,
			"latL":subnet[i].CVRG_LB_Y,
		}
		points.push(point);
	
	
	var position = new BMap.Point(subnet[i].CVRG_LB_Y,subnet[i].CVRG_LB_X);
	var netIcon = new BMap.Icon("img/node.ico",new BMap.Size(16,16));
	var marklabel = new BMap.Label(subnet[i].SBNTID+"号子网");
	var marker = new BMap.Marker(position,{icon:netIcon});
	if(Map.getZoom()<17)
	{
	Map.addOverlay(marker);
	
	marker.setLabel(marklabel);
	}else{

	}
	marker.addEventListener("click",function(e){ 
	updateGridData(subnet[i]);
		var location= new BMap.Point(e.point.lng,e.point.lat);
		Map.panTo(location);
		console.log("经度:"+e.point.lng,"纬度:"+e.point.lat);
		Map.openInfoWindow(info,location);
	});
	
	var opts = {
			width:240,
			height:150,
			title:"       子网基本信息",
		
	}
	var info = new BMap.InfoWindow("子网ID:  "+subnet[i].SBNTID+"<br>"+"子网名称："+subnet[i].NTNM+"<br>"+
			"节点数量："+index+"<br>"+"子网描述："+subnet[i].DSPT+"<br>"+"经纬度:"+subnet[i].CVRG_LB_X+","+subnet[i].CVRG_LB_Y,opts);
	}
	
	
function showNode(node,i) //节点显示
	{
	var index='0'; //传感器数量
	if(node[i].SENSOR!=null)
		index=node[i].SENSOR.length;
		var points = new Array();
	
	/*	var point={
			"LCTN_X":node[i].LCTN_X ,
			"LCTN_Y":node[i].LCTN_Y,	
		}
		points.push(point);
	*/
	var position = new BMap.Point(node[i].LCTN_X ,node[i].LCTN_Y);

	var netIcon = new BMap.Icon("img/node.ico",new BMap.Size(16,16));
	var marklabel = new BMap.Label(node[i].NDPHDR+"号节点");
	var marker = new BMap.Marker(position,{icon:netIcon});
	Map.addOverlay(marker);
	marker.setLabel(marklabel);
	console.log("节点经纬度："+node[i].LCTN_X,node[i].LCTN_Y);
	marker.addEventListener("click",function(e){ //
		updateGridData(node[i]);
		var location= new BMap.Point(e.point.lng,e.point.lat);
		Map.panTo(location);
		
		Map.openInfoWindow(info,location);
	});
	
	var opts = {
			width:200,
			height:100,
			title:"       节点基本信息",
		
	}
	var info = new BMap.InfoWindow("节点名称:  "+node[i].NDPHDR+"<br>"+"节点功率："+node[i].TRSMTPWR+"<br>"+
			"节点描述："+node[i].NDDSPT+"<br>"+"传感器数量"+index+"<br>",opts);
	
	}
	
	
function radius(x1,y1,x2,y2){//覆盖半径的计算

	return Number(Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));
}
function getCirclePoint(x1,y1,x2,y2){//圆心计算
	
	return Number(((x1-x2)+(y1-y2))/2);
}
function remove_overlay(){//移除所有覆盖物
		Map.clearOverlays();         	}

	
function initMap(Nets)
	{
	
		
		Map = new BMap.Map('center2',{mapType: BMAP_HYBRID_MAP});
		var point = new BMap.Point(115.842003,28.6620007);

		Map.centerAndZoom(point, 13); 
		Map.enableScrollWheelZoom(true);
		OldZoomLevel = 13;
		console.log(Map);
		
		Map.addControl(new BMap.NavigationControl());//地图平移缩放控件
		Map.addControl(new BMap.ScaleControl());    //比例尺控件
		Map.addControl(new BMap.OverviewMapControl());    //缩略地图控件
		Map.addControl(new BMap.MapTypeControl());//地图类型控件

		dataChange(Nets);
		Map.enableDoubleClickZoom();//双击放大
		CurrentIcons = new Hashtable();//当前地图上显示的图标
		CurrentMsgs = new Array();//当前地图上显示的拓扑消息画线
		
		CurrentNet = -1;//当前未选中网络
		CurrentSubNet = -1;//当前未选中子网
		CurrentNode = -1;//当前未选中节点
		Map.addEventListener("zoomend",function(){//地图zoom16显示网络 17显示子网 18显示节点 19显示传感器
			var currentLevel=Map.getZoom();
			console.log("currentLevel="+currentLevel+"|"+"OldZoomLevel="+OldZoomLevel);
			
			if(OldZoomLevel<currentLevel)//地图放大 
			{ 
			for(var i in net)
			{
				showNet(net,i);
			}
				if(OldZoomLevel<17&&currentLevel<16){//放大地图至子网
				var n=Nets.NETSIZE;
					if(n!='0')
					{
						for(var i in subnet)
						showSubnet(subnet,i);
						OldZoomLevel = currentLevel;	
						
					}else{
						alert("当前无网络，请管理员添加。");
					}
				}else if(OldZoomLevel<18&&currentLevel>17&&currentLevel<19)//放大地图至节点
				{
					for(var i in node)
					showNode(node,i);
			
					OldZoomLevel = currentLevel;
				}else if(OldZoomLevel<19&&currentLevel==19)//放大地图至传感器
				{
					OldZoomLevel = currentLevel;
				}
			}else//地图缩小
			{
					if(OldZoomLevel==19&&currentLevel<19&&currentLevel>17)//缩小至节点
					OldZoomLevel = currentLevel;
					else if(OldZoomLevel>17&&currentLevel<18&&currentLevel>16)//缩小至子网
					{
						OldZoomLevel = currentLevel;
					}else if(OldZoomLevel>16&&currentLevel<17&&currentLevel>15){
						OldZoomLevel = currentLevel;
					}else{
						
					}
			}
			
		})
		}
		/**
		* 东部网格数据更新
		*暂时无法写进其他js。
		*传感器与节点共同显示，且只含有一个。
		*/
		
function updateGridData(str) {//str为传入的单个网络/子网/节点,暂时设置节点只含有一个传感器
			var size='0';//数量判断
			var gridHandle = Ext.getCmp('Rigthgrid');		
			
			if (str.NTID!=null) {//网络信息显示
				myTitle = "网络名称：" + str.NTID+"号网络";
								//myGrid.setTitle(myTitle);
								if(str.subnet!=null)         //存在子网则在地图显示子网
								{
								for(var i in str.subnet)
								ShowSubNets(str);//
								}
							GridNet(str);	
						
						}else if(str.SBNTID!=null){           //子网信息在网格显示         
							myTitle = "子网名称：" + str.SBNTID+"号子网";
								//myGrid.setTitle(myTitle);
								if(str.node!=null)         //存在节点则在地图显示节点
								{
								for(var i in str.node)
								ShowNode(str);
								}
							GridSubnet(str);
							
						}else if(str.NDPHDR!=null){
							    myTitle = "节点名称：" + str.SBNTID+"号节点";
								//myGrid.setTitle(myTitle);
				
							gridHandle.setTitle("节点信息");
							GridNode(str);
							}else {
							GridSensor(str);
							}
						
	}
	
	function GridNet(net){
		var gridHandle = Ext.getCmp('Rigthgrid');	
		myTitle = "网络名称：" + str.NTID+"号网络";
		if(net.SUBNETSIZE==null)
		size='0';
		else
		size=net.SUBNETSIZE[0];
		gridHandle.setTitle("网络信息");
		gridHandle.setSource({
		"网络ID": net.NTID+"号网络",						
		"经纬度": net.CVRG_LB_X + ","+ net.CVRG_LB_Y,	
	    "网络描述": net.NTDSCRPT[0],	  //NTDSCRPT被当作数组显示需要加0							
		"子网数量" : size,
		});
	}
	function GridSubnet(subnet){
		var gridHandle = Ext.getCmp('Rigthgrid');	
			if(subnet.NODESIZE==null)  
				size='0';
			else
				size=subnet.NODESIZE[0];
				gridHandle.setTitle("子网信息");
				gridHandle.setSource({
					"子网ID" : subnet.SBNTID+"号子网",	
					"子网名称": subnet.NTNM[0],
					"子网描述" : subnet.DSPT[0],			
					"经纬度" : subnet.CVRG_LB_X[0] + ","
						+ subnet.CVRG_LB_Y[0],								
				"节点数量" : size,
							});
	}
	function GridNode(node){
		var gridHandle = Ext.getCmp('Rigthgrid');	
			if(node.SENSORSIZE==null)  
				size='0';
			else
			gridHandle.setTitle("子网信息");
								gridHandle.setSource({
								"节点ID" : node.NDPHDR[0]+"号节点",	
								"节点描述" : node.NDDSPT[0],
								"节点功率":node.TRSMTPWR[0],
								"经纬度" : node.LCTN_X[0] + ","
										+ node.LCTN_Y[0],								
								"传感器数量" : node.SENSORSIZE[0]
		
	});
	}
	function GridSensor(sensor){
		var gridHandle = Ext.getCmp('Rigthgrid');	

	
			gridHandle.setSource({
			"节点ID" : sensor.NDPHDR[0]+"号节点",	
			"节点描述" : sensor.NDDSPT[0],
			"节点功率"	:	sensor.TRSMTPWR[0],
			"经纬度" : sensor.LCTN_X[0] + ","
					+ sensor.LCTN_Y[0],								
			"传感器数量" : sensor.SENSORSIZE[0],
			"传感器编号": sensor.SENSOR[0].UNIT,
			"传感器类型":sensor.SENSOR[0].STPNM,
			"传感器描述":sensor.SENSOR[0].DSPTN,
			"传感器_TP":sensor.SENSOR[0].SNSR_TP
							});
							
							
	}
	
	
	
	
	
	function NavTreeEvent(rcd,Nets){
		var location;
		//dataChange(Nets);
		   var depth=rcd.data.depth;
		   var index=rcd.data.index;
	
	switch(depth)
		{
			case 1: 
			if(16!=Map.getZoom())
			
			Map.setZoom(18);
			
			location= new BMap.Point(net[index].CVRG_LB_Y,net[index].CVRG_LB_X);
			Map.panTo(location);
			GridNet(net[index]);
			break;
			
			case 2: 
			if(17!=Map.getZoom())
			Map.setZoom(17);
		    netIndex=rcd.parentNode.data.Index;
			location= new BMap.Point(net[netIndex].SUBNET[index].CVRG_LB_Y,net[netIndex].SUBNET[index].CVRG_LB_X);
			Map.panTo(location);
			
			GridSubnet(net[netIndex].SUBNET[index]);
			break;
			case 3: 
			if(18!=Map.getZoom())
			Map.setZoom(18);
			 netIndex=rcd.parentNode.parentNode.data.index;
			 subIndex=rcd.parentNode.data.index;
		
			location= new BMap.Point(net[netIndex].SUBNET[subIndex].NODE[index].LCTN_Y,net[netIndex].SUBNET[subIndex].NODE[index].LCTN_X);
			Map.panTo(location);
			GridNode(net[netIndex].SUBNET[subIndex].NODE[index]);
			break;
			case 4: break;
			default: alert("网络结构发生变化，请通知管理员！");break;
			
		}
	}

          

					
					
				

		
