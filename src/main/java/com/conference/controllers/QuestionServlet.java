package com.conference.controllers;

import com.conference.dao.entities.Questions_qs;
import com.conference.dao.entities.Users_usr;
import com.conference.dao.repos.QuestionRepo;
import com.conference.views.MainView;
import com.conference.views.QuestionView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuestionServlet", urlPatterns ={"/questions"})
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        Users_usr currentUser = (Users_usr) session.getAttribute("user");

        if (currentUser != null) {
            QuestionView questionView = new QuestionView();
            out.println(questionView.getHtml().replace("<!--#username#-->", "@"+currentUser.getNickname_usr()));
        } else {
            response.sendRedirect("/login");
        }

        //save question
        if ( request.getParameter("question") != null ) {
            Questions_qs questions_qs = new Questions_qs();
            questions_qs.setQuestion_qs(request.getParameter("quesiton"));
            questions_qs.setFk_id_rp(currentReport.getId_rp);
            questions_qs.setFk_id_usr(currentUser.getId_usr());
            QuestionRepo questionRepo = new QuestionRepo();
            questionRepo.saveQuestion(questions_qs);
        }
    }
}
