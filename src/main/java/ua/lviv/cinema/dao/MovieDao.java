package ua.lviv.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Integer> {
	
	Movie findByTitle(String title);
	
}
