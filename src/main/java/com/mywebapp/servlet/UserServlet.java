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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idFromRequest = request.getParameter("id");
        System.out.println("param id is : " + idFromRequest);
        String action = request.getParameter("action");
        UserDao userDao = new UserDao();

        User user = null;
        if (action==null) {
            request.getRequestDispatcher("/WEB-INF/pages/userError.jsp").forward(request, response);
        } else {
            switch (action) {
                case "detail":
                    if (idFromRequest != null) {
                        user = userDao.findUser(idFromRequest);
                        request.setAttribute("user", user);
                        request.getRequestDispatcher("/WEB-INF/pages/showUser.jsp").forward(request, response);
                    }
                    break;
                case "list":
                    request.getRequestDispatcher("/WEB-INF/pages/userList.jsp").forward(request, response);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + action);
            }
        }
    }
}
