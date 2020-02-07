package com.anTools.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    //过期时间设置(30分钟)
    private static final long EXPIRE_TIME = 30 * 60 * 1000;

    //私钥设置------随便乱写的
    private static final String TOKEN_SECRET = "ASuKiN7AwIys0ZanZxc";

    public static String creatToken(Integer id, String openid, String role) {
        //头部信息
        Map<String, Object> header = new HashMap<String, Object>(2);
        header.put("typ","JWT");
        header.put("alg","HS256");

        return JWT.create()
                .withHeader(header)
                .withClaim("id", id)
                .withClaim("openId", openid)
                .withClaim("role", role)
                .withClaim("lastLoginDate", new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .sign(Algorithm.HMAC256(TOKEN_SECRET));
    }

    public static Claim getTokenData(String token, String name) {
        return JWT.decode(token).getClaim(name);
    }

}
