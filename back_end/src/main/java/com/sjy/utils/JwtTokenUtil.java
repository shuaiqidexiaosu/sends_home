package com.sjy.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sjy.entity.User;

import java.util.Date;

public class JwtTokenUtil {
    // token私钥
    private static final String TOKEN_SECRET = "苏健尧真帅";

    // token过期时长30分钟
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000; // 单位为毫秒


    /**
     * 生成用户token,设置token超时时间
     *
     * @return 生成的token
     */
    public static String createToken(User user) {
        String token = null;
        try {
            // 设置过期时间
            Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 生成 JWT Token
            token = JWT.create()
                    .withClaim("userId", user.getUserId())
                    .withIssuer("auth0") // 签发者
                    .withExpiresAt(expireDate) //超时设置,设置过期的日期
                    .withIssuedAt(new Date()) //签发时间
                    .sign(Algorithm.HMAC256(TOKEN_SECRET)); //SECRET加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 检验token是否正确
     *
     * @param token 需要校验的token
     * @return 校验是否成功
     */
    public static boolean verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
//            System.err.println("认证通过：");
//            System.err.println("userId: " + jwt.getClaim("userId").asString());
//            System.err.println("过期时间：      " + jwt.getExpiresAt());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /*
     * 获取当前Token
     */
//    public static String getCurrentToken() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String token = request.getHeader("token");
//        return token;
//    }
}

