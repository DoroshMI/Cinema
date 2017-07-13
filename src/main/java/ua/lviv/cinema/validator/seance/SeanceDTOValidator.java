package ua.lviv.cinema.validator.seance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.cinema.dao.ScheduleDao;
import ua.lviv.cinema.dto.SeanceDTO;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;

@Component("seanceDTOValidator")
public class SeanceDTOValidator implements Validator {


    @Override
    public void validator(Object o) throws SeanceException {

        SeanceDTO seanceDTO = (SeanceDTO) o;
        System.out.println("VALIDATOR SeanceDTO");
        System.out.println(seanceDTO);

        if (seanceDTO.getDate() == null || "".equals(seanceDTO.getDate()) || seanceDTO.getDate().length() == 0) {
            throw new SeanceException(SeanceValidatorMessages.EMPTY_DATE_FIELD);
        } else if (seanceDTO.getTime() == null || "".equals(seanceDTO.getTime()) || seanceDTO.getTime().length() == 0) {
            throw new SeanceException(SeanceValidatorMessages.EMPTY_TIME_FIELD);
        } else if (seanceDTO.getMovieId() == null || seanceDTO.getMovieId().length() == 0) {
            throw new SeanceException(SeanceValidatorMessages.EMPTY_MOVIE_FIELD);
        } else if (seanceDTO.getPrice() == null || seanceDTO.getPrice().length() == 0 ) {
            throw new SeanceException(SeanceValidatorMessages.EMPTY_PRICE_FIELD);
        }
    }
}