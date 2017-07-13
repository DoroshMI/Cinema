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
	
	<ol class="breadcrumb" style="margin-bottom: 5px;">
			  <li><a href="/admin">Theater</a></li>
			  <li> <a href="/admin/cinemas/${currentCinema.id }">Cinema (${currentCinema.name})</a></li>
			  <li class="active">Create moviehall</li>
			</ol>
		

		

		<div class="form-horizontal">
			<div class="col-sm-2"></div>
			<h1>Створення кінозалу в кінотеатрі: ${currentCinema.name}</h1>
		</div>




		<form:form modelAttribute="moviehall"
			action="/cinemas/${currentCinema.id}/moviehalls/${moviehall.id}/form"
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
					<form:input  path="rows" type="text" required="true"  pattern="[0-9]" name="rows"
						class="form-control" id="inputRows" placeholder="rows" />
				</div>
			</div>

			<div class="form-group">
				<label for="inputColumns" class="col-sm-2 control-label">Columns</label>
				<div class="col-sm-5">
					<form:input path="columns" type="text" pattern="[0-9]" name="columns"
						class="form-control" id="inputcolumns" placeholder="columns" />
				</div>
			</div>




			<!-- technology select -->
			<div class="form-group">
				<label class="col-sm-2 control-label">Technology</label>
				<div class = "col-sm-5">

					<form:select path="technology" items="${technologies}" id="technology" name="technology"
								 class="form-control" />
				</div>
			</div>





			<div id="button-form-group"class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">create/update
						moviehall</button>

				</div>
				<label for="button-form-group" style="color: red; text-align: left;"
					   class="col-sm-5 control-label" >${exception}</label>
			</div>
			<!-- error -->

		</form:form>



	</div>
</body>


</html>