<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="/Struts2Contacts/main.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game Share: game search</title>
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

<div id="body" align="center" style="width=600;background:#F0F0F0; border:1px solid #CCC; left:0px;">
<h2>Search Game</h2>
<s:actionerror />

<s:form action="searchGame" method="post" namespace="/">
	<s:textfield name="game" key="label.gameName" size="20"/>
	<s:submit method="execute" key="label.search" align="right"/>
</s:form>
</div>
</body>
</html>