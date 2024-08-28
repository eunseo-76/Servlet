package com.kenny.chap08.section01.othersite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/othersite")
public class OtherSiteRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청 후 naver site로 redirect");
        resp.sendRedirect("https://www.naver.com");

    }
}

// http://localhost:8080 (ip:port number)
// 일반적인 웹 사이트의 url은 도메인을 사용함. dns 서버에 ip를 요청한다.