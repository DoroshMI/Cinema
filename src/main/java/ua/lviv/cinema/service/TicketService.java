package ua.lviv.cinema.service;

import java.util.List;

import ua.lviv.cinema.entity.Ticket;
import ua.lviv.cinema.entity.User;

public interface TicketService {
	
	void save(Ticket ticket);
	List<Ticket> findAll();	
	void delete(Ticket ticket); 
	void update(Ticket ticket); 
	
	Ticket findById(Integer id);

}
