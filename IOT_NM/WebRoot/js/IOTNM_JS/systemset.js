
//private fields;
/*var columnModal=new Ext.grid.ColumnModel({
	column:this.columns
});*/

var pagingTB={
	xtype:'paging',
	store:userstore,
	pageSize:5,
	displayInfo:true,
	displayMsg:'记录：第{0}条-第{1}条，共{2}条',
	emptyMsg:'没有数据',
	beforePageText:'第',
	afterPageText:'页，共{0}页',
	firstText:'第一页',
	lastText:'最末页',
	nextText:'下一页',
	prevText:'上一页'
	//pagingSize:this.pageSize
}

var searchTB={
	xtype:'toolbar',
	padding:2,
	items:[
		{xtype:'button',text:'增加用户',handler:function(){creatForm();}},
		{xtype:'spacer',width:20},
		{xtype:textfield,emptyText:'请输入用户名...',width:220,
		id:'queryText'},
		{xtype:'spacer',width:5},
		{xtype:'button',text:'查询',hander:this.queryStore,
		scope:this}
	]
};

//测试脚本
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
	{name:'id', dataIndex:'id',	header:'序号',type:'int',width:25},
	{name:'username',dataIndex:'username',header:'用户',type:'int',width:75},
	{name:'pass',dataIndex:'pass',header:'密码',type:'int',width:75},
	{name:'identity',dataIndex:'identity',header:'身份',type:'string',width:75}
	],
	defaults:{
		resizable:false
	}
}) ;
var LJWgrid= new Ext.grid.GridPanel({
	title:'用户管理',
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


