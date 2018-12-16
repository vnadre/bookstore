package org.brewingjava.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.brewingjava.model.Books;
import org.brewingjava.util.DBConnection;
import org.brewingjava.util.PropertyReaderUtil;

/*
 * This class implements the method to create the Event in db 
 */
public class EventHandlerDAOImpl implements EventHandlerDAO {
	private static final String QUERIES_PROERTIES_FILE = "queries.properties";
	String QueryId = "";
	private DBConnection dbConnection;

	
	public EventHandlerDAOImpl() {
		dbConnection = DBConnection.getInstance();
	}

	/*
	 * This method saves the events and save it in the db and returns boolean value 
	 */
	public boolean createEvent(ArrayList<Books> bookIdList, String eventType) {

		Connection connection = null;
		Statement stmt = null;
		boolean value = false;
		try {
			QueryId = "CREATE_EVENT";
			connection = dbConnection.getDataSource().getConnection();
			stmt = connection.createStatement();
			for (Books book : bookIdList) {
				String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
				query = String.format(query, book.getBookid(), eventType);
				stmt.addBatch(query);
				query = "";
			}
			int rowCount[] = stmt.executeBatch();
			for (int i = 0; i < rowCount.length; i++) {
				if (rowCount[i] > 0)
					value = true;
				else
					value = false;
			}
			stmt.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

		return value;

	}
}
