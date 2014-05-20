<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Games List</title>
</head>
<body>

		<s:iterator value="similarGames" status="stat">           

		<p><s:property value="name"/></p>
	
		</s:iterator> 
		<a href="addGame.jsp">Add Game</a>
</body>
</html>