
//private fields;
/*var columnModal=new Ext.grid.ColumnModel({
	column:this.columns
});*/

var pagingTB={
	xtype:'paging',
	store:userstore,
	pageSize:5,
	displayInfo:true,
	displayMsg:'��¼����{0}��-��{1}������{2}��',
	emptyMsg:'û������',
	beforePageText:'��',
	afterPageText:'ҳ����{0}ҳ',
	firstText:'��һҳ',
	lastText:'��ĩҳ',
	nextText:'��һҳ',
	prevText:'��һҳ'
	//pagingSize:this.pageSize
}

var searchTB={
	xtype:'toolbar',
	padding:2,
	items:[
		{xtype:'button',text:'�����û�',handler:function(){creatForm();}},
		{xtype:'spacer',width:20},
		{xtype:textfield,emptyText:'�������û���...',width:220,
		id:'queryText'},
		{xtype:'spacer',width:5},
		{xtype:'button',text:'��ѯ',hander:this.queryStore,
		scope:this}
	]
};

//���Խű�
/*var ratingRenderer=function(value,metaData,record,rowIndex,colIndex,store){
	var starNum=value;
	var result='';
	for(var i=0;i<starNum;i++){
		result +='<span class="star-span"> &nbsp;</span>';
	}
	return result;
}
*/
var cbSM=new Ext.grid.CheckboxSelectionModel({
	singleSelect:false
});

var columns= new Ext.grid.ColumnModel({
	columns:[
	cbSM,
	{name:'id', dataIndex:'id',	header:'���',type:'int',width:25},
	{name:'username',dataIndex:'username',header:'�û�',type:'int',width:75},
	{name:'pass',dataIndex:'pass',header:'����',type:'int',width:75},
	{name:'identity',dataIndex:'identity',header:'���',type:'string',width:75}
	],
	defaults:{
		resizable:false
	}
}) ;
var LJWgrid= new Ext.grid.GridPanel({
	title:'�û�����',
	layout:'fit',
	store:userstore,
	setAutoScroll:true,
	viewConfig:{
		forceFit:true
	},
	colModel:columns,
	tbar:searchTB,
	bbar:pagingTB
});
LJWgrid.render('container');


