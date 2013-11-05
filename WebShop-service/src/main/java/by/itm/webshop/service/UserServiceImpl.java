package by.itm.webshop.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;
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
			user.setEnabled(true);
			user.setCreationDate(new Date());
			userDao.addUser(user);
		} else {
			userDao.saveUser(user);
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User getUser(Long id) {
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
		return userDao.getOrdersForUser(user);
	}

	@Override
	public Order addOrder(Order newOrder) {
		Order oldOrder;
		if ((oldOrder = userDao.getOrderForUserByPhoneId(newOrder.getUser(), newOrder.getPhoneId())) != null) {
			oldOrder.setQty(oldOrder.getQty() + newOrder.getQty());
			userDao.updateOrder(oldOrder);
			return oldOrder;
		} else {
			newOrder.setDate(new Date());
			userDao.addOrder(newOrder);
			return newOrder;
		}
	}

	@Override
	public Order getOrderById(Long id) {
		return userDao.getOrderById(id);
	}

	@Override
	public void deleteOrder(Long id) {
		userDao.deleteOrder(id);

	}

}
