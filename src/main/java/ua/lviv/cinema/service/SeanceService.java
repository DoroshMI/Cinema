package ua.lviv.cinema.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.validator.seance.SeanceException;

public interface SeanceService {
	void save(Seance seance) throws Exception;

	void update(Seance seance) throws Exception;

	Seance findOne(Integer id);
	
	List<Seance> findAll();

	void delete(Seance seance);


	
	List<Seance> allSeancesOfMoviehall(Moviehall moviehall);
	
	Map<LocalDate, Map<Movie, List<Seance>>> allSeancesOfMoviehallByDate(Moviehall moviehall);

	Map<Movie, List<Seance>> allSeances(Cinema cinema, LocalDate date);

	Map<Movie,List<Seance>> allSeances(Cinema cinema);
	
	Map<LocalDate, Map<Movie, List<Seance>>>  allSeancesByDate(Cinema cinema);

	Map<LocalDate, List<Seance>> allSeancesOfMovie(Cinema cinema, Movie movie);
	
	List<Seance> allSeancesOfMovie(Movie movie);

	List<Seance> allSeancesOfDay(Cinema cinema, LocalDate date);
	
	Seance findByMoviehallAndTime(Moviehall moviehall, LocalDateTime startTime);

//	void saveSeancesOverPeriod(Movie movie, LocalDateTime startTime, LocalDateTime endTime, Schedule schedule,
//			int price);

	void saveAllSeances(Movie movie, List<LocalDateTime> times, Schedule schedule, int price) throws Exception;
	
	void deleteAllSeances(Movie movie, List<LocalDateTime> times, Moviehall moviehall);
	
	void deleteAllSeances(List<Seance> seances);
	
	Seance findByIdWithSeats(Integer id);

}
