package ua.lviv.cinema.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.lviv.cinema.dao.UserDao;
import ua.lviv.cinema.entity.Role;
import ua.lviv.cinema.entity.User;
import ua.lviv.cinema.service.UserService;
import ua.lviv.cinema.validator.Validator;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	@Qualifier("userSignupValidator")
	private Validator validator;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public void save(User user) throws Exception {
		user.setRole(Role.ROLE_USER);
		validator.validator(user);
		user.setPassword(encoder.encode(user.getPassword()));
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
//
//	@Override
//	public User findByEmailAndPassword(String name, String password) {
//		return userDao.findByEmailAndPassword(name, password);
//	}
//
//	@Override
//	public void delete(String name, String password) {
//		User user = findByEmailAndPassword(name, password);
//		userDao.delete(user.getId());
//	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User findByPhone(String phone) {
		return userDao.findByPhone(phone);
	}

//	@Override
//	public User findByPhoneAndPassword(String phone, String password) {
//		return userDao.findByPhoneAndPassword(phone, password);
//	}
	
	

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return userDao.findByEmailOrPhone(s);
	}

	@Override
	public User findByEmailOrPhone(String emailOrPhone) {
		return userDao.findByEmailOrPhone(emailOrPhone);
	}
}
