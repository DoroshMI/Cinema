<%@  page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IMAX | theater</title>

</head>

<body>
<div style="margin: 15px;">
<<<<<<< HEAD


    <div class="row">
        <div class="col-xs-12 col-md-8">

            <div id="carousel-example-generic" class="carousel slide"
                 data-ride="carousel">

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">

                    <div class="item active">

                        <a href="/cinemas/${currentCinema.id}/movies">
                            <img src="${currentCinema.cinemaImage}" alt="${currentCinema.cinemaImage}" width="100%"></a>
                        <div class="carousel-caption">
                            <h1>
                                <a href="/cinemas/${currentCinema.id}/movies"> ${currentCinema.name} </a>
                            </h1>
                        </div>
                    </div>


                    <c:forEach var="c" items="${cinemas}">
                        <c:choose>
                            <c:when test="${c.id != currentCinema.id}">
                                <div class="item ">
                                    <a href="/cinemas/${c.id}/movies"> <img src="${c.cinemaImage}"
                                                                            alt="${c.cinemaImage}" width="100%"></a>
                                    <div class="carousel-caption">
                                        <h1>
                                            <a href="/cinemas/${c.id}/movies"> ${c.name} </a>
                                        </h1>
                                    </div>

                                </div>
                            </c:when>
                        </c:choose>

                    </c:forEach>


                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic"
                   role="button" data-slide="prev">

                    <span
                        class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span  class="sr-only" >Previous</span>

                </a>
                <a class="right carousel-control" href="#carousel-example-generic"
                   role="button" data-slide="next"> <span
                        class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

        </div>
        <div id="addressCinemma" class="col-xs-6 col-md-4">
            <h2>Address cinema</h2>
            <div style="margin-bottom: 25px">
                <label>city: ${currentCinema.address.city}</label>
            </div>

            <div style="margin-bottom: 25px">
                <label>addressLine: ${currentCinema.address.addressLine}</label>
            </div>

            <div style="margin-bottom: 25px">
                <label>state: ${currentCinema.address.state}</label>
            </div>

        </div>
    </div>


</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>


<script src="/js/index.js"></script>

=======


    <div class="row">
        <div class="col-xs-12 col-md-8">

            <div id="carousel-example-generic" class="carousel slide"
                 data-ride="carousel">
                <!-- Indicators -->
                <%--<ol id="carousel-indicators" class="carousel-indicators">--%>
                <%----%>
                <%----%>
                <%--<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>--%>
                <%--<li data-target="#carousel-example-generic" data-slide-to="1"></li>--%>
                <%--<li data-target="#carousel-example-generic" data-slide-to="2"></li>--%>
                <%--<li data-target="#carousel-example-generic" data-slide-to="3"></li>--%>
                <%--<li data-target="#carousel-example-generic" data-slide-to="4"></li>--%>
                <%--<li data-target="#carousel-example-generic" data-slide-to="5"></li>--%>
                <%--<li data-target="#carousel-example-generic" data-slide-to="6"></li>--%>
                <%--</ol>--%>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">

                    <div class="item active">

                        <a href="/cinemas/${currentCinema.id}/movies">
                            <img src="${currentCinema.cinemaImage}" alt="${currentCinema.cinemaImage}" width="100%"></a>
                        <div class="carousel-caption">
                            <h1>
                                <a href="/cinemas/${currentCinema.id}/movies"> ${currentCinema.name} </a>
                            </h1>
                        </div>
                    </div>


                    <c:forEach var="c" items="${cinemas}">
                        <c:choose>
                            <c:when test="${c.id != currentCinema.id}">
                                <div class="item ">
                                    <a href="/cinemas/${c.id}/movies"> <img src="${c.cinemaImage}"
                                                                            alt="${c.cinemaImage}" width="100%"></a>
                                    <div class="carousel-caption">
                                        <h1>
                                            <a href="/cinemas/${c.id}/movies"> ${c.name} </a>
                                        </h1>
                                    </div>
                                </div>
                            </c:when>
                        </c:choose>

                    </c:forEach>


                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic"
                   role="button" data-slide="prev"> <span
                        class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a> <a class="right carousel-control" href="#carousel-example-generic"
                        role="button" data-slide="next"> <span
                    class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
            </div>

        </div>
        <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
    </div>


</div>


>>>>>>> origin/master
</body>


</html>