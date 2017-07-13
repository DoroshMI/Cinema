package ua.lviv.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
//	User findByEmailAndPassword(String email, String password);
//	User findByPhoneAndPassword(String phone, String password);
	@Query("select u From User u where u.email = :param or u.phone = :param")
	User findByEmailOrPhone(@Param("param") String param);
	
	User findByEmail(String email);
	User findByPhone(String phone);

	@Query("select u from User u where u.uuid = :uuid")
	User findByUuid(@Param("uuid") String uuid);
	
	@Query("select u from User u left join fetch u.seats seats where u.id = :id")
	User findByIdWithSeats(@Param("id") int id);
	
	@Query("select u from User u left join fetch u.orders orders where u.id = :id")
	User findByIdWithOrders(@Param("id") int id);

	@Query("select u from User u left join fetch u.movies orders where u.id = :id")
	User findByIdWithMovies(@Param("id") int id);
	
	
}
