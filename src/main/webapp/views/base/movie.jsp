<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | movies</title>

</head>

<body>

	<!-- -------------------------CENTER container begin----------------------------- -->

	<div style="margin: 15px;">


		<h1 class="movie-poster-block__title">${movie.title} name movie</h1>

		<div class="row movie-page-block">
			<div class="col-md-9 col-xs-12">
				<div class="movie-page-block__desc">
					<p>
						Дивись <strong>ексклюзивну версію фільму</strong> «Вартові
						галактики 2» в IMAX. Тільки в цій технології зображення
						найвидовищніших сцен <strong>на 30% більше</strong> за розмір
						екрану інших залів.
					</p>

					<p>
						Головними героями фільму <strong>«Вартові галактики 2»</strong> як
						і раніше будуть доблесна четвірка на чолі з Зоряним Лицарем (Кріс
						Пратт). На екрані знову з'являться мила на перший погляд, але
						холоднокровна вбивця Ґамора (Зої Салдана), реактивний єнот Ракета
						(Бредлі Купер), дерево Ґрут (Він Дізель), якого Ракета вберіг від
						загибелі, вкорінивши маленький паросток, та відлюдько Дрекс (Дейв
						Батіста). Цього разу банді космічних волоцюг доведеться битися,
						щоб захистити свою знову знайдену сім'ю, а також їм належить
						з'ясувати всі деталі біографії свого ватажка Зоряного Лицаря.
					</p>
					<p>Про те, що історія героїв, які подорожують галактикою,
						матиме продовження, стало відомо через тиждень після виходу на
						екрани першого фільму. Продюсери заявили, що сюжет гідний
						франшизи, а режисер Джеймс Ганн охоче погодився працювати над
						продовженням. Сценарій сиквелу, як і першої частини, пишуть
						спільно Джеймс Ганн і Ніколь Перлман, вся кар'єра якої - це
						написання сценаріїв до фільмів з кінематографічного всесвіту
						Марвел. Дана картина стане 15-ю у списку Marvel Studios.</p>
				</div>


				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<!-- Indicators -->
					<%--<ol class="carousel-indicators">--%>
						<%--<li data-target="#carousel-example-generic" data-slide-to="0" class="active">etrere</li>--%>
						<%--<li data-target="#carousel-example-generic" data-slide-to="1"></li>--%>
						<%--<li data-target="#carousel-example-generic" data-slide-to="2"></li>--%>
						<%--<li data-target="#carousel-example-generic" data-slide-to="3"></li>--%>
						<%--<li data-target="#carousel-example-generic" data-slide-to="4"></li>--%>
					<%--</ol>--%>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">

						<div class="item active">
							<a href="schedule.html"> <img src="17.jpg" alt="wwwwwwww"
								width="100%"></a>
							<div class="carousel-caption">
								<h1>IMAX Kharkiv</h1>
							</div>
						</div>


						<div class="item">
							<a href="schedule.html"> <img src="2.jpg" alt="11111111111"
								width="100%"></a>
							<div class="carousel-caption">
								<h1>IMAX Odessa</h1>

							</div>
						</div>


						<div class="item">
							<a href="schedule.html"> <img src="foro-lvov-kadr10-big.jpg"
								alt="3333333333" width="100%"></a>
							<div class="carousel-caption">
								<h1>IMAX Kiev</h1>

							</div>
						</div>


						<div class="item">
							<a href="schedule.html"> <img src="N_3.jpg" alt="444444"
								width="100%"></a>
							<div class="carousel-caption">
								<h1>IMAX Lviv2</h1>

							</div>
						</div>


						<div class="item">
							<a href="schedule.html"> <img src="DSC-2.jpg" alt="555555555"
								width="100%"></a>
							<div class="carousel-caption">

								<h1>IMAX Lviv1</h1>

							</div>
						</div>


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


			<div class="col-md-3 col-xs-12">

				<div class="movie-page-block__summary">
					<dl>
						<dt name="year">Рік</dt>
						<dd>2017</dd>

						<dt name="country">Країна</dt>
						<dd>США</dd>

						<dt name="duplicationLang">Мова дублювання</dt>
						<dd>українська</dd>

						<dt name="genre">Жанр</dt>
						<dd>фантастика, бойовик</dd>

						<dt name="inStars">В головних ролях</dt>
						<dd>Кріс Пратт, Зої Салдана, Дейв Батіста, Він Дізель, Бредлі
							Купер, Курт Рассел</dd>

						<dt name="director">Режисер</dt>
						<dd>Джеймс Ганн</dd>

						<dt name="scenario">Сценарій</dt>
						<dd>Джеймс Ганн, Ден Абнетт, Енді Леннінг</dd>

						<dt name="dtStart">Прокат</dt>
						<dd>З 04 травня 2017, орієнтовно по 31 травня 2017</dd>


						<dt name="duration">Тривалість</dt>
						<dd>136 хв.</dd>

						<dt name="ageLimit">Вікові обмеження</dt>
						<dd>12+</dd>

					</dl>
				</div>
			</div>
		</div>

	</div>







</body>
</html>














