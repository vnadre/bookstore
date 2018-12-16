package org.brewingjava.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class is used to read properties from DB property and Queries property file
 */
public class PropertyReaderUtil {

	private static boolean debugOnOff = false;

	private static PropertyReaderUtil instance;
	
	/**
	 * Default constructor
	 */
	private PropertyReaderUtil() {
	}

	/**
	 * Method is used to get instance of a class
	 */
	public static PropertyReaderUtil getInstance() {

		if (instance == null)

			instance = new PropertyReaderUtil();

		return instance;

	}

	/**
	 * This method is used to get requested property value
	 * 
	 * @param propertiesFile
	 * @param propertyKey
	 * @return requested property value
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getPropertyValue(String propertiesFile, String propertyKey)
			throws FileNotFoundException, IOException {

		Properties prop = new Properties();

		String value = "";
		String path = "";
		// check file exists
		//make changes in your system with your own path
		if (propertiesFile.equalsIgnoreCase("db.properties")) {
			System.out.println("inside reading property file");
			//path = "C:\\Users\\Hp\\git\\BrewingJava\\Part-1\\WebContent\\resources\\db.properties";
			path = "./resources/db.properties";
		} else if (propertiesFile.equalsIgnoreCase("queries.properties")) {
			//path = "C:\\Users\\Hp\\git\\BrewingJava\\Part-1\\WebContent\\resources\\queries.properties";
			path = "./resources/queries.properties";
		}

		System.out.println("file is here" + new File(".").getAbsoluteFile());
		try (FileInputStream fis = new FileInputStream(path)) {

			try {
				System.out.println("got the file");
				prop.load(fis);

				value = prop.getProperty(propertyKey);

				debugOnOff = Boolean.valueOf(prop.getProperty("DEBUG"));

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		//debug works as logger so use it to save your time
		//Make an entry in DB.properties file for debug
		if (debugOnOff) {

			System.out.println(String.format("Key : %s ; Value : %s", propertyKey, value));

		}

		return value;

	}

}