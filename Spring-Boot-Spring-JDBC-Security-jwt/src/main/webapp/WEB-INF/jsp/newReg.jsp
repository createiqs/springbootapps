<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Sign Up</h1>
	<a href="/emp/employees">Employees</a> |
	<a href="/emp/newemployee">New Employee</a> |
	<hr>
	<form action="/user/saveReg" method="post">
	<table>
		<tr>
			<td>Username</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>Re - Password</td>
			<td><input type="password" name="repassword"></td>
		</tr>
		<tr>
			<td>Role</td>
			<td><select name="roles" multiple="multiple">
					<option value="ROLE_ADMIN">Admin</option>
					<option value="ROLE_USER">User</option>
			</select></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save"></td>
		</tr>
	</table>
</form>
</body>
</html>