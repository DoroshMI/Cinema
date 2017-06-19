package ua.lviv.cinema.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
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
	private Validator userSignupValidator;

	@Autowired
	@Qualifier("usernameValidator")
	private Validator usernameValidator;


	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
//	public void save(User user, MultipartFile image) throws Exception {
	public void save(User user) throws Exception {
		System.out.println("AAAAaaaaa1: " + user);
		user.setRole(Role.ROLE_USER);
		System.out.println("AAAAaaaaa2: " + user);
		userSignupValidator.validator(user);
		user.setPassword(encoder.encode(user.getPassword()));

//
//		String path = System.getProperty("catalina.home") + "/resources/"
//				+ user.getName() + "/" + image.getOriginalFilename();
//
//		user.setPathImage("resources/" + user.getName() + "/" + image.getOriginalFilename());
//
//		File filePath = new File(path);
//
//		try {
//			filePath.mkdirs();
//			image.transferTo(filePath);
//		} catch (IOException e) {
//			System.out.println("error with file");
//		}




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

	@Override
	public User findByUuid(String uuid) {
		return userDao.findByUuid(uuid);
	}

	@Override
	public User parse(String username, String password) throws Exception {
		usernameValidator.validator(username);
		return new User(username,password);
	}

	@Override
	public User findByIdWithSeats(int id) {
		return userDao.findByIdWithSeats(id);
	}

	@Override
	public User findById(Integer id) {
		return userDao.findOne(id);
	}

	@Override
	public User findByIdWithOrders(int id) {
		return userDao.findByIdWithOrders(id);
	}
}
