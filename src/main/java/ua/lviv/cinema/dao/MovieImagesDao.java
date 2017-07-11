package ua.lviv.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.cinema.entity.MovieImages;

/**
 * Created by n.dorosh on 11.07.2017.
 */
public interface MovieImagesDao extends JpaRepository<MovieImages, Integer> {
}
