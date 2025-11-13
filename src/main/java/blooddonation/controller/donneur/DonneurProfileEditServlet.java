package blooddonation.controller.donneur;

import blooddonation.bean.Donneur;
import blooddonation.dao.impl.DonneurDaoImpl;
import blooddonation.dao.impl.DonneurDaoImpl; // same package
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/donneur/update")
public class DonneurProfileEditServlet extends HttpServlet {

    private DonneurDaoImpl donneurDao;

    @Override
    public void init() {
        donneurDao = new DonneurDaoImpl();
    }

    // Show edit form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("../login.jsp");
            return;
        }

        Donneur donneur = (Donneur) session.getAttribute("user");
        // optionally reload from DB to get freshest data
        Donneur fresh = donneurDao.findById(donneur.getId());
        if (fresh != null) donneur = fresh;

        req.setAttribute("donneur", donneur);
        RequestDispatcher rd = req.getRequestDispatcher("/donneur/edit-profil.jsp");
        rd.forward(req, resp);
    }

    // Handle update form submission
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("../login.jsp");
            return;
        }

        try {
            Donneur sessionDonneur = (Donneur) session.getAttribute("user");
            Donneur donneurToUpdate = donneurDao.findById(sessionDonneur.getId());
            if (donneurToUpdate == null) {
                resp.sendRedirect("../login.jsp");
                return;
            }

            // Read parameters (validate/sanitize in real app)
            String prenom = req.getParameter("prenom");
            String nom = req.getParameter("nom");
            String email = req.getParameter("email");
            String telephone = req.getParameter("telephone");
            String adresse = req.getParameter("adresse");
            String groupe = req.getParameter("groupeSanguin"); // if enum stored as string
            String disponibilite = req.getParameter("disponibilite"); // ordinal or string depending on enum

            // Update fields (only update if not null/empty; avoids overwriting)
            if (prenom != null) donneurToUpdate.setPrenom(prenom.trim());
            if (nom != null) donneurToUpdate.setNom(nom.trim());
            if (email != null) donneurToUpdate.setEmail(email.trim());
            if (telephone != null) donneurToUpdate.setPhoneNum(telephone.trim());
            if (adresse != null) donneurToUpdate.setAdresse(adresse.trim());

            // if groupeSanguin is an enum attribute (GroupeSang), convert it
            if (groupe != null && !groupe.isEmpty()) {
                // example: GroupeSang.valueOf(groupe) — be careful about naming
                // if your Donneur uses enum type, set accordingly:
                try {
                    blooddonation.enums.GroupeSang gs = blooddonation.enums.GroupeSang.valueOf(groupe);
                    donneurToUpdate.setGroupeSanguin(gs);
                } catch (IllegalArgumentException ex) {
                    // invalid value; ignore or handle
                }
            }

            if (disponibilite != null && !disponibilite.isEmpty()) {
                try {
                    blooddonation.enums.StatusDisponibilite st = blooddonation.enums.StatusDisponibilite.valueOf(disponibilite);
                    donneurToUpdate.setDisponibilite(st);
                } catch (IllegalArgumentException ex) {
                    // ignore or handle
                }
            }

            // Optional: handle dateDernierDon if provided
            String dateDernierDon = req.getParameter("dateDernierDon");
            if (dateDernierDon != null && !dateDernierDon.trim().isEmpty()) {

                try {
                    donneurToUpdate.setDateDernierDon(LocalDate.parse(dateDernierDon));
                } catch (Exception ex) { /* ignore parse error */ }
            }

            // Persist update
            donneurDao.update(donneurToUpdate);

            // Refresh session attribute with updated entity
            Donneur updated = donneurDao.findById(donneurToUpdate.getId());
            session.setAttribute("user", updated);

            // success message and redirect back to profile page
            session.setAttribute("successMsg", "Profil mis à jour avec succès.");
            resp.sendRedirect(req.getContextPath() + "/donneur/profil");

        } catch (Exception e) {
            e.printStackTrace();
            req.getSession().setAttribute("errorMsg", "Erreur lors de la mise à jour du profil.");
            resp.sendRedirect(req.getContextPath() + "/donneur/profil");
        }
    }
}
