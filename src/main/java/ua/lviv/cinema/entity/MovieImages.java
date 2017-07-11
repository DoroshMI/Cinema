package ua.lviv.cinema.entity;

import javax.persistence.*;

/**
 * Created by n.dorosh on 11.07.2017.
 */
@Entity
public class MovieImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pathImage;

    @ManyToOne
    private Movie movie;

    public MovieImages(String pathImage) {
        this.pathImage = pathImage;
    }

    public MovieImages() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "MovieImages{" +
                "id=" + id +
                ", pathImage='" + pathImage + '\'' +
                ", movie=" + movie +
                '}';
    }
}