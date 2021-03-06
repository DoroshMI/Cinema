package ua.lviv.cinema.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import ua.lviv.cinema.dto.MovieDTO;
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

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/cinemas/{id}/movies", method = RequestMethod.GET)
    private String allMovies(@PathVariable int id, Model model) {
        Cinema cinema = cinemaService.findByIdWithMovies(id);
        model.addAttribute("currentCinema", cinema);
        model.addAttribute("cinemas", cinemaService.findAll());

        model.addAttribute("moviesInShow", movieService.findAllMoviesInShow(cinema));
        model.addAttribute("moviesInFuture", movieService.findAllMoviesInFuture(cinema));

        model.addAttribute("method", "/cinemas/" + id + "/movies");

        return "views-base-movies";
    }

    @RequestMapping(value = {"/cinemas/{cinemaId}/movies/{movieId}", "cinemas/{oldCinemaId}/movies/{movieId}/to/{cinemaId}"}, method = RequestMethod.GET)
    private String choose(@PathVariable int cinemaId, @PathVariable int movieId, Model model) {
        Cinema cinema = cinemaService.findByIdWithMovies(cinemaId);
        model.addAttribute("currentCinema", cinema);
        model.addAttribute("cinemas", cinemaService.findAll());

        Movie movie = movieService.findByIdWithMovieImages(movieId);
        model.addAttribute("movie", movie);

        model.addAttribute("method", "/cinemas/" + cinemaId + "/movies/" + movieId);

        model.addAttribute("seances", seanceService.allSeancesOfMovie(cinema, movie));

        return "views-base-movie";
    }


//    cinemas/1/movies/39/to/5
//    @RequestMapping(value = "/cinemas/{cinemaId}/movies/{movieId}", method = RequestMethod.GET)
//    private String chooseNew(@PathVariable int cinemaId, @PathVariable int movieId, Model model) {
//        Cinema cinema = cinemaService.findByIdWithMovies(cinemaId);
//        model.addAttribute("currentCinema", cinema);
//        model.addAttribute("cinemas", cinemaService.findAll());
//
//        Movie movie = movieService.findByIdWithMovieImages(movieId);
//        model.addAttribute("movie", movie);
//
//        model.addAttribute("method", "/cinemas/" + cinemaId + "/movies/" + movieId);
//
//        model.addAttribute("seances", seanceService.allSeancesOfMovie(cinema, movie));
//
//        return "views-base-movie";
//    }

    @GetMapping("admin/movies/{movieId}")
    public String chooseForAdmin(@PathVariable int movieId, Model model) {
        List<Cinema> cinemas = cinemaService.findAll();
        model.addAttribute("cinemas", cinemas);
        model.addAttribute("currentCinema", cinemas.get(0));
        model.addAttribute("movie", movieService.findById(movieId));

        model.addAttribute("method", "admin/movies/" + movieId);
        return "views-admin-movie";
    }

    @RequestMapping(value = "/cinemas/{oldId}/movies/to/{newId}", method = RequestMethod.GET)
    private String allMoviesNew(@PathVariable int newId, Model model) {
        return "redirect:/cinemas/" + newId + "/movies";
    }

    @GetMapping("/movies/form")
    public String create(Model model) {
        List<Cinema> cinemas = cinemaService.findAll();
        model.addAttribute("cinemas", cinemas);
        if (cinemas.size() != 0) {
            model.addAttribute("currentCinema", cinemas.get(0));
        }
        model.addAttribute("movieDTO", new MovieDTO());
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
//    public String save(@RequestParam String moviename, @RequestParam int minutes, @RequestParam String showFromDate,
//                       @RequestParam("images") List<MultipartFile> images, @RequestParam("imageLogo") MultipartFile imageLogo  ) {
    public String save(@ModelAttribute MovieDTO movieDTO,
                       @RequestParam("images") List<MultipartFile> images, @RequestParam("imageLogo") MultipartFile imageLogo) {

        System.out.println("images = " + images);
        System.out.println("image = " + imageLogo);

        String[] strings = movieDTO.getShowFromDate().split("-");
        LocalDate showFromDate = LocalDate.of(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]),
                Integer.valueOf(strings[2]));

        strings = movieDTO.getShowToDate().split("-");
        LocalDate showToDate = LocalDate.of(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]),
                Integer.valueOf(strings[2]));

        Movie movie = new Movie(movieDTO.getTitle(), Integer.valueOf(movieDTO.getMinutes()), showFromDate, showToDate);

        movieService.save(movie, images, imageLogo);

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


    @RequestMapping(value = "/movie/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int id) throws Exception {

        // delete all seances, where is movie
        Movie movie = movieService.findById(id);
        List<Seance> seances = seanceService.allSeancesOfMovie(movie);
        if (seances.size() != 0) {
            seanceService.deleteAllSeances(seances);
        }

        // delete movie from cinema
        for (Cinema cinema : cinemaService.findAll()) {
            cinema = cinemaService.findByIdWithMovies(cinema.getId());
            cinema.getMovies().remove(movie);
            cinemaService.update(cinema.getId(), cinema, cinema.getAddress());
        }

        movieService.delete(movie);

        return "redirect:/";
    }
}
