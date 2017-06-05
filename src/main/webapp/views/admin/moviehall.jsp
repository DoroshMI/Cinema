<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | moviehall</title>

</head>

<body>
	<div style="margin: 15px;">

		<h3 style="margin-top: -15px; text-align: right;">
			<a href="/admin">administration</a>
		</h3>

		<h1 style="text-align: center;">Moviehall ${moviehall.name} of
			${moviehall.cinema.name}</h1>


		<h2 style="margin-left: 20px; color: red;">all seances</h2>

		<ol>
			<c:forEach var="seance" items="${seancesOfMoviehall}">
				<li><a href="/seances/${seance.id}">${seance.startTime}</a></li>
			</c:forEach>

		</ol>


		<a href="/cinema/${moviehall.cinema.id}">Change moviehall</a> <br>





		<form action="/moviehall/${moviehall.id}/seances/form" method="get"
			class="form-horizontal">
			<div class="form-group">
				<label for="inputDate" class="col-sm-2 control-label">date</label>
				<div class="col-sm-5">
					<input type="date" name="date" class="form-control" id="inputDate"
						placeholder="yyyy-mm-dd">
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">create
						seance</button>
				</div>
			</div>
		</form>

	</div>

</body>


</html>