package com.parking.mongodb.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import com.mongodb.internal.connection.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.MongoClient;
import com.parking.entity.Reservation;
import com.parking.entity.Garage;
import com.parking.entity.Customer;
import com.parking.mongodb.dao.MongoDBGarageDAO;
import com.parking.mongodb.dao.MongoDBReservationDAO;


/**
 * Servlet implementation class AddReservationServlet
 */
@WebServlet("/addReservation")
public class AddReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer c = (Customer) request.getSession().getAttribute("customer");
		String garageName = request.getParameter("garage");
		String startTime = request.getParameter("begintime");
		String startDate = request.getParameter("begin");
		String endTime = request.getParameter("endtime");
		String endDate = request.getParameter("end");
		//String userID = request.getParameter("user");
		String userID = c.getName();
		boolean paid = false;
		//String paymentId = request.getParameter("PaymentID");
		if((garageName == null || garageName.equals(""))||(startTime == null || startTime.equals(""))
				||(startDate==null|| startDate.equals(""))||(endTime == null || endTime.equals(""))
				||(endDate==null|| endDate.equals(""))||(userID==null ||userID.equals(""))){
			request.setAttribute("error", "Mandatory Parameters Missing");
			System.out.println(userID);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/homepage.jsp");
			rd.forward(request, response);
		}
		else {
			Reservation r = new Reservation();
			r.setUserID(userID);
			r.setGarageID(garageName);
			r.setPaid(paid);
			r.setEndTime(endTime);
			//r.setPaymentId(paymentId);
			r.setStartTime(startTime);
			r.setEndDate(endDate);
			r.setStartDate(startDate);
			//r.setReservationID(reservationId);
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			MongoDBReservationDAO ReservationDAO = new MongoDBReservationDAO(mongo);
			MongoDBGarageDAO GarageDAO = new MongoDBGarageDAO(mongo);
			Garage g = GarageDAO.findGrage(garageName);
			double price = g.getUnitPrice();
			int spot = g.getSpot();
			Random randomGenerator = new Random();
			int randomInt1 = randomGenerator.nextInt(spot) + 1;
			//String[] section=g.getSection();
			//int randomInt1 = randomGenerator.nextInt() + 1;
			r.setPrice(price);
			r.setSpots(Integer.toString(randomInt1));
			ReservationDAO.createReservation(r);
			System.out.println("Reservation Added Successfully with id");
			request.setAttribute("success", "Reservation added successfully");
			//List<Reservation> reservations = ReservationDAO.readAllReservation();
			//request.setAttribute("reservations", reservations);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/customerProfile.jsp");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
