package org.brewingjava.model;

/**
 * @author Brewing Java
 *
 * class UserDetails used as 
 * model class to get account info 
 * and user info and set the same
 * value
 */
public class UserDetails {
	public AccountInfo accountInfo;
	public UserInfo userInfo;
	
	/**
	 * ${UserDetails}
	 */
	public UserDetails() {
	}
	
	/**
	 * ${Parameterized constructor: AccountInfo}
	 */
	public UserDetails(AccountInfo accountInfo, UserInfo userInfo) {
		this.accountInfo = accountInfo;
		this.userInfo = userInfo;
	}

	/**
	 * @return the accountInfo
	 */
	public AccountInfo getAccountInfo() {
		return accountInfo;
	}
	
	/**
	 * @param accountInfo the accountInfo to set
	 */
	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}	
}