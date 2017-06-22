package ua.lviv.cinema.serviceImpl;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by admin on 6/21/2017.
 */
public class CookieThenAcceptHeaderLocaleResolver extends CookieLocaleResolver {

    private final AcceptHeaderLocaleResolver acceptHeaderLocaleResolver =
            new AcceptHeaderLocaleResolver();

    @Override
    protected Locale determineDefaultLocale(HttpServletRequest request) {

        Locale currentLocal =
                new Locale(acceptHeaderLocaleResolver
                        .resolveLocale(request)
                        .getLanguage());
        
        System.out.println("COUNTRY     " + currentLocal.getCountry());

        if(currentLocal.equals("ua")) return new Locale("ua");

        

        return new Locale("en");
    }
}