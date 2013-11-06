package by.itm.webshop.persistence;

import java.util.List;

import by.itm.webshop.domain.Order;
import by.itm.webshop.domain.User;

public interface OrderDao {
	
	List<Order> getOrdersForUser(User user);

	void addOrder(Order order);

	void updateOrder(Order order);

	Order getOrderById(long id);

	void deleteOrder(long id);

	Order getOrderForUserByPhoneId(User user, Long phoneId);

}
