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
            );
        } else {
            response.sendRedirect("/login");
        }

        switch (request.getPathInfo()) {
            case "/reports":
                ReportsView reportsView = new ReportsView();
                out.println(reportsView.getHtml());

                ReportsRepo reportsRepo = new ReportsRepo();
                Reports_rp reports = reportsRepo.getReportByConferenceId(request.getParameter("cf_id"));

                out.println(reportsView.getHtml().replace("<!--content-->","<div class=\"report\" style=\"width: 400px; height: 100%; background-color: #333333; color: #fff; margin-top: 30px; margin-left: 15px; padding: 15px; border-radius: 3px\">\n" +
                        "        <h2>"+reports.getName_rp()+"</h2>\n" +
                        "        <p>"+reports.getAnnouncer_rp()+"</p>\n" +
                        "    </div>")
                        .replace("<form>\n" +
                                "        <div class=\"input-group\">\n" +
                                "            <input type=\"text\" name=\"cf_id\" class=\"form-control\" aria-describedby=\"button-addon2\">\n" +
                                "            <div style=\"background-color: #444444; color: #fff; -webkit-border-radius: 0;-moz-border-radius: 0;border-radius: 0; border: none;\" class=\"input-group-append\">\n" +
                                "                <button class=\"btn btn-outline-secondary\" type=\"submit\" id=\"button-addon2\">show</button>\n" +
                                "            </div>\n" +
                                "        </div>\n" +
                                "    </form>", "")
                );
                break;
            case "/questions":
                out.println();
        }
    }
}
