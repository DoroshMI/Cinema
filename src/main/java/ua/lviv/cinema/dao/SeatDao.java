package ua.lviv.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.cinema.entity.Seat;

public interface SeatDao extends JpaRepository<Seat, Integer>{

}
