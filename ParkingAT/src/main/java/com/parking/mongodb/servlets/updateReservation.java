package com.parking.mongodb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;
import com.parking.entity.Reservation;
import com.parking.mongodb.dao.MongoDBCustomerDAO;
import com.parking.mongodb.dao.MongoDBReservationDAO;

/**
 * Servlet implementation class updateReservation
 */
@WebServlet("/updateReservation")
public class updateReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("reservationID");
		String startTime = request.getParameter("startTime");
		String startDate = request.getParameter("parking-start");
		String endTime = request.getParameter("endtime");
		String endDate = request.getParameter("parking-end");
		if (id == null || "".equals(id)) {
			throw new ServletException("id missing for delete operation");
		}
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		MongoDBReservationDAO ReservationDAO = new MongoDBReservationDAO(mongo);
		Reservation r = new Reservation();
		r.setReservationID(id);
		r.setCheckOutTime(endTime);
		r.setCheckInTime(startTime);
		r.setCheckOutDate(endDate);
		r.setCheckInDate(startDate);
		ReservationDAO.updateReservation(r);
		System.out.println("Reservation was updated successfully with id=" + id);
		request.setAttribute("success", "Reservation update successfully");
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"./Reservation.jsp");
		rd.forward(request, response);
	}

}
