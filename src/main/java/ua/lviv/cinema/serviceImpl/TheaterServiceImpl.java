package ua.lviv.cinema.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.cinema.dao.TheaterDao;
import ua.lviv.cinema.entity.Theater;
import ua.lviv.cinema.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	private TheaterDao theaterDao;
	
	@Override
	public void save(Theater theater) {
		theaterDao.save(theater);
	}

	@Override
	public List<Theater> findAll() {
		return theaterDao.findAll();
	}

	@Override
	public void delete(Theater theater) {
		theaterDao.delete(theater);
	}

	@Override
	public void update(Theater theater) {
		theaterDao.save(theater);
	}

	@Override
	public Theater findByIdWithCinemas(Integer id) {
		return theaterDao.findByIdWithCinemas(id);
	}

	@Override
	public Theater findByIdWithMovies(Integer id) {
		return theaterDao.findByIdWithMovies(id);
	}

}
