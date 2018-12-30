package com.conference.controllers;

import com.conference.dao.entities.Users_usr;
import com.conference.dao.repos.UserRepo;
import com.conference.formvalidator.SignupFormValidator;
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
        String html = new SignupView().getHtml();

        if (request.getParameter("email") != null && request.getParameter("password") != null ) {
            SignupFormValidator signupFormValidator = new SignupFormValidator(
                    request.getParameter("email"),
                    request.getParameter("password"),
                    request.getParameter("username")
            );

            if (!signupFormValidator.isFormValid()) {
                String emailMessage = signupFormValidator.getEmailMessage();
                String passwordMessage = signupFormValidator.getPasswordMessage();
                String usernameMessage = signupFormValidator.getUsernameMessage();
                if (!isEmptyString(emailMessage)) {
                    html = html.replace("<!--emailinvalid-->", emailMessage);
                }
                if (!isEmptyString(passwordMessage)) {
                    html = html.replace("<!--passwordinvalid-->", passwordMessage);
                }
                if (!isEmptyString(usernameMessage)) {
                    html = html.replace("<!--usernameinvalid-->", usernameMessage);
                }
            } else {
                UserRepo userRepo = new UserRepo();
                Users_usr usr = new Users_usr();
                usr.setNickname_usr(request.getParameter("username"));
                usr.setEmail_usr(request.getParameter("email"));
                usr.setPassword_usr(request.getParameter("password"));
                userRepo.saveUser(usr);
                response.sendRedirect("/login");
            }
        }

        switch (request.getPathInfo()) {
            case "/signup":
                out.println(html);
                break;
            case "/logout":
                session.setAttribute("user", null);
                response.sendRedirect("/login");
                break;
        }
    }

    private static boolean isEmptyString(String s) {
        return s == null || s.isEmpty();
    }
}
