package ua.lviv.cinema.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.cinema.dao.AddressDao;
import ua.lviv.cinema.entity.Address;
import ua.lviv.cinema.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressDao addressDao; 
	
	@Override
	public void save(Address address) {
		addressDao.save(address);		
	}

	@Override
	public List<Address> findAll() {
		return addressDao.findAll();
	}

	@Override
	public void delete(Address address) {
		addressDao.delete(address);
	}

	@Override
	public void update(Address address) {
		addressDao.save(address);
		
	}

}
