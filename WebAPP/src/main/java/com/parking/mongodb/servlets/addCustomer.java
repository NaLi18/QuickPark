package com.parking.mongodb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parking.mongodb.dao.MongoDBCustomerDAO;
import com.parking.entity.Customer;
import com.mongodb.MongoClient;
/**
 * Servlet implementation class addCustomer
 */
@WebServlet("/addCustomer")
public class addCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String DriverLicenceId = request.getParameter("DriverLicenceId");
		String DriverLicenceId1 = request.getParameter("DriverLicenceId1");
		if ( DriverLicenceId == null || "".equals(DriverLicenceId)) {
			throw new ServletException("id missing for edit operation");
		}

		String Name = request.getParameter("name");
		String Password = request.getParameter("password");
		String Password1 = request.getParameter("password1");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		if((Name == null || Name.equals(""))||(Password == null || Password.equals(""))||(Password1 == null || Password1.equals(""))||(phone==null || phone.equals(""))||(email==null|| email.contentEquals(""))){
			request.setAttribute("error", "Mandatory Parameters Missing");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/customerReg.html");
			rd.forward(request, response);
		}
		else {
			Customer c = new Customer();
			c.setDriverLicenceId(DriverLicenceId);
			c.setName(Name);
			c.setPassword(Password);
			c.setPhone(phone);
			c.setEmail(email);
			
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			MongoDBCustomerDAO customerDAO = new MongoDBCustomerDAO(mongo);
			customerDAO.createCustomer(c);
			System.out.println("Customer Added Successfully with id="+c.getDriverLicenceId());
			request.setAttribute("success", "Customer added successfully");
			List<Customer> customers = customerDAO.readAllCustomer();
			request.setAttribute("customers", customers);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/customerReg.html");
			rd.forward(request, response);
		}
	}

}
