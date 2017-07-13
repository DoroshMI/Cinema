package ua.lviv.cinema.validator.moviehall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.MoviehallService;
import ua.lviv.cinema.validator.Validator;

@Component
public class MoviehallValidator implements Validator {

	@Autowired
	private MoviehallService moviehallService;

	@Override
	public void validator(Object o) throws Exception {

		Moviehall moviehall = (Moviehall) o;

		if(moviehall == null) {
			throw new MoviehallException(MoviehallValidatorMessages.INCORRECT_DATA_NULL);
		}

		if( (moviehall.getName() == null) || (moviehall.getName() == "") || (moviehall.getName().length() == 0)) {
			throw new Exception(MoviehallValidatorMessages.EMPTY_NAME_FIELD);
		} else if( (moviehall.getRows() <= 0) ) {
			throw new Exception(MoviehallValidatorMessages.EMPTY_ROWS_FIELD);
		} else if( (moviehall.getColumns() <= 0) ) {
			throw new Exception(MoviehallValidatorMessages.EMPTY_COLUMNS_FIELD);
		} else if( (moviehall.getTechnology() == null) || (moviehall.getTechnology().name() == "") || (moviehall.getTechnology().name().length() == 0)) {
			throw new Exception(MoviehallValidatorMessages.EMPTY_TECHNOLOGY_FIELD);
		} else if( (moviehallService.findByNameAndCinema(moviehall.getName(), moviehall.getCinema()) != null) &&  (moviehallService.findByNameAndCinema(moviehall.getName(), moviehall.getCinema()).getId()!=moviehall.getId()) ) {
			throw new Exception(MoviehallValidatorMessages.INCORRECT_NAME);
		}

	}

}
