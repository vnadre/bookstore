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

import org.brewingjava.model.Books;
import org.brewingjava.util.CommonsUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class ShoppingCart
 * 
 * Controller for the Shopping Cart.
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Calls the BookInfo web service to fetch the book details for each id of the book passed in the list. 
     * Creates the list of all the books to be passed on to the shoppingcart.jsp to present it on the page. 
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String baseURI = CommonsUtil.getBaseUrl(request);
		Client client = ClientBuilder.newClient();
		HttpSession session = request.getSession();
		ArrayList<Books> idList = new ArrayList<Books>();
		if(session.getAttribute("idList")!=null) {
			idList = (ArrayList<Books>) session.getAttribute("idList");
			session.removeAttribute("idList");
		}
		WebTarget target;
		String result;
		List<Books> allBooksList = new ArrayList<Books>();
		boolean addTax = true;
		try {
			for(int j=0;j<idList.size();j++) {
				target = client.target(baseURI).path("/REST/WebService/BookInfo").queryParam("bookId", idList.get(j).getBookid()).queryParam("event", "CART");
				result = target.request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
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
			}
			List<Books> CartList =  session.getAttribute("CartList")!=null ? (ArrayList<Books>)session.getAttribute("CartList") : new ArrayList<Books>();
			for(Books book:allBooksList) {
				CartList.add(book);
			}
			session.setAttribute("CartList", CartList);
			session.setAttribute("addTax", addTax);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ShoppingCart.jsp");
			dispatcher.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}

}