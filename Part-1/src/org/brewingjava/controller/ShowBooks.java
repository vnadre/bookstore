package org.brewingjava.controller;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import org.brewingjava.model.Books;
import org.brewingjava.util.CommonsUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class ShowDetails
 * Controller for fetching the data of books according to category selected by the user and displaying it on the page.
 */
@WebServlet("/ShowBooks")
public class ShowBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      
	 * Calls the web service for fetching the data according to the category. 
	 * Renders the JSON response and present the data on the Homepage.jsp.     
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category = request.getParameter("category");
		HttpSession mysession = request.getSession();
		mysession.setAttribute("category", category);
		//String baseURI = "http://localhost:8080/Part-1";
		String baseURI = CommonsUtil.getBaseUrl(request);
		Client client = ClientBuilder.newClient();
		WebTarget target = null;
		if (category.equals("All")) {
		 target = client.target(baseURI).path("/REST/WebService/AllBooks");
		}
		else {
		 target = client.target(baseURI).path("/REST/WebService/Categories").queryParam("category", category);
		}
		String result = target.request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
		List<Books> allBooksList = new ArrayList<Books>();
		try {
			JSONArray jsonArr = new JSONArray(result);
			for (int i = 0; i < jsonArr.length(); i++) {
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				Books bookVo = new Books();
				bookVo.setAuthor(jsonObj.getString("author"));
				bookVo.setBookid(jsonObj.getInt("bookid"));
				bookVo.setCategory(jsonObj.getString("category"));
				bookVo.setPrice(jsonObj.getLong("price"));
				bookVo.setTitle(jsonObj.getString("title"));
				allBooksList.add(bookVo);
			}

			request.setAttribute("allBook", allBooksList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
			dispatcher.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	/*private static void disableSslVerification() {
	    try
	    {
	        // Create a trust manager that does not validate certificate chains
	        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
	            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }
	            public void checkClientTrusted(X509Certificate[] certs, String authType) {
	            }
	            public void checkServerTrusted(X509Certificate[] certs, String authType) {
	            }
	        }
	        };

	        // Install the all-trusting trust manager
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	        // Create all-trusting host name verifier
	        HostnameVerifier allHostsValid = new HostnameVerifier() {
	            public boolean verify(String hostname, SSLSession session) {
	                return true;
	            }
	        };

	        // Install the all-trusting host verifier
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (KeyManagementException e) {
	        e.printStackTrace();
	    }
	}*/
}
