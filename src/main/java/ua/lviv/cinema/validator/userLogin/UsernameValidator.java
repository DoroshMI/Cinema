package ua.lviv.cinema.validator.userLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;

@Component("usernameValidator")
public class UsernameValidator implements Validator {



	@Override
	public void validator(Object o) throws Exception {

		String username = (String) o;



		if(username == null || "".equals(username)) {
			throw new Exception(UserLoginValidatorMessages.EMPTY_EMAIL_OR_PHONE_FIELD);
		}if(!(username.startsWith("+380") || username.contains("@"))) {
			throw new Exception(UserLoginValidatorMessages.INCORRECT_EMAIL_OR_PHONE);
		} else if (username.startsWith("+380") && username.length()!=13) {
			throw new Exception(UserLoginValidatorMessages.INCORRECT_PHONE);
		}else if (username.contains("@") && !username.contains(".")) {
			throw new Exception(UserLoginValidatorMessages.INCORRECT_EMAIL);
		}

		//if(username.contains("@"))




	}

}
