package com.kenny.chap11.section02.uses;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// servletrequestwrapper 클래스 상속받는 httpservletrequestwrapper 클래스

public class RequestWrapper extends HttpServletRequestWrapper {
    // 내가 감싸고 있을 requestwrapper를 생성자로 전달해야 함
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        // 비밀번호를 암호화시켜서 내보내기 위해 getParameter 오버라이딩

        String value = "";
        if ("password".equals(name)) {
            // 비밀번호 암호화 처리한 값으로 변경한다.
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter(name));

        } else {
            value = super.getParameter(name);   // 클라이언트에서 넘어온 값 그대로 처리한다.
        }
        return value;
    }
}
