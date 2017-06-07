package ua.lviv.cinema.editor;

import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.entity.Movie;

import java.beans.PropertyEditorSupport;

/**
 * Created by User on 25.05.2017.
 */
public class MovieEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String idMovieFromJSP) throws IllegalArgumentException {
        System.out.println("EDITOR : "+ idMovieFromJSP);
        Movie movie = new Movie();
        movie.setId(Integer.parseInt(idMovieFromJSP));

        setValue(movie);
    }
}
