package com.kenny.chap01.section01.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

// WAS 서버에서 사용자의 요청을 처리하는 객체 : Servlet 객체
// Servlet 객체를 만들기 위해 HttpServlet을 상속받는다.
// HttpServlet은 GenericServlet을 상속한다. (GenericServlet <- HttpServelt)
// 추후 Http가 아닌 다른 형태의 프로토콜의 Servlet을 구현해야할 수 있으므로(GenericServlet <- XXXXServlet) 유지보수를 위해 GenericServlet을 상속받게 함

public class LifeCycleTest extends HttpServlet {
    // 생성자, init, service, destroy override

    /* 기본 생성자 */
    public LifeCycleTest() {
        System.out.println("xml 매핑 생성자 호출");
    }

    /* init : 최초 서블릿 요청 시 객체를 생성하며 초기화 작업을 할 수 있는 메소드 */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("xml 매핑 init 호출");
    }

    /* destroy: 컨테이너가 종료될 때 호출되는 메소드로 주로 자원을 반납하는 용도로 사용되는 메소드 */
    @Override
    public void destroy() {
        System.out.println("xml 매핑 destroy 호출");
    }

    /* 서블릿 컨테이너에 의해 호출되며 최초 요청 시에는 init 이후 동작, 두 번째 요청부터는 init 없이 바로 동작하는 메소드 */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("xml 매핑 service 호출");
    }
}

// 매핑 방법
// 1) web.xml에 servlet을 등록하고 매핑한다
// 2) 어노테이션을 이용한다.