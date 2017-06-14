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

    <div class="center">
        <div class="content">
            <div class="container-fluid form-edit">


                <div class="row">
                    <form action="https://cabinet.planetakino.ua/Profile/UpdateUserInfo" method="post">
                        <h1>Редагування особистих даних</h1>
                        <div class="input-together" name="firstname-block" id="firstname-block">
                            <span>Ім'я</span>
                            <input type="text" value="Марян" id="firstName" name="firstName"
                                   oninput="checkFirstLastName(&#39;firstName&#39;);"
                                   style="border-radius: 2px 0px 0px 2px;">
                        </div>
                        <div class="input-together input-together_w" name="lastname-block" id="lastname-block">
                            <span>Прізвище</span>
                            <input type="text" value="Дорош" id="lastName" name="lastName"
                                   oninput="checkFirstLastName(&#39;lastName&#39;);"
                                   style="border-radius: 0px 2px 2px 0;">
                            <span class="error-box" name="firstlastname-error" id="firstlastname-error"><img
                                    src="./Change_files/error_icon.png" alt="">Введи коректні дані</span>
                        </div>
                        <div class="input-together-date">
                            <p>Дата народження</p>
                            <input type="text"
                                   onfocus="$(&quot;#birth-hint&quot;).css(&quot;display&quot;, &quot;block&quot;);"
                                   class="day-input" id="ddlDobD" name="birthday_d"
                                   oninput="$(&quot;#birth-hint&quot;).css(&quot;display&quot;, &quot;none&quot;);checkBirthdate();"
                                   value="28" maxlength="2" placeholder="дд" disabled="">
                            <input type="text" class="month-input" id="ddlDobM" name="birthday_m"
                                   oninput="checkBirthdate();"
                                   value="08" maxlength="2" placeholder="мм" disabled="">
                            <input type="text" class="year-input" id="ddlDobY" name="birthday_y"
                                   oninput="checkBirthdate();"
                                   value="1985" maxlength="4" placeholder="рррр" disabled="">
                            <span class="tips" id="birth-hint" name="birth-hint" style="display:none">Після заповнення цього поля, змінити дату народження буде неможливо.</span>
                            <span class="error-box" name="dob-error" id="dob-error"><img
                                    src="./Change_files/error_icon.png" alt="">Введи коректні дані</span>
                        </div>

                        <div class="input-block">
                            <p>Секретне слово-пароль</p>
                            <input type="text" value="" id="secretWord" name="secretWord"
                                   onfocus="$(&quot;#secretWord-hint&quot;).css(&quot;display&quot;, &quot;block&quot;);"
                                   oninput="$(&quot;#secretWord-hint&quot;).css(&quot;display&quot;, &quot;none&quot;);checkSecretWord(&quot;secretWord&quot;);"
                                   style="width: 200px;" autocomplete="off">
                            <span class="tips" id="secretWord-hint" name="secretWord-hint" style="display:none">Cлово-пароль допоможе тобі списувати бонуси з рахунку без надання Клубної Карти, а просто назвавши номер телефону. Для редагування слова-паролю використовуй великі та малі літери української або російської мови.</span>
                            <span class="error-box" style="display:none" name="secretWord-error"
                                  id="secretWord-error"><img
                                    src="./Change_files/error_icon.png" alt="">Для вводу використовуй великі та малі літери української або російської мови. Будь ласка, перевір правильність та спробуй ще раз.</span>
                        </div>

                        <div class="virtyal-cart">
                            <span>Віртуальна карта</span>
                            <p>429836903899</p>
                        </div>
                        <div class="input-block">
                            <p>e-mail</p>
                            <input type="text" autocomplete="off" value="dorosh77727@gmail.com"
                                   defaultvalue="dorosh77727@gmail.com"
                                   onfocus="$(&quot;#email-hint&quot;).css(&quot;display&quot;, &quot;block&quot;);$(&quot;#email-error&quot;).css(&quot;display&quot;, &quot;none&quot;);	$(&quot;#email&quot;).removeClass(&quot;error&quot;);"
                                   oninput="$(&quot;#email-hint&quot;).css(&quot;display&quot;, &quot;none&quot;);$(&quot;#email-actual&quot;).css(&quot;display&quot;, &quot;none&quot;);$(&quot;#emailButton&quot;).attr(&quot;onclick&quot;, &quot;return false;&quot;); $(&quot;#emailButton&quot;).css(&quot;display&quot;, &quot;none&quot;);"
                                   id="email" name="email" onblur="checkMail();">
                            <span class="tips" id="email-hint" name="email-hint" style="display:none">Для зміни електронної пошти, на твій новий e-mail буде відправлено лист. Для підтвердження, будь ласка, перейди за посиланням у ньому.</span>
                            <input style="width: 170px;line-height: 24px; float: left" type="submit" id="emailButton"
                                   name="emailButton" onclick="return false;" value="Надіслати підтвердження"
                                   class="btn-input-block btn-disabled">
                            <!--button style="top:55px;position:absolute;opacity:0.3;line-height: 33px;"><id="emailButton" name="emailButton" onclick="SendActivationSms();return false;" class="btn-input-block btn-disabled"><span style="color:White; text-align:center">Надіслати підтвердження</span></button-->
                            <span style="float: none;" class="error-box" name="email-error" id="email-error"><img
                                    src="./Change_files/error_icon.png" alt="">Введи коректні дані</span>
                            <span style="float: none; color: black; margin-top: 24px; display: inline-block;"
                                  class="error-box"
                                  name="email-actual" id="email-actual"><img src="./Change_files/ico_green_galka.png"
                                                                             alt="">&nbsp;E-mail підтверджено</span>
                        </div>
                        <div class="input-block tell-block">
                            <p>Телефон</p>
                            <span class="cont-pluss">+</span>
                            <input type="text" class="tell-input" value="380978564636"
                                   defaultvalue="dorosh77727@gmail.com"
                                   maxlength="12"
                                   onfocus="$(&quot;#phone-hint&quot;).css(&quot;display&quot;, &quot;block&quot;);"
                                   oninput="$(&quot;#phone-hint&quot;).css(&quot;display&quot;, &quot;none&quot;);$(&quot;#phone-actual&quot;).css(&quot;display&quot;, &quot;none&quot;);checkPhone();"
                                   onblur="checkPhoneForm()" id="phoneNumber" name="phoneNumber">
                            <span class="tips" id="phone-hint" name="phone-hint" style="display: none;">Щоб змінити номер телефону, будь ласка, введи код активації, який прийде на твій телефон у смс.</span>
                            <input type="submit" style="padding: 0 19px 0 19px" id="smsButton" name="smsButton"
                                   onclick="SendActivationSms();return false;" value="надіслати код"
                                   class="btn-input-block btn-disabled">
                            <span class="error-box" name="phone-error" id="phone-error"><img
                                    src="./Change_files/error_icon.png"
                                    alt="">Введи коректні дані</span>
                            <span class="error-box" name="phone-actual" id="phone-actual"
                                  style="color: black; margin-top: 24px; display: inline-block;"><img
                                    src="./Change_files/ico_green_galka.png" alt="">&nbsp;Телефон підтверджено</span>
                        </div>
                        <div class="input-block">
                            <p>Код активації (надісланий у смс)</p>
                            <input type="text" value="" id="smsCode" name="smsCode" oninput="smsConfirm();"
                                   style="width: 200px;"
                                   autocomplete="off">
                            <span class="error-box" style="display:none" name="sms-error" id="sms-error"><img
                                    src="./Change_files/error_icon.png" alt="">Введи коректні дані</span>
                            <div style="clear: left;" class="clearfix"></div>
                            <a href="https://cabinet.planetakino.ua/Profile/ChangeInfo#" id="smsHref" name="smsHref"
                               onclick="SendActivationSms();return false;">Відправити код ще раз</a>
                            <a href="https://cabinet.planetakino.ua/Profile/ChangeInfo#"
                               onclick="SendProblemMail();return false;">Повідомити
                                про проблему</a>
                        </div>
                        <div class="input-block">
                            <p>Новий пароль</p>
                            <input type="password" value="" name="password" id="password" oninput="checkPassword();">
                            <span class="error-box" style="display:none" name="password-error" id="password-error"><img
                                    src="./Change_files/error_icon.png" alt="">Введи коректні дані</span>
                        </div>
                        <div class="input-block">
                            <p>Повтори новий пароль</p>
                            <input type="password" value="" onblur="checkPassConfirm();" name="passwordConfirm"
                                   id="passwordConfirm">
                            <span class="error-box" style="display:none" name="passwordConfirm-error"
                                  id="passwordConfirm-error"><img src="./Change_files/error_icon.png" alt="">Введений пароль не співпадає. Будь ласка, перевір правильність та спробуй ще раз.</span>
                        </div>
                        <div style="clear: left;" class="clearfix"></div>
                        <input type="hidden" id="phoneConfimed" name="phoneConfimed" value="yes">
                        <input type="submit" onclick="return formValidate();" value="Зберегти"
                               class="btn-input-block btn-input-block-form">
                    </form>
                </div>

            </div>
        </div>
    </div>


</div>
</body>


</html>

