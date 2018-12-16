/**
 * @author : BrewingJava
 *
 */
package org.brewingjava.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.brewingjava.model.Books;

/**
 * Servlet implementation class AddItemsToCart
 * 
 * Controller for the Adding items to the cart. 
 */
@WebServlet("/AddItemsToCart")
public class AddItemsToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	/**
	 * Method retrieves the id of the book to be added to the cart and updates the list of books that is already added to the cart in the session.
	 * Then directs the page to the same page user was viewing.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession mysession = request.getSession();
		String category = (String)mysession.getAttribute("category");
		ArrayList idList = mysession.getAttribute("idList")!=null ? (ArrayList) mysession.getAttribute("idList") : new ArrayList();	//retrieve List of ids from session otherwise create new arraylist if not available.
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		if(bookId != 0) {
			Books book = new Books();
			book.setBookid(bookId);
			idList.add(book);
			String msg= "Book added successfully to cart";
			mysession.setAttribute("idList", idList);
			mysession.setAttribute("displayMsg", msg);
			response.sendRedirect("ShowBooks?category="+category);
			
		}
	}

}
