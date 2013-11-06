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

@Repository("orderDao")
@Transactional
public class JpaOrderDao implements OrderDao {

	private static final String ORDERS_BY_USER_LOGIN = "SELECT s FROM Order s WHERE s.user.login = :login";
	private static final String ORDER_FOR_USER_BY_PHONE_ID = "SELECT o FROM Order o WHERE o.phoneId = :phoneId AND o.user = :user";

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> getOrdersForUser(User user) {
		return (List<Order>) em.createQuery(ORDERS_BY_USER_LOGIN)
				.setParameter("login", user.getLogin()).getResultList();
	}

	@Override
	public Order getOrderForUserByPhoneId(User user, Long phoneId) {
		try {
			return (Order) em.createQuery(ORDER_FOR_USER_BY_PHONE_ID)
					.setParameter("phoneId", phoneId).setParameter("user", user).getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	public void addOrder(Order order) {
		em.persist(order);
	}

	@Override
	public void updateOrder(Order order) {
		em.merge(order);
	}

	@Override
	public void deleteOrder(long id) {
		try {
			em.remove(getOrderById(id));
		} catch (DataAccessException e) {
		}
	}

	@Override
	public Order getOrderById(long id) {
		return em.find(Order.class, id);
	}

}
