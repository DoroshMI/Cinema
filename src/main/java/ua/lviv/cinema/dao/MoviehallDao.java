package ua.lviv.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Moviehall;

public interface MoviehallDao extends JpaRepository<Moviehall, Integer> {
	
	Moviehall findByNameAndCinema(String name, Cinema cinema);
	
	@Query("select m from Moviehall m left join fetch m.schedules s where m.id = :id")
	Moviehall findByIdWithSchedules(@Param("id") Integer id);
	
}
