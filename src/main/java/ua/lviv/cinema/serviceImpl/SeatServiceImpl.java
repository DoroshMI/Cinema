package ua.lviv.cinema.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.cinema.dao.SeatDao;
import ua.lviv.cinema.entity.Seat;
import ua.lviv.cinema.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatDao seatDao;
	
	@Override
	public void save(Seat seat) {
		seatDao.save(seat);
	}

	@Override
	public List<Seat> findAll() {
		return seatDao.findAll();
	}

	@Override
	public void delete(Seat seat) {
		seatDao.delete(seat);
	}

	@Override
	public void update(Seat seat) {
		seatDao.save(seat);
	}

}
