<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | theater</title>

</head>

<body>

	<div style="margin: 15px;">

		<ol class="breadcrumb" style="margin-bottom: 5px;">
			<li><a href="/admin">Theater with cinemas</a></li>
			<li class="active">Theater with all movies</li>
			<li><a href="/cinemas/form">Create cinema</a></li>
			<li><a href="/movies/form">Create movie</a></li>

		</ol>


		<!-- Right column -->



		<h2 style="margin-left: 20px; text-align: center;" class="red">Movies
			of theater</h2>










		<!-- List movies -->
		<div class="movies-list">

			<c:forEach var="movie" items="${movies}">
				<!-- Movie -->
				<div class="movie-block">
					<a class="movie-block__poster movie-block__poster_size_big"
						href="#"> <img src="#" alt="${movie.title}">
					</a>
					<div class="movie-block__info">
						<div class="movie-block__text movie-block__text_color_blue">
							<div class="movie-block__info-icon movie-block__info-icon_2d"></div>
							<div class="movie-block__text-date">
								${movie.showFromDate}|${movie.showToDate}</div>
						</div>

						<div class="movie-block__text movie-block__text_title" href="@">
							<div style="margin-left: 30px; margin-bottom: 20px;"
								role="separator" class="divider dropdown">
								<a href="/#" class="dropdown-toggle" data-toggle="dropdown"
									role="button" aria-haspopup="true" aria-expanded="false">
									${movie.title}</a>
								<ul class="dropdown-menu">
									<li><a href="/movies/${movie.id}">choose</a></li>
									<li><a href="/movies/${movie.id}/update">update</a></li>
									<li><a href="/movies/${movie.id}/delete">delete</a></li>

								</ul>
							</div>
						</div>
						<div
							class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass"></div>
					</div>
				</div>

			</c:forEach>

		</div>











	</div>


</body>


</html>