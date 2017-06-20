package ua.lviv.cinema.service;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by Study on 09.06.2017.
 */
public interface MailSenderService {

    void sendMail (String theme, String mailBody, String email);

    void sendMailWithTickets (String theme, String mailBody, String email, String filePath) throws MessagingException, IOException;

}
