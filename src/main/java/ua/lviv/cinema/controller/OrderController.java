package ua.lviv.cinema.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ua.lviv.cinema.dto.*;
import ua.lviv.cinema.entity.Order;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.entity.Seat;
import ua.lviv.cinema.entity.Ticket;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.OrderService;
import ua.lviv.cinema.service.SeanceService;
import ua.lviv.cinema.service.SeatService;
import ua.lviv.cinema.service.TicketService;
import ua.lviv.cinema.service.UserService;

@Controller
public class OrderController {

    @Autowired
    UserService userService;

    @Autowired
    SeatService seatService;

    @Autowired
    OrderService orderService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    SeanceService seanceService;

    @Autowired
    TicketService ticketService;

    /**
     * add ticket to backet of user
     *
     * @param principal
     * @param seatId
     * @param model
     * @return
     */
    @GetMapping("/addTicket/{seatId}")
    public String addTicket(Principal principal, @PathVariable int seatId, Model model) {

        if (principal == null) {
            return "redirect:/login";
        }

        Seat seat = seatService.findById(seatId);

        if (principal.getName().equals("admin")) {

        } else {

            User user = userService.findByIdWithSeats(Integer.valueOf(principal.getName()));
            for (Seat s : user.getSeats()) {
                if (!s.getSeance().equals(seat.getSeance())) {
                    s.setUser(null);
                    seatService.update(s);
                }
            }

            orderService.addTicketIntoBasket(principal, seatId);
        }

        return "redirect:/seances/" + seat.getSeance().getId();

    }

    @PostMapping("/addTicket")
    public @ResponseBody
    List<SeatDTOFull> addTicketREST(@RequestBody SeatDTO seatDTO, Principal principal) {
        System.out.println("seatDTO = " + seatDTO);

        Seat seat = seatService.findById(seatDTO.getId());
        List<SeatDTOFull> reserveSeats = new ArrayList<>();
        if (!principal.getName().equals("admin")) {

            User user = userService.findByIdWithSeats(Integer.valueOf(principal.getName()));
            for (Seat s : user.getSeats()) {
                if (!s.getSeance().equals(seat.getSeance())) {
                    s.setUser(null);
                    seatService.update(s);
                }
            }

            orderService.addTicketIntoBasket(principal, seat.getId());

            reserveSeats = DTOUtilMapper.saetsToSeatDTOFulls(userService.findByIdWithSeats(Integer.valueOf(principal.getName())).getSeats());
        }
        return reserveSeats;
    }

    @GetMapping("/deleteTicket/{seatId}")
    public String deleteTicket(Principal principal, @PathVariable int seatId, Model model) {

        Seat seat = seatService.findById(seatId);

        orderService.deleteTicketFromBasket(Integer.valueOf(principal.getName()), seatId);

        return "redirect:/seances/" + seat.getSeance().getId();

    }

    /**
     * @param principal
     * @param seanceId
     * @return
     */
    @PostMapping("/seats")
    private @ResponseBody
    List<SeatDTOFull> allSeats(Principal principal, @RequestBody int seanceId) {
        User user = userService.findById(Integer.valueOf(principal.getName()));
        List<Seat> seats = seanceService.findByIdWithSeats(seanceId).getSeats();
        List<SeatDTOFull> result = DTOUtilMapper.saetsToSeatDTOFulls(seats);
        for (int i = 0; i < seats.size(); i++) {
            if (user.equals(seats.get(i).getUser())) {
                result.get(i).setReservedSeat(true);
            }
        }
        return result;
    }


    @DeleteMapping("/ticket")
    public @ResponseBody
    List<SeatDTOFull> deleteTicketREST(Principal principal, @RequestBody int seatId) {

        Seat seat = seatService.findById(seatId);
        orderService.deleteTicketFromBasket(Integer.valueOf(principal.getName()), seatId);
        List<SeatDTOFull> reserveSeats = new ArrayList<>();

        reserveSeats = DTOUtilMapper.saetsToSeatDTOFulls(userService.findByIdWithSeats(Integer.valueOf(principal.getName())).getSeats());
        System.out.println("delete " + reserveSeats);
        return reserveSeats;

    }


    @GetMapping("/createOrder")
    public String createOrder(Principal principal, Model model) {

        Order order = orderService.createOrderAndSave(Integer.valueOf(principal.getName()));

        // Async method for delete order after set time
//        orderService.deleteOrder(Integer.valueOf(principal.getName()));

        model.addAttribute("order", order);
        model.addAttribute("seance", order.getSeance());

        int priceTickets = 0;
        for (Seat seat : order.getSeats()) {
            priceTickets += seat.getPrice();
        }
        model.addAttribute("priceTickets", priceTickets);

        return "views-user-tickets_information";
    }

//    @GetMapping("/deleteTicketFromOrder/{seatId}")
//    public String deleteTicketFromOrder(Principal principal, @PathVariable int seatId, Model model) {
//
//        Seat seat = seatService.findById(seatId);
//
//        orderService.deleteTicketFromLastOrder(Integer.valueOf(principal.getName()), seatId);
//        Order order = orderService.lastOrderInUser(Integer.valueOf(principal.getName()));
//        order = orderService.findByIdWithSeats(order.getId());
//        model.addAttribute("order", order);
//        model.addAttribute("seance", order.getSeance());
//
//        return "views-user-tickets_information";
//
//    }

    @DeleteMapping("/deleteTicketFromOrderREST")
    public @ResponseBody
    List<SeatDTOFull> deleteTicketFromOrderREST(Principal principal, @RequestBody int seatId) {

        Seat seat = seatService.findById(seatId);

        orderService.deleteTicketFromLastOrder(Integer.valueOf(principal.getName()), seatId);
        Order order = orderService.lastOrderInUser(Integer.valueOf(principal.getName()));
        order = orderService.findByIdWithSeats(order.getId());


        return DTOUtilMapper.saetsToSeatDTOFulls(order.getSeats());

    }

    @GetMapping("/buyTickets")
    public String buyTickets(Principal principal, Model model) {
        Order lastOrder = orderService.lastOrderWithSeatInUser(Integer.valueOf(principal.getName()));

        Seance seance = lastOrder.getSeance();

        model.addAttribute("currentCinema", seance.getSchedule().getMoviehall().getCinema());

        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("seance", seance);
        int priceTickets = 0;
        for(Seat seat : lastOrder.getSeats()) {priceTickets += seat.getPrice();}

        model.addAttribute("priceTickets", priceTickets);

        model.addAttribute("order", lastOrder);

        model.addAttribute("creditCardDTO", new CreditCardDTO());

        return "views-user-buy_tickets";
    }



    @GetMapping("/returnTo/Seances/{seanceId}")
    public String returnToSeanse(Principal principal, @PathVariable int seanceId) {

        orderService.deleteLastOrderAndRedirectBasket(Integer.valueOf(principal.getName()));
        return "redirect:/seances/" + seanceId;
    }

}
