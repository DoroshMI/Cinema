<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="/css/style.css" type="text/css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<title>Theater</title>
</head>

<body>
	<h1 class="text" style="text-align: center;">Welcome to theater of
		future</h1>
	<h2 style="text-align: center;">List Cinema</h2>



	<div class="row">
		<div class="col-xs-12 col-md-6">
			<h2 style="margin-left: 20px; color: red;">Cinemas</h2>
			<ol>
				<c:forEach var="cinema" items="${cinemas}">
					<li><a  href="/cinema/${cinema.id}">${cinema.name}</a>
						<div class="dropdown">
							<button  class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								action <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
								<li><a href="/cinema/${cinema.id}/change">change</a></li>
								<li><a href="/cinema/${cinema.id}/delete">delete</a></li>
								<li><a href="/cinema/${cinema.id}">choose</a></li>

							</ul>
						</div></li>
				</c:forEach>
			</ol>
			<br>
			<a href="/createCinema">Create cinema</a>
		</div>

		<div class="col-xs-12 col-md-6">
			<h2 style="margin-left: 20px; color: red;">Movies of theater</h2>

			<ol>
				<c:forEach var="movie" items="${movies}">
					<li><a href="/movie/${movie.id}">${movie.title}</a></li>
				</c:forEach>

			</ol>

<a href="/createMovie">Create movie</a>
		</div>
	</div>






	

</body>
</html>