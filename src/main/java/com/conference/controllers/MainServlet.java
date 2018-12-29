package com.conference.controllers;

import com.conference.dao.entities.Conferences_cf;
import com.conference.dao.entities.Reports_rp;
import com.conference.dao.entities.Users_usr;
import com.conference.dao.repos.ConferenceRepo;
import com.conference.dao.repos.ReportsRepo;
import com.conference.dao.repos.UserRepo;
import com.conference.views.*;
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
        MainView mainView = new MainView();

        if (currentUser != null) {
            out.println(mainView.getHtml()
                    .replace("<!--#username#-->", "@"+currentUser.getNickname_usr())
                    .replace("<!--Conference name-->", conferences_cf.getName_cf())
                    .replace("<!--Short information about this conference-->", conferences_cf.getInfo_cf())
                    .replace("<!--conference id-->", ""+conferences_cf.getId_cf())
            );
        } else {
            response.sendRedirect("/login");
        }

        switch (request.getPathInfo()) {
            case "/reports":
                ReportsView reportsView = new ReportsView();
                ReportsRepo reportsRepo = new ReportsRepo();
                Reports_rp reports = reportsRepo.getReportByConferenceId(request.getParameter("cf_id"));

                out.print(reportsView.getHtml()
                        .replace("<!--#username#-->", "@"+currentUser.getNickname_usr())
                        .replace("<!--Report Name-->", reports.getName_rp())
                        .replace("<!--Announcer info-->", reports.getAnnouncer_rp())
                        .replace("<!--report id-->", ""+reports.getId_rp()));
                break;
            case "/questions":
                out.println();
        }
    }
}
