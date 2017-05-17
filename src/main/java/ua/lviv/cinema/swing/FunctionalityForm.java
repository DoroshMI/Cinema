package ua.lviv.cinema.swing;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.persistence.EntityManager;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.lviv.cinema.dao.CinemaDao;
import ua.lviv.cinema.dao.UserDao;
import ua.lviv.cinema.dao.MovieDao;
import ua.lviv.cinema.dao.MoviehallDao;
import ua.lviv.cinema.dao.ScheduleDao;
import ua.lviv.cinema.dao.SeanceDao;

import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.service.AddressService;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.MovieService;
import ua.lviv.cinema.service.MoviehallService;
import ua.lviv.cinema.service.ScheduleService;
import ua.lviv.cinema.service.SeanceService;
import ua.lviv.cinema.service.UserService;

public class FunctionalityForm {

	
	private Cinema cinema;

	ConfigurableApplicationContext context;
	
	private CinemaService cinemaService;
	private AddressService addressService;
	private UserService userService;
	private MoviehallService moviehallService;
	private ScheduleService scheduleService;
	private SeanceService seanceService;
	private MovieService movieService;

	public FunctionalityForm() {
		

		context = new ClassPathXmlApplicationContext("applicationContext.xml");

		cinemaService = context.getBean("cinemaServiceImpl", CinemaService.class);
		addressService = context.getBean("addressServiceImpl", AddressService.class); 
		userService = (UserService) context.getBean("userServiceImpl");
		moviehallService = (MoviehallService) context.getBean("moviehallServiceImpl");
		scheduleService = (ScheduleService) context.getBean("scheduleServiceImpl");
		seanceService = (SeanceService) context.getBean("seanceServiceImpl");
		movieService = (MovieService) context.getBean("movieServiceImpl");
	}

	public Cinema init() {

		Address addressCinema = new Address("Sy", "23", "Lviv", "Lvivska", "1234", "Ukraine");
		addressService.save(addressCinema);
		Cinema cinema = new Cinema("imax", addressCinema);
		cinemaService.save(cinema);
		

//		@SuppressWarnings("deprecation")
//		User userA = new User("A", "aa", "a@", "111", LocalDate.of(1985, 7, 8), LocalDate.now(), cinema);
//		User userB = new User("B", "bb", "b@", "222", LocalDate.of(1985, 7, 28), LocalDate.now(), cinema);
//		
//		User userAdmA = new User("SSS", "aa", "a@", "fg", LocalDate.of(1934, 5, 2), LocalDate.now(), cinema);
//		User userAdmB = new User("FFF", "df", "b@", "dfg", LocalDate.of(1954, 2, 28), LocalDate.now(), cinema);
//
//		userService.save(userA);
//		userService.save(userB);
		
		

		Moviehall moviehallA = new Moviehall("hall1", 10, 10, cinema);
		Moviehall moviehallB = new Moviehall("hall2", 5, 6, cinema);
		Moviehall moviehallC = new Moviehall("hall3", 6, 7, cinema);
		
		
		
		moviehallService.save(moviehallA);
		moviehallService.save(moviehallB);
		moviehallService.save(moviehallC);

		Movie movie1 = new Movie("bond", 100, LocalDate.of(2017, Month.APRIL, 29));
		Movie movie2 = new Movie("qqqq", 110, LocalDate.of(2017, Month.MAY, 3));
		Movie movie3 = new Movie("ccccc", 110, LocalDate.of(2017, Month.MAY, 13));

		System.out.println("GGGGGGGGGGG " + cinema);
		movie1.addCinema(cinema);
		movie2.addCinema(cinema);
		movie3.addCinema(cinema);
		
		movieService.save(movie1);
		movieService.save(movie2);
		movieService.save(movie3);
		
		cinemaService.update(cinema);

		Schedule schedule = scheduleService.findByDateAndMoviehall(LocalDate.now(), moviehallA);

		Seance seance1 = new Seance(movieService.findByTitle("bond"),
				LocalDateTime.of(schedule.getDate(), LocalTime.of(9, 10)), 100, schedule);
		seanceService.save(seance1);

		
		context.close();
		return cinema;

	}

	public Cinema read() {
		return cinemaService.findByName("imax");
	}

	public static LocalDate[] allDays() {
		LocalDate[] result = new LocalDate[7];
		for (int i = 0; i < 7; i++) {
			result[i] = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
					LocalDate.now().getDayOfMonth() + i);
		}
		return result;
	}

}
