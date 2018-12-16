package org.brewingjava.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brewing Java
 *
 * class PO used as 
 * model class to get purchase 
 * order details where we have 
 * array list of cart and username
 */
public class PO {

	String username;
	List<Books> cartInfo = new ArrayList<Books>();
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the cartInfo
	 */
	public List<Books> getCartInfo() {
		return cartInfo;
	}
	
	/**
	 * @param cartInfo the cartInfo to set
	 */
	public void setCartInfo(List<Books> cartInfo) {
		this.cartInfo = cartInfo;
	}
	
	
}
