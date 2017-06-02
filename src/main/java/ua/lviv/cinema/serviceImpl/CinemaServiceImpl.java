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

import ua.lviv.cinema.dao.AddressDao;
import ua.lviv.cinema.dao.CinemaDao;
import ua.lviv.cinema.dao.MoviehallDao;
import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.service.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaDao cinemaDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private MoviehallDao moviehallDao;

    @Override
    public void save(Cinema cinema) {
        cinemaDao.save(cinema);
    }

    @Override
    public void update(int cinemaId, Cinema cinema, Address address) {
        address.setId(cinemaDao.findOne(cinemaId).getAddress().getId());
        cinema.setAddress(address);
        cinema.setId(cinemaId);
        cinemaDao.save(cinema);
    }

    @Override
    public List<Cinema> findAll() {
        return cinemaDao.findAll();
    }

    @Override
    public void delete(Cinema cinema) {


        cinemaDao.findByIdWithMoviehalls(cinema.getId()).getMoviehalls().stream()
                .forEach(moviehall -> moviehallDao.delete(moviehallDao.findOne(moviehall.getId())));

        cinemaDao.delete(cinema);
    }

    @Override
    public Cinema findByName(String name) {
        return cinemaDao.findByName(name);
    }

//    @Override
//    public Cinema findByIdWithMoviehalls(Cinema cinema) {
//        List<Movie> list = null;
//        if (cinema.getMovies() != null) {
//            list = cinema.getMovies();
//        }
//        Cinema cinemaNew = cinemaDao.findByIdWithMoviehalls(cinema.getId());
//        cinemaNew.setMovies(list);
//        return cinemaNew;
//    }

    @Override
    public Cinema findByIdWithMoviehalls(Cinema cinema) {
        List<Movie> list = null;
        if (cinema.getMovies() != null) {
            list = cinema.getMovies();
        }
        Cinema cinemaNew = cinemaDao.findByIdWithMoviehalls(cinema.getId());
        cinemaNew.setMovies(list);
        return cinemaNew;
    }

    @Override
    public Cinema findByIdWithMovies(Integer id) {
        return cinemaDao.findByIdWithMovies(id);
    }

    @Override
    public Cinema findById(Integer id) {
        return cinemaDao.findOne(id);
    }


}
