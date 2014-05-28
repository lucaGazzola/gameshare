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
<s:url action="searchGame" method="execute" namespace="/" var="urlSearchGame">
<s:param name="id_game" value="ID_game"></s:param>
</s:url>

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
	</div><br><br>
	<!-- fine barra header fissa -->
	
	<!-- tabella foto profilo + welcome -->
	<div id="profile" align="center">
	<table width=600px style="background-color:#F0F0F0;border:1px solid #CCC;">
	<tr>
		<td width="22%" style="border:1px solid #CCC;">
			<img alt="profile_image" src="/Struts2Contacts/images/profile_images/<s:property value="%{#session.loggedInUser.ID_user}"/>-profile.jpg" width="150" height="150"/>
		</td>
		<td width="78%" style="border:1px solid #CCC;">
			<h2 align="center">Welcome <s:property value="%{#session.loggedInUser.firstname}"/>!</h2>
		</td>
	</tr>
	</table>
	</div><br>
	<!-- fine tabella foto profilo + welcome -->
	
	
	<!-- inizio tabella info profilo -->
	<div id="body" align="center">
	<table width=600px style="background-color:#F0F0F0;border:1px solid #CCC;">
		<tr>
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;">
				<b>Your Played games</b>
				<table width="100%">
				<s:iterator value="#session.playGameList" var="game">
				<tr>
					<td width="15%">
						<img alt="game_image" src="/Struts2Contacts/images/game_images/<s:property value="ID_game"/>-game.jpg" width="30" height="30"/>
					</td>
					<td width="85%">
						<s:a href="%{urlSearchGame}"><s:property value="name"/></s:a>
					</td>
				</tr>
				</s:iterator> 
			</table>
			</td>
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;">
				<b>Social</b><br>
				New messages: <i><b>0</b></i><br>
				New friend requests: <i><b>0</b></i>
			</td>
		</tr>
		<tr>
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;">
				<b>Suggested games</b><br><br>
				- Briscola<br>
				- Tresette
			</td>
			<td width="50%"style="vertical-align:top;border:1px solid #CCC;">
				<b>Suggested friends</b><br><br>
				- Gina Lollobrigida<br>
				- Gigi Rizzi
			</td>
		<tr>
	</table>
	</div>
	<!-- fine tabella info profilo -->
</body>
</html>