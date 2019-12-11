package com.parking.mongodb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.MongoClient;
import com.parking.entity.Reservation;
import com.parking.mongodb.dao.MongoDBReservationDAO;

@WebServlet("/cancelReservation")
public class cancelReservationSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public cancelReservationSerlvet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vID = request.getParameter("id");
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBReservationDAO ReservationDAO=new MongoDBReservationDAO(mongo);
		Reservation r = new Reservation();
		ReservationDAO.deleteReservation(vID);
		HttpSession session=request.getSession();	
		List<Reservation> reservations = ReservationDAO.readAllReservation(r);
		session.setAttribute("reservations", reservations);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerProfileElement/Reservation.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
