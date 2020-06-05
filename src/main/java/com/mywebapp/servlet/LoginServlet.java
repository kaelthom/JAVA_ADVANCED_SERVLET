package com.mywebapp.servlet;

import com.mywebapp.dao.UserDao;
import com.mywebapp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value="/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        UserDao userDao = UserDao.getInstance();

        switch (action) {
            case "login":
                if (userDao.findUser(username)!=null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userLogged", true);
                    session.setAttribute("user", userDao.findUser(username));
                    response.sendRedirect(request.getContextPath() + "/user-details?action=list");
                } else {
                    response.sendRedirect(request.getContextPath() + "/error");
                }
                break;
            case "create":
                userDao.addUser(new User(email, username));
                response.sendRedirect(request.getContextPath() + "/user-details?action=list");
                break;

            default:
                response.sendRedirect(request.getContextPath() + "/error");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null) {
            switch (action) {
                case "logout":
                    request.getSession().invalidate();
                    response.sendRedirect(request.getContextPath() + "/login");
                    break;

                default:
                    response.sendRedirect(request.getContextPath() + "/error");
            }
        } else {
            request.getSession().invalidate();
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }

    }
}
