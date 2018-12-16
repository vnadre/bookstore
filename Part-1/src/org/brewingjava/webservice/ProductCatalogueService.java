package org.brewingjava.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.brewingjava.model.Books;
import org.brewingjava.service.ProductService;
import org.brewingjava.service.ProductServiceImpl;

/**
 * @author Brewing Java
 *
 * class ProductCatalogueService used as 
 * Web service class to get all books
 * by category and details of specific 
 * book. Featured books are part of category.
 * Book Catalogue
 */
@Path("/WebService")
public class ProductCatalogueService {
	
	/**
	 * ${get all books web service}
	 */
	@GET
	@Path("/AllBooks")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Books> getAllCategories() {
		ProductService ps = new ProductServiceImpl();
		return ps.getAllBooks();
	}

	/**
	 * ${get all books by category web service}
	 */
	@GET
	@Path("/Categories")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Books> getBookByCategory(@QueryParam("category") String category) {
		ProductService ps = new ProductServiceImpl();
		return ps.getBooksByCategory(category);
		}

	/**
	 * ${get book detail by id web service}
	 */
	@GET
	@Path("/BookInfo")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Books> getBookInfo(@QueryParam("bookId") int id, @QueryParam("event") String event) {
		ProductService ps = new ProductServiceImpl();
		return ps.getBookInfo(id,event);		//We have to handle the null value if book is not their.
	}


//Another way to hit WebService through POST method (Keep it in code)
	/*
	 * @POST
	 * 
	 * @Path("/Categories")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * getAllCategories(@QueryParam("category") String category) {
	 * System.out.println("in side "); System.out.println(category);
	 * 
	 * return Response.status(200).entity(getAllCategoriesList(category)).build(); }
	 */

}
