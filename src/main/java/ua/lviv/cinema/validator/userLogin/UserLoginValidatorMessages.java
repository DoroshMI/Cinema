package ua.lviv.cinema.validator.userLogin;

public interface UserLoginValidatorMessages {

 
    String EMPTY_EMAIL_OR_PHONE_FIELD = "EMPTY EMAIL OR PHONE FIELD";
    String EMPTY_PASSWORD = "EMPTY PASSWORD";

    String INCORRECT_EMAIL_OR_PHONE = "INCORRECT EMAIL OR PHONE";
    String INCORRECT_EMAIL = "INCORRECT EMAIL";
    String INCORRECT_PHONE = "INCORRECT PHONE";

    String WRONG_DATA = "WRONG EMAIL (PHONE) OR PASSWORD";
    String WRONG_DATA_NULL = "DATA IS NULL";
}
