package org.brewingjava.dao;

import org.brewingjava.model.UserDetails;

/*
 * This interface provides methods for creating and fetching account info of user
 */
public interface AccountInfoDAO {

	public boolean createAccount(UserDetails userDetails);

	public UserDetails getAccount(String username, String password);
}
