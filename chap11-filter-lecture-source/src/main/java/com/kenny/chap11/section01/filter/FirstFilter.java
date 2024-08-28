package com.kenny.chap11.section01.filter;

import jakarta.servlet.*;   // Filter 구현 시 jakarta.servlet!
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

// doFilter 반드시 구현해야 함
@WebFilter("/first/*")  // 필터 등록 어노테이션 - 어떤 요청을 가로채는지
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init 호출");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // req, resp를 가공하려면 각 객체를 사용

        /* 서블릿 호출 전 전처리 코드 */
        System.out.println("Filter doFilter 호출 - 전처리");

        /* 필터에서 전처리가 끝나면 다음 필터 또는 서블릿을 호출하는 코드이다. */
        filterChain.doFilter(servletRequest, servletResponse);  // 이 기능이 반드시 있어야 함

        /* 서블릿 호출 후 후처리 코드*/
        System.out.println("서블릿 요청 수행 완료 - 후처리");
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy() 호출");
    }
}

// Filter 구현 후 필터가 특정 요청을 가로채기 하면 doFilter 실행