package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {

		model.addAttribute("users", userService.findAll());
		model.addAttribute("user", new User());

		return "signup";
	}

	@PostMapping("/signup")
	public String save(@ModelAttribute User user, Model model) {

		try {
			userService.save(user);
		} catch (Exception e) {
			model.addAttribute("usernameException", e.getMessage());
			return "signup";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@PostMapping("/login")
	public String checkLogin(@RequestParam String email, @RequestParam String password) {
		User user = userService.findByEmailAndPassword(email, password);
		if (user == null) {
			return "redirect:/login";
		} else {
			return "redirect:/";
		}

	}
}
