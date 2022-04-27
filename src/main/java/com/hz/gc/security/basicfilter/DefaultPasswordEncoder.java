package com.hz.gc.security.basicfilter;

import com.hz.gc.utils.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultPasswordEncoder implements PasswordEncoder {

    /**
     *  对密码进行加密
     * @param rawPassword 原始密码 例如: 123456
     * @return 返回加密后的密码
     */
    @Override
    public String encode(CharSequence rawPassword) {
        // 给到下面进行匹配
        return MD5.encrypt(rawPassword.toString());
    }

    /**
     *  进行匹配校验
     * @param rawPassword 原始密码
     * @param encodedPassword 存储中的密码,数据库查回来的.
     * @return 返回比对结果,若为true,则进入下一个filter
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return encodedPassword.equals(MD5.encrypt(rawPassword.toString()));
    }
}
