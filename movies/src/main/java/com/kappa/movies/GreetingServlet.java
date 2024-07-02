package com.kappa.movies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Simulate getting the username from a login or session
        String username = "John Doe";

        // Set the username as a request attribute
        request.setAttribute("username", username);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/WEB-INF/views/greeting.jsp").forward(request, response);
    }
}
