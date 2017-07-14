<%@  page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IMAX | person cabinet</title>


    <script src="/js/orderInInfo.js"></script>

    <script type="text/javascript">
        //Set the date we're counting down to
        seance = ${seance.id};
        var countDownDate = new Date().getTime() + (1 - (  new Date().getTime() - new Date("${order.localDateTime}").getTime()) / (60 * 1000) ) * 1 * 60 * 1000;
        console.log("TIME     " + (1 - (  new Date().getTime() - new Date("${order.localDateTime}").getTime()) / (60 * 1000) ));


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

                    document.getElementById("btn-buy-tickets1").innerHTML = '<a href="/seances/' + seance.valueOf() + '" style="float: left;" class="batton batton2">ОБРАТИ НОВІ МІСЦЯ </a>';
                }
            }, 1000);
    </script>


</head>

<body>
<div style=" margin: 15px 15px 15px 100px;">


    <div class="sidebar-left" id="sidebar-left" style="position: inherit; top: 0px;">
        <div class="sitebar-content">
            <p>
                <a href="https://cabinet.planetakino.ua/choose-tickets?showtimeId=365889&amp;theaterId=pk-lvov&amp;transactionId=16598752&amp;ids=500008%2C500009"
                   class="black_triangel" id="black_triangel" onclick="goToBuy = true;"></a></p>
        </div>
    </div>


    <div class="center">
        <div class="content">
            <h1>Оплата банківською картою</h1>

        </div>    <!-- content -->
        <div class="platon_block">
            <div class="platon_logo"><img src="/image/platon_logo.png"></div>
        </div>
        <div class="content">
            <div class="payment_coll">

                <%--<div class="platon_line_block">--%>
                <%--<p><strong>Твій квиток заброньовано. <br>Будь ласка, здійсни оплату протягом 1 хвилини!</strong></p>--%>
                <%--<p class="platon_dascription"><span>Оплата квитків у «IMAX-LOGOS» здійснюється через сертифікованого партнера – платіжну систему «Platon». Це максимально безпечно, зручно та без жодних комісій!</span>--%>
                <%--</p>--%>
                <%--<div class="line-order-block">--%>
                <%--<div class="text">--%>
                <%--<p class="right" id="txt-progress-bar"><strong>Залишилось .... хвилин</strong></p>--%>
                <%--</div>--%>
                <%--<div class="line_order">--%>
                <%--<div id="progress-bar" style="width: 97%;"></div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--</div>--%>

                <h2>
                    Купівля квитків: <span id="time" style="color: red"></span>
                </h2>


                <div class="check_list">
                    <table>
                        <tbody>
                        <tr>
                            <td class="check1">Кінотеатр</td>
                            <td class="check2"><strong>${currentCinema.name}
                                (${currentCinema.address.addressLine }) </strong></td>
                        </tr>
                        <tr>
                            <td class="check1">№ замовлення</td>
                            <td class="check2"><strong>${order.id}</strong></td>
                        </tr>
                        <tr>
                            <td class="check1">Опис</td>
                            <td class="check2"><strong>"${seance.movie.title}"
                                Зал: ${seance.schedule.moviehall.name} ${seance.startTime.toLocalTime()}
                            </strong></td>
                        </tr>
                        <tr>
                            <td class="check1">місце</td>
                            <td class="check2"><strong> <c:forEach var="seat"
                                                                   items="${order.seats}">ряд ${seat.coordinate.row + 1} місце ${seat.coordinate.column +1}; </c:forEach> </strong>
                            </td>
                        </tr>
                        <tr>
                            <td class="check1">Всього до сплати</td>
                            <td class="check2"><strong> ${priceTickets} грн.</strong></td>
                        </tr>
                        </tbody>
                    </table>
                </div>


                <div id="platon-form" style=" background-color: lightblue; width:550px;height:450px">


                    <div style="margin: 25px;" class="content">
                        <div class="p_page">

                            <div class="spin"></div>


                            <div class="card">
		<span style="margin-bottom: 25px;">На твоїй картці можуть бути встановлені обмеження на суму та кількість операцій в Інтернеті.
							Рекомендуємо перед оплатою зв'язатися з банком та впевнитися у тому, що всі обмеження зняті.</span>
                                <div><br> <br></div>


                                <%--<form:form modelAttribute="creditCardDTO" action="/checkCreditCard" method="post" name="process"--%>
                                <%--id="process" >--%>


                                <%--<span class="infocard">Введи реквізити платіжної карти (номер і термін дії) </span>--%>


                                <%--<div class="numbercard">--%>
                                <%--<form:input path="accountNumberI" type="tel" name="card_num1" value="" id="cardNumber"--%>
                                <%--autocomplete="off" pattern="[0-9]*" maxlength="4"--%>
                                <%--class="NumGroup error"--%>
                                <%--onkeyup="if(this.value.length >= 4){document.getElementById('cardNumber2').focus();}"--%>
                                <%--aria-required="true" aria-invalid="true" required="true"/>--%>
                                <%--<form:input path="accountNumberII"  type="tel" name="card_num2" value="" id="cardNumber2"--%>
                                <%--autocomplete="off" pattern="[0-9]*" maxlength="4"--%>
                                <%--class="NumGroup error"--%>
                                <%--onkeyup="if(this.value.length >= 4){document.getElementById('cardNumber3').focus();}"--%>
                                <%--aria-required="true" required="true"/>--%>
                                <%--<form:input path="accountNumberIII"  type="tel" name="card_num3" value="" id="cardNumber3"--%>
                                <%--autocomplete="off" pattern="[0-9]*" maxlength="4"--%>
                                <%--class="NumGroup error"--%>
                                <%--onkeyup="if(this.value.length >= 4){document.getElementById('cardNumber4').focus();}"--%>
                                <%--aria-required="true" required="true"/>--%>
                                <%--<form:input path="accountNumberIV"  type="tel" name="card_num4" value="" id="cardNumber4"--%>
                                <%--autocomplete="off" pattern="[0-9]*" maxlength="4"--%>
                                <%--class="NumGroup error"--%>
                                <%--onkeyup="if(this.value.length >= 4){document.getElementById('cardExpirationMonth').focus();}"--%>
                                <%--aria-required="true" required="true"/>--%>

                                <%--<div> <br></div>--%>
                                <%--<label for="card_num"> Будь ласка, введіть номер--%>
                                <%--кредитної картки</label>--%>
                                <%--</div>--%>

                                <%--&lt;%&ndash;<div class="datecard">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<span id="arrow"></span>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<span id="arrow1"></span>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<form:select path="expirationMonth" id="cardExpirationMonth" name="card_exp_month"&ndash;%&gt;--%>
                                <%--&lt;%&ndash;onchange="if(this.value.length >= 2){document.getElementById('cardExpirationYear').focus();}"&ndash;%&gt;--%>
                                <%--&lt;%&ndash;aria-required="true" class="error" required="true" pattern="[0-9]*">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option value="0" disabled="" selected="" hidden="">Місяць</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="ml" value="01">&nbsp;&nbsp;&nbsp;01</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="ml" value="02">&nbsp;&nbsp;&nbsp;02</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="ml" value="03">&nbsp;&nbsp;&nbsp;03</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="ml" value="04">&nbsp;&nbsp;&nbsp;04</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="ml" value="05">&nbsp;&nbsp;&nbsp;05</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="ml" value="06">&nbsp;&nbsp;&nbsp;06</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="ml" value="07">&nbsp;&nbsp;&nbsp;07</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="ml" value="08">&nbsp;&nbsp;&nbsp;08</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="ml" value="09">&nbsp;&nbsp;&nbsp;09</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="ml" value="10">&nbsp;&nbsp;&nbsp;10</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="ml" value="11">&nbsp;&nbsp;&nbsp;11</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="ml" value="12">&nbsp;&nbsp;&nbsp;12</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</form:select>&ndash;%&gt;--%>

                                <%--&lt;%&ndash;<form:select path="expirationYear" id="cardExpirationYear" name="card_exp_year"&ndash;%&gt;--%>
                                <%--&lt;%&ndash;onchange="if(this.value.length >= 4){document.getElementById('cvv').focus();}"&ndash;%&gt;--%>
                                <%--&lt;%&ndash;aria-required="true" class="error" pattern="[0-9]*">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option value="0" disabled="" selected="" hidden="">&nbsp;Рік</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="yl" value="2017">2017</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="yl" value="2018">2018</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="yl" value="2019">2019</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="yl" value="2020">2020</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="yl" value="2021">2021</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="yl" value="2022">2022</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="yl" value="2023">2023</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="yl" value="2024">2024</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="yl" value="2025">2025</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="yl" value="2026">2026</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option class="yl" value="2027">2027</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</form:select>&ndash;%&gt;--%>

                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

                                <%--<div class="cod">--%>
                                <%--<div> <br></div>--%>
                                <%--<span class="cvvname"> CVC2/CVV2:</span>--%>

                                <%--<form:input path="securityCode" name="cvv2" maxlength="3" id="cvv" pattern="[0-9]*"--%>
                                <%--onkeyup="if(this.value.length >= 3){document.getElementById('button').focus();}"--%>
                                <%--aria-required="true" class="error" required="true"/>--%>
                                <%--</div>--%>


                                <%--<div id="line"></div>--%>

                                <%--<input type="hidden" name="totalPrice" value="${priceTickets}"/>--%>
                                <%--<!-- error -->--%>
                                <%--<label style="color: red; text-align: left;"--%>
                                <%-->${exception}</label>--%>
                                <%--<div   id="btn-buy-tickets1" class="buttonorig">--%>
                                <%--<form:button id="button" class="batton batton2">Оплатити</form:button>--%>
                                <%--</div>--%>


                                <%--</form:form>--%>

                                <form:form action="/checkCreditCard" method="post" name="process" id="process">
                                    <div id="btn-buy-tickets1" class="buttonorig">
                                        <button id="button" class="batton batton2">Оплатити</button>
                                    </div>
                                    <input type="hidden" name="totalPrice" value="${priceTickets}"/>
                                </form:form>



                            </div>


                        </div>
                    </div>


                </div>


                <div><img style="width: 550px; " src="/image/payments.jpg"></div>
                <div><br> <br></div>
                <div class="col1 feetback">
                    <p>У разі неуспішного завершення покупки, будь ласка, звернися у наш Контакт Центр через онлайн-чат
                        на
                        нашому <a href="https://planetakino.ua/">сайті</a>, надішли лист на <a
                                href="mailto:info@planetakino.ua">info@planetakino.ua</a> або зателефонуй за номером
                        <strong>0 800 300 600</strong> (з 9:00 до 22:00, безкоштовно по Україні з будь-якого номеру).
                    </p>

                </div>
            </div>


        </div>

    </div><!-- center -->


</div>


</body>


</html>

