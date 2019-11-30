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
 * Servlet implementation class DeletePersonServlet
 */
@WebServlet("/deleteCustomer")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("DriverLicenceId");
		if (id == null || "".equals(id)) {
			throw new ServletException("id missing for delete operation");
		}
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBCustomerDAO customerDAO = new MongoDBCustomerDAO(mongo);
		Customer c = new Customer();
		c.setDriverLicenceId(id);
		customerDAO.deleteCustomer(c);
		System.out.println("Customer deleted successfully with id=" + id);
		request.setAttribute("success", "Customer deleted successfully");
		List<Customer> persons = customerDAO.readAllCustomer();
		request.setAttribute("persons", persons);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/customerReg.html");
		rd.forward(request, response);
	}

}
