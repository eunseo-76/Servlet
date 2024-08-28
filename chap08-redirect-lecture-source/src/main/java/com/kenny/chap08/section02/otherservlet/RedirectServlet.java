package com.kenny.chap08.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("이 servlet으로 redirect 완료! ^_^a");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>이 서블릿으로 redirect 완료!</h1>");
        out.flush();
        out.close();
    }
}

// redirect 요청은 무조건 get 방식 (브라우저가 가지고 있는 주소값을 변경하라는 요청이기 때문)
// 브라우저에 주소를 적어서 enter 치는 것은 get 방식의 요청임