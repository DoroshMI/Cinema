package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.cinema.dao.MoviehallDao;
import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.MoviehallService;
import ua.lviv.cinema.service.UserService;

@Controller
public class MoviehallController {

//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String home(){
//		return "home";
//	}
	
	
	@Autowired
	private MoviehallService moviehallService;

	@RequestMapping(value="/createMoviehall", method=RequestMethod.GET)
	public String signup(Model model){
		
		return "createmoviehall";
	}
	
	
	@RequestMapping(value="/saveMoviehall", method=RequestMethod.POST)
	public String saveUser(@RequestParam String moviehallname, 
			@RequestParam String rows, 
			@RequestParam String columns,
			Model model){
		
		Moviehall  moviehall = new Moviehall(moviehallname, Integer.valueOf(rows), Integer.valueOf(columns),
				(Cinema)model.asMap().get("cinema"));
		System.out.println(model.asMap());
		moviehallService.save(moviehall);
		
		return "cinema";
	}
	
	
//	@RequestMapping(value="/chooseCinema/{id}", method=RequestMethod.GET)
//	public String deleteUser(@PathVariable int id, Model model){
//		
//		model.addAttribute("cinema", cinemaService.findById(id));
//		
//		return "cinema";
//	}
//	
	
}
