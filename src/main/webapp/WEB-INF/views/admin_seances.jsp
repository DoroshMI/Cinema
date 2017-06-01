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
                            <li><a href="/cinema/${cinema.id}/seances">Розклад</a></li>
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
                                        <li class="addon-menu__list-item"><a
                                                href="/cinema/${c.id}/seances">${c.name}</a></li>
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

<div style="margin: 15px;">

    <div class="page-header-block row">
        <h1 class="page-title col-sm-9 col-xs-12">Розклад сеансів у ${cinema.name} </h1>

        <div class="page-header-small col-sm-9 col-xs-12" type="button" data-toggle="collapse"
             data-target="#collapseMain"
             aria-expanded="false" aria-controls="collapseMain">
            Розклад зазвичай оновлюється щосереди після 16:00 на 1 тиждень вперед (з четверга по наступну
            середу).
        </div>

        <div class="page-header-main collapse col-sm-9 col-xs-12" id="collapseMain">
            <div class="well">
                <table class="table-params table-params_with-hidden-content">
                    <tbody>
                    <tr>
                        <td>Розклад зазвичай оновлюється щосереди після 16:00<br> на 1 тиждень вперед (з четверга по
                            наступну середу).
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="under-table-params" style="font-weight: normal; font-size: 90%; padding-left: 0px">
                    <p>Нові фільми виходять у прокат щочетверга, тому щосереди після 16:00 ми публікуємо розклад на всі
                        сеанси.</p>
                    <p>Зазвичай розклад оновлюється лише на 1 тиждень - з четверга по середу. Однак, інколи, на деякі
                        фільми
                        розклад може з’являтися раніше або пізніше та більше, ніж на 1 тиждень.</p>
                    <p>Для кінозалів IMAX ми намагаємося публікувати розклад на фільми раніше. На сеанси у технології
                        4DX
                        іноді розклад може з’являтися зранку у день прем’єри фільму. Це пов'язано з тим, що ключі для
                        запуску фільму активуються лише вночі, а ми повинні перевірити всі ефекти на фільмі.</p>
                    <p>Щоб одним з перших дізнаватися про появу розкладу на улюблений фільм, радимо налаштувати
                        оповіщення. </p>
                    <p>Для цього залогінься або зареєструйся на сайті, у розділі «Фільми» обери той, що тебе цікавить та
                        перейди на його сторінку. Поруч з датою початку прокату фільму знайди та натисни посилання
                        «Сповістити про початок продажу квитків». Коли ми опублікуємо розклад на цей фільм, ти отримаєш
                        від
                        нас листа на e-mail, який ти вказав у своїй анкеті в Особистому Кабінеті. </p>
                    <p>Така сама зручна функція сповіщення є у нашому мобільному додатку «Планета Кіно».</p>

                </div>

            </div>
        </div>
    </div>


    <div class="choose-container">
        <div class="time-select">


            <c:forEach items="${seances}" var="entry">


                <div class="time-select__group">
                    <div class="col-sm-4">

                        <!-- Movie -->
                        <div class="movie-block">
                            <a class="movie-block__poster movie-block__poster_size_big"
                               href="#">
                                <img src="./index_files/pirats1-big.jpg" alt="${entry.getKey().title}">
                            </a>
                            <div class="movie-block__info">
                                <div class="movie-block__text movie-block__text_color_blue">
                                    <div class="movie-block__info-icon movie-block__info-icon_2d"></div>
                                    <div class="movie-block__text-date">до ${entry.getKey().showToDate}</div>
                                </div>

                                <a class="movie-block__text movie-block__text_title"
                                   href="https://planetakino.ua/lvov/movies/pirates_of_the_caribbean_dead_men_tell_no_tales/">
                                        ${entry.getKey().title} </a>
                                <div class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass"></div>
                            </div>
                        </div>

                    </div>
                    <ul class="col-sm-8 items-wrap">

                        <c:forEach items="${entry.getValue()}" var="s">
                            <!-- Seances -->
                            <div class="time-select__item time">
                                <div role="separator" class="divider dropdown ">
                                    <a href="/#"
                                       class="dropdown-toggle" data-toggle="dropdown" role="button"
                                       aria-haspopup="true" aria-expanded="false">
                                            ${s.startTime.toLocalTime()}</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/seances/${s.id}">choose</a></li>
                                        <li><a href="/seances/${s.id}/update">update</a></li>
                                        <li><a href="/seances/${s.id}/delete">delete</a></li>

                                    </ul>
                                </div>

                            </div>
                        </c:forEach>


                    </ul>
                </div>


            </c:forEach>


        </div>


    </div>

</div>


<!-- -------------------------CENTER container end----------------------------- -->
<br>


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

