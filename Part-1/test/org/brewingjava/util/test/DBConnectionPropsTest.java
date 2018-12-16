package org.brewingjava.util.test;

import static org.junit.Assert.*;

import org.brewingjava.util.DBConnectionProps;
import org.junit.Test;
/**
 * Test class DBConnection Properties
 */
public class DBConnectionPropsTest {
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/TEST";
	private static final String JDBC_PASSWORD = "admin";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private DBConnectionProps dBConnectionProps;
	
	/**
	 * Test DBConnectionProps method
	 */
	@Test
	public void DBConnPropsTest() {
		dBConnectionProps = new DBConnectionProps();
		assertEquals("Test driver name", JDBC_DRIVER, dBConnectionProps.getDriver());
		assertEquals("Test password", JDBC_PASSWORD, dBConnectionProps.getPassword());
		assertEquals("Test Url", JDBC_URL, dBConnectionProps.getUrl());
		assertEquals("Test Username", JDBC_USERNAME, dBConnectionProps.getUsername());
	}
}
