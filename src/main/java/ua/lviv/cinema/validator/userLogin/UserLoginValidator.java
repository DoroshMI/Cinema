package ua.lviv.cinema.validator.userLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ua.lviv.cinema.entity.Role;
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

		String emailOrPhone = null;
		if (user.getEmail() != null) {
			emailOrPhone = user.getEmail();
		} else {
			emailOrPhone = user.getPhone();
		}

		

		if(emailOrPhone == null || "".equals(emailOrPhone)) {
			System.out.println("ERROR EMPTY");
			user.setRole(Role.ROLE_ANONYMOUS);
			throw new Exception(UserLoginValidatorMessages.EMPTY_EMAIL_OR_PHONE_FIELD);
		}if(!(emailOrPhone.startsWith("+380") || emailOrPhone.contains("@"))) {
			user.setRole(Role.ROLE_ANONYMOUS);
			throw new Exception(UserLoginValidatorMessages.INCORRECT_EMAIL_OR_PHONE);
		} else if (emailOrPhone.startsWith("+380") && emailOrPhone.length()!=13) {
			user.setRole(Role.ROLE_ANONYMOUS);
			throw new Exception(UserLoginValidatorMessages.INCORRECT_PHONE);
		}else if (emailOrPhone.contains("@") && !emailOrPhone.contains(".")) {
			user.setRole(Role.ROLE_ANONYMOUS);
			throw new Exception(UserLoginValidatorMessages.INCORRECT_EMAIL);
		}
	

		if(user.getPassword() == null || "".equals(user.getPassword())) {
			user.setRole(Role.ROLE_ANONYMOUS);
			throw new Exception(UserLoginValidatorMessages.EMPTY_PASSWORD);
		} else if (userService.findByEmailOrPhone(emailOrPhone) == null) {
			user.setRole(Role.ROLE_ANONYMOUS);
			throw new Exception(UserLoginValidatorMessages.WRONG_DATA);
		} else if (!encoder.matches(user.getPassword(),
				userService.findByEmailOrPhone(emailOrPhone).getPassword())){
			user.setRole(Role.ROLE_ANONYMOUS);
			throw new Exception(UserLoginValidatorMessages.WRONG_DATA);
		}


	}

}
