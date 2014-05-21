<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

<h2>Register</h2>
<s:actionerror />

<s:form action="register" method="post" namespace="/">
	<s:textfield name="email" key="label.email" size="20"/>
	<s:password name="password" key="label.password" size="20"/>
	<s:date name="birthdate" var="formattedVal"/>
    <s:textfield name="birthdate" value="%{#formattedVal}" key="label.birthdate" />
	<s:textfield name="hometown" key="label.hometown" size="20"/>
	<s:radio key="label.gender" name="gender" list="{'M','F'}" />
	<s:textfield name="job" key="label.job" size="20"/>
	<s:textfield name="school" key="label.school" size="20"/>
	<s:textfield name="firstname" key="label.firstname" size="20"/>
	<s:textfield name="lastname" key="label.lastname" size="20"/>
	<s:textfield name="residence" key="label.residence" size="20"/>
	
	<s:submit method="execute" key="label.register" align="center"/>
</s:form>

</body>
</html>