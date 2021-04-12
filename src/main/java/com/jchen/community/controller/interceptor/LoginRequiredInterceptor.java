package com.jchen.community.controller.interceptor;

import com.jchen.community.annotation.LoginRequired;
import com.jchen.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 利用拦截器拦截带有注解的方法，检查登陆状态，如果未登录拒绝访问
 * @Auther: jchen
 * @Date: 2021/03/30/10:07
 */
@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    private HostHolder hostHolder;

    /**
     * 在到达Controller层之前会检查登陆状态，如果未登录重定向到登陆页面
     * @param handler 通过handler获取带注解的方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
            if (loginRequired != null && hostHolder.getUser() == null) {//未获取到当前登录用户，证明未登录
                response.sendRedirect(request.getContextPath() + "/login"); //重定向到登陆页面
                return false;
            }
        }
        return true;
    }
}
