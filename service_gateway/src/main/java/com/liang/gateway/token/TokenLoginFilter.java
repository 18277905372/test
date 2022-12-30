//package com.liang.gateway.token;
//
//import com.liang.gateway.util.JwtTokenUtil;
//import com.liang.utils.other.ResponseUtil;
//import com.liang.utils.result.Result;
//import lombok.SneakyThrows;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//
///**
// * @Version 验证账户密码，指定登录url，返回token等操作
// */
//public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {
//    private AuthenticationManager authenticationManager;
//
//
//    /**
//     * 指定那个为登录页面，项目启动时就进行监听了
//     * @param authenticationManager
//     */
//    public TokenLoginFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//        this.setPostOnly(false);
//        this.setRequiresAuthenticationRequestMatcher(
//                new AntPathRequestMatcher("/api/login", "POST"));
//    }
//
//    /**
//     * 当登录时，先进来这里格式对应的用户名，密码
//     * @param req
//     * @param res
//     * @return
//     * @throws AuthenticationException
//     */
//    @SneakyThrows
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
//        try {
//            String username = req.getParameter("account");
//            String password = req.getParameter("password");
//            username = username != null ? username.trim() : "";
//            password = password != null ? password : "";
//            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>()));
//        } catch (Exception e) {
//            res.setStatus(500);
//            res.setContentType("text/html;charset=UTF-8");
//            PrintWriter writer = res.getWriter();
//            writer.write("{\"msg\":\"登录失败\"}");
//            return null;
//        }
//    }
//
//    /**
//     * 登录成功，用于登录成功后调用的方法，用于处理响应，（可返回token等）
//     * 用于给登录页面返回的数据
//     */
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
//        User user = (User) auth.getPrincipal();
//        String authrorities = user.getAuthorities().size() > 0 ? user.getAuthorities().toString().replaceAll("(?:\\[|null|\\]| +)", "") : user.getAuthorities().toString();
//
//        String token = JwtTokenUtil.createToken(user.getUsername(), authrorities);
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("token", token);
//        map.put("user", user);
//        map.put("authrorities", authrorities);
//        map.put("username", user.getUsername());
////        map.put("loginName", user.getUsername());
//        ResponseUtil.out(response, Result.ok(map));
//    }
//
//    /**
//     * 登录失败
//     */
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//        ResponseUtil.out(response, Result.error("登录失败"));
//    }
//}
//
