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
							<li><a href="/cinemas/${currentCinema.id}/seances">Розклад</a></li>
							<li><a href="/cinemas/${currentCinema.id}/movies">Фільми</a>
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
								aria-haspopup="true" aria-expanded="false">Cinema:
									${currentCinema.name}</a> <%--<c:choose>--%> <%--<c:when test="${cinema==null}">--%>
								<%--<input style="visibility: hidden" name="cinemaId" type="text" value="0">--%>
								<%--</c:when>--%> <%--<c:otherwise>--%> <%--<input style="visibility: hidden" name="cinemaId" type="text" value="${cinema.id}">--%>
								<%--</c:otherwise>--%> <%--</c:choose>--%>

								<ul class="dropdown-menu">

									<c:forEach items="${cinemas}" var="c">

										<%--<li class="addon-menu__list-item"><a href="${pageContext.request.requestURL}">${c.name}</a></li>--%>
										<li class="addon-menu__list-item"><a
											href="/cinemas/${c.id}/movies">${c.name}</a></li>
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
									<li><a href="/signup" class="register-link">Реєстрація
									</a></li>
								</ul></li>

							<!-- Personal cabinet-->
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

							<div>  <img src=""></div>


						</ul>
					</div>

				</div>
			</div>
		</div>

	</div>
</nav>
<!-- ROW HADER container end -->

