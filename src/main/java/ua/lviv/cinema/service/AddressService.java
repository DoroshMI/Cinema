package ua.lviv.cinema.service;

import java.util.List;

import ua.lviv.cinema.entity.Address;


public interface AddressService {

	void save(Address address);
	List<Address> findAll();	
	void delete(Address address); 
	void update(Address address); 
	
	
	
}
