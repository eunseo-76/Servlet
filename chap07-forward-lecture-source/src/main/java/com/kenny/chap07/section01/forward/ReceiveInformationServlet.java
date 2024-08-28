package com.kenny.chap07.section01.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward") // forward 요청이 발생했을 때 이 servlet과 매핑한다.
public class ReceiveInformationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        /* id와 pwd에 해당하는 user의 정보를 select 하고 오는 비즈니스 로직이 수행되어야 한다.
        * 해당 로직이 정상 수행되었다는 가정 하에 'XXX님 환영합니다' 와 같은 메세지 출력 화면을 응답한다.
        * */
        // 이전 실습과 달리 메세지 출력을 다른 서블릿에서 수행한다.

        req.setAttribute("userName", "홍길동");    // 조회된 이름으로 가정 (비즈니스 로직은 생략했기 때문)

        /* 다른 서블릿으로 forward */
        RequestDispatcher rd = req.getRequestDispatcher("print");
        rd.forward(req, resp);  // dopost에서 forward 되었으므로 print에서도 dopost로


    }


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//    }
}

// mapping에 대한 servlet이 존재 하지 않는 경우(@webservlet("/forward") 없음) - 404
// post 요청을 보냈는데 dopost가 없는 경우 - 405 에러
// 405 : 허용되지 않는 메소드 (get만 구현이 되어있는데 post로 요청을 한 경우 발생) - 클라이언트에서 제공하지 않는 방식으로 요청을 하면 발생한다.