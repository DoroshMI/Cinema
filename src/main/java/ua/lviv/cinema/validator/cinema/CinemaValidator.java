package ua.lviv.cinema.validator.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;
import ua.lviv.cinema.validator.address.AddressValidatorMessages;

@Component
public class CinemaValidator implements Validator {

	@Autowired
	private CinemaService cinemaService;

	@Override
	public void validator(Object o) throws Exception {

		Cinema cinema = (Cinema) o;

		if(cinema == null) {
			throw new CinemaException(CinemaValidatorMessages.INCORRECT_DATA_NULL);
		}

		if( (cinema.getName() == null) || (cinema.getName() == "") || (cinema.getName().length() == 0)) {
			throw new Exception(CinemaValidatorMessages.EMPTY_NAME_FIELD);
		} else if( cinemaService.findByName(cinema.getName())!= null && ( cinemaService.findByName(cinema.getName()).getId()!=cinema.getId()) ) {
			throw new Exception(CinemaValidatorMessages.INCORRECT_NAME);
		}if( (cinema.getCinemaImage() == null || cinema.getCinemaImage() == "" || cinema.getCinemaImage().length() == 0) ) {
			throw new Exception(CinemaValidatorMessages.EMPTY_IMAGE_FIELD);
		}

	}

}
