package com.t4er.config.interceptor;

import com.t4er.domain.member.Role;
import com.t4er.dto.admin.AdminCheckDto;
import com.t4er.session.SessionConst;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        HttpSession session = request.getSession();

        AdminCheckDto checkDto = new AdminCheckDto();
        if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            response.sendRedirect("/login?redirectURL=" + requestURI);
            if (checkDto.getRole() != Role.ADMIN) {
                response.sendRedirect("/");
                return false;
            }
        }

        return true;
    }
}
