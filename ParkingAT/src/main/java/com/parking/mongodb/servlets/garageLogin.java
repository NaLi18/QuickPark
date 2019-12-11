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
import com.parking.entity.Garage;
import com.parking.entity.GarageOwner;
import com.parking.mongodb.dao.MongoDBAdministerDAO;
import com.parking.mongodb.dao.MongoDBGarageDAO;
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
		HttpSession session=request.getSession();
		session.invalidate();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/homepage.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String email = request.getParameter("emailaddress");
				String Password = request.getParameter("Ipassword");
				
				MongoClient mongo = (MongoClient) request.getServletContext()
						.getAttribute("MONGO_CLIENT");
				
				MongoDBGarageOwnerDAO GarageOwnerDAO = new MongoDBGarageOwnerDAO(mongo);
				GarageOwnerDAO.findGarageOwner(email,Password);
				MongoDBGarageDAO  garageDAO = new MongoDBGarageDAO(mongo);
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				if(GarageOwnerDAO.findGarageOwner(email,Password)==null) {
					System.out.println("fail");
					request.setAttribute("loginError", "true");         
					request.getRequestDispatcher("/garagelogin.jsp").forward(request, response);
					
				}else {
					HttpSession session=request.getSession();	
					GarageOwner garageowner = GarageOwnerDAO.findGarageOwner(email,Password);
					session.setAttribute("GarageO", garageowner);
					Garage garage = garageDAO.findGrage( garageowner.getName());
					System.out.println(garageowner.getName());
					session.setAttribute("garage",garage);
					request.setAttribute("loginError", "false"); 
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/garageProfile.jsp");
					rd.forward(request, response);
				}
	}

}
