package ua.lviv.cinema.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.cinema.dao.ScheduleDao;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleDao scheduleDao;

	@Override
	public void save(Schedule schedule) {
		scheduleDao.save(schedule);
	}

	@Override
	public List<Schedule> findAll() {
		return scheduleDao.findAll();
	}

	@Override
	public void delete(Schedule schedule) {
		scheduleDao.delete(schedule);
	}

	@Override
	public void update(Schedule schedule) {
		scheduleDao.save(schedule);
	}

	@Override
	public Schedule findByDateAndMoviehall(LocalDate date, Moviehall moviehall) {		
		return  scheduleDao.findByDateAndMoviehall(date, moviehall);	
	}

	@Override
	public void delete(LocalDate date, Moviehall moviehall) {
		Schedule schedule = findByDateAndMoviehall(date, moviehall);
		scheduleDao.delete(schedule.getId());	
	}

	@Override
	public void deleteAllSchedules(LocalDate date) {
		scheduleDao.deleteAllSchedules(date);		
	}
	
	@Override
	public Schedule findByIdWithSeances(Integer id) {		
		return scheduleDao.findByIdWithSeances(id);		
	}


}
