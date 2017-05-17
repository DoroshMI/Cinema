package ua.lviv.cinema.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Schedule;

public interface ScheduleDao extends JpaRepository<Schedule, Integer> {
	
	Schedule findByDateAndMoviehall(LocalDate date, Moviehall moviehall);
	
	@Query("delete from Schedule s where s.date = :date")
	void deleteAllSchedules(@Param("date") LocalDate date);
	
	@Query("select s from Schedule s left join fetch s.seances list where s.id = :id")
	Schedule findByIdWithSeances(@Param("id") Integer id);
	
}
