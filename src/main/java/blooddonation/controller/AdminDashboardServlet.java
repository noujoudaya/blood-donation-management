package blooddonation.controller;

import blooddonation.dao.impl.*;
import blooddonation.service.DashboardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminDashboardServlet extends HttpServlet {

    private DashboardService service;

    @Override
    public void init() throws ServletException {
        service = new DashboardService(
                new DonneurDaoImpl(),
                new HopitalDaoImpl(),
                new DonDaoImpl(),
                new DemandeDaoImpl()
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("service", service);
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }
}





