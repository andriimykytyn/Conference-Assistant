package com.conference.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IndexSingleton {

    private String htmlPath;
    private String page;
    private String header;
    private String login;
    private String register;
    private String questions;
    private String conferences;

    private static IndexSingleton ourInstance = new IndexSingleton();

    public static IndexSingleton getInstance() {
        return ourInstance;
    }

    private IndexSingleton() {
    }

    public String getHtmlPath() {
        return htmlPath;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getConferences() {
        return conferences;
    }

    public void setConferences(String conferences) {
        this.conferences = conferences;
    }

    public String getQuestions() {
        return questions;
    }

    public void setHtmlPath(String htmlPath) {
        this.htmlPath = htmlPath;
        this.page = getPartialHtml("/index.html");
        this.header = getPartialHtml("/header.html");
        this.login = getPartialHtml("/login.html");
        this.register = getPartialHtml("/register.html");
        this.questions = getPartialHtml("/questions.html");
        this.conferences = getPartialHtml("/conferences.html");
    }

    public String getPartialHtml(String filename) {
        StringBuilder strb = new StringBuilder();
        Path file = Paths.get(this.htmlPath + filename);
        Charset charset = Charset.forName("UTF-8");

        try(BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                strb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return strb.toString();
    }
}
