<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | admine-moviehall</title>

</head>

<body>


	<div style="margin: 15px;">


		<ol class="breadcrumb" style="margin-bottom: 5px;">
			<li><a href="/admin">Theater</a></li>
			<li><a href="/admin/cinemas/${currentCinema.id }">Cinema
					(${currentCinema.name})</a></li>
			<li class="active">Moviehall (${moviehall.name})</li>
			<li><a href="/admin/moviehalls/${moviehall.id}/seances">Show
					seances</a></li>
			<li><a href="/moviehalls/${moviehall.id}/seances/form">Create
					seances</a></li>
		</ol>


		<div class="row">
			<!-- Seats -->
			<div class="col-xs-12 col-md-8">


				<div class="seatSelection col-lg-12">

					<p class="seatSection">
						-------------------------------------------------<br> екран
					</p>


					<!-- Schema seats -->
					<div class="seatsChart">

						<c:forEach items="${allSeats }" var="rowSeats">

							<div class="seatRow">
								<div class="seatRowNumber">Row ${rowSeats[0].row}</div>
								<c:forEach items="${rowSeats}" var="seat">


									<div style="margin-right: 5px;"
										class=" seatNumber seatUnavailable">${seat.column}</div>

								</c:forEach>

							</div>

						</c:forEach>

					</div>

				</div>

			</div>


			<!-- Left column -->
			<div class="col-xs-12 col-md-4">

				<div class="col-zal-right" style="padding-top: 0px">

					<h2>${currentCinema.name}</h2>
					<p>Address:</p>
					<p>
						<strong>${currentCinema.address.addressLine}</strong>
					</p>
					<p>
						<strong>${currentCinema.address.city}</strong>
					</p>

					<p style="margin-top: 20px">Tehnology:</p>
					<div class="film_tehnology">
						<p>${moviehall.technology }</p>

					</div>




					<a id="btn-bye-tickets"
						href="/admin/moviehalls/${moviehall.id}/seances"
						class="batton batton2">Переглянути сеанси</a> 
						
						
					<a id="btn-bye-tickets"
						href="/moviehalls/${moviehall.id}/seances/form"
						class="batton batton2">Cтворити сеанси</a>

				</div>

			</div>





		</div>
</body>


</html>