package com.conference.controllers;

import com.conference.views.IndexSingleton;
import com.conference.views.SignupView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignupServlet", urlPatterns ={"/signup"})
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        SignupView signupView = new SignupView();
        out.println(signupView.getHtml());
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
