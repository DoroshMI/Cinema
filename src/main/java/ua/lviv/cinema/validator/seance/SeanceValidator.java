package ua.lviv.cinema.validator.seance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.cinema.dao.ScheduleDao;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component("seanceValidator")
public class SeanceValidator implements Validator {

    @Autowired
    private UserService userService;

    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    public void validator(Object o) throws SeanceException {

        System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        if(o == null) {
            throw new SeanceException(SeanceValidatorMessages.INCORRECT_DATE_FIELD);
        }

        System.out.println("RRRRRRRRRRRRRRRR1111111111111");
        Seance seance = (Seance) o;
        System.out.println("RRRRRRRRRRRRRRRR222222222222");
        if(seance== null) {
            throw new SeanceException(SeanceValidatorMessages.INCORRECT_DATE_FIELD);
        }
        System.out.println("seance = " + seance);
        System.out.println("RRRRRRRRRRRRRRRR3333333333333333");
        if (seance.getStartTime().toLocalTime() == null )  {
            throw new SeanceException(SeanceValidatorMessages.EMPTY_TIME_FIELD);
        } else if (seance.getMovie() == null) {
            throw new SeanceException(SeanceValidatorMessages.EMPTY_MOVIE_FIELD);
        } else if ((seance.getPrice() == null) || (seance.getPrice() <= 0)) {
            throw new SeanceException(SeanceValidatorMessages.EMPTY_PRICE_FIELD);
        }


        System.out.println("GGGGGGGGGGGGGGGG   " + seance.getStartTime());
        if(seance.getStartTime().toLocalDate().isBefore(LocalDate.now()) || seance.getStartTime().toLocalDate().isAfter(LocalDate.now().plusDays(30))) {

            System.out.println(SeanceValidatorMessages.INCORRECT_DATE_FIELD);
            throw new SeanceException(SeanceValidatorMessages.INCORRECT_DATE_FIELD);
        }

        if(seance.getStartTime().toLocalTime().isBefore(LocalTime.of(9,0)) ) {

            System.out.println(SeanceValidatorMessages.INCORRECT_TIME_FIELD);
            throw new SeanceException(SeanceValidatorMessages.INCORRECT_TIME_FIELD);
        }


        Schedule schedule = scheduleDao.findByIdWithSeances(seance.getSchedule().getId());
        if (!schedule.addSeance(seance))
            throw new SeanceException(SeanceValidatorMessages.SEANCE_ALREADY_EXIST);


    }

}
