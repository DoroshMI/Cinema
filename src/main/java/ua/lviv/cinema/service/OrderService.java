package ua.lviv.cinema.service;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Service;

import ua.lviv.cinema.entity.Order;

@Service
public interface OrderService {
	void save(Order order);
	void saveAndFlush(Order order);
	List<Order> findAll();	
	void delete(Order order); 
	void update(Order order);
	
	
	Order findById(Integer id);
	Order findByIdWithSeats(Integer id);
	
	
	void addTicketIntoBasket(Principal principal, int seatId) ;
	void deleteTicketFromBasket(int userId, int seatId);

	Order createOrderAndSave(int userId);
	void buyTikets(int userId);

	void deleteOrder(int userId);
	
	Order lastOrderInUser(int userId);
	
	void deleteTicketFromLastOrder(int userId, int seatId);
	
	void deleteLastOrderAndRedirectBasket(int userId);
}
