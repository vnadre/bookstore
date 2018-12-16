package org.brewingjava.dao;

import java.util.ArrayList;
import java.util.List;

import org.brewingjava.model.Books;

/*
 * This interface provides methods for getting book info from book table
 */
public abstract interface BookDAO {

	public ArrayList<Books> getAllBooks();

	public List<Books> getBooksByCategory(String category);

	public Books getBookInfo(int id);

}
