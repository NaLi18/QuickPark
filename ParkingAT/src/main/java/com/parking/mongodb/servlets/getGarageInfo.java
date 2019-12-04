package com.parking.mongodb.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.MongoClient;
import com.parking.entity.Garage;
import com.parking.mongodb.dao.MongoDBAdministerDAO;
import com.parking.mongodb.dao.MongoDBGarageDAO;
import com.parking.mongodb.dao.MongoDBGarageOwnerDAO;
/**
 * Servlet implementation class getGarageInfo
 */
@WebServlet("/getGarage")
public class getGarageInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getGarageInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String add = (String)request.getParameter("addressInput");
		System.out.println(add);
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		
		MongoDBGarageDAO GarageDAO = new MongoDBGarageDAO(mongo);
		GarageDAO.readAllGarage(add);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(GarageDAO.readAllGarage(add)== null) {
			System.out.println("Wrong get the garage");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerlogin.html");
			rd.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			List<Garage> garages = GarageDAO.readAllGarage(add);
			session.setAttribute("garages", garages);
			for(Garage g:garages) {
				System.out.println(g.getName());
			}
			System.out.println("get the information sucessful");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/homepage.jsp");
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
