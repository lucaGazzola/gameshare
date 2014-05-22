<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
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
	<h2>User <s:property value="email"/> <s:property value="firstname"/> added!</h2>
</body>
</html>