package org.brewingjava.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.brewingjava.dao.BookDAOImpl;
import org.brewingjava.model.Books;
import org.junit.Assert;
import org.junit.Test;
/**
 * Test class for Book DAO implementation
 */
public class BookDAOImplTest {
	private static final String BOOK_TITLE = "CLEAN CODE: A HANDBOOK OF AGILE SOFTWARE CRAFTSMANSHIP";
	private static final float BOOK_PRICE = 1599.0f;
	private static final String BOOK_CATEGORY = "Computers";
	private static final String BOOK_AUTHOR = "Robert C. Martin";
	private static final int BOOK_ID = 132350882;
	private BookDAOImpl dao;

	/**
	 * Test getAllBooks method
	 */
	@Test
	public void getAllBooksTest() {
		dao = new BookDAOImpl();
		ArrayList<Books> list = dao.getAllBooks();
		// Test list is not null
		assertNotNull(list);
		// list has 6 values
		assertEquals(6, list.size());
		// Test first Book element id, author, category, price and title
		assertEquals(BOOK_ID, list.get(0).getBookid());
		assertEquals(BOOK_AUTHOR, list.get(0).getAuthor());
		assertEquals(BOOK_CATEGORY, list.get(0).getCategory());
		Assert.assertEquals(BOOK_PRICE, list.get(0).getPrice(), 0.0002);
		assertEquals(BOOK_TITLE, list.get(0).getTitle());
	}
	
	/**
	 * Test getBooksByCategory method
	 */
	@Test
	public void getBooksByCategoryTest() {
		dao = new BookDAOImpl();
		List<Books> list = dao.getBooksByCategory(BOOK_CATEGORY);
		// Test list is not null
		assertNotNull(list);
		// list has 2 values
		assertEquals(2, list.size());
		// Test first Book element id, author, category, price and title
		assertEquals(BOOK_ID, list.get(0).getBookid());
		assertEquals(BOOK_AUTHOR, list.get(0).getAuthor());
		assertEquals(BOOK_CATEGORY, list.get(0).getCategory());
		Assert.assertEquals(BOOK_PRICE, list.get(0).getPrice(), 0.0002);
		assertEquals(BOOK_TITLE, list.get(0).getTitle());
	}
	
	/**
	 * Test getBookInfo method
	 */
	@Test
	public void getBookInfoTest() {
		dao = new BookDAOImpl();
		Books book = dao.getBookInfo(BOOK_ID);
		// Book object is not null
		assertNotNull(book);
		// Test Book id, author, category, price and title
		assertEquals(BOOK_ID, book.getBookid());
		assertEquals(BOOK_AUTHOR, book.getAuthor());
		assertEquals(BOOK_CATEGORY, book.getCategory());
		Assert.assertEquals(BOOK_PRICE, book.getPrice(), 0.0002);
		assertEquals(BOOK_TITLE, book.getTitle());
	}
}
