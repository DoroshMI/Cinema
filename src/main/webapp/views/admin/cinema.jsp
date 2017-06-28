<%@  page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IMAX | theater</title>

</head>

<body>

<!-- -------------------------CENTER container begin----------------------------- -->
<div style="margin: 15px;">

<ol class="breadcrumb" style="margin-bottom: 5px;">
			  <li><a href="/admin">Theater</a></li>
			  <li><a href="/admin/cinemas/${currentCinema.id}">Cinema</a></li>
			  <li class="active">Moviehall</li>
			</ol>
		

    <h3 style="margin-top: -15px; text-align: right;">
        <a href="/admin">administration</a>
    </h3>

    <h1 style="text-align: center;">Welcome to CINEMA: ${cinema.name}</h1>


    <div class="row">
        <!-- left column -->
        <div class="col-xs-12 col-md-6">
            <h2 style="margin-left: 20px; color: red;">Moviehall</h2>


            <div class="movies-list">


                <c:forEach var="moviehall" items="${moviehalls}">
                    <!-- Moviehall -->
                    <div class="movie-block">
                        <a class="movie-block__poster movie-block__poster_size_big"
                           href="/moviehalls/${moviehall.id}"> <img src="#"
                                                                    alt="${moviehall.name}">
                        </a>
                        <div class="movie-block__info">
                            <div class="movie-block__text movie-block__text_color_blue">
                                <div class="movie-block__info-icon movie-block__info-icon_2d"></div>
                                <div class="movie-block__text-date">technology:
                                        ${moviehall.technology}</div>
                            </div>

                            <div class="movie-block__text movie-block__text_title" href="#">
                                <div role="separator" class="divider dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                                       role="button" aria-haspopup="true" aria-expanded="false">
                                        action: ${moviehall.name}</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/moviehalls/${moviehall.id}">choose</a></li>
                                        <li><a href="/moviehalls/${moviehall.id}/form">update</a></li>
                                        <li><a href="/moviehalls/${moviehall.id}/delete">delete</a></li>

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


        <!-- right column -->
        <div class="col-xs-12 col-md-6">
            <h2 style="margin-left: 20px; color: red;">Movies of cinema</h2>
            <a href="/movies">look at movies of cinema</a>
        </div>
    </div>


    <a href="/cinemas/${cinema.id}/moviehalls/form">Create moviehall</a> <br>
    <br> <a href="/admin">change cinema</a>


</div>

<!-- -------------------------CENTER container end----------------------------- -->

</body>


</html>