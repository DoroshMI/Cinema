package ua.lviv.cinema.dto;

import ua.lviv.cinema.entity.Seat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by n.dorosh on 06.07.2017.
 */
public class DTOUtilMapper {

    public static List<SeatDTOFull> saetsToSeatDTOFulls(List<Seat> seats) {
        List<SeatDTOFull> seatDTOFulls = new ArrayList<>();

        seats.stream().forEach(seat -> {
            seatDTOFulls.add(new SeatDTOFull(seat.getId(),seat.isFreeSeat(),seat.getPrice(),
                    seat.getSeance().getId(), seat.getCoordinate().getRow(),seat.getCoordinate().getColumn()));
        });
        return seatDTOFulls;
    }
}
