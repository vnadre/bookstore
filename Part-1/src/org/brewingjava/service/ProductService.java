package org.brewingjava.service;

import java.util.ArrayList;
import java.util.List;

import org.brewingjava.model.Books;

/*
 * This interface provides method to get book info
 */
public interface ProductService {

	public ArrayList<Books> getAllBooks();

	public List<Books> getBooksByCategory(String category);

	public ArrayList<Books> getBookInfo(int id, String event);

}
