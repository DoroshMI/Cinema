package ua.lviv.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.cinema.entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

}
