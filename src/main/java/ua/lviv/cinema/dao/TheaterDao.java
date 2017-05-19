package ua.lviv.cinema.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.lviv.cinema.entity.Theater;

public interface TheaterDao extends JpaRepository<Theater, Integer> {
	


	@Query("select theater from Theater theater left join fetch theater.cinemas cinemas where theater.id = :id")
	Theater findByIdWithCinemas(@Param("id") Integer id); 

	@Query("select theater from Theater theater left join fetch theater.movies movies where theater.id = :id")
	Theater findByIdWithMovies(@Param("id") Integer id);
}
