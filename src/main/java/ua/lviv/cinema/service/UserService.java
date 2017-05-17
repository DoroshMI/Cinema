package ua.lviv.cinema.service;

import java.util.List;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.User;

public interface UserService {

	void save(User customer);
	List<User> findAll();	
	void delete(User customer); 
	void update(User customer); 
	
	User findByEmailAndPassword(String name, String password);
	void delete(String name, String password);	
	//void addCustomerToCinema(Customer customer, Cinema cinema);
	
}
