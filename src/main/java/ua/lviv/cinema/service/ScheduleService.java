package ua.lviv.cinema.service;

import java.time.LocalDate;
import java.util.List;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Schedule;

public interface ScheduleService {
	void save(Schedule schedule);
	List<Schedule> findAll();	
	void delete(Schedule schedule); 
	void update(Schedule schedule);
	
	Schedule findByDateAndMoviehall(LocalDate date, Moviehall moviehall);
	
	void delete(LocalDate date, Moviehall moviehall);
	
	void deleteAllSchedules(LocalDate date);
	
	Schedule findByIdWithSeances(Integer id);

	//List<Schedule> findByCinemaWithSeances(Cinema cinema);
}
