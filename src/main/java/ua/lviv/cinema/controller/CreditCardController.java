package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.lviv.cinema.component.TicketPDFComponent;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.MailSenderService;
import ua.lviv.cinema.service.OrderService;
import ua.lviv.cinema.service.UserService;

import java.io.File;
import java.io.Reader;
import java.security.Principal;

/**
 * Created by User on 19.06.2017.
 */
@Controller
public class CreditCardController {
    @Autowired
    OrderService orderService;

    @Autowired
    MailSenderService mailSenderService;

    @Autowired
    UserService userService;

    @Autowired
    TicketPDFComponent ticketPDFComponent;

    @GetMapping("/checkCreditCard")
    private String check (Principal principal) throws Exception {

        orderService.buyTikets(Integer.valueOf(principal.getName()));


        String theme = "thank's for buy tikets";
        String mailBody =
                "your tickets are: " ;
        User user = userService.findById(Integer.valueOf(principal.getName()));

        mailSenderService.sendMailWithTickets(theme, mailBody, user.getEmail(), "D:\\Google Диск\\Course Java\\Projects\\tickets.pdf");

        ticketPDFComponent.main();

        return "redirect:/";
    }
}
