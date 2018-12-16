package org.brewingjava.util.test;

import static org.junit.Assert.*;

import org.brewingjava.util.PasswordEncryptionService;
import org.junit.Test;
/**
 * Test class for Password Encryption Service
 */
public class PasswordEncryptionServiceTest {
	/**
	 * Test generateSecurePassword method
	 */
	@Test
	public void generateSecurePasswordTest(){
		String password= "test";
		String encryptedPass = PasswordEncryptionService.generateSecurePassword(password, PasswordEncryptionService.salt);
		assertEquals("Test Encryption", "D0Nq6BBoMlrfNFaZePRFWn0QJcJUC8c1jmerGVml1pE=", encryptedPass);	
	}

}
