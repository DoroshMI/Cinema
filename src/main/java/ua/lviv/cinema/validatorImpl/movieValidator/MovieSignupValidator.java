package ua.lviv.cinema.validatorImpl.movieValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;

@Component
public class MovieSignupValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public void validator(Object o) throws MovieException {

		User user = (User) o;

		if ((user.getName() == null) || (user.getName() == "") ) {
			throw new MovieException(MovieValidatorMessages.EMPTY_NAME_FIELD);
		} else if ((user.getEmail() == null) || (user.getEmail() == "") ) {
			throw new MovieException(MovieValidatorMessages.EMPTY_EMAIL_FIELD);
		} else if ((user.getPhone() == null) || (user.getPhone() == "") ) {
			throw new MovieException(MovieValidatorMessages.EMPTY_PHONE_FIELD);
		} else if ((user.getPassword() == null) || (user.getPassword() == "") ) {
			throw new MovieException(MovieValidatorMessages.EMPTY_PASSWORD_FIELD);
		}

		if (userService.findByEmail(user.getEmail()) != null) {
			throw new MovieException(MovieValidatorMessages.EMAIL_ALREADY_EXIST);
		}else if (userService.findByPhone(user.getPhone()) != null) {
			throw new MovieException(MovieValidatorMessages.PHONE_ALREADY_EXIST);
		}

	}

}
