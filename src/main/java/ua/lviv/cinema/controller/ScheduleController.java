package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.ScheduleService;

/**
 * Created by User on 30.05.2017.
 */
@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    CinemaService cinemaService;


}
