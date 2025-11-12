package blooddonation.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/donordashboard")
public class DonorDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Données temporaires (avant Hibernate)
        request.setAttribute("bloodType", "A+");
        request.setAttribute("donationCount", 3);
        request.setAttribute("nextAppointment", "25 Nov 2025");

        request.getRequestDispatcher("donor-dashboard.jsp").forward(request, response);
    }
}
