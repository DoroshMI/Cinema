<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/31/2017
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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

							<li><sec:authorize access="hasRole('ROLE_ADMIN')">

									<a href="/admin">to admin</a>

								</sec:authorize></li>


							<li><a href="/cinemas/${currentCinema.id}/seances"> <spring:message
										code="label.schedule" />
							</a></li>
							<li><a href="/cinemas/${currentCinema.id}/movies"><spring:message
										code="label.movies" /></a></li>



							<li role="separator" class="divider dropdown"><a
								href="https://planetakino.ua/lvov/apps/#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">...</a>
								<ul class="dropdown-menu">
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/imax/">IMAX</a></li>
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/theatres/"><spring:message
												code="label.movies" /></a></li>
									<li class="addon-menu__list-item"><a
										href="https://planetakino.ua/lvov/about/faq/"><spring:message
												code="label.help" /></a></li>
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
								aria-haspopup="true" aria-expanded="false">
									${currentCinema.name}</a>

								<ul class="dropdown-menu">

									<c:forEach items="${cinemas}" var="c">


										<li class="addon-menu__list-item">
											<%--<a href=${method}>${c.name}</a>--%> <a
											href="/cinemas/${c.id}/movies">${c.name}</a>
										</li>
									</c:forEach>

								</ul></li>

							<!-- Languege -->
							<li role="presentation" class="dropdown"><a
								class="dropdown-toggle" data-toggle="dropdown" href="#"
								role="button" aria-haspopup="true" aria-expanded="false">
									Lang <span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="/?lang=en">English</a></li>
									<li><a href="/?lang=ua">Ukraine</a></li>
								</ul></li>



							<!-- Registration -->
							<sec:authorize access="!isAuthenticated()">

								<li role="presentation" class="dropdown"><a
									class="dropdown-toggle" data-toggle="dropdown" href="#"
									role="button" aria-haspopup="true" aria-expanded="false">
										Вхід <span class="caret"></span>
								</a>
									<ul class="dropdown-menu">
										<li><a href="/login">Вхід</a></li>
										<li><a href="/signup" class="register-link">Реєстрація
										</a></li>
									</ul></li>
							</sec:authorize>


							<!-- Personal cabinet-->
							<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
								<li role="presentation" class="dropdown"><a
									class="dropdown-toggle" data-toggle="dropdown" href="#"
									role="button" aria-haspopup="true" aria-expanded="false">
										User <span class="caret"></span>
								</a>
									<ul class="dropdown-menu">
										<li><a href="/cabinet">Особистий кабінет</a></li>
										<li></li>
										<li><form:form action="/logout" method="post">

												<button type="submit">logout</button>
											</form:form></li>
										<li><sec:authentication property="name" /></li>
									</ul></li>

								<div>
									<img src="">
								</div>
							</sec:authorize>


						</ul>
					</div>

				</div>
			</div>
		</div>

	</div>
</nav>
<!-- ROW HADER container end -->

