package org.brewingjava.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

import org.brewingjava.model.AccountInfo;
import org.brewingjava.model.UserDetails;
import org.brewingjava.model.UserInfo;
import org.brewingjava.util.CommonsUtil;
import org.brewingjava.util.PasswordEncryptionService;
import org.json.JSONObject;

/**
 * Servlet implementation class Login
 * 
 * Controller for Login functionality.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      
	 * Method fetches the password from the request and encrypts it.
	 * Calls the login web service that takes the username and encrypted password. Web service matches the attribute with that of stored in database and
	 * returns empty if information is not matched, otherwise account information of the user is returned.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String epass = null;
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		HttpSession mySession = request.getSession();
		try {
			epass = PasswordEncryptionService.generateSecurePassword(pass, PasswordEncryptionService.salt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String baseURI = CommonsUtil.getBaseUrl(request);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(baseURI).path("/REST/WebService/login").queryParam("username", name).queryParam("password", epass);
		String result = target.request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
		if (!result.equals("")) {
			List<UserDetails> userDetailList = new ArrayList<UserDetails>();
			UserDetails userDetails;
			AccountInfo accountInfo = new AccountInfo();
			UserInfo userInfo = new UserInfo();
			try {
				// Use JSON Object
				JSONObject jsonObj = new JSONObject(result);
				// Set values in user details object 
				String userName = jsonObj.getJSONObject("accountInfo").get("username").toString();
				String fname = jsonObj.getJSONObject("userInfo").get("fname").toString();
				String lname = jsonObj.getJSONObject("userInfo").get("lname").toString();
				String billing = jsonObj.getJSONObject("userInfo").get("billing").toString();
				String shipping = jsonObj.getJSONObject("userInfo").get("shipping").toString();
				
				accountInfo.setUsername(userName);
				mySession.setAttribute("userName", userName);
				userInfo.setFname(fname);
				userInfo.setLname(lname);
				userInfo.setBilling(billing);
				userInfo.setShipping(shipping);
				
				userDetails = new UserDetails(accountInfo, userInfo);
				userDetailList.add(userDetails);
				mySession.setAttribute("UserDetails", userDetailList);
				response.sendRedirect("/Part-1-0.0.1-SNAPSHOT/Checkout");
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/Checkout");
				//dispatcher.include(request, response);
			}catch (Exception e) {
				e.printStackTrace();
				}
		} else {
			String error = "Invalid Username or Password!";
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.include(request, response);
		}
	}
}