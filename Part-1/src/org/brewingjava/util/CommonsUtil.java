package org.brewingjava.util;

import javax.servlet.http.HttpServletRequest;

public class CommonsUtil {
	
	public static String getBaseUrl(HttpServletRequest request) {
		String baseUrl = request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length()) + request.getContextPath();
		return baseUrl.replaceAll("https", "http").replaceAll("8443", "8080");
	}

}
