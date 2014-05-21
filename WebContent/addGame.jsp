<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddGame</title>
</head>
<body>
 
<h2>AddGame</h2>
<s:actionerror />

<s:form action="addGame" method="post" namespace="/">
    <s:select key="label.gameType" name="gameType" headerKey="0" headerValue="-- Please Select --" list="{'videogame', 'card', 'sport', 'board'}" />
	<s:textfield name="name" key="label.name" size="20"/>
	<s:textfield name="description" key="label.description" size="20"/>
    <s:textfield name="priceRange" key="label.priceRange" size="20"/>
	<s:radio key="label.online" name="online" list="{true,false}" />
	<s:textfield name="videogameType" key="label.videogameType" size="20"/>
	<s:textfield name="duration" key="label.duration" size="20"/>
	<s:textfield name="suggestedPlayers" key="label.suggested" size="20"/>
	<s:textfield name="requiredPlayers" key="label.required" size="20"/>
	<s:textfield name="deck" key="label.deck" size="20"/>
	
	<s:submit method="execute" key="label.addGame" align="center"/>
</s:form>

</body>
</html>