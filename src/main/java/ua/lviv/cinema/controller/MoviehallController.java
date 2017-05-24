package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.cinema.dao.MoviehallDao;
import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.MoviehallService;
import ua.lviv.cinema.service.SeanceService;
import ua.lviv.cinema.service.UserService;

@Controller
public class MoviehallController {

	// @RequestMapping(value="/", method=RequestMethod.GET)
	// public String home(){
	// return "home";
	// }

	@Autowired
	private CinemaService cinemaService;
	
	@Autowired
	private MoviehallService moviehallService;

	@Autowired
	private SeanceService seanceService;
	
	private Cinema cinema;

	@RequestMapping(value = "/chooseCinema/{id}/createMoviehall", method = RequestMethod.GET)
	public String create(@PathVariable int id, Model model) {
		cinema = cinemaService.findById(id);
		model.addAttribute("cinema", cinema);
		
		return "createmoviehall";
	}

	@RequestMapping(value = "/saveMoviehall", method = RequestMethod.POST)
	public String save(@RequestParam String moviehallname, @RequestParam String rows, @RequestParam String columns,
			Model model) {

		Moviehall moviehall = new Moviehall(moviehallname, Integer.valueOf(rows), Integer.valueOf(columns),
				cinema);
		model.addAttribute("cinema", cinema);

		moviehallService.save(moviehall);

		return "redirect:/chooseCinema/" + cinema.getId() + "/createMoviehall";
	}

	@RequestMapping(value ="/chooseMoviehall/{id}", method = RequestMethod.GET)
	public String choose(@PathVariable int id, Model model) {
		model.addAttribute("moviehall", moviehallService.findById(id));

		model.addAttribute("seancesOfMoviehall", seanceService.allSeancesOfMoviehall(moviehallService.findById(id)));

		return "moviehall";
	}
	
	


	// @RequestMapping(value="/chooseCinema/{id}", method=RequestMethod.GET)
	// public String deleteUser(@PathVariable int id, Model model){
	//
	// model.addAttribute("cinema", cinemaService.findById(id));
	//
	// return "cinema";
	// }
	//

}
