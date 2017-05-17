package ua.lviv.cinema.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.cinema.dao.MoviehallDao;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.service.MoviehallService;

@Service
public class MoviehallServiceImpl implements MoviehallService {
	
	@Autowired
	private MoviehallDao moviehallDao;

	@Override
	public void save(Moviehall moviehall) {
		moviehallDao.save(moviehall);
	}

	@Override
	public List<Moviehall> findAll() {
		return moviehallDao.findAll();
	}

	@Override
	public void delete(Moviehall moviehall) {
		moviehallDao.delete(moviehall);
	}

	@Override
	public void update(Moviehall moviehall) {
		moviehallDao.save(moviehall);
	}

	@Override
	public Moviehall findByNameAndCinema(String name, Cinema cinema) {
		return moviehallDao.findByNameAndCinema(name, cinema);
	}

	@Override
	public void delete(String name, Cinema cinema) {
		delete(findByNameAndCinema(name, cinema));
	}

	@Override
	public Moviehall findByIdWithSchedules(Integer id){			
		return moviehallDao.findByIdWithSchedules(id);
	}
}
