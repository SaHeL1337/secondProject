<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Spring MVC Tutorial by Crunchify - Hello World Spring MVC
	Example</title>
<style type="text/css">
body {
	background-image: url('http://crunchify.com/bg.png');
}
</style>
</head>
<body>
${message}
<form action="test.html" method="post">
<input type="text" name="username">
<input type="password" name="password">
<input type="submit" value="Send">
</form>
</body>
</html>