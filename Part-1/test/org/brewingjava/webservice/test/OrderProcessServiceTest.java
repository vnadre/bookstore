package org.brewingjava.webservice.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Test class OrderProcessService
 */
public class OrderProcessServiceTest {

	private static final String LOGIN_SERVICE = "http://localhost:8080/Part-1/REST/WebService/login?username=varun&password=zqks98quCcJGcoZIewCV8UGE+usvZeQyDcd8xh1C/K8=";
	private static final String CONFIRM_ORDER_SERVICE = "http://localhost:8080/Part-1/REST/WebService/confirmOrder?POId=1";
	
	/**
	 * Test login service call
	 */
	@Test
    public void loginServiceTest() throws ClientProtocolException, IOException {
		// Create HTTP Request
		HttpUriRequest request = new HttpGet( LOGIN_SERVICE );
		// Get HTTP Response
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		// Test that the status code is 200 (Success)
		assertThat(httpResponse.getStatusLine().getStatusCode(),equalTo(HttpStatus.SC_OK));
	}
	
	/**
	 * Test confirm order service call
	 */
	@Test
    public void confirmOrderServiceTest() throws ClientProtocolException, IOException {
		// Create HTTP Request
		HttpUriRequest request = new HttpGet( CONFIRM_ORDER_SERVICE );
		// Get HTTP Response
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		// Test that the status code is 200 (Success)
		assertThat(httpResponse.getStatusLine().getStatusCode(),equalTo(HttpStatus.SC_OK));
	}
}
