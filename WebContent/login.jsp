<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset title="Login Page">
		<legend>Login Page</legend>
		<form action="LoginServlet" method="post">
			<table>
				<tr>
					<td>Email ID :</td>
					<td><input type="email" name="email" required></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="passkey" required></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
				</form>
				<form action="ForgetPassword" method="post">
					<td><input type="submit" value="Forget Password" /></td>
				</form>
			</table>
	</fieldset>
</body>
</html>