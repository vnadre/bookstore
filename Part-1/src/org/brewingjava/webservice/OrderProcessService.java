package org.brewingjava.webservice;

import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.brewingjava.model.PO;
import org.brewingjava.model.UserDetails;
import org.brewingjava.service.OrderService;
import org.brewingjava.service.OrderServiceImpl;

/**
 * @author Brewing Java
 *
 * class OrderProcessService used as 
 * Web service class to create order and get  
 * all the details with respect to
 * order and user details are also the part of 
 * value order processing service.
 * Login and register web service is also added here.
 */
@Path("/WebService")
public class OrderProcessService {

	/**
	 * ${create account web service}
	 */
	@PUT
	@Path("/createUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean createAccount(UserDetails userDetails) {
		
		OrderService os = new OrderServiceImpl();
		return os.createAccount(userDetails);
	}
	
	/**
	 * ${get account web service (login)}
	 */
	@GET
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDetails getAccount(@QueryParam("username") String username, @QueryParam("password") String password) {
		
		OrderService os = new OrderServiceImpl();
		return (os.getAccount(username, password) != null) ? os.getAccount(username, password) : null;
	}
	
	/**
	 * ${create order web service}
	 */
	@PUT
	@Path("/createOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int createOrder(PO purchaseOrder) {
		
		OrderService os = new OrderServiceImpl();
		return os.createOrder(purchaseOrder);
	}
	
	/**
	 * ${confirm order web service}
	 */
	@GET
	@Path("/confirmOrder")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String confirmOrder(@QueryParam("POId") int id) {
		OrderService os = new OrderServiceImpl();
		return os.confirmOrder(id, true);		// payement is passed as true. Set it as false in service if id is divisible by 5.
	}
	
}
