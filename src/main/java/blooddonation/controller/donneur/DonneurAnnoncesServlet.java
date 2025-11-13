package blooddonation.controller.donneur;

import blooddonation.bean.Donneur;
import blooddonation.service.donneur.DonneurAnnoncesService;
import blooddonation.dao.impl.DemandeDaoImpl;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/donneur/annonces")
public class DonneurAnnoncesServlet extends HttpServlet {

    private DonneurAnnoncesService annoncesService;

    @Override
    public void init() {
        annoncesService = new DonneurAnnoncesService(new DemandeDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("../login.jsp");
            return;
        }

        Donneur donneur = (Donneur) session.getAttribute("user");
        req.setAttribute("urgentDemands", annoncesService.getUrgentDemands(donneur.getGroupeSanguin()));

        RequestDispatcher rd = req.getRequestDispatcher("/donneur/annonces.jsp");
        rd.forward(req, resp);
    }
}

