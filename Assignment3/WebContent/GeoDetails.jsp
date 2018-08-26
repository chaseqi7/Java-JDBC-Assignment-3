<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Geographic Details</title>
</head>
<body>
	<h1>Geographic Details Page</h1>
	
	<h3>Geographic Area Id: ${requestScope.geoAreaId}</h3>
	<h3>Code: ${requestScope.code}</h3>
	<h3>Level: ${requestScope.level}</h3>
	<h3>Name: ${requestScope.name}</h3>
	<h3>Alternative Code: ${requestScope.altCode}</h3>
	
	<br>
	<p>2011 Output: ${requestScope.output2011}</p>
	<p>2016 Output: ${requestScope.output2016}</p>
</body>
</html>