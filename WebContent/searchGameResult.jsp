<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Games List</title>
</head>
<body>
	<!-- barra header fissa -->
	<div style="position:fixed; height:30px; width:99%; top:0px; left:0px;
	    background:#F0F0F0;
	    border:1px solid #CCC;
	    margin:0px auto;" >
	     <b>GameShare</b> | 
	     <a href="/Struts2Contacts/loginConfirm.jsp" style="text-decoration:none; color:black;">Home</a> | 
	     <a href="/Struts2Contacts/searchGame.jsp" style="text-decoration: none; color:black;">Search</a> | 
	     Messages | 
	     Friends |
	</div>
	<br><br>
	
	<div id="body" align="center" style="width=600;background:#F0F0F0; border:1px solid #CCC; left:0px;">
		
		<s:url action="viewGame" namespace="/" var="urlTag">
				<s:param name="id_game" value="ID_game"></s:param>
		</s:url>
			
		<s:iterator value="similarGames">
			<p><s:a href="%{urlTag}"><s:property value="name"/></s:a></p>
		</s:iterator> 
		
		<a href="addGame.jsp">Add Game</a>
	</div>
</body>
</html>