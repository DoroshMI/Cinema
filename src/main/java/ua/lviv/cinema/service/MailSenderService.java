package ua.lviv.cinema.service;

/**
 * Created by Study on 09.06.2017.
 */
public interface MailSenderService {

    void sendMail (String theme, String mailBody, String email);

}
