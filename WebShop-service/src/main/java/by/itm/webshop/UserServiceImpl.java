package by.itm.webshop;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.itm.webshop.domain.Order;
import by.itm.webshop.domain.User;
import by.itm.webshop.persistence.UserDao;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	private final PasswordEncoder encoder = new StandardPasswordEncoder();

	@Autowired
	UserDao userDao;

	@Override
	public void addUser(User user) throws NoSuchAlgorithmException {
		user.setCreationDate(new Date());
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.addUser(user);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.saveUser(user);
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

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
