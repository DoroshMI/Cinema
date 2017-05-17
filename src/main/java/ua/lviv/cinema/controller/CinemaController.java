package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.UserService;

@Controller
public class CinemaController {

//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String home(){
//		return "home";
//	}
	
	
	@Autowired
	private CinemaService cinemaService;

	@RequestMapping(value="/createCinema", method=RequestMethod.GET)
	public String signup(Model model){
		
		return "createcinema";
	}
	
	
	@RequestMapping(value="/saveCinema", method=RequestMethod.POST)
	public String saveUser(@RequestParam String cinemaname){
		
		Cinema cinema = new Cinema(cinemaname, new Address("Sychiv", "28", "Lviv", "Lvivska obl", "123456", "Ukraine"));
		
		cinemaService.save(cinema);
		
		return "cinema";
	}
	
	
	@RequestMapping(value="/chooseCinema/{id}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable int id, Model model){
		
		model.addAttribute("cinema", cinemaService.findById(id));
		
		return "cinema";
	}
	
	
}
