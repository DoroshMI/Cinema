package ua.lviv.cinema.dto;

/**
 * Created by n.dorosh on 06.07.2017.
 */
public class MovieDTO {

    private int id;

    private String title;

    private String minutes;
    private String showFromDate;

    private String showToDate;

    public MovieDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getShowFromDate() {
        return showFromDate;
    }

    public void setShowFromDate(String showFromDate) {
        this.showFromDate = showFromDate;
    }

    public String getShowToDate() {
        return showToDate;
    }

    public void setShowToDate(String showToDate) {
        this.showToDate = showToDate;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", minutes='" + minutes + '\'' +
                ", showFromDate='" + showFromDate + '\'' +
                ", showToDate='" + showToDate + '\'' +
                '}';
    }
}
