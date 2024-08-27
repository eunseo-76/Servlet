package com.kenny.chap05.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;

@WebServlet("/headers")
public class ResponseHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");   // 한글값이 깨지지 않도록
//        resp.setHeader("Refresh", "1"); // 1초마다 refresh
        PrintWriter writer = resp.getWriter();  // 출력을 위해 출력 스트림 생성
        long currentTime = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<head>")
                .append("<title>응답 페이지</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append(currentTime)
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        writer.print(sb);
        writer.flush();
        writer.close();

        /* response header 정보 */
        Collection<String> responseHeader = resp.getHeaderNames();
        for(String headerName : responseHeader) {
            System.out.println(headerName + " : " + resp.getHeader(headerName));
        }
    }
}
