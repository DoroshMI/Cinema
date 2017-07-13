package ua.lviv.cinema.dto;

/**
 * Created by n.dorosh on 06.07.2017.
 */
public class SeanceDTO {

    private int id;

    private String date;
    private String time;
    private String movieId;
    private String price;

    public SeanceDTO() {
    }

    public SeanceDTO(String date, String time, String movieId, String price) {
        this.date = date;
        this.time = time;
        this.movieId = movieId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SeanceDTO{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", movieId='" + movieId + '\'' +
                ", price=" + price +
                '}';
    }
}
