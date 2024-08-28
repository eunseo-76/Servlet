package com.kenny.chap10.section02.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Enumeration<String> keys = session.getAttributeNames();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            System.out.println(key + " = " + session.getAttribute(key));
        }

        /* 세션 데이터를 제거하는 방법
        * 1. 설정 만료 시간이 지나면 세션 자동 만료
        * 2. removeAttribute() 로 속성 제거
        * 3. invalidate()로 세션의 모든 데이터 제거 (세션 무효화)
        * */

        System.out.println("=========================");
        session.removeAttribute("firstName");
        keys = session.getAttributeNames();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            System.out.println(key + " = " + session.getAttribute(key));
        }
        //특정 attr 제거. lastName만 출력됨

        System.out.println("=========================");
        session.invalidate();
        keys = session.getAttributeNames();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            System.out.println(key + " = " + session.getAttribute(key));
        }
        // 아무런 출력이 나오지 않고, 500 내부 서버 오류 발생 (세션을 무효화했는데 왜 다시 세션을 호출하니?)

    }
}
