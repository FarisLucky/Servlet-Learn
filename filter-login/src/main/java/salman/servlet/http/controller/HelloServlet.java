package salman.servlet.http.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/","/login"})
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1l;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("admin".equals(username) && "123".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("isLoggedIn",true);
            session.setAttribute("username",username);
            resp.sendRedirect("welcome.jsp");
        } else {
            resp.sendRedirect("login?error=true");
        }
    }
}
