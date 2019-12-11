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
import com.parking.mongodb.dao.MongoDBAdministerDAO;
import com.parking.mongodb.dao.MongoDBCustomerDAO;
import com.parking.mongodb.dao.MongoDBGarageOwnerDAO;


@WebServlet("/addCustomer")
public class addCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public addCustomer() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DriverLicenceId = request.getParameter("DriverLicenceId");
		String DriverLicenceId1 = request.getParameter("DriverLicenceId1");
		String Name = request.getParameter("name");
		String Password = request.getParameter("password");
		String Password1 = request.getParameter("password1");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		
		if(Password.compareTo(Password1) !=0){
					
			System.out.println("fail");
			request.setAttribute("passwordError", "true");       
			request.getRequestDispatcher("/customerReg.jsp").forward(request, response);
			
		} else if (DriverLicenceId.compareTo(DriverLicenceId1)!=0) {
			request.setAttribute("DLIDError", "true");       
			request.getRequestDispatcher("/customerReg.jsp").forward(request, response);
				
			}else {
			request.setAttribute("passwordError", "false"); 
			request.setAttribute("DLIDError", "false"); 
			Customer c = new Customer();
			c.setDriverLicenceId(DriverLicenceId);
			c.setName(Name);
			c.setPassword(Password);
			c.setPhone(phone);
			c.setEmail(email);
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			
			MongoDBCustomerDAO CustomerDAO = new MongoDBCustomerDAO(mongo);
			MongoDBGarageOwnerDAO GarageOwnerDAO = new MongoDBGarageOwnerDAO(mongo);
			MongoDBAdministerDAO AdministerDAO = new MongoDBAdministerDAO(mongo);
			
			if(CustomerDAO.uniqueName(Name) !=null || GarageOwnerDAO.uniqueName(Name) != null || AdministerDAO.uniqueName(Name) != null) {
				
				request.setAttribute("NameDup", "true");       
				request.getRequestDispatcher("/customerReg.jsp").forward(request, response);
				
			} else if (CustomerDAO.uniqueEmail(email) !=null || GarageOwnerDAO.uniqueEmail(email) != null || AdministerDAO.uniqueEmail(email) != null){
				
				request.setAttribute("EmailDup", "true");       
				request.getRequestDispatcher("/customerReg.jsp").forward(request, response);
				
			} else {
				request.setAttribute("EmailDup", "false"); 
				request.setAttribute("NameDup", "false"); 
				CustomerDAO.createCustomer(c);
				System.out.println("Success");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerlogin.jsp");
				rd.forward(request, response);
			
			}		
		}
	}

}
