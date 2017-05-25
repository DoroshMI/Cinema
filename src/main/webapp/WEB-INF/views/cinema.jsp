<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="style.css">

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



	<h1 style="text-align: center;">Welcome to CINEMA: ${cinema.name}</h1>


	<div class="row">
		<div class="col-xs-12 col-md-6">
			<h2 style="margin-left: 20px; color: red;">Moviehall</h2>


			<ol>
				<c:forEach var="moviehall" items="${moviehalls}">
					<li><a href="/moviehall/${moviehall.id}">${moviehall.name}</a>

					</li>
				</c:forEach>

			</ol>


		</div>
		<div class="col-xs-12 col-md-6">
			<h2 style="margin-left: 20px; color: red;">Movies of cinema</h2>
			<a href="/movies">look at movies of cinema</a>
		</div>
	</div>





	<a href="/cinema/${cinema.id}/createMoviehall">Create moviehall</a>

	<br>
	<br>
	<a href="/">change cinema</a>

</body>
</html>