package org.brewingjava.util;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Class DBConnection Properties
 */
public class DBConnectionProps {

	private static final String DB_PROERTIES_FILE = "db.properties";

	private static final String DB_DRIVER_NAME = "JDBC_DRIVER";

	private static final String DB_DRIVER_URL = "JDBC_DB_URL";

	private static final String DB_USERNAME = "JDBC_USER";

	private static final String DB_PASSWORD = "JDBC_PASS";

	private String driver;

	private String url;

	private String username;

	private String password;

	/**
	 *  DBConnection Properties default constructor
	 */
	public DBConnectionProps() {

		readProperties();

	}

	/**
	 *  Method used to read properties from DB Properties file
	 */
	private void readProperties() {

		try {

			driver = PropertyReaderUtil.getInstance().getPropertyValue(DB_PROERTIES_FILE, DB_DRIVER_NAME);

			url = PropertyReaderUtil.getInstance().getPropertyValue(DB_PROERTIES_FILE, DB_DRIVER_URL);

			username = PropertyReaderUtil.getInstance().getPropertyValue(DB_PROERTIES_FILE, DB_USERNAME);

			password = PropertyReaderUtil.getInstance().getPropertyValue(DB_PROERTIES_FILE, DB_PASSWORD);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	/**
	 *  Method used to get driver
	 */
	public String getDriver() {

		return driver;

	}

	/**
	 *  Method used to set driver
	 *  @param driver
	 */
	public void setDriver(String driver) {

		this.driver = driver;

	}

	/**
	 *  Method used to get username
	 */
	public String getUsername() {

		return username;

	}

	/**
	 *  Method used to set username
	 *  @param username
	 */
	public void setUsername(String username) {

		this.username = username;

	}

	/**
	 *  Method used to get password
	 */
	public String getPassword() {

		return password;

	}

	/**
	 *  Method used to set password
	 *  @param password
	 */
	public void setPassword(String password) {

		this.password = password;

	}

	/**
	 *  Method used to get URL
	 */
	public String getUrl() {

		return url;

	}

	/**
	 *  Method used to set Url
	 *  @param url
	 */
	public void setUrl(String url) {

		this.url = url;

	}

}