<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<title>WSN 网络管理系统</title>

<!-- GC -->

<!-- 引入ExtJS框架样式 -->
<link rel="stylesheet" type="text/css" href="js/ExtJS4.2.1/resources/css/ext-all.css">
<script type="text/javascript" src="js/ExtJS4.2.1/ext-all.js"></script>
<!-- 引用中文环境文件 -->
<script type="text/javascript" src="js/ExtJS4.2.1/locale/ext-lang-zh_CN.js"></script>


<style type="text/css">
    #center2{height:100%;width:100%;float:left;border-right:2px solid #bcbcbc;}
</style>
<script type="text/javascript" src="./js/IOTNM_JS/Commands.js" charset="GB2312"></script>
<script type="text/javascript" src="./js/IOTNM_JS/Register.js" charset="GB2312"></script>
<script type="text/javascript" src="./js/IOTNM_JS/BDMap.js" charset="GB2312"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xa6IlSTZtjDqZ8MKw3AU2lN5" ></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>
<script type="text/javascript" src="./js/IOTNM_JS/Hashtable.js"></script>
<script type="text/javascript" src="./js/IOTNM_JS/Vtype.js" charset="GB2312"></script><!--注册验证  -->

<script type="text/javascript" src="./js/IOTNM_JS/Map.js" charset="GB2312"></script>


<script type="text/javascript" src="./js/IOTNM_JS/include-ext.js"></script>

<script type='text/javascript' src='/IOT_NM/dwr/engine.js'></script>
<script type='text/javascript' src='/IOT_NM/dwr/interface/messagePush.js'></script>
<script type='text/javascript' src='/IOT_NM/dwr/util.js'></script>

<link rel="stylesheet" type="text/css" href="css/GroupTabPanel.css">


<script type="text/javascript">
 Ext.require([
            'Ext.Viewport',
            'Ext.tab.Panel',
            'Ext.ux.GroupTabPanel' 
        ]);

	var MM="[{ Net: '', SubNet: '', Node: '', NodeType: '', MsgType:'',MsgCount:'', MsgSequence:'', MsgBody:'', Route:'', Voltage:'', MsgTime:'', NetID:'', SubnetID:''}]";
	var MyMsg =Ext.JSON.decode(MM);
	var dataStore;
	var userdata;
	var memoryProxy;
	
	
	var myTitle = "网络名称：";
	var alerm = true;
	
	var navTreeData;
 	var treeJSONstr; //树形JSON字符串
    var item = "";
    var jsonString="";


	
	function onPageLoad(){
		
		initMap(Nets); 
		//messagePush.messageCP(4031);
	  	
	  }
//function notload(){
	  Ext.Ajax.request({
	 	    url: 'dirService.action',
	 	    success: function(response){
	 	        jsonString = Ext.JSON.decode(response.responseText);//[{ text: "detention", leaf: true },{ text: "homework", expanded: true, children: [{ text: "book report", leaf: true },{ text: "alegrbra", leaf: true}]},{ text: "buy lottery tickets", leaf: true }];
 							
	 	    	navStore2 = Ext.create('Ext.data.TreeStore', {
	 	  		  
	 	    		root: {
	 	    	        expanded: false,
	 	    	        children:jsonString
	 	    	    }
	 	    	    
	 	     });	 
	 	    	var tree123=Ext.create('Ext.tree.Panel', {
	 	    	    title: '网络结构',
	 	    	    id:'navTreeID',
	 	    	    store: navStore2,
	 	    	    rootVisible: false,
	 	    	    renderTo: Ext.getBody()
	 	    	});
	 	    	Ext.getCmp('west-panel').add(tree123);
	 	    	Ext.getCmp('west-panel').doLayout();
	 	    	
	 	       var treeitem = Ext.getCmp('navTreeID');
	 	       mapRequest();
	             //目录树单击事件
	           treeitem.on('itemclick',function(view, rcd, item, idx, event, eOpts) {
	                    console.log(item);
	                    NavTreeEvent(rcd,Nets);
	              });			 	    	
	 	    }
	 	});
function mapRequest(){
	  Ext.Ajax.request({
	 	    url: 'mapAction',
	 	    success: function(response){
	 	        Nets = Ext.JSON.decode(response.responseText).IOT_DIR.NETS[0];
	 	        dataChange(Nets);
	 	     }	 

	 	});
	}

		 //messagePush.messageCP(4031);//当getString从服务器取回数据后的回调函数,data为返回的值);//端口号为参数  待完善
		 //messagePush.getDIR();
