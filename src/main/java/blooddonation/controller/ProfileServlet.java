package blooddonation.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name="DonorLoginServlet", value="/DonorLogin")
public class DonorLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fake login (just for testing)
        String email = request.getParameter("email");
        String name = "Test Donor";
        String blood = "O+";

        // Create session
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("name", name);
        session.setAttribute("blood", blood);

        // Redirect to dashboard
        response.sendRedirect("donor-dashboard.jsp");
    }
}
