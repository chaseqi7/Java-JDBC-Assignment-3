<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Geographic Area</title>
</head>
<body>
	<h1>Add New Geographic Area Form</h1>
	<form class="form-group" action="/Assignment3/NewGeographicAreaServlet" method="POST" style="width: 50%;
    padding: 2%;">
		<label for="geographicAreaId">Geographic Area Id:</label>
		<input type="number" name="geographicAreaId" class="form-control" >
		<br>
		<label for="code">Code:</label>
		<input type="number" name="code" class="form-control" >
		<br>
		<label for="Level">Level:</label>
		<input type="number" name="level" class="form-control" >
		<br>
		<label for="name">Name:</label>
		<input type="text" name="name" class="form-control" >
		<br>
		<label for="altCode">Alternative Code:</label>
		<input type="number" name="altCode" class="form-control" >
		<br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>