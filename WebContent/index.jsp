<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Contact</title>
</head>
<body>

<h2>Add Contact</h2>
<s:actionerror />

<s:form action="add.action" method="post">
	<s:textfield name="firstname" key="label.firstname" size="20"/>
	<s:textfield name="lastname" key="label.lastname" size="20"/>
	<s:textfield name="address" key="label.address" size="20"/>
	
	<s:submit method="execute" key="label.add" align="center"/>
</s:form>

</body>
</html>