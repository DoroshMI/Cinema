package ua.lviv.cinema.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import ua.lviv.cinema.Country;
import ua.lviv.cinema.editor.CinemaEditor;
import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.TheaterService;
import ua.lviv.cinema.service.UserService;

@Controller
public class CinemaController {


    private Cinema cinema;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private TheaterService theaterService;


//    @InitBinder
//    public void init(WebDataBinder binder) {
//        binder.registerCustomEditor(Cinema.class, new CinemaEditor());
//    }

    @RequestMapping(value = "/createCinema", method = RequestMethod.GET)
    public String create(Model model) {


        model.addAttribute("cinema",new Cinema());
        model.addAttribute("address",new Address());
        model.addAttribute("countries", Country.values());

        return "createcinema";
    }

    @GetMapping("/cinema/{id}/update")
    public String update(@PathVariable int id, Model model) {
        Cinema cinema = cinemaService.findById(id);
        model.addAttribute("cinema", cinema);
        return "createcinema";
    }

    @RequestMapping(value = "/cinema/{id}/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Cinema cinema, @ModelAttribute Address address, @PathVariable int id) {
        cinema.setId(id);
        System.out.println("AAAA: " + address);
        cinema.setAddress(address);
        cinema.setTheater(theaterService.findAll().get(0));
        System.out.println("CCCC: " + cinema);
        cinemaService.save(cinema);

        return "redirect:/createCinema";
    }


    @RequestMapping(value = "/cinema/{id}", method = RequestMethod.GET)
    public String choose(@PathVariable int id, Model model) {

        cinema = cinemaService.findById(id);
        model.addAttribute("cinema", cinema);

        model.addAttribute("moviehalls", cinemaService.findByIdWithMoviehalls(cinema).getMoviehalls());

        return "cinema";
    }


    @RequestMapping(value = "/cinema/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        System.out.println(cinemaService.findById(id));
        cinemaService.delete(cinemaService.findById(id));
        ;


        return "redirect:/";
    }




//	@PostMapping("/cinema/id/update")

//	@GetMapping
//	public String 
//	

}
