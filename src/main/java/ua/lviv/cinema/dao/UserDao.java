package ua.lviv.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByEmailAndPassword(String email, String password);
	User findByPhoneAndPassword(String phone, String password);
	
	User findByEmail(String email);
	User findByPhone(String phone);
	
	
}
