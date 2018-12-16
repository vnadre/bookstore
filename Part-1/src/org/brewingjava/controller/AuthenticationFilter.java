package org.brewingjava.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.brewingjava.model.AccountInfo;
import org.brewingjava.model.UserDetails;

/**
 * Servlet Filter implementation class AuthenticationFilter
 * Servlet Filter to prevent non-logged in user to checkout.
 */
@WebFilter("/Checkout")
public class AuthenticationFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * 
	 * Servlet filter is applied over checkout page. 
	 * Checks and allow whether user is Logged in or not.
	 * Logged in user then allowed to move on to Checkout feature.
	 * Guests are redirected to Login.jsp to login into their account.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession mySession = req.getSession();
		try {
			@SuppressWarnings("unchecked")
			List<UserDetails> userDetails = (ArrayList<UserDetails>) mySession.getAttribute("UserDetails");
			if (userDetails != null) {
				ArrayList checkCartList = (ArrayList) mySession.getAttribute("CartList");
				if (checkCartList.size() != 0) {				
					chain.doFilter(request, response);
				} else {
					resp.sendRedirect("Welcome.jsp");
				}
			} else {
				resp.sendRedirect("Login.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
