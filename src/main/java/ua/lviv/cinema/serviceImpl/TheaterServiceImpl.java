package ua.lviv.cinema.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.cinema.entity.Theater;
import ua.lviv.cinema.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	private TheaterService theaterService;
	
	@Override
	public void save(Theater theater) {
		theaterService.save(theater);
	}

	@Override
	public List<Theater> findAll() {
		return theaterService.findAll();
	}

	@Override
	public void delete(Theater theater) {
		theaterService.delete(theater);
	}

	@Override
	public void update(Theater theater) {
		theaterService.update(theater);
	}

	@Override
	public Theater findByIdWithCinemas(Integer id) {
		return theaterService.findByIdWithCinemas(id);
	}

	@Override
	public Theater findByIdWithMovies(Integer id) {
		return theaterService.findByIdWithMovies(id);
	}

}
