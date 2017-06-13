package ua.lviv.cinema.validator.userLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;

@Component("userLoginValidator")
public class UserLoginValidator implements Validator {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public void validator(Object o) throws Exception {

		User user = (User) o;

		if(user == null) {
			throw new Exception(UserLoginValidatorMessages.WRONG_DATA_NULL);
		}
		System.out.println("000000: " + user);

		String emailOrPhone = null;
		if (user.getEmail() != null) {
			emailOrPhone = user.getEmail();
		} else {
			emailOrPhone = user.getPhone();
		}


		System.out.println("1111111: " + user);

		if(user.getPassword() == null || "".equals(user.getPassword())) {
			throw new Exception(UserLoginValidatorMessages.EMPTY_PASSWORD);
		} else if (userService.findByEmailOrPhone(emailOrPhone) == null) {
			throw new Exception(UserLoginValidatorMessages.WRONG_DATA);
		} else if (!encoder.matches(user.getPassword(),
				userService.findByEmailOrPhone(emailOrPhone).getPassword())){
			throw new Exception(UserLoginValidatorMessages.WRONG_DATA);
		}


	}

}
