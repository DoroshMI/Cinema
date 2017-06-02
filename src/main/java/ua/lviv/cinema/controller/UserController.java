package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validatorImpl.userValidator.UserLoginValidator;
import ua.lviv.cinema.validatorImpl.userValidator.UserSignupValidator;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    @Qualifier("userLoginValidator")
    UserLoginValidator userValidator;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {

        model.addAttribute("cinemas", cinemaService.findAll());
        model.addAttribute("user", new User());

        return "signup";

    }

    @PostMapping("/signup")
    public String save(@ModelAttribute User user, Model model) {

        try {
            userService.save(user);
        } catch (Exception e) {
            model.addAttribute("userException", e.getMessage());
            return "signup";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("cinemas", cinemaService.findAll());
        return "login";
    }

    @PostMapping("/login")
    public String checkLogin(@RequestParam String emailOrPhone, @RequestParam String password,
                             Model model) {

        User user = userService.findByEmailAndPassword(emailOrPhone, password);
        if (user == null) {
            user = userService.findByPhoneAndPassword(emailOrPhone, password);
        }

        try {
            userValidator.validator(user);
        } catch (Exception e) {
            model.addAttribute("userException", e.getMessage());
            return "login";
        }
        return "redirect:/";



    }
}
