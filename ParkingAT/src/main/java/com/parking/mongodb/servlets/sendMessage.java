package com.parking.mongodb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.parking.entity.Message;
/**
 * Servlet implementation class sendMessage
 */
@WebServlet("/mail")
public class sendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String to = request.getParameter("senderEmail");
        String subject = request.getParameter("subject");
        String message =  request.getParameter("message");
        String user = request.getParameter("email");
        //Message.send(to,subject, message, user);
        out.println("Mail send successfully");
	}

}
