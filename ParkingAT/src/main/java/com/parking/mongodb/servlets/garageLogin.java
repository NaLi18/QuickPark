package com.parking.mongodb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;
import com.parking.mongodb.dao.MongoDBAdministerDAO;
import com.parking.mongodb.dao.MongoDBGarageOwnerDAO;

/**
 * Servlet implementation class garageLogin
 */
@WebServlet("/garageLogin")
public class garageLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public garageLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("emailaddress");
		String Password = request.getParameter("Ipassword");
		
		System.out.println("email:"+email);
		System.out.println("Password:"+Password);
		
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		
		MongoDBGarageOwnerDAO GarageOwnerDAO = new MongoDBGarageOwnerDAO(mongo);
		GarageOwnerDAO.findGarageOwner(email,Password);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(GarageOwnerDAO.findGarageOwner(email,Password)!=true) {
			System.out.println("fail");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/garagelogin.html");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/garageProfile.html");
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
