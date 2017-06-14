package ua.lviv.cinema.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import ua.lviv.cinema.editor.MovieEditor;
import ua.lviv.cinema.entity.*;
import ua.lviv.cinema.service.*;
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


    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Movie.class, new MovieEditor());
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/moviehalls/{id}/seances/form")
    public String create(@PathVariable int id, Model model) {
//        String[] strings = date.split("-");
//        LocalDate localDate = LocalDate.of(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]),
//                Integer.valueOf(strings[2]));

        model.addAttribute("moviehall", moviehallService.findById(id));
        model.addAttribute("currentCinema", moviehallService.findById(id).getCinema());
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("seance", new Seance());
//        model.addAttribute("localDate", localDate);

        return "views-admin-create_seance";
    }


    @PostMapping("/moviehalls/{moviehallId}/seances/form")
    public String save(@PathVariable int moviehallId, @RequestParam String date, @RequestParam @NotNull String time,
                       @RequestParam int movieId, @RequestParam int price, Model model) {

        Movie movie = movieService.findById(movieId);

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
        System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFf");
        Seance seance = null;

        try {
            seance = new Seance(movie, startTime, price, schedule);
            seanceService.save(seance);
        } catch (Exception e) {
            if (e.getMessage().equals(SeanceValidatorMessages.EMPTY_TIME_FIELD) || e.getMessage().equals(SeanceValidatorMessages.SEANCE_ALREADY_EXIST)) {
                model.addAttribute("seanceTimeException", e.getMessage());
            } else if (e.getMessage().equals(SeanceValidatorMessages.EMPTY_MOVIE_FIELD)) {
                model.addAttribute("seanceMovieExcaption", e.getMessage());
            } else if (e.getMessage().equals(SeanceValidatorMessages.EMPTY_PRICE_FIELD)) {
                model.addAttribute("seancePriceExcaption", e.getMessage());
            } else if (e.getMessage().equals(SeanceValidatorMessages.EMPTY_SCHEDULE_FIELD)) {
                model.addAttribute("seanceScheduleException", e.getMessage());
            }

            model.addAttribute("moviehall", moviehallService.findById(moviehallId));
            model.addAttribute("currentCinema", moviehallService.findById(moviehallId).getCinema());
            model.addAttribute("cinemas", cinemaService.findAll());
            model.addAttribute("movies", movieService.findAll());
            model.addAttribute("seance", seance);
            model.addAttribute("localDate", localDate);
            // return "redirect:/moviehalls/" + moviehallId + "/seances/form?date=" + localDate;
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
    public String choose(@PathVariable int id, Model model) {
        Seance seance = seanceService.findOne(id);
        model.addAttribute("cinema", seance.getSchedule().getMoviehall().getCinema());
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("seance", seance);
        return "views-base-seance";
    }

    @GetMapping("/cinemas/{id}/seances")
    private String schedule(@PathVariable int id, Model model) {
        model.addAttribute("currentCinema", cinemaService.findById(id));
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("seances", seanceService.allSeances(cinemaService.findById(id), LocalDate.now()));
        return "views-base-seances";
    }

    @GetMapping("admin/cinemas/{cinemaId}/seances")
    private String adminSchedule(@PathVariable int cinemaId, Model model) {
        model.addAttribute("cinema", cinemaService.findById(cinemaId));
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("seances", seanceService.allSeances(cinemaService.findById(cinemaId), LocalDate.now()));
        return "admin_seances";
    }

}
