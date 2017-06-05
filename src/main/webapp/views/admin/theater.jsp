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

		<h3 style="margin-top: -15px; text-align: right;">
			<a href="/admin">administration</a>
		</h3>
		<h1 class="text" style="text-align: center;">Welcome to IMAX
			theater</h1>
		<h2 style="text-align: center;">administration</h2>

		<div class="row">
			<!-- Left column -->
			<div style="border-right: 1px solid black;"
				class="col-xs-12 col-md-6">
				<h2 style="margin-left: 20px; text-align: center;" class="red">Cinemas</h2>

				<a style="margin-left: 30px" href="/cinemas/form">Create cinema</a>
				<br>

				<!-- List cinemas -->
				<div class="movies-list">

					<c:forEach var="cinema" items="${cinemas}">
						<!-- Cinema -->
						<div class="movie-block">
							<a class="movie-block__poster movie-block__poster_size_big"
								href="/cinemas/${cinema.id}"> <img src="#"
								alt="${cinema.name}">
							</a>
							<div class="movie-block__info">
								<div class="movie-block__text movie-block__text_color_blue">
									<div class="movie-block__info-icon movie-block__info-icon_2d"></div>
									<div class="movie-block__text-date">city:
										${cinema.address.city}</div>
								</div>

								<div class="movie-block__text movie-block__text_title"
									href="/cinemas/${cinema.id}">
									<div role="separator" class="divider dropdown">
										<a href="/cinemas/${cinema.id}" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-haspopup="true"
											aria-expanded="false"> action: ${cinema.name}</a>
										<ul class="dropdown-menu">
											<li><a href="/cinemas/${cinema.id}">choose</a></li>
											<li><a href="/cinemas/${cinema.id}/form">update</a></li>
											<li><a href="/cinemas/${cinema.id}/delete">delete</a></li>

										</ul>
									</div>
								</div>
								<div
									class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass"></div>
							</div>
						</div>

					</c:forEach>

				</div>

				<br> <a style="margin-left: 30px" href="/cinemas/form">Create
					cinema</a>

			</div>

			<!-- Right column -->
			<div class="col-xs-12 col-md-6">
				<h2 style="margin-left: 20px; text-align: center;" class="red">Movies
					of theater</h2>

				<a style="margin-left: 30px" href="/createMovie">Create movie</a>

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
											<li><a href="/movie/${movie.id}">choose</a></li>
											<li><a href="/movie/${movie.id}/update">update</a></li>
											<li><a href="/movie/${movie.id}/delete">delete</a></li>

										</ul>
									</div>
								</div>
								<div
									class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass"></div>
							</div>
						</div>

					</c:forEach>

				</div>


				<a style="margin-left: 30px" href="/createMovie">Create movie</a>
			</div>
		</div>

	</div>
</body>


</html>