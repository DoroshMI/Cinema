package ua.lviv.cinema.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.cinema.dao.MovieDao;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.service.MovieService;
import ua.lviv.cinema.service.MoviehallService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieDao movieDao;

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

}
