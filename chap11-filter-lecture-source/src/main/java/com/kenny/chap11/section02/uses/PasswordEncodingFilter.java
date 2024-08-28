package com.kenny.chap11.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.IOException;

@WebFilter("/member/*") // member로 시작하는 모든 요청에 대해 이 필터를 타게 하겠다
public class PasswordEncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 이쪽으로 넘어온 servletRequest를 wrapper 클래스로 감싼다.
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        RequestWrapper requestWrapper = new RequestWrapper(request);

        // member와 관련한 기능은 기존 requeset 객체를 RequestWrapper 객체로 감싸서 서블릿으로 전달한다.
        // RequestWrapper에서 오버라이딩한 메소드가 기능하게 된다.
        filterChain.doFilter(requestWrapper, servletResponse);

    }
}


// 클라 ----req-----> 서버 [  filter[ ]  servlet[ ]  ]
// 원래는 req 한 정보가 servletRequest로 넘어가는데,
// 이를 필터를 통과하면서 requestWrapper로 감싸서 넘김.
// doPost에서는 기존의 getParameter가 아니라 requestWrapper에서 재정의한(override) getParameter를 호출하게 됨.