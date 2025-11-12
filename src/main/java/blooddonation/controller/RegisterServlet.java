package blooddonation.controller;

import blooddonation.dao.impl.UserDaoImpl;
import blooddonation.dao.interfaces.UserDao;
import blooddonation.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService service;

    @Override
    public void init() {
        UserDao userDao = new UserDaoImpl();
        service = new UserService(userDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();

            // 1️⃣ Get parameters from JSP
            String prenom = req.getParameter("prenom");
            String nom = req.getParameter("nom");
            String email = req.getParameter("email");
            String phone = req.getParameter("telephone");
            String password = req.getParameter("motDePasse");
            String role = req.getParameter("role");

            // 2️⃣ Call service layer to handle registration
            boolean success = service.registerUser(prenom, nom, email, phone, password, role);

            // 3️⃣ Set session messages
            if (success) {
                session.setAttribute("successMsg", "Register Successfully!");
            } else {
                session.setAttribute("errorMsg", "Something went wrong!");
            }

            // 4️⃣ Redirect back to the signup page
            resp.sendRedirect("register.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("register.jsp");
        }
    }
}
