package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import domain.Student;
import domain.User;
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    String role = request.getParameter("role");
	    
	    try {
	        // Check if email and role are not empty
	        if (email != null && !email.isEmpty() && role != null && !role.isEmpty()) {
	            // Create user object and save to database
	            User user = new User(email, password, role);
	            UserDao dao = new UserDao();
	            dao.insertUser(user);

	            request.setAttribute("message", "Registration successful!");
	            response.sendRedirect("login.html"); // Redirect to login page after registration
	        } else {
	            response.getWriter().println("Email and role are required fields.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.getWriter().println("An error occurred during registration. Please try again later.");
	    }
	}	
	}


