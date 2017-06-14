package ua.lviv.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.MailSenderService;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;
import ua.lviv.cinema.validator.user.UserSignupValidator;
import ua.lviv.cinema.validator.user.UserSignupValidatorMessages;
import ua.lviv.cinema.validator.userLogin.UserLoginValidator;
import ua.lviv.cinema.validator.userLogin.UserLoginValidatorMessages;

import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    @Qualifier("userLoginValidator")
    private Validator userLoginValidator;

    @Autowired
    @Qualifier("userSignupValidator")
    private Validator userSignupValidator;

    @Autowired
    @Qualifier("usernameValidator")
    private Validator usernameValidator;

    @Autowired
    private MailSenderService mailSenderService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {

        List<Cinema> cinemas = cinemaService.findAll();
        if (cinemas.size() != 0) {
            model.addAttribute("currentCinema", cinemas.get(0));
        }
        model.addAttribute("cinemas", cinemas);
        model.addAttribute("user", new User());

        return "views-user-signup";

    }

    @PostMapping("/signup")
   // public String save(@ModelAttribute User user, Model model, @RequestParam("image") MultipartFile image) {
    public String save(@ModelAttribute User user, Model model) {
    	System.out.println("Save!!!!!");
        String uuid = UUID.randomUUID().toString();

        user.setUuid(uuid);

        try {
        	System.out.println("Try!!!!!");
//            userService.save(user, image);
            userService.save(user);
        } catch (Exception e) {
        	System.out.println("Error!!!!!");
            if (e.getMessage().equals(UserSignupValidatorMessages.EMPTY_NAME_FIELD)) {
                model.addAttribute("userNameException", e.getMessage());
            } else if (e.getMessage().equals(UserSignupValidatorMessages.EMPTY_EMAIL_FIELD)
                    || e.getMessage().equals(UserSignupValidatorMessages.EMAIL_ALREADY_EXIST)
                    || e.getMessage().equals(UserSignupValidatorMessages.INCORRECT_EMAIL)) {
                model.addAttribute("emailExcaption", e.getMessage());
            } else if (e.getMessage().equals(UserSignupValidatorMessages.EMPTY_PHONE_FIELD)
                    || e.getMessage().equals(UserSignupValidatorMessages.PHONE_ALREADY_EXIST)
                    || e.getMessage().equals(UserSignupValidatorMessages.INCORRECT_PHONE)) {
                model.addAttribute("phoneExcaption", e.getMessage());
            } else if (e.getMessage().equals(UserSignupValidatorMessages.EMPTY_PASSWORD_FIELD)) {
                model.addAttribute("passwordException", e.getMessage());
            }

            List<Cinema> cinemas = cinemaService.findAll();
            if (cinemas.size() != 0) {
                model.addAttribute("currentCinema", cinemas.get(0));
            }
            model.addAttribute("cinemas", cinemas);
            model.addAttribute("user", user);
            return "views-user-signup";
        }

        String theme = "thank's for registration";
        String mailBody =
                "gl & hf       http://localhost:8080/confirm/" + uuid;

        mailSenderService.sendMail(theme, mailBody, user.getEmail());


        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {

        List<Cinema> cinemas = cinemaService.findAll();
        if (cinemas.size() != 0) {
            model.addAttribute("currentCinema", cinemas.get(0));
        }
        model.addAttribute("cinemas", cinemas);
        model.addAttribute("defaltUsername", "+380");

        return "views-user-login";
    }

    // @PostMapping("/login")
    // public String checkLogin(@RequestParam String username, @RequestParam
    // String password, Model model) {
    //
    // System.out.println("JJJJJJJJJJJJJJJJJJJJ");
    // User user = userService.findByEmailAndPassword(username, password);
    // if (user == null) {
    // user = userService.findByPhoneAndPassword(username, password);
    // }
    //
    // try {
    // userValidator.validator(user);
    // } catch (Exception e) {
    // model.addAttribute("userException", e.getMessage());
    // return "views-user-login";
    // }
    // return "redirect:/";
    //
    // }

    @PostMapping("/failureLogin")
    public String failureLogin(@RequestParam String username, @RequestParam String password, Model model) {
        User user = null;
        try {
            usernameValidator.validator(username);
            user = new User(username,password);
        } catch (Exception e) {

            if (e.getMessage().equals(UserLoginValidatorMessages.EMPTY_EMAIL_OR_PHONE_FIELD) ||
                    e.getMessage().equals(UserLoginValidatorMessages.INCORRECT_EMAIL_OR_PHONE) ||
                    e.getMessage().equals(UserLoginValidatorMessages.INCORRECT_EMAIL) ||
                    e.getMessage().equals(UserLoginValidatorMessages.INCORRECT_PHONE)) {
                model.addAttribute("userException", e.getMessage());

            }
            model.addAttribute("defaltUsername", username);
            return "views-user-login";
        }


        try {
            userLoginValidator.validator(user);
        } catch (Exception e) {

            if (e.getMessage().equals(UserLoginValidatorMessages.WRONG_DATA) ||
                    e.getMessage().equals(UserLoginValidatorMessages.EMPTY_PASSWORD)) {
                model.addAttribute("userException", e.getMessage());

            }
            model.addAttribute("defaltUsername", username);
            return "views-user-login";
        }
        return "redirect:/";

    }


    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String cabinet(Model model) {

        List<Cinema> cinemas = cinemaService.findAll();
        if (cinemas.size() != 0) {
            model.addAttribute("currentCinema", cinemas.get(0));
        }
        model.addAttribute("cinemas", cinemas);

        return "views-user-cabinet";
    }

    @GetMapping("/confirm/{uuid}")
    public String confirm(@PathVariable String uuid) {

        User user = userService.findByUuid(uuid);
        user.setEnable(true);

        userService.update(user);

        return "redirect:/";
    }
}
