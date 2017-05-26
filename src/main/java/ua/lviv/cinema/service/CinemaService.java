package ua.lviv.cinema.service;

import java.util.List;

import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Moviehall;


public interface CinemaService {
	
	void save(Cinema cinema);
	List<Cinema> findAll();	
	void delete(Cinema cinema); 
	void update(int cinemaId, Cinema cinema, Address address);
	
	Cinema findById(Integer id);
	
	Cinema findByName(String name);
	
	Cinema findByIdWithMoviehalls(Cinema cinema);
	
	Cinema findByIdWithMovies(Cinema cinema);
}
