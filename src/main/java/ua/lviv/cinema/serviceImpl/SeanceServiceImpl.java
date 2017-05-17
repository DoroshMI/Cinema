package ua.lviv.cinema.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.cinema.dao.ScheduleDao;
import ua.lviv.cinema.dao.SeanceDao;
import ua.lviv.cinema.dao.SeanceDao2;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.service.ScheduleService;
import ua.lviv.cinema.service.SeanceService;

@Service
@Repository
public class SeanceServiceImpl implements SeanceService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private SeanceDao seanceDao;
	
	@Autowired
	private ScheduleDao scheduleDao;


	/**
	 * Цей метод додає тільки сеанси щоб ненакладались часові границі
	 */
	// @Override
	// @Transactional
	// public void save(Seance seance) {
	//
	// Schedule schedule = entityManager.merge(seance.getSchedule());
	// if (!schedule.addSeance(seance)) {
	// return;
	// }
	//
	// entityManager.persist(seance);
	// seance.getSeats().forEach(seat -> entityManager.persist(seat));
	//
	// }

	@Override

	public void save(Seance seance) {
		
		Schedule schedule = scheduleDao.findByIdWithSeances(seance.getSchedule().getId());
		if (!schedule.addSeance(seance)) {
			return;
		}

		seanceDao.save(seance);
		//seanceDao2.save(seance);
	}

	@Override
	public List<Seance> findAll() {
		return seanceDao.findAll();
	}

	@Override
	public void delete(Seance seance) {
		seanceDao.delete(seance);
	}

	@Override
	public void update(Seance seance) {
		seanceDao.save(seance);
	}

	@Override
	public Seance findOne(Integer id) {
		return seanceDao.findOne(id);
	}

	@Override
	public Seance findByMoviehallAndTime(Moviehall moviehall, LocalDateTime startTime) {
		return seanceDao.findByMoviehallAndTime(moviehall, startTime);
	}

	@Override
	public List<Seance> allSeancesOfMovie(Cinema cinema, Movie movie) {
		return seanceDao.allSeancesOfMovie(cinema, movie);
	}

	@Override
	public List<Seance> allSeancesOfDay(Cinema cinema, LocalDate date) {
		return seanceDao.allSeancesOfDay(cinema, date);
	}

	@Override
	public void saveAllSeances(Movie movie, List<LocalDateTime> times, Schedule schedule, int price) {
		for (int i = 0; i < times.size(); i++) {
			this.save(new Seance(movie, times.get(i), price, schedule));
		}
	}

	@Override
	public void deleteAllSeances(Movie movie, List<LocalDateTime> times, Moviehall moviehall) {
		for (int i = 0; i < times.size(); i++) {
			this.delete(this.findByMoviehallAndTime( moviehall, times.get(i)));
		}
	}

	@Override
	public void deleteAllSeances(List<Seance> seances) {
		seances.stream().forEach(seance -> this.delete(seance));
	}

	@Override
	public Seance findByIdWithSeats(Integer id) {
		return seanceDao.findByIdWithSeats(id);
	}
}
