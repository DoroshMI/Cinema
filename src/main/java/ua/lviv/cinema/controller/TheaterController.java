package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.UserService;

@Controller
public class TheaterController {

//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String home(){
//		return "home";
//	}
	
	
	@Autowired
	private CinemaService cinemaService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String theater(Model model){
		
		model.addAttribute("cinemas", cinemaService.findAll());
		
		return "theater";
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

//	
	
}
