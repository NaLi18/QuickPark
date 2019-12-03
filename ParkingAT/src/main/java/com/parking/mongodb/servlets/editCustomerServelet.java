package com.parking.mongodb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.MongoClient;
import com.parking.entity.Customer;
import com.parking.mongodb.dao.MongoDBCustomerDAO;

/**
 * Servlet implementation class editCustomerServelet
 */
@WebServlet("/editCustomer")
public class editCustomerServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCustomerServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String name = request.getParameter("name");
		String DriverLicenceId = (String) session.getAttribute("id");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String Password = request.getParameter("password");
		String Password1 = request.getParameter("password1");
		System.out.println(DriverLicenceId);
		if((Password.compareTo(Password1) !=0)){
			
			System.out.println("fail");
			request.setAttribute("error", "Mandatory Parameters not same");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerProfileElement/personinfo.jsp");
			rd.forward(request, response);
			
		} else {
			Customer c = new Customer();
			
			c.setName(name);
			c.setPassword(Password);
			c.setPhone(phone);
			c.setEmail(email);
			c.setDriverLicenceId(DriverLicenceId);
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			
			MongoDBCustomerDAO CustomerDAO = new MongoDBCustomerDAO(mongo);
			CustomerDAO.updateCustomer(c);	
			c = CustomerDAO.updateCustomer(c);
			boolean Refresh = true;
			session.setAttribute("customer", c);
			//session.setAttribute("Refesh",Refresh);
			System.out.println("Success");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerProfileElement/personinfo.html");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
