<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game Share</title>
<link rel="stylesheet" type="text/css" href="/Struts2Contacts/main.css"/>
</head>
<body>

<div id="body" align="center">
<div style="background:#F0F0F0;border:1px solid #CCC;"><h2>Game Share, game social network</h2></div>

<s:url action="populateAction" method="erase" namespace="/" var="urlTagErase"></s:url>
<s:url action="populateAction" method="execute" namespace="/" var="urlTagPopulator"></s:url>
<br>
<s:a href="%{urlTagPopulator}"><button type="button">Populate DB</button></s:a>
<s:a href="%{urlTagErase}"><button type="button">Erase DB</button></s:a>
<br>
<br>
<s:actionerror />

<s:if test="hasActionMessages()">
      <s:actionmessage/>
</s:if>

<!-- TABELLA GRIGIA PRINCIPALE -->
<table width=600 style="background-color:#F0F0F0;border:1px solid #CCC;">
<tr>
<s:if test="%{#session.containsKey(\"loggedInUser\")}">
	<!-- colonna logout -->
	<td style="vertical-align:top;">
	<h3>You are already logged in:</h3>
	</td>
	<tr>
	<td align="center">
		Go to your <b><i><a href="/Struts2Contacts/loginConfirm.jsp">Profile page</a></i></b>
		 or 
		<b><i>
		<s:url action="login" method="logout" namespace="/" var="urlTag"></s:url>
		<s:a href="%{urlTag}">Logout</s:a></i></b>
	</td>
	</tr>

		
	
</s:if>
<s:else>
	<!-- 	colonna registrazione -->
	<td style="border:1px solid #CCC;">
	<h3>Register</h3>
	<s:form action="register" method="post" namespace="/" enctype="multipart/form-data">
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
		<s:file name="userImage" key="label.uploadUserImage"  size="5" label="User Image" />
		<br>
		<s:submit method="execute" key="label.register" align="right"/>
	</s:form>
	</td>
	
	<!-- 	colonna login -->
	<td style="vertical-align:top; border:1px solid #CCC;">
	<h3>Login</h3>
	<s:form action="login" method="post" namespace="/">
		<s:textfield name="email" key="label.email" size="20"/>
		<s:password name="password" key="label.password" size="20"/>
		<s:submit method="login" key="label.login" align="right"/>
	</s:form>
	</td>
</s:else>
</tr>
</table>

</div>
</body>
</html>