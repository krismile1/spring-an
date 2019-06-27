package com.ning.springboot.test;

/**
 * Create By : an
 * Time : 2019/2/14 9:54
 * Description :
 */
public class TestRegist {

    public String register(String username, String pwd, String confirm) {

        if (username.length() < 3) {
            return "用户名长度不能小于3";
        }
        if (pwd.equals(confirm)) {
            return "两部分必须相同";
        }
        return "注册成功";
    }
}
