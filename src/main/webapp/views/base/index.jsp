<%@  page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IMAX | theater</title>

</head>

<body>
<div style="margin: 15px;">



    <h3 style="margin-top: -15px; text-align: right;"><a href="/admin">administration</a></h3>

    <div class="row">
        <div class="col-xs-12 col-md-8">

            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">

                    <div class="item active">

                        <a href="/cinemas/${cinema.id}/movies"> <img src="/image/1.jpg" alt="..." width="100%"></a>
                        <div class="carousel-caption">
                            <h1><a href="/cinemas/${cinema.id}/movies"> ${cinema.name} </a></h1>
                        </div>
                    </div>


                    <c:forEach var="c" items="${cinemas}">

                        <div class="item ">
                            <a href="/cinemas/${c.id}/movies"> <img src="/image/1.jpg" alt="..." width="100%"></a>
                            <div class="carousel-caption">
                                <h1><a href="/cinemas/${c.id}/movies"> ${c.name} </a></h1>
                            </div>
                        </div>

                    </c:forEach>


                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

        </div>
        <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
    </div>


    <form:form action="/logout" method="post">

        <button type="submit">logout</button>
    </form:form>

</div>
</body>


</html>