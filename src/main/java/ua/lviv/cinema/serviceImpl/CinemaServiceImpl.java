package ua.lviv.cinema.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;
import ua.lviv.cinema.dao.AddressDao;
import ua.lviv.cinema.dao.CinemaDao;
import ua.lviv.cinema.dao.MoviehallDao;
import ua.lviv.cinema.entity.*;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.validator.Validator;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaDao cinemaDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private MoviehallDao moviehallDao;
    
    @Autowired
	@Qualifier("addressValidator")
	private Validator addressValidator;

    @Override
    public void save(Cinema cinema, MultipartFile image) throws Exception{
    	addressValidator.validator(cinema.getAddress());
        cinemaDao.saveAndFlush(cinema);

        String path = "C:\\all\\apache-tomcat-8.0.44\\resources\\"
                + cinema.getName() + "\\" + image.getOriginalFilename();
        String cinemaImages = "/resources/" + cinema.getName() + "/"
                + image.getOriginalFilename();

       cinema.setCinemaImage(cinemaImages);

        File filePath = new File(path);

        if (!filePath.exists()) {
            filePath.mkdirs();
        }


        try {
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }
        System.out.println("cinema SERVICE = " + cinema);
        cinemaDao.saveAndFlush(cinema);

    }

    @Override
    public void update(int cinemaId, Cinema cinema, Address address) throws Exception {
        address.setId(cinemaDao.findOne(cinemaId).getAddress().getId());
        cinema.setAddress(address);
        cinema.setId(cinemaId);
        addressValidator.validator(cinema.getAddress());
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
