<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>WSN Login</title>
 	<meta http-equiv="pragma" content="no-cache">
 	<meta http-equiv="cache-control" content="no-cache">
 	<meta http-equiv="expires" content="0">    
 	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
 	<meta http-equiv="description" content="This is my page">
 	
 	
 	<!--- CSS --->
<link href="css/login.css" rel='stylesheet' type='text/css' />
	
  	</head>
<body>
	<div class="main">
		
		<div class="login">
		
			<div class="inset">
				<!-----start-main---->
			
				<div class="title">
				<label class="font">WSN网络管理系统</label>
				</div>
				<div><img class="pic" src="img/logo.png"></div> 
				<form action="login!login" method="post">
			         <div>
						<span><label class="label">用户名</label><img class="username" src="img/username.png"></span>
						<span><input type="text" class="textbox" id="loginName"name="loginName" /></span>
					 </div>
					 <div>
						<span><label >密&nbsp;&nbsp;码</label><img class="password" src="img/password.png"></span>
					    <span><input type="password" class="password" id="password" name="password"></span>
						
					 </div>
					
						<span class="forget-pass">
							<a href="#">新用户？</a>
						</span>
					 <div>
					 <span><input type="radio" name="identity" value="用户" checked="checked" />用户 
					 &nbsp;<input type="radio" name="identity" value="管理员" />管理员</span>
					 </div>
					 
					 <div id="check" ></div>
					
					<div class="sign">
					
						<div class="submit">		
						  <input type="submit" value="登录" >
						   &nbsp;&nbsp;&nbsp;&nbsp;<input type="reset"  value="重置"  >				  
						</div>

							<div class="clear"> </div>
							
					</div>
				 </form>
				</div>
					
			</div>
			
		<!-----//end-main---->
		</div>
	
</body>
  	
  
 
</html>
