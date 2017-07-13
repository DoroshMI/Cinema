<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | create seance</title>

</head>

<body>

	<div style="margin: 15px;">


		<ol class="breadcrumb" style="margin-bottom: 5px;">
			<li><a href="/admin">Theater</a></li>
			<li><a href="/admin/cinemas/${currentCinema.id }">Cinema
					(${currentCinema.name})</a></li>
			<li><a href="/moviehalls/${moviehall.id}">Moviehall (${moviehall.name})</a></li>
			<li class="active"><a href="/admin/moviehalls/${moviehall.id}/seances">Show
					seances</a></li>
			<li class="active">Create seances</li>
		</ol>


		<div class="form-horizontal">
			<div class="col-sm-2"></div>
			<h1>Add ceance in moviehall: ${moviehall.name} of
				${moviehall.cinema.name} for ${localDate.toString() }</h1>
		</div>


		<form:form modelAttribute="seanceDTO"
			action="/moviehalls/${moviehall.id}/seances/form" method="post"
			class="form-horizontal">


			<div class="form-group">
				<label for="inputDate" class="col-sm-2 control-label">date</label>
				<div class="col-sm-5">
					<form:input type="text" path="date" pattern="[0-9-]{10}" class="form-control" id="inputDate"
						placeholder="yyyy-mm-dd"/>
				</div>

			</div>



			<div class="form-group">
				<label for="inputTime" class="col-sm-2 control-label">Time
					of ceance</label>
				<div class="col-sm-5">
					<form:input type="time" path="time" pattern="[0-9:]{5}" min="09:00" max="23:59" class="form-control" id="inputTime"
						placeholder="hh:mm" />
				</div>

			</div>


			<div class="form-group">
				<label for="inputMovies" class="col-sm-2 control-label">Movies</label>
				<div class="col-sm-5">

					<%--<form:select path="movieId" items="${movies}" id="movieId" name="movieId"--%>
								 <%--class="form-control" />--%>


					<form:select path="movieId" id="inputMovies" class="form-control">

						<c:forEach var="movie" items="${movies}">
							<c:choose>
								<c:when test="${movie.id == seanceDTo.movieId}">
									<form:option value="${movie.id}">${movie.title}</form:option>
								</c:when>
							</c:choose>
						</c:forEach>

						<c:forEach var="movie" items="${movies}">
							<c:choose>
								<c:when test="${movie.id != seanceDTo.movieId}">
									<form:option value="${movie.id}">${movie.title}</form:option>
								</c:when>
							</c:choose>
						</c:forEach>

						<%--<c:forEach var="movie" items="${movies}">--%>
							<%--<option value="${movie.id}">${movie.title}</option>--%>
						<%--</c:forEach>--%>
					</form:select>
				</div>

			</div>

			<div class="form-group">
				<label for="inputPrice" class="col-sm-2 control-label">Price</label>
				<div class="col-sm-5">
					<form:input path="price" pattern="[0-9]{1,3}" type="text" name="price"
						class="form-control" id="inputPrice" placeholder="price" />
				</div>

			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="submit" class="btn btn-default">create
						seance</button>
				</div>
				<!-- error -->
				<label style="color: red; text-align: left;"
					class="col-sm-5 control-label" for="submit">${exception}</label>
			</div>

		</form:form>



	</div>


	<%--<script>--%>
		<%--function validator() {--%>
			<%--if--%>
        <%--}--%>


	<%--</script>--%>
</body>


</html>