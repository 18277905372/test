//package com.liang.gateway.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig1  {
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        //配置白名单和访问规则，CommonEnum枚举类
//        http.anonymous().authorities("/**", "/login", "/api/login","/api/system/user/register").and().authorizeExchange().anyExchange().permitAll();
////        http.anonymous().authorities("/api/**").and().authorizeExchange().anyExchange().hasAnyRole("administrator");
//
//        http.csrf().disable();
//        return http.build();
//    }
//}