<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/css/style.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<title>IMAX | theater</title>
</head>

<body>

	<!-- HADER container begin -->
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="row">
			<div class="d col-xs-12 col-sm-8 col-md-8">


				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="/"><img class="img-logo"
							src="/image/logo.png"></a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="schedule.html">Розклад</a></li>
							<li><a href="/movies/">Фільми</a></li>
							<li><a href="https://planetakino.ua/lvov/imax/">IMAX</a></li>


							<li role="separator" class="divider dropdown"><a
								href="https://planetakino.ua/lvov/apps/#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">...</a>
								<ul class="dropdown-menu">

									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/theatres/">Кінотеатри</a></li>
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/about/faq/">Допомога.
											Відповіді на запитання</a></li>
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/i/sale/">Знижки</a></li>
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/i/gift-certificate/">Подарунковий
											сертифікат</a></li>
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/apps/">Мобільний додаток</a></li>
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/events/">Новини</a></li>
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/about/">Про Планету Кіно</a></li>
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/about/vacancy/">Робота у
											нас</a></li>
								</ul></li>
						</ul>

					</div>


				</div>


			</div>

			<div class="d col-xs-12 col-sm-4 col-md-4">
				<div class="container-fluid">
					<div class="row">


						<ul class="nav nav-pills navbar-right">

							<!-- Choose cinema-->
							<li role="separator" class="divider dropdown"><a
								href="https://planetakino.ua/lvov/apps/#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">Cinema:
									${cinema.name}</a>
								<ul class="dropdown-menu">

									<c:forEach items="${cinemas}" var="c">
										<li class="addon-menu__list-item"><a
											href="/cinema/${c.id}">${c.name}</a></li>
									</c:forEach>

								</ul></li>


							<!-- Registration-->
							<li role="presentation" class="dropdown"><a
								class="dropdown-toggle" data-toggle="dropdown" href="#"
								role="button" aria-haspopup="true" aria-expanded="false">
									Вхід <span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="/login">Вхід</a></li>
									<li><a href="/signup" class="register-link">
											Реєстрація </a></li>
								</ul></li>

						</ul>


					</div>

				</div>


			</div>
		</div>

	</div>
	</nav>
	<!-- ROW HADER container end -->

	<!-- -------------------------CENTER container begin----------------------------- -->

	<h1 class="text" style="text-align: center;">Welcome to theater of
		future</h1>
	<h2 style="text-align: center;">List Cinema</h2>





	<div class="row">
		<div class="col-xs-12 col-md-6">
			<h2 style="margin-left: 20px;" class="red">Cinemas</h2>
			<ol>
				<c:forEach var="cinema" items="${cinemas}">



					<div style="margin-left: 30px; margin-bottom: 20px;" role="separator"
						class="divider dropdown">
						<a href="/#"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-haspopup="true" aria-expanded="false">
							${cinema.name}</a>
						<ul class="dropdown-menu">
							<li><a href="/cinema/${cinema.id}">choose</a></li>
							<li><a href="/cinema/${cinema.id}/update">update</a></li>
							<li><a href="/cinema/${cinema.id}/delete">delete</a></li>
							
						</ul>
					</div>





					<!-- <li><a href="/cinema/${cinema.id}">${cinema.name}</a>
						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								action <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
								<li><a href="/cinema/${cinema.id}/update">update</a></li>
								<li><a href="/cinema/${cinema.id}/delete">delete</a></li>
								<li><a href="/cinema/${cinema.id}">choose</a></li>

							</ul>
						</div></li> -->



				</c:forEach>
			</ol>
			
			<br> <a style="margin-left: 30px" href="/createCinema">Create cinema</a>
		</div>

		<div class="col-xs-12 col-md-6">
			<h2 style="margin-left: 20px; color: red;">Movies of theater</h2>

			<ol>
				<c:forEach var="movie" items="${movies}">
				
				<div style="margin-left: 30px; margin-bottom: 20px;" role="separator"
						class="divider dropdown">
						<a href="/#"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-haspopup="true" aria-expanded="false">
							${movie.title}</a>
						<ul class="dropdown-menu">
							<li><a href="/movie/${movie.id}">choose</a></li>
							<li><a href="/movie/${movie.id}/update">update</a></li>
							<li><a href="/movie/${movie.id}/delete">delete</a></li>
							
						</ul>
					</div>
				
				
				
				
				</c:forEach>

			</ol>

			<a href="/createMovie">Create movie</a>
		</div>
	</div>

	<!-- CENTER container the end -->

	<!-- FOOTER container begin, TODO: please create component -->
	<footer id="footer" class="footer"> <!-- DESCRIPTION BOX begin -->
	<div class="description-box">
		<div class="description-box__title" data-toggle="Сховати опис">Читати
			опис</div>
		<div class="description-box__wrapper" style="display: none;"></div>
	</div>

	<div class="copyright-and-contacts">
		<a href="mailto:info@planetakino.ua">info@planetakino.ua</a>
		<p>Всі звернення, надіслані на цю пошту, потраплять до власників
			та керівництва Планети Кіно</p>
	</div>

	<div class="search right-panel">
		<div class="reducer">
			<!--form object-id="114">
  <input type="search" name="q" placeholder="пошук" />
</form-->
			<div class="footer-contacts">
				<a href="tel:0800300600"><h3>0 800 300 600</h3></a>
				<p>
					Щоденно, 9:00—22:00 <br>Безкоштовно по Україні з будь-якого
					номеру
				</p>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	</footer>
	<!-- FOOTER container the end -->

</body>
</html>