var randomLine;
var MMdataOri={

		
	    'items': [
	              {
	                  'Net': '2号网络',
	                  'SubNet': '1号子网',
	                  'Node': '0号节点',
	                  'NodeType':'中继节点',
	                  'MsgType': Math.round(Math.round(Math.random()*5+13)),
	                  'MsgCount': Math.round(Math.round(Math.random()*48700+1300)),
	                  'MsgSequence': '消息序列',
	                  'MsgBody': '消息实体',
	                  'Route': 0,
	                  'Voltage': parseFloat(((Math.random()*2+2)/10).toFixed(2))+3.0+" V",	                  
	                  'NetID': '2',
	                  'SubnetID': '1',
	                  'lat':28.653762,
	                  'lng':115.832718,	                  
	                  'NodeID': 0
	              },
	              {
	                  'Net': '2号网络',
	                  'SubNet': '1号子网',
	                  'Node': '1号节点',
	                  'NodeType':'感知节点',
	                  'MsgType': Math.round(Math.random()*5+13),
	                  'MsgCount': Math.round(Math.round(Math.random()*48700+1300)),
	                  'MsgSequence': '消息序列',
	                  'MsgBody': '消息实体',
	                  'Route': 1,
	                  'Voltage': parseFloat(((Math.random()*2+2)/10).toFixed(2))+3.0+" V",	                  
	                  'NetID': '2',
	                  'SubnetID': '1',
	                  'lat':28.653072,
	                  'lng':115.830135,	                  
	                  'NodeID': 1
	              },
	              {
	                  'Net': '2号网络',
	                  'SubNet': '1号子网',
	                  'Node': '3号节点',
	                  'NodeType':'感知节点',
	                  'MsgType': Math.round(Math.random()*5+13),
	                  'MsgCount': Math.round(Math.round(Math.random()*48700+1300)),
	                  'MsgSequence': '消息序列',
	                  'MsgBody': '消息实体',
	                  'Route': 2,
	                  'Voltage': parseFloat(((Math.random()*2+2)/10).toFixed(2))+3.0+" V",	                  
	                  'NetID': '2',
	                  'SubnetID': '1',
	                  'lat':28.653465,
	                  'lng':115.830863,	                  
	                  'NodeID': 2
	              },
	              {
	                  'Net': '2号网络',
	                  'SubNet': '1号子网',
	                  'Node': '5号节点',
	                  'NodeType':'感知节点',
	                  'MsgType': Math.round(Math.random()*5+13),
	                  'MsgCount': Math.round(Math.round(Math.random()*48700+1300)),
	                  'MsgSequence': '消息序列',
	                  'MsgBody': '消息实体',
	                  'Route': 3,
	                  'Voltage': parseFloat(((Math.random()*2+2)/10).toFixed(2))+3.0+" V",	                  
	                  'NetID': '2',
	                  'SubnetID': '1',
	                  'lat':28.653029,
	                  'lng':115.831959,	                  
	                  'NodeID': 3
	              },{
	                  'Net': '2号网络',
	                  'SubNet': '1号子网',
	                  'Node': '7号节点',
	                  'NodeType':'感知节点',
	                  'MsgType': Math.round(Math.random()*5+13),
	                  'MsgCount': Math.round(Math.round(Math.random()*48700+1300)),
	                  'MsgSequence': '消息序列',
	                  'MsgBody': '消息实体',
	                  'Route': 4,
	                  'Voltage': parseFloat(((Math.random()*2+2)/10).toFixed(2))+3.0+" V",	                  
	                  'NetID': '2',
	                  'SubnetID': '1',
	                  'lat':28.654067,
	                  'lng':115.830782,	                  
	                  'NodeID': 4
	              },{
	                  'Net': '2号网络',
	                  'SubNet': '1号子网',
	                  'Node': '9号节点',
	                  'NodeType':'感知节点',
	                  'MsgType': Math.round(Math.random()*5+13),
	                  'MsgCount': Math.round(Math.round(Math.random()*48700+1300)),
	                  'MsgSequence': '消息序列',
	                  'MsgBody': '消息实体',
	                  'Route': 5,
	                  'Voltage': parseFloat(((Math.random()*2+2)/10).toFixed(2))+3.0+" V",	                  
	                  'NetID': '2',
	                  'SubnetID': '1',
	                  'lat':28.654312,
	                  'lng':115.832026,	                  
	                  'NodeID': 5
	              },{
	                  'Net': '4号网络',
	                  'SubNet': '1号子网',
	                  'Node': '0号节点',
	                  'NodeType':'中继节点',
	                  'MsgType': Math.round(Math.random()*5+13),
	                  'MsgCount': Math.round(Math.round(Math.random()*48700+1300)),
	                  'MsgSequence': '消息序列',
	                  'MsgBody': '消息实体',
	                  'Route': "0,1",
	                  'Voltage': parseFloat(((Math.random()*2+2)/10).toFixed(2))+3.0+" V",	                  
	                  'NetID': '4',
	                  'SubnetID': '1',
	                  'lat':28.655707,
	                  'lng':115.834236,	                 
	                  'NodeID': 6
	              },{
	                  'Net': '4号网络',
	                  'SubNet': '1号子网',
	                  'Node': '1号节点',
	                  'NodeType':'感知节点',
	                  'MsgType': Math.round(Math.random()*5+13),
	                  'MsgCount': Math.round(Math.round(Math.random()*48700+1300)),
	                  'MsgSequence': '消息序列',
	                  'MsgBody': '消息实体',
	                  'Route': "1,0",
	                  'Voltage': parseFloat(((Math.random()*2+2)/10).toFixed(2))+3.0+" V",	                  
	                  'NetID': '4',
	                  'SubnetID': '1',
	                  'lat':28.655798,
	                  'lng':115.835835,	                  
	                  'NodeID': 7
	              },{
	                  'Net': '5号网络',
	                  'SubNet': '1号子网',
	                  'Node': '0号节点',
	                  'NodeType':'中继节点',
	                  'MsgType': Math.round(Math.random()*5+13),
	                  'MsgCount': Math.round(Math.round(Math.random()*48700+1300)),
	                  'MsgSequence': '消息序列',
	                  'MsgBody': '消息实体',
	                  'Route': "0,1",
	                  'Voltage': parseFloat(((Math.random()*2+2)/10).toFixed(2))+3.0+" V",	                
	                  'NetID': '5',
	                  'SubnetID': '1',
	                  'lat':28.653021,
	                  'lng':115.833262,	                  
	                  'NodeID': 8
	              },{
	                  'Net': '5号网络',
	                  'SubNet': '1号子网',
	                  'Node': '1号节点',
	                  'NodeType':'感知节点',
	                  'MsgType': Math.round(Math.random()*5+13),
	                  'MsgCount': Math.round(Math.round(Math.random()*48700+1300)),
	                  'MsgSequence': '消息序列',
	                  'MsgBody': '消息实体',
	                  'Route': "1,0",
	                  'Voltage': parseFloat(((Math.random()*2+2)/10).toFixed(2))+3.0+" V",	                  
	                  'NetID': '5',
	                  'SubnetID': '1',
	                  'lat':28.651313,
	                  'lng':115.833814,	                  
	                  'NodeID': 9
	              }
	          ]
	      };
