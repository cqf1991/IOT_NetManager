var Map;
var Nets;
//var SubNets;
//var Nodes;
var CurrentIcons;
var CurrentMsgs;
var mapJson;
var NetIndex_;
var SubNetIndex_;

var CurrentNet;//��ǰѡ�������
var oldID=-1;
var CurrentSubNet;//��ǰѡ��������
var CurrentNode;//��ǰѡ�нڵ��

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
	Map.addControl(new BMap.MapTypeControl());//����Ϊ��ͼ������Ϣ��ʼ��
	
	CurrentIcons = new Hashtable();//��ǰ��ͼ����ʾ��ͼ��
	CurrentMsgs = new Array();//��ǰ��ͼ����ʾ��������Ϣ����
	
	CurrentNet = -1;//��ǰδѡ������
	CurrentSubNet = -1;//��ǰδѡ������
	CurrentNode = -1;//��ǰδѡ�нڵ�
	
	ShowNets();

//	Map.addEventListener("zoomend", function(){ 
//		var newLevel = Map.getZoom();
//		if(OldZoomLevel<newLevel)//��ͼ�Ŵ�
//		{
//			if(OldZoomLevel<15&&newLevel>14 && newLevel<17)//�Ŵ���ʾ����
//			{
//				var n=Nets.netCount;
//				switch(n)
//				{
//					case 0:
//						alert("��ǰ�����磬�����Ա���һ������!");
//						Map.setZoom(OldZoomLevel);
//						break;
//					case 1:
//						DeleteHeatMapIcon();
//						ShowSubNets();
//						OldZoomLevel = newLevel;
//						break;
//					default:
//						alert("��ѡ��һ������!");
//						Map.setZoom(OldZoomLevel);
//				}
//			}
//			else if(OldZoomLevel<17&&newLevel>=17)//�Ŵ���ʾ�ڵ�
//			{
//				var s=Nets.netList[NetIndex_].subnets.length;
//				switch(s)
//				{
//					case 0:
//						alert("��ǰ�������������Ա���һ������!");
//						Map.setZoom(OldZoomLevel);
//						break;
//					case 1:
//						DeleteHeatMapIcon();
//						ShowNodes();
//						OldZoomLevel = newLevel;
//						break;
//					default:
//						alert("��ѡ��һ������!");
//						Map.setZoom(OldZoomLevel);
//				}
//			}
//		}
//		else//��ͼ��С
//		{
//			if(OldZoomLevel>16&&newLevel<17)//��С����ʾ����
//			{
//				CurrentSubnet = -1;
//				DeleteCurrentIcon();
//				ShowSubNets(NetIndex_);
//				OldZoomLevel = newLevel;
//			}
//			else if(OldZoomLevel>14&&newLevel<15)//��С����ʾ����
//			{
//				CurrentNet = -1;
//				DeleteHeatMapIcon();
//				ShowNets();
//				OldZoomLevel = newLevel;
//			}
//		}
//	});
}