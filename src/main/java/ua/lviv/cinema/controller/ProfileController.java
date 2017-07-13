package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.service.CinemaService;

import java.util.List;

/**
 * Created by User on 14.06.2017.
 */
@Controller
public class ProfileController {

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String cabinet(Model model) {

        List<Cinema> cinemas = cinemaService.findAll();
        if (cinemas.size() != 0) {
            model.addAttribute("currentCinema", cinemas.get(0));
        }

        model.addAttribute("cinemas", cinemas);
        model.addAttribute("method", "/cabinet");

        return "views-user-cabinet";
    }


    @RequestMapping(value = "/cabinet/to/{currentCinemaId}", method = RequestMethod.GET)
    public String cabinet(@PathVariable int currentCinemaId, Model model) {

        List<Cinema> cinemas = cinemaService.findAll();

        model.addAttribute("currentCinema", cinemaService.findById(currentCinemaId));

        model.addAttribute("cinemas", cinemas);
        model.addAttribute("method", "/cabinet");

        return "views-user-cabinet";
    }

    @GetMapping("/profile/myTickets")
    public String allMyTickets(){
        return  "views-user-my_tickets";
    }



    @GetMapping("/profile/favoriteMovies")
    public String favoriteMovies(){
        return  "views-user-favorite_movies";
    }




}
