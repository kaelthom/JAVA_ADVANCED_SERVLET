package com.mywebapp.servlet;

import com.mywebapp.dao.UserDao;
import com.mywebapp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/user-details")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String salary = request.getParameter("salary");

        UserDao userDao = UserDao.getInstance();
        userDao.addUser(new User(lastname, firstname, Integer.parseInt(salary)));

        response.sendRedirect(request.getContextPath() + "/user-details?action=list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idFromRequest = request.getParameter("id");
        System.out.println("param id is : " + idFromRequest);
        String action = request.getParameter("action");
        UserDao userDao = UserDao.getInstance();

        User user = null;
        if (action==null) {
            response.sendRedirect(request.getContextPath() + "/error");
        } else {
            switch (action) {
                case "detail":
                    if (idFromRequest != null) {
                        user = userDao.findUser(idFromRequest);
                        request.setAttribute("user", user);
                        request.getRequestDispatcher("/WEB-INF/pages/showUser.jsp").forward(request, response);
                    } else {
                        response.sendRedirect(request.getContextPath() + "/error");
                    }
                    break;
                case "list":
                    request.setAttribute("users", userDao.getUsers().values());
                    request.getRequestDispatcher("/WEB-INF/pages/userList.jsp").forward(request, response);
                    break;
                case "add":
                    request.getRequestDispatcher("/WEB-INF/pages/addUser.jsp").forward(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/error");
            }
        }
    }
}
