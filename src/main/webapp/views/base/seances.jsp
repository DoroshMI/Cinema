<%@  page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IMAX | seances</title>

</head>

<body>
<div style="margin: 15px;">


    <div class="page-header-block row">
        <h1 class="page-title col-sm-9 col-xs-12">Розклад сеансів у ${currentCinema.name} </h1>

        <div class="page-header-small col-sm-9 col-xs-12" type="button" data-toggle="collapse"
             data-target="#collapseMain"
             aria-expanded="false" aria-controls="collapseMain">
            Розклад зазвичай оновлюється щосереди після 16:00 на 1 тиждень вперед (з четверга по наступну
            середу).
        </div>

        <div class="page-header-main collapse col-sm-9 col-xs-12" id="collapseMain">
            <div class="well">
                <table class="table-params table-params_with-hidden-content">
                    <tbody>
                    <tr>
                        <td>Розклад зазвичай оновлюється щосереди після 16:00<br> на 1 тиждень вперед (з четверга по
                            наступну середу).
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="under-table-params" style="font-weight: normal; font-size: 90%; padding-left: 0px">
                    <p>Нові фільми виходять у прокат щочетверга, тому щосереди після 16:00 ми публікуємо розклад на всі
                        сеанси.</p>
                    <p>Зазвичай розклад оновлюється лише на 1 тиждень - з четверга по середу. Однак, інколи, на деякі
                        фільми
                        розклад може з’являтися раніше або пізніше та більше, ніж на 1 тиждень.</p>
                    <p>Для кінозалів IMAX ми намагаємося публікувати розклад на фільми раніше. На сеанси у технології
                        4DX
                        іноді розклад може з’являтися зранку у день прем’єри фільму. Це пов'язано з тим, що ключі для
                        запуску фільму активуються лише вночі, а ми повинні перевірити всі ефекти на фільмі.</p>
                    <p>Щоб одним з перших дізнаватися про появу розкладу на улюблений фільм, радимо налаштувати
                        оповіщення. </p>
                    <p>Для цього залогінься або зареєструйся на сайті, у розділі «Фільми» обери той, що тебе цікавить та
                        перейди на його сторінку. Поруч з датою початку прокату фільму знайди та натисни посилання
                        «Сповістити про початок продажу квитків». Коли ми опублікуємо розклад на цей фільм, ти отримаєш
                        від
                        нас листа на e-mail, який ти вказав у своїй анкеті в Особистому Кабінеті. </p>
                    <p>Така сама зручна функція сповіщення є у нашому мобільному додатку «Планета Кіно».</p>

                </div>

            </div>
        </div>
    </div>

    <div class="date_selection  arrs">
        <div class="date_prev"></div>
        <div class="date active" data-date="1496793600" style="display: none;">
            <p class="dateval">7 июня</p>
            <p class="datedesc">Сегодня</p>
        </div>
        <div class="date" data-date="1496880000" style="display: none;">
            <p class="dateval">8 июня</p>
            <p class="datedesc">Завтра</p>
        </div>
        <div class="date" data-date="1496966400">
            <p class="dateval">9 июня</p>
            <p class="datedesc">Пятница</p>
        </div>

        <select class="otherdate">
            <option disabled="" selected="">Другой</option>
            <option value="1496966400">9 июня</option>

        </select>

        <div class="date_next inact"></div>
    </div>


    <div class="choose-container">
        <div class="time-select">

            <c:forEach items="${seances}" var="entry">


                <div class="time-select__group">
                    <div class="col-sm-4">
                        <p class="time-select__place"> ${entry.getKey().title}</p>
                    </div>
                    <ul class="col-sm-8 items-wrap">

                        <c:forEach items="${entry.getValue()}" var="s">
                            <a class="time-select__item time" href="/seances/${s.id}">${s.startTime.toLocalTime()}</a>
                        </c:forEach>


                    </ul>
                </div>


            </c:forEach>

        </div>


    </div>


    <br>


</div>
</body>


</html>


