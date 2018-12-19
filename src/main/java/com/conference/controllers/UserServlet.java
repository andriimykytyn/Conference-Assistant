package com.conference.controllers;

import com.conference.dao.entities.Users_usr;
import com.conference.dao.repos.UserRepo;
import com.conference.views.IndexSingleton;
import com.conference.views.LoginView;
import com.conference.views.SignupView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", urlPatterns ={"/user/*"}, loadOnStartup = 1)
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        if (request.getParameter("email") != null && request.getParameter("password") != null ) {
            UserRepo userRepo = new UserRepo();
            Users_usr usr = new Users_usr();
            usr.setEmail_usr(request.getParameter("email"));
            usr.setNickname_usr(request.getParameter("username"));
            usr.setPassword_usr(request.getParameter("password"));
            userRepo.saveUser(usr);
            response.sendRedirect("/login");
        }


        switch (request.getPathInfo()) {
            case "/signup":
                SignupView signupView = new SignupView();
                out.println(signupView.getHtml());
                break;
            case "/logout":
                session.setAttribute("user", null);
                response.sendRedirect("/login");
                break;
        }
    }
}
