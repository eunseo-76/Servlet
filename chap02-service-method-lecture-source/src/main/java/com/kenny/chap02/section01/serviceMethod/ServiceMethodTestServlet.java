package com.kenny.chap02.section01.serviceMethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/request-service") // index.jsp에 작성한 요청 주소와 동일해야 함
public class ServiceMethodTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /* Http 프로토콜의 정보를 담고 있는 타입으로 다운캐스팅 한다. */
        // 더 구체적인 하위 타입인 httpservlet으로 다운캐스팅함
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String httpMethod = request.getMethod();    // 요청 받은 http 메소드가 어떤 메소드인지 판단한다.
        System.out.println("httpMethod: " + httpMethod);

        if ("GET".equals(httpMethod)) {
            doGet(request, response);
        } else if ("POST".equals(httpMethod)) {
            doPost(request, response);
        }

    }
}
