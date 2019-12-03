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
import com.parking.mongodb.dao.MongoDBCustomerDAO;

/**
 * Servlet implementation class administerLogin
 */
@WebServlet("/administerLogin")
public class administerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public administerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("aEmail");
		String Password = request.getParameter("aPassword");
		
		System.out.println("email:"+email);
		System.out.println("Password:"+Password);
		
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		
		MongoDBAdministerDAO AdministerDAO = new MongoDBAdministerDAO(mongo);
		AdministerDAO.findAdminister(email,Password);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(AdministerDAO.findAdminister(email,Password)!=true) {
			System.out.println("fail");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Admin.html");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminProfile.html");
			rd.forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
