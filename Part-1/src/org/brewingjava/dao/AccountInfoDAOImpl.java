package org.brewingjava.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.brewingjava.model.AccountInfo;
import org.brewingjava.model.UserDetails;
import org.brewingjava.model.UserInfo;
import org.brewingjava.util.DBConnection;
import org.brewingjava.util.PropertyReaderUtil;

/*
 * This class implements AccountInfoDAO interface
 */
public class AccountInfoDAOImpl implements AccountInfoDAO {

	private static final String QUERIES_PROERTIES_FILE = "queries.properties";
	private DBConnection dbConnection;

	public AccountInfoDAOImpl() {
		dbConnection = DBConnection.getInstance();
	}

	/*
	 * This method creates a new user and saves it to the db
	 */
	@Override
	public boolean createAccount(UserDetails userDetails) {

		String QueryId = "";
		Statement stmt = null;
		Connection connection = null;
		boolean hasError = true;
		try {
			QueryId = "SAVE_ACCOUNT";
			connection = dbConnection.getDataSource().getConnection();
			String registerQuery = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
			// Formating the query with the data to be saved
			registerQuery = String.format(registerQuery, userDetails.accountInfo.getUsername(),
					userDetails.accountInfo.getPassword());
			stmt = connection.createStatement();
			// Returns 1 if data is inserted
			int result = stmt.executeUpdate(registerQuery);
			// If the result is 1, execute the second the query
			if (result == 1) {
				registerQuery = "";
				QueryId = "SAVE_USER_INFO";
				registerQuery = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
				// Formating the query with the data to be saved
				registerQuery = String.format(registerQuery, userDetails.userInfo.getFname(),
						userDetails.userInfo.getLname(), userDetails.userInfo.getUserName(),
						userDetails.userInfo.getShipping(), userDetails.userInfo.getBilling());
				int finalResult = stmt.executeUpdate(registerQuery);
				// If second query is executed set flag false
				if (finalResult == 1)
					hasError = false;
			} else
				hasError = true;
		} catch (Exception e) {
			System.out.println("Some Error occurred while saving user credentials in DAO");
			e.printStackTrace();
			hasError = true;
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
		return (!hasError) ? true : false;
	}

	/*
	 * This method fetch the data during login
	 */
	@Override
	public UserDetails getAccount(String username, String password) {
		UserDetails usereDetails;
		UserInfo userInfo = new UserInfo();
		AccountInfo accountInfo = new AccountInfo();
		String QueryId = "";
		ResultSet rs = null;
		Statement stmt = null;
		Connection connection = null;
		try {
			// Executing query for login info
			QueryId = "LOGIN";
			connection = dbConnection.getDataSource().getConnection();
			String query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
			// Formating the query with the data to be saved
			query = String.format(query, username);
			stmt = connection.createStatement();
			// Fetching all the login data for the user
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String user = rs.getString("username");
				String pass = rs.getString("password");
				accountInfo.setUsername(user);
				accountInfo.setPassword(pass);
			}
			rs.close();
			// Executing the other query for user info if above query is success
			if (!accountInfo.getUsername().isEmpty()) {
				query = "";
				QueryId = "USER_INFO";
				query = PropertyReaderUtil.getInstance().getPropertyValue(QUERIES_PROERTIES_FILE, QueryId);
				// Formating the query with the username
				query = String.format(query, username);
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					userInfo.setFname(rs.getString("fname"));
					userInfo.setLname(rs.getString("lname"));
					userInfo.setShipping(rs.getString("shippingaddress"));
					userInfo.setBilling(rs.getString("billingaddress"));
				}

			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Some Error occurred in DAO!");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		}
		usereDetails = new UserDetails(accountInfo, userInfo);
		return usereDetails;
	}
}