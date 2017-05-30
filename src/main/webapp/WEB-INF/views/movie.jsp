
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
                            <li  role="separator" class="divider dropdown">
                                <a href="https://planetakino.ua/lvov/apps/#"
                                   class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-haspopup="true" aria-expanded="false">Cinema: ${cinema.name}</a>
                                <ul class="dropdown-menu">

                                    <c:forEach items="${cinemas}" var="c">
                                        <li  class="addon-menu__list-item"><a href="/cinema/${c.id}">${c.name}</a></li>
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














<%--<%@  page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>


<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>

<%--<html>--%>

<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
    <%--<link rel="stylesheet" href="css/style.css">--%>

    <%--<!-- Latest compiled and minified CSS -->--%>
    <%--<link rel="stylesheet"--%>
          <%--href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"--%>
          <%--integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"--%>
          <%--crossorigin="anonymous">--%>
    <%--<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>--%>

    <%--<!-- Latest compiled and minified JavaScript -->--%>
    <%--<script--%>
            <%--src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"--%>
            <%--integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"--%>
            <%--crossorigin="anonymous"></script>--%>

    <%--<title>IMAX | theater</title>--%>
<%--</head>--%>

<%--<body>--%>

<%--<!-- HADER container begin -->--%>
<%--<nav class="navbar navbar-default">--%>
    <%--<div class="container-fluid">--%>
        <%--<div class="row">--%>
            <%--<div class="d col-xs-12 col-sm-8 col-md-8">--%>


                <%--<div class="container-fluid">--%>
                    <%--<!-- Brand and toggle get grouped for better mobile display -->--%>
                    <%--<div class="navbar-header">--%>
                        <%--<button type="button" class="navbar-toggle collapsed"--%>
                                <%--data-toggle="collapse"--%>
                                <%--data-target="#bs-example-navbar-collapse-1" aria-expanded="false">--%>
                            <%--<span class="sr-only">Toggle navigation</span> <span--%>
                                <%--class="icon-bar"></span> <span class="icon-bar"></span> <span--%>
                                <%--class="icon-bar"></span>--%>
                        <%--</button>--%>
                        <%--<a class="navbar-brand" href="/"><img class="img-logo" src="/image/logo.png"></a>--%>
                    <%--</div>--%>

                    <%--<!-- Collect the nav links, forms, and other content for toggling -->--%>
                    <%--<div class="collapse navbar-collapse"--%>
                         <%--id="bs-example-navbar-collapse-1">--%>
                        <%--<ul class="nav navbar-nav">--%>
                            <%--<li><a href="schedule.html">Розклад</a></li>--%>
                            <%--<li><a href="/movies/">Фільми</a>--%>
                            <%--</li>--%>
                            <%--<li><a href="https://planetakino.ua/lvov/imax/">IMAX</a></li>--%>


                            <%--<li role="separator" class="divider dropdown"><a--%>
                                    <%--href="https://planetakino.ua/lvov/apps/#"--%>
                                    <%--class="dropdown-toggle" data-toggle="dropdown" role="button"--%>
                                    <%--aria-haspopup="true" aria-expanded="false">...</a>--%>
                                <%--<ul class="dropdown-menu">--%>

                                    <%--<li class="addon-menu__list-item"><a--%>
                                            <%--href="https://planetakino.ua/lvov/theatres/">Кінотеатри</a></li>--%>
                                    <%--<li class="addon-menu__list-item"><a--%>
                                            <%--href="https://planetakino.ua/lvov/about/faq/">Допомога.--%>
                                        <%--Відповіді на запитання</a></li>--%>
                                    <%--<li class="addon-menu__list-item"><a--%>
                                            <%--href="https://planetakino.ua/lvov/i/sale/">Знижки</a></li>--%>
                                    <%--<li class="addon-menu__list-item"><a--%>
                                            <%--href="https://planetakino.ua/lvov/i/gift-certificate/">Подарунковий--%>
                                        <%--сертифікат</a></li>--%>
                                    <%--<li class="addon-menu__list-item"><a--%>
                                            <%--href="https://planetakino.ua/lvov/apps/">Мобільний додаток</a></li>--%>
                                    <%--<li class="addon-menu__list-item"><a--%>
                                            <%--href="https://planetakino.ua/lvov/events/">Новини</a></li>--%>
                                    <%--<li class="addon-menu__list-item"><a--%>
                                            <%--href="https://planetakino.ua/lvov/about/">Про Планету Кіно</a></li>--%>
                                    <%--<li class="addon-menu__list-item"><a--%>
                                            <%--href="https://planetakino.ua/lvov/about/vacancy/">Робота у--%>
                                        <%--нас</a></li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                        <%--</ul>--%>

                    <%--</div>--%>


                <%--</div>--%>


            <%--</div>--%>

            <%--<div class="d col-xs-12 col-sm-4 col-md-4">--%>
                <%--<div class="container-fluid">--%>
                    <%--<div class="row">--%>


                        <%--<ul class="nav nav-pills navbar-right">--%>

                            <%--<!-- Choose cinema-->--%>
                            <%--<li  role="separator" class="divider dropdown">--%>
                                <%--<a href="https://planetakino.ua/lvov/apps/#"--%>
                                   <%--class="dropdown-toggle" data-toggle="dropdown" role="button"--%>
                                   <%--aria-haspopup="true" aria-expanded="false">Cinema: ${cinema.name}</a>--%>
                                <%--<ul class="dropdown-menu">--%>

                                    <%--<c:forEach items="${cinemas}" var="c">--%>
                                        <%--<li  class="addon-menu__list-item"><a href="/cinema/${c.id}">${c.name}</a></li>--%>
                                    <%--</c:forEach>--%>

                                <%--</ul>--%>
                            <%--</li>--%>


                            <%--<!-- Registration-->--%>
                            <%--<li role="presentation" class="dropdown"><a--%>
                                    <%--class="dropdown-toggle" data-toggle="dropdown" href="#"--%>
                                    <%--role="button" aria-haspopup="true" aria-expanded="false">--%>
                                <%--Вхід <span class="caret"></span>--%>
                            <%--</a>--%>
                                <%--<ul class="dropdown-menu">--%>
                                    <%--<li><a href="/login">Вхід</a></li>--%>
                                    <%--<li><a href="/signup" class="register-link">--%>
                                        <%--Реєстрація </a></li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>

                        <%--</ul>--%>


                    <%--</div>--%>

                <%--</div>--%>


            <%--</div>--%>
        <%--</div>--%>

    <%--</div>--%>
