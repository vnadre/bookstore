package org.brewingjava.dao.test;

import static org.junit.Assert.*;

import org.brewingjava.dao.AccountInfoDAOImpl;
import org.brewingjava.model.UserDetails;
import org.junit.Test;
/**
 * Test class for Account Info DAO implementation
 */
public class AccountInfoDAOImplTest {
	private static final String ADDRESS = "Paris";
	private static final String LAST_NAME = "Lincon";
	private static final String FIRST_NAME = "John";
	private static final String ENCRYPTED_PASSWORD = "vHCMwtolmbF15owqKaq4HsF1ZQUnhmD2YvUkanCf+jo=";
	private static final String JOHN123 = "john123";
	private AccountInfoDAOImpl dao;
	
	/**
	 * Test createAccount method
	 */
	@Test
	public void createAccountTest() {
		dao = new AccountInfoDAOImpl();
		assertFalse("Create account should return false for null values", 
				dao.createAccount(null));
	}
	
	/**
	 * Test getAccount method
	 */
	@Test
	public void getAccountTest() {
		dao = new AccountInfoDAOImpl();
		String username = JOHN123;
		String password = JOHN123;
		// Get account details
		UserDetails details = dao.getAccount(username, password);
		// Test not null
		assertNotNull(details);
		// Test username, encrypted password, first name, last name. shipping and billing address
		assertEquals(username, details.getAccountInfo().getUsername());
		assertEquals(ENCRYPTED_PASSWORD, details.getAccountInfo().getPassword());
		assertEquals(FIRST_NAME, details.getUserInfo().getFname());
		assertEquals(LAST_NAME, details.getUserInfo().getLname());
		assertEquals(ADDRESS, details.getUserInfo().getShipping());
		assertEquals(ADDRESS, details.getUserInfo().getBilling());
	}
}
