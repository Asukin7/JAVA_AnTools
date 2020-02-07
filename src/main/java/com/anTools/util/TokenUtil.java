package com.anTools.util;

import com.anTools.entity.AnToken;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    //过期时间设置(30分钟)------可能有问题
    private static final long EXPIRE_TIME = 30 * 60 * 1000;

    //私钥设置------随便乱写的
    private static final String TOKEN_SECRET = "ASuKiN7AwIys0ZanZxc";

    public static String creatToken(String openid, String role) {
        AnToken anToken = new AnToken();
        anToken.setOpenId(openid);
        anToken.setRole(role);
        anToken.setLastLoginDate(new Date());

        return getToken(anToken);
    }

    public static String getToken(AnToken anToken) {
        //设置过期时间和加密算法
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

        //头部信息
        Map<String, Object> header = new HashMap<String, Object>(2);
        header.put("typ","JWT");
        header.put("alg","HS256");

        return JWT.create()
                .withHeader(header)
                .withClaim("openId",anToken.getOpenId())
                .withClaim("role",anToken.getRole())
                .withClaim("lastLoginDate",anToken.getLastLoginDate())
                .withExpiresAt(date)
                .sign(algorithm);
    }

    public static AnToken getTokenData(String token) {
        DecodedJWT jwt = JWT.decode(token);

        AnToken anToken = new AnToken();
        anToken.setOpenId(jwt.getClaim("openId").asString());
        anToken.setRole(jwt.getClaim("role").asString());
        anToken.setLastLoginDate(jwt.getClaim("lastLoginDate").asDate());

        return anToken;
    }

    public static String getTokenDataOpenId(String token) {
        return JWT.decode(token).getClaim("openId").asString();
    }

}
