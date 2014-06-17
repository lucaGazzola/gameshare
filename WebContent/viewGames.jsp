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
	     <font color="gray">Messages | 
	     Friends |</font>
	    </div>
	    
	    <div style="float: right; position:relative; top:5px; right:7px;">
			<s:url action="login" method="logout" namespace="/" var="urlTag"></s:url>
			<s:a href="%{urlTag}">| Logout </s:a>
		</div>
	</div><br><br><div style="clear: both;"></div>
	<!-- fine barra header fissa -->

	
<div id="body" align="center">
	<!-- inizio tabella games separati x categoria -->
	
	<!-- titolo -->
	<table width=600px style="background-color:#F0F0F0;border:1px solid #CCC;z-index: 10;">
		<tr>
			<td align="center" width="100%" style="border:1px solid #CCC;z-index: 10;">
				<h2>Game List</h2>
			</td>
		</tr>
	</table>
	<table width=600px style="background-color:#F0F0F0;border:1px solid #CCC;z-index: 10;">
		<!--  riga 1 -->
		<tr>
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<b>Board Games</b>
				
				<table width="100%">
				<s:iterator value="boardgameList" var="game" status="ctr">
				<s:if test="#ctr.index < 8">
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
			
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<b>Card Games</b>
				
				<table width="100%">
				<s:iterator value="cardgameList" var="game" status="ctr">
				<s:if test="#ctr.index < 8">
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
		</tr>
		<!-- fine riga1 -->
		
		<!-- riga2 -->
		<tr>
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<b>Video Games</b>
				
				<table width="100%">
				<s:iterator value="videogameList" var="game" status="ctr">
				<s:if test="#ctr.index < 8">
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
			
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<b>Sport</b>
				
				<table width="100%">
				<s:iterator value="sportList" var="game" status="ctr">
				<s:if test="#ctr.index < 8">
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
		</tr>
		<!-- fine riga2 -->		
	</table>
	<table width=600px style="background-color:#F0F0F0;border:1px solid #CCC;z-index: 10;">
		<tr>
			<td>
				Didn't find your game? <b><a href="/Struts2Contacts/addGame.jsp">Add new game</a></b>
			</td>
		</tr>
	</table>
	
	
	<br><br>
	<!-- inizio tabella unaccepted games -->
	<!-- titolo -->
	<table width=600px style="background-color:#F0F0F0;border:1px solid #CCC;z-index: 10;">
		<tr>
			<td align="center" style="width:100%;vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<h2>Games waiting approval</h2>
			</td>
		</tr>
	</table>
	<table width=600px style="background-color:#F0F0F0;border:1px solid #CCC;z-index: 10;">
		<!--  riga 1 -->
		<tr>
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<b>Board Games</b>
				
				<table width="100%">
				<s:iterator value="unaccepted_boardgameList" var="game" status="ctr">
				<s:if test="#ctr.index < 8">
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
			
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<b>Card Games</b>
				
				<table width="100%">
				<s:iterator value="unaccepted_cardgameList" var="game" status="ctr">
				<s:if test="#ctr.index < 8">
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
		</tr>
		<!-- fine riga1 -->
		
		<!-- riga2 -->
		<tr>
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<b>Video Games</b>
				
				<table width="100%">
				<s:iterator value="unaccepted_videogameList" var="game" status="ctr">
				<s:if test="#ctr.index < 8">
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
			
			<td width="50%" style="vertical-align:top;border:1px solid #CCC;position: relative;z-index: 10;">
				<b>Sport</b>
				
				<table width="100%">
				<s:iterator value="unaccepted_sportList" var="game" status="ctr">
				<s:if test="#ctr.index < 8">
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
		</tr>
		<!-- fine riga2 -->
</table>
</div>

</body>
</html>