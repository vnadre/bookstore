package org.brewingjava.util.test;

import static org.junit.Assert.*;

import org.brewingjava.util.DBConnection;
import org.junit.Test;
/**
 * Test class DBConnection
 */
public class DBConnectionTest {
	
	/**
	 * Test getInstance method
	 */
	@Test
	public void getInstanceTest() {
		assertNotNull(DBConnection.getInstance());
	}
	
}
