<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/Struts2Contacts/main.css"/>
<title>Game Share: Welcome</title>
</head>
<body>

	<!-- barra header fissa -->
	<div style="position:fixed; height:30px; width:99%; top:0px; left:0px;
	    background:#F0F0F0;
	    border:1px solid #CCC;
	    margin:0px auto;" >
	     <b>GameShare</b> | 
	     <a href="/Struts2Contacts/loginConfirm.jsp">Home</a> | 
	     <a href="/Struts2Contacts/searchGame.jsp">Search</a> | 
	     Messages | 
	     Friends |
	</div>
	
	<br><br>
	<h2 align="center">Welcome <s:property value="%{#session.loggedInUser.firstname}"/>!</h2>
	<div id="body" align="center">
	<table width=600px style="background-color:#F0F0F0;border:1px solid #CCC;">
		<tr>
			<td style="vertical-align:top;border:1px solid #CCC;">
				<b>Your Played games</b>
			</td>
			<td style="vertical-align:top;border:1px solid #CCC;">
				<b>Social</b><br>
				New messages: <br>
				New friend requests: 
			</td>
		</tr>
		<tr>
			<td style="vertical-align:top;border:1px solid #CCC;">
				<b>Suggested games</b><br>
				- prova<br>
				- prova
			</td>
			<td style="vertical-align:top;border:1px solid #CCC;">
				<b>Suggested friends</b><br>
				- prova<br>
				- prova
			</td>
		<tr>
	</table>
	</div>
</body>
</html>