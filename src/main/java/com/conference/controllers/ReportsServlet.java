package com.conference.controllers;

import com.conference.dao.entities.Reports_rp;
import com.conference.dao.entities.Users_usr;
import com.conference.dao.repos.ReportsRepo;
import com.conference.views.ReportsView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReportsServlet", urlPatterns = "/reports")
public class ReportsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        Users_usr currentUser = (Users_usr) session.getAttribute("user");
        ReportsView reportsView = new ReportsView();

        ReportsRepo reportsRepo = new ReportsRepo();
        Reports_rp reports = reportsRepo.getReportByConferenceId(request.getParameter("cf_id"));

        if (currentUser != null) {
            out.println(reportsView.getHtml()
                    .replace("<!--#username#-->", "@" + currentUser.getNickname_usr())
                    .replace("<!--Report Name-->", reports.getName_rp())
                    .replace("<!--Announcer info-->", reports.getAnnouncer_rp())
                    .replace("<!--report id-->", "" + reports.getId_rp()));
        } else {
            response.sendRedirect("/login");
        }
    }
}
