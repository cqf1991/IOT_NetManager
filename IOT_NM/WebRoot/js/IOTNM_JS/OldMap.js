var Map;
var Nets;
//var SubNets;
//var Nodes;
var CurrentIcons;
var CurrentMsgs;
var mapJson;
var NetIndex_;
var SubNetIndex_;

var CurrentNet;//当前选择网络号
var oldID=-1;
var CurrentSubNet;//当前选中子网号
var CurrentNode;//当前选中节点号

var OldZoomLevel;


function initialize()
{
	Map = new BMap.Map('center2',{mapType: BMAP_HYBRID_MAP});
	var point = new BMap.Point(115.83733,28.656634);
	Map.centerAndZoom(point, 12); 
	Map.enableScrollWheelZoom(true);
	OldZoomLevel = 12;
	
	Map.addControl(new BMap.NavigationControl());
	Map.addControl(new BMap.ScaleControl());    
	Map.addControl(new BMap.OverviewMapControl());    
	Map.addControl(new BMap.MapTypeControl());//以上为地图基本信息初始化
	
	CurrentIcons = new Hashtable();//当前地图上显示的图标
	CurrentMsgs = new Array();//当前地图上显示的拓扑消息画线
	
	CurrentNet = -1;//当前未选中网络
	CurrentSubNet = -1;//当前未选中子网
	CurrentNode = -1;//当前未选中节点
	
	ShowNets();

//	Map.addEventListener("zoomend", function(){ 
//		var newLevel = Map.getZoom();
//		if(OldZoomLevel<newLevel)//地图放大
//		{
//			if(OldZoomLevel<15&&newLevel>14 && newLevel<17)//放大到显示子网
//			{
//				var n=Nets.netCount;
//				switch(n)
//				{
//					case 0:
//						alert("当前无网络，请管理员添加一个网络!");
//						Map.setZoom(OldZoomLevel);
//						break;
//					case 1:
//						DeleteHeatMapIcon();
//						ShowSubNets();
//						OldZoomLevel = newLevel;
//						break;
//					default:
//						alert("请选择一个网络!");
//						Map.setZoom(OldZoomLevel);
//				}
//			}
//			else if(OldZoomLevel<17&&newLevel>=17)//放大到显示节点
//			{
//				var s=Nets.netList[NetIndex_].subnets.length;
//				switch(s)
//				{
//					case 0:
//						alert("当前无子网，请管理员添加一个子网!");
//						Map.setZoom(OldZoomLevel);
//						break;
//					case 1:
//						DeleteHeatMapIcon();
//						ShowNodes();
//						OldZoomLevel = newLevel;
//						break;
//					default:
//						alert("请选择一个子网!");
//						Map.setZoom(OldZoomLevel);
//				}
//			}
//		}
//		else//地图缩小
//		{
//			if(OldZoomLevel>16&&newLevel<17)//缩小到显示子网
//			{
//				CurrentSubnet = -1;
//				DeleteCurrentIcon();
//				ShowSubNets(NetIndex_);
//				OldZoomLevel = newLevel;
//			}
//			else if(OldZoomLevel>14&&newLevel<15)//缩小到显示网络
//			{
//				CurrentNet = -1;
//				DeleteHeatMapIcon();
//				ShowNets();
//				OldZoomLevel = newLevel;
//			}
//		}
//	});
}