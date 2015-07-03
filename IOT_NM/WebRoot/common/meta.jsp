<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta name="author" content="尔演&Eryan" />
<link rel="shortcut icon" href="${ctx}/img/favicon.ico" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/default.css" />

<link rel="stylesheet" type="text/css" href="${ctx}/css/form_style.css" />

<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery/easyui-1.3.3/portal/portal.css">


<!-- 引入jQuery -->
<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/jquery/jquery-migrate-1.2.1.min.js" charset="utf-8"></script>
<!-- 引入bootstrap -->
<%-- <link href="${ctx}/js/bootstrap-2.3.1/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="${ctx}/js/bootstrap-2.3.1/js/bootstrap.min.js" charset="utf-8"></script>
 --%>
<%-- jQuery Cookie插件 --%>
<script type="text/javascript" src="${ctx}/js/jquery/jquery.cookie.js" charset="utf-8"></script>
<%
	String easyuiThemeName = "default";
	Cookie cookies[] = request.getCookies();
	if (cookies != null && cookies.length > 0) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("easyuiThemeName")) {
				easyuiThemeName = cookie.getValue();
				break;
			}
		}
	}
%>
<link id="easyuiTheme" rel="stylesheet" type="text/css" href="${ctx}/js/jquery/easyui-1.3.3/themes/<%=easyuiThemeName%>/easyui.css" />
<link id="easyuiTheme" rel="stylesheet" type="text/css" href="${ctx}/js/jquery/easyui-1.3.3/themes/<%=easyuiThemeName%>/my97.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery/easyui-1.3.3/themes/icon.css" />
<script type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/jquery/easyui-1.3.3/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/jquery/easyui-1.3.3/jquery.my97.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/jquery/easyui-1.3.3/portal/jquery.portal.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/jquery/easyui-1.3.3/easyui-lang-zh_CN.js" charset="utf-8"></script>
<!-- datagrid-detailview的引用 -->
<script type="text/javascript" src="${ctx}/js/jquery/easyui-1.3.3/datagridview/datagrid-detailview.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/xheditor-1.2.1/xheditor-1.2.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/xheditor-1.2.1/xheditor_lang/zh-cn.js" charset="utf-8"></script>

<script type="text/javascript" src="${ctx}/js/common.js" charset="utf-8"></script>
<%-- <script type="text/javascript" src="${ctx}/js/prohibit.js" charset="utf-8"></script> --%>
<script type="text/javascript" src="${ctx}/js/validatebox-extend.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/validatebox-ajax.js" charset="utf-8"></script>