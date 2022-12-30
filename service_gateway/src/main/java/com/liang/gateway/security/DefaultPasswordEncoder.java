//package com.liang.gateway.security;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
///**
// * 密码处理，登录时的处理
// *
// */
//@Component
//@Slf4j
//public class DefaultPasswordEncoder extends BCryptPasswordEncoder {
//
//    @Override
//    public String encode(CharSequence rawPassword) {
//        return rawPassword.toString();
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        if (rawPassword == null) {
//            throw new IllegalArgumentException("rawPassword cannot be null");
//        }
//        if (encodedPassword == null || encodedPassword.length() == 0) {
//            log.error("Empty encoded password");
//            throw new IllegalArgumentException("encodedPassword is null");
//        }
//        return encodedPassword.equals(rawPassword);
//    }
//}
