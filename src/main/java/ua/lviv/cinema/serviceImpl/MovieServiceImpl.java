package ua.lviv.cinema.serviceImpl;

import java.io.File;
import java.io.IOException;
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

import org.springframework.web.multipart.MultipartFile;
import ua.lviv.cinema.dao.MovieDao;
import ua.lviv.cinema.dao.SeanceDao;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.MovieImages;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.service.MovieImagesService;
import ua.lviv.cinema.service.MovieService;
import ua.lviv.cinema.service.MoviehallService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private SeanceDao seanceDao;

    @Autowired
    private MovieImagesService movieImagesService;

    @Override
    public void save(Movie movie, List<MultipartFile> images) {

        movieDao.saveAndFlush(movie);

        List<MovieImages> imagePaths = new ArrayList<>();
        System.out.println("images Service = " + images);
        for (MultipartFile multipartFile : images) {

            String path = "C:\\all\\apache-tomcat-8.0.44\\resources\\"
                    + movie.getTitle() + "\\" + multipartFile.getOriginalFilename();
MovieImages movieImages = new MovieImages("resources/" + movie.getTitle() + "/"
        + multipartFile.getOriginalFilename());
            imagePaths.add(movieImages);
            movieImages.setMovie(movie);

            File filePath = new File(path);

            if (!filePath.exists()) {
                filePath.mkdirs();
            }


            try {
                multipartFile.transferTo(filePath);
            } catch (IOException e) {
                System.out.println("error with file");
            }



        }
        System.out.println("imagePaths SERVICE = " + imagePaths);
        imagePaths.stream().forEach(image -> movieImagesService.save(image));
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

        for (Seance seance : seanceDao.allSeancesOfDay(cinema, LocalDate.now())) {
            result.add(seance.getMovie());
        }

        return result;
    }

    @Override
    public Set<Movie> findAllMoviesInFuture(Cinema cinema) {
        Set<Movie> result = new HashSet<>(movieDao.findAll());

        result.removeAll(findAllMoviesInShow(cinema));
        //System.out.println(result);
        return result;
    }


//	@Override
//	public List<Movie> findAllMoviesInCinema(Cinema cinema) {
//		return movieDao.findAllMoviesInCinema(cinema);
//	}

}
