package ua.lviv.cinema.service;

import java.util.List;

import ua.lviv.cinema.entity.Seat;

public interface SeatService {
	void save(Seat seat);
	List<Seat> findAll();	
	void delete(Seat seat); 
	void update(Seat seat);
	
	Seat findById(Integer id);
}
