<%@  page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/style.css">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <title>IMAX | theater</title>
</head>

<body>

<!-- HADER container begin -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="row">
            <div class="d col-xs-12 col-sm-8 col-md-8">


                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed"
                                data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span> <span
                                class="icon-bar"></span> <span class="icon-bar"></span> <span
                                class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="/"><img class="img-logo" src="/image/logo.png"></a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse"
                         id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="schedule.html">Розклад</a></li>
                            <li><a href="/movies/">Фільми</a>
                            </li>
                            <li><a href="https://planetakino.ua/lvov/imax/">IMAX</a></li>


                            <li role="separator" class="divider dropdown"><a
                                    href="https://planetakino.ua/lvov/apps/#"
                                    class="dropdown-toggle" data-toggle="dropdown" role="button"
                                    aria-haspopup="true" aria-expanded="false">...</a>
                                <ul class="dropdown-menu">

                                    <li class="addon-menu__list-item"><a
                                            href="https://planetakino.ua/lvov/theatres/">Кінотеатри</a></li>
                                    <li class="addon-menu__list-item"><a
                                            href="https://planetakino.ua/lvov/about/faq/">Допомога.
                                        Відповіді на запитання</a></li>
                                    <li class="addon-menu__list-item"><a
                                            href="https://planetakino.ua/lvov/i/sale/">Знижки</a></li>
                                    <li class="addon-menu__list-item"><a
                                            href="https://planetakino.ua/lvov/i/gift-certificate/">Подарунковий
                                        сертифікат</a></li>
                                    <li class="addon-menu__list-item"><a
                                            href="https://planetakino.ua/lvov/apps/">Мобільний додаток</a></li>
                                    <li class="addon-menu__list-item"><a
                                            href="https://planetakino.ua/lvov/events/">Новини</a></li>
                                    <li class="addon-menu__list-item"><a
                                            href="https://planetakino.ua/lvov/about/">Про Планету Кіно</a></li>
                                    <li class="addon-menu__list-item"><a
                                            href="https://planetakino.ua/lvov/about/vacancy/">Робота у
                                        нас</a></li>
                                </ul>
                            </li>
                        </ul>

                    </div>


                </div>


            </div>

            <div class="d col-xs-12 col-sm-4 col-md-4">
                <div class="container-fluid">
                    <div class="row">


                        <ul class="nav nav-pills navbar-right">

                            <!-- Choose cinema-->
                            <li role="separator" class="divider dropdown">
                                <a href="https://planetakino.ua/lvov/apps/#"
                                   class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-haspopup="true" aria-expanded="false">Cinema: ${cinema.name}</a>
                                <ul class="dropdown-menu">

                                    <c:forEach items="${cinemas}" var="c">
                                        <li class="addon-menu__list-item"><a href="/cinema/${c.id}/movies">${c.name}</a>
                                        </li>
                                    </c:forEach>

                                </ul>
                            </li>


                            <!-- Registration-->
                            <li role="presentation" class="dropdown"><a
                                    class="dropdown-toggle" data-toggle="dropdown" href="#"
                                    role="button" aria-haspopup="true" aria-expanded="false">
                                Вхід <span class="caret"></span>
                            </a>
                                <ul class="dropdown-menu">
                                    <li><a href="/login">Вхід</a></li>
                                    <li><a href="/signup" class="register-link">
                                        Реєстрація </a></li>
                                </ul>
                            </li>

                        </ul>


                    </div>

                </div>


            </div>
        </div>

    </div>
</nav>
<!-- ROW HADER container end -->


<!-- -------------------------CENTER container begin----------------------------- -->


<br>

<main class="main-body">


    <header class="slider-block slider-block-fade slider-block-main carousel slide" id="slider-block-main"
            data-ride="carousel" data-pause="hover" data-interval="10000">


        <div class="slider-block__carousel-inner carousel-inner">


            <div class="slider-block__item item  movieid-2110">
                <div class="slider-block__carousel-caption carousel-caption">
                    <div class="row">
                        <div class="col-sm-6 col-xs-12">
                            <!-- add to wishlist begin -->
                            <div class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass movie-block__info-icon_wishlist-slider"></div>
                            <!-- add to wishlist end -->
                            <a class="slider-block__movie-title"
                               href="https://planetakino.ua/lvov/movies/pirates_of_the_caribbean_dead_men_tell_no_tales/">Пірати
                                Карибського моря: Помста Салазара<span class="slider-block__movie-original-title">Pirates of the Caribbean: Dead Men Tell No Tales</span></a>
                        </div>
                        <div class="col-sm-6 col-xs-12">
                            <a class="slider-block__btn"
                               href="https://planetakino.ua/lvov/movies/pirates_of_the_caribbean_dead_men_tell_no_tales/">Придбати
                                квиток</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="slider-block__item item  movieid-2544 active" data-movieid="2544"
                 style="background-image: url(&#39;/f/1/movies/pirates_of_the_caribbean_dead_men_tell_no_tales_original/Pirates-of-the-Caribbean-afisha2.jpg&#39;);">
                <div class="slider-block__carousel-caption carousel-caption">
                    <div class="row">
                        <div class="col-sm-6 col-xs-12">
                            <!-- add to wishlist begin -->
                            <div class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass movie-block__info-icon_wishlist-slider"
                                 data-filmid="2544"></div>
                            <!-- add to wishlist end -->
                            <a class="slider-block__movie-title"
                               href="https://planetakino.ua/lvov/movies/pirates_of_the_caribbean_dead_men_tell_no_tales_original/">Pirates
                                of the Caribbean: Dead Men Tell No Tales (мовою оригіналу)<span
                                        class="slider-block__movie-original-title">Pirates of the Caribbean: Dead Men Tell No Tales</span></a>
                        </div>
                        <div class="col-sm-6 col-xs-12">
                            <a class="slider-block__btn"
                               href="https://planetakino.ua/lvov/movies/pirates_of_the_caribbean_dead_men_tell_no_tales_original/">Придбати
                                квиток</a>
                        </div>
                    </div>
                </div>
            </div>


        </div>


        <!-- Left and right controls -->
        <a class="slider-block__carousel-control slider-block__carousel-control-left vertical-center left carousel-control"
           href="https://planetakino.ua/lvov/#slider-block-main" role="button" data-slide="prev">
            <span class="zmdi zmdi-chevron-left zmdi-hc-2x" aria-hidden="true"></span>
            <span class="sr-only">Попередній</span>
        </a>
        <a class="slider-block__carousel-control slider-block__carousel-control-right vertical-center right carousel-control"
           href="https://planetakino.ua/lvov/#slider-block-main" role="button" data-slide="next">
            <span class="zmdi zmdi-chevron-right zmdi-hc-2x" aria-hidden="true"></span>
            <span class="sr-only">Наступний</span>
        </a>
    </header>

    <!-- Movies in show -->
    <div id="content" class="content">

        <div class="content__section">
            <div class="movie-top-stripe">
                <h1 class="movie-list-title">Планета Кіно у Львові (King Cross Leopolis): сьогодні у кіно</h1>
                <div class="movie-count">10 фільмів</div>
            </div>

            <div class="description_content"></div>

            <!-- List of Movies in show -->
            <div class="movies-list">

                <div class="movie-block">
                    <a class="movie-block__poster movie-block__poster_size_big"
                       href="#">
                        <img src="./index_files/pirats1-big.jpg" alt="Пірати Карибського моря: Помста Салазара">
                    </a>
                    <div class="movie-block__info">
                        <div class="movie-block__text movie-block__text_color_blue">
                            <div class="movie-block__info-icon movie-block__info-icon_2d"></div>
                            <div class="movie-block__text-date">до 28.06.17</div>
                        </div>

                        <a class="movie-block__text movie-block__text_title"
                           href="https://planetakino.ua/lvov/movies/pirates_of_the_caribbean_dead_men_tell_no_tales/">
                            Пірати Карибського моря: Помста Салазара </a>
                        <div class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass"></div>
                    </div>
                </div>

                <div class="movie-block">
                    <a class="movie-block__poster movie-block__poster_size_big"
                       href="https://planetakino.ua/lvov/movies/pirates_of_the_caribbean_dead_men_tell_no_tales/">
                        <img src="./index_files/pirats1-big.jpg" alt="Пірати Карибського моря: Помста Салазара">
                    </a>
                    <div class="movie-block__info">
                        <div class="movie-block__text movie-block__text_color_blue">
                            <div class="movie-block__info-icon movie-block__info-icon_2d"></div>
                            <div class="movie-block__text-date">до 28.06.17</div>
                        </div>

                        <a class="movie-block__text movie-block__text_title"
                           href="https://planetakino.ua/lvov/movies/pirates_of_the_caribbean_dead_men_tell_no_tales/">
                            Пірати Карибського моря: Помста Салазара </a>
                        <div class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass"></div>
                    </div>
                </div>

            </div>



        </div>


        <div class="content__section content__section_s1 " id="moviesoon">

            <span class="movie-list-title">Скоро на екранах</span>
            <a href="https://planetakino.ua/movies" target="_blank" class="movie-count">Інші фільми (116)</a>

            <div class="movies-list">

                <div class="movie-block" data-movieid="2393">
                    <a class="movie-block__poster movie-block__poster_size_big"
                       href="https://planetakino.ua/lvov/movies/baywatch/">
                        <img src="./index_files/BAYW-poster-big.jpg" alt="Рятувальники Малібу">
                    </a>
                    <div class="movie-block__info">
                        <div class="movie-block__text movie-block__text_color_blue">
                            <div class="movie-block__info-icon movie-block__info-icon_2d"></div>
                            <div class="movie-block__text-date">
                                з 01.06.2017
                            </div>
                        </div>
                        <%--<div class="movie-block__text movie-block__text_tech">--%>
                        <%--<div class="movie-block__info-icon movie-block__info-icon_relux "></div>--%>
                        <%--<div class="movie-block__info-icon movie-block__info-icon_imax "></div>--%>
                        <%--<div class="movie-block__info-icon movie-block__info-icon_4dx "></div>--%>
                        <%--<div class="movie-block__info-icon movie-block__info-icon_cinetech movie-block__info-icon_active"></div>--%>
                        <%--</div>--%>
                        <a class="movie-block__text movie-block__text_title"
                           href="https://planetakino.ua/lvov/movies/baywatch/">
                            Рятувальники Малібу </a>
                        <div class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass"
                        >
                        </div>
                    </div>
                </div>

                <div class="movie-block" data-movieid="2591">
                    <a class="movie-block__poster movie-block__poster_size_big"
                       href="https://planetakino.ua/lvov/movies/deep/">
                        <img src="./index_files/Deep-poster1-big.jpg" alt="Підводна ера">
                    </a>
                    <div class="movie-block__info">
                        <div class="movie-block__text movie-block__text_color_blue">
                            <div class="movie-block__info-icon movie-block__info-icon_2d"></div>
                            <div class="movie-block__text-date">
                                з 01.06.2017
                            </div>
                        </div>
                        <div class="movie-block__text movie-block__text_tech">
                            <div class="movie-block__info-icon movie-block__info-icon_relux "></div>
                            <div class="movie-block__info-icon movie-block__info-icon_imax "></div>
                            <div class="movie-block__info-icon movie-block__info-icon_4dx "></div>
                            <div class="movie-block__info-icon movie-block__info-icon_cinetech movie-block__info-icon_active"></div>
                        </div>
                        <a class="movie-block__text movie-block__text_title"
                           href="https://planetakino.ua/lvov/movies/deep/">
                            Підводна ера </a>
                        <div class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass"
                             data-filmid="2591"
                             data-noshowtimes="true"
                        "="">
                    </div>
                </div>



            </div>


        </div>

    </div>






</main>


<h1 style="text-align: center;">All movies of theater</h1>


<ol>
    <c:forEach var="movie" items="${movies}">
        <li>
            <a href="/movie/${movie.id}">${movie.title}</a>

        </li>
    </c:forEach>

</ol>


<a href="/createMovie">Create movie</a>

<br>
<br>
<a href="/">main page</a>


<!-- -------------------------CENTER container end----------------------------- -->


<!-- FOOTER container begin, TODO: please create component -->
<footer id="footer" class="footer"> <!-- DESCRIPTION BOX begin -->
    <div class="description-box">
        <div class="description-box__title" data-toggle="Сховати опис">Читати
            опис
        </div>
        <div class="description-box__wrapper" style="display: none;"></div>
    </div>

    <div class="copyright-and-contacts">
        <a href="mailto:info@planetakino.ua">info@planetakino.ua</a>
        <p>Всі звернення, надіслані на цю пошту, потраплять до власників
            та керівництва Планети Кіно</p>
    </div>

    <div class="search right-panel">
        <div class="reducer">
            <!--form object-id="114">
  <input type="search" name="q" placeholder="пошук" />
</form-->
            <div class="footer-contacts">
                <a href="tel:0800300600"><h3>0 800 300 600</h3></a>
                <p>
                    Щоденно, 9:00—22:00 <br>Безкоштовно по Україні з будь-якого
                    номеру
                </p>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</footer>
<!-- FOOTER container the end -->

</body>
</html>
