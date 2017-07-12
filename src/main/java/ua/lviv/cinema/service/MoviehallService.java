package ua.lviv.cinema.service;

import java.util.List;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Moviehall;

public interface MoviehallService {

	void save(Moviehall moviehall) throws  Exception;
	void update(Moviehall moviehall) throws  Exception;
	List<Moviehall> findAll();

	void delete(Moviehall moviehall);



	Moviehall findById(Integer id);

	Moviehall findByNameAndCinema(String name, Cinema cinema);

	void delete(String name, Cinema cinema);

	Moviehall findByIdWithSchedules(Integer id);

}
