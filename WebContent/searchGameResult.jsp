<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Games List</title>
</head>
<body>
	<table>
		<s:iterator value="similarGames">           
		<tr>
		<td><s:property/></td>
		</tr>
		</s:iterator> 
</table>
</body>
</html>