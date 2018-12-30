package com.conference.controllers;

import com.conference.dao.entities.Conferences_cf;
import com.conference.dao.entities.Users_usr;
import com.conference.dao.repos.ConferenceRepo;
import com.conference.dao.repos.UserRepo;
import com.conference.views.IndexSingleton;
import com.conference.views.LoginView;
import com.conference.views.MainView;
import com.conference.views.SignupView;
import sun.applet.Main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MainServlet", urlPatterns ={"/main/*"})
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        Users_usr currentUser = (Users_usr) session.getAttribute("user");
        ConferenceRepo conferenceRepo = new ConferenceRepo();
        Conferences_cf  conferences_cf = conferenceRepo.getConference();


        if (currentUser != null) {
            MainView mainView = new MainView();
            out.println(mainView.getHtml()
                    .replace("<!--#username#-->", "@"+currentUser.getNickname_usr())
                    .replace("<!--Conference name-->", conferences_cf.getName_cf())
                    .replace("<!--Short information about this conference-->", conferences_cf.getInfo_cf())
            );
        } else {
            response.sendRedirect("/login");
        }

        switch (request.getPathInfo()) {
            case "/reports":
                out.println();
                break;
            case "/questions":
                out.println();
        }
    }
}
