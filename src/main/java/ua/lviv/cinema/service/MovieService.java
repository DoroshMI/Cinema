package ua.lviv.cinema.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;

public interface MovieService {
	void save(Movie movie);
	List<Movie> findAll();	
	void delete(Movie movie); 
	void update(Movie movie);
	
	Movie findByTitle(String title);
	
	Movie findById(Integer id);
	
	//List<Movie> findAllMoviesInCinema(Cinema cinema);
}
