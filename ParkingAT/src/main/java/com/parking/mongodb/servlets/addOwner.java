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
import com.parking.mongodb.dao.MongoDBAdministerDAO;
import com.parking.mongodb.dao.MongoDBCustomerDAO;
import com.parking.mongodb.dao.MongoDBGarageOwnerDAO;

/**
 * Servlet implementation class addOwner
 */
@WebServlet("/addOwner")
public class addOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public addOwner() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name = request.getParameter("name");
		String Password = request.getParameter("password");
		String Password1 = request.getParameter("password1");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		if((Password.compareTo(Password1) !=0)){
			
			System.out.println("fail");
			request.setAttribute("passwordError", "true");       
			request.getRequestDispatcher("/garagereg.jsp").forward(request, response);
		} else {
			GarageOwner o = new GarageOwner();
			request.setAttribute("passwordError", "false"); 
			o.setName(Name);
			o.setPassword(Password);
			o.setPhone(phone);
			o.setEmail(email);
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			
			MongoDBCustomerDAO CustomerDAO = new MongoDBCustomerDAO(mongo);
			MongoDBGarageOwnerDAO GarageOwnerDAO = new MongoDBGarageOwnerDAO(mongo);
			MongoDBAdministerDAO AdministerDAO = new MongoDBAdministerDAO(mongo);
			
			
			if(CustomerDAO.uniqueName(Name) !=null || GarageOwnerDAO.uniqueName(Name) != null || AdministerDAO.uniqueName(Name) != null) {
				
				request.setAttribute("NameDup", "true");       
				request.getRequestDispatcher("/garagereg.jsp").forward(request, response);
				
			} else if (CustomerDAO.uniqueEmail(email) !=null || GarageOwnerDAO.uniqueEmail(email) != null || AdministerDAO.uniqueEmail(email) != null){
				
				request.setAttribute("EmailDup", "true");       
				request.getRequestDispatcher("/garagereg.jsp").forward(request, response);
				
				
			} else {
				
				request.setAttribute("EmailDup", "false"); 
				request.setAttribute("NameDup", "false"); 
				
				GarageOwnerDAO.createGarageOwner(o);
				System.out.println("Success");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/garagelogin.jsp");
				rd.forward(request, response);
			
			}		
					
		}
	}

}
