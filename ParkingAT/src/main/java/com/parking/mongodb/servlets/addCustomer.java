package com.parking.mongodb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;
import com.parking.entity.Customer;
import com.parking.mongodb.dao.MongoDBCustomerDAO;


@WebServlet("/addCustomer")
public class addCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String DriverLicenceId = request.getParameter("DriverLicenceId");
		String DriverLicenceId1 = request.getParameter("DriverLicenceId1");
		String Name = request.getParameter("name");
		String Password = request.getParameter("password");
		String Password1 = request.getParameter("password1");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
//		
//		System.out.println("name:"+Name);
//		System.out.println("DriverLicenceId:"+DriverLicenceId);
//		System.out.println("DriverLicenceId1:"+DriverLicenceId1);
//		System.out.println("Password:"+Password);
//		System.out.println("Password1:"+Password1);
//		System.out.println("phone:"+phone);
//		System.out.println("email:"+email);
		
		if((Password.compareTo(Password1) !=0) || (DriverLicenceId.compareTo(DriverLicenceId1)!=0) ){
					
			System.out.println("fail");
			request.setAttribute("error", "Mandatory Parameters Missing");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerReg.html");
			rd.forward(request, response);
			
		} else {
			
			Customer c = new Customer();
			c.setDriverLicenceId(DriverLicenceId);
			c.setName(Name);
			c.setPassword(Password);
			c.setPhone(phone);
			c.setEmail(email);
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			
			MongoDBCustomerDAO CustomerDAO = new MongoDBCustomerDAO(mongo);
			CustomerDAO.createCustomer(c);
			
			System.out.println("Success");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerlogin.html");
			rd.forward(request, response);
					
		}
	}

}
