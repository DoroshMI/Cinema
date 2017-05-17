package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model){
		
		model.addAttribute("users", userService.findAll());
		
		return "signup";
	}
//	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
//	public String saveUser(@RequestParam String username,
//			@RequestParam String email,
//			@RequestParam String password){
//		
//		User user = new User();
//		
//		
//		user.setEmail(email);
//		user.setPassword(password);
//		
//		userService.save(user);
//		
//		return "redirect:/signup";
//	}
//	
//	@RequestMapping(value="/deleteUser/{id}", method=RequestMethod.GET)
//	public String deleteUser(@PathVariable int id){
//		
//		userService.delete(id);
//		
//		return "redirect:/signup";
//	}
	
	
	
	
	
}
