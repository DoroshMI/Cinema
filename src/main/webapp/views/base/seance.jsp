<%@  page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IMAX | Особистий кабінет</title>


    <script>
        function countTickets() {

            if (${user.seats.size() == 0 || user == null}) {
                $("#tickets-buy-info").css("display", "inherit");
                $("#tickets-buy-info").css("color", "red");
                $("#btn-bye-tickets").attr('href','#');
            } else {
                $("#btn-bye-tickets").attr('href','/createOrder');
                $("#tickets-buy-info").css("display", "none");
            }

        }
    </script>

</head>

<body>


<div style="margin: 15px;">

    <div class="row">
        <!-- Seats -->
        <div class="col-xs-12 col-md-8">


            <div class="seatSelection col-lg-12">

                <p class="seatSection">
                    -------------------------------------------------<br> екран
                </p>


                <!-- Schema seats -->
                <div class="seatsChart">

                    <c:forEach items="${allSeats }" var="rowSeats">

                        <div class="seatRow">
                            <div class="seatRowNumber">Row
                                    ${rowSeats[0].coordinate.row + 1}</div>
                            <c:forEach items="${rowSeats}" var="seat">

                                <c:choose>

                                    <c:when test="${seat.freeSeat == true}">

                                        <c:choose>

                                            <c:when test="${seatsId.contains(seat.id)}">
                                                <div style="margin-right: 5px; background-color: red;"
                                                     class=" seatNumber">
                                                    <a href="/deleteTicket/${seat.getId()}"
                                                       style="color: white;"><strong>${seat.coordinate.column+1}</strong></a>
                                                </div>


                                            </c:when>
                                            <c:otherwise>

                                                <div style="margin-right: 5px;" class=" seatNumber">

                                                    <c:choose>
                                                        <c:when test="${principal == null}">
                                                            <a href="javascript:PopUpShow()"
                                                               style="color: white;">${seat.coordinate.column+1}</a>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="/addTicket/${seat.getId()}"
                                                               style="color: white;">${seat.coordinate.column+1}</a>
                                                        </c:otherwise>

                                                    </c:choose>


                                                </div>

                                            </c:otherwise>

                                        </c:choose>


                                    </c:when>

                                    <c:otherwise>
                                        <div style="margin-right: 5px;"
                                             class=" seatNumber seatUnavailable">
                                                ${seat.coordinate.column+1}</div>
                                    </c:otherwise>

                                </c:choose>


                            </c:forEach>

                        </div>

                    </c:forEach>

                </div>

            </div>

        </div>

        <!-- Buy -->
        <div class="col-xs-12 col-md-4">

            <div class="col-zal-right" style="padding-top: 0px">

                <h2>${seance.movie.title}</h2>
                <p>${cinema.name}</p>
                <p>
                    <strong>${seance.startTime }</strong>
                </p>
                <div class="film_tehnology">
                    <p>${seance.schedule.moviehall.technology }</p>

                </div>

                <div class="ticets-cart" id="ticets-cart">

                    <c:choose>
                        <c:when test="${reserveSeats.size() == 0} ">
                            <p>
                                <strong>Обрати місця</strong>
                            </p>
                        </c:when>
                        <c:otherwise>
                            <p>
                                <strong>квитки: ${reserveSeats.size() } </strong>
                                    ${reserveSeats.size() == 0}
                            </p>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach items="${reserveSeats }" var="seat">

                        <div class="cart_item">
                            <div class="cart_item_data cart_item_data1">
                                <div class="top">
                                    <p>ряд</p>
                                </div>
                                <div class="bottom">
                                    <p>
                                        <strong>${seat.coordinate.row + 1}</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="cart_item_data cart_item_data2">
                                <div class="top">
                                    <p>місце</p>
                                </div>
                                <div class="bottom">
                                    <p>
                                        <strong>${seat.coordinate.column + 1}</strong>
                                    </p>
                                </div>
                            </div>
                            <div class="cart_item_data cart_item_data3">
                                <div class="top">
                                    <p>ціна</p>
                                </div>
                                <div class="bottom">
                                    <p>
                                        <strong>${seat.price}</strong><span>грн.</span>
                                    </p>
                                </div>
                            </div>
                            <div class="cart_item_data cart_item_data4">
                                <div class="top">
                                    <p></p>
                                </div>
                                <div class="bottom">
                                    <p>
                                        <strong>${seat.price * 10}</strong><span>бонусів</span>
                                    </p>
                                </div>
                            </div>
                            <div class="cart_item_data cart_item_data5">
                                <a href="/deleteTicket/${seat.getId()}" type="button">delete</a>
                            </div>
                        </div>


                    </c:forEach>


                </div>


                <p class="total">
                    <strong>До сплати:</strong>
                </p>
                <div class="total_summ">
                    <div class="total_summ1">

                        <p>${priceTickets}грн.</p>
                    </div>
                </div>
            </div>

            <!--<input id="seatIds" type="hidden"
                value="[&quot;400005&quot;,&quot;400004&quot;,&quot;400003&quot;]">  -->

            <a id="btn-bye-tickets"
               href="/createOrder"
               class="batton batton2" onclick="countTickets()">Kупиtи квитки</a>


            <div id="amount-bonuses" class="total_summ2"
                 style="padding-left: 100px">
                <p>або ${priceTickets * 10} бонусів</p>
            </div>
            <p style="margin-top: 20px; width: 296px; display: none;"
               id="tickets-buy-info">Для продовження покупки необхідно обрати
                хоча б одне місце на схемі залу</p>
        </div>

    </div>


    <script type="text/javascript">
        $(document).ready(function () {
            PopUpHide();
        });
        function PopUpShow() {
            $("#popup1").show();
        }
        function PopUpHide() {
            $("#popup1").hide();
        }
    </script>


    <div class="b-popup" id="popup1">
        <div class="b-popup-content">


            <!-- registration -->
            <form:form action="/login" method="post" class="form-horizontal">

                <div class="form-group">
                    <label for="inputEmailOrPhone" class="col-sm-2 control-label">Email
                        or password</label>
                    <div class="col-sm-5">

                        <input name="username" type="text" value="${defaltUsername}"
                               class="form-control" id="inputEmailOrPhone" autocomplete="off"
                               placeholder="Email or password">

                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-5">
                        <input name="password" type="password" class="form-control"
                               id="inputPassword" placeholder="Password">
                    </div>

                    <!-- error -->
                    <label style="color: red; text-align: left;"
                           class="col-sm-5 control-label" for="inputPassword">${userException}</label>

                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label> <input type="checkbox"> Remember me
                            </label>
                        </div>
                    </div>

                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Sign in</button>
                    </div>
                </div>


            </form:form>


            <a href="javascript:PopUpHide()">Hide login</a>
        </div>
    </div>


</div>


</body>


</html>


