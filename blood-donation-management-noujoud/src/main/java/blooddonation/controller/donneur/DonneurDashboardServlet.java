package blooddonation.controller.donneur;

import blooddonation.bean.Donneur;
import blooddonation.service.donneur.DonneurDashboardService;
import blooddonation.dao.impl.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/donneur/dashboard")
public class DonneurDashboardServlet extends HttpServlet {

    private DonneurDashboardService dashboardService;

    @Override
    public void init() {
        dashboardService = new DonneurDashboardService(new DonDaoImpl(), new DemandeDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("../login.jsp");
            return;
        }

        Donneur donneur = (Donneur) session.getAttribute("user");

        req.setAttribute("totalDons", dashboardService.getTotalDons(donneur.getId()));
        req.setAttribute("lastDonation", dashboardService.getLastDonation(donneur.getId()));
        req.setAttribute("nextDonation", dashboardService.getNextPossibleDate(donneur.getId()));
        req.setAttribute("urgentDemands", dashboardService.getUrgentDemands(donneur.getGroupeSanguin()));

        RequestDispatcher rd = req.getRequestDispatcher("/donneur/dashboard.jsp");
        rd.forward(req, resp);
    }
}

