package by.itm.webshop.service;

import java.util.List;

import by.itm.webshop.domain.Order;
import by.itm.webshop.domain.User;

public interface UserService {
	
	void saveUser(User user);

	User getUser(long id);
	
	User getUser(String login);

	void deleteUser(Long id);

	List<Order> getOrdersForUser(User user);

	Order addOrder(Order order);

	void updateOrder(Order order);

	Order getOrderById(long id);

	void deleteOrder(Order order);

}
