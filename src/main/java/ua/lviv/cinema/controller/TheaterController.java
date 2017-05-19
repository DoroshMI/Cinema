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


	
	@Autowired
	private CinemaService cinemaService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String theater(Model model){
		
		model.addAttribute("cinemas", cinemaService.findAll());
		
		return "theater";
	}
	
	
	

	
}
