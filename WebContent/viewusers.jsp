<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/Struts2Contacts/main.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Game Share: View User List</title>
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
	     <font color="gray">Messages | 
	     Friends |</font>
	    </div>
	    
	    <div style="float: right; position:relative; top:5px; right:7px;">
			<s:url action="login" method="logout" namespace="/" var="urlTag"></s:url>
			<s:a href="%{urlTag}">| Logout </s:a>
		</div>
	</div><br><br><div style="clear: both;"></div>
	<!-- fine barra header fissa -->
	

<table width=600 cellpadding=10 align="center" style="background-color:#F0F0F0; border:1px solid #CCC;">
		<s:iterator value="userList">
			<tr>
				<td width="14%" style="border:1px solid #CCC;">
					<img alt="profile_image" src="/Struts2Contacts/images/profile_images/<s:property value="ID_user"/>-profile.jpg" width="50" height="50"/>
				</td>
				<td width="86%" style="border:1px solid #CCC;">
					<i><b><s:property value="firstname"/> <s:property value="lastname"/><br></b></i>
					<br>
					<button type="button">Add Friend</button> <button type="button">Send Message</button>
				</td>
			</tr>
		</s:iterator>
	<s:else>
		
	</s:else>
</table>

</body>
</html>