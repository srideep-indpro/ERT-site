<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<form method="POST"
		action="${pageContext.request.contextPath}/editContact">
		<input type="hidden" name="contactId"
			value="${singleContactDetails.getContactId()}" />
		<table border="0">
			<%-- <tr>
				<td>ContactId</td>
				<td><input type="text" name="contactId"
					value="${singleContactDetails.getContactId()}" /></td>
			</tr> --%>

			<tr>
				<td>ContactName</td>
				<td><input type="text" name="contactName"
					value="${singleContactDetails.getContactName()}" /></td>
			</tr>
			
			<tr>
				<td>ContactNo</td>
				<td><input type="text" name="phoneNumber"
					value="${singleContactDetails.getPhoneNumber()}" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> <a
					href="${pageContext.request.contextPath}/userInfo">Cancel</a></td>
			</tr>
		</table>
	</form>
</body>
</html>