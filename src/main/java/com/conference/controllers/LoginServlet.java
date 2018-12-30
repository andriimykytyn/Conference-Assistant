package com.conference.controllers;

import com.conference.dao.entities.Users_usr;
import com.conference.dao.repos.UserRepo;
import com.conference.views.IndexSingleton;
import com.conference.views.LoginView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"}, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        LoginView loginView = new LoginView();
        out.println(loginView.getHtml());

        if (request.getParameter("email") != null) {
            UserRepo userRepo = new UserRepo();
            Users_usr usr = userRepo.getUserByEmailByPassword(request.getParameter("email"),
                    request.getParameter("password"));
            if (usr == null) {
                out.println("Please, log in again");
            } else {
                session.setAttribute("user", usr);
                response.sendRedirect("/main");
            }
        }
    }


    @Override
    public void init() throws ServletException {
        super.init();
        //set path
        String path = getServletContext().getRealPath("/html/");
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        indexSingleton.setHtmlPath(path);
    }
}
