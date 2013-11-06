package by.itm.webshop.persistence;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.dataset.IDataSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import by.itm.webshop.domain.Order;
import by.itm.webshop.domain.User;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:persistence-context.xml",
		"classpath:test-dataSource-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:data/data.xml")
public class JpaUserDaoTest {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private UserDao userDao;
	
	private static User user;

	/*
	 * @Autowired private DataSource dataSource;
	 */

	@Autowired
	private DatabaseDataSourceConnection dbUnitDatabaseConnection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user=new User();
		user.setLogin("bob");
		user.setPassword("bob");
		user.setName("bob");
		user=userDao.getUserById(1L);
	}

	@After
	public void tearDown() throws Exception {
	}

	/*@Test
	public void testInformationSchemaDbunit() throws Exception {

		System.out.println(dbUnitDatabaseConnection.getSchema());
		IDataSet dataSet = dbUnitDatabaseConnection.createDataSet();
		for (String s : dataSet.getTableNames()) {
			System.out.println(s);
		}
	}*/

	@Test
	public void testGetOrdersForUser() {
		Order order1=new Order();
		order1.setUser(user);
		order1.setPhoneId(111111L);
		order1.setQty(1);
		Order order2=new Order();
		order2.setUser(user);
		order2.setPhoneId(222222L);
		order2.setQty(3);
		List<Order> ordersExpected=Arrays.asList(order1,order2);
		List<Order> ordersActual=orderDao.getOrdersForUser(user);
		assertEquals(ordersExpected, ordersActual);
	}

	@Test
	public void testGetOrderForUserByPhoneId() {
		fail("Not yet implemented");
	}

	@Test
	@ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT, value = "classpath:data/AddOrder.xml")
	public void testAddOrder() {
		user=userDao.getUserById(1L);
		Order order=new Order();
		order.setUser(user);
		order.setPhoneId(333333L);
		order.setQty(3);
		orderDao.addOrder(order);
	}

	@Test
	public void testUpdateOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrderById() {
		fail("Not yet implemented");
	}

}
