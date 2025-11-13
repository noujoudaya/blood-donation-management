package blooddonation.controller.donneur;

import blooddonation.bean.Donneur;
import blooddonation.bean.Don;
import blooddonation.dao.impl.DonDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/donneur/dons")
public class DonneurDonsServlet extends HttpServlet {

    private DonDaoImpl donDao;

    @Override
    public void init() {
        donDao = new DonDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("../login.jsp");
            return;
        }

        Donneur donneur = (Donneur) session.getAttribute("user");
        List<Don> dons = donDao.findByDonneurId(donneur.getId());

        req.setAttribute("dons", dons);
        RequestDispatcher rd = req.getRequestDispatcher("/donneur/list-dons.jsp");
        rd.forward(req, resp);
    }
}
