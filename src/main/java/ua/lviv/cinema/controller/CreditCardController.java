package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.cinema.component.TicketPDFComponent;
import ua.lviv.cinema.dto.CreditCardDTO;
import ua.lviv.cinema.dto.DTOUtilMapper;
import ua.lviv.cinema.entity.*;
import ua.lviv.cinema.service.*;
import ua.lviv.cinema.validator.Validator;
import ua.lviv.cinema.validator.creditCard.CreditCardDTOValidator;

import org.springframework.ui.Model;
import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.security.Principal;

/**
 * Created by User on 19.06.2017.
 */
@Controller
public class CreditCardController {
    @Autowired
    private OrderService orderService;



    @Autowired
    private UserService userService;



    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    @Qualifier("creditCardDTOValidator")
    private Validator creditCardDTOValidator;

    @Autowired
    private CinemaService cinemaService;

    @PostMapping("/checkCreditCard")
    private String check (Principal principal, @ModelAttribute CreditCardDTO creditCardDTO, @RequestParam int totalPrice, Model model)  {

        try {
            creditCardDTOValidator.validator(creditCardDTO);

            System.out.println("creditCardDTO in Controller = " + creditCardDTO);
            CreditCard creditCard = DTOUtilMapper.creditCardDAOToCreditCard(creditCardDTO);
            System.out.println("creditCard = " + creditCard);

        } catch (Exception e) {
            model.addAttribute("excaption", e.getMessage());

            Order lastOrder = orderService.lastOrderWithSeatInUser(Integer.valueOf(principal.getName()));
            Seance seance = lastOrder.getSeance();

            model.addAttribute("currentCinema", seance.getSchedule().getMoviehall().getCinema());
            model.addAttribute("cinemas", cinemaService.findAll());
            model.addAttribute("seance", seance);

            int priceTickets = 0;
            for(Seat seat : lastOrder.getSeats()) {priceTickets += seat.getPrice();}

            model.addAttribute("priceTickets", priceTickets);

            model.addAttribute("order", lastOrder);

            model.addAttribute("creditCardDTO", creditCardDTO);

            return "views-user-buy_tickets";
        }


        orderService.buyTikets(Integer.valueOf(principal.getName()));





        return "redirect:/";
    }
}
