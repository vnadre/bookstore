package org.brewingjava.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.brewingjava.model.Books;
import org.brewingjava.util.DBConnection;
import org.brewingjava.util.PropertyReaderUtil;

/*
 * This class implements BookDAO interface
 */
public class BookDAOImpl implements BookDAO {

	private static final String QUERIES_PROERTIES_FILE = "queries.properties";
	String QueryId = "";

	private DBConnection dbConnection;

	public BookDAOImpl() {
		dbConnection = DBConnection.getInstance();
	}

	/*
	 * This method gets all the books for product catalog and returns the list of
	 * books
	 */
	@Override
	public ArrayList<Books> getAllBooks() {
		ArrayList<Books> allBooksList = new ArrayList<Books>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			QueryId = "ALL_BOOKS";
			connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int bookid = rs.getInt("bookid");
				String title = rs.getString("title");
				float price = rs.getFloat("price");
				String author = rs.getString("author");
				String category = rs.getString("category");

				Books cat = new Books(bookid, title, price, author, category);
				allBooksList.add(cat);
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Unable to load Driver");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle) {
					System.out.println(sqle);
					sqle.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();

				} catch (SQLException sqle) {
					System.out.println(sqle);
					sqle.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					System.out.println(sqle);
					sqle.printStackTrace();
				}
			}

		}
		return allBooksList;
	}

	/*
	 * This method gets the books based on category and returns the list of books
	 */
	@Override
	public List<Books> getBooksByCategory(String bookCategory) {

		List<Books> booksByCategory = new ArrayList<Books>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			connection = dbConnection.getDataSource().getConnection();
			if (bookCategory != "" && bookCategory.equals("featured")) {
				QueryId = "FEATURED_BOOKS";
				query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
				query = String.format(query, true);
				System.out.println(query);
			} else {
				QueryId = "CATEGORY_BOOKS";
				query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
				query = String.format(query, bookCategory);
				System.out.println(query);
			}
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			Books cat = new Books();
			if (rs != null) {
				while (rs.next()) {
					int bookid = rs.getInt("bookid");
					String title = rs.getString("title");
					float price = rs.getFloat("price");
					String author = rs.getString("author");
					String category = rs.getString("category");

					cat = new Books(bookid, title, price, author, category);
					booksByCategory.add(cat);
				}

			} else {
				String status = "No Books available";
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Unable to load Driver");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle) {
					System.out.println(sqle);
					sqle.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqle) {
					System.out.println(sqle);
					sqle.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					System.out.println(sqle);
					sqle.printStackTrace();
				}
			}
		}
		return booksByCategory;

	}

	/*
	 * This method gets book info based on book id and returns a book object
	 */
	@Override
	public Books getBookInfo(int id) {
		Books book = null;
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String QueryId = "BOOK_INFO";
			connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
			query = String.format(query, id);
			System.out.println(query);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int bookid = rs.getInt("bookid");
				String title = rs.getString("title");
				float price = rs.getFloat("price");
				String author = rs.getString("author");
				String category = rs.getString("category");
				book = new Books(bookid, title, price, author, category);
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Unable to load Driver");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle) {
					System.out.println(sqle);
					sqle.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqle) {
					System.out.println(sqle);
					sqle.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					System.out.println(sqle);
					sqle.printStackTrace();
				}
			}
		}
		return book;
	}
}
