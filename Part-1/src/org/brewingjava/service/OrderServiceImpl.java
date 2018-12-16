package org.brewingjava.service;

import org.brewingjava.dao.AccountInfoDAO;
import org.brewingjava.dao.AccountInfoDAOImpl;
import org.brewingjava.dao.OrderDAO;
import org.brewingjava.dao.OrderDAOImpl;
import org.brewingjava.model.PO;
import org.brewingjava.model.UserDetails;

/*
 * This class implements the methods from OrderService DAO
 */
public class OrderServiceImpl implements OrderService {

	/*
	 * This method calls the method in DAO
	 */
	@Override
	public boolean createAccount(UserDetails userDetails) {

		AccountInfoDAO dao = new AccountInfoDAOImpl();
		return dao.createAccount(userDetails);
	}

	/*
	 * This method calls the method in DAO and checks the username and password. If
	 * the username does not match it returns null
	 */
	@Override
	public UserDetails getAccount(String username, String password) {

		AccountInfoDAO dao = new AccountInfoDAOImpl();
		UserDetails userDetails = new UserDetails();
		userDetails = dao.getAccount(username, password);
		if (username.equals(userDetails.accountInfo.getUsername())
				&& password.equals(userDetails.accountInfo.getPassword())) {
			return userDetails;
		} else {
			return null;
		}
	}

	/*
	 * This method calls the method in DAO
	 */
	@Override
	public int createOrder(PO purchaseOrder) {
		OrderDAO dao = new OrderDAOImpl();
		return dao.createOrder(purchaseOrder);
	}

	/*
	 * This method checks the 5th order to deny it and setting the payment flag. It
	 * returns the result string based on the check
	 */
	@Override
	public String confirmOrder(int id, boolean payement) {
		if (id % 5 == 0) {
			payement = false;
		}
		OrderDAO dao = new OrderDAOImpl();
		boolean result = dao.confirmOrder(id, payement);
		String resultingStmt;
		if (result)
			resultingStmt = "Thanks for shopping with us. Your Order is Confirmed";
		else
			resultingStmt = "We are sorry , Your Order is Denied";
		return resultingStmt;
	}
}
