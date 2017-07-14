package ua.lviv.cinema.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.lviv.cinema.entity.Country;
import ua.lviv.cinema.entity.Technology;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Coordinate;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Seat;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.MoviehallService;
import ua.lviv.cinema.service.SeanceService;
import ua.lviv.cinema.validator.address.AddressValidatorMessages;
import ua.lviv.cinema.validator.cinema.CinemaValidatorMessages;
import ua.lviv.cinema.validator.moviehall.MoviehallValidatorMessages;

@Controller
public class MoviehallController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private MoviehallService moviehallService;

    @Autowired
    private SeanceService seanceService;

    @RequestMapping(value = "/cinemas/{id}/moviehalls/form", method = RequestMethod.GET)
    public String create(@PathVariable int id, Model model) {

        model.addAttribute("currentCinema", cinemaService.findById(id));
        model.addAttribute("cinema", cinemaService.findById(id));
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("moviehall", new Moviehall());
        model.addAttribute("technologies", Technology.values());

        return "views-admin-create_moviehall";
    }

    @RequestMapping(value = "/cinemas/{cinemaId}/moviehalls/{moviehallId}/form", method = RequestMethod.POST)
    public String save(@ModelAttribute Moviehall moviehall, @PathVariable int cinemaId, @PathVariable int moviehallId,
                       Model model) {
        Cinema cinema = cinemaService.findById(cinemaId);
        try {
            if (moviehallId == 0) {
                moviehall.setCinema(cinema);
                moviehallService.save(moviehall);

            } else {
                Moviehall moviehallFromDB = moviehallService.findById(moviehallId);

                if (moviehallFromDB != null && (moviehallFromDB.getRows() != moviehall.getRows() || moviehallFromDB.getColumns() != moviehall.getColumns())) {
                    moviehall = moviehallFromDB;
                    throw new Exception("Rows or Columns can not update");
                }
                moviehall.setId(moviehallId);
                moviehall.setCinema(cinema);
                moviehallService.update(moviehall);
            }

        } catch (Exception e) {
                model.addAttribute("exception", e.getMessage());

            model.addAttribute("currentCinema", cinemaService.findById(cinemaId));
            model.addAttribute("cinemas", cinemaService.findAll());
            model.addAttribute("moviehall",moviehall);
            model.addAttribute("technologies", Technology.values());


            return "views-admin-create_moviehall";
        }


        return"redirect:/cinemas/"+cinema.getId()+"/moviehalls/form";
}

    @RequestMapping(value = "/moviehalls/{moviehallId}/form", method = RequestMethod.GET)
    public String update(@PathVariable int moviehallId, Model model) {
        Moviehall moviehall = moviehallService.findById(moviehallId);
        int cinemaId = moviehall.getCinema().getId();
        model.addAttribute("currentCinema", cinemaService.findById(cinemaId));
        model.addAttribute("cinema", cinemaService.findById(cinemaId));
        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("moviehall", moviehall);

        model.addAttribute("technologies", Technology.values());

        return "views-admin-create_moviehall";
    }

    @RequestMapping(value = "/admin/moviehalls/{id}/seances", method = RequestMethod.GET)
    public String show(@PathVariable int id, Model model) {
        Moviehall moviehall = moviehallService.findById(id);
        model.addAttribute("currentCinema", moviehall.getCinema());

        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("moviehall", moviehall);

        model.addAttribute("seancesOfMoviehall",
                seanceService.allSeancesOfMoviehallByDate(moviehallService.findById(id)));

        return "views-admin-seances";
    }

    @RequestMapping(value = "/moviehalls/{id}", method = RequestMethod.GET)
    public String showPlane(@PathVariable int id, Model model) {

        Moviehall moviehall = moviehallService.findById(id);
        model.addAttribute("currentCinema", moviehall.getCinema());

        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("moviehall", moviehall);


        int rows = moviehall.getRows();
        int columns = moviehall.getColumns();


        Coordinate[][] seats = new Coordinate[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = new Coordinate(i + 1, j + 1);
            }
        }


        model.addAttribute("allSeats", seats);


        return "views-admin-moviehall";

    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/moviehalls/{id}/delete")
    public String delete(@PathVariable int id) {
        int cinemaId = moviehallService.findById(id).getCinema().getId();
        moviehallService.delete(moviehallService.findById(id));
        return "redirect:/admin/cinemas/" + cinemaId;
    }

}
