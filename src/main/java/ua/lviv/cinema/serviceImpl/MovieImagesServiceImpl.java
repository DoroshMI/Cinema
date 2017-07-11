package ua.lviv.cinema.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.cinema.dao.MovieImagesDao;
import ua.lviv.cinema.entity.MovieImages;
import ua.lviv.cinema.service.MovieImagesService;

import java.util.List;

/**
 * Created by n.dorosh on 11.07.2017.
 */
@Service
public class MovieImagesServiceImpl implements MovieImagesService {
    @Autowired
    private MovieImagesDao movieImagesDao;

    @Override
    public void save(MovieImages movieImages) {
        movieImagesDao.save(movieImages);
        System.out.println("movieImages DAO = " + movieImages);
    }

    @Override
    public List<MovieImages> findAll() {
        return movieImagesDao.findAll();
    }

    @Override
    public void delete(MovieImages movieImages) {
        movieImagesDao.delete(movieImages);
    }

    @Override
    public void update(MovieImages movieImages) {
        movieImagesDao.save(movieImages);
    }
}
