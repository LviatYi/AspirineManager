package com.lviat.util.authentic;

import com.lviat.model.RoleEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * Token 工具类.
 *
 * @author LviatYi
 * @version 1.0
 * @className Token
 * @date 2021/7/28
 */
public class TokenUtil {
    /**
     * token 有效时长.
     */
    private static final long TOKEN_EFFECTIVE_TIME;
    private static final String ISSUER;
    private static final String KEY;


    //类加载时初始化.
    //从 token.config 配置文件中获取相关属性.
    static {
        Properties properties = new Properties();
        InputStream inputStream = TokenUtil.class.getClassLoader().getResourceAsStream("token.config");
        try {
            properties.load(inputStream);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        TOKEN_EFFECTIVE_TIME = Long.parseLong(properties.getProperty("token_effective_time"));
        ISSUER = properties.getProperty("issuer");
        KEY = properties.getProperty("key");
    }

    /**
     * 创建 token.
     *
     * @param id            用户 id.
     * @param effectiveTime 有效时间.单位 ms.
     */
    public static String createToken(long id, int userType, long effectiveTime) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setIssuer(ISSUER)
                .setId(String.valueOf(id))
                .setSubject(String.valueOf(userType))
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, KEY);

        if (effectiveTime >= 0) {
            long expMillis = nowMillis + effectiveTime;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        return builder.compact();
    }

    /**
     * 创建 token.有效时间默认为 24 小时.
     *
     * @param id 用户 id.
     */
    public static String createToken(long id, int userType) {
        return createToken(id, userType, TOKEN_EFFECTIVE_TIME);
    }


    /**
     * 验证 jwt.
     *
     * @param token 待验证 token.
     * @param id    验证 User 的 id.
     * @param role  需要的 Role 权限.
     * @return 返回验证状态.
     * 当为 0 时,Token 解析失败.
     * 为 1 时,认证成功.
     * 为 2 时,超时.
     * 为 3 时,id 错误.
     * 为 4 时,issue 错误.
     * 为 5 时,权限不足.
     */
    public static int verifyToken(String token, long id, int role) {
        int verifyStatus = 1;
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(KEY)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return 0;
        }
        if (!claims.getIssuer().equals(ISSUER)) {
            verifyStatus = 4;
        } else if (!claims.getId().equals(String.valueOf(id))) {
            verifyStatus = 3;
        } else if (((Integer.parseInt(claims.getSubject()) & role) == 0)) {
            verifyStatus = 5;
        }

        return verifyStatus;
    }

    /**
     * 验证 jwt.
     * 不验证 Role.
     *
     * @param token 待验证 token.
     * @param id    验证 User 的 id.
     * @return 返回验证状态.
     */
    public static boolean verifyToken(String token, long id) {
        boolean verifyStatus = true;
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(KEY)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return false;
        }
        if (!claims.getIssuer().equals(ISSUER)) {
            verifyStatus = false;
        } else if (!claims.getId().equals(String.valueOf(id))) {
            verifyStatus = false;
        }

        return verifyStatus;
    }
}
