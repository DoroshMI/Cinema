<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>

<meta charset="utf-8">
<link rel="stylesheet" href="style.css">

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

<title>imaxMe</title>



</head>

<body>

	<header class="header header-main"> <nav
		class="navbar navbar-default" id="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Brand</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="https://planetakino.ua/lvov/showtimes/">Розклад</a>
				</li>
				<li><a href="https://planetakino.ua/lvov/movies/">Фільми</a></li>
				<li><a href="https://planetakino.ua/lvov/imax/">IMAX</a></li>
				<li><a href="https://planetakino.ua/lvov/4dx/">4DX</a></li>
				<li><a href="https://planetakino.ua/lvov/club/">Клуб</a></li>

				<li role="separator" class="divider dropdown"><a
					href="https://planetakino.ua/lvov/apps/#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">...</a>
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
		<!-- /.navbar-collapse -->




		<div class="navigation-section right register-block">
			<div id="auth_block" class="auth-block">

				<a
					href="https://cabinet.planetakino.ua/?return=http%3A%2F%2Fplanetakino.ua">Вхід</a>
				<a href="https://cabinet.planetakino.ua/signing/#up"
					class="register-link"> <span class="register-link-text">Реєстрація</span>
				</a>

			</div>
		</div>

		<div class="navigation-section right border-left city-block">
			<div class="city-selector addon-menu addon-menu__closed dropdown">
				<span class="addon-menu__icon-wrapper pseudo-lh dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false" id="currentCitySpan" abbr="lvov"><span
					class="icon icon-city-selector"></span>Львів (King Cross)</span>
				<ul class="addon-menu__list dropdown-menu">
					<li class="addon-menu__list-item"><a abbr="kiev"
						href="https://planetakino.ua/apps/">Київ</a></li>

					<li class="addon-menu__list-item"><a abbr="odessa"
						href="https://planetakino.ua/odessa/apps/">Одеса (Котовського)</a></li>

					<li class="addon-menu__list-item"><a abbr="odessa2"
						href="https://planetakino.ua/odessa2/apps/">Одеса (Таїрова)</a></li>

					<li class="addon-menu__list-item"><a abbr="lvov2"
						href="https://planetakino.ua/lvov2/apps/">Львів (FORUM LVIV)</a></li>

					<li class="addon-menu__list-item"><a abbr="kharkov"
						href="https://planetakino.ua/kharkov/apps/">Харків</a></li>

					<li class="addon-menu__list-item"><a abbr="sumy"
						href="https://planetakino.ua/sumy/apps/">Суми</a></li>

				</ul>
			</div>
		</div>

	</div>
	<!-- /.container-fluid --> </nav> </header>






	<div class="form-horizontal">
		<div class="col-sm-2"></div>
		<h1>Створення кінотеатру</h1>
	</div>




	<form action="/saveCinema" method="post" class="form-horizontal">
		<div class="form-group">
			<label for="inputNameCinema" class="col-sm-2 control-label">Name
				cinema</label>
			<div class="col-sm-5">
				<input type="text" name="cinemaname" class="form-control"
					id="inputNameCinema" placeholder="name cinema">
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">create</button>
			</div>
		</div>
	</form>


<a href="/">Choose cinema</a>















</body>




</html>