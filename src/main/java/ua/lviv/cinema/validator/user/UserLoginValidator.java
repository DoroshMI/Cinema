package ua.lviv.cinema.validator.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;

@Component
public class UserLoginValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public void validator(Object o) throws UserException {

		User user = (User) o;

		if(user == null) {
			throw new UserException(UserValidatorMessages.INCORRECT_DATA);
		}



	}

}
