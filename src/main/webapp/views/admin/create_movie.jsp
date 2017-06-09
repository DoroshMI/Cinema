<%@  page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

    <h3 style="margin-top: -15px; text-align: right;">
        <a href="/admin">administration</a>
    </h3>

    <h1 style="text-align: center;">Create movie</h1>


    <form:form action="/movies/form" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="inputNameMovie" class="col-sm-2 control-label">Name
                movie</label>
            <div class="col-sm-5">
                <input type="text" name="moviename" class="form-control"
                       id="inputNameMovie" placeholder="name movie">
            </div>
        </div>

        <div class="form-group">
            <label for="inputMinutes" class="col-sm-2 control-label">Minutes</label>
            <div class="col-sm-5">
                <input type="text" name="minutes" class="form-control"
                       id="inputMinutes" placeholder="minutes">
            </div>
        </div>

        <div class="form-group">
            <label for="inputShowFromDate" class="col-sm-2 control-label">Show from date</label>
            <div class="col-sm-5">
                <input type="date" name="showFromDate" class="form-control"
                       id="inputShowFromDate" placeholder="yyyy-mm-dd">
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">create moviehall</button>
            </div>
        </div>
    </form:form>


    <br>
    <br>
    <a href="/">to theater</a>

</div>
</body>


</html>