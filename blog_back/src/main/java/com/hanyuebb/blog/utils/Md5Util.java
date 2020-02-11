package com.hanyuebb.blog.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * ClassName:Md5Util
 * Package:com.hanyuebb.blog.utils
 * Description:
 *
 * @date:2020/2/9 15:59
 * @auther:zh
 */
public class Md5Util {

    /**
     * 加密方式
     */
    private static final String ALGORITHM_NAME = "MD5";

    /**
     * 默认盐值
     */
    private static final Object DEFAULT_SALT = "add1s.net";

    /**
     * 默认加密次数
     */
    private static final int DEFAULT_ITERATIONS = 1024;

    /**
     * 返回盐值
     *
     * @return private static final String SALT 盐值
     */
    public static Object getDefaultSalt() {
        return DEFAULT_SALT;
    }

    /**
     * 返回加密次数
     *
     * @return private static final int HASHITERATIONS 加密次数
     */
    public static int getDefaultIterations() {
        return DEFAULT_ITERATIONS;
    }

    /**
     * MD5加密
     *
     * @param source 待加密源数据
     * @return md5's string
     */
    public static String md5String(String source) {
        return new SimpleHash(ALGORITHM_NAME, source, DEFAULT_SALT, DEFAULT_ITERATIONS).toString();
    }

    /**
     * MD5加密
     *
     * @param source 待加密源数据
     * @param salt 盐值
     * @return md5's string
     */
    public static String md5String(String source, Object salt) {
        return new SimpleHash(ALGORITHM_NAME, source, salt, DEFAULT_ITERATIONS).toString();
    }

    /**
     * MD5加密
     *
     * @param source 待加密源数据
     * @param salt 盐值
     * @param iterations 加密次数
     * @return md5's string
     */
    public static String md5String(String source, String salt, int iterations) {
        return new SimpleHash(ALGORITHM_NAME, source, salt, iterations).toString();
    }
}