package by.itm.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.itm.webshop.domain.Order;
import by.itm.webshop.domain.User;
import by.itm.webshop.persistence.UserDao;

//@Service("userService")
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	private final PasswordEncoder encoder = new StandardPasswordEncoder();

	@Autowired
	UserDao userDao;

	@Override
	public void saveUser(User user) {
		if (user.getId() == null) {
			user.setPassword(encoder.encode(user.getPassword()));
			userDao.addUser(user);
		} else {
			userDao.saveUser(user);
		}

	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User getUser(long id) {
		return userDao.getUserById(id);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User getUser(String login) {
		return userDao.getUserByLogin(login);
	}

	@Override
	public void deleteUser(Long id) {
		userDao.deleteUser(id);

	}

	@Override
	public List<Order> getOrdersForUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public Order getOrderById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub

	}

}
