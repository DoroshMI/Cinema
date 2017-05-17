package ua.lviv.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Moviehall;


public interface CinemaDao extends JpaRepository<Cinema, Integer>{
	
	Cinema findByName(String Name);
	
	@Query("select c from Cinema c left join fetch c.moviehalls m where c.id = :id")
	Cinema findByIdWithMoviehalls(@Param("id") Integer id);
	
	@Query("select c from Cinema c left join fetch c.movies m where c.id = :id")
	Cinema findByIdWithMovies(@Param("id") Integer id);
}
