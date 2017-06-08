package ua.lviv.cinema.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.User;

public interface UserService {

	void save(User customer) throws Exception;
	List<User> findAll();	
	void delete(User customer); 
	void update(User customer); 
	
	User findByEmail(String email);
	User findByPhone(String phone);
	
//	User findByEmailAndPassword(String email, String password) ;
//	User findByPhoneAndPassword(String phone, String password);
	User findByEmailOrPhone(String emailOrPhone);
	//void delete(String name, String password);	
	//void addCustomerToCinema(Customer customer, Cinema cinema);
	
}
