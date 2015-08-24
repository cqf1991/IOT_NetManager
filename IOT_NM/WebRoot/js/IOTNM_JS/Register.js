var net=new Array();
var subnet=new Array();
var node=new Array();
var sensor=new Array();
var subCombo=new Array();
var tip="带<font color=red>*</font>为必填项";
var star="<font color=red>*</font>";
var langitude=/^(-?((180)|(((1[0-7]\d)|(\d{1,2}))(\.\d+)?)))$/g;
var latitude=/^(-?((90)|((([0-8]\d)|(\d{1}))(\.\d+)?)))$/g;
function ZhuCe()//注册功能
{    
        var centerPanel = Ext.getCmp("centerPanel");  //Ext.ComponentManager.get方法的简写。 通过id查找现有的Component
            	if(Ext.getCmp("subscribeTab")==null)
            	{
	            	centerPanel.add({	
	            	id:'subscribeTab',
	            
					title:'注册',
					animCollapse:true,
					closable:true,
					
					 layout: 'fit',   	
					 listeners:{'beforeclose':function(){
	            		var w = Ext.getCmp('buttomGrid');
	            		//var g=Ext.getCmp('eastPanel');
	            		if(w!=null)
		            	w.expand();
	            		//if(g!=null)
	            		//g.expand();
                      }} ,
	            	frame:true, 
                      items: [{        	
                    	  xtype: 'grouptabpanel',
                    	  //默认值为0，但0组因为bug问题被隐藏 
                    	  activeGroup:1,
                    	  id:'fds',
                    	  items: [{
                    		// hidden:true,
                    		  items:[{ }  
                    		  ]}, 
                  {	
                      id:'wlzc1', 
                     items: {                   
                   
                    title: '网络注册',
                    style: 'padding: 10px',
                    id:'wlzc',
                    border: false,
                    autoScroll:true,
                    items:[{
                    	xtype:'form',
                    	id:'netReg',
                    	title:'网络注册',
                    	
                    	bodyPadding:10,
                    	html:tip,
                    	autoScroll:true,
                    	
                  		 fieldDefaults:{
                    	flex:1,
                    	
                    	labelWidth: 60,
                    },
                    	defaults:{
                    	style:"margin-left:10px;margin-bottom:8px;"
                    },  
                    	items:[
                    	 {
                    		 xtype:'container', anchor:'80%',layout:'hbox',defaults:{padding:8},items:[
                    	{xtype:'textfield',fieldLabel:'网络名称',anchor:'80%',name:'wlmc',allowBlank:false,afterLabelTextTpl:star,vtype:'alphanum'},
                    	{xtype:'textfield',name:'ssdw',anchor:'80%',fieldLabel:'所属单位'}
                    	 ]},
                    	 {
                    		 xtype:'container', anchor:'80%',layout:'hbox',defaults:{padding:8},items:[
                    	{xtype:'textfield',fieldLabel:'网络描述',name:'wlms'},{xtype:'textfield',name:'dd',fieldLabel:'地点'}
                    	 ]},
                    	 {
                    		 xtype:'container', anchor:'80%',layout:'hbox',defaults:{padding:8},items:[
                    	{xtype:'textfield',fieldLabel:'维护单位',name:'whdw',},{xtype:'textfield',name:'lxr',fieldLabel:'联系人',minLengthText:'人名不能低于2个字',minLength:2}
                    	 ]},
                    	{xtype:'textfield',name:'lxdh',fieldLabel:'联系电话',anchor:'40.5%',padding:8,vtype:'phoneNumber'}
                    	 ,
                    	 {
                    		 xtype:'fieldset',title:'覆盖范围经纬度',anchor:'80%',items:[
                    	 {
                    		 xtype:'container',layout:'hbox',defaults:{padding:8},items:[
                    	{xtype:'textfield',id:'fgzsjd',fieldLabel:'覆盖范围左上点经度',name:'fgfwzsjd',regexText:'请输入正确的经度格式'}
                    	,{xtype:'textfield',id:'fgzxjd',fieldLabel:'覆盖范围左下点经度',name:'fgfwzxjd',regexText:'请输入正确的纬度格式'}
                    	 ]},
                    	 {
                    		 xtype:'container', layout:'hbox',defaults:{padding:8},items:[
                    	{xtype:'textfield',id:'fgysjd',fieldLabel:'覆盖范围右上点纬度',name:'fgfwysjd',regexText:'请输入正确的经度格式'}
                    	,{xtype:'textfield',id:'fgyxjd',fieldLabel:'覆盖范围右下点纬度',name:'fgfwyxjd',regexText:'请输入正确的纬度格式'}
                    	 ]} 
                    	 ]},{xtype:'textarea',name:'bz',fieldLabel:'备注',minWidth:280,anchor:'80%'}
                    	 
                    	],
                    	buttons:[{text:'提交',handler:function(field){
                    		var form =Ext.getCmp('netReg').form;
                    		if(form.isValid()){
                    			form.submit({
                    				url:'regAction!netReg.action',	
                    				method:'post',
                    				params:{
                    				RegType:'net',
                    				
                    			},
                    				success:function(response){
                    				console.log(action);
                    				alert("网络注册成功"+response);
                    			},
                    				failure:function(form,action){
                    				console.log(action);
                    				
                    				},
                    			});
                    			
                    		}
                    		
                    		}
                    	},
                    	         {text:'重置',handler:function(){Ext.getCmp('netReg').getForm().reset();}}]
                    }]       
                }
                },
            {        
                items: {
                    title: '子网注册',
                    style: 'padding: 10px',
                    border: false,
                    id:'zwzc',
                  
                    autoScroll:true,
                    items:[{
                    	xtype:'form',
                    	//layout:'hbox',
                    	id:'subnetReg',
                    	title:'子网注册',
                    	  html:tip,
                    	//defaultMargins: {top: 0, right: 5, bottom: 0, left: 0},
                    	bodyPadding:10,
                    	autoScroll:true,
                   
                  		defaultType:'textfield',
                  	    fieldDefaults:{
                    	flex:1,
                    	labelWidth: 80,
                    },
                    	defaults:{
                    	expandeds: false,
                    
                    	style:"margin-left:10px;"
                    },       
                    	items:[
                          	 {
                        	 xtype:'container',layout:'hbox',anchor:'80%',defaults:{padding:8},items:[
                        	{
                        	xtype:'combobox',
                        	fieldLabel:'网络名称',
                        	allowBlank:false,
                        	id:'NetOfSubReg',
                        	name:'wlmc',
                        	emptyText:'请选择网络',
                        	store:Combostore(),
                        	},{xtype:'textfield',name:'zwbh',allowBlank:false,fieldLabel:'子网编号',regex:/^[0-9]{1,3}$/,regexText:'输入0~3位数字',afterLabelTextTpl:star}
                        	 ]},
                        	 {
                        		 xtype:'container', anchor:'80%',layout:'hbox',defaults:{padding:8},items:[
                       	{xtype:'textfield',fieldLabel:'子网名称',name:'zwmc',allowBlank:false,afterLabelTextTpl:star,vtype:'alphanum'}// 子网名称
                        	,{xtype:'textfield',name:'zwms',fieldLabel:'子网描述',beforeLabelText:[star]}
                        	 ]},                        	 
                        	 {
                        		 xtype:'container', anchor:'80%',layout:'hbox',defaults:{padding:8},items:[
                        	{xtype:'textfield',name:'zwdz',fieldLabel:'子网地址',allowBlank:false,name:'lxdh',afterLabelTextTpl:star,vtype:'IPaddress'}
                        	,{xtype:'textfield',name:'gzxd',fieldLabel:'工作信道',regex:/^[0-9]{1,3}$/,regexText:'输入0~3位数字'}
                        	 ]},   
                        	 {layout:'hbox',xtype:'fieldcontainer',anchor:'80%',items:[
                          	 {layout:'hbox',xtype:'fieldcontainer',minWidth:230,defaults:{padding:8},
                          		 items:[{xtype: 'textfield',fieldLabel:'工作周期',vtype:'number'},{xtype:'displayfield',name:'gzzq',value:'(单位:秒)',maxWidth:60}]
                         	  },
                         	  {layout:'hbox',xtype:'fieldcontainer',anchor:'80%',defaults:{padding:8},items:[
                         	  {fieldLabel:'接入方式',xtype:'combobox',name:'jrfs', mode:'local',store:jrfs,value:['TCP/IP']},{xtype:'button',text:'添加',handler:NodeAdd}]
                         	  },
                         	 ]},
                        	 {
                        		 xtype:'fieldset',title:'覆盖范围经纬度',anchor:'80%',items:[
                        	 {
                        		 xtype:'container',layout:'hbox',defaults:{padding:8},items:[
                        	{xtype:'textfield',fieldLabel:'覆盖范围左上点经度',name:'fgfwzsjd',regexText:'请输入正确的经度格式'}
                        	,{xtype:'textfield',fieldLabel:'覆盖范围左下点经度',name:'fgfwzxwd',regexText:'请输入正确的经度格式'}
                        	 ]},
                        	 {
                        		 xtype:'container', layout:'hbox',defaults:{padding:8},items:[
                        	{xtype:'textfield',fieldLabel:'覆盖范围右上点纬度',name:'fgfwysjd',regexText:'请输入正确的经度格式'}
                        	,{xtype:'textfield',fieldLabel:'覆盖范围右下点纬度',name:'fgfwyxwd',regexText:'请输入正确的经度格式'}
                        	 ]} 
                        	 ]
                        	 },{xtype:'textarea',name:'bz',fieldLabel:'备注',minWidth:280,anchor:'80%'}],
                         	buttons:[{text:'提交',handler:function(field){
                        		var form =Ext.getCmp('subnetReg').form;
                        		if(form.isValid()){
                        			form.submit({
                        				url:'regAction!subNetReg.action',	
                        				method:'post',
                        				params:{
                        				RegType:'subnet',
                        				
                        			},
                        				success:function(form,action){
                        				console.log(action);
                        			},
                        				failure:function(form,action){
                        				console.log(action);
                        				
                        				},
                        			});
                        			
                        		}
                        		
                        		}
                        	},
                        	         {text:'重置',handler:function(){Ext.getCmp('subnetReg').getForm().reset();}}]
                    }]       
                }
                }
            ,{ 
                items: {
                title: '节点注册',    
                tabTip: 'Configuration tabtip',
                style: 'padding: 10px',
                border: false,
                autoScroll:true,
               
                items:[{
                	xtype:'form',
                	id:'nodeReg',
                	title:'节点注册',
                	bodyPadding:10,
                	 html:tip,
                	autoScroll:true,
              		defaultType:'textfield',
              		fieldDefaults:{
                	flex:1,
                	labelWidth: 80,
                },
                	defaults:{
                	expanded: false,
               	
                	style:"margin-left:10px;"
                },       
                	items:[
                        	 {
                            	 xtype:'container', anchor:'80%',layout:'hbox',defaults:{padding:8},items:[
                            	{xtype:'combobox',
                            	afterLabelTextTpl:star,
                            	allowBlank:false,
                            	fieldLabel:'网络名称:',
                            	id:'netStore',
                            	emptyText:'请选择网络',                      	
                            	store: Combostore(),
                            	name:'wlmc',                      
                            	listeners:{'select':function(combo,rec){ 
                            			var val=combo.getValue();
                            			var ss=Ext.getCmp('subnetStore');
                            			for(var index in net)
                            				if((net[index].NTID)==val){
                       					
                            					if(net[index].SUBNET!=null){
                            						subStoreV=[]; 
                            						subStoreD=[];
                            					
                            						var subarray=new Array(); 
                            						ss.setValue('请选择子网');
                            						for(var i in net[index].SUBNET){		                           							
                            							subStoreD.push(net[index].SUBNET[i].SBNTID+"号子网");
                            							subStoreV.push(net[index].SUBNET[i].SBNTID.toString());
                            							subarray[i]=[subStoreD[i],subStoreV[i]];
                            							
                            						}                        						
                            						
                            						ss.getStore().proxy.data=subarray;
                            					 
                            					}else{
                            						subarray=[];
                            						ss.store.loadData(subarray);
                            						ss.setValue('此网络无子网');
                            						
                            					}         				                          					
                            				}                     			
                            	}}
                            	},
                            	{
                            	afterLabelTextTpl:star,
                             	xtype:'combobox', 
                             	
                             	emptyText:'请选择子网',
                             	id:'subnetStore',
                             	name:'zwmc',
                             	mode:'local',
                             	allowBlank:false,
                             	valueField:'value',
                             	displayField:'key',
                            	fieldLabel:'子网名称:',
                            	store:  new Ext.data.SimpleStore({
                                    fields: ['key', 'value'],
                                    data : [],
                                }),                 	       	
                             	}
                            	 ]},
                            	 {
                            		 xtype:'container', anchor:'80%',layout:'hbox',defaults:{padding:8},items:[
                            	{xtype:'textfield',fieldLabel:'发射功率',name:'fsgl',vtype:'alphanum'}
                            	,{xtype:'textfield',fieldLabel:'生产厂商',name:'sccs'}
                            	 ]},                

                            	 {layout:'hbox',xtype:'fieldcontainer',anchor:'80%',items:[
                            	 {xtype:'textfield',fieldLabel:'规格型号和软件版本',name:'ggxhhrjbb'},                                                        
                             	  {layout:'hbox',xtype:'fieldcontainer',anchor:'80%',defaults:{padding:8},items:[
                             	  {fieldLabel:'节点类型',xtype:'combobox',name:'jdlx',afterLabelText:star,regex:/^[0-9]{1,3}$/,regexText:'输入0~3位数字',}
                             	  ,{xtype:'button',text:'添加',handler:NodeAdd,autoRender:true}]
                             	  },
                             	 ]},
                            	 {
                            		 xtype:'container',layout:'hbox',anchor:'80%',defaults:{padding:8},items:[
                            	{xtype:'textfield',fieldLabel:'节点描述信息',name:'jdmsxx',}
                            	,{xtype:'textfield',fieldLabel:'节点物理地址',name:'jdwldz',afterLabelText:star,vtype:'Mac'}
                            	 ]},
                            	 {
                            		 xtype:'container',layout:'hbox',anchor:'80%',defaults:{padding:8},items:[
                            	{xtype:'textfield',fieldLabel:'节点位置经度',name:'jdwzjd',regexText:'请输入正确的经度格式'}
                            	,{xtype:'textfield',fieldLabel:'节点位置纬度',name:'jdwzwd',regexText:'请输入正确的纬度格式'}
                            	 ]},
                            	 {
                            	 xtype:'container', layout:'hbox',anchor:'80%',defaults:{padding:8},items:[
                            	 
                            	 ]},{xtype:'textarea',padding:10,fieldLabel:'备注',name:'bb',minWidth:280,anchor:'80%'} 
                            	 ],
                              	buttons:[{text:'提交',handler:function(field){
                            		var form =Ext.getCmp('nodeReg').form;
                            		
                					
                            		if(form.isValid()){
                            			form.submit({
                            				url:'regAction!nodeReg.action',	
                            				method:'post',
                            				params:{
                            				RegType:'node',
                            				
                            			},
                            				success:function(form,action){
                            				
                            			},
                            				failure:function(form,action){
                            			
                            				
                            				},
                            			});
                            			
                            		}
                            		
                            		}
                            	},
                            	         {text:'重置',handler:function(){Ext.getCmp('nodeReg').getForm().reset();}}]
                }]       
            }
                    },{
                    	expanded: false,
                items: {
                        title: '传感器注册',
                        
                      
                        tabTip: 'Configuration tabtip',
                        style: 'padding: 10px',
                        border: false,
                        autoScroll:true,
                        items:[{
                        	xtype:'form',
                        	id:'sensorReg',
                        	title:'传感器注册',
                        	html:tip,
                        	bodyPadding:10,
                        	autoScroll:true,
                      		defaultType:'textfield',
                      		 fieldDefaults:{
                        	flex:1,
                        	labelWidth: 100,
                        },
                        	defaults:{
                        	expanded: false,	
                        	style:"margin-left:10px;"
                        },       
                        	items:[
                                 {
                                  xtype:'container', anchor:'80%',layout:'hbox',defaults:{padding:8},items:[
                                 {xtype:'textfield',anchor:'80%',fieldLabel:'传感器名称:',name:'cgqmc',afterLabelTextTpl:star,allowBlank:false},
                                 {xtype:'combobox',
                                 fieldLabel:'传感器类型:',
                                 anchor:'80%',
                                 afterLabelTextTpl:star,
                                 allowBlank:false,
                                 store:sensorName,
                                 value:'温度',
                                 autoSelect:true,
                                 mode:'local',
                                 id:'sensorName',
                                 name:'cgqlx'
                                	 }
                                   ]},
                                   {
                                     xtype:'container', anchor:'80%',layout:'hbox',defaults:{padding:8},items:[
                                    {xtype:'textfield',fieldLabel:'传感器描述信息',name:'cgqmsxx'}
                                    ,{xtype:'textfield',fieldLabel:'生产厂商',name:'sccs'}
                                    ]},                        	 
                                    {
                                     xtype:'container', anchor:'80%',layout:'hbox',defaults:{padding:8},items:[
                                    	{xtype:'textfield',fieldLabel:'转换公式参数列表',name:'zhgscslb',}
                                    	,{xtype:'textfield',fieldLabel:'规格型号与版本',name:'ggxhybb'}
                                    	 ]}, 
                                    	 {
                                    	 xtype:'container', anchor:'80%',layout:'hbox',defaults:{padding:8},items:[
                                    	{xtype:'textfield',fieldLabel:'计量单位',name:'jldw',}
                                    	,{xtype:'textfield',fieldLabel:'转换公式',name:'zhgs'}]
                                    	},
                                    	{
                                       	 xtype:'container', anchor:'80%',layout:'hbox',defaults:{padding:8},items:[
                                       	{xtype:'textfield',fieldLabel:'精度',name:'jd',}
                                       	,{xtype:'textfield',anchor:'20%',fieldLabel:'数据最大值',name:'sjzdz'}]
                                       	},
                                    	{
                                          xtype:'container', anchor:'20%',layout:'hbox',defaults:{padding:8},items:[
                                         {xtype:'textfield',fieldLabel:'数据最小值',name:'sjzxz',regex:/^[0-9]{1,3}$/,regexText:'输入0~3位数字',}]
                                        },
                             ],
                           	buttons:[{text:'提交',handler:function(field){
                        		var form =Ext.getCmp('sensorReg').form;
                        		if(form.isValid()){
                        			form.submit({
                        				url:'regAction!sensorReg.action',	
                        				method:'post',
                        				params:{
                        				RegType:'node',
                        				
                        			},
                        				success:function(form,action){
                        				console.log(action);
                        			},
                        				failure:function(form,action){
                        				console.log(action);
                        				
                        				},
                        			});
                        		}
                        		}
                        },{text:'重置',handler:function(){Ext.getCmp('nodeReg').getForm().reset();}}] 
                    }] 
                    }
        }]
                      }]
	                })
	                var w = Ext.getCmp('buttomGrid');
	            	//var g=Ext.getCmp('eastPanel');
	            	w.collapse(); 
	            	//g.collapse();
	            	 centerPanel.setActiveTab( "subscribeTab" ) ;	            	
	            	 Ext.getCmp("fds").setActiveTab("zwzc");
	            	 Ext.getCmp("fds").setActiveTab("wlzc");	            	 
            	}        	
        }

function NodeAdd(){
	Ext.Msg.prompt("添加节点","请输入节点类型名称：",function (btn, text) {  
        if (btn =="ok") {  
          
        }   
	});
}
function Combostore(){
	var subNetD=new Array();
	var subNetV=new Array();
	var array=new Array();
	for(var i in net){
		subNetD.push(net[i].NTID+"号网络");
		subNetV.push(net[i].NTID.toString());
		array[i]=[ subNetV[i],subNetD[i]];
	}	 
	return array;
}






 var jrfs=new Ext.data.ArrayStore({//子网注册接入方式
	 fields:['value','text'],
  	data:[['0','TCP/IP'],['1','UDP']],
  	
  });
 jrfs.load();
                                                                  
var sensorName=new Ext.data.ArrayStore({
		fields:['text'],
		data:[['温度'],['湿度']],
});
sensorName.load();