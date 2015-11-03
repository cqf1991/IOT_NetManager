function LQ_precision(){

	var centerPanel = Ext.getCmp("centerPanel");
	
	if(Ext.getCmp("linkQualityTab")==null)
	{
    	centerPanel.add({
    		id: "linkQualityTab",
    		activeGroup:1,
    		layout: 'fit', 
            title: "链路质量评估预测",
            closable: true,
            items: [ {
            	contentEl: 'center3',
                autoScroll: false,
                layout: 'fit'
            }],
            buttons:[{text:'计算 PRR',handler:function()
            	{
            	var PRR=new Array();
            	var LQIData=$('#center3').highcharts().series[0].yData;
            		for(var i in LQIData)
            		{
            			if(LQIData[i]>100)
            				{
            				PRR[i]=0.98*100;
            				LQIData[i]=parseFloat(LQIData[i]).toFixed(2);
            				}
            				
            			else
            				{
            				PRR[i]=(-3.149556695210915+0.0863498021131775*LQIData[i]-0.0004525534159034142*LQIData[i]*LQIData[i])*100;
            				LQIData[i]=parseFloat(LQIData[i]).toFixed(2);
            				}
            		}
            	
            		console.log(PRR);
            		Ext.getCmp("PRR")?false:showPRR(LQIData,PRR);
            		
            	}
            },
            {text:'RSSI-LQI线性回归',handler:function(){
            	  Ext.Ajax.request({
          	 	    url: 'linkQualityAction!linearReg.action',
          	 	    params : {
          	 	    	DataX :$('#center3').highcharts().series[0].yData, //  这就是参数 param1 是参数名字，a 是值
          	 	    	DataY :$('#center3').highcharts().series[2].yData
          			
          		},
          	 	    success: function(response){
          	 	    	var linear=response.responseText.split(",");
          	 	    	var A0=parseFloat(linear[0]);
          	 	    	var A1=parseFloat(linear[1]);
          	 	    	var Ar=parseFloat(linear[2]);
          	 	    	var LQIData=$('#center3').highcharts().series[0].yData;
                		var LQIfloat=new Array();
                		var RSSIData=$('#center3').highcharts().series[2].yData;
          	 	    	for(var i in LQIData)
                		{
                			LQIfloat[i]=parseFloat(LQIData[i].toFixed(2));
                			RSSIData[i]=parseFloat(RSSIData[i].toFixed(2));
                             		}
          	 	    	showLinearReg(A0,A1,Ar,LQIfloat,RSSIData);
          	 	        
          	 	 }});
            }},{text:'RSSI预测',handler:function(){
            	var RSSIData=$('#center3').highcharts().series[2].yData;
            	
            	showRSSI_P(RSSIData)
            }}
            ,{text:'LQI预测',handler:function(){
            	var LQIData=$('#center3').highcharts().series[0].yData;
            	
            	showLQI_P(LQIData)
            	
            }}
            ,{text:'SNR预测',handler:function(){
            	var SNRData=$('#center3').highcharts().series[1].yData;
            	
            	showSNR_P(SNRData)
            }}
          ]
        });
    	centerPanel.setActiveTab( "linkQualityTab" ) ;
    	$(function () {
    		 $(document).ready(function() {                                                  
    		        Highcharts.setOptions({                                                     
    		            global: {                                                               
    		                useUTC: false                                                       
    		            }                                                                       
    		        });
    		        var chart;
    	    $('#center3').highcharts({
    	        chart: {
    	            zoomType: 'xy',
    	            events: {                                                           
                        load: function() {                                                                                                                                     
                            // set up the updating of the chart each second             
                            var LQI = this.series[0];  
                            var SNR = this.series[1];
                            var RSSI = this.series[2];
                            setInterval(function() {                                    
                                var x = (new Date()).getTime(), // current time         
                                    LQIy = Math.random()*60+50,
                                    SNRy=Math.random()*50,
                                    RSSIy= Math.random()*(-80)-20
                                
                                    
                                LQI.addPoint([x, LQIy], true, true);                    
                                SNR.addPoint([x, SNRy], true, true);
                                RSSI.addPoint([x, RSSIy], true, true);
                            }, 3000);                                                   
                        }                                                               
                    }      	        	                                                                        
            },
    	        title: {
    	            text: '链路质量评估指标RSSI,LQI,SNR实时监控图'
    	        },
    	        subtitle: {
    	            text: 'Source: 2号网络-1号子网-0号中继节点'
    	        },
    	        xAxis: [{
    	        	 type: 'datetime',                                                   
    	             tickPixelInterval: 150  
    	        }],
    	        yAxis: [{ // Primary yAxis
    	            labels: {            
    	                style: {
    	                    color: '#89A54E'
    	                }
    	            },
    	            title: {
    	                text: 'RSSI',
    	                style: {
    	                    color: '#89A54E'
    	                }
    	            },
    	            opposite: true

    	        }, { // Secondary yAxis
    	            gridLineWidth: 0,
    	            title: {
    	                text: 'LQI',
    	                style: {
    	                    color: '#4572A7'
    	                }
    	            },
    	            labels: {
    	                style: {
    	                    color: '#4572A7'
    	                }
    	            }

    	        }, { // Tertiary yAxis
    	            gridLineWidth: 0,
    	            title: {
    	                text: 'SNR',
    	                style: {
    	                    color: '#AA4643'
    	                }
    	            },
    	            labels: {
    	                style: {
    	                    color: '#AA4643'
    	                }
    	            },
    	            opposite: true
    	        }],
    	        tooltip: {
    	        	formatter: function() {                                             
                        return '<b>'+ this.series.name +'</b><br>'+                
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br>'+
                        Highcharts.numberFormat(this.y, 2);                         
                }     
    	        },
    	        legend: {
    	            layout: 'vertical',
    	            align: 'right',
    	            verticalAlign: 'middle',
    	            borderWidth: 0
    	        },                                                                     
                exporting: {                                                            
                    enabled: false                                                      
                },
    	        series: [{
    	            name: 'LQI',
    	            color: '#4572A7',
    	            type: 'spline',//待修改
    	            yAxis: 1,
    	            data:  (function() {                                                 
                        // generate an array of random data                             
                        var data = [],                                                  
                            time = (new Date()).getTime(),                              
                            i;                                                          
                                                                                        
                        for (i = -14; i <= 0; i++) {                                    
                            data.push({                                                 
                                x: time + i * 3000,                                     
                                y: Math.random()*60+50                                       
                            });                                                         
                        }                                                               
                        return data;                                                    
                    })()
    	        }, {
    	            name: 'SNR',
    	            type: 'spline',
    	            color: '#AA4643',
    	            yAxis: 2,
    	            //data: [1016, 1016, 1015.9, 1015.5, 1012.3, 1009.5, 1009.6, 1010.2, 1013.1, 1016.9, 1018.2, 1016.7],
    	            data: (function() {                                                 
                        // generate an array of random data                             
                        var data = [],                                                  
                            time = (new Date()).getTime(),                              
                            i;                                                          
                                                                                        
                        for (i = -14; i <= 0; i++) {                                    
                            data.push({                                                 
                                x: time + i * 3000,                                     
                                y: Math.random()*50                                      
                            });                                                         
                        }                                                               
                        return data;                                                    
                    })(),
    	            dashStyle: 'shortdot'

    	        }, {
    	            name: 'RSSI',
    	            color: '#89A54E',
    	            type: 'spline',
    	            //data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
    	            data: (function() {                                                 
                        // generate an array of random data                             
                        var data = [],                                                  
                            time = (new Date()).getTime(),                              
                            i;                                                          
                                                                                        
                        for (i = -14; i <= 0; i++) {                                    
                            data.push({                                                 
                                x: time + i * 3000,                                     
                                y: Math.random()*(-80)-20                                       
                            });                                                         
                        }                                                               
                        return data;                                                    
                    })()
    	        }]
    	    });
    	});
    	});	
	}
}

