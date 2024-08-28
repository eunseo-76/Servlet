package com.kenny.chap08.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/otherservlet")
public class OtherServletRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청 정상 수락");

        /* 비즈니스 로직 처리 후 */

        resp.sendRedirect("redirect");  // 이 주소로 이동하도록
    }
}
// index에서 2번째 a 태그 클릭했을 때 이 servlet으로 오도록
