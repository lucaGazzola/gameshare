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
	     <a href="/Struts2Contacts/loginConfirm.jsp">Home</a> | 
	     <a href="/Struts2Contacts/searchGame.jsp">Search</a> | 
	     Messages | 
	     Friends |
	</div>
	
			<!-- tag url per le action via link  -->
	    	<s:url action="likeAction" method="execute" namespace="/" var="urlTagLike">
	    	<s:param name="id_game" value="game.ID_game"></s:param>
			<s:param name="game" value="%{#game}"></s:param>
			<s:param name="user_reviewList" value="%{#user_reviewList}"></s:param>
			<s:param name="numPlay" value="numPlay"></s:param>
			<s:param name="numLike" value="numLike"></s:param>
						<s:param name="isPlay" value="isPlay"></s:param>
			<s:param name="isLike" value="isLike"></s:param>
			<s:param name="gameCategory" value="gameCategory"></s:param>
			</s:url>
			
			<s:url action="playAction" method="execute" namespace="/" var="urlTagPlay">
			<s:param name="id_game" value="game.ID_game"></s:param>
			<s:param name="game" value="%{#game}"></s:param>
			<s:param name="user_reviewList" value="%{#user_reviewList}"></s:param>
			<s:param name="numPlay" value="numPlay"></s:param>
			<s:param name="numLike" value="numLike"></s:param>
			<s:param name="isPlay" value="isPlay"></s:param>
			<s:param name="isLike" value="isLike"></s:param>
			<s:param name="gameCategory" value="gameCategory"></s:param>
			</s:url>
			
			<s:url action="viewLikeUsers" method="execute" namespace="/" var="urlTag">
			<s:param name="id_game" value="game.ID_game"></s:param></s:url>
			
			<s:url action="viewPlayUsers" method="execute" namespace="/" var="urlTag2">
			<s:param name="id_game" value="game.ID_game"></s:param></s:url>
			
<br><br>
<s:actionerror />
<table width=600 cellpadding=10 align="center" style="background-color:#F0F0F0; border:1px solid #CCC;">
<tr>
	<td width="22%" style="border:1px solid #CCC;">
		<img alt="game_image" src="/Struts2Contacts/images/game_images/<s:property value="id_game"/>-game.jpg" width="150" height="150"/>
	</td>
	<td width="78%" style="border:1px solid #CCC;">
		<table width="100%">
			<tr>
				<td width="100%">
					<h2><s:property value="game.name"/></h2>
					<i><b>Game category:</b></i> <s:property value="gameCategory"/><br>
					<i><b>Average score:</b></i> <s:property value="game.avgScore"/><br>
					<i><b>Price range:</b></i> <s:property value="game.priceRange"/>
				</td>
			</tr>
			<tr>
				<td>
					<s:a href="%{urlTagLike}"><button type="button">Like</button></s:a>
					<s:a href="%{urlTagPlay}"><button type="button">Play</button></s:a>
				</td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td colspan=3 style="border:1px solid #CCC;">
	    <div id="description_box">
	    	<h3>Description</h3>
	      <p><s:property value="game.description"/></p>
	    </div>
    </td>	
</tr>

<tr>
	<td colspan=3 style="border:1px solid #CCC;">
	    <div id="social_box">
	    	<h3>Social</h3>
	    	<p><i><b><s:a href="%{urlTag}"><s:property value="numLike"/></s:a></b></i> users <i><b>like</b></i> this game</p>
	    	<p><i><b><s:a href="%{urlTag2}"><s:property value="numPlay"/></s:a></b></i> users <i><b>play</b></i> this game</p>
	    </div>
    </td>	
</tr>

<tr>
	<td colspan=3 style="border:1px solid #CCC;">
	    <div id="review_box">
	    	<h3>Reviews</h3>
	    	<table width="100%">
				<s:iterator value="user_reviewList" var="user_reviewSingle">
				<tr>
					<td width="100%">
						<b><s:property value="%{#user_reviewSingle[0]}"/> <s:property value="%{#user_reviewSingle[1]}"/>:</b>
						<br><s:property value="%{#user_reviewSingle[2]}"/>
						<br>SCORE: <b><i><s:property value="%{#user_reviewSingle[3]}"/></i></b>
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