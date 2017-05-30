package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.MovieService;
import ua.lviv.cinema.service.UserService;

@Controller
public class TheaterController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CinemaService cinemaService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String theater( Model model){
		
		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("movies", movieService.findAll());


		return "theater";
	}
	
	
	
	
}
