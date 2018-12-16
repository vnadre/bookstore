package org.brewingjava.service;

import java.util.ArrayList;
import java.util.List;

import org.brewingjava.dao.BookDAO;
import org.brewingjava.dao.BookDAOImpl;
import org.brewingjava.dao.EventHandlerDAO;
import org.brewingjava.dao.EventHandlerDAOImpl;
import org.brewingjava.model.Books;

/*
 * This class implements the methods from ProductService DAO
 */
public class ProductServiceImpl implements ProductService {

	/*
	 * This method calls the method in DAO to get the booklist and returns an
	 * Arraylist
	 */
	@Override
	public ArrayList<Books> getAllBooks() {

		ArrayList<Books> bookList = new ArrayList<Books>();
		BookDAO dao = new BookDAOImpl();
		bookList = dao.getAllBooks();
		return bookList;
	}

	/*
	 * This method calls the method in DAO to get the books by category and returns
	 * the list of book type
	 */
	@Override
	public List<Books> getBooksByCategory(String category) {

		List<Books> bookList = new ArrayList<Books>();
		BookDAO dao = new BookDAOImpl();
		bookList = dao.getBooksByCategory(category);
		return bookList;
	}

	/*
	 * This method calls the method in DAO to get the book info and silently adds
	 * the book event in the db
	 */
	@Override
	public ArrayList<Books> getBookInfo(int id, String event) {

		ArrayList<Books> bookList = new ArrayList<Books>();
		ArrayList<Books> bookEventList = new ArrayList<Books>();
		Books eventBook = new Books();
		eventBook.setBookid(id);
		bookEventList.add(eventBook);
		EventHandlerDAO eventDao = new EventHandlerDAOImpl();
		eventDao.createEvent(bookEventList, event);
		BookDAO dao = new BookDAOImpl();
		Books book = dao.getBookInfo(id);
		bookList.add(book);
		return bookList;
	}
}
