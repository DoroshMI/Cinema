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
import ua.lviv.cinema.service.*;

@Controller
public class SeanceController {
	
	@Autowired
	private SeanceService seanceService;
	
	@Autowired ScheduleService scheduleService;

	
	@Autowired
	private MovieService movieService;

	
	@Autowired
	private MoviehallService moviehallService;

	@Autowired
	private CinemaService cinemaService;
	
	@GetMapping("/moviehall/{id}/createSeance")
	public String create(@PathVariable int id, @RequestParam String date, Model model) {
		String[] strings = date.split("-");
		LocalDate localDate = LocalDate.of(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]), Integer.valueOf(strings[2]));
		
		model.addAttribute("moviehall",  moviehallService.findById(id));
		model.addAttribute("cinema",  moviehallService.findById(id).getCinema());
		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("movies", movieService.findAll());
		model.addAttribute("localDate", localDate);
		
		return "createseance";
	}
	
	@PostMapping("/moviehall/{moviehallId}/{date}/saveSeance")
	public String save(@PathVariable int moviehallId, @PathVariable String date,
			@RequestParam String time, @RequestParam int movieId, @RequestParam int price) {
		
		
		Movie movie = movieService.findById(movieId);
		
    	String[] stringsDate = date.split("-");
		LocalDate localDate = LocalDate.of(Integer.valueOf(stringsDate[0]), Integer.valueOf(stringsDate[1]), Integer.valueOf(stringsDate[2]));
		
		
		
		String[] stringsTime = time.split(":");
		LocalTime localTime = LocalTime.of(Integer.valueOf(stringsTime[0]), Integer.valueOf(stringsTime[1]));
		LocalDateTime startTime = LocalDateTime.of(localDate, localTime);
		
		Schedule schedule = scheduleService.findByDateAndMoviehall(localDate, moviehallService.findById(moviehallId));
				
		
		seanceService.save(new Seance(movie, startTime, price, schedule));
		
		return "redirect:/moviehall/" + moviehallId + "/createSeance?date=" + localDate;
	}
	
	
	@GetMapping("/seances/{id}")
	public String choose(@PathVariable int id, Model model) {
		Seance seance = seanceService.findOne(id);
		model.addAttribute("cinema", seance.getSchedule().getMoviehall().getCinema());
		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("seance", seance);
		return "seance";
	}


	@GetMapping("/cinema/{cinemaId}/seances")
	private String schedule(@PathVariable int cinemaId, Model model){
		model.addAttribute("cinema",cinemaService.findById(cinemaId));
		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("seances", seanceService.allSeances(cinemaService.findById(cinemaId), LocalDate.now()));
		return "admin_seances";
	}

	@GetMapping("admin/cinema/{cinemaId}/seances")
	private String admineSchedule(@PathVariable int cinemaId, Model model){
		model.addAttribute("cinema",cinemaService.findById(cinemaId));
		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("seances", seanceService.allSeances(cinemaService.findById(cinemaId), LocalDate.now()));
		return "admin_seances";
	}
	
}
