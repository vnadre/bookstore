package org.brewingjava.dao;

import org.brewingjava.model.PO;

/*
 * This interface provides methods for creating and confirming the order
 */
public interface OrderDAO {

	public int createOrder(PO orderDetails);

	public boolean confirmOrder(int id, boolean payement);

}
