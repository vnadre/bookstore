package org.brewingjava.model;

/**
 * @author Brewing Java
 *
 * class AccountInfo used as 
 * model class to get user name 
 * and get password and set the same
 * value
 */

public class AccountInfo {

	private String username;
	private String password;
	
	/**
	 * ${Parameterized constructor: AccountInfo}
	 */
	public AccountInfo(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * ${AccountInfo}
	 */
	public AccountInfo() {
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}