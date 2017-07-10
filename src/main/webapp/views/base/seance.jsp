<%@  page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IMAX | Особистий кабінет</title>




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
                <input type="hidden" id="columns" value="${columns}"></input>
                <div id="seatsChart" class="seatsChart">

                    <c:forEach items="${allSeats }" var="rowSeats">

                        <div class="seatRow">
                            <div class="seatRowNumber">Row
                                    ${rowSeats[0].coordinate.row + 1}</div>
                            <c:forEach items="${rowSeats}" var="seat">

                                <c:choose>

                                    <c:when test="${seat.freeSeat == true}">

                                        <c:choose>
                                            <c:when test="${seatsId.contains(seat.id)}">
                                                <div style="margin-right: 5px;" class=" seatNumber">
                                                    <button class="buttonForReservedTicket">
                                                            ${seat.coordinate.column+1}
                                                    </button>
                                                </div>


                                            </c:when>
                                            <c:otherwise>

                                                <div style="margin-right: 5px;" class=" seatNumber">
                                                    <button onclick="reserveTicket(${seat.getId()})"
                                                            class="buttonForAddTicket">
                                                            ${seat.coordinate.column+1}
                                                    </button>
                                                </div>

                                            </c:otherwise>

                                        </c:choose>

                                    </c:when>

                                    <%--unable seat--%>
                                    <c:otherwise>
                                        <div style="margin-left: 11px; margin-right: 11px; "
                                             class=" seatUnavailable">
                                                ${seat.coordinate.column+1}</div>
                                    </c:otherwise>

                                </c:choose>


                            </c:forEach>

                        </div>

                    </c:forEach>

                </div>

            </div>

            <sec:authorize access="hasAnyRole('ROLE_ADMIN')"> <h4 style="color : red;">Для покупки квитків потрібно зареєструватися як звичайний користувач</h4> </sec:authorize>
            <sec:authorize access="!isAuthenticated()"> <h4 style="color : red;">Для покупки квитків потрібно зареєструватися</h4> </sec:authorize>
        </div>

        <!-- Buy -->
        <div class="col-xs-12 col-md-4">

            <div class="col-zal-right" style="padding-top: 0px">

                <h2>${seance.movie.title}</h2>
                <input type="hidden" id="seance" value="${seance.id}"></input>
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
                                <strong id="numberTickets">квитки: ${reserveSeats.size() } </strong>
                            </p>
                        </c:otherwise>
                    </c:choose>

                    <div id="reservedTickets">

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
                                            <strong>${seat.price}
                                            </strong><span>грн.</span>
                                        </p>
                                    </div>
                                </div>
                                <div class="cart_item_data cart_item_data4">
                                    <div class="top">
                                        <p></p>
                                    </div>
                                    <div class="bottom">
                                        <p>
                                            <strong>${seat.price * 10}</strong>
                                            <span>бонусів</span>
                                        </p>
                                    </div>
                                </div>
                                <div class="cart_item_data cart_item_data5">
                                        <%--<a href="/deleteTicket/${seat.getId()}" type="button" class="buttonForReservedTicket">delete</a>--%>
                                        <%--<button class="buttonForReservedTicket" value="${seat.getId()}">delete</button>--%>
                                    <button onclick="deleteTicket(${seat.getId()})" value="${seat.getId()}">delete
                                    </button>
                                </div>
                            </div>


                        </c:forEach>


                    </div>


                </div>


                <p class="total">
                    <strong>До сплати:</strong>
                </p>
                <div class="total_summ">
                    <div id="totalPrice" class="total_summ1">
                        <p>${priceTickets}грн.</p>
                    </div>
                </div>
            </div>


            <a id="btn-bye-tickets" onclick="countTickets()"
               href="#"
               class="batton batton2" >Kупити квитки</a>

            <div id="totalBonus" class="total_summ2" style="padding-left: 100px">
                <p>або ${priceTickets * 10} бонусів</p>
            </div>
            <p style="margin-top: 20px; width: 296px; display: none;"
               id="tickets-buy-info">Для продовження покупки необхідно обрати
                хоча б одне місце на схемі залу</p>
        </div>

    </div>




</div>





















<input type="hidden" id="countTickets" value="${user.seats.size()}"/>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>


<script>
     function countTickets() {
         console.log('count' + $('#countTickets').val());
         if ($('#countTickets').val() == 0 ) {
             $("#tickets-buy-info").css("display", "inherit");
             $("#tickets-buy-info").css("color", "red");
             $("#btn-bye-tickets").attr('href', '#');
         } else {
             $("#btn-bye-tickets").attr('href', '/createOrder');
             $("#tickets-buy-info").css("display", "none");
         }
     };

</script>

<script src="/js/order.js"></script>

</body>


</html>


