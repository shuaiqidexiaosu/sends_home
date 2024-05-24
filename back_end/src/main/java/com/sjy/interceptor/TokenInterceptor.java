package com.sjy.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.sjy.res.ReturnCode;
import com.sjy.utils.JwtTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Controller
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token"); //前端vue将token添加在请求头中
        if (token != null) {
            if (JwtTokenUtil.verify(token)) {
                System.out.println("通过拦截器");
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            JSONObject json = new JSONObject();
            json.put("msg", "token认证失败");
            json.put("code", ReturnCode.FAIL.getCode());
            response.getWriter().append(json.toJSONString());
            System.out.println("认证失败，未通过拦截器");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }
}
