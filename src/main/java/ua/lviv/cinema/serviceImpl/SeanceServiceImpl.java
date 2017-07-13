package ua.lviv.cinema.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.lviv.cinema.dao.CinemaDao;
import ua.lviv.cinema.dao.MovieDao;
import ua.lviv.cinema.dao.ScheduleDao;
import ua.lviv.cinema.dao.SeanceDao;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.service.SeanceService;
import ua.lviv.cinema.validator.Validator;

@Service
public class SeanceServiceImpl implements SeanceService {

	@Autowired
	private SeanceDao seanceDao;

	@Autowired
	private ScheduleDao scheduleDao;

	@Autowired
	private MovieDao movieDao;

	@Autowired
	private CinemaDao cinemaDao;

	@Autowired
	@Qualifier("seanceValidator")
	private Validator seanceValidator;

	@Override
	public void save(Seance seance) throws Exception {

		// Schedule schedule =
		// scheduleDao.findByIdWithSeances(seance.getSchedule().getId());
		// if (!schedule.addSeance(seance)) {
		// return;
		// }

		Movie movie = seance.getMovie();

		Cinema cinema = cinemaDao.findByIdWithMovies(seance.getSchedule().getMoviehall().getCinema().getId());

		seanceValidator.validator(seance);
		if (!cinema.getMovies().contains(movie)) {
			cinema.getMovies().add(movie);
			cinemaDao.save(cinema);
		}

		seanceDao.save(seance);
	}

	@Override
	public void update(Seance seance) {
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
	public Map<Movie, List<Seance>> allSeances(Cinema cinema) {
		Map<Movie, List<Seance>> seances = new TreeMap<>();
		List<Seance> list = seanceDao.allSeances(cinema);
		for (Seance seance : list) {
			if (seances.containsKey(seance.getMovie())) {
				seances.get(seance.getMovie()).add(seance);
			} else {
				seances.put(seance.getMovie(), new ArrayList<>(Arrays.asList(seance)));
			}
		}

		return seances;
	}

	

	/**
	 * 
	 */
	@Override
	public Map<LocalDate, Map<Movie, List<Seance>>> allSeancesByDate(Cinema cinema) {

		List<Seance> list = seanceDao.allSeancesByDate(cinema);
			
		return createMapSeances(list);
	}
	
	/**
	 * 
	 */
	@Override
	public Map<LocalDate, Map<Movie, List<Seance>>> allSeancesOfMoviehallByDate(Moviehall moviehall) {
		List<Seance> list = seanceDao.allSeancesOfMoviehall(moviehall);		
		return createMapSeances(list);
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	private Map<LocalDate, Map<Movie, List<Seance>>> createMapSeances(List<Seance> list) {
		Map<LocalDate, List<Seance>> seances = new TreeMap<>();

		for (Seance seance : list) {
			if (seances.containsKey(seance.getStartTime().toLocalDate())) {
				seances.get(seance.getStartTime().toLocalDate()).add(seance);
			} else {
				seances.put(seance.getStartTime().toLocalDate(), new ArrayList<>(Arrays.asList(seance)));
			}
		}

		Map<LocalDate, Map<Movie, List<Seance>>> result = new TreeMap<>();

		for (Map.Entry<LocalDate, List<Seance>> entry : seances.entrySet()) {

			result.put(entry.getKey(), format(entry.getValue()));

		}

		return result;
	}

	private Map<Movie, List<Seance>> format(List<Seance> list) {
		Map<Movie, List<Seance>> seances = new TreeMap<>();

		for (Seance seance : list) {
			if (seances.containsKey(seance.getMovie())) {
				seances.get(seance.getMovie()).add(seance);
			} else {
				seances.put(seance.getMovie(), new ArrayList<>(Arrays.asList(seance)));
			}
		}

		return seances;
	}

	@Override
	public Map<Movie, List<Seance>> allSeances(Cinema cinema, LocalDate date) {
		Map<Movie, List<Seance>> seances = new TreeMap<>();
		List<Seance> list = seanceDao.allSeancesOfDay(cinema, date);
		for (Seance seance : list) {
			if (seances.containsKey(seance.getMovie())) {
				seances.get(seance.getMovie()).add(seance);
			} else {
				seances.put(seance.getMovie(), new ArrayList<>(Arrays.asList(seance)));
			}
		}

		return seances;
	}

	@Override
	public List<Seance> allSeancesOfMovie(Cinema cinema, Movie movie) {
		return seanceDao.allSeancesOfMovie(cinema, movie);
	}

	@Override
	public List<Seance> allSeancesOfMovie(Movie movie) {
		return seanceDao.allSeancesOfMovie(movie);
	}

	@Override
	public List<Seance> allSeancesOfDay(Cinema cinema, LocalDate date) {
		return seanceDao.allSeancesOfDay(cinema, date);
	}

	@Override
	public void saveAllSeances(Movie movie, List<LocalDateTime> times, Schedule schedule, int price) throws Exception {
		for (LocalDateTime time : times) {
			this.save(new Seance(movie, time, price, schedule));
		}
	}

	@Override
	public void deleteAllSeances(Movie movie, List<LocalDateTime> times, Moviehall moviehall) {
		for (LocalDateTime time : times) {
			this.delete(this.findByMoviehallAndTime(moviehall, time));
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
