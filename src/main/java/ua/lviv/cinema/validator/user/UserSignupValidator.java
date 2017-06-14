package ua.lviv.cinema.validator.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;

@Component("userSignupValidator")
public class UserSignupValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public void validator(Object o) throws Exception {

		User user = (User) o;
		System.out.println("user: " + user);
		if ((user.getName() == null) || (user.getName() == "") ) {
			throw new Exception(UserSignupValidatorMessages.EMPTY_NAME_FIELD);
		} else if ((user.getEmail() == null) || (user.getEmail() == "") ) {
			throw new Exception(UserSignupValidatorMessages.EMPTY_EMAIL_FIELD);
		} else if ((user.getPhone() == null) || (user.getPhone() == "") ) {
			throw new Exception(UserSignupValidatorMessages.EMPTY_PHONE_FIELD);
		} else if ((user.getPassword() == null) || (user.getPassword() == "") ) {
			throw new Exception(UserSignupValidatorMessages.EMPTY_PASSWORD_FIELD);
		}

		if (userService.findByEmail(user.getEmail()) != null) {
			throw new Exception(UserSignupValidatorMessages.EMAIL_ALREADY_EXIST);
		}else if (userService.findByPhone(user.getPhone()) != null) {
			throw new Exception(UserSignupValidatorMessages.PHONE_ALREADY_EXIST);
		}

	}

}
