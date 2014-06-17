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
	    margin:0px auto;
	    z-index: 40;" >
	    
	    <div style="float: left; position:relative; top:5px; left:5px;">
	    <s:url action="viewGameList" method="execute" namespace="/" var="urlTagGames"></s:url>
	      <b>GameShare</b> | 
	     <a href="/Struts2Contacts/loginConfirm.jsp">Home</a> | 
	     <s:a href="%{urlTagGames}">Games</s:a> | 
	     <a href="/Struts2Contacts/searchGame.jsp">Search</a> | 
	     <font color="gray">Messages | 
	     Friends |</font>
	    </div>
	    
	    <div style="float: right; position:relative; top:5px; right:7px;">
			<s:url action="login" method="logout" namespace="/" var="urlTag"></s:url>
			<s:a href="%{urlTag}">| Logout </s:a>
		</div>
	</div><br><br><div style="clear: both;"></div>
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
			<b><i>E-Mail:</i></b> <s:property value="%{#session.loggedInUser.email}"/><br>
			<b><i>School:</i></b> <s:property value="%{#session.loggedInUser.school}"/><br>
			<b><i>Hometown:</i></b> <s:property value="%{#session.loggedInUser.hometown}"/><br>
			<b><i>Job:</i></b> <s:property value="%{#session.loggedInUser.job}"/><br>
			<font color="gray"><b><i>Edit your profile</i></b></font>
		</td>
	</tr>
	</table>
	</div><br>
	<!-- fine tabella foto profilo + welcome -->
	
	
	<!-- inizio tabella info profilo -->
	<div id="body" align="center" style="z-index: 10;">
	<table width=600px style="background-color:#F0F0F0;border:1px solid #CCC;">
		<tr>
			<td width="50%" style="position:relative;vertical-align:top;border:1px solid #CCC;">
				<b>Your Played games</b>
				<table width="100%">
				<s:iterator value="#session.playGameList" var="game" status="ctr">
				<s:if test="#ctr.index < 5">
				<tr>
					<td width="15%">
						<img alt="game_image" src="/Struts2Contacts/images/game_images/<s:property value="ID_game"/>-game.jpg" width="30" height="30"/>
					</td>
					<td width="85%">
						<a href="<s:url action="viewGame" method="execute" namespace="/">
							<s:param name="id_game" value="ID_game"></s:param></s:url>">
						    <s:property value="name"/>
						</a>
					</td>
				</tr>
				</s:if>
				</s:iterator>
				</table>
				
				<br><p></p>
				<div style="position: absolute; bottom: 0px;"><font color="gray"><b><i>View all</i></b></font></div>
			</td>
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;">
				<font color="gray">
				<b>Social</b><br>
				New messages: <i><b>0</b></i><br>
				New friend requests: <i><b>0</b></i>
				</font>
			</td>
		</tr>
		<tr>
			<td width="50%" style="position:relative;vertical-align:top;border:1px solid #CCC;">
				<b>Suggested games</b><br><br>
				- Briscola<br>
				- Tresette
				
				<br><br><p></p>
				<div style="position: absolute; bottom: 0px;"><font color="gray"><b><i>View all</i></b></font></div>
			</td>
			<td width="50%"style="position:relative;vertical-align:top;border:1px solid #CCC;">
				<b>Suggested friends</b><br><br>
				- Gina Lollobrigida<br>
				- Gigi Rizzi
				
				<br><br><p></p>
				<div style="position: absolute; bottom: 0px;"><font color="gray"><b><i>View all</i></b></font></div>
			</td>
		<tr>
	</table>
	</div>
	<!-- fine tabella info profilo -->
</body>
</html>