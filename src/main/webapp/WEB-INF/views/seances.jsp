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
                                        <li class="addon-menu__list-item"><a href="/cinema/${c.id}/">${c.name}</a></li>
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

<div class="page-header-block row">
    <h1 class="page-title col-sm-9 col-xs-12">Розклад сеансів у ${cinema.name} </h1>

    <div class="page-header-small col-sm-9 col-xs-12" type="button" data-toggle="collapse" data-target="#collapseMain"
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
                <p>Зазвичай розклад оновлюється лише на 1 тиждень - з четверга по середу. Однак, інколи, на деякі фільми
                    розклад може з’являтися раніше або пізніше та більше, ніж на 1 тиждень.</p>
                <p>Для кінозалів IMAX ми намагаємося публікувати розклад на фільми раніше. На сеанси у технології 4DX
                    іноді розклад може з’являтися зранку у день прем’єри фільму. Це пов'язано з тим, що ключі для
                    запуску фільму активуються лише вночі, а ми повинні перевірити всі ефекти на фільмі.</p>
                <p>Щоб одним з перших дізнаватися про появу розкладу на улюблений фільм, радимо налаштувати
                    оповіщення. </p>
                <p>Для цього залогінься або зареєструйся на сайті, у розділі «Фільми» обери той, що тебе цікавить та
                    перейди на його сторінку. Поруч з датою початку прокату фільму знайди та натисни посилання
                    «Сповістити про початок продажу квитків». Коли ми опублікуємо розклад на цей фільм, ти отримаєш від
                    нас листа на e-mail, який ти вказав у своїй анкеті в Особистому Кабінеті. </p>
                <p>Така сама зручна функція сповіщення є у нашому мобільному додатку «Планета Кіно».</p>

            </div>

        </div>
    </div>
</div>


<div class="container-fluid">


    <div class="row">

        <div class="filters-block filters-block-fixed col-lg-6 col-md-12">

            <div class="filters-block__column">
                <div class="filters-block__list-label">технології:</div>
                <ul class="filters-block__list filters-block__list-technology">
                    <li class="filters-block__technology">
                        <a href="#imax" class="selected-tech"
                           data-filterclasses=".t-imax, .t-imax-2d, .t-imax-3d">IMAX</a>
                    </li>
                    <li class="filters-block__technology">
                        <a href="#4dx" class="selected-tech" data-filterclasses=".t-4dx, .t-4dx-2d, .t-4dx-3d">4DX</a>
                    </li>
                    <li class="filters-block__technology">
                        <a href="#4dx" class="selected-tech" data-filterclasses=".t-4dx, .t-4dx-2d, .t-4dx-3d">RELUX</a>
                    </li>

                    <li class="filters-block__technology">
                        <a href="#cinetech" class="selected-tech" data-filterclasses=".t-2d, .t-3d">CINETECH+</a></li>
                </ul>

                <div class="filters-block__list-label">формати:</div>
                <ul class="filters-block__list filters-block__list-format">
                    <li class="filters-block__format" data-group="imax"><a href="#imax-2d" data-filterclasses=".t-imax"
                                                                           class="selected">2D</a><a href="#imax-3d"
                                                                                                     data-filterclasses=".t-imax-3d"
                                                                                                     class="selected">3D</a>
                    </li>
                    <li class="filters-block__format" data-group="4dx"><a href="#4dx-2d" data-filterclasses=".t-4dx-2d"
                                                                          class="selected">2D</a><a href="#4dx-3d"
                                                                                                    data-filterclasses=".t-4dx-3d"
                                                                                                    class="selected">3D</a>
                    </li>
                    <li class="filters-block__format" data-group="imax"><a href="#imax-2d" data-filterclasses=".t-imax"
                                                                           class="selected">2D</a><a href="#imax-3d"
                                                                                                     data-filterclasses=".t-imax-3d"
                                                                                                     class="selected">3D</a>
                    </li>
                    <li class="filters-block__format" data-group="relux" style="display: none;"><a href="#relux-2d"
                                                                                                   data-filterclasses=".t-relux-2d"
                                                                                                   class="selected">2D</a><a
                            href="#relux-3d" data-filterclasses=".t-relux-3d" class="selected">3D</a></li>
                    <li class="filters-block__format" data-group="cinetech"><a href="#cinetech-2d"
                                                                               data-filterclasses=".t-2d"
                                                                               class="selected">2D</a><a
                            href="#cinetech-3d" data-filterclasses=".t-3d" class="selected">3D</a></li>
                </ul>
            </div>
        </div>


        <div class="filters-block filters-block-fixed col-lg-4 col-md-12">
            <div class="filters-block__list-label filters-block__list-label-wide">період показу:</div>
            <ul class="filters-block__list filters-block__list-date">
                <li class="filters-block__date"><a href="#one-day" id="one-day"
                                                   data-filterclasses=".p-one-day">сьогодні</a></li>
                <li class="filters-block__date"><a href="#tomorrow" id="tomorrow" data-filterclasses=".p-tomorrow">завтра</a>
                </li>
                <li class="filters-block__date"><a href="#week" id="week" data-filterclasses=".p-week">тиждень</a></li>
                <li class="filters-block__date"><a href="#month" id="month" data-filterclasses=".p-month"
                                                   class="selected">місяць</a></li>
            </ul>
        </div>


    </div>
</div>

<!-- Шкала -->
<div class="showtimes-head">
    <div class="hours">
        <div class="time-line-wrapper">
            <div class="time-line">
                <table class="navigation">
                    <tbody>
                    <tr>
                        <td class="hour hour-highlight-9">
                            <div class="selector">09:00</div>
                        </td>
                        <td class="hour hour-highlight-10">
                            <div class="selector">10:00</div>
                        </td>
                        <td class="hour hour-highlight-11">
                            <div class="selector">11:00</div>
                        </td>
                        <td class="hour hour-highlight-12">
                            <div class="selector">12:00</div>
                        </td>
                        <td class="hour hour-highlight-13">
                            <div class="selector">13:00</div>
                        </td>
                        <td class="hour hour-highlight-14">
                            <div class="selector">14:00</div>
                        </td>
                        <td class="hour hour-highlight-15">
                            <div class="selector">15:00</div>
                        </td>
                        <td class="hour hour-highlight-16">
                            <div class="selector">16:00</div>
                        </td>
                        <td class="hour hour-highlight-17">
                            <div class="selector">17:00</div>
                        </td>
                        <td class="hour hour-highlight-18">
                            <div class="selector">18:00</div>
                        </td>
                        <td class="hour hour-highlight-19">
                            <div class="selector">19:00</div>
                        </td>
                        <td class="hour hour-highlight-20">
                            <div class="selector">20:00</div>
                        </td>
                        <td class="hour hour-highlight-21">
                            <div class="selector">21:00</div>
                        </td>
                        <td class="hour hour-highlight-22">
                            <div class="selector">22:00</div>
                        </td>
                        <td class="hour hour-highlight-23">
                            <div class="selector">23:00</div>
                        </td>
                        <td class="hour hour-highlight-24">
                            <div class="selector">0:00</div>
                        </td>
                        <td class="hour hour-highlight-25">
                            <div class="selector">1:00</div>
                        </td>
                        <td class="hour hour-highlight-26">
                            <div class="selector">2:00</div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

${seances}
<c:forEach items="${seances}" var="listSeances">


    <%--<c:forEach items="${listSeances}" var="s">--%>
        <%--${s} <br>--%>
    <%--</c:forEach>--%>


</c:forEach>

<div class="   showtime-movie-container" style="display: block; padding-top: 0px;">

    <p class="2578 movie-title" style="top: 0px;">
        <a href="/lvov/movies/the_headhunters_calling/"> Мисливець з Уолл-стріт <img
                data-vend="https://planetakino.ua/@resize/f/1/movies/the_headhunters_calling/Mislivez-afisha3.jpg?width=720&amp;height=360"
                width="110" height="162" alt=""
                src="/f/1/movies/the_headhunters_calling/Mislivez-poster1-small.jpg"></a>
    </p>


    <div>


        <p class="cl" style="float: left; margin-left: 16.94117647%;">10:00 </p>


        <p class="cl" style="float: left; margin-left: 12.82352941%;">13:00 </p>
        <p class="cl" style="float: left; margin-left: 7.88235294%;">15:00 </p>

        <p class="cl" style="float: left; margin-left: 17.76470588%;">19:00 </p>


        <p class="cl" style="float: left; margin-left: 7.88235296%;">21:00 </p>
        <p class="cl" style="float: left; margin-left: 12.82352940%;">24:00 </p>


    </div>


</div>

<br>

<a data-id="00000000000000000000000000000821" data-name="Мисливець з Уолл-стріт" data-category="2d"
   data-brand="Планета Кіно" data-position="15" data-list="showtimes" class="time  h-20"
   href="https://cabinet.planetakino.ua/hall/?show_id=356679&amp;theatre_id=pk-lvov"
   style="left: 61.5741%; margin-left: 5px;" title=""> 20:05 </a>

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

