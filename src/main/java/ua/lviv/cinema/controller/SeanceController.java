package ua.lviv.cinema.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import ua.lviv.cinema.dto.SeanceDTO;
import ua.lviv.cinema.editor.MovieEditor;
import ua.lviv.cinema.entity.*;
import ua.lviv.cinema.service.*;
import ua.lviv.cinema.validator.Validator;
import ua.lviv.cinema.validator.seance.SeanceValidatorMessages;

@Controller
public class SeanceController {

	@Autowired
	private SeanceService seanceService;

	@Autowired
	ScheduleService scheduleService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private MoviehallService moviehallService;

	@Autowired
	private CinemaService cinemaService;
	
	@Autowired
	SeatService seatService;

	@Autowired
	UserService userService;

	@Autowired
	@Qualifier("seanceDTOValidator")
	private Validator seanceDTOValidator;


	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/moviehalls/{id}/seances/form")
	public String create(@PathVariable int id, Model model) {

		model.addAttribute("moviehall", moviehallService.findById(id));
		model.addAttribute("currentCinema", moviehallService.findById(id).getCinema());
		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("movies", movieService.findAll());
		model.addAttribute("seance", new Seance());
		

		return "views-admin-create_seance";
	}

	@PostMapping("/moviehalls/{moviehallId}/seances/form")
	public String save(@PathVariable int moviehallId, @RequestParam String date, @RequestParam @NotNull String time,
			@RequestParam int movieId, @RequestParam int price, Model model) {



		// formater
		LocalDate localDate = null;
		if (date == null || "".equals(date.toString())) {
			localDate = null;
		} else {
			String[] stringsDate = date.split("-");
			localDate = LocalDate.of(Integer.valueOf(stringsDate[0]), Integer.valueOf(stringsDate[1]),
					Integer.valueOf(stringsDate[2]));

		}

		// formater
		LocalTime localTime = null;
		LocalDateTime startTime = null;

		String[] stringsTime = time.split(":");
		localTime = LocalTime.of(Integer.valueOf(stringsTime[0]), Integer.valueOf(stringsTime[1]));
		startTime = LocalDateTime.of(localDate, localTime);

		Schedule schedule = scheduleService.findByDateAndMoviehall(localDate, moviehallService.findById(moviehallId));
		Seance seance = null;

		try {
			SeanceDTO seanceDTO = new SeanceDTO(date, time, movieId, price);
			seanceDTOValidator.validator(seanceDTO);

			Movie movie = movieService.findById(movieId);
			seance = new Seance(movie, startTime, price, schedule);
			System.out.println("seance SERVICE = " + seance);

			seanceService.save(seance);
		} catch (Exception e) {

				model.addAttribute("exception", e.getMessage());

			model.addAttribute("moviehall", moviehallService.findById(moviehallId));
			model.addAttribute("currentCinema", moviehallService.findById(moviehallId).getCinema());
			model.addAttribute("cinemas", cinemaService.findAll());
			model.addAttribute("movies", movieService.findAll());
			model.addAttribute("seance", seance);
			model.addAttribute("localDate", localDate);
			// return "redirect:/moviehalls/" + moviehallId +
			// "/seances/form?date=" + localDate;
			return "views-admin-create_seance";
		}

		return "redirect:/moviehalls/" + moviehallId + "/seances/form";
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/seances/{id}")
	public String choose(Principal principal, @PathVariable int id, Model model) {
		Seance seance = seanceService.findByIdWithSeats(id);
		
		model.addAttribute("currentCinema", seance.getSchedule().getMoviehall().getCinema());
		model.addAttribute("cinema", seance.getSchedule().getMoviehall().getCinema());
		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("seance", seance);
		model.addAttribute("columns", seance.getSchedule().getMoviehall().getColumns());
		
		//model.addAttribute("method", )

		model.addAttribute("principal", principal);


		if (principal != null && !principal.getName().equals("admin")) {
			model.addAttribute("user", userService.findByIdWithSeats(Integer.valueOf(principal.getName())));
		} else {
			model.addAttribute("user", null);
		}


		if (principal != null && !principal.getName().equals("admin")) {
			User user = userService.findByIdWithSeats(Integer.valueOf(principal.getName()));
			for (Seat s : user.getSeats()) {
				if (!s.getSeance().equals(seance)) {
					s.setUser(null);
					seatService.update(s);
				}
			}
		}

		int rows = seance.getSchedule().getMoviehall().getRows();
		int columns = seance.getSchedule().getMoviehall().getColumns();
		List<Seat> listSeats = seance.getSeats();
		Seat[][] seats = new Seat[rows][columns];
		for (int i = 0; i < listSeats.size(); i++) {
			seats[i / columns][i - (i / columns) * columns] = listSeats.get(i);
		}
		model.addAttribute("allSeats", seats);
		
		if (principal != null && !principal.getName().equals("admin")) {
			List<Integer> seatsId = new ArrayList<>();
			List<Seat> reserveSeats = userService.findByIdWithSeats(Integer.valueOf(principal.getName())).getSeats();
			
			reserveSeats.stream().forEach(s -> seatsId.add(s.getId()));
			model.addAttribute("seatsId", seatsId);
			
			model.addAttribute("reserveSeats", reserveSeats);
			
			int priceTickets = 0;
			for(Seat seat : reserveSeats) {priceTickets += seat.getPrice();}
			
			model.addAttribute("priceTickets", priceTickets);
		}
		

		return "views-base-seance";
	}
	



	
	

	@GetMapping(path = {"/cinemas/{id}/seances"})
	private String schedule(@PathVariable int id, Model model) {
		model.addAttribute("currentCinema", cinemaService.findById(id));
		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("seances", seanceService.allSeancesByDate(cinemaService.findById(id)));
		model.addAttribute("method", "/cinemas/"+ id + "/seances");
		
		return "views-base-seances";
	}
	
	@GetMapping(path = {"/cinemas/{oldId}/seances/to/{newId}"})
	private String scheduleNew(@PathVariable int newId, Model model) {	
		return "redirect:/cinemas/" + newId + "/seances";
	}

	@GetMapping("admin/cinemas/{cinemaId}/seances")
	private String adminSchedule(@PathVariable int cinemaId, Model model) {
		model.addAttribute("cinema", cinemaService.findById(cinemaId));
		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("seances", seanceService.allSeances(cinemaService.findById(cinemaId), LocalDate.now()));
		return "admin_seances";
	}

}
