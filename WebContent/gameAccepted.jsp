<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/Struts2Contacts/main.css"/>
<title>GameShare: Game Accepted</title>
</head>
<body>
	<!-- barra header fissa -->
	<div style="position:fixed; height:30px; width:99%; top:0px; left:0px;
	    background:#F0F0F0;
	    border:1px solid #CCC;
	    margin:0px auto;" >
	    
	    <div style="float: left; position:relative; top:5px; left:5px;">
	    <s:url action="viewGameList" method="execute" namespace="/" var="urlTagGames"></s:url>
	      <b>GameShare</b> | 
	     <a href="/Struts2Contacts/loginConfirm.jsp">Home</a> | 
	     <s:a href="%{urlTagGames}">Games</s:a> | 
	     <a href="/Struts2Contacts/searchGame.jsp">Search</a> | 
	     Messages | 
	     Friends |
	    </div>
	    
	    <div style="float: right; position:relative; top:5px; right:7px;">
			<s:url action="login" method="logout" namespace="/" var="urlTag"></s:url>
			<s:a href="%{urlTag}">| Logout </s:a>
		</div>
	</div><br><br><div style="clear: both;"></div>
	<!-- fine barra header fissa -->
	
	
	
	
	<table width=600 cellpadding=10 align="center" style="background-color:#F0F0F0; border:1px solid #CCC;">
	<tr>
		<td align="center" valign="middle">
			Congratulations!<br>
			The game is now accepted and it will be fully available in GameShare!
		</td>
	</tr>
	</table>
	
</body>
</html>