<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/Struts2Contacts/main.css"/>
<title>Game Share: search game results</title>
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
	
	<div id="body" align="center" style="width=600;background:#F0F0F0; border:1px solid #CCC; left:0px;">
		<h2>Game search results:</h2>
		<s:iterator value="similarGames">
			<s:url action="viewGame" namespace="/" var="urlTag">
				<s:param name="id_game" value="ID_game"></s:param>
			</s:url>
			<p><s:a href="%{urlTag}">- <s:property value="name"/></s:a></p>
		</s:iterator> 
		<a href="addGame.jsp"><s:submit value="Add New Game" align="center"/></a>
	</div>
</body>
</html>