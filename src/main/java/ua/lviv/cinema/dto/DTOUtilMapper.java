package ua.lviv.cinema.dto;

import ua.lviv.cinema.entity.CreditCard;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Seat;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by n.dorosh on 06.07.2017.
 */
public class DTOUtilMapper {

    public static List<SeatDTOFull> saetsToSeatDTOFulls(List<Seat> seats) {
        List<SeatDTOFull> seatDTOFulls = new ArrayList<>();

        seats.stream().forEach(seat -> {
            seatDTOFulls.add(new SeatDTOFull(seat.getId(), seat.isFreeSeat(), seat.getPrice(),
                    seat.getSeance().getId(), seat.getCoordinate().getRow(), seat.getCoordinate().getColumn()));
        });
        return seatDTOFulls;
    }

    public static CreditCard creditCardDAOToCreditCard(CreditCardDTO creditCardDTO) {
        CreditCard creditCard = new CreditCard();
        System.out.println("creditCardDTO in DTO = " + creditCardDTO);
        creditCard.setAccountNumber(creditCardDTO.getAccountNumberI() + creditCardDTO.getAccountNumberII() + creditCardDTO.getAccountNumberIII() + creditCardDTO.getAccountNumberIV());
        creditCard.setExpirationYearMonth(YearMonth.of(  Integer.valueOf(creditCardDTO.getExpirationYear()), Integer.valueOf(creditCardDTO.getExpirationMonth())));
        creditCard.setSecurityCode(creditCardDTO.getSecurityCode());
        System.out.println("creditCard = " + creditCard);
        return creditCard;
    }


    public static MovieDTO movieToMovieDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setMinutes(movie.getMinutes()+"");
        movieDTO.setShowFromDate(movie.getShowFromDate().toString());
        movieDTO.setShowToDate(movie.getShowToDate().toString());

        return movieDTO;
    }
}
