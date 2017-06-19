package ua.lviv.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * Created by User on 19.06.2017.
 */
@Controller
public class CreditCardController {

    @GetMapping("/checkCreditCard")
    private String check (Principal principal) {

        return "redirect:/";
    }
}
