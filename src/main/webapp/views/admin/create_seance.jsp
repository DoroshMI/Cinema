<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | create seance</title>

</head>

<body>

	<div style="margin: 15px;">

		<h3 style="margin-top: -15px; text-align: right;">
			<a href="/admin">administration</a>
		</h3>

		<div class="form-horizontal">
			<div class="col-sm-2"></div>
			<h1>Add ceance in moviehall: ${moviehall.name} of
				${moviehall.cinema.name} for ${localDate.toString() }</h1>
		</div>


		<form:form modelAttribute="seance"
			action="/moviehalls/${moviehall.id}/seances/form"
			method="post" class="form-horizontal">


			<div class="form-group">
				<label for="inputDate" class="col-sm-2 control-label">date</label>
				<div class="col-sm-5">
					<input type="date" name="date" class="form-control" id="inputDate"
						   placeholder="yyyy-mm-dd" value="${localDate}">
				</div>
				<!-- error -->
				<label style="color: red; text-align: left;" class="col-sm-5 control-label"
					   for="inputDate">${seanceTimeException}</label>
			</div>



			<div class="form-group">
				<label for="inputTime" class="col-sm-2 control-label">Time
					of ceance</label>
				<div class="col-sm-5">
					<input type="time" name="time" class="form-control" id="inputTime"
						placeholder="hh:mm"/>
				</div>
				<!-- error -->
				<label style="color: red; text-align: left;" class="col-sm-5 control-label"
					   for="inputTime">${seanceTimeException}</label>
			</div>


			<div class="form-group">
				<label for="inputMovies" class="col-sm-2 control-label">Movies</label>
				<div class="col-sm-5">
					<select  name="movieId" id="inputMovies" class="form-control">
						<option value="${movie.id}">${movie.title}</option>
						<c:forEach var="movie" items="${movies}">
							<option value="${movie.id}">${movie.title}</option>
						</c:forEach>
					</select>
				</div>
				<!-- error -->
				<label style="color: red; text-align: left;" class="col-sm-5 control-label"
					   for="inputMovies">${seanceMovieException}</label>
			</div>

			<div class="form-group">
				<label for="inputPrice" class="col-sm-2 control-label">Price</label>
				<div class="col-sm-5">
					<form:input path="price" type="text" name="price" class="form-control"
						id="inputPrice" placeholder="price"/>
				</div>
				<!-- error -->
				<label style="color: red; text-align: left;" class="col-sm-5 control-label"
					   for="inputPrice">${seancePriceException}</label>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="submit" class="btn btn-default">create
						seance</button>
				</div>
				<!-- error -->
				<label style="color: red; text-align: left;" class="col-sm-5 control-label"
					   for="submit">${seanceScheduleException}</label>
			</div>

		</form:form>

		<br> <a href="/moviehalls/${moviehall.id}">come back</a>

	</div>
</body>


</html>