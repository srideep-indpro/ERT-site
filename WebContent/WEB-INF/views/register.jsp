<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>

	<form action="${pageContext.request.contextPath}/register"
		method="POST" style="border: 1px solid #ccc">
		<div class="container">
			<h2>
				<font color="green">${successMessage}</font>
			</h2>
			<h1>Sign Up</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>
			<label><b>Name</b></label> <input type="text"
				placeholder="Enter Name" name="name"> <label> <label><b>Email</b></label>
				<input type="text" placeholder="Enter Email" name="email"> <label><b>Phone
						Number</b> <input type="text" placeholder="Enter Phone Number"
					name="phoneNumber"> </label><label><b>Password</b></label> <input
				type="password" placeholder="Enter Password" name="password">

				<p>
					By creating an account you agree to our <a href="#"
						style="color: dodgerblue">Terms & Privacy</a>.
				</p>

				<div class="clearfix">
					<input type="submit" value="Sign Up">
				</div>
				<p>
					<a href="${pageContext.request.contextPath}/login">Login</a>
				</p>
		</div>
	</form>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>