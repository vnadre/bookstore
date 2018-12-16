package org.brewingjava.model;

/**
 * @author Brewing Java
 *
 * class UserInfo used as 
 * model class to get user details
 * like fname, lname, user name,
 * billing, shipping and set the same
 * value
 */
public class UserInfo {
	private String fname;
	private String lname;
	private String userName;
	private String billing;
	private String shipping;
	

	/**
	 * ${UserInfo}
	 */
	public UserInfo() {
	}
	
	/**
	 * ${Parameterized constructor: AccountInfo}
	 */
	public UserInfo(String fname, String lname, String userName, String billing, String shipping) {
		this.fname = fname;
		this.lname = lname;
		this.userName = userName;
		this.billing = billing;
		this.shipping = shipping;
	}
	
	/**
	 * @return the firstname
	 */
	public String getFname() {
		return fname;
	}
	
	/**
	 * @param firstname the firstname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	/**
	 * @return the lastname
	 */
	public String getLname() {
		return lname;
	}
	
	/**
	 * @param lastname the lastname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	/**
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @return the billing address
	 */
	public String getBilling() {
		return billing;
	}
	
	/**
	 * @param billing address the billing address to set
	 */
	public void setBilling(String billing) {
		this.billing = billing;
	}
	
	/**
	 * @return the shipping address 
	 */
	public String getShipping() {
		return shipping;
	}
	
	/**
	 * @param shipping address the shipping address to set
	 */
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	
}