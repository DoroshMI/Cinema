package ua.lviv.cinema.validatorImpl.cinemaValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;

@Component
public class CinemaValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public void validator(Object o) throws CinemaException {

		User user = (User) o;

		if(user == null) {
			throw new CinemaException(CinemaValidatorMessages.INCORRECT_DATA);
		}



	}

}
