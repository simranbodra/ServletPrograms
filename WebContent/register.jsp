<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   
 <%--    <%
    	if((session.getAttribute("username")==null)||(session.getAttribute("password")==null)){
    		response.sendRedirect("login.jsp");
    	}
    %> --%>
    
    <fieldset title="Registration Page">
<legend>Registration Page</legend>
    <form action="Registration" method="post">
    			<table>
    				<tr>
    					<td>Enter Name</td>
    					<td><input type="text" name="name" required placeholder="Enter Full Name" /></td>
    				</tr>
    				<tr>
    					<td>Contact No</td>
    					<td><input type="text" name="contact" maxlength="10" title="only 10 digit" required /></td>
    				</tr>
    				<tr>
    					<td>Email ID</td>
    					<td><input type="email" name="email" title="abc@gmail.com" required/></td>
    				</tr>
    					<tr>
    					<td>Password</td>
    					<td><input type="password" name="password" required placeholder="******" pattern="((?=.*\d)(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*]).{6,20})" title="must contain atleast 1-UpperCase,1-LowerCase,1-specialCharacter And 1-Digit"/></td>
    				</tr>
    				</table>
    			<input type="submit" value="Submit" /></form>
    			</fieldset>
</body>
</html>