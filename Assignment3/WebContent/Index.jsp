<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Geographic Area List</title>
</head>
<body>
  <ul>
  	<li><a href="GeographicAreasServlet">Geographic Areas</a></li>
  	<li><a href="PopulationGrowthServlet">AgeGroup List</a></li>
  	<li><a href="NewGeographicAreaServlet">New Geographic Area Form</a></li>
  	<li><a href="NewAgeDataServlet">New Age Data Form</a></li>
  	<li><a href="NewHouseholdServlet">New Household Form</a></li>
  </ul>
	
	<h1>${requestScope.title}</h1>
	<table class="table table-striped">
		<c:forEach var="area" items="${requestScope.listGeo}">
			<tr>
				<td><a href="GeographicDetailsServlet?geographicAreaId=${area.geographicAreaId}&code=${area.code}&level=${area.level}&name=${area.name}&alternativeCode=${area.alternativeCode}">${area.name}</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>