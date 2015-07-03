creatForm=function(){
	
var simple = Ext.widget({
        xtype: 'form',
        layout: 'form',
        collapsible: false,
        id: 'simpleForm',
        url: 'save-form.php',
        frame: false,
        title: '用户登陆',
        bodyPadding: '5 5 0',
        width: 350,  
        defaultType: 'textfield',
        fieldDefaults: {
            //msgTarget: 'side',
            //labelWidth: 75
        	labelWidth: 80,
    		labelSeparator: "：",
    		anchor: "0",
    		allowBlank: false
        }, 
        items: [{
            fieldLabel: '用 户 名',
            name: 'UserName',
            emptyText: '账 号...',
            tooltip: 'Enter your ID'
        },{
            fieldLabel: '密        码',
            name: 'Password',
            emptyText: '密 码 ...',
            tooltip: 'Enter your password'
        },{
        	xtype:"combo",
			fieldLabel : "类 别",
			name:'Identity',
			id:'XXXZ' ,
			anchor:"100%",
    		queryMode: 'local',  
    		typeAhead: true , 
    		value:'1',
    		forceSelection: true,
    		triggerAction:"all", 
    		store:Ext.create('Ext.data.Store',
    			{
    			fields:['value','name'],
    		    data:
    			 [
    			    {'value':'1','name':'管理员'},
    				{'value':'2','name':'用户'},

    			 ]
    			}),
    			displayField:'name',
    			valueField:'value'
    							
		}
        
        /*{
        	fieldLabel: "类别", 
       		name: "Identity", 
       		xtype: 'combo',
            //typeAhead: true,
            editable:false,
            triggerAction : 'all',
            selectOnFocus:true,
            forceSelection: true,
            mode: 'queryModel',
            //store: dsStore,
            displayField: 'xxdmkeepType',
            valueField: 'xxdmid',
    	}*/
        /*{
            xtype: 'timefield',
            fieldLabel: '类别',
            name: 'identity',
            minValue: '8:00am',
            maxValue: '6:00pm',
            tooltip: 'Enter a identity',
            plugins: {
                ptype: 'datatip',
                tpl: 'Select time {date:date("G:i")}'
            }
		}*/
			],

        buttons: [{
            text: '登 陆',
            handler: function() {
                this.up('form').getForm().isValid();
            }
        },{
            text: '取 消',
            handler: function() {
                this.up('form').getForm().reset();
            }
        }]
    });
      var win = Ext.create('Ext.Window', {
        title: '网关用户登陆界面',
        height: 230,
        width: 330,
        modal:true,
        frame:true,
        closable:true,
        resizable: false,
        //closeAction: 'hide',
    	//hideMode: 'offsets',
        layout: 'fit',
        items: simple
    }).show();
}