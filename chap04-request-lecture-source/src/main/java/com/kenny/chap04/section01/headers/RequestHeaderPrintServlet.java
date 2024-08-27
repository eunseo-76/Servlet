package com.kenny.chap04.section01.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/headers")
public class RequestHeaderPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        // Enumeration : Iterator의 구 버전. 다음 값이 있는지 확인하여, 다음 값이 있으면 가져옴
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }

        System.out.println("accept : " + req.getHeader("accept"));
        System.out.println("accept-encoding : " + req.getHeader("accept-encoding"));
        System.out.println("accept-language : " + req.getHeader("accept-language"));
        System.out.println("connection : " + req.getHeader("connection"));
        System.out.println("host : " + req.getHeader("host"));
        System.out.println("referer : " + req.getHeader("referer"));
        System.out.println("sec-fetch-dest : " + req.getHeader("sec-fetch-dest"));
        System.out.println("sec-fetch-mode : " + req.getHeader("sec-fetch-mode"));
        System.out.println("sec-fetch-site : " + req.getHeader("sec-fetch-site"));
        System.out.println("sec-fetch-user : " + req.getHeader("sec-fetch-user"));
        System.out.println("cache-control : " + req.getHeader("cache-control"));
        System.out.println("upgrade-insecure-requests : " + req.getHeader("upgrade-insecure-requests"));
        System.out.println("user-agent : " + req.getHeader("user-agent"));
    }
}
