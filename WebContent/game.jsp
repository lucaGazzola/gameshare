<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Game Share: <s:property value="game.name"/></title>
<link rel="stylesheet" type="text/css" href="/Struts2Contacts/main.css"/>
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
<table border=1 width=600 cellpadding=10 align="center" style="background-color:#F0F0F0;">
<tr>
	<td width="22%">
		<img alt="game_image" src="/Struts2Contacts/images/game_images/<s:property value="id_game"/>-game.jpg" width="150" height="150"/>
	</td>
	<td width="78%">
		<table width="100%">
			<tr>
				<td width="100%">
					<h2><s:property value="game.name"/></h2>
					<p>Game category: <s:property value="game.getClass().getName()"/></p>
					<p>Average score: <s:property value="game.avgScore"/></p>
					<p>Price range: <s:property value="game.priceRange"/></p>
				</td>
			</tr>
			<tr>
				<td>
					<s:form action="playLike" method="post">
						<s:submit method="likeGame" key="label.like_button"/>				
						<s:submit method="playGame" key="label.play_button"/>	
					</s:form>
				</td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td colspan=3>
	    <div id="description_box">
	    	<h3>Description</h3>
	      <p><s:property value="game.description"/></p>
	    </div>
    </td>	
</tr>

<tr>
	<td colspan=3>
	    <div id="social_box">
	    	<h3>Social</h3>
	    	<p><s:property value="numLike"/> users like this game
    			<s:form action="viewLikeUsers" method="post">
    				<s:hidden name="id_game"></s:hidden>	
					<s:submit method="execute" key="label.view_button"/>
				</s:form>
	    	</p>
	    	<p><s:property value="numPlay"/> users play this game
    			<s:form action="viewPlayUsers" method="post">		
    				<s:hidden name="id_game"></s:hidden>			
					<s:submit method="execute" key="label.view_button"/>
				</s:form>
	    	</p>
	    </div>
    </td>	
</tr>

<tr>
	<td colspan=3>
	    <div id="review_box">
	    	<h3>Reviews</h3>
	    	<table width="100%">
				<s:iterator value="user_reviewList" var="user_reviewSingle">
				<tr>
					<td width="100%">
						<b><s:property value="%{#user_reviewSingle[0]}"/> <s:property value="%{#user_reviewSingle[1]}"/>:</b>
						<br><s:property value="%{#user_reviewSingle[2]}"/>
						<br>VOTO: <i><s:property value="%{#user_reviewSingle[3]}"/></i>
					</td>
				</tr>
				</s:iterator> 
			</table>
	    </div>
    </td>
</tr>
</table>


</body>
</html>