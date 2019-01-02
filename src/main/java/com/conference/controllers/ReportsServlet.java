package com.conference.controllers;

import com.conference.dao.entities.Reports_rp;
import com.conference.dao.entities.Users_usr;
import com.conference.dao.repos.ReportsRepo;
import com.conference.views.IndexSingleton;
import com.conference.views.ReportsView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
        IndexSingleton indexSingleton = IndexSingleton.getInstance();

        ReportsRepo reportsRepo = new ReportsRepo();
        List<Reports_rp> reports = reportsRepo.getReportByConferenceId(request.getParameter("cf_id"));
        String cfId = request.getParameter("cf_id");
        out.println(reportsView.getHtml().replace("<!--#username#-->", "@" + currentUser.getNickname_usr()));


        if (cfId==null||cfId.equals("")) {
            List<Reports_rp> allReports = reportsRepo.getAllReports();
            for (int i=0; i<allReports.size();i++) {
                out.print(indexSingleton.getReports()
                        .replace("<!--Report Name-->", allReports.get(i).getName_rp())
                        .replace("<!--Announcer info-->", allReports.get(i).getAnnouncer_rp())
                        .replace("<!--report id-->", ""+allReports.get(i).getId_rp()));

            }

        } else if (currentUser != null) {
            for (int i=0; i<reports.size();i++) {
                out.print(indexSingleton.getReports()
                        .replace("<!--Report Name-->", reports.get(i).getName_rp())
                        .replace("<!--Announcer info-->", reports.get(i).getAnnouncer_rp())
                        .replace("<!--report id-->", ""+reports.get(i).getId_rp()));

                    }
                } else {
                     response.sendRedirect("/login");
                }
    }
}
