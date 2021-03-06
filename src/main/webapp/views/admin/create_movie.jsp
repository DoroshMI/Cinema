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

    <ol class="breadcrumb" style="margin-bottom: 5px;">
        <li><a href="/admin">Theater</a></li>
        <li><a href="/cinemas/form">Create cinema</a></li>
        <li class="active">Create movie</li>

    </ol>

    <h1 style="text-align: center;">Create movie</h1>


    <form:form modelAttribute="movieDTO" action="/movies/form?${_csrf.parameterName}=${_csrf.token}" method="post"
               enctype="multipart/form-data" class="form-horizontal">

        <div class="form-group">
            <label for="inputNameMovie" class="col-sm-2 control-label">Name
                movie</label>
            <div class="col-sm-5">
                <form:input path="title" type="text" name="moviename" class="form-control"
                            id="inputNameMovie" placeholder="name movie" required="true"/>
            </div>
        </div>

        <div class="form-group">
            <label for="inputMinutes" class="col-sm-2 control-label">Minutes</label>
            <div class="col-sm-5">
                <form:input path="minutes" type="text" name="minutes" class="form-control"
                            id="inputMinutes" placeholder="minutes" required="true" pattern="[0-9]{2,3}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="inputShowFromDate" class="col-sm-2 control-label">Show
                from date</label>
            <div class="col-sm-5">
                <form:input path="showFromDate" type="date" name="showFromDate" class="form-control"
                            id="inputShowFromDate" placeholder="yyyy-mm-dd" required="true" pattern="[0-9-]{10}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="inputShowFromDate" class="col-sm-2 control-label">Show
                to date</label>
            <div class="col-sm-5">
                <form:input path="showToDate" type="date" name="showToDate" class="form-control"
                            id="inputShowToDate" placeholder="yyyy-mm-dd" required="true" pattern="[0-9-]{10}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="container">
                <div class="row">
                    <label class="col-sm-2 control-label">Image logo:</label>
                    <input type="file" id="imageLogo" name="imageLogo" required="required"/></div>
            </div>
        </div>


        <div class="form-group">
            <div class="container">
                <div class="row">
                    <label class="col-sm-2 control-label">Multi-loading images:</label>
                    <input type="file" id="fileMulti" name="images" required="required" multiple/>
                </div>
            </div>
        </div>


        <%--<input type="file" id="fileMulti" name="images" required="required"/>--%>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">create/update
                    movie
                </button>
            </div>
        </div>
    </form:form>


</div>
</body>


</html>