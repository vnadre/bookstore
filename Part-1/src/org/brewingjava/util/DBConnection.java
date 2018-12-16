package org.brewingjava.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;

import org.apache.commons.dbcp.PoolableConnectionFactory;

import org.apache.commons.dbcp.PoolingDataSource;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;
/**
 * This class is used to create DB connection
 */
public class DBConnection {

	private static DBConnection dbConnectionInstance = null;

	private DBConnectionProps dbConnectionProperties = null;

	private DataSource dataSource = null;

	private static GenericObjectPool gPool = null;

	/**
	 * Default constructor
	 */
	private DBConnection() {
	}

	/**
	 * Parameterized constructor
	 * @param properties
	 */
	private DBConnection(DBConnectionProps properties) {

		dbConnectionProperties = properties;

		try {
			setDataSource(setUpPool());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to get instance of DB Connection class
	 * 
	 * @return DBConnection
	 */
	public static DBConnection getInstance() {

		if (dbConnectionInstance == null)

			dbConnectionInstance = new DBConnection(new DBConnectionProps());

		return dbConnectionInstance;

	}

	/**
	 * This method is used to set up pool
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public DataSource setUpPool() throws Exception {
		//Copied code snippet from **https://examples.javacodegeeks.com/core-java/sql/jdbc-connection-pool-example/**
		Class.forName(dbConnectionProperties.getDriver());

		// Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object
		gPool = new GenericObjectPool();

		gPool.setMaxActive(700);

		// Creates a ConnectionFactory Object Which Will Be Used by the Pool to Create the Connection Object
		ConnectionFactory cf = new DriverManagerConnectionFactory(dbConnectionProperties.getUrl(),
				dbConnectionProperties.getUsername(), dbConnectionProperties.getPassword());

		// Creates a PoolableConnectionFactory That Will Wraps the Connection Object
		// Created by the ConnectionFactory to Add Object Pooling Functionality
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);

		return new PoolingDataSource((ObjectPool) gPool);

	}

	/**
	 * Getter method for DataSource
	 * 
	 * @return DataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * Setter method for DataSource
	 * 
	 * @param dataSource
	 */
	private void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}