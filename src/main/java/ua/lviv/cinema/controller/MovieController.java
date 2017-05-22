package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.lviv.cinema.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/movies", method=RequestMethod.GET)
	private String allMovies(Model model){
		model.addAttribute("movies", movieService.findAll());
		
		return "movies";
	}

	
	@GetMapping("/chooseMovie/{id}")
	private String chooseMovie(@PathVariable int id, Model model){
		model.addAttribute("movie", movieService.findById(id));
		return "movie";
	}
}
