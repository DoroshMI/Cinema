<%@  page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IMAX | person cabinet</title>


</head>

<body>
<div style="margin: 15px;">


    <div class="row">

        <--! Left column -->
        <div class="col-xs-12 col-sm-6 col-md-8">
            <h1>Особистий Кабінет</h1>


            <div class="main_abinet">
                <a href="/profile/myTickets" class="item">
                    <div class="ico"><span><img src="tickets"></span></div>
                    <div class="num"><strong></strong></div>
                    <div class="description">
                        <div class="text">
                            <p>Мої квитки</p>
                        </div>
                    </div>
                </a> <!-- item -->

                <a href="/profile/forBirthday"
                   class="item">
                    <div class="ico"><span><img src="birthday"></span></div>
                    <div class="num"><strong></strong></div>
                    <div class="description">
                        <div class="text">
                            <p>Квиток до Дня народження у подарунок
                                <span class="atention">E-mail не підтверджено. Ти не можеш отримати безкоштовний квиток до Дня народження.</span>
                            </p>
                        </div>
                    </div>
                </a> <!-- item -->

                <a href="profile/favoriteMovies" class="item">
                    <div class="ico"><span><img src="./Планета Кіно — Особистий кабінет_files/films.svg"
                                                style="height:44px; width:44px"></span></div>
                    <div class="num"><strong></strong></div>
                    <div class="description">
                        <div class="text">
                            <p>Мої обрані фільми</p>
                        </div>
                    </div>
                </a> <!-- item -->

            </div> <!-- main_abinet -->


            <div class="main_cabinet2">
                <h2>Персональні дані</h2>
                <!--div class="item item_pass"-->
                <div class="item item_pass">
                    <div class="status" id="pass-status">
                        <!--p>Змінити пароль</p-->
                        <button id="pass-button" onclick="changePersonalInfo(&#39;password&#39;);">Змінити пароль
                        </button>


                    </div>
                    <div class="text" id="pass-block">
                        <p>***********</p>
                        <!--form><input type="password" id="password" name="password" placeholder="*******"  onfocus="startChangingPass();$('#phone-hint').attr('style','display:none');$('#email-hint').attr('style','display:none');return false;"/></form-->
                    </div>
                </div>
                <div class="item item_mail">
                    <div class="status" id="email-status">
                        <button onclick="changePersonalInfo(&#39;email&#39;)">Змінити ПОШТУ</button>

                    </div>


                    <div class="text" id="email-block" style="line-height: 14px;">
                        <p>dorosh77727@gmail.com<br><br>
                            <span style="font-size: 12px;"><img
                                    src="./Планета Кіно — Особистий кабінет_files/error_icon.png" alt="">&nbsp;E-mail не підтверджено. Натисни «Змінити пошту» і онови дані</span>
                        </p>
                        <!--form><input type="text" id="email" name="email" placeholder="dorosh77727@gmail.com" onfocus="$('#password-hint').attr('style','display:none');$('#phone-hint').attr('style','display:none');return false;" /></form-->
                    </div>
                </div>
                <div class="item item_phone">
                    <div class="status">
                        <button onclick="changePersonalInfo(&#39;phoneNumber&#39;)">Змінити ТЕЛЕФОН</button>

                    </div>
                    <div class="text" id="" style="line-height: 14px;">
                        <p>380978564636<br><br>
                            <span style="font-size: 12px;"><img
                                    src="./Планета Кіно — Особистий кабінет_files/ico_green_galka.png" alt="">&nbsp;Телефон підтверджено</span>
                        </p>
                        <!--form><input type="text" id="phone" name="phone" placeholder="380978564636" onfocus="$('#password-hint').attr('style','display:none');$('#email-hint').attr('style','display:none');return false;" /></form-->
                    </div>


                </div>


                <div class="item item_card">

                    <div class="text">
                        <p>429836903899</p>
                    </div>
                </div>
                <form style="display:none" action="https://cabinet.planetakino.ua/Profile/ChangeInfo" method="post"
                      autocomplete="off">
                    <input type="password" id="actualPass" name="actualPass" value="">
                    <input type="hidden" id="changingAttribute" name="changingAttribute" value="">
                    <input type="submit" id="submit-editting">
                </form>
            </div>


        </div>

        <--! Right column -->
        <div class="col-xs-6 col-md-4 content">

            <h1>0 бонусів</h1>

            <p>За кожну гривню, витрачену у нашому кінотеатрі (на сайті, у мобільному додатку, у попкорн-барі
                або Кіномаркеті), ти отримуєш 1 бонус</p>
            <p>Щоб отримувати бонуси, купуй квитки на сайті та у мобільному додатку, увійшовши до Особистого
                Кабінету, а у касі, попкорн-барі та Кіномаркеті щоразу перед покупкою називай свій номер
                телефону, вказаний в Особистому Кабінеті</p>
            <p>Також додаткові бонуси ти можеш отримати у різноманітних розіграшах на наших сторінках у
                соцмережах</p>

            <a href="#">Отримати
                історію бонусів на е-mail</a>
        </div>
    </div>


</div>
</body>


</html>

