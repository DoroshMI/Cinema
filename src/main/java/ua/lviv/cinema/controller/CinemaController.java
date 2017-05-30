package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import ua.lviv.cinema.Country;
import ua.lviv.cinema.editor.AddressEditor;
import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.TheaterService;

@Controller
public class CinemaController {


    private Cinema cinema;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private TheaterService theaterService;


//    @InitBinder
//    public void init(WebDataBinder binder) {
//        binder.registerCustomEditor(Address.class, new AddressEditor());
//    }

    @RequestMapping(value = "/createCinema", method = RequestMethod.GET)
    public String create(Model model) {


        model.addAttribute("cinema", new Cinema());
        model.addAttribute("address", new Address());
        model.addAttribute("countries", Country.values());

        return "createcinema";
    }

    @GetMapping("/cinema/{id}/update")
    public String update(@PathVariable int id, Model model) {
        Cinema cinema = cinemaService.findById(id);
        model.addAttribute("cinema", cinema);
        model.addAttribute("address", cinema.getAddress());
        model.addAttribute("countries", Country.values());
        return "createcinema";
    }

    @RequestMapping(value = "/cinema/{id}/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Cinema cinema, @ModelAttribute Address address, @PathVariable int id) {
        cinema.setTheater(theaterService.findAll().get(0));
        if (id == 0) {
            cinema.setAddress(address);
            cinemaService.save(cinema);
        } else {
            cinemaService.update(id, cinema, address);
        }


        return "redirect:/createCinema";
    }


    @RequestMapping(value = "/cinema/{id}", method = RequestMethod.GET)
    public String choose(@PathVariable int id, Model model) {

        cinema = cinemaService.findById(id);
        model.addAttribute("cinema", cinema);
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("moviehalls", cinemaService.findByIdWithMoviehalls(cinema).getMoviehalls());

        return "cinema";
    }


    @RequestMapping(value = "/cinema/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {

        cinemaService.delete(cinemaService.findById(id));

        return "redirect:/";
    }


//	@PostMapping("/cinema/id/update")

//	@GetMapping
//	public String 
//	

}
