package org.brewingjava.controller;

import java.io.IOException;
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
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.brewingjava.model.Books;
import org.brewingjava.model.PO;
import org.brewingjava.model.UserDetails;
import org.brewingjava.util.CommonsUtil;

/**
 * Servlet implementation class CreateOrder
 * 
 * Controller for creating the order. 
 */
@WebServlet("/CreateOrder")
public class CreateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *  Calls the Create Order web service that passes the information of the user and the books ordered by the user.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession mysession = request.getSession();
		// Fetching the data from session
		List<Books> cartList = (List<Books>) mysession.getAttribute("CartList");
		List<UserDetails> userDetailList = (List<UserDetails>) mysession.getAttribute("UserDetails");
		String accountName = null;

		PO purchaseOrder = new PO();
		for (UserDetails details : userDetailList) {
			accountName = details.accountInfo.getUsername();
		}

		purchaseOrder.setUsername(accountName);
		purchaseOrder.setCartInfo(cartList);

		String baseURI = CommonsUtil.getBaseUrl(request);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(baseURI).path("/REST/WebService/createOrder");
		int purchaseOrderID = Integer.parseInt(target.request(MediaType.TEXT_PLAIN).put(Entity.json(purchaseOrder), String.class));

		if (purchaseOrderID != 0) {
			request.setAttribute("purchaseOrderID", purchaseOrderID);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmOrder.jsp");
			dispatcher.include(request, response);
		} else {

			mysession.removeAttribute("CartList");
			String msg = "Unable to process your order.";
			request.setAttribute("Message", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
			dispatcher.include(request, response);
		}

	}

}
