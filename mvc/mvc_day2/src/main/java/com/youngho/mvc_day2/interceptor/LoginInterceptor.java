package com.youngho.mvc_day2.interceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Objects;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {

        Cookie[] cookies = request.getCookies();

        if (Objects.nonNull(cookies)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase("Login")) {
                    String value = cookie.getValue();
                    if (Objects.nonNull(value)) {
                        return true;
                    }
                }
            }
        }

        response.sendRedirect("/login");
        return false;
    }
}
