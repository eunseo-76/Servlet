package com.kenny.chap11.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/* 필터 등록 web.xml(배포 서술자)에서 처리한다. */
// 어노테이션으로도 가능
public class EncodingFilter implements Filter {

    private String encodingType;
    // init은 꼭 없어도 됨
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 매개변수 : filterConfig - web.xml에서 설정한 초기값이 넘어온다.
        //  UTF-8 이라는 정보가 encodingType에 저장된다.
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    // filter 구현 시 필수적으로 작성해야 하는 doFilter
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // POST 방식의 요청일 경우 문자 셋을 설정하는 전처리 코드
        HttpServletRequest request = (HttpServletRequest) servletRequest;   // 상위 타입인 servletRequest에서 구체적인 타입으로 다운캐스팅
        if("POST".equals(request.getMethod())) servletRequest.setCharacterEncoding(encodingType);   // post 방식인 경우 인코딩 (get 방식은 url을 타고오므로 문자 셋의 변화 x)

        // 다음 필터 또는 서블릿 요청(필수)
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
