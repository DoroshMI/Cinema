package ua.lviv.cinema.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;

public interface SeanceDao2 {
	void save(Seance seance);
	
}