dataStore = Ext.create('Ext.data.Store', {
     fields: [ 'Net','SubNet', 'Node', 'NodeType','MsgType','MsgCount','MsgSequence','MsgBody','Route','Voltage','MsgTime','NetID','SubnetID' ],
     data:MMdataOri,
proxy:{
		type: 'memory',
reader:{
    type: 'json',
    root: 'items'
}
}
});
var MMdata=new Array();

function getRandomRoute(str)
{
	var randomRo=["0","1","3","5","7","9"];
	var random1="random";
	var random2="random";
	while(random1==random2)
	{
		randomLine=Math.round(Math.random()*5);
		random1=randomRo[parseInt(str)];
		random2=randomRo[randomLine];		
		}
	
	return random1+","+random2;
	
	}

function dataProvide(){
	var polyline;
	Ext.TaskManager.start({
		run:function(){		
		Map.removeOverlay(polyline);
		var randomStore=MMdataOri.items[Math.round(Math.random()*5)];
		randomStore.MsgTime=(new Date()).toLocaleString();
		if(randomStore.NodeID<6)//net2
		{
			randomStore.Route=getRandomRoute(randomStore.NodeID);
			dataStore.insert(0,randomStore);
			polyline = new BMap.Polyline([
				                          		new BMap.Point(randomStore.lng, randomStore.lat),
				                          		new BMap.Point(node[MMdataOri.items[randomLine].NodeID].LCTN_Y,node[MMdataOri.items[randomLine].NodeID].LCTN_X)
				                          	], {strokeColor:"#DD0000", strokeWeight:4, strokeOpacity:1}); 
			Map.addOverlay(polyline); 			
		}
		
			
		
		 
		
	},
		interval:3000
	});

};
