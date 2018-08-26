<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Household Form</title>
</head>
<body>
	<h1>Add New Household Form</h1>
	<form class="form-group" action="/Assignment3/NewHouseholdServlet" method="POST" style="width: 50%;
    padding: 2%;">
		<label for="id">Household Id:</label>
		<input type="number" name="id" class="form-control" >
		<br>
		<label for="geographicArea">Geographic Area:</label>
		<input type="number" name="geographicArea" class="form-control" >
		<br>
		<label for="censusYear">Census Year:</label>
		<input type="number" name="censusYear" class="form-control" >
		<br>
		<label for="householdType">Household Type:</label>
		<input type="text" name="householdType" class="form-control" >
		<br>
		<label for="householdSize">Household Size:</label>
		<input type="number" name="householdSize" class="form-control" >
		<br>
		<label for="householdByAgeRange">Male:</label>
		<input type="number" name="male" class="form-control" >
		<br>
		<label for="female">Household By Age Range:</label>
		<input type="number" name="householdByAgeRange" class="form-control" >
		<br>
		<label for="householdEarners">Household Earners:</label>
		<input type="number" name="householdEarners" class="form-control" >
		<br>
		<label for="totalIncome">Total Income:</label>
		<input type="number" name="totalIncome" class="form-control" >
		<br>
		<label for="numberReported">Number Reported:</label>
		<input type="number" name="numberReported" class="form-control" >
		<br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>