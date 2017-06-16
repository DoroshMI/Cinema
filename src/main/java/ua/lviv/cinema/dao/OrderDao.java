package ua.lviv.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Order;
import ua.lviv.cinema.entity.Seance;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{
	
	Order findById(Integer id);
	
	@Query("select o from Order o left join fetch o.seats seats where o.id = :id")
	Order findByIdWithSeats(@Param("id") Integer id);
}
