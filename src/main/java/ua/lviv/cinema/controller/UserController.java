package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.user.UserLoginValidator;
import ua.lviv.cinema.validator.user.UserValidatorMessages;

import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	CinemaService cinemaService;

	@Autowired
	@Qualifier("userLoginValidator")
	UserLoginValidator userValidator;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {

		List<Cinema> cinemas = cinemaService.findAll();
		if (cinemas.size() != 0) {
			model.addAttribute("currentCinema", cinemas.get(0));
		}
		model.addAttribute("cinemas", cinemas);
		model.addAttribute("user", new User());

		return "views-user-signup";

	}

	@PostMapping("/signup")
	public String save(@ModelAttribute User user, Model model) {

		try {
			userService.save(user);
		} catch (Exception e) {

			if (e.getMessage().equals(UserValidatorMessages.EMPTY_NAME_FIELD)) {
				model.addAttribute("userNameException", e.getMessage());
			} else if (e.getMessage().equals(UserValidatorMessages.EMPTY_EMAIL_FIELD)
					|| e.getMessage().equals(UserValidatorMessages.EMAIL_ALREADY_EXIST)) {
				model.addAttribute("emailExcaption", e.getMessage());
			} else if (e.getMessage().equals(UserValidatorMessages.EMPTY_PHONE_FIELD)
					|| e.getMessage().equals(UserValidatorMessages.PHONE_ALREADY_EXIST)) {
				model.addAttribute("phoneExcaption", e.getMessage());
			} else if (e.getMessage().equals(UserValidatorMessages.EMPTY_PASSWORD_FIELD)) {
				model.addAttribute("passwordException", e.getMessage());
			}

			List<Cinema> cinemas = cinemaService.findAll();
			if (cinemas.size() != 0) {
				model.addAttribute("currentCinema", cinemas.get(0));
			}
			model.addAttribute("cinemas", cinemas);
			model.addAttribute("user", user);
			return "views-user-signup";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {

		List<Cinema> cinemas = cinemaService.findAll();
		if (cinemas.size() != 0) {
			model.addAttribute("currentCinema", cinemas.get(0));
		}
		model.addAttribute("cinemas", cinemas);

		return "views-user-login";
	}

	// @PostMapping("/login")
	// public String checkLogin(@RequestParam String username, @RequestParam
	// String password, Model model) {
	//
	// System.out.println("JJJJJJJJJJJJJJJJJJJJ");
	// User user = userService.findByEmailAndPassword(username, password);
	// if (user == null) {
	// user = userService.findByPhoneAndPassword(username, password);
	// }
	//
	// try {
	// userValidator.validator(user);
	// } catch (Exception e) {
	// model.addAttribute("userException", e.getMessage());
	// return "views-user-login";
	// }
	// return "redirect:/";
	//
	// }

	@PostMapping("/failureLogin")
	public String failureLogin(@RequestParam String username, @RequestParam String password, Model model) {
		User user = userService.findByEmailOrPhone(username);

		try {
			userValidator.validator(user);
		} catch (Exception e) {
			model.addAttribute("userException", e.getMessage());

			return "views-user-login";
		}
		return "redirect:/";

	}
}
