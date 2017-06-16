package ua.lviv.cinema.serviceImpl;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.cinema.dao.OrderDao;
import ua.lviv.cinema.dao.TicketDao;
import ua.lviv.cinema.dao.UserDao;
import ua.lviv.cinema.entity.Order;
import ua.lviv.cinema.entity.Seat;
import ua.lviv.cinema.entity.StatusTicket;
import ua.lviv.cinema.entity.Ticket;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.OrderService;
import ua.lviv.cinema.service.SeatService;
import ua.lviv.cinema.service.TicketService;
import ua.lviv.cinema.service.UserService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;

	@Autowired
	UserService userService;

	@Autowired
	SeatService seatService;
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	TicketDao ticketDao;

	@Override
	public void save(Order order) {
		orderDao.save(order);
	}
	
	@Override
	public void saveAndFlush(Order order) {
		orderDao.saveAndFlush(order);
		
	}

	@Override
	public List<Order> findAll() {
		return orderDao.findAll();
	}

	@Override
	public void delete(Order order) {
		orderDao.delete(order);

	}

	@Override
	public void update(Order order) {
		orderDao.save(order);

	}

	@Override
	public Order findById(Integer id) {
		return orderDao.findById(id);
	}

	@Override
	public Order findByIdWithSeats(Integer id) {
		return orderDao.findByIdWithSeats(id);
	}

	@Override
	@Transactional
	public void addIntoBasket(Principal principal, int seatId) {
		User user = userService.findById(Integer.parseInt(principal.getName()));

		Seat seat = seatService.findById(seatId);
		//seat.setReservedSeat(true);
		//seatService.update(seat);
//		Ticket ticket = new Ticket(StatusTicket.PROCESSED, seat.getSeance());
//		ticket.setUser(user);
		
//		ticketService.save(ticket);
		seat.setUser(user);
		seatService.update(seat);
		//ticket = ticketDao.saveAndFlush(ticket);
		//user.getTickets().add(ticket);
		 user = userService.findByIdWithSeats(Integer.parseInt(principal.getName()));
		
		
		

		//userService.update(user);

	}

	@Override
	public void deleteFromBasket(int userId, int seatId) {
		User user = userService.findByIdWithSeats(userId);

		Seat seat = seatService.findById(seatId);
		seat.setUser(null);;
		//Ticket ticket = seat.getTicket();
		//ticketService.findById(tiketId);

		//ticketService.delete(ticket);

		seatService.update(seat);
		

	}

	@Override
	public void create(int userId) {
		Order order = new Order(LocalDateTime.now());

		orderDao.saveAndFlush(order);

		User user = userService.findByIdWithSeats(userId);

		order.setUser(user);

		for (Seat seat: user.getSeats()) {

			order.getSeats().add(seat);

			seat.setOrder(order);
			seat.setUser(null);
			seat.setFreeSeat(false);
			seatService.update(seat);
		}
		orderDao.save(order);


		user.getSeats().clear();
		userService.update(user);


	}

	@Override
	public void buyTikets(int userId) {
		Order order = new Order(LocalDateTime.now());

		orderDao.saveAndFlush(order);

		User user = userService.findByIdWithSeats(userId);

		order.setUser(user);

//		for (Ticket ticket: user.getTickets()) {
//
//			order.getTickets().add(ticket);
//
//			orderDao.save(order);
//
//		}
//
//		user.getTickets().clear();
//		userService.update(user);


	}





}
