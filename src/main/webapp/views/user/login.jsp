<%@  page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IMAX | theater</title>

    <csrf disabled="true"/>

</head>

<body>
<div style="margin: 15px;">



    <div class="form-horizontal">
        <div class="col-sm-2"></div>
        <h1>Вхід</h1>
    </div>


    <form:form action="/login" method="post" class="form-horizontal">

        <div class="form-group">
            <label for="inputEmailOrPhone" class="col-sm-2 control-label">Email or password</label>
            <div class="col-sm-5">

                <input name="username" type="text" value="${defaltUsername}" class="form-control" id="inputEmailOrPhone" autocomplete="off" placeholder="Email or password">

            </div>
        </div>

        <div class="form-group">
            <label for="inputPassword" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-5">
                <input name="password" type="password" class="form-control" id="inputPassword" placeholder="Password">
            </div>

            <!-- error -->
            <label style="color: red; text-align: left;" class="col-sm-5 control-label"
                   for="inputPassword">${userException}</label>

        </div>

        <div  class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label> <input type="checkbox"> Remember me </label>
                </div>
            </div>

        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign in</button>
            </div>
        </div>

        <%--<div>--%>
            <%--<input name = "image" type="file">--%>

        <%--</div>--%>

    </form:form>




</div>
</body>


</html>