<%--</nav>--%>
<%--<!-- ROW HADER container end -->--%>


<%--<!-- -------------------------CENTER container begin----------------------------- -->--%>

<%--<br>--%>
<%--<br>--%>
<%--<br>--%>
<%--<br><br>--%>


<%--<h1 style="margin-left: 20px;" class="red">sfdsdf</h1>--%>
<%--<h2 style="margin-left: 20px;" class="red">Cinemas</h2>--%>

<%--<iframe id="ytplayer" type="text/html"--%>
        <%--src="https://www.youtube.com/embed/CZwvQzsXhjY?&amp;enablejsapi=1&amp;controls=0&amp;rel=0&amp;showinfo=0&amp;html5=1"--%>
        <%--style="opacity: 0;" height="100%" frameborder="0" width="100%"></iframe>--%>
<%--<div class="ytp-play-btn" style=""></div>--%>
<%--<div class="youtube-player-controls ytp-controls"--%>
     <%--style="display: none;">--%>
    <%--<div class="playback">--%>
        <%--<div class="playback__time"></div>--%>
        <%--<div class="playback__line"></div>--%>
        <%--<div class="playback__timeline"></div>--%>
        <%--<div class="playback__bufferline"></div>--%>
    <%--</div>--%>
    <%--<div class="ytp__sound-board">--%>
        <%--<div class="ytp__sound"></div>--%>
        <%--<input min="0" max="100" value="90" class="ytp__sound-volume"--%>
               <%--step="1" type="range">--%>
    <%--</div>--%>
    <%--<a target="_blank" title="YouTube.com" class="ytp__link"--%>
       <%--href="https://www.youtube.com/watch?v=CZwvQzsXhjY"></a>--%>
<%--</div>--%>
<%--<div class="movie-poster-block__caption movie-block">--%>
    <%--<div--%>
            <%--class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass movie-block__info-icon_wishlist-slider"--%>
            <%--data-filmid="2110"></div>--%>
    <%--<h1 class="movie-poster-block__title">${movie.title}</h1>--%>


    <%--<span class="movie-poster-block__subtitle"> Пираты Карибского--%>
<%--моря: Мертвецы не рассказывают сказки / Pirates of the Caribbean:--%>
<%--Dead Men Tell No Tales</span>--%>

<%--</div>--%>


