<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset title="Home Page">
		<legend>Recover Password</legend>
		<form action="SendMailServlet">
			To: &nbsp;&nbsp;&nbsp;<input type="text" name="email" required /><br /> 
			<input type="submit" value="send" />
		</form>
		</fieldset>
	</body>
</html>