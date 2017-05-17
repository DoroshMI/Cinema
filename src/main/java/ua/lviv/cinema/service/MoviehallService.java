package ua.lviv.cinema.service;

import java.util.List;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Moviehall;

public interface MoviehallService {

	void save(Moviehall moviehall);
	List<Moviehall> findAll();	
	void delete(Moviehall moviehall); 
	void update(Moviehall moviehall); 
	
	Moviehall findByNameAndCinema(String name, Cinema cinema) ;
	void delete(String name, Cinema cinema);	
	//void addCustomerToCinema(Customer customer, Cinema cinema);
	
	// made limited version
	Moviehall findByIdWithSchedules(Integer id);
	
}