<%--<div class="row movie-page-block">--%>
    <%--<div class="col-md-9 col-xs-12">--%>
        <%--<div class="movie-page-block__desc">--%>
            <%--<p>--%>
                <%--Дивись <strong>ексклюзивну версію фільму</strong> «Вартові--%>
                <%--галактики 2» в IMAX. Тільки в цій технології зображення--%>
                <%--найвидовищніших сцен <strong>на 30% більше</strong> за розмір--%>
                <%--екрану інших залів.--%>
            <%--</p>--%>

            <%--<p>--%>
                <%--Головними героями фільму <strong>«Вартові галактики 2»</strong> як--%>
                <%--і раніше будуть доблесна четвірка на чолі з Зоряним Лицарем (Кріс--%>
                <%--Пратт). На екрані знову з'являться мила на перший погляд, але--%>
                <%--холоднокровна вбивця Ґамора (Зої Салдана), реактивний єнот Ракета--%>
                <%--(Бредлі Купер), дерево Ґрут (Він Дізель), якого Ракета вберіг від--%>
                <%--загибелі, вкорінивши маленький паросток, та відлюдько Дрекс (Дейв--%>
                <%--Батіста). Цього разу банді космічних волоцюг доведеться битися, щоб--%>
                <%--захистити свою знову знайдену сім'ю, а також їм належить з'ясувати--%>
                <%--всі деталі біографії свого ватажка Зоряного Лицаря.--%>
            <%--</p>--%>
            <%--<p>Про те, що історія героїв, які подорожують галактикою, матиме--%>
                <%--продовження, стало відомо через тиждень після виходу на екрани--%>
                <%--першого фільму. Продюсери заявили, що сюжет гідний франшизи, а--%>
                <%--режисер Джеймс Ганн охоче погодився працювати над продовженням.--%>
                <%--Сценарій сиквелу, як і першої частини, пишуть спільно Джеймс Ганн і--%>
                <%--Ніколь Перлман, вся кар'єра якої - це написання сценаріїв до--%>
                <%--фільмів з кінематографічного всесвіту Марвел. Дана картина стане--%>
                <%--15-ю у списку Marvel Studios.</p>--%>
        <%--</div>--%>


        <%--<div id="carousel-example-generic" class="carousel slide"--%>
             <%--data-ride="carousel">--%>
            <%--<!-- Indicators -->--%>
            <%--<ol class="carousel-indicators">--%>
                <%--<li data-target="#carousel-example-generic" data-slide-to="0"--%>
                    <%--class="active"></li>--%>
                <%--<li data-target="#carousel-example-generic" data-slide-to="1"></li>--%>
                <%--<li data-target="#carousel-example-generic" data-slide-to="2"></li>--%>
                <%--<li data-target="#carousel-example-generic" data-slide-to="3"></li>--%>
                <%--<li data-target="#carousel-example-generic" data-slide-to="4"></li>--%>
            <%--</ol>--%>

            <%--<!-- Wrapper for slides -->--%>
            <%--<div class="carousel-inner" role="listbox">--%>

                <%--<div class="item active">--%>
                    <%--<a href="schedule.html"> <img src="17.jpg" alt="..."--%>
                                                  <%--width="100%"></a>--%>
                    <%--<div class="carousel-caption">--%>
                        <%--<h1>IMAX Kharkiv</h1>--%>
                    <%--</div>--%>
                <%--</div>--%>


                <%--<div class="item">--%>
                    <%--<a href="schedule.html"> <img src="2.jpg" alt="..."--%>
                                                  <%--width="100%"></a>--%>
                    <%--<div class="carousel-caption">--%>
                        <%--<h1>IMAX Odessa</h1>--%>

                    <%--</div>--%>
                <%--</div>--%>


                <%--<div class="item">--%>
                    <%--<a href="schedule.html"> <img src="foro-lvov-kadr10-big.jpg"--%>
                                                  <%--alt="..." width="100%"></a>--%>
                    <%--<div class="carousel-caption">--%>
                        <%--<h1>IMAX Kiev</h1>--%>

                    <%--</div>--%>
                <%--</div>--%>


                <%--<div class="item">--%>
                    <%--<a href="schedule.html"> <img src="N_3.jpg" alt="..."--%>
                                                  <%--width="100%"></a>--%>
                    <%--<div class="carousel-caption">--%>
                        <%--<h1>IMAX Lviv2</h1>--%>

                    <%--</div>--%>
                <%--</div>--%>


                <%--<div class="item">--%>
                    <%--<a href="schedule.html"> <img src="DSC-2.jpg" alt="..."--%>
                                                  <%--width="100%"></a>--%>
                    <%--<div class="carousel-caption">--%>

                        <%--<h1>IMAX Lviv1</h1>--%>

                    <%--</div>--%>
                <%--</div>--%>


            <%--</div>--%>

            <%--<!-- Controls -->--%>
            <%--<a class="left carousel-control" href="#carousel-example-generic"--%>
               <%--role="button" data-slide="prev"> <span--%>
                    <%--class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>--%>
                <%--<span class="sr-only">Previous</span>--%>
            <%--</a> <a class="right carousel-control" href="#carousel-example-generic"--%>
                    <%--role="button" data-slide="next"> <span--%>
                <%--class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>--%>
            <%--<span class="sr-only">Next</span>--%>
        <%--</a>--%>
        <%--</div>--%>


    <%--</div>--%>


    <%--<div class="col-md-3 col-xs-12">--%>

        <%--<div class="movie-page-block__summary">--%>
            <%--<dl>--%>
                <%--<dt name="year">Рік</dt>--%>
                <%--<dd>2017</dd>--%>

                <%--<dt name="country">Країна</dt>--%>
                <%--<dd>США</dd>--%>

                <%--<dt name="duplicationLang">Мова дублювання</dt>--%>
                <%--<dd>українська</dd>--%>

                <%--<dt name="genre">Жанр</dt>--%>
                <%--<dd>фантастика, бойовик</dd>--%>

                <%--<dt name="inStars">В головних ролях</dt>--%>
                <%--<dd>Кріс Пратт, Зої Салдана, Дейв Батіста, Він Дізель, Бредлі--%>
                    <%--Купер, Курт Рассел--%>
                <%--</dd>--%>

                <%--<dt name="director">Режисер</dt>--%>
                <%--<dd>Джеймс Ганн</dd>--%>

                <%--<dt name="scenario">Сценарій</dt>--%>
                <%--<dd>Джеймс Ганн, Ден Абнетт, Енді Леннінг</dd>--%>

                <%--<dt name="dtStart">Прокат</dt>--%>
                <%--<dd>З 04 травня 2017, орієнтовно по 31 травня 2017</dd>--%>


                <%--<dt name="duration">Тривалість</dt>--%>
                <%--<dd>136 хв.</dd>--%>

                <%--<dt name="ageLimit">Вікові обмеження</dt>--%>
                <%--<dd>12+</dd>--%>

            <%--</dl>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<%--<!-- -------------------------CENTER container end----------------------------- -->--%>


