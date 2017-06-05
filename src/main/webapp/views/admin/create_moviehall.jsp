<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | create miviehall</title>

</head>

<body>

	<div style="margin: 15px;">

		<h3 style="margin-top: -15px; text-align: right;">
			<a href="/admin">administration</a>
		</h3>

		<div class="form-horizontal">
			<div class="col-sm-2"></div>
			<h1>Створення кінозалу в кінотеатрі: ${cinema.name}</h1>
		</div>




		<form:form modelAttribute="moviehall"
			action="/cinemas/${cinema.id}/moviehalls/${moviehall.id}/form"
			method="post" class="form-horizontal">
			<div class="form-group">
				<label for="inputNameMoviehall" class="col-sm-2 control-label">Name
					moviehall</label>
				<div class="col-sm-5">
					<form:input path="name" type="text" name="moviehallname"
						class="form-control" id="inputNameMoviehall"
						placeholder="name moviehall" />
				</div>
			</div>

			<div class="form-group">
				<label for="inputRows" class="col-sm-2 control-label">Rows</label>
				<div class="col-sm-5">
					<form:input path="rows" type="text" name="rows"
						class="form-control" id="inputRows" placeholder="rows" />
				</div>
			</div>

			<div class="form-group">
				<label for="inputColumns" class="col-sm-2 control-label">Columns</label>
				<div class="col-sm-5">
					<form:input path="columns" type="text" name="columns"
						class="form-control" id="inputcolumns" placeholder="columns" />
				</div>
			</div>




			<!-- technology select -->
			<div class="form-group">
				<label class="col-sm-2 control-label">Technology</label>
				<div class = "col-sm-5">
					<form:select path="technology" name="technology"
						class=" form-control">

						<option value="${moviehall.technology.name()}" selected="selected">${moviehall.technology.name()}</option>

						<c:forEach var="technology" items="${technologies}">
							<option value="${technology.name()}">${technology.name()}</option>
						</c:forEach>

					</form:select>
				</div>
			</div>





			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">create/update
						moviehall</button>
				</div>
			</div>
		</form:form>

		<br> <br> <br> <a href="/cinemas/${cinema.id}">to
			cinema</a>

	</div>
</body>


</html>