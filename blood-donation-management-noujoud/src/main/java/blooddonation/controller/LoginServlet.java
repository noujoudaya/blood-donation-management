package blooddonation.controller;

import blooddonation.bean.User;
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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        UserDao userDao = new UserDaoImpl();
        userService = new UserService(userDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userService.authenticateUser(email, password);

        if (user != null) {
            session.setAttribute("user", user);
            session.setAttribute("successMsg", "Connexion réussie !");

            // Redirect by role
            if ("donneur".equalsIgnoreCase(user.getRole())) {
                resp.sendRedirect(req.getContextPath() + "/donneur/dashboard.jsp");
            } else if ("hopital".equalsIgnoreCase(user.getRole())) {
                resp.sendRedirect(req.getContextPath() + "/hopital/dashboard.jsp");
            } else {
                resp.sendRedirect(req.getContextPath() + "/admin/dashboard.jsp");
            }

        } else {
            session.setAttribute("errorMsg", "Email ou mot de passe incorrect !");
            resp.sendRedirect("login.jsp");
        }
    }
}

