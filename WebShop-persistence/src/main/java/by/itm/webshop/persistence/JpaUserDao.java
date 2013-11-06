package by.itm.webshop.persistence;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.itm.webshop.domain.User;

@Repository("userDao")
@Transactional
public class JpaUserDao implements UserDao {
	
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
	public void deleteUser(Long id) {
		try {
			em.remove(getUserById(id));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

	

}