<%--<!-- FOOTER container begin, TODO: please create component -->--%>
<%--<footer id="footer" class="footer"> <!-- DESCRIPTION BOX begin -->--%>
    <%--<div class="description-box">--%>
        <%--<div class="description-box__title" data-toggle="Сховати опис">Читати--%>
            <%--опис--%>
        <%--</div>--%>
        <%--<div class="description-box__wrapper" style="display: none;"></div>--%>
    <%--</div>--%>

    <%--<div class="copyright-and-contacts">--%>
        <%--<a href="mailto:info@planetakino.ua">info@planetakino.ua</a>--%>
        <%--<p>Всі звернення, надіслані на цю пошту, потраплять до власників--%>
            <%--та керівництва Планети Кіно</p>--%>
    <%--</div>--%>

    <%--<div class="search right-panel">--%>
        <%--<div class="reducer">--%>
            <%--<!--form object-id="114">--%>
  <%--<input type="search" name="q" placeholder="пошук" />--%>
<%--</form-->--%>
            <%--<div class="footer-contacts">--%>
                <%--<a href="tel:0800300600"><h3>0 800 300 600</h3></a>--%>
                <%--<p>--%>
                    <%--Щоденно, 9:00—22:00 <br>Безкоштовно по Україні з будь-якого--%>
                    <%--номеру--%>
                <%--</p>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="clear"></div>--%>
<%--</footer>--%>
<%--<!-- FOOTER container the end -->--%>

<%--</body>--%>
<%--</html>--%>










<%--&lt;%&ndash;<%@  page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>&ndash;%&gt;--%>
<%--&lt;%&ndash;<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>&ndash;%&gt;--%>


<%--&lt;%&ndash;<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">&ndash;%&gt;--%>

<%--&lt;%&ndash;<html>&ndash;%&gt;--%>

<%--&lt;%&ndash;<head>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<meta http-equiv="Content-Type" content="text/html; charset=utf-8">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<link rel="stylesheet" href="css/style.css">&ndash;%&gt;--%>

    <%--&lt;%&ndash;<!-- Latest compiled and minified CSS -->&ndash;%&gt;--%>
    <%--&lt;%&ndash;<link rel="stylesheet"&ndash;%&gt;--%>
          <%--&lt;%&ndash;href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"&ndash;%&gt;--%>
          <%--&lt;%&ndash;integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"&ndash;%&gt;--%>
          <%--&lt;%&ndash;crossorigin="anonymous">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>&ndash;%&gt;--%>

    <%--&lt;%&ndash;<!-- Latest compiled and minified JavaScript -->&ndash;%&gt;--%>
    <%--&lt;%&ndash;<script&ndash;%&gt;--%>
            <%--&lt;%&ndash;src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"&ndash;%&gt;--%>
            <%--&lt;%&ndash;integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"&ndash;%&gt;--%>
            <%--&lt;%&ndash;crossorigin="anonymous"></script>&ndash;%&gt;--%>

    <%--&lt;%&ndash;<title>IMAX | layout</title>&ndash;%&gt;--%>
<%--&lt;%&ndash;</head>&ndash;%&gt;--%>

<%--&lt;%&ndash;<body>&ndash;%&gt;--%>


<%--&lt;%&ndash;<!-- HADER container begin -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<nav class="navbar navbar-default">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="container-fluid">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="d col-xs-12 col-sm-8 col-md-8">&ndash;%&gt;--%>


                <%--&lt;%&ndash;<div class="container-fluid">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<!-- Brand and toggle get grouped for better mobile display -->&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="navbar-header">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<button type="button" class="navbar-toggle collapsed"&ndash;%&gt;--%>
                                <%--&lt;%&ndash;data-toggle="collapse"&ndash;%&gt;--%>
                                <%--&lt;%&ndash;data-target="#bs-example-navbar-collapse-1" aria-expanded="false">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<span class="sr-only">Toggle navigation</span> <span&ndash;%&gt;--%>
                                <%--&lt;%&ndash;class="icon-bar"></span> <span class="icon-bar"></span> <span&ndash;%&gt;--%>
                                <%--&lt;%&ndash;class="icon-bar"></span>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</button>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<a class="navbar-brand img-logo"  href="/"><img src="/image/logo.png"></a>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

                    <%--&lt;%&ndash;<!-- Collect the nav links, forms, and other content for toggling -->&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="collapse navbar-collapse"&ndash;%&gt;--%>
                         <%--&lt;%&ndash;id="bs-example-navbar-collapse-1">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<ul class="nav navbar-nav">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<li><a href="schedule.html">Розклад</a></li>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<li><a href="/movies/">Фільми</a>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<li><a href="https://planetakino.ua/lvov/imax/">IMAX</a></li>&ndash;%&gt;--%>


                            <%--&lt;%&ndash;<li role="separator" class="divider dropdown"><a&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;href="https://planetakino.ua/lvov/apps/#"&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;class="dropdown-toggle" data-toggle="dropdown" role="button"&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;aria-haspopup="true" aria-expanded="false">...</a>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<ul class="dropdown-menu">&ndash;%&gt;--%>

                                    <%--&lt;%&ndash;<li class="addon-menu__list-item"><a&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;href="https://planetakino.ua/lvov/theatres/">Кінотеатри</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li class="addon-menu__list-item"><a&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;href="https://planetakino.ua/lvov/about/faq/">Допомога.&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;Відповіді на запитання</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li class="addon-menu__list-item"><a&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;href="https://planetakino.ua/lvov/i/sale/">Знижки</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li class="addon-menu__list-item"><a&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;href="https://planetakino.ua/lvov/i/gift-certificate/">Подарунковий&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;сертифікат</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li class="addon-menu__list-item"><a&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;href="https://planetakino.ua/lvov/apps/">Мобільний додаток</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li class="addon-menu__list-item"><a&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;href="https://planetakino.ua/lvov/events/">Новини</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li class="addon-menu__list-item"><a&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;href="https://planetakino.ua/lvov/about/">Про Планету Кіно</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li class="addon-menu__list-item"><a&ndash;%&gt;--%>
                                            <%--&lt;%&ndash;href="https://planetakino.ua/lvov/about/vacancy/">Робота у&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;нас</a></li>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>

                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>


                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>


            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

            <%--&lt;%&ndash;<div class="d col-xs-12 col-sm-4 col-md-4">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<div class="container-fluid">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>


                        <%--&lt;%&ndash;<ul class="nav nav-pills navbar-right">&ndash;%&gt;--%>

                            <%--&lt;%&ndash;<!-- Choose cinema-->&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<li  role="separator" class="divider dropdown">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<a href="https://planetakino.ua/lvov/apps/#"&ndash;%&gt;--%>
                                   <%--&lt;%&ndash;class="dropdown-toggle" data-toggle="dropdown" role="button"&ndash;%&gt;--%>
                                   <%--&lt;%&ndash;aria-haspopup="true" aria-expanded="false">Cinema: ${cinema.name}</a>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<ul class="dropdown-menu">&ndash;%&gt;--%>

                                    <%--&lt;%&ndash;<c:forEach items="${cinemas}" var="c">&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;<li  class="addon-menu__list-item"><a href="/cinema/${c.id}">${c.name}</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>

                                <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>


                            <%--&lt;%&ndash;<!-- Registration-->&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<li role="presentation" class="dropdown"><a&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;class="dropdown-toggle" data-toggle="dropdown" href="#"&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;role="button" aria-haspopup="true" aria-expanded="false">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;Вхід <span class="caret"></span>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<ul class="dropdown-menu">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li><a href="/login">Вхід</a></li>&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<li><a href="/signup" class="register-link">&ndash;%&gt;--%>
                                        <%--&lt;%&ndash;Реєстрація </a></li>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>

                        <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>


                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>


            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</nav>&ndash;%&gt;--%>
<%--&lt;%&ndash;<!-- ROW HADER container end -->&ndash;%&gt;--%>


<%--&lt;%&ndash;<!-- -------------------------CENTER container begin----------------------------- -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<br>&ndash;%&gt;--%>
<%--&lt;%&ndash;<br>&ndash;%&gt;--%>
<%--&lt;%&ndash;<br>&ndash;%&gt;--%>
<%--&lt;%&ndash;<br><br>&ndash;%&gt;--%>


<%--&lt;%&ndash;<h1 style="margin-left: 20px;" class="red">sfdsdf</h1>&ndash;%&gt;--%>
<%--&lt;%&ndash;<h2 style="margin-left: 20px;" class="red">Cinemas</h2>&ndash;%&gt;--%>

<%--&lt;%&ndash;<iframe id="ytplayer" type="text/html"&ndash;%&gt;--%>
        <%--&lt;%&ndash;src="https://www.youtube.com/embed/CZwvQzsXhjY?&amp;enablejsapi=1&amp;controls=0&amp;rel=0&amp;showinfo=0&amp;html5=1"&ndash;%&gt;--%>
        <%--&lt;%&ndash;style="opacity: 0;" height="100%" frameborder="0" width="100%"></iframe>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="ytp-play-btn" style=""></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="youtube-player-controls ytp-controls"&ndash;%&gt;--%>
     <%--&lt;%&ndash;style="display: none;">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="playback">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="playback__time"></div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="playback__line"></div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="playback__timeline"></div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="playback__bufferline"></div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="ytp__sound-board">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="ytp__sound"></div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input min="0" max="100" value="90" class="ytp__sound-volume"&ndash;%&gt;--%>
               <%--&lt;%&ndash;step="1" type="range">&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<a target="_blank" title="YouTube.com" class="ytp__link"&ndash;%&gt;--%>
       <%--&lt;%&ndash;href="https://www.youtube.com/watch?v=CZwvQzsXhjY"></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="movie-poster-block__caption movie-block">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div&ndash;%&gt;--%>
            <%--&lt;%&ndash;class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass movie-block__info-icon_wishlist-slider"&ndash;%&gt;--%>
            <%--&lt;%&ndash;data-filmid="2110"></div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<h1 class="movie-poster-block__title">${movie.title}</h1>&ndash;%&gt;--%>


    <%--&lt;%&ndash;<span class="movie-poster-block__subtitle"> Пираты Карибского&ndash;%&gt;--%>
			<%--&lt;%&ndash;моря: Мертвецы не рассказывают сказки / Pirates of the Caribbean:&ndash;%&gt;--%>
			<%--&lt;%&ndash;Dead Men Tell No Tales</span>&ndash;%&gt;--%>

<%--&lt;%&ndash;</div>&ndash;%&gt;--%>


<%--&lt;%&ndash;<div class="row movie-page-block">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="col-md-9 col-xs-12">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="movie-page-block__desc">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<p>&ndash;%&gt;--%>
                <%--&lt;%&ndash;Дивись <strong>ексклюзивну версію фільму</strong> «Вартові&ndash;%&gt;--%>
                <%--&lt;%&ndash;галактики 2» в IMAX. Тільки в цій технології зображення&ndash;%&gt;--%>
                <%--&lt;%&ndash;найвидовищніших сцен <strong>на 30% більше</strong> за розмір&ndash;%&gt;--%>
                <%--&lt;%&ndash;екрану інших залів.&ndash;%&gt;--%>
            <%--&lt;%&ndash;</p>&ndash;%&gt;--%>

            <%--&lt;%&ndash;<p>&ndash;%&gt;--%>
                <%--&lt;%&ndash;Головними героями фільму <strong>«Вартові галактики 2»</strong> як&ndash;%&gt;--%>
                <%--&lt;%&ndash;і раніше будуть доблесна четвірка на чолі з Зоряним Лицарем (Кріс&ndash;%&gt;--%>
                <%--&lt;%&ndash;Пратт). На екрані знову з'являться мила на перший погляд, але&ndash;%&gt;--%>
                <%--&lt;%&ndash;холоднокровна вбивця Ґамора (Зої Салдана), реактивний єнот Ракета&ndash;%&gt;--%>
                <%--&lt;%&ndash;(Бредлі Купер), дерево Ґрут (Він Дізель), якого Ракета вберіг від&ndash;%&gt;--%>
                <%--&lt;%&ndash;загибелі, вкорінивши маленький паросток, та відлюдько Дрекс (Дейв&ndash;%&gt;--%>
                <%--&lt;%&ndash;Батіста). Цього разу банді космічних волоцюг доведеться битися, щоб&ndash;%&gt;--%>
                <%--&lt;%&ndash;захистити свою знову знайдену сім'ю, а також їм належить з'ясувати&ndash;%&gt;--%>
                <%--&lt;%&ndash;всі деталі біографії свого ватажка Зоряного Лицаря.&ndash;%&gt;--%>
            <%--&lt;%&ndash;</p>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<p>Про те, що історія героїв, які подорожують галактикою, матиме&ndash;%&gt;--%>
                <%--&lt;%&ndash;продовження, стало відомо через тиждень після виходу на екрани&ndash;%&gt;--%>
                <%--&lt;%&ndash;першого фільму. Продюсери заявили, що сюжет гідний франшизи, а&ndash;%&gt;--%>
                <%--&lt;%&ndash;режисер Джеймс Ганн охоче погодився працювати над продовженням.&ndash;%&gt;--%>
                <%--&lt;%&ndash;Сценарій сиквелу, як і першої частини, пишуть спільно Джеймс Ганн і&ndash;%&gt;--%>
                <%--&lt;%&ndash;Ніколь Перлман, вся кар'єра якої - це написання сценаріїв до&ndash;%&gt;--%>
                <%--&lt;%&ndash;фільмів з кінематографічного всесвіту Марвел. Дана картина стане&ndash;%&gt;--%>
                <%--&lt;%&ndash;15-ю у списку Marvel Studios.</p>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>


        <%--&lt;%&ndash;<div id="carousel-example-generic" class="carousel slide"&ndash;%&gt;--%>
             <%--&lt;%&ndash;data-ride="carousel">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<!-- Indicators -->&ndash;%&gt;--%>
            <%--&lt;%&ndash;<ol class="carousel-indicators">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li data-target="#carousel-example-generic" data-slide-to="0"&ndash;%&gt;--%>
                    <%--&lt;%&ndash;class="active"></li>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li data-target="#carousel-example-generic" data-slide-to="1"></li>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li data-target="#carousel-example-generic" data-slide-to="2"></li>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li data-target="#carousel-example-generic" data-slide-to="3"></li>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li data-target="#carousel-example-generic" data-slide-to="4"></li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</ol>&ndash;%&gt;--%>

            <%--&lt;%&ndash;<!-- Wrapper for slides -->&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="carousel-inner" role="listbox">&ndash;%&gt;--%>

                <%--&lt;%&ndash;<div class="item active">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a href="schedule.html"> <img src="17.jpg" alt="..."&ndash;%&gt;--%>
                                                  <%--&lt;%&ndash;width="100%"></a>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="carousel-caption">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<h1>IMAX Kharkiv</h1>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>


                <%--&lt;%&ndash;<div class="item">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a href="schedule.html"> <img src="2.jpg" alt="..."&ndash;%&gt;--%>
                                                  <%--&lt;%&ndash;width="100%"></a>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="carousel-caption">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<h1>IMAX Odessa</h1>&ndash;%&gt;--%>

                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>


                <%--&lt;%&ndash;<div class="item">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a href="schedule.html"> <img src="foro-lvov-kadr10-big.jpg"&ndash;%&gt;--%>
                                                  <%--&lt;%&ndash;alt="..." width="100%"></a>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="carousel-caption">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<h1>IMAX Kiev</h1>&ndash;%&gt;--%>

                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>


                <%--&lt;%&ndash;<div class="item">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a href="schedule.html"> <img src="N_3.jpg" alt="..."&ndash;%&gt;--%>
                                                  <%--&lt;%&ndash;width="100%"></a>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="carousel-caption">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<h1>IMAX Lviv2</h1>&ndash;%&gt;--%>

                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>


                <%--&lt;%&ndash;<div class="item">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<a href="schedule.html"> <img src="DSC-2.jpg" alt="..."&ndash;%&gt;--%>
                                                  <%--&lt;%&ndash;width="100%"></a>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<div class="carousel-caption">&ndash;%&gt;--%>

                        <%--&lt;%&ndash;<h1>IMAX Lviv1</h1>&ndash;%&gt;--%>

                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>


            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

            <%--&lt;%&ndash;<!-- Controls -->&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a class="left carousel-control" href="#carousel-example-generic"&ndash;%&gt;--%>
               <%--&lt;%&ndash;role="button" data-slide="prev"> <span&ndash;%&gt;--%>
                    <%--&lt;%&ndash;class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<span class="sr-only">Previous</span>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</a> <a class="right carousel-control" href="#carousel-example-generic"&ndash;%&gt;--%>
                    <%--&lt;%&ndash;role="button" data-slide="next"> <span&ndash;%&gt;--%>
                <%--&lt;%&ndash;class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<span class="sr-only">Next</span>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>


    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>


    <%--&lt;%&ndash;<div class="col-md-3 col-xs-12">&ndash;%&gt;--%>

        <%--&lt;%&ndash;<div class="movie-page-block__summary">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<dl>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<dt name="year">Рік</dt>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<dd>2017</dd>&ndash;%&gt;--%>

                <%--&lt;%&ndash;<dt name="country">Країна</dt>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<dd>США</dd>&ndash;%&gt;--%>

                <%--&lt;%&ndash;<dt name="duplicationLang">Мова дублювання</dt>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<dd>українська</dd>&ndash;%&gt;--%>

                <%--&lt;%&ndash;<dt name="genre">Жанр</dt>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<dd>фантастика, бойовик</dd>&ndash;%&gt;--%>

                <%--&lt;%&ndash;<dt name="inStars">В головних ролях</dt>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<dd>Кріс Пратт, Зої Салдана, Дейв Батіста, Він Дізель, Бредлі&ndash;%&gt;--%>
                    <%--&lt;%&ndash;Купер, Курт Рассел&ndash;%&gt;--%>
                <%--&lt;%&ndash;</dd>&ndash;%&gt;--%>

                <%--&lt;%&ndash;<dt name="director">Режисер</dt>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<dd>Джеймс Ганн</dd>&ndash;%&gt;--%>

                <%--&lt;%&ndash;<dt name="scenario">Сценарій</dt>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<dd>Джеймс Ганн, Ден Абнетт, Енді Леннінг</dd>&ndash;%&gt;--%>

                <%--&lt;%&ndash;<dt name="dtStart">Прокат</dt>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<dd>З 04 травня 2017, орієнтовно по 31 травня 2017</dd>&ndash;%&gt;--%>


                <%--&lt;%&ndash;<dt name="duration">Тривалість</dt>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<dd>136 хв.</dd>&ndash;%&gt;--%>

                <%--&lt;%&ndash;<dt name="ageLimit">Вікові обмеження</dt>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<dd>12+</dd>&ndash;%&gt;--%>

            <%--&lt;%&ndash;</dl>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<!-- ------------------------- CENTER  container the END----------------------------- -->&ndash;%&gt;--%>

