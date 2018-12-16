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

import org.brewingjava.model.Books;

/**
 * Servlet implementation class Checkout
 * Controller for Checkout page
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 * It adds the tax to individual book price available in the list of the books in the cart, retrieved from the session.
	 * Directs to the checkout.jsp after updating the price of the books to be displayed on the page.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession mysession = request.getSession();
		List<Books> cartList = (List<Books>) mysession.getAttribute("CartList");
		boolean addTax = (boolean) mysession.getAttribute("addTax");
		float price = 0, tax = 0;
		try {
			// Adding the 13% tax
			for (Books book : cartList) {
				if (addTax) {
					price = book.getPrice();
					tax = price * (float) 0.13;
					price = tax + price;
					book.setPrice(price);
				}
			}
			addTax = false;
			// Setting the flag in session
			mysession.setAttribute("addTax", addTax);
			// Setting the updated price in session
			mysession.setAttribute("CartList", cartList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Checkout.jsp");
			dispatcher.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}