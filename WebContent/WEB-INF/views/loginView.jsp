<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Login</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>

	<h3 align="middle" style="font-size: 30px; font-family: sans-serif;">Login
		Page</h3>
	<p style="color: red;">${LoginErrorString}</p>


	<form method="POST" action="${pageContext.request.contextPath}/login">
		<div
			style="margin-left: 450px; margin-right: 450px; border-style: solid; padding-left: 38px; padding-top: 25px; padding-bottom: 25px">
			<table border="0">
				<tr>
					<td style="font-size: 18px; font-family: sans-serif;">User
						Name</td>
					<td><input type="text" name="userName"
						placeholder="Enter your name"
						style="height: 30px; width: 200px; border-radius: 5px"
						value="${user.userName}" /></td>
				</tr>
				<tr>
					<td style="font-size: 18px; font-family: sans-serif;">Password</td>
					<td><input type="password" name="password"
						placeholder="Enter your password"
						style="height: 30px; width: 200px; border-radius: 5px"
						value="${user.password}" /></td>
				</tr>
				<tr>
					<td style="font-size: 18px; font-family: sans-serif;">Remember
						me</td>
					<td><input type="checkbox" name="rememberMe" value="Y" /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td colspan="2" style="padding-left: 85px"><input
						type="submit"
						style="font-size: 15px; font-family: sans-serif; border-radius: 5px"
						value="Submit" /> <a
						href="${pageContext.request.contextPath}/cancel">Cancel</a></td>
				</tr>

				<tr>
					<td style="font-size: 18px; font-family: sans-serif;">Not yet
						registered?</td>

					<td><a href="${pageContext.request.contextPath}/register">Sign
							Up</a></td>

				</tr>

			</table>
		</div>
	</form>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>