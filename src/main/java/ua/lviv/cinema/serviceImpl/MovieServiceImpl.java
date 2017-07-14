package ua.lviv.cinema.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

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
    public void save(Movie movie, List<MultipartFile> images, MultipartFile image) {

        movieDao.saveAndFlush(movie);

        List<MovieImages> imagePaths = new ArrayList<>();
        System.out.println("images Service = " + images);

        for (MultipartFile multipartFile : images) {
            String path = "C:\\all\\apache-tomcat-8.0.44\\resources\\"
                    + movie.getTitle() + "\\" + multipartFile.getOriginalFilename();
            MovieImages movieImages = new MovieImages("/resources/" + movie.getTitle() + "/"
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


        //--------------------------------
        String path = "C:\\all\\apache-tomcat-8.0.44\\resources\\"
                + movie.getTitle() + "\\" + image.getOriginalFilename();

        movie.setMovieImageLogo("/resources/" + movie.getTitle() + "/"
                + image.getOriginalFilename());

        File filePath = new File(path);

        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        try {
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }
        //--------------------------------

        System.out.println("imagePaths SERVICE = " + imagePaths);
        imagePaths.stream().forEach(img -> movieImagesService.save(img));
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
    public List<Movie> findAllMoviesInShow(Cinema cinema) {
        List<Movie> result = new ArrayList<>();

        for (Seance seance : seanceDao.allSeancesOfDay(cinema, LocalDate.now())) {
            result.add(seance.getMovie());
        }
        //result.stream().sorted((m1, m2) -> m1.getTitle().compareToIgnoreCase(m2.getTitle()));
        return result;
    }

    @Override
    public List<Movie> findAllMoviesInFuture(Cinema cinema) {
        List<Movie> result = new ArrayList<>(movieDao.findAll());

        result.removeAll(findAllMoviesInShow(cinema));

        Collections.sort(result, (m1, m2) -> {
            if (m1.getShowFromDate().equals(m2.getShowFromDate())) {
                return 0;
            } else if (m1.getShowFromDate().isBefore(m2.getShowFromDate())) {
                return -1;
            } else {
                return 1;
            }
        });


        return result;
    }

    @Override
    public Movie findByIdWithMovieImages(int id) {
        return movieDao.findByIdWithMovieImages(id);
    }

    @Override
    public Movie findByIdWithUsers(int id) {
        return movieDao.findByIdWithUsers(id);
    }
//	@Override
//	public List<Movie> findAllMoviesInCinema(Cinema cinema) {
//		return movieDao.findAllMoviesInCinema(cinema);
//	}

}
