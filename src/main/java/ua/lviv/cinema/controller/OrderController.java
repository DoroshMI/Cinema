package ua.lviv.cinema.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

	@GetMapping("/addTicket/{seatId}")
	public String addTicket(Principal principal, @PathVariable int seatId, Model model) {
		
		if (principal == null) {
			return "redirect:/login";
		}
		
		Seat seat = seatService.findById(seatId);
		
		User user = userService.findByIdWithSeats(Integer.valueOf(principal.getName()));
		for(Seat s : user.getSeats()) {
			if (!s.getSeance().equals(seat.getSeance())) {
				s.setUser(null);
				seatService.update(s);
			}
		}
		//Seance seance
		
		orderService.addTicketIntoBasket(principal, seatId);
		
		user = userService.findByIdWithSeats(Integer.valueOf(principal.getName()));
		
		
		
		
		
		return "redirect:/seances/" + seat.getSeance().getId();
		
		
//		Seance seance = seanceService.findByIdWithSeats(seat.getSeance().getId());
//		
//		model.addAttribute("currentCinema", seance.getSchedule().getMoviehall().getCinema());
//		model.addAttribute("cinema", seance.getSchedule().getMoviehall().getCinema());
//		model.addAttribute("cinemas", cinemaService.findAll());
//		model.addAttribute("seance", seance);
//
//		model.addAttribute("principal", principal);
//
//		
//		int rows = seance.getSchedule().getMoviehall().getRows();
//		int columns = seance.getSchedule().getMoviehall().getColumns();
//		List<Seat> listSeats = seance.getSeats();
//		Seat[][] seats = new Seat[rows][columns];
//		for (int i = 0; i < listSeats.size(); i++) {
//			seats[i / columns][i - (i / columns) * columns] = listSeats.get(i);
//		}
//		model.addAttribute("allSeats", seats);
//		return "views-base-seance";

	}
	
	
	@GetMapping("/deleteTicket/{seatId}")
	public String deleteTicket(Principal principal, @PathVariable int seatId, Model model) {

	
		Seat seat = seatService.findById(seatId);
		
		orderService.deleteTicketFromBasket(Integer.valueOf(principal.getName()), seatId);
		
//		User user = userService.findByIdWithSeats(Integer.valueOf(principal.getName()));
//		
//		model.addAttribute("seats", user.getSeats());
		
		return "redirect:/seances/" + seat.getSeance().getId();
		
//

	}

	@GetMapping("/createOrder")
	public String createOrder(Principal principal, Model model) {

		Order order = orderService.createOrderAndSave(Integer.valueOf(principal.getName()));

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
		
//

	}

	@GetMapping("/buyTickets")
	public String buyTickets(Principal principal, Model model) {

		model.addAttribute("order", orderService.lastOrderInUser(Integer.valueOf(principal.getName())));
		return "views-user-buy_tickets";
	}
	
	@GetMapping("/returnTo/Seances/{seanceId}")
	public String returnToSeanse(Principal principal, @PathVariable int seanceId){
		
		orderService.deleteLastOrderAndRedirectBasket(Integer.valueOf(principal.getName()));
		return "redirect:/seances/" + seanceId;
	}

}
