package com.conference.controllers;

import com.conference.views.IndexSingleton;
import com.conference.views.LoginView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns ={"/login"}, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        LoginView loginView = new LoginView();
        loginView.setTitle("CAssistant");
        loginView.setContent("<form class=\"form-signin text-center\">\n" +
                "      <img class=\"mb-4\" src=\"../../assets/brand/bootstrap-solid.svg\" alt=\"\" width=\"72\" height=\"72\">\n" +
                "      <h1 class=\"h3 mb-3 font-weight-normal\">Please sign in</h1>\n" +
                "      <label for=\"inputEmail\" class=\"sr-only\">Email address</label>\n" +
                "      <input type=\"email\" id=\"inputEmail\" class=\"form-control\" placeholder=\"Email address\" required autofocus>\n" +
                "      <label for=\"inputPassword\" class=\"sr-only\">Password</label>\n" +
                "      <input type=\"password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Password\" required>\n" +
                "      <div class=\"checkbox mb-3\">\n" +
                "        <label>\n" +
                "          <input type=\"checkbox\" value=\"remember-me\"> Remember me\n" +
                "        </label>\n" +
                "      </div>\n" +
                "      <button class=\"btn btn-lg btn-dark btn-block\" type=\"submit\">Sign in</button>\n" +
                "      <p class=\"mt-5 mb-3 text-muted\">Don't have an account? <a href=\"/signup\">Sign up</></p>\n" +
                "    </form>\n");
        out.println(loginView.getHtml());

    }

    @Override
    public void init() throws ServletException {
        super.init();
        //set path
        String path = getServletContext().getRealPath("/html/");
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        indexSingleton.setHtmlPath(path);
        indexSingleton.setPage("index.html");

    }
}
