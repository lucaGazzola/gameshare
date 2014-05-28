<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/Struts2Contacts/main.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Game Share: Game List</title>
</head>
<body>
	<!-- barra header fissa -->
	<div style="position:fixed; height:30px; width:99%; top:0px; left:0px;
	    background:#F0F0F0;
	    border:1px solid #CCC;
	    margin:0px auto;
	    z-index: 40;">
	    
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

	<!-- inizio tabella games separati x categoria -->
<div id="body" align="center">
	<h2>Game List</h2><br>
	<table width=600px style="background-color:#F0F0F0;border:1px solid #CCC;z-index: 10;">
		<!--  riga 1 -->
		<tr>
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<b>Board Games</b>
				
				<table width="100%"">
				<s:iterator value="boardgameList" var="game">
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
				</s:iterator> 
				</table>
				<br><p></p>
				<div style="position: absolute; bottom: 0px;"><b><i>View all</i></b></div>
			</td>
			
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<b>Card Games</b>
				
				<table width="100%">
				<s:iterator value="cardgameList" var="game">
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
				</s:iterator> 
				</table>
				<br><p></p>
				<div style="position: absolute; bottom: 0px;"><b><i>View all</i></b></div>
			</td>
		</tr>
		<!-- fine riga1 -->
		
		<!-- riga2 -->
		<tr>
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<b>Video Games</b>
				
				<table width="100%">
				<s:iterator value="videogameList" var="game">
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
				</s:iterator> 
				</table>
				<br><p></p>
				<div style="position: absolute; bottom: 0px;"><b><i>View all</i></b></div>
			</td>
			
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<b>Sport</b>
				
				<table width="100%">
				<s:iterator value="sportList" var="game">
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
				</s:iterator> 
				</table>
				<br><p></p>
				<div style="position: absolute; bottom: 0px;"><b><i>View all</i></b></div>
			</td>
		</tr>
		<!-- fine riga2 -->
		
	</table>
</div>

</body>
</html>