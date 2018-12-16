package org.brewingjava.webservice.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

/**
 * Test class ProductCatalogueService
 */
public class ProductCatalogueServiceTest {

	private static final String BOOK_INFO = "http://localhost:8080/Part-1/REST/WebService/BookInfo?bookId=786965614";
	private static final String ALL_BOOK = "http://localhost:8080/Part-1/REST/WebService/AllBooks";
	private static final String CATEGORIES = "http://localhost:8080/Part-1/REST/WebService/Categories?category=Computers";
	
	/**
	 * Test Book info service call
	 */
	@Test
    public void bookInfoTest() throws ClientProtocolException, IOException {
		// Create HTTP Request
		HttpUriRequest request = new HttpGet( BOOK_INFO );
		// Get HTTP Response
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		// Test that the status code is 200 (Success)
		assertThat(httpResponse.getStatusLine().getStatusCode(),equalTo(HttpStatus.SC_OK));
	}
	
	/**
	 * Test all book service call
	 */
	@Test
    public void allBookTest() throws ClientProtocolException, IOException {
		// Create HTTP Request
		HttpUriRequest request = new HttpGet( ALL_BOOK );
		// Get HTTP Response
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		// Test that the status code is 200 (Success)
		assertThat(httpResponse.getStatusLine().getStatusCode(),equalTo(HttpStatus.SC_OK));
	}
	
	/**
	 * Test Get Book by category service call
	 */
	@Test
    public void categoriesTest() throws ClientProtocolException, IOException {
		// Create HTTP Request
		HttpUriRequest request = new HttpGet( CATEGORIES );
		// Get HTTP Response
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		// Test that the status code is 200 (Success)
		assertThat(httpResponse.getStatusLine().getStatusCode(),equalTo(HttpStatus.SC_OK));
	}
}
