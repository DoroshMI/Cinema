<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | theater</title>

</head>

<body>
	<div style="margin: 15px;">


		<div class="form-horizontal">
			<div class="col-sm-2"></div>
			<h1>Реєстрація у Клубі</h1>
		</div>


		<form:form modelAttribute="user" action="/signup?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data"
			class="form-horizontal">

			<div class="form-group">
				<label for="inputName" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-5">
					<form:input path="name" type="text" class="form-control"
						id="inputName" placeholder="Name" />
				</div>
				<!-- error -->
				<label style="color: red; text-align: left;" class="col-sm-5 control-label"
					for="inputName">${userNameException}</label>
			</div>

			<div class="form-group">
				<label for="inputEmail" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-5">
					<form:input path="email" type="email" class="form-control"
						id="inputEmail" placeholder="Email" />
				</div>
				<!-- error -->
				<label style="color: red; text-align: left;" class="col-sm-5 control-label"
					for="inputEmail">${emailExcaption}</label>

			</div>

			<div class="form-group">
				<label for="inputPhone" class="col-sm-2 control-label">Phone</label>
				<div class="col-sm-5">
					<form:input path="phone" type="text" class="form-control"  title=""
						id="inputPhone" placeholder="Number" />
				</div>
				<!-- error -->
				<label style="color: red; text-align: left;" class="col-sm-5 control-label"
					for="inputPhone" >${phoneExcaption}</label>
			</div>

			<div class="form-group">
				<label for="inputPassword" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-5">
					<form:input path="password" type="password" class="form-control"
						id="inputPassword" placeholder="Password" />
				</div>
				<!-- error -->
				<label style="color: red; text-align: left;" class="col-sm-5 control-label"
					for="inputPassword">${passwordException}</label>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Sign in</button>
				</div>
			</div>

			<div>
				<input name = "image" type="file">

			</div>


		</form:form>


	</div>
</body>


</html>

