package com.conference.controllers;

import com.conference.dao.entities.Questions_qs;
import com.conference.dao.entities.Users_usr;
import com.conference.dao.repos.QuestionRepo;
import com.conference.views.QuestionView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "QuestionServlet", urlPatterns ={"/questions"})
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        Users_usr currentUser = (Users_usr) session.getAttribute("user");
        QuestionRepo questionRepo = new QuestionRepo();
        Questions_qs questions_qs = new Questions_qs();
        QuestionView questionView = new QuestionView();

        if (currentUser != null) {
            int userId = currentUser.getId_usr();
            int reportId = Integer.parseInt(request.getParameter("rp_id"));

            List<Questions_qs> questions = questionRepo.getQuestionsByReportId(String.valueOf(reportId));
            List<Questions_qs> sortedQuestions = questions.stream()
                    .sorted(Comparator.comparing(Questions_qs::getRating_qs))
                    .collect(Collectors.toList());
            for (int i=0;i<questions.size();i++) {
                out.println(questionView.getHtml().replace("<!--questionhere<button class=\"btn btn-outline-secondary\" style=\"padding:8px;\n" +
                                "        padding-top:0px;padding-bottom:0px;position: absolute;right: 15px;\" type=\"submit\" id=\"button-addon2\">+</button>-->"
                        , i+1 +"."+" "+sortedQuestions.get(i).getQuestion_qs()+"<button class=\"btn btn-outline-secondary\" style=\"padding:8px;\n" +
                                "        padding-top:0px;padding-bottom:0px;position: absolute;right: 15px;\" type=\"submit\" id=\"button-addon2\">+</button>"));
            }

            String questionPage = questionView.getHtml()
                    .replace("<!--#username#-->", "@" + currentUser.getNickname_usr())
                    .replace("<!--#reportid#-->", String.valueOf(reportId) );

            String question = request.getParameter("question");

            if (question != null && !question.isEmpty()) {
                //save question

                questions_qs.setQuestion_qs(question);
                questions_qs.setFk_id_rp(reportId);
                questions_qs.setFk_id_usr(userId);
                questionRepo.saveQuestion(questions_qs);
            }
            out.println(questionPage);
        } else {
            response.sendRedirect("/login");
        }

    }
}
