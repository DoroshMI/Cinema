<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | theater</title>

</head>

<body>

	<div style="margin: 15px;">


		<ol class="breadcrumb" style="margin-bottom: 5px;">
			<li class="active">Theater with cinemas</li>
			<li><a href="/admin2">Theater with all movies</a></li>
			<li><a href="/cinemas/form">Create cinema</a></li>
			<li><a href="/movies/form">Create movie</a></li>

		</ol>






		<h2 style="margin-left: 20px; text-align: center;" class="red">Cinemas</h2>






		<table class="table table-hover">
			<thead>
				<tr>
					<th>image</th>
					<th>name</th>
					<th>city</th>
					<th>street</th>
					<th>choose</th>
					<th>update</th>
					<th>delete</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="cinema" items="${cinemas}">
					<tr>
						<td><a href="/admin/cinemas/${cinema.id}"><img
								src="${drink.pathImage}" alt="${cinema.name}" height="100px"
								width="75px"></a></td>
						<td>${cinema.name}</td>
						<td>${cinema.address.city}</td>
						<td>${cinema.address.city}</td>

						<td><a href="/admin/cinemas/${cinema.id}">choose</a></td>
						<td><a href="/cinemas/${cinema.id}/form">update</a></td>
						<td><a href="/cinemas/${cinema.id}/delete">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>


</html>