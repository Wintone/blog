package com.study.blog.util.uid;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.SecureRandom;
import java.util.Arrays;

public class MD5Util {

    /*
    生成随机盐
     */
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[15];
        random.nextBytes(bytes);
        String salt = Base64.encodeBase64String(bytes);
        System.out.println("salt:" + salt);
        System.out.println("bytes:" + Arrays.toString(bytes));
        return salt;
    }

    public static void main(String[] args) {
        System.out.println(generateSalt());
    }
}
