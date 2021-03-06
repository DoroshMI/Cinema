<%@  page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IMAX | person cabinet</title>


    <script type="text/javascript">
        //Set the date we're counting down to
        seance = ${seance.id};
        globalTime = new Date().getTime();

        console.log("time" + new Date().getTime());

        var countDownDate = new Date().getTime() + 1 * 60 * 1000;



        // Update the count down every 1 second
        var x = setInterval(
            function () {

// Get todays date and time
                var now = new Date().getTime();

// Find the distance between now an the count down date
                var distance = countDownDate - now;

                var minutes = Math.floor((distance % (1000 * 60 * 60))
                    / (1000 * 60));
                var seconds = Math.floor((distance % (1000 * 60)) / 1000);

                document.getElementById("time").innerHTML = minutes + "хв "
                    + seconds + "сек ";


// If the count down is over, write some text
                if (distance < 0) {
                    clearInterval(x);
                    document.getElementById("time").innerHTML = "";
                    $("#planeta-rules")
                        .html(
                            'Твої квитки повернулися у вільний продаж. Відкрий сеанс і обери нові місця');
                    $("#btn-buy-tickets").html("ОБРАТИ НОВІ МІСЦЯ");
                    $("#hall-return").css("display", "none");
                    $("#btn-buy-tickets").attr('onclick', '');
                    $("#btn-buy-tickets").attr('href',
                        '/seances/${seance.id}'.replace('amp;', ''));
                }
            }, 1000);
    </script>

</head>

<body>
<div style="margin: 15px;">
    <p id="demo" style="text-align: center; font-size: 60px;"></p>

    <div class="row">

        <!-- Left column -->
        <div class="col-xs-12 col-md-4">


            <div class="sidebar-left sidebar-presentation">
                <!--div class="target" style="width: 100%; height: 100%; padding-left:0px; padding-bottom:20px;  " data-banner="buy-online-banner" data-banneranimation="slideInDown" data-bannerbefore="1"></div-->
                <div class="sitebar-content">
                    <div class="presentation">
                        <div class="presentation_top"></div>
                        <div class="poster">
                            <a href="http://planetakino.ua/lvov/movies/orbita_9/"
                               target="_blank"><img
                                    src="${order.seance.movie.movieImageLogo}"
                                    alt="poster"> </a>
                        </div>
                        <div class="film_about">
                            <div class="item">
                                <p>
                                    <strong>Фільм</strong>
                                </p>
                                <p>${order.seance.movie.title}</p>
                            </div>
                            <div class="item">
                                <p>
                                    <strong>Технологія</strong>
                                </p>
                                <p>${order.seance.schedule.moviehall.technology}</p>
                            </div>

                            <div class="item">
                                <p>
                                    <strong>Дата та час сеансу</strong>
                                </p>
                                <p>${order.seance.startTime}</p>
                                <!--p><a href="#">Додати подію у календар</a></p-->
                            </div>
                            <div class="item">
                                <p>
                                    <strong>Зал</strong>
                                </p>
                                <p>${order.seance.schedule.moviehall.name}</p>
                            </div>
                            <div class="item">
                                <p>
                                    <strong>Кінотеатр</strong>
                                </p>
                                <p>
                                    ${currentCinema.name}<br> Львівська область, с. Сокільники,
                                    вул. Стрийська, 30<br>
                                </p>
                            </div>

                            <div class="item">

                                <p>
                                    <strong>Вікові обмеження</strong>
                                </p>
                                <a href="javascript:void(0)">12+</a>
                                <div class="splash">
                                    <div class="ico_splash"></div>
                                    <a href="javascript:void(0)" class="close_splash">x</a>
                                    <p>
                                        На цей фільм Міністерством Культури України встановлено <b>вікове
                                        обмеження</b>. Ми не маємо права пропустити до кінозалу осіб,
                                        які не досягли цього віку, без супроводу батьків або опікунів
                                    </p>
                                </div>
                            </div>
                            <div class="item item-phone">
                                <p>
                                    <strong class="tel">0 800 300 600</strong>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>

        <!-- Right column -->
        <div class="col-xs-12 col-md-8">


            <div class="" style="padding-top: 0px;">

                <h1>Орбіта 9</h1>

                <div class="col1">

                    <h2>
                        Купівля квитків: <span id="time" style="color: red"></span>
                    </h2>
                    <span id="timeout"><p>Твої квитки зарезервовано, щоб
ніхто не зміг їх купити.</p>
<p>Якщо ти не встигнеш провести оплату за цей час, квитки
повернуться у вільний продаж і тобі доведеться заново пройти
процедуру вибору місць та оплати.</p>
<p>Перед оплатою квитків, будь ласка, переконайся, що ти не
помилився у виборі кінотеатру, фільму, дати та сеансу.</p></span>
                    <h3>Обери зручний спосіб оплати</h3>

                    <div class="cart_list">

                        <div class="item"
                             style="background: none; font-size: 14px; color: #aeaeae;">
                            <div class="pleace"></div>
                            <div class="price">
                                <em>вартість</em>
                            </div>
                            <div class="comment"></div>


                            <div class="empty" style="display: none"></div>
                        </div>

                        <div id="ticket-container">

                            <c:forEach items="${order.seats}" var="seat">

                                <div class="item" id="ticket" row="5" seat="17" glassesid=""
                                     glassesname="">
                                    <div class="pleace">
                                        <p>ряд ${seat.coordinate.row + 1}, місце
                                                ${seat.coordinate.column + 1}</p>
                                    </div>
                                    <div class="price">
                                        <p>
                                            <strong> ${seat.price}.00 грн.</strong>
                                        </p>
                                    </div>
                                    <div class="comment">
                                        <p>
                                            <strong>${seat.price * 10} бонусів</strong>
                                        </p>
                                    </div>

                                    <div class="empty">
                                        <button onclick="deleteTicketFromInfo(${seat.getId()})">
                                            delete
                                        </button>


                                    </div>

                                </div>


                            </c:forEach>

                        </div>

                        <div class="result" id="totalAmount" amount="140.00"
                             discount="10.00" promodiscount="0">


                            <div class="buy-online-message" id="discount">
                                <div class="buy-online-message__icon"></div>
                                <div class="buy-online-message__text" id="discount-text">У
                                    касі дорожче на 10 грн.
                                </div>
                            </div>


                            <div>
                                <p>
                                    <strong id="totalBonus"> Завтра тобі буде нараховано ${priceTickets} бонусів. За
                                        купівлю у RE'LUX бонуси не нараховуються</strong>
                                </p>
                                <div class="line"></div>

                                <p>
                                    <strong id="totalPrice">Всього до сплати: ${priceTickets} грн.</strong>
                                </p>
                            </div>

                        </div>


                        <div class="cart_list_finish" style="max-width: 815px;">
                            <p>
                                <a href="/buyTickets"
                                   style="float: left;" class="batton batton2"
                                   id="btn-buy-tickets">купити квитки за ${priceTickets} грн.</a>

                            </p>

                            <a href="/seances/${seance.id}"
                               style="margin-left: 25px; background-color: #fff; color: #1aa3e0;"
                               class="batton batton2"> ←Повернутись до вибору місць </a>


                            <div style="clear: both; padding-top: 10px;">
                                <p>
                                    <strong>Вітаємо з покупкою! Пам’ятай, купуючи квитки
                                        на сайті чи у мобільному додатку ти платиш трішки менше, ніж
                                        у касі!</strong>
                                </p>
                            </div>
                        </div>


                    </div>
                </div>


            </div>

        </div>
    </div>
</div>


<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>


<script src="/js/orderInInfo.js"></script>

</body>


</html>

