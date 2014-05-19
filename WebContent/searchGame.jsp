<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Game</title>
</head>
<body>

<h2>Search Game</h2>
<s:actionerror />

<s:form action="searchGame.action" method="post">
	<s:textfield name="name" key="label.gameName" size="20"/>
	<s:submit method="execute" key="label.search" align="center"/>
</s:form>

</body>
</html>