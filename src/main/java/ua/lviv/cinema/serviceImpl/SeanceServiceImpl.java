package ua.lviv.cinema.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.cinema.dao.ScheduleDao;
import ua.lviv.cinema.dao.SeanceDao;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.service.SeanceService;

@Service
public class SeanceServiceImpl implements SeanceService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private SeanceDao seanceDao;

	@Autowired
	private ScheduleDao scheduleDao;

	@Override
	public void save(Seance seance) {

		Schedule schedule = scheduleDao.findByIdWithSeances(seance.getSchedule().getId());
		if (!schedule.addSeance(seance)) {
			return;
		}

		seanceDao.save(seance);
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
	public List<Seance> allSeancesOfMoviehall(Moviehall moviehall) {
		return seanceDao.allSeancesOfMoviehall(moviehall);
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
			this.delete(this.findByMoviehallAndTime(moviehall, times.get(i)));
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
