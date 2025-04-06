package com.divine.code.auth;



import com.divine.code.auth.utils.MD5Utils;

import java.util.Map;

public class AuthToken {


    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;

    private static final String SEPARATE = "@";

    private String token;

    private long createTime;

    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;


    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this(token, createTime);
        this.expiredTimeInterval = expiredTimeInterval;
    }


    public static AuthToken create(String baseUrl, long createTime, Map<String, Object> param) {
        // TODO... 创建AutoToken
        return null;
    }

    /**
     * 2、生成token
     *
     * @param originalUrl
     * @param appId
     * @param timestamp
     * @param password
     * @return {@link AuthToken}
     */
    public static AuthToken generate(String originalUrl, String appId, long timestamp, String password) {
        String token = generateTokenString(originalUrl, appId, timestamp, password);
        AuthToken authToken = new AuthToken(token, timestamp);
        return authToken;
    }


    /**
     * 1、拼接字符串
     *
     * @param originalUrl
     * @param appId
     * @param timestamp
     * @param password
     * @return {@link String}
     */
    public static String generateTokenString(String originalUrl, String appId, long timestamp, String password) {
        StringBuffer sb = new StringBuffer(originalUrl);
        sb.append(SEPARATE).append(appId);
        sb.append(SEPARATE).append(timestamp);
        sb.append(SEPARATE).append(password);
        return MD5Utils.md5(sb.toString());
    }


    /**
     * 供方法4 使用
     *
     * @return {@link String}
     */
    public String getToken() {
        return this.token;
    }

    /**
     * 3、检查是否过期
     *
     * @return boolean
     */
    public boolean isExpired() {
        return createTime + expiredTimeInterval < System.currentTimeMillis();
    }

    /**
     * 4、检查是否匹配
     *
     * @param authToken
     * @return boolean
     */
    public boolean match(AuthToken authToken) {
        return this.token.equals(authToken.getToken());
    }

}
