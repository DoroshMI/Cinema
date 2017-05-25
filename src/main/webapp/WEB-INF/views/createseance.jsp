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


<title>Create ceance</title>
</head>

<body>



	<div class="form-horizontal">
		<div class="col-sm-2"></div>
		<h1>Add ceance in moviehall: ${moviehall.name} of
			${moviehall.cinema.name} for ${localDate.toString() }</h1>
	</div>





	<form action="/moviehall/${moviehall.id}/${localDate.toString() }/saveSeance" method="post"
		class="form-horizontal">
		<div class="form-group">
			<label for="inputTime" class="col-sm-2 control-label">Time of
				ceance</label>
			<div class="col-sm-5">
				<input type="time" name="time" class="form-control" id="inputTime"
					placeholder="hh:mm">
			</div>
		</div>



		<div class="form-group">
			<label for="inputMovies" class="col-sm-2 control-label">Movies</label>
			<div class="col-sm-5">
				<select name="movieId">
					<option value="${movie.id}">${movie.title}</option>
					<c:forEach var="movie" items="${movies}">
						<option value="${movie.id}">${movie.title}</option>
					</c:forEach>
				</select>

			</div>
		</div>
		
		<div class="form-group">
			<label for="inputPrice" class="col-sm-2 control-label">Price</label>
			<div class="col-sm-5">
				<input type="text" name="price" class="form-control" id="inputPrice"
					placeholder="price">
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">create
					seance</button>
			</div>
		</div>
	</form>

	<br>
	<br>
	<br>


<a href="/moviehall/${moviehall.id}">come back</a>

</body>
</html>