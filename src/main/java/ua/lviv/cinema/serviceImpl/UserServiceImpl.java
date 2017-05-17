package ua.lviv.cinema.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.cinema.dao.UserDao;
import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public void update(User user) {
		userDao.save(user);
	}

	@Override
	public User findByEmailAndPassword(String name, String password) {
		return userDao.findByEmailAndPassword(name, password);
	}

	@Override	
	public void delete(String name, String password) {
		User user = findByEmailAndPassword(name, password);
		userDao.delete(user.getId());		
	}

}
