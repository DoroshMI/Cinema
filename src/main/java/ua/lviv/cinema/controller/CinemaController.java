package ua.lviv.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import ua.lviv.cinema.entity.Country;
import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.TheaterService;
import ua.lviv.cinema.validator.address.AddressValidatorMessages;
import ua.lviv.cinema.validator.cinema.CinemaValidatorMessages;

@Controller
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private TheaterService theaterService;

    @RequestMapping(value = "/cinemas/form", method = RequestMethod.GET)
    public String create(Model model) {
        List<Cinema> cinemas = cinemaService.findAll();
        if (cinemas.size() != 0) {
            model.addAttribute("currentCinema", cinemas.get(0));
        }
        model.addAttribute("cinemas", cinemas);
        model.addAttribute("cinema", new Cinema());
        model.addAttribute("address", new Address());
        model.addAttribute("countries", Country.values());

        return "views-admin-create_cinema";
    }

    @RequestMapping(value = "/cinemas/{id}/form", method = RequestMethod.POST)
    public String save(@PathVariable int id, @ModelAttribute Cinema cinema, @ModelAttribute Address address,
<<<<<<< HEAD
                       @RequestParam MultipartFile image,  Model model) {
=======
                       @RequestParam MultipartFile image, Model model) {
>>>>>>> origin/master

        try {
            cinema.setTheater(theaterService.findAll().get(0));
            if (id == 0) {
                cinema.setAddress(address);
                cinemaService.save(cinema, image);

            } else {
                cinemaService.update(id, cinema, address, image);
            }
        } catch (Exception e) {
            if (e.getMessage().equals(CinemaValidatorMessages.EMPTY_NAME_FIELD) || e.getMessage().equals(CinemaValidatorMessages.INCORRECT_NAME)|| e.getMessage().equals(CinemaValidatorMessages.EMPTY_IMAGE_FIELD)) {
                model.addAttribute("cinemaException", e.getMessage());
            }

            if (e.getMessage().equals(AddressValidatorMessages.EMPTY_ADDRESSLINE_FIELD)) {
                model.addAttribute("addressLineException", e.getMessage());
            } else if (e.getMessage().equals(AddressValidatorMessages.EMPTY_CITY_FIELD)) {
                model.addAttribute("addressCityException", e.getMessage());
            } else if (e.getMessage().equals(AddressValidatorMessages.EMPTY_STATE_FIELD)) {
                model.addAttribute("addressStateException", e.getMessage());
            } else if (e.getMessage().equals(AddressValidatorMessages.EMPTY_ZIPCODE_FIELD)) {
                model.addAttribute("addressZipcodeException", e.getMessage());
            } else if (e.getMessage().equals(AddressValidatorMessages.EMPTY_COUNTRY_FIELD)) {
                model.addAttribute("addressCountryException", e.getMessage());
            }

            List<Cinema> cinemas = cinemaService.findAll();
            if (cinemas.size() != 0) {
                model.addAttribute("currentCinema", cinemas.get(0));
            }
            model.addAttribute("cinemas", cinemas);

            model.addAttribute("cinema", cinema);
            model.addAttribute("address", address);
            model.addAttribute("countries", Country.values());
            return "views-admin-create_cinema";
        }

        return "redirect:/cinemas/form";
    }

    @GetMapping("/cinemas/{id}/form")
    public String update(@PathVariable int id, Model model) {
        Cinema cinema = cinemaService.findById(id);
        model.addAttribute("currentCinema", cinema);
        model.addAttribute("cinema", cinema);
        model.addAttribute("address", cinema.getAddress());
        model.addAttribute("countries", Country.values());
        return "views-admin-create_cinema";
    }

    @RequestMapping(value = "/admin/cinemas/{id}", method = RequestMethod.GET)
    public String show(@PathVariable int id, Model model) {

        Cinema cinema = cinemaService.findById(id);
        model.addAttribute("currentCinema", cinema);
        model.addAttribute("cinema", cinema);
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("moviehalls", cinemaService.findByIdWithMoviehalls(cinema).getMoviehalls());

        return "views-admin-cinema";
    }

    @RequestMapping(value = "/cinemas/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {

        cinemaService.delete(cinemaService.findById(id));

        return "redirect:/admin";
    }

}
