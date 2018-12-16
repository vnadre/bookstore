package org.brewingjava.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.brewingjava.dao.OrderDAOImpl;
import org.brewingjava.model.PO;
import org.junit.Test;

public class OrderDAOImplTest {

	private static final int id = 1;
	private OrderDAOImpl dao;
	private PO po;

	// Create order test
	@Test
	public void createOrderTest() {

		dao = new OrderDAOImpl();
		assertEquals("The purchase order id should be zero", 0, dao.createOrder(po));

	}

	// Confirm order test
	@Test
	public void confirmOrderTest() {

		dao = new OrderDAOImpl();
		assertTrue("Confirm order should return true if payment flag is true", dao.confirmOrder(id, true));
		assertTrue("Confirm order should return true if payment flag is false", dao.confirmOrder(id, false));
	}
}