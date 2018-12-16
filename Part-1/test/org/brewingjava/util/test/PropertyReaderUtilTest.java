package org.brewingjava.util.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.brewingjava.util.PropertyReaderUtil;
import org.junit.Test;
/**
 * Test class PropertyReaderUtil
 */
public class PropertyReaderUtilTest {
	// Query IDs used to get Database query from property file
	private static final String ALL_BOOKS = "Select * from book;";
	private static final String CATEGORY_BOOKS = "Select bookid, title, price, author, category from book where category='%s';";
	private static final String FEATURED_BOOKS = "Select bookid, title, price, author, category from book where featured='%b';";
	private static final String BOOK_INFO = "Select * from book where bookid=%s;";
	private static final String SAVE_USER_INFO = "Insert into userinfo values ('%s','%s','%s','%s','%s');";
	private static final String SAVE_ACCOUNT = "Insert into AccountInfo values ('%s','%s');";
	private static final String LOGIN = "Select * from AccountInfo where username='%s';";
	private static final String USER_INFO = "Select * from userinfo where username='%s';";
	private static final String QUERIES_PROERTIES_FILE = "queries.properties";
	
	/**
	 * Test getPropertyValue method which read property file and returns Query
	 */
	@Test
	public void getPropertyValueTest() throws FileNotFoundException, IOException {
		String result = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, "ALL_BOOKS");
		assertEquals("Test All books query", ALL_BOOKS, result);
		
		result = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, "CATEGORY_BOOKS");
		assertEquals("Test Category books query", CATEGORY_BOOKS, result);
		
		result = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, "FEATURED_BOOKS");
		assertEquals("Test Featured books query", FEATURED_BOOKS, result);
		
		result = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, "BOOK_INFO");
		assertEquals("Test Book info query", BOOK_INFO, result);
		
		result = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, "SAVE_USER_INFO");
		assertEquals("Test Save user info query", SAVE_USER_INFO, result);
		
		result = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, "SAVE_ACCOUNT");
		assertEquals("Test Save account query", SAVE_ACCOUNT, result);
		
		result = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, "LOGIN");
		assertEquals("Test Save Account", LOGIN, result);
		
		result = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, "USER_INFO");
		assertEquals("Test Save Account", USER_INFO, result);
	}
}
