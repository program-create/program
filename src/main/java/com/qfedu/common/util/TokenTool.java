package com.qfedu.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取token【APP端、PC端通用】
 */
public class TokenTool {
    public static String getToken (HttpServletRequest request) {
        String token = CookieUtil.getCk(request, "token");
        if (token == null || token.length() < 1) {
            String t = (String) request.getParameter("token");
            if (t == null || t.length() < 1) {
                return null;
            } else {
                return t;
            }
        }
        return token;
    }

}
