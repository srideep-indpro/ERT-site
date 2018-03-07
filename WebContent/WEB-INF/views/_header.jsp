<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="background: #E0E0E0; height: 75px; padding: 5px;">
	<div style="float: left">
		<h1>UserHome</h1>
	</div>

	<div style="float: right; padding: 10px; text-align: right;">

		Hello <b style="font-size: 20px; font-family: serif;color: green;"> ${userName}</b> <br />
        <a href="${pageContext.request.contextPath}/logout">Logout</a></li>
	</div>

</div>