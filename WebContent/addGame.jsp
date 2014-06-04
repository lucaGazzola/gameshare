<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="/Struts2Contacts/main.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game Share: Add game</title>
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
	
<div id="body" align="center" style="width=600;background:#F0F0F0; border:1px solid #CCC;">
<h2>Add new game</h2>
<s:actionerror />

<s:form action="addGame" method="post" namespace="/">
    <s:select key="label.gameType" name="gameType" headerKey="0" headerValue="-- Please Select --" list="{'videogame', 'card', 'sport', 'board'}" />
	<s:textfield name="name" key="label.name" size="20"/>
	<s:textfield name="description" key="label.description" size="20"/>
    <s:textfield name="priceRange" key="label.priceRange" size="20"/>
	<s:radio key="label.online" name="online" list="{true,false}" />
	<s:textfield name="videogameType" key="label.videogameType" size="20"/>
	<s:checkbox name="PC" fieldValue="true" label="PC"/>
	<s:checkbox name="XBox" fieldValue="true" label="XBox"/>
	<s:checkbox name="PS" fieldValue="true" label="PS"/>
	<s:checkbox name="Wii" fieldValue="true" label="Wii"/>
	<s:textfield name="duration" key="label.duration" size="20"/>
	<s:textfield name="suggestedPlayers" key="label.suggested" size="20"/>
	<s:textfield name="requiredPlayers" key="label.required" size="20"/>
	<s:textfield name="deck" key="label.deck" size="20"/>
	
	<s:submit method="execute" key="label.addGame" align="center"/>
</s:form>
</div>
</body>
</html>