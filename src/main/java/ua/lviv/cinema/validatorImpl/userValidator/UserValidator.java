package ua.lviv.cinema.validatorImpl.userValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public void validator(Object o) throws UserException {

		User user = (User) o;
		if (user.getFirstName() == null) {
			throw new UserException(UserValidatorMessages.EMPTY_FIRSTNAME_FIELD);
		} else if (user.getEmail() == null) {
			throw new UserException(UserValidatorMessages.EMPTY_EMAIL_FIELD);
		} else if (user.getPhone() == null) {
			throw new UserException(UserValidatorMessages.EMPTY_PHONE_FIELD);
		} else if (user.getPassword() == null) {
			throw new UserException(UserValidatorMessages.EMPTY_PASSWORD_FIELD);
		}

		if (userService.findByEmail(user.getEmail()) != null) {
			throw new UserException(UserValidatorMessages.EMAIL_ALREADY_EXIST);
		}else if (userService.findByEmail(user.getEmail()) != null) {
			throw new UserException(UserValidatorMessages.EMAIL_ALREADY_EXIST);
		}

	}

}
