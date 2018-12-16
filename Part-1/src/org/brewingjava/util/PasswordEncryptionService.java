package org.brewingjava.util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

/**
 * This class is used to encrypt password
 * Class has been referenced from http://www.appsdeveloperblog.com/encrypt-user-password-example-java/
 */
public class PasswordEncryptionService {

	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;
	public static final String salt = "Tn4BTBAX";
	/**
	 * Method is used to get Hash
	 * 
	 * @param password
	 * @param salt
	 * @return byte[] hash
	 */
	public static byte[] hash(char[] password, byte[] salt) {
		PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
		Arrays.fill(password, Character.MIN_VALUE);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
	}
	/**
	 * This method is used to generate secure password
	 * 
	 * @param password
	 * @param salt
	 * @return encrypted password
	 */
	public static String generateSecurePassword(String password, String salt) {
		String returnValue = null;
		byte[] securePassword = hash(password.toCharArray(), salt.getBytes());

		returnValue = Base64.getEncoder().encodeToString(securePassword);

		return returnValue;
	}

	/**
	 * This method is used to verify given user password
	 * 
	 * @param providedPassword
	 * @param securedPassword
	 * @param salt
	 * @return boolean value
	 */
	public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {
		boolean returnValue = false;

		// Generate New secure password with the same salt
		String newSecurePassword = generateSecurePassword(providedPassword, salt);

		// Check if two passwords are equal
		returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);

		return returnValue;
	}
}