package com.kenny.chap06.section01.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/* Custom Error Page 작성 */
@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {
    // 에러 발생 시 커스텀 페이지를 이 servlet을 통해 작업하기

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // request 객체가 가지고 있는 parameter 외에도
        // 내부적으로 가지고 있는 속성(Attribute)이 있다.
        Enumeration<String> attrs = req.getAttributeNames();
        while (attrs.hasMoreElements()) {
            String attr = attrs.nextElement();
            System.out.println(attr + " : " + req.getAttribute(attr));  // 속성 key : 속성의 값 value
        }

        int statusCode = (int) req.getAttribute("jakarta.servlet.error.status_code");
        String message = (String) req.getAttribute("jakarta.servlet.error.message");
        String servletName = (String) req.getAttribute("jakarta.servlet.error.servlet_name");

        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<h1>")
                .append(statusCode)
                .append("-")
                .append(message)
                .append("</h1>")
                .append("<p>에러 발생 서블릿 명: ")
                .append(servletName)
                .append("</p>");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print(errorPage);
        out.flush();
        out.close();

    }

}
