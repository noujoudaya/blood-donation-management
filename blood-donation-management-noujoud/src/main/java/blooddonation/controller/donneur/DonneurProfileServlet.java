package blooddonation.controller.donneur;

import blooddonation.bean.Donneur;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/donneur/profil")
public class DonneurProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("../login.jsp");
            return;
        }

        Donneur donneur = (Donneur) session.getAttribute("user");
        req.setAttribute("donneur", donneur);

        RequestDispatcher rd = req.getRequestDispatcher("/donneur/profil.jsp");
        rd.forward(req, resp);
    }
}

