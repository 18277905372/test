//package com.liang.gateway.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SecurityAuthenticationConfig {
//    @Autowired
//    AuthenticationManagerBuilder aut;
//
//    private static AuthenticationManager am = new SampleAuthenticationManager();
//
//    /**
//     * 授予用户临时权限，退出后就没有了，没有添加到令牌器中
//     */
//    public void getToke(String username, String password) {
//        try {
//            Authentication request = new UsernamePasswordAuthenticationToken(username, password);
//            Authentication result = am.authenticate(request);
//            SecurityContextHolder.getContext().setAuthentication(result);
//        } catch (AuthenticationException e) {
//            System.out.println("Authentication failed: " + e.getMessage());
//        }
//
//        System.out.println("Successfully authenticated. Security context contains: " +
//                SecurityContextHolder.getContext().getAuthentication());
//    }
//}
//
//class SampleAuthenticationManager implements AuthenticationManager {
//    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<>();
//
//    static {
//        AUTHORITIES.add(new SimpleGrantedAuthority("liang"));
//        AUTHORITIES.add(new SimpleGrantedAuthority("root"));
//        AUTHORITIES.add(new SimpleGrantedAuthority("administrator"));
//    }
//
//    public Authentication authenticate(Authentication auth) throws AuthenticationException {
//        if (auth.getName() != null && auth.getCredentials() != null) {
//            return new UsernamePasswordAuthenticationToken(auth.getName(),
//                    auth.getCredentials(), AUTHORITIES);
//        }
//        throw new BadCredentialsException("Bad Credentials");
//    }
//
//}
