<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/Struts2Contacts/main.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Game Share: view user list</title>
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
	</div><br><br>
	<!-- fine barra header fissa -->
	

<table width=600 cellpadding=10 align="center" style="background-color:#F0F0F0; border:1px solid #CCC;">
	<s:iterator value="userList">
		<tr>
			<td width="22%" style="border:1px solid #CCC;">
				<img alt="profile_image" src="/Struts2Contacts/images/profile_images/<s:property value="ID_user"/>-profile.jpg" width="150" height="150"/>
			</td>
			<td width="78%" style="border:1px solid #CCC;">
				<i><b><s:property value="firstname"/> <s:property value="lastname"/><br></b></i>
				<br>
				<button type="button">Add Friend</button> <button type="button">Send Message</button>
			</td>
		</tr>
	</s:iterator>
</table>

</body>
</html>