package ua.lviv.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by User on 14.06.2017.
 */
@Controller
public class ProfileController {

    @GetMapping("/profile/myTickets")
    public String allMyTickets(){
        return  "views-user-my_tickets";
    }

    @GetMapping("/profile/forBirthday")
    public String forBirthday(){
        return  "views-user-for_birthday";
    }

    @GetMapping("/profile/favoriteMovies")
    public String favoriteMovies(){
        return  "views-user-favorite_movies";
    }

    @GetMapping("/profile/change")
    public String changePersonalData(){
        return  "views-user-change_personal_data";
    }


}
