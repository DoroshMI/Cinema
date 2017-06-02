package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.MovieService;

import java.util.List;

@Controller
public class TheaterController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CinemaService cinemaService;

	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String theater(  Model model){

		List<Cinema> cinemas = cinemaService.findAll();


		if(cinemas.size() != 0) {
			model.addAttribute("cinema", cinemas.get(0));
		}


		model.addAttribute("cinemas", cinemas);
		model.addAttribute("movies", movieService.findAll());

		return "views-admin-theater";
	}
	
	@GetMapping("/")
	public String index( Model model){
		List<Cinema> cinemas = cinemaService.findAll();


			if(cinemas.size() != 0) {
				model.addAttribute("cinema", cinemas.get(0));
			}


		model.addAttribute("cinemas", cinemas);

		return "views-base-index";

	}
	
	
}
