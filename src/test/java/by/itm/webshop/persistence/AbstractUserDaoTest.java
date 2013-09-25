package by.itm.webshop.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import by.itm.webshop.domain.Order;
import by.itm.webshop.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "classpath:persistence-context.xml", 
        "classpath:test-dataSource-context.xml",
        "classpath:test-transaction-context.xml"
        })
        
@TransactionConfiguration(transactionManager="txMgr", defaultRollback=true)
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
@Repository("spitterDao")
public class AbstractUserDaoTest {
	
	@Autowired
	private UserDao dao;
	
	@Test
	public void shouldBeAbleToDeleteInsertedUser() {
	    //assertEquals(0, countRowsInTable(jdbcTemplate, "spitter"));  
		User user=insertAUser("login", "name", "patronymic", "surname", "tel", "email", false,new Date());
		user=dao.getUserById(user.getId());
		assertNotNull(user);
		dao.deleteUser(user);
		user=dao.getUserById(user.getId());
		assertNull(user);
	    
	   // assertEquals(1, countRowsInTable(jdbcTemplate, "spitter"));
	    
	    //assertEquals(2, countRowsInTable(jdbcTemplate, "spitter"));
	}  
	
	@Test
	public void shouldBeAbleToDeleteInsertedOrder() {
		User user=insertAUser("login", "name", "patronymic", "surname", "tel", "email", false,new Date());
		Order order=insertOrder(user,12L,2,new Date());
		order=dao.getOrderById(order.getId());
		assertNotNull(order);
		dao.deleteOrder(order);
		order=dao.getOrderById(order.getId());
		assertNull(order);
	}
	
	@Test
	public void shouldBeAbleToAddInsertedOrder() {
		User user=insertAUser("login", "name", "patronymic", "surname", "tel", "email", false,new Date());
		insertOrder(user,12L,2,new Date());
		Order order=insertOrder(user,12L,3,new Date());
		order=dao.getOrderById(order.getId());
		assertEquals(order.getPhoneQty(),5);
	}
	
	@Test
	public void shouldBeAbleToUpdateInsertedOrder() {
		User user=insertAUser("login", "name", "patronymic", "surname", "tel", "email", false,new Date());
		Order order=insertOrder(user,12L,3,new Date());
		order.setPhoneQty(1);
		order=dao.getOrderById(order.getId());
		assertEquals(order.getPhoneQty(),1);
	}
	
	@Test
	public void shouldBeAbleToFindInsertedUser() {
	    User userIn = insertAUser("login", "name", "patronymic", "surname", "tel", "email", false, new Date());
	    User userOut = dao.getUserById(userIn.getId());
	    assertEquals(userIn, userOut);
	}  
	
	@Test
	public void shouldBeAbleToFindInsertedOrders() {
	    User user = insertAUser("login", "name", "patronymic", "surname", "tel", "email", false, new Date());
	    Order order1=insertOrder(user,12L,2,new Date());
	    Order order2=insertOrder(user,3L,4,new Date());
	    List<Order> ordersIn=new ArrayList<Order>();
	    ordersIn.add(order1);ordersIn.add(order2);
	    List<Order> ordersOut=dao.getOrdersForUser(user);
	    assertEquals(ordersIn, ordersOut);
	    System.out.println(ordersIn);
	    System.out.println(ordersOut);
	}
	
	private User insertAUser(String login, String name, String patronymic, String surname, String tel, String email, boolean isAdmin, Date date) {
	    User user = new User();
	    user.setLogin(login);
	    user.setName(name);
	    user.setPatronymic(patronymic);
	    user.setSurname(surname);
	    user.setTel(tel);
	    user.setEmail(email);
	    user.setIsAdmin(isAdmin);
	    user.setDate(date);
	    assertNull(user.getId());
	    dao.addUser(user);
	    assertNotNull(user.getId());
	    return user;
	}
	
	private Order insertOrder(User user, long phoneId, int phoneQty, Date date){
		Order order=new Order();
		order.setUser(user);
		order.setPhoneId(phoneId);
		order.setPhoneQty(phoneQty);
		order.setDate(date);
		assertNull(order.getId());
		order=dao.addOrder(order);
		assertNotNull(order.getId());
		return order;
	}

}