<%--&lt;%&ndash;<!-- FOOTER container begin, TODO: please create component -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<footer id="footer" class="footer"> <!-- DESCRIPTION BOX begin -->&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="description-box">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="description-box__title" data-toggle="Сховати опис">Читати&ndash;%&gt;--%>
            <%--&lt;%&ndash;опис&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="description-box__wrapper" style="display: none;"></div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

    <%--&lt;%&ndash;<div class="copyright-and-contacts">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<a href="mailto:info@planetakino.ua">info@planetakino.ua</a>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<p>Всі звернення, надіслані на цю пошту, потраплять до власників&ndash;%&gt;--%>
            <%--&lt;%&ndash;та керівництва Планети Кіно</p>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

    <%--&lt;%&ndash;<div class="search right-panel">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="reducer">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<!--form object-id="114">&ndash;%&gt;--%>
  <%--&lt;%&ndash;<input type="search" name="q" placeholder="пошук" />&ndash;%&gt;--%>
<%--&lt;%&ndash;</form-->&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="footer-contacts">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<a href="tel:0800300600"><h3>0 800 300 600</h3></a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<p>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;Щоденно, 9:00—22:00 <br>Безкоштовно по Україні з будь-якого&ndash;%&gt;--%>
                    <%--&lt;%&ndash;номеру&ndash;%&gt;--%>
                <%--&lt;%&ndash;</p>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="clear"></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</footer>&ndash;%&gt;--%>
<%--&lt;%&ndash;<!-- FOOTER container the end -->&ndash;%&gt;--%>
<%--&lt;%&ndash;</body>&ndash;%&gt;--%>
<%--&lt;%&ndash;</html>&ndash;%&gt;--%>