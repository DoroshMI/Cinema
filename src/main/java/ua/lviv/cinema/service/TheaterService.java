package ua.lviv.cinema.service;

import java.util.List;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Theater;

public interface TheaterService {
	void save(Theater theater);
	List<Theater> findAll();	
	void delete(Theater theater); 
	void update(Theater theater);
	
	
	Theater findByIdWithCinemas(Integer id);
	Theater findByIdWithMovies(Integer id);
}
