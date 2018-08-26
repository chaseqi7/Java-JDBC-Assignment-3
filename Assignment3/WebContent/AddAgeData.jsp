<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Age Data Form</title>
</head>
<body>
	<h1>Add New Age Data Form</h1>
	<form class="form-group" action="/Assignment3/NewAgeDataServlet" method="POST" style="width: 50%;
    padding: 2%;">
		<label for="ageId">Age Id:</label>
		<input type="number" name="ageId" class="form-control" >
		<br>
		<label for="ageGroup">Age Group:</label>
		<input type="number" name="ageGroup" class="form-control" >
		<br>
		<label for="censusYear">Census Year:</label>
		<input type="number" name="censusYear" class="form-control" >
		<br>
		<label for="geographicArea">Geographic Area:</label>
		<input type="text" name="geographicArea" class="form-control" >
		<br>
		<label for="combined">Combined:</label>
		<input type="number" name="combined" class="form-control" >
		<br>
		<label for="male">Male:</label>
		<input type="number" name="male" class="form-control" >
		<br>
		<label for="female">Female:</label>
		<input type="number" name="female" class="form-control" >
		<br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>