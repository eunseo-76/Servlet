package com.kenny.chap03.section01.querystring;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/querystring") // 요청 주소
public class QueryStringTestServlet extends HttpServlet {

    /* 서블릿이 매핑된 주소로 GET 방식의 요청이 발생하면 doGet 메소드가 호출된다. */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* HttpServletRequest 객체로부터 요청 시 전달한 값을 getParameter 메소드로 추출할 수 있다.
        * 인자로 input 태그의 name 속성 값을 문자열 형태로 전달한다.
        * (모든 input 태그의 값을 hashmap으로 관리하고 있으므로 원하는 값을 찾기 위해 key 역할 문자열이 필요) */

        String name = req.getParameter("name"); // form 태그의 input의 name에 해당하는 값
        // getParameter의 반환 타입은 String 이므로 다른 형식은 parsing이 필요하다.
        int age = Integer.parseInt(req.getParameter("age"));
        java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));   // YYYY-MM-DD를 sql.Date로
        String gender = req.getParameter("gender");
        String national = req.getParameter("national");
        // checkbox는 다중으로 값을 입력 받을 수 있으므로 문자열 배열로 전달된다.
        // getParameterValues 메소드를 이용한다.
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("birthday: " + birthday);
        System.out.println("gender: " + gender);
        System.out.println("national: " + national);
        System.out.println("hobbies :" + Arrays.toString(hobbies));
    }
}

// Servlet LifeCycle
// Constructor 호출 -> init 호출 -> Service 메소드 호출 -> doXXX 호출 -> ... -> destroy
// 이 내용은 httpservlet에 모두 담겨있으므로 특별히 변경할 사항이 없다면 override 하지 않아도 된다.
// 실제 기능과 관련되어 있는 doXXX만 구현한다.

// 실제 http 통신은 byte 문자열로 이루어지지만, 이를 해석하여 httpservletrequest 라는 객체로 넘겨준다.(doGet의 매개변수)
