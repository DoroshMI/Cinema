<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | movies</title>

</head>

<body>
	<div style="margin: 15px;">

		<main class="main-body"> <!-- All Movies -->
		<div id="content" class="content">

			<!-- Movies in show -->
			<div class="content__section">
				<div class="movie-top-stripe">
					<h1 class="movie-list-title">${currentCinema.name} : сьогодні у
						кіно</h1>

					<c:choose>
						<c:when test="${moviesInShow.size() == 0}">
							<h3 style="color: red">На даний момент кінотеатр не має
								фільми в показі</h3>
						</c:when>
						<c:otherwise>
							<div class="movie-count">${moviesInShow.size()} фільмів</div>
						</c:otherwise>
					</c:choose>


				</div>

				<div class="description_content"></div>

				<!-- List of Movies in show -->
				<div class="movies-list">






					<c:forEach var="movie" items="${moviesInShow}">

						<div class="movie-block">
							<a class="movie-block__poster movie-block__poster_size_big"
								href="/cinemas/${currentCinema.id}/movies/${movie.id}"> <img
								src="./index_files/pirats1-big.jpg" alt=" ${movie.title}">
							</a>
							<div class="movie-block__info">
								<div class="movie-block__text movie-block__text_color_blue">
									<div class="movie-block__info-icon movie-block__info-icon_2d"></div>
									<div class="movie-block__text-date">до ${movie.showToDate }</div>
								</div>

								<a class="movie-block__text movie-block__text_title"
									href="/cinemas/${currentCinema.id}/movies/${movie.id}">
									${movie.title} </a>
								<div
									class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass"></div>
							</div>
						</div>



					</c:forEach>


				</div>


			</div>

			<!-- Soon -->
			<div class="content__section content__section_s1 " id="moviesoon">

				<span class="movie-list-title">Скоро на екранах</span>

				<c:choose>
					<c:when test="${moviesInFuture.size() == 0}">
						<h3 style="color: red">На даний момент кінотеатр не має
							фільми для майбутнього показу</h3>
							${moviesInFuture.size()}

					</c:when>
					<c:otherwise>
						<div class="movie-count"> інші фільми (${moviesInFuture.size()}) </div>
							
					</c:otherwise>

				</c:choose>



				<div class="movies-list">

					<c:forEach var="movie" items="${moviesInFuture}">


						<div class="movie-block" data-movieid="2393">
							<a class="movie-block__poster movie-block__poster_size_big"
								href="/cinemas/${currentCinema.id}/movies/${movie.id}"> <img
								src="./index_files/BAYW-poster-big.jpg"
								alt="${movie.title }">
							</a>
							<div class="movie-block__info">
								<div class="movie-block__text movie-block__text_color_blue">
									<div class="movie-block__info-icon movie-block__info-icon_2d"></div>
									<div class="movie-block__text-date">з ${movie.showFromDate }</div>
								</div>

								<a class="movie-block__text movie-block__text_title"
									href="/cinemas/${currentCinema.id}/movies/${movie.id}">
									${movie.title }</a>
								<div
									class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass">
								</div>
							</div>
						</div>


					</c:forEach>


				</div>

			</div>
		</main>

	</div>
</body>


</html>

