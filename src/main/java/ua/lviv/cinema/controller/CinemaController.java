package ua.lviv.cinema.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	static Cinema cinema;
	
	@Autowired
	private CinemaService cinemaService;

	@RequestMapping(value="/createCinema", method=RequestMethod.GET)
	public String create(){
		
		return "createcinema";
	}
	
	
	@RequestMapping(value="/saveCinema", method=RequestMethod.POST)
	public String save(@RequestParam String cinemaname){
		
		Cinema cinema = new Cinema(cinemaname, new Address("Sychiv", "28", "Lviv", "Lvivska obl", "123456", "Ukraine"));
		
		cinemaService.save(cinema);
		
		return "redirect:/createCinema";
	}
	
	
	@RequestMapping(value="/chooseCinema/{id}", method=RequestMethod.GET)
	public String choose(@PathVariable int id, Model model){
		
		cinema = cinemaService.findById(id);
		model.addAttribute("cinema", cinema);
		
		model.addAttribute("moviehalls", cinemaService.findByIdWithMoviehalls(cinema).getMoviehalls());
		
		return "cinema";
	}
	
	
	@RequestMapping(value="/chooseCinema/{id}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		System.out.println(cinemaService.findById(id));
		cinemaService.delete(cinemaService.findById(id));;
		
		
		return "redirect:/";
	}
	
//	@GetMapping
//	public String 
//	
	
}
