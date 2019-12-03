package com.parking.mongodb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginedCheckInterceptorAction
 */
public class LoginedCheckInterceptorAction implements Filter {

    /**
     * Default constructor. 
     */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
    public LoginedCheckInterceptorAction() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
		
		//get users' request URL
		String path = servletRequest.getRequestURI();
		
		if(path.contains("login") || path.contains("home"))
		{
			chain.doFilter(request, servletResponse);
			System.out.println("1");
		}
		else {
			Object obj = session.getAttribute("customer");
			//haven't login
			if(null==obj)
			{
				servletResponse.sendRedirect("homepage.jsp");
				System.out.println("2");
			}
			else
			{
				System.out.println("3");
				//login
				chain.doFilter(request, response);
				
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
