package com.hz.gc.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author helen
 * @since 2019/10/16
 */
public class JwtUtils {

    public static final long EXPIRE = 1000 * 60 * 60 * 24; // token的过期时间
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO"; //密钥

    // 生成字符串的方法
    public static String getJwtToken(String userName, String id){

        String JwtToken = Jwts.builder()
                // 1 生成JWT的头部分
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")

                // 设置过期时间部分
                .setSubject("soms_fiveGroup")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))

                // 2 设置token的主体部分,存储用户的信息
                .claim("userName", userName)
                .claim("userId", id)

                // 3 生成token的签名哈希(防伪标志)
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

                    return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if(StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取会员id,从token字符串中获取用户信息
     * @param request
     * @return
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if(StringUtils.isEmpty(jwtToken)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
         // 主体是按照key,value的形式存放,要取哪一部分的主体就get哪一部分的key
        return (String)claims.get("userName");
    }
}
