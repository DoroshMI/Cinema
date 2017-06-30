package ua.lviv.cinema.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.cinema.dao.MovieDao;
import ua.lviv.cinema.dao.SeanceDao;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.service.MovieService;
import ua.lviv.cinema.service.MoviehallService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private SeanceDao seanceDao;

	@Override
	public void save(Movie movie) {
		movieDao.save(movie);
	}

	@Override
	public List<Movie> findAll() {
		return movieDao.findAll();
	}

	@Override
	public void delete(Movie movie) {
		movieDao.delete(movie);
	}

	@Override
	public void update(Movie movie) {
		movieDao.save(movie);
	}

	@Override
	public Movie findByTitle(String title) {
		return movieDao.findByTitle(title);
	
	}
	
	@Override
	public Movie findById(Integer id) {
		return movieDao.findById(id);
	
	}
	
	@Override 
	public Set<Movie> findAllMoviesInShow(Cinema cinema) {
		 Set<Movie> result = new HashSet<>();
		 
		 for(Seance seance :  seanceDao.allSeancesOfDay(cinema, LocalDate.now())) {
			 result.add(seance.getMovie());
		 }
		 
		 return result;
	}
	
	@Override 
	public Set<Movie> findAllMoviesInFuture(Cinema cinema) {
		 Set<Movie>result = new HashSet<>(movieDao.findAll());
		
		 result.removeAll(findAllMoviesInShow(cinema));
		 //System.out.println(result);
		 return result;
	}


//	@Override
//	public List<Movie> findAllMoviesInCinema(Cinema cinema) {
//		return movieDao.findAllMoviesInCinema(cinema);
//	}

}
