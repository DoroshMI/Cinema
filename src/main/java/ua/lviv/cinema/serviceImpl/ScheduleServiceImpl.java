package ua.lviv.cinema.serviceImpl;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.cinema.dao.ScheduleDao;
import ua.lviv.cinema.entity.Cinema;
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
	
	@Override
	//@Scheduled(fixedDelay=1000)
	@Scheduled(cron = "0 * * * * *")
	public void updateSchedule() {
		System.out.println("update shedule");
		
		
	
				for(Schedule schedule : this.findAll()) {
					if (schedule.getDate().isBefore(LocalDate.now())) {
						this.delete(schedule);
					}
				}
		
		
	}


//	@Override
//	public List<Schedule> findByCinemaWithSeances(Cinema cinema) {
//
//		List<Schedule> schedules = scheduleDao.findByCinemaWithSeances(cinema);
//
//		for(Iterator<Schedule> iterator = schedules.iterator(); iterator.hasNext();) {
//			if (iterator.next().getSeances().size() == 0) {
//				iterator.remove();
//			}
//		}
//		return schedules;
//	}


}
