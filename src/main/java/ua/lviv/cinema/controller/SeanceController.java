package ua.lviv.cinema.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.service.MovieService;
import ua.lviv.cinema.service.MoviehallService;
import ua.lviv.cinema.service.ScheduleService;
import ua.lviv.cinema.service.SeanceService;
import ua.lviv.cinema.service.TheaterService;

@Controller
public class SeanceController {
	
	@Autowired
	private SeanceService seanceService;
	
	@Autowired ScheduleService scheduleService;

	
	@Autowired
	private MovieService movieService;
	

	
	private Moviehall moviehall;
	private LocalDate localDate;
	private int moviehallId;
	
	@Autowired
	private MoviehallService moviehallService;
	
//	@RequestMapping(value="/movies", method=RequestMethod.GET)
//	private String allMovies(Model model){
//		model.addAttribute("movies", movieService.findAll());
//		
//		return "movies";
//	}
	
	@GetMapping("/chooseMoviehall/{id}/createSeance")
	public String create(@PathVariable int id, @RequestParam String date, Model model) {
		this.moviehallId = id;
		moviehall = moviehallService.findById(id);
		String[] strings = date.split("-");
		localDate = LocalDate.of(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]), Integer.valueOf(strings[2]));
		
		model.addAttribute("moviehall", moviehall);
		model.addAttribute("movies", movieService.findAll());
		model.addAttribute("localDate", localDate);
		
		return "createseance";
	}
	
	@PostMapping("/chooseMoviehall/{id}/saveSeance")
	public String save(@RequestParam String time, @RequestParam int movieId, @RequestParam int price) {
//		String[] strings = showFromDate.split("-");
//		LocalDate date = LocalDate.of(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]), Integer.valueOf(strings[2]));
//		
//		
//		movieService.save(new Movie(moviename, minutes, date, theaterService.findAll().get(0)));
		
		Movie movie = movieService.findById(movieId);
		
		String[] strings = time.split(":");
		LocalTime localTime = LocalTime.of(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]));
		LocalDateTime startTime = LocalDateTime.of(localDate, localTime);
		
		Schedule schedule = scheduleService.findByDateAndMoviehall(localDate, moviehallService.findById(moviehallId));
				
		
		seanceService.save(new Seance(movie, startTime, price, schedule));
		
		return "redirect:/chooseMoviehall/" + moviehallId + "/createSeance?date=" + localDate;
	}
	
	
	@GetMapping("/chooseSeance/{id}")
	public String choose(@PathVariable int id, Model model) {
		model.addAttribute("seance", seanceService.findOne(id));
		return "seance";
	}
	
	
}