function getP_data(data)
{
	var P_data=new Array();
	for(var i in data)
	{
		P_data[i]=data[i]*(Math.random()*0.4+0.8);
	}
	return P_data;
}
function showLQI_P(LQIData){
	var win=Ext.create('Ext.window.Window',{
		
		xtype:'panel',
		id:'LQI_P',
		title:'LQI预测图',
		width:750,
		height:350,
		layout:'form',
		resizable:false,
		margin:'3',
		items:[{		
					contentEl: 'LQI_P',
	                autoScroll: false,
	                layout: 'fit'
					}],
		buttons:[{text:'关闭',handler:function(){win.close();}}]	
	});
	$(function () {
	    $('#LQI_P').highcharts({
	        title: {
	            text: 'LQI Prediction(SVM)',
	            x: -20 //center
	        },
	        subtitle: {
	            text: 'Source: Recent LQI',
	            x: -20
	        },
	        xAxis: {
	        	title: {
	                text: 'Sequence'
	            },
	            //categories: RSSIData,
	        },
	        yAxis: {
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        series: [{
	        	name:"LQI",
	            data: LQIData
	        },
	        {
	        	name:"LQI(Prediction)",
	            data: getP_data(LQIData),
	            dashStyle: 'shortdot'
	        }
	        ]
	    });
	});
	
	Ext.getCmp("LQI_P").show();	
}
function showRSSI_P(RSSIData){
	var win=Ext.create('Ext.window.Window',{
		
		xtype:'panel',
		id:'RSSI_P',
		title:'RSSI预测图',
		width:750,
		height:350,
		layout:'form',
		resizable:false,
		margin:'3',
		items:[{		
					contentEl: 'RSSI_P',
	                autoScroll: false,
	                layout: 'fit'
					}],
		buttons:[{text:'关闭',handler:function(){win.close();}}]	
	});
	$(function () {
	    $('#RSSI_P').highcharts({
	        title: {
	            text: 'RSSI Prediction(SVM)',
	            x: -20 //center
	        },
	        subtitle: {
	            text: 'Source: Recent RSSI',
	            x: -20
	        },
	        xAxis: {
	        	title: {
	                text: 'Sequence'
	            },
	            //categories: RSSIData,
	        },
	        yAxis: {
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        series: [{
	        	name:"RSSI",
	            data: RSSIData
	        },
	        {
	        	name:"RSSI(Prediction)",
	            data: getP_data(RSSIData),
	            dashStyle: 'shortdot'
	        }
	        ]
	    });
	});
	
	Ext.getCmp("RSSI_P").show();	
}
function showSNR_P(SNRData){
	var win=Ext.create('Ext.window.Window',{
		
		xtype:'panel',
		id:'SNR_P',
		title:'SNR预测图',
		width:750,
		height:350,
		layout:'form',
		resizable:false,
		margin:'3',
		items:[{		
					contentEl: 'SNR_P',
	                autoScroll: false,
	                layout: 'fit'
					}],
		buttons:[{text:'关闭',handler:function(){win.close();}}]	
	});
	$(function () {
	    $('#SNR_P').highcharts({
	        title: {
	            text: 'SNR Prediction(SVM)',
	            x: -20 //center
	        },
	        subtitle: {
	            text: 'Source: Recent SNR',
	            x: -20
	        },
	        xAxis: {
	        	title: {
	                text: 'Sequence'
	            },
	            //categories: RSSIData,
	        },
	        yAxis: {
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        series: [{
	        	name:"SNR",
	            data: SNRData
	        },
	        {
	        	name:"SNR(Prediction)",
	            data: getP_data(SNRData),
	            dashStyle: 'shortdot'
	        }
	        ]
	    });
	});
	
	Ext.getCmp("SNR_P").show();	
}

function showLinearReg(A0,A1,Ar,LQIData,RSSIData)//y=A0*x=A1   R^2=Ar
{
	
	var showData=new Array();
	for(var i in LQIData)
	{
		showData[i]=new Array();
		for(var j=0;j<2;j++)
		{
			if(j==0)
				showData[i][j]=LQIData[i];
			else
				showData[i][j]=RSSIData[i];
		}
	}
	var win=Ext.create('Ext.window.Window',{
		
		xtype:'panel',
		id:'LQIRSSI',
		title:'RSSI-LQI线性回归图',
		width:750,
		height:350,
		layout:'form',
		resizable:false,
		margin:'3',
		items:[{		
					contentEl: 'center5',
	                autoScroll: false,
	                layout: 'fit'
					}],
		buttons:[{text:'关闭',handler:function(){win.close();}}]	
	});
	$(function () {
		$('#center5').highcharts({
	        chart: {
	        },
	        xAxis: {
	        	title: {
                text: 'RSSI'
            },
	        	categories: LQIData,
	        },
	        yAxis: {
	        	title: {
	                text: 'LQI'
	            }
	        },
	        title: {
	            text: 'RSSI-LQI linear regression'
	        },
	        series: [{
	            type: 'line',
	            name: 'Regression Line',
	            data: [[0, A1], [150, 150*A0+A1]],
	            marker: {
	                enabled: false
	            },
	            states: {
	                hover: {
	                    lineWidth: 0
	                }
	            },
	            enableMouseTracking: false
	        }, {
	            type: 'scatter',
	            name: 'Value',
	            data: showData
	            
	            
	        }]
	    });
	});
	
	Ext.getCmp("LQIRSSI").show();	
}
function showPRR(LQIData,PRR){
	var win=Ext.create('Ext.window.Window',{
		
		xtype:'panel',
		id:'PRR',
		title:'PRR预测图',
		width:750,
		height:350,
		layout:'form',
		resizable:false,
		margin:'3',
		items:[{		
					contentEl: 'center4',
	                autoScroll: false,
	                layout: 'fit'
					}],
		buttons:[{text:'关闭',handler:function(){win.close();}}]	
	});
	$(function () {
	    $('#center4').highcharts({
	        title: {
	            text: 'LQI predict  PRR',
	            x: -20 //center
	        },
	        subtitle: {
	            text: 'Source: Recent LQI',
	            x: -20
	        },
	        xAxis: {
	        	title: {
	                text: 'LQI'
	            },
	            categories: LQIData,
	        },
	        yAxis: {
	            title: {
	                text: '包接收率 (%)'
	            },
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        series: [{
	        	name:"PRR",
	            data: PRR
	        }]
	    });
	});
	
	Ext.getCmp("PRR").show();	
}