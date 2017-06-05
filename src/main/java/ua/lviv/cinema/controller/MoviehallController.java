package ua.lviv.cinema.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.cinema.Country;
import ua.lviv.cinema.Technology;
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

	@Autowired
	private CinemaService cinemaService;

	@Autowired
	private MoviehallService moviehallService;

	@Autowired
	private SeanceService seanceService;

	@RequestMapping(value = "/cinemas/{id}/moviehalls/form", method = RequestMethod.GET)
	public String create(@PathVariable int id, Model model) {
		
		model.addAttribute("currentCinema", cinemaService.findById(id));
		model.addAttribute("cinema", cinemaService.findById(id));
		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("moviehall", new Moviehall());
		model.addAttribute("technologies", Technology.values());
		model.addAttribute("countries", Country.values());

		return "views-admin-create_moviehall";
	}

	@RequestMapping(value = "/cinemas/{cinemaId}/moviehalls/{moviehallId}/form", method = RequestMethod.POST)
	public String save(@ModelAttribute Moviehall moviehall, @PathVariable int cinemaId, @PathVariable int moviehallId,
			Model model) {
		Cinema cinema = cinemaService.findById(cinemaId);

		if (moviehallId == 0) {
			moviehall.setCinema(cinema);
			moviehallService.save(moviehall);

		} else {
			moviehall.setId(moviehallId);
			moviehall.setCinema(cinema);
			moviehallService.update(moviehall);
		}

		return "redirect:/cinemas/" + cinema.getId() + "/moviehalls/form";
	}

	@RequestMapping(value = "/moviehalls/{moviehallId}/form", method = RequestMethod.GET)
	public String update(@PathVariable int moviehallId, Model model) {
		Moviehall moviehall = moviehallService.findById(moviehallId);
		int cinemaId = moviehall.getCinema().getId();
		model.addAttribute("currentCinema", cinemaService.findById(cinemaId));
		model.addAttribute("cinema", cinemaService.findById(cinemaId));
		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("moviehall", moviehall);

		model.addAttribute("technologies", Technology.values());

		return "views-admin-create_moviehall";
	}

	@RequestMapping(value = "/moviehalls/{id}", method = RequestMethod.GET)
	public String show(@PathVariable int id, Model model) {
		Moviehall moviehall = moviehallService.findById(id);
		model.addAttribute("currentCinema", moviehall.getCinema());
	
		model.addAttribute("cinemas", cinemaService.findAll());
		model.addAttribute("moviehall", moviehall);

		model.addAttribute("seancesOfMoviehall", seanceService.allSeancesOfMoviehall(moviehallService.findById(id)));

		return "views-admin-moviehall";
	}

	@GetMapping("/moviehalls/{id}/delete")
	public String delete(@PathVariable int id) {
		int cinemaId = moviehallService.findById(id).getCinema().getId();
		moviehallService.delete(moviehallService.findById(id));
		return "redirect:/cinemas/" + cinemaId;
	}

}
