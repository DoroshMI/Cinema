package ua.lviv.cinema.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Moviehall;


public interface CinemaService {
	
	void save(Cinema cinema, MultipartFile image) throws Exception;
	List<Cinema> findAll();	
	void delete(Cinema cinema); 
	void update(int cinemaId, Cinema cinema, Address address) throws Exception;
	
	Cinema findById(Integer id);
	
	Cinema findByName(String name);
	
	Cinema findByIdWithMoviehalls(Cinema cinema);
	
	Cinema findByIdWithMovies(Integer id);
}