//}
	
	 //推送信息
	 function testDWR(msg)
	 {		   
		 alert(msg);
	 }
	 function showMessage(autoMessage){
		 
		 
		 
		// document.getElementById("MsgDiv1").innerHTML += "</br>"+autoMessage+"----->"+i;]
		
		  	if(autoMessage != null)
			{  
		  		var store = Ext.getCmp("buttomGrid").getStore(); 
		  		MyMsg =Ext.JSON.decode(autoMessage);	
		    	var myData = autoMessage;
		    	myData=eval("("+myData+")");
		        var obj=myData[0];
		        var myGrid = Ext.getCmp("buttomGrid");
		        
				
				
		    	
		        if(obj.Net == "NCHU水质监测网")
		        {
			        netID = 1;
			    }
		        else if(obj.Net == "青山湖水质监测网")
		        {
			        netID = 2;
		        }
		        
		    	if(netID == CurrentNet)
		    	{
					 var count = store.getCount();  
					 if (count > 100) {  
					  store.remove(store.getAt(count - 1));  
					 }  
					 store.insert(0, MyMsg);
					 AddMsg(obj.NetID , obj.SubnetID ,obj.Route);
		    	}
 
				  
				  
				// Ext.getCmp("buttomGrid").setScrollTop(0);  
			}			
	}
	function showAnOtherMessage(autoMessage){
		 
		 //document.getElementById("MsgDiv2").innerHTML += "</br>"+autoMessage+"---"+i;
	  Nets = autoMessage;
	  for(i=0;i<Nets.netList.length;i++)
      {
        item+="{'text':'"+Nets.netList[i].netName+"','leaf':false,'expend':true,'children':[";
      //  alert(item);
        for(j=0;j<Nets.netList[i].subnets.length;j++)
        {
          item+="{'text':'"+Nets.netList[i].subnets[j].subnetName+"','leaf':false,'expend':true,'children':["       
          for(k=0;k<Nets.netList[i].subnets[j].nodes.length; k++)
          {
           if(k == Nets.netList[i].subnets[j].nodes.length-1)
           {
             item+="{'text':'"+Nets.netList[i].subnets[j].nodes[k].nodeID+"','leaf':true,'children':[]}"
           }
           else
           {
             item+="{'text':'"+Nets.netList[i].subnets[j].nodes[k].nodeID+"','leaf':true,'children':[]},";
           }
          }
          if(j == Nets.netList[i].subnets.length-1)
          {
            item+="]}";
          }
           else
           {
             item+="]}," ; 
           } 
        
        } 
        if(i == Nets.netList.length-1) {
         item+="]}";
        }
        else{
         item+="]},"
        }  
      } 
		treeJSONstr="["+item+"]" 
		//alert(treeJSONstr);
		navTreeData= Ext.JSON.decode(treeJSONstr);
		//console.info(treeJSONstr);
	  			
	}



    Ext.require(['*']);

    Ext.onReady(function() {
    	
        Ext.QuickTips.init();

        // NOTE: This is an example showing simple state management. During development,
        // it is generally best to disable state management as dynamically-generated ids
        // can change across page loads, leading to unpredictable results.  The developer
        // should ensure that stable state ids are set for stateful components in real apps.
        Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));


      Ext.define('User', {
    	     extend: 'Ext.data.Model',
            fields: [ 'Net','SubNet', 'Node', 'NodeType','MsgType','MsgCount','MsgSequence','MsgBody','Route','Voltage','MsgTime','NetID','SubnetID' ]
        });

   
			
        
 	 dataStore = Ext.create('Ext.data.Store', {
 		              model:'User',
 		             data:MyMsg,
				       autoLoad:true
		        });


         

        var dateMenu = Ext.create('Ext.menu.DatePicker', {
            handler: function(dp, date){
                Ext.example.msg('Date Selected', 'You choose {0}.', Ext.Date.format(date, 'M j, Y'));

            }
        });

        var colorMenu = Ext.create('Ext.menu.ColorPicker', {
            handler: function(cm, color){
                Ext.example.msg('Color Selected', '<span style="color:#' + color + ';">You choose {0}.</span>', color);
            }
        });
        var menu = Ext.create('Ext.menu.Menu', {
            id: 'mainMenu',
            items: [
                 {
                    text: '注册',
                    id: 'SBSCRB',
                    handler: onItemClick
               },{
                   text: '命令下发',
                   menu: {        // <-- submenu by nested config object
                       items: [
                           // stick any markup in a menu
                           //'<b class="menu-title">Choose a Theme</b>',
                           {
                               text: '节点探测',id:'jdtc',handler:function(){Ext.getCmp("NP")?false:nodeProbe();} ,
                           }, {
                               text: '节点采集参数设置',id:'jdcjcssz',handler:function(){Ext.getCmp("NPA")?false:nodeParamsAcquisition()},
                           }, {
                               text: '节点邻居探测',id:'jdljtc',handler:function(){Ext.getCmp("NNP")?false:nodeNeighborProbe()},
                           }, {
                               text: '节点链路测试',id:'jdllcs',handler:function(){Ext.getCmp("NLT")?false:nodeLinkTest()},
                           }, {
                               text: '节点功率设置',id:'jdglsz',handler:function(){Ext.getCmp("NPS")?false:nodePowSetting()},
                           }
                       ]
                   }
               },{
                   text: '警报',
                   checked: true,       // when checked has a boolean value, it is assumed to be a CheckItem
                   checkHandler: onItemCheck
               },{
                   text: '系统设置',
                   id: 'systemSet',
                   handler: onItemClick
               }
            ]
        });
        function onItemCheck(item, checked){
            alerm = checked;
        }
     function onItemClick(item)
        {
            if(item.id == "SBSCRB")
            {
            	ZhuCe();
            }
            else if(item.id == "systemSet")
            {
            	var centerPanel = Ext.getCmp("centerPanel");
            	if(Ext.getCmp("systemSetTab")==null)
            	{
	            	centerPanel.add({
	    	        	id: 'systemSetTab',
	    	            title: '系统设置',
	    	            xtype: 'tabpanel', // 
                   		tabPosition: 'left',
                   		deferredRender: false,
                		activeTab: 0,
                		defaults:{
                			bodyPadding: 10,
                			layout: 'anchor'
            			},
                   		items:[{
                    		title: '用户管理',
                    		defaultType: 'textfield',
                			defaults: {
                    			anchor: '100%'
                			}
                			
                		}]
	                });
	            	centerPanel.setActiveTab("systemSetTab");
            	}
            	else
            	{
            		centerPanel.setActiveTab("systemSetTab");
            	}
            }
        }
        
        
      
     
        
        var viewport = Ext.create('Ext.Viewport', {
            id: 'border-example',
            layout: 'border',
            items: [
            // create instance immediately
            {
                xtype: 'toolbar',
                region: 'north',
       	    height: 70, // give north and south regions a heigh/t
                style: "background-image:url('img/bg.jpg');background-size:cover;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='img/bg.jpg',sizingMethod='scale');font-weight:bold;font-style:italic;",

                              items: [
             	 {xtype:'label',
                 text:'WSN',	
                 style:'font-size:38px;color:#dde7f0;margin-left:30px;' 
                 },
                 {xtype:'label',
                 text:'网络管理系统',	
                 style:'font-size:38px;margin-left:5px;color:#dde7f0;font-family："幼圆";,font-style:normal;' 
                 }]},
                  {  
              	xtype:'toolbar',
              	region:'north',
                height:'30px',
                style:'background:#E6E6E6',
                items:[
				{                                      											      
                	xtype:"label",
                	text:'用户:'
                 },
                 '-',
                 {
                 xtype:"label",
                 text:'身份:'
           		
                 },
                 '-',
                 {
                 xtype:"label",
                 text:'日期:'
                 
                 } 
                 ,
                 {
                 xtype:"button",
                 text:'注销',
                 renderTo: Ext.getBody(),
                 handler:function() {         	
				if(confirm("确定要注销？")){ return window.location.href="denglu.jsp";}
				} 
                 }
                 ,'->',{
                  text:'菜单',
                 menu:menu
               
                 } ]},
                 {
                // lazily created panel (xtype:'panel' is default)
                xtype: 'grid',
                id:'buttomGrid',
                region: 'south',
                split: true,
                height: 280,
                minSize: 280,
                maxSize: 600,
                collapsible: true,
                collapsed: false,
                title: myTitle,
                margins: '0 0 0 0',
                layout: 'fit',
                store: dataStore,
                forceFit: true,
                columns: [
              	        {
              	            text: '网络',
              	            sortable: false,
              	            //hideable: false,
              	            hidden: true,
              	            dataIndex: 'Net'
              	        },
              	        {
              	            text: '子网',
              	            sortable: false,
              	            hideable: false,
              	            dataIndex: 'SubNet'
              	        },
              	        {
              	            text: '节点',
              	            sortable: false,
              	            hideable: false,
              	            dataIndex: 'Node'
              	        },
              	        {
              	            text: '节点类型',
              	            sortable: false,
              	            dataIndex: 'NodeType'
              	        },
              	        {
              	            text: '消息类型',
              	            sortable: false,
              	            dataIndex: 'MsgType'
              	        },
              	        {
              	            text: '消息总数',
              	            sortable: false,
              	            dataIndex: 'MsgCount'
              	        },
              	        {
              	            text: '消息序列',
              	            sortable: false,
              	            dataIndex: 'MsgSequence'
              	        },
              	        {
              	            text: '消息体',
              	            sortable: false,
              	            hidden: true,
              	            dataIndex: 'MsgBody'
              	        },
              	        {
              	            text: '路由',
              	            sortable: false,
              	            dataIndex: 'Route'
              	        },
              	        {
              	            text: '电压值',
              	            sortable: true,
              	            dataIndex: 'Voltage'
              	        },
              	        {
              	            text: '消息处理时间',
              	            sortable: true,
              	            hideable: false,
              	            dataIndex: 'MsgTime'
              	        },
              	      {
              	            text: '网络ID',
              	            hidden: true,
              	            dataIndex: 'NetID'
              	        },
              	      {
              	            text: '子网ID',
              	            hidden: true,
              	            dataIndex: 'SubNetID'
              	        }
              	    ],
              	    viewConfig:{getRowClass : function(record,rowIndex,rowParams,store){ 
                        if(alerm && record.data.Voltage=="2.5V"){
                            //alert(""+record.data.Node+"号节点电压值过低！\n电压值为："+record.data.Voltage);
                            Ext.Msg.alert('低电量警告！', ""+record.data.Node+"号节点电压值过低！\n电压值为："+record.data.Voltage);
                            return '.x-grid3-row-alt';
                        }                        }
        			}
            }, {
                xtype: 'tabpanel',
                region: 'east',
                title: '信息栏',
                dockedItems: [{
                    dock: 'top',
                    xtype: 'toolbar',
                    items: [ '->', {
                       xtype: 'button',
                       text: '保存修改',
                       tooltip: 'Test Button'
                    }]
                }],
                animCollapse: true,
                collapsible: true,
                split: true,
                width: 225, // give east and west regions a width
                minSize: 175,
                maxSize: 400,
                margins: '0 5 0 0',
                activeTab: 1,
                tabPosition: 'bottom',
                items: [
						Ext.create('Ext.grid.PropertyGrid', {
						    id:'Rigthgrid',
						   title: 'Property Grid',
						   source: {
						       
						   }
						})]
            }, {
                region: 'west',
                stateId: 'navigation-panel',
                id: 'west-panel', 
                title: '导航',
                split: true,
                width: 200,
                minWidth: 175,
                maxWidth: 400,
                collapsible: true,
                animCollapse: true,
                margins: '0 0 0 5',
                layout: 'accordion'
                
            },
            // in this instance the TabPanel is not wrapped by another panel
            // since no title is needed, this Panel is added directly
            // as a Container
            Ext.create('Ext.tab.Panel', {
                region: 'center', // a center region is ALWAYS required for border layout
                id: 'centerPanel',
                deferredRender: false,
                activeTab: 0,     // first tab initially active
                autoDestroy:true,
                items: [ {
                    contentEl: 'center2',
                    title: '网络实景',
                    autoScroll: false,
                    layout: 'fit'
                }]
            })]
        });
  
	
	
        
});

			

	
  
</script>
</head>



<body onload="onPageLoad();dwr.engine.setActiveReverseAjax(true);dwr.engine.setNotifyServerOnPageUnload(true);">
    <!-- use class="x-hide-display" to prevent a brief flicker of the content -->
    <div id="west" class="x-hide-display">
        <p>Hi. I'm the west panel.</p>
    </div>
    <div id="center1" class="x-hide-display">
   		 <iframe src="Reg.jsp" width="100%" height="100%"> </iframe>
    </div>
    <%--
    <div id="center5" class="x-hide-display">
   		 <script type="text/javascript">
   		     //var netId = Nets[currentNet].netID;
   		     //alert(netId);
   		     document.write("<iframe src=\"Reg.jsp\" width=\"100%\" height=\"100%\"> </iframe>");
   		 </script>
    </div>
    --%>
    <div id="center2" class="x-hide-display">
    </div>
    
    <div id="props-panel" class="x-hide-display" style="width:200px;height:200px;overflow:hidden;">
    </div>
    
</body>
</html>