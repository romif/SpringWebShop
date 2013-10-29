package by.itm.webshop.persistence;

import java.util.List;

import by.itm.webshop.domain.Order;
import by.itm.webshop.domain.User;

public interface UserDao {
	void addUser(User user);

	void saveUser(User user);

	User getUserById(long id);

	void deleteUser(User user);

	List<Order> getOrdersForUser(User user);

	Order addOrder(Order order);

	void updateOrder(Order order);

	Order getOrderById(long id);

	void deleteOrder(Order order);
}
