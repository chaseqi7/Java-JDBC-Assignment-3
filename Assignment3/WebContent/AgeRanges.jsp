<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Age Ranges</title>
</head>
<body>
	<h1>List of Age Ranges</h1>
	<table class="table table-striped">
		<c:forEach var="ageGroup" items="${requestScope.ageGroupList}">
			<tr>
				<td><a href="AgeGroupDetailsServlet?ageGroupID=${ageGroup.ageGroupID}">${ageGroup.description}</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>