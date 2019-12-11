
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
import com.parking.mongodb.dao.MongoDBGarageOwnerDAO;
import com.parking.entity.Customer;
import com.parking.entity.GarageOwner;
import com.mongodb.MongoClient;
/**
 * Servlet implementation class DeletePersonServlet
 */
@WebServlet("/admingaragedelete")
public class AdminDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("_id");
		if (id == null || "".equals(id)) {
			throw new ServletException("id missing for delete operation");
		}
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		//MongoDBCustomerDAO customerDAO = new MongoDBCustomerDAO(mongo);
		GarageOwner g = new GarageOwner();
		g.setGarageOwnerID(id);
		MongoDBGarageOwnerDAO mdg=new MongoDBGarageOwnerDAO(mongo);
		mdg.deleteGarageOwner(g);
		System.out.println("Garage owner deleted successfully with id=" + id);
		request.setAttribute("success", "Garage owner deleted successfully");
		List<GarageOwner> persons = mdg.readAllGarageOwner();
		request.setAttribute("persons", persons);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/Admin.html");
		rd.forward(request, response);
	}

}
