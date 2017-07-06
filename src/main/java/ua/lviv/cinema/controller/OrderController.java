package ua.lviv.cinema.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

		// user =
		// userService.findByIdWithSeats(Integer.valueOf(principal.getName()));

		return "redirect:/seances/" + seat.getSeance().getId();

	}

	@PostMapping("/addTicket")
	public void addTicketREST(@RequestBody String seat) {
		System.out.println("seat = " + seat);
	}

	@GetMapping("/deleteTicket/{seatId}")
	public String deleteTicket(Principal principal, @PathVariable int seatId, Model model) {

		Seat seat = seatService.findById(seatId);

		orderService.deleteTicketFromBasket(Integer.valueOf(principal.getName()), seatId);

		return "redirect:/seances/" + seat.getSeance().getId();

		//

	}

	@GetMapping("/createOrder")
	public String createOrder(Principal principal, Model model) {

		Order order = orderService.createOrderAndSave(Integer.valueOf(principal.getName()));

		// Async method for delete order after set time
		orderService.deleteOrder(Integer.valueOf(principal.getName()));

		model.addAttribute("order", order);
		model.addAttribute("seance", order.getSeance());

		return "views-user-tickets_information";
	}

	@GetMapping("/deleteTicketFromOrder/{seatId}")
	public String deleteTicketFromOrder(Principal principal, @PathVariable int seatId, Model model) {

		Seat seat = seatService.findById(seatId);

		orderService.deleteTicketFromLastOrder(Integer.valueOf(principal.getName()), seatId);
		Order order = orderService.lastOrderInUser(Integer.valueOf(principal.getName()));
		order = orderService.findByIdWithSeats(order.getId());
		model.addAttribute("order", order);
		model.addAttribute("seance", order.getSeance());

		return "views-user-tickets_information";

	}

	@GetMapping("/buyTickets")
	public String buyTickets(Principal principal, Model model) {

		model.addAttribute("order", orderService.lastOrderInUser(Integer.valueOf(principal.getName())));
		return "views-user-buy_tickets";
	}

	@GetMapping("/returnTo/Seances/{seanceId}")
	public String returnToSeanse(Principal principal, @PathVariable int seanceId) {

		orderService.deleteLastOrderAndRedirectBasket(Integer.valueOf(principal.getName()));
		return "redirect:/seances/" + seanceId;
	}

}
