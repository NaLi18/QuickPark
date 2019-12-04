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
import com.parking.entity.GarageOwner;
import com.parking.mongodb.dao.MongoDBCustomerDAO;
import com.parking.mongodb.dao.MongoDBGarageOwnerDAO;

/**
 * Servlet implementation class addOwner
 */
@WebServlet("/addOwner")
public class addOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOwner() {
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
		String Name = request.getParameter("name");
		String Password = request.getParameter("password");
		String Password1 = request.getParameter("password1");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		if((Password.compareTo(Password1) !=0)){
			
			System.out.println("fail");
			request.setAttribute("error", "Mandatory Parameters Missing");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/garagereg.html");
			rd.forward(request, response);
			
		} else {
			
			GarageOwner o = new GarageOwner();
			
			o.setName(Name);
			o.setPassword(Password);
			o.setPhone(phone);
			o.setEmail(email);
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			
			MongoDBGarageOwnerDAO GarageOwnerDAO = new MongoDBGarageOwnerDAO(mongo);
			GarageOwnerDAO.createGarageOwner(o);
			
			System.out.println("Success");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/garagelogin.html");
			rd.forward(request, response);
					
		}
	}

}
