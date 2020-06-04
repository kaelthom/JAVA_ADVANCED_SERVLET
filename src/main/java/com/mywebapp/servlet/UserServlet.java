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
        UserDao userDao = new UserDao();

        request.setAttribute("firstUserInUserDao", userDao.getUsers().get("John"));

        request.setAttribute("user", new User("Jean", "Paul", 2000));
        request.setAttribute("name", "John Doe");
        request.getRequestDispatcher("/WEB-INF/pages/showUser.jsp").forward(request, response);
    }
}
