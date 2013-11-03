package by.itm.webshop.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.itm.webshop.domain.Order;
import by.itm.webshop.domain.User;

@Repository("userDao")
@Transactional
public class JpaUserDao implements UserDao {
	private static final String ORDERS_BY_USER_LOGIN = "SELECT s FROM Order s WHERE s.user.login = :login";
	private static final String USER_FOR_LOGIN = "SELECT s FROM User s WHERE s.login = :login";

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addUser(User user) {
		em.persist(user);
	}

	@Override
	public void saveUser(User user) {
		em.merge(user);
	}

	@Override
	public User getUserById(long id) {
		return em.find(User.class, id);
	}

	@Override
	public User getUserByLogin(String login) {
		try {
			return (User) em.createQuery(USER_FOR_LOGIN).setParameter("login", login)
					.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> getOrdersForUser(User user) {
		return (List<Order>) em.createQuery(ORDERS_BY_USER_LOGIN)
				.setParameter("login", user.getLogin()).getResultList();
	}

	@Override
	public Order addOrder(Order order) {
		for (Order order1 : getOrdersForUser(order.getUser())) {
			if (order1.getPhoneId() == order.getPhoneId()) {
				order1.setPhoneQty(order1.getPhoneQty() + order.getPhoneQty());
				em.merge(order1);
				return order1;
			}
		}
		em.persist(order);
		return order;
	}

	@Override
	public void deleteUser(Long id) {
		try {
			em.remove(getUserById(id));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteOrder(Order order) {
		try {
			em.remove(order);
		} catch (DataAccessException e) {
		}
	}

	@Override
	public Order getOrderById(long id) {
		return em.find(Order.class, id);
	}

	@Override
	public void updateOrder(Order order) {
		em.merge(order);
	}

}
