package com.conference.views;

public abstract class BaseView {

    private String htmlTop = "<!doctype html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <!-- Required meta tags -->\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
            "\n" +
            "    <!-- Bootstrap CSS -->\n" +
            "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n" +
            "\n" +
            "    <!-- Custom styles for this template -->\n" +
            "    <link href=\"/css/signin.css\" rel=\"stylesheet\">\n" +
            "    <link href=\"/css/sticky-footer-navbar.css\" rel=\"stylesheet\">\n" +
            "    <title>###title###</title>\n" +
            "</head>\n" +
            "<body>\n";

    private String htmlBottom = "<!-- Optional JavaScript -->\n" +
            "<!-- jQuery first, then Popper.js, then Bootstrap JS -->\n" +
            "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" +
            "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n" +
            "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n" +
            "</body>\n" +
            "</html>";

    private String htmlHeader = "<header>\n" +
            "    <!-- Fixed navbar -->\n" +
            "    <nav class=\"navbar navbar-expand-md navbar-dark fixed-top bg-dark\">\n" +
            "        <a class=\"navbar-brand\" href=\"#\">CAssistant</a>\n" +
            "        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\" aria-controls=\"navbarCollapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
            "            <span class=\"navbar-toggler-icon\"></span>\n" +
            "        </button>\n" +
            "        <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\n" +
            "            <ul class=\"navbar-nav mr-auto\">\n" +
            "                <li class=\"nav-item active\">\n" +
            "                    <a class=\"nav-link\" href=\"#\">Conferences <span class=\"sr-only\">(current)</span></a>\n" +
            "                </li>\n" +
            "                <li class=\"nav-item\">\n" +
            "                    <a class=\"nav-link\" href=\"#\">Reports</a>\n" +
            "                </li>\n" +
            "                <li class=\"nav-item\">\n" +
            "                    <a class=\"nav-link\" href=\"#\">Questions</a>\n" +
            "                </li>\n" +
            "            </ul>\n" +
            "            <a class=\"btn btn-light\" my-2 my-sm-0\">Sign in</a>\n" +
            "        </div>\n" +
            "    </nav>\n" +
            "</header>\n";

    private String content;


    public String getHtmlTop() {
        return htmlTop;
    }

    public void setHtmlTop(String htmlTop) {
        this.htmlTop = htmlTop;
    }

    public String getHtmlBottom() {
        return htmlBottom;
    }

    public void setHtmlBottom(String htmlBottom) {
        this.htmlBottom = htmlBottom;
    }

    public String getHtmlHeader() {
        return htmlHeader;
    }

    public void setHtmlHeader(String htmlHeader) {
        this.htmlHeader = htmlHeader;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.htmlTop = this.htmlTop.replace("###title###", title);
    }

    public String getHtml() {
        return this.getHtmlTop() +
                this.getHtmlHeader() +
                this.getContent() +
                this.getHtmlBottom();
    }
}