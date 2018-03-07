<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
.btnstyle:hover {
	background-color: '#ff9900';
}
</style>

</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>

	<br />
	<br />

	<p><font color="green" size = "15px">${successContactAddedMessage}</font></p>
	<div class="container">
		<div class='row'>
			<div class='col-lg-6 col-md-6 col-sm-12 col-xs-12'>
				<form action="${pageContext.request.contextPath}/addContact"
					method="POST">
					<div class='col-lg-7 col-md-7 col-sm-12 col-xs-12'
						style='padding-bottom: 10px'>
						<input type="text" name="contactName" class="form-control"
							placeholder="Enter Contact Name" />
					</div>
					<div class='col-lg-5 col-md-5 col-sm-12 col-xs-12'
						style='padding-bottom: 10px'></div>
					<div class='col-lg-7 col-md-7 col-sm-12 col-xs-12'
						style='padding-bottom: 10px'>
						<input type="text" name="phoneNumber" class="form-control"
							placeholder="Enter phone Number" required />
					</div>
					<div class='col-lg-5 col-md-5 col-sm-12 col-xs-12'
						style='padding-bottom: 10px'></div>
					<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'
						style='padding-bottom: 10px'>
						<input type="submit" class="btn btnstyle"
							style="background-color: '#ff9900'" value="+ADD">
					</div>

				</form>

				<form action="${pageContext.request.contextPath}/sendSMS"
					method="POST">
					<div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'
						style='padding-bottom: 10px'>
						<input type="submit" class="btn btnstyle"
							style="background-color: '#ff9900'" value="iPANIC!">
					</div>
				</form>

			</div>
			<div class='col-lg-6 col-md-6 col-sm-12 col-xs-12'
				style='border-style: solid; border-left-color: coral; border-right-color: white; border-top-color: white; border-bottom-color: white; min-height: 550px'>

				<p><font color="green" size="15px">${successSMS}</font></p>
				<table class="table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Phone Number</th>
							<th>Manage</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${contactList}" var="contact">
							<tr>
								<td>${contact.contactId}</td>
								<td>${contact.contactName}</td>
								<td>${contact.phoneNumber}</td>
								<td><a
									href="${pageContext.request.contextPath}/editContact?contactId= ${contact.contactId}"
									<span class="glyphicon glyphicon-pencil"></span></a>
									&nbsp;&nbsp; <a
									href="${pageContext.request.contextPath}/deleteContact?contactId=${contact.contactId}"
									<span class="glyphicon glyphicon-trash"></span></a>
								</td>
							</tr>
						</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>

