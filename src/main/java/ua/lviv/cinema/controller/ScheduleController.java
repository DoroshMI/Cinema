package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.lviv.cinema.service.CinemaService;

/**
 * Created by User on 30.05.2017.
 */
@Controller
public class ScheduleController {

    @Autowired
    CinemaService cinemaService;


}
