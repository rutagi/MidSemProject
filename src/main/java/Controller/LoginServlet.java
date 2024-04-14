package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import domain.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Check if email and password are not empty
            if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
                UserDao dao = new UserDao();
                User user = dao.getUserByEmail(email);

                // Check if user exists and password matches
                if (user != null && validatePassword(password, user.getPassword())) {
                    // Set user session
                    HttpSession session = request.getSession();
                    session.setAttribute("email", email);
                    session.setAttribute("role", user.getRole());

                    // Redirect to appropriate page based on user role
                    String role = user.getRole();
                    if ("admin".equals(role)) {
                        response.sendRedirect("Home.html");
                    } else if ("user".equals(role)) {
                        response.sendRedirect("Academic.html");
                    } else if ("teacher".equals(role)) {
                        response.sendRedirect("Media.html");
                    } else {
                        // Handle other roles or cases if needed
                        response.sendRedirect("login.html");
                    }
                } else {
                    // If credentials are invalid, redirect back to login page with an error message
                    response.sendRedirect("login.html?error=Invalid credentials");
                }
            } else {
                response.getWriter().println("Email and password are required fields.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred during login. Please try again later.");
        }
    }

    private boolean validatePassword(String inputPassword, String storedPassword) {
        // Implement password validation logic here
        // For demonstration, let's assume a simple comparison
        return inputPassword.equals(storedPassword);
    }
}