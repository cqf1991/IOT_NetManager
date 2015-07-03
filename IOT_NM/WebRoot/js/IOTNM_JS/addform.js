creatForm=function(){
	
var simple = Ext.widget({
        xtype: 'form',
        layout: 'form',
        collapsible: false,
        id: 'simpleForm',
        url: 'save-form.php',
        frame: false,
        title: '�û���½',
        bodyPadding: '5 5 0',
        width: 350,  
        defaultType: 'textfield',
        fieldDefaults: {
            //msgTarget: 'side',
            //labelWidth: 75
        	labelWidth: 80,
    		labelSeparator: "��",
    		anchor: "0",
    		allowBlank: false
        }, 
        items: [{
            fieldLabel: '�� �� ��',
            name: 'UserName',
            emptyText: '�� ��...',
            tooltip: 'Enter your ID'
        },{
            fieldLabel: '��        ��',
            name: 'Password',
            emptyText: '�� �� ...',
            tooltip: 'Enter your password'
        },{
        	xtype:"combo",
			fieldLabel : "�� ��",
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
    			    {'value':'1','name':'����Ա'},
    				{'value':'2','name':'�û�'},

    			 ]
    			}),
    			displayField:'name',
    			valueField:'value'
    							
		}
        
        /*{
        	fieldLabel: "���", 
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
            fieldLabel: '���',
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
            text: '�� ½',
            handler: function() {
                this.up('form').getForm().isValid();
            }
        },{
            text: 'ȡ ��',
            handler: function() {
                this.up('form').getForm().reset();
            }
        }]
    });
      var win = Ext.create('Ext.Window', {
        title: '�����û���½����',
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