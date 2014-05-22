<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="/Struts2Contacts/main.css"/>
</head>
<body>

<h2>Login</h2>
<s:actionerror />

<s:form action="login" method="post" namespace="/">
	<s:textfield name="email" key="label.email" size="20"/>
	<s:password name="password" key="label.password" size="20"/>
	
	<s:submit method="execute" key="label.login" align="center"/>
</s:form>

</body>
</html>