/**
 * @author: Brewing Java
 *
 */
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

import org.brewingjava.util.CommonsUtil;

/**
 * Controller for the  Confirm Order page. 
 *
 */
@WebServlet("/ConfirmOrder")
public class ConfirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Calls the Web service for confirming order based on Placed Order id.
	 * Renders response from the web service.  
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int poId = 0;
		String msg="";
		try {
			poId = Integer.parseInt(request.getParameter("purchaseOrderID"));
			String baseURI = CommonsUtil.getBaseUrl(request);
			Client client = ClientBuilder.newClient();
			WebTarget target = null;
			if (poId != 0) {
				target = client.target(baseURI).path("/REST/WebService/confirmOrder").queryParam("POId", poId);
				msg = target.request(MediaType.TEXT_PLAIN).get().readEntity(String.class);
			}
			else
				msg = "Error Processing your request!!!";
		} catch (NumberFormatException e) {
			if (poId == 0) {
				msg = "Error Processing your request!!!";
			}
		} 
			HttpSession mySession = request.getSession();
			mySession.removeAttribute("CartList");
			request.setAttribute("Message", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
			dispatcher.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
