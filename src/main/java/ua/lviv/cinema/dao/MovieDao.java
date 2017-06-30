package ua.lviv.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Integer> {
	
	Movie findByTitle(String title);
	
	Movie findById(Integer id);
	
	//@Query("select seance from Seance seance where seance.movie = :movie and seance.schedule.moviehall.cinema = :cinema")
//	@Query("select movie from Movie movie where :cinema IN movie.cinemas" )
//	List<Movie> findAllMoviesInCinema(@Param("cinema") Cinema cinema);
	
//	@Query(":movie IN :cinema.movies")
//	boolean movieIsInCinema(@Param("movie") Movie movie, @Param("cinema") Cinema cinema);
	
	//@Query("select seance from Seance seance where seance.movie = :movie and seance.schedule.moviehall.cinema = :cinema")
//	@Query("select movie from Movie movie where :cinema IN movie.cinemas" )
//	List<Movie> findAllMoviesInCinema(@Param("cinema") Cinema cinema);
	
}
