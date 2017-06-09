package ua.lviv.cinema.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.cinema.entity.Country;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.MovieService;
import ua.lviv.cinema.service.SeanceService;
import ua.lviv.cinema.service.TheaterService;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private CinemaService cinemaService;
    
    @Autowired
    private SeanceService seanceService;

    @RequestMapping(value = "/cinemas/{id}/movies", method = RequestMethod.GET)
    private String allMovies(@PathVariable int id, Model model) {
        Cinema cinema = cinemaService.findByIdWithMovies(id);
        model.addAttribute("currentCinema", cinema);
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("movies", cinema.getMovies());

        return "views-base-movies";
    }

    @RequestMapping(value = "cinema/{id}/movies/", method = RequestMethod.GET)
    private String allMoviesOfCinema(@PathVariable int id, Model model) {
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("movies", cinemaService.findByIdWithMoviehalls(cinemaService.findById(id)).getMovies());
        model.addAttribute("currentCinema", cinemaService.findById(id));
        return "movies";
    }

    @GetMapping("/movies/form")
    public String create(Model model) {
        List<Cinema> cinemas = cinemaService.findAll();
        model.addAttribute("cinemas", cinemas);
        if (cinemas.size() != 0) {
            model.addAttribute("currentCinema", cinemas.get(0));
        }

        model.addAttribute("movie", new Movie());

        return "views-admin-create_movie";
    }

    @GetMapping("/movies/{id}/update")
    public String update(@PathVariable int id, Model model) {
        List<Cinema> cinemas = cinemaService.findAll();
        model.addAttribute("cinemas", cinemas);
        if (cinemas.size() != 0) {
            model.addAttribute("currentCinema", cinemas.get(0));
        }

        model.addAttribute("movie", movieService.findById(id));


        return "views-admin-create_movie";
    }

    @PostMapping("/movies/form")
    public String save(@RequestParam String moviename, @RequestParam int minutes, @RequestParam String showFromDate) {
        String[] strings = showFromDate.split("-");
        LocalDate date = LocalDate.of(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]),
                Integer.valueOf(strings[2]));

        Movie movie = new Movie(moviename, minutes, Country.USA, date, theaterService.findAll().get(0));

        movieService.save(movie);

        return "redirect:/movies/form";
    }

//    @PostMapping("/movies/form")
//    public String save(@RequestParam String moviename, @RequestParam int minutes, @RequestParam String showFromDate) {
//        String[] strings = showFromDate.split("-");
//        LocalDate date = LocalDate.of(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]),
//                Integer.valueOf(strings[2]));
//
//        Movie movie = new Movie(moviename, minutes, Country.USA, date, theaterService.findAll().get(0));
//
//        movieService.save(movie);
//
//        return "redirect:/movies/form";
//    }

    @GetMapping("/movies/{mivieId}")
    public String choose(@PathVariable int mivieId, Model model) {
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("movie", movieService.findById(mivieId));
        return "movie";
    }
    
    @RequestMapping(value = "/movie/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int id) throws Exception {
    	
    	// delete all seances, where is movie
    	Movie movie = movieService.findById(id);
    	List<Seance> seances = seanceService.allSeancesOfMovie(movie);
    	if(seances.size() != 0) {
    		seanceService.deleteAllSeances(seances);
    	}
    	
    	// delete movie from cinema
        for(Cinema cinema : cinemaService.findAll()) {
            cinema = cinemaService.findByIdWithMovies(cinema.getId());
            cinema.getMovies().remove(movie);
            cinemaService.update(cinema.getId(),cinema,cinema.getAddress());
        }

        movieService.delete(movie);

        return "redirect:/";
    }
}
