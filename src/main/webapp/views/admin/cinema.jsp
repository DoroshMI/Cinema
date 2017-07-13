<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | theater</title>

</head>

<body >

	<!-- -------------------------CENTER container begin----------------------------- -->
	<div style="margin: 15px;">

		<ol class="breadcrumb" style="margin-bottom: 5px;">
			<li><a href="/admin">Theater</a></li>
			<li class="active">Cinema (${currentCinema.name})</li>
			<li><a href="/cinemas/${currentCinema.id}/moviehalls/form">Create
					moviehall</a></li>
		</ol>



		<h1 style="text-align: center;">Welcome to CINEMA: ${cinema.name}</h1>



		<table class="table table-hover">
			<thead>
			<tr>

				<th>name moviehall</th>
				<th>rows</th>
				<th>columns</th>
				<th>technology</th>
				<th>choose</th>
				<th>update</th>
				<th>delete</th>

			</tr>
			</thead>
			<tbody>
			<c:forEach var="moviehall" items="${moviehalls}">
				<tr>
					<td>${moviehall.name}</td>
					<td>${moviehall.rows}</td>
					<td>${moviehall.columns}</td>
					<td>${moviehall.technology}</td>




					<td><a href="/moviehalls/${moviehall.id}">choose</a></td>
					<td><a href="/moviehalls/${moviehall.id}/form">update</a></td>
					<td><a href="/moviehalls/${moviehall.id}/delete">delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>



	</div>

	<!-- -------------------------CENTER container end----------------------------- -->

</body>


</html>