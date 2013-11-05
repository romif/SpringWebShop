package by.itm.webshop.service;

import java.util.List;

import by.itm.webshop.domain.Order;
import by.itm.webshop.domain.User;

public interface UserService {
	
	void saveUser(User user);

	User getUser(Long id);
	
	User getUser(String login);

	void deleteUser(Long id);

	List<Order> getOrdersForUser(User user);

	Order addOrder(Order order);

	Order getOrderById(Long id);

	void deleteOrder(Long id);

}
