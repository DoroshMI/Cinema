package ua.lviv.cinema.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;

public interface SeanceDao extends JpaRepository<Seance, Integer> {
	
	@Query("select seance from Seance seance where seance.schedule.moviehall = :moviehall")
	List<Seance> allSeancesOfMoviehall(@Param("moviehall") Moviehall moviehall);
	
	@Query("select seance from Seance seance where seance.movie = :movie and seance.schedule.moviehall.cinema = :cinema")
	List<Seance> allSeancesOfMovie(@Param("cinema") Cinema cinema, @Param("movie") Movie movie);
	
	@Query("select seance from Seance seance where seance.schedule.date = :date and seance.schedule.moviehall.cinema = :cinema")
	List<Seance> allSeancesOfDay(@Param("cinema") Cinema cinema, @Param("date") LocalDate date);
	
	@Query("select seance from Seance seance left join fetch seance.seats list where seance.id = :id")
	Seance findByIdWithSeats(@Param("id") Integer id);
	
	@Query("select seance from Seance seance where seance.schedule.moviehall = :moviehall and seance.startTime = :startTime")
	Seance findByMoviehallAndTime(@Param("moviehall") Moviehall moviehall, @Param("startTime") LocalDateTime startTime);
}
