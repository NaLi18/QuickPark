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
import com.parking.entity.Customer;
import com.parking.entity.Reservation;

import com.parking.mongodb.dao.MongoDBReservationDAO;
/**
 * Servlet implementation class getGarageInfo
 */
@WebServlet("/getReservationInfo")
public class getReservationInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getReservationInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	//System.out.print("hello");
    	Customer c = (Customer) request.getSession().getAttribute("customer");
    	String userID = c.getName();
    	System.out.println(userID);
    	Reservation r = new Reservation();
    	r.setUserID(userID);
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBReservationDAO ReservationDAO = new MongoDBReservationDAO(mongo);
		ReservationDAO.readAllReservation(r);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(ReservationDAO.readAllReservation(r)== null) {
			System.out.println("Wrong get the garage");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerlogin.html");
			rd.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			//System.out.println("hello");
			List<Reservation> reservations = ReservationDAO.readAllReservation(r);
			session.setAttribute("reservations", reservations);
			System.out.println("get the reservation information sucessful ");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerProfileElement/Reservation.jsp");
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
