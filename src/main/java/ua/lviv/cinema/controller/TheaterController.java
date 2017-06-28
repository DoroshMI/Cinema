package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String theater(Model model) {

		List<Cinema> cinemas = cinemaService.findAll();

		if (cinemas.size() != 0) {
			model.addAttribute("currentCinema", cinemas.get(0));
		}

		model.addAttribute("cinemas", cinemas);
		model.addAttribute("movies", movieService.findAll());

		return "views-admin-theater";
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Cinema> cinemas = cinemaService.findAll();

		if (cinemas.size() != 0) {
			model.addAttribute("currentCinema", cinemas.get(0));
		}
		model.addAttribute("method", "/");
		model.addAttribute("cinemas", cinemas);
		// model.addAttribute("image", )

		return "views-base-index";

	}

	@GetMapping("/to/{id}")
	public String indexNew(@PathVariable int id, Model model) {

		Cinema cinema = cinemaService.findById(id);
		if (cinema != null) {
			model.addAttribute("currentCinema", cinema);
		}

		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("method", "");
		// model.addAttribute("image", )

		return "views-base-index";

	}

	@PostMapping("/")
	public String indexAfterLogin(Model model) {
		List<Cinema> cinemas = cinemaService.findAll();

		if (cinemas.size() != 0) {
			model.addAttribute("currentCinema", cinemas.get(0));
		}

		model.addAttribute("cinemas", cinemas);

		return "views-base-index";

	}

}
