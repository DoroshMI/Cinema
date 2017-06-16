package ua.lviv.cinema.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.cinema.dao.TicketDao;
import ua.lviv.cinema.entity.Ticket;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketDao ticketDao;

	@Override
	public void save(Ticket ticket) {
		ticketDao.save(ticket);
	}

	@Override
	public List<Ticket> findAll() {
		return ticketDao.findAll();
	}

	@Override
	public void delete(Ticket ticket) {
		ticketDao.delete(ticket);
		
	}

	@Override
	public void update(Ticket ticket) {
		ticketDao.save(ticket);
		
	}

	@Override
	public Ticket findById(Integer id) {
		return ticketDao.findOne(id);
	}

}
