package ua.lviv.cinema.validator.seance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.cinema.dao.ScheduleDao;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;

@Component("seanceValidator")
public class SeanceValidator implements Validator {

    @Autowired
    private UserService userService;

    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    public void validator(Object o) throws SeanceException {

        Seance seance = (Seance) o;
        System.out.println("VALIDATOR");
        System.out.println(seance);
        System.out.println(seance.getStartTime().toLocalTime());
        if (seance.getStartTime().toLocalTime() == null )  {
            throw new SeanceException(SeanceValidatorMessages.EMPTY_TIME_FIELD);
        } else if (seance.getMovie() == null) {
            throw new SeanceException(SeanceValidatorMessages.EMPTY_MOVIE_FIELD);
        } else if ((seance.getPrice() == null) || (seance.getPrice() <= 0)) {
            throw new SeanceException(SeanceValidatorMessages.EMPTY_PRICE_FIELD);
        } else if (seance.getSchedule() == null ) {
            throw new SeanceException(SeanceValidatorMessages.EMPTY_SCHEDULE_FIELD);
        }

        Schedule schedule = scheduleDao.findByIdWithSeances(seance.getSchedule().getId());
        if (!schedule.addSeance(seance))
            throw new SeanceException(SeanceValidatorMessages.SEANCE_ALREADY_EXIST);
    }

}
