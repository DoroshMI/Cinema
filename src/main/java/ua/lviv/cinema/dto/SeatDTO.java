package ua.lviv.cinema.dto;

/**
 * Created by n.dorosh on 06.07.2017.
 */
public class SeatDTO {

    private int id;

    private int seanceId;

    public SeatDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(int seanceId) {
        this.seanceId = seanceId;
    }

    @Override
    public String toString() {
        return "SeatDTO{" +
                "id=" + id +
                ", seanceId=" + seanceId +
                '}';
    }
}
