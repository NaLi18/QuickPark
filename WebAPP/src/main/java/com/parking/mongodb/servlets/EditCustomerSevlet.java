package com.parking.mongodb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import com.parking.mongodb.dao.MongoDBCustomerDAO;
import com.parking.entity.Customer;
import com.mongodb.MongoClient;
/**
 * Servlet implementation class EditCustomerSevlet
 */
@WebServlet("/editCustomer")
public class EditCustomerSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("DriverLicenceId");
		if (id == null || "".equals(id)) {
			throw new ServletException("id missing for edit operation");
		}
		System.out.println("Customer edit requested with id="+id);
		
		MongoClient mongo=(MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		MongoDBCustomerDAO customerDAO = new MongoDBCustomerDAO(mongo);
		Customer c = new Customer();
		c.setDriverLicenceId(id);
		c = customerDAO.readCustomer(c);
		request.setAttribute("customer", c);
		List<Customer> customers = customerDAO.readAllCustomer();
		request.setAttribute("customers",customers);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerReg.html");
		rd.forward(request, response);
		/*
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		*/
		}
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
			request.setAttribute("error", "Name, Password,Comfirm Password, Phone and Email cannot be empty");
			MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
			MongoDBCustomerDAO customerDAO = new MongoDBCustomerDAO(mongo);
			Customer c = new Customer();
			c.setDriverLicenceId(DriverLicenceId);
			c.setName(Name);
			c.setPassword(Password);
			c.setPhone(phone);
			c.setEmail(email);
			request.setAttribute("customer", c);
			List<Customer> customers = customerDAO.readAllCustomer();
			request.setAttribute("customers", customers);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/customerReg.html");
			rd.forward(request, response);
		}
		else {
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			MongoDBCustomerDAO customerDAO = new MongoDBCustomerDAO(mongo);
			Customer c = new Customer();
			c.setDriverLicenceId(DriverLicenceId);
			c.setName(Name);
			c.setPassword(Password);
			c.setPhone(phone);
			c.setEmail(email);
			
			customerDAO.updateCustomer(c);
			System.out.println("Customer edited successfully with id=" + DriverLicenceId);
			request.setAttribute("success", "Customer edited successfully");
			List<Customer> customers = customerDAO.readAllCustomer();
			request.setAttribute("customers", customers);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/customerReg.html");
			rd.forward(request, response);
		}
	}

}
