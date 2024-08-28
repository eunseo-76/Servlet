package com.kenny.assignmentservletloginform;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        StringBuilder sb = new StringBuilder();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("maru") && password.equals("maru1234")) {
            sb.append("<html>")
                    .append("<head>")
                    .append("<title>로그인 결과</title>")
                    .append("</head>")
                    .append("<body>")
                    .append("<h1>")
                    .append("로그인 성공!!! 뿌빠뿌빠 ^ㅁ^/")
                    .append("</h1>");
            // 이렇게 나눠서 안 써도 된다 ^^; .append("<html><body>") 다 붙여서 써도 됨
        } else {
            sb.append("<html>")
                    .append("<head>")
                    .append("<title>로그인 결과</title>")
                    .append("</head>")
                    .append("<body>")
                    .append("<h1>")
                    .append("로그인 실패!!!")
                    .append("</h1>")
                    .append("<h2>")
                    .append("사용자명 또는 비밀번호가 올바르지 않습니다.")
                    .append("</h2>")
                    .append("</body>")
                    .append("</html>");
        }
        pw.print(sb);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();  // 출력 스트림 생성

        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<head>")
                .append("<h1>")
                .append("무*적*엘*지 엘지 트윈스 샵")
                .append("</h1>")
                .append("<h2>")
                .append("마루는 강쥐 에디션 유니폼 판매!!! \\oOo/")
                .append("</h2>")
                .append("<form action=")
                .append("\"login\"")
                .append("method=post>")
                .append("<label>")
                .append("사용자명 : ")
                .append("</label>")
                .append("<input type=")
                .append("\"text\"")
                .append(" name =")
                .append(" \"username\">")
                .append("<br>")
                .append("<label>")
                .append("비밀번호 : ")
                .append("</label>")
                .append("<input type=")
                .append("\"text\"")
                .append(" name =")
                .append(" \"password\">")
                .append("<br>")
                .append("<input type =")
                .append("\"submit\"")
                .append("value =")
                .append("\"로그인\"")
                .append("</form>");

        resp.setContentType("text/html");

        pw.print(sb);
        pw.flush();
        pw.close();

    }
}
