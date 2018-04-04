<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Test Hexagon</title>
<link href="resources/style.css" rel="stylesheet" />
<body>
	<div class="login">
	
		<form method="POST" action="uploadPatch" enctype="multipart/form-data">
			Name of the patch: <input type="text"></br>
			Patch: <input type="file"><br/>
			<input type="submit" value="Upload">
		</form>
	</div>
	</body>
</html>