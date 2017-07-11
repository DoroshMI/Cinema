package ua.lviv.cinema.service;

import ua.lviv.cinema.entity.MovieImages;

import java.util.List;

/**
 * Created by n.dorosh on 11.07.2017.
 */
public interface MovieImagesService {

    void save(MovieImages movieImages);
    List<MovieImages> findAll();
    void delete(MovieImages movieImages);
    void update(MovieImages movieImages);
}
