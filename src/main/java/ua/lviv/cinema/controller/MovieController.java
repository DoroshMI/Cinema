package ua.lviv.cinema.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.cinema.Country;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.service.MovieService;
import ua.lviv.cinema.service.TheaterService;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheaterService theaterService;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    private String allMovies(Model model) {
        model.addAttribute("movies", movieService.findAll());

        return "movies";
    }

    @GetMapping("/createMovie")
    public String create() {
        return "createmovie";
    }

    @PostMapping("/saveMovie")
    public String save(@RequestParam String moviename, @RequestParam int minutes, @RequestParam String showFromDate) {
        String[] strings = showFromDate.split("-");
        LocalDate date = LocalDate.of(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]),
                Integer.valueOf(strings[2]));

        Movie movie = new Movie(moviename, minutes, Country.USA, date, theaterService.findAll().get(0));

        movieService.save(movie);

        return "redirect:/createMovie";
    }

    @GetMapping("/movie/{id}")
    public String choose(@PathVariable int id, Model model) {
        model.addAttribute("movie", movieService.findById(id));
        return "movie";
    }
}
