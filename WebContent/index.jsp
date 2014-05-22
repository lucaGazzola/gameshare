<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@  page 
import="util.Populator" 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game Share</title>
<link rel="stylesheet" type="text/css" href="/Struts2Contacts/main.css"/>
</head>
<body>

<div id="body" align="center">
<h2>Game Share, game social network</h2>

<s:form action="populateAction" method="post" namespace="/">
	<s:submit method="execute" value="Populate DB" align="center"/>
</s:form>
<br>
<s:actionerror />

<!-- TABELLA GRIGIA PRINCIPALE -->
<table border=1 width=600 style="background-color:#F0F0F0;">
<tr>
<!-- 	colonna registrazione -->
	<td>
	<h3>Register</h3>
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
	<s:submit method="execute" key="label.register" align="right"/>
	</s:form>
	</td>
	
<!-- 	colonna login -->
	<td style="vertical-align:top;">
	<h3>Login</h3>
	<s:form action="login" method="post" namespace="/">
	<s:textfield name="email" key="label.email" size="20"/>
	<s:password name="password" key="label.password" size="20"/>
	<s:submit method="execute" key="label.login" align="right"/>
	</s:form>
	</td>
</tr>
</table>

</div>

<s:form action="viewGame" method="post" namespace="/">
	<s:textfield name="id_game" size="5"/>
	<s:submit method="execute" value="View Game" align="center"/>
</s:form>

<%-- <s:form action="add" method="post" namespace="/"> --%>
<%-- 	<s:textfield name="firstname" key="label.firstname" size="20"/> --%>
<%-- 	<s:textfield name="lastname" key="label.lastname" size="20"/> --%>
<%-- 	<s:textfield name="address" key="label.address" size="20"/> --%>
<%-- 	<s:submit method="execute" key="label.add" align="center"/> --%>
<%-- </s:form> --%>

</body>
</html>