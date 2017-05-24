<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<meta charset="utf-8">
<link rel="stylesheet" href="style.css">

<link rel="stylesheet" href="styleNew.css">

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

<title>IMAX | layout</title>
</head>
<body>

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
						<a class="navbar-brand" href=""><img src="logo.png"
							class="img-logo"></a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="schedule.html">Розклад</a></li>
							<li><a href="https://planetakino.ua/lvov/movies/">Фільми</a>
							</li>
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
								aria-haspopup="true" aria-expanded="false">Львів (King
									Cross)</a>
								<ul class="dropdown-menu">

									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/theatres/">Київ</a></li>
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/about/faq/">Одеса
											(Котовського)</a></li>
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/i/sale/">Одеса (Таїрова)</a></li>
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/i/gift-certificate/">Львів
											(FORUM LVIV)</a></li>

								</ul></li>


							<!-- Registration-->
							<li role="presentation" class="dropdown"><a
								class="dropdown-toggle" data-toggle="dropdown" href="#"
								role="button" aria-haspopup="true" aria-expanded="false">
									Вхід <span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="singup.html">Вхід</a></li>
									<li><a href="registration.html" class="register-link">
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






	<!-- CENTER -->





	<iframe id="ytplayer" type="text/html"
		src="https://www.youtube.com/embed/CZwvQzsXhjY?&amp;enablejsapi=1&amp;controls=0&amp;rel=0&amp;showinfo=0&amp;html5=1"
		style="opacity: 0;" height="100%" frameborder="0" width="100%"></iframe>
	<div class="ytp-play-btn" style=""></div>
	<div class="youtube-player-controls ytp-controls"
		style="display: none;">
		<div class="playback">
			<div class="playback__time"></div>
			<div class="playback__line"></div>
			<div class="playback__timeline"></div>
			<div class="playback__bufferline"></div>
		</div>
		<div class="ytp__sound-board">
			<div class="ytp__sound"></div>
			<input min="0" max="100" value="90" class="ytp__sound-volume"
				step="1" type="range">
		</div>
		<a target="_blank" title="YouTube.com" class="ytp__link"
			href="https://www.youtube.com/watch?v=CZwvQzsXhjY"></a>
	</div>
	<div class="movie-poster-block__caption movie-block">
		<div
			class="movie-block__info-icon-wishlist movie-block__info-icon_wishlist-pass movie-block__info-icon_wishlist-slider"
			data-filmid="2110"></div>
		<h1 class="movie-poster-block__title">${movie.title}</h1>


		<span class="movie-poster-block__subtitle"> Пираты Карибского
			моря: Мертвецы не рассказывают сказки / Pirates of the Caribbean:
			Dead Men Tell No Tales</span>

	</div>

















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
					Батіста). Цього разу банді космічних волоцюг доведеться битися, щоб
					захистити свою знову знайдену сім'ю, а також їм належить з'ясувати
					всі деталі біографії свого ватажка Зоряного Лицаря.
				</p>
				<p>Про те, що історія героїв, які подорожують галактикою, матиме
					продовження, стало відомо через тиждень після виходу на екрани
					першого фільму. Продюсери заявили, що сюжет гідний франшизи, а
					режисер Джеймс Ганн охоче погодився працювати над продовженням.
					Сценарій сиквелу, як і першої частини, пишуть спільно Джеймс Ганн і
					Ніколь Перлман, вся кар'єра якої - це написання сценаріїв до
					фільмів з кінематографічного всесвіту Марвел. Дана картина стане
					15-ю у списку Marvel Studios.</p>
			</div>




			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"></li>
					<li data-target="#carousel-example-generic" data-slide-to="4"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">

					<div class="item active">
						<a href="schedule.html"> <img src="17.jpg" alt="..."
							width="100%"></a>
						<div class="carousel-caption">
							<h1>IMAX Kharkiv</h1>
						</div>
					</div>



					<div class="item">
						<a href="schedule.html"> <img src="2.jpg" alt="..."
							width="100%"></a>
						<div class="carousel-caption">
							<h1>IMAX Odessa</h1>

						</div>
					</div>



					<div class="item">
						<a href="schedule.html"> <img src="foro-lvov-kadr10-big.jpg"
							alt="..." width="100%"></a>
						<div class="carousel-caption">
							<h1>IMAX Kiev</h1>

						</div>
					</div>



					<div class="item">
						<a href="schedule.html"> <img src="N_3.jpg" alt="..."
							width="100%"></a>
						<div class="carousel-caption">
							<h1>IMAX Lviv2</h1>

						</div>
					</div>




					<div class="item">
						<a href="schedule.html"> <img src="DSC-2.jpg" alt="..."
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
	<!-- FOOTER container end -->

</body>
</html>