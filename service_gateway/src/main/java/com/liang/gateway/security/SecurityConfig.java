//package com.liang.gateway.security;
//
//import com.liang.gateway.token.TokenAuthenticationFilter;
//import com.liang.gateway.token.TokenLoginFilter;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
//import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
////AOP:拦截器
//@EnableWebSecurity
//@AllArgsConstructor
//@Component
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private DefaultPasswordEncoder defaultPasswordEncoder;
//    private UserDetailsService userDetailsService;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // 设置权限大小
//    @Bean
//    RoleHierarchy roleHierarchy() {
//        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
//        hierarchy.setHierarchy("ROLE_administrator > ROLE_liang");
////        hierarchy.setHierarchy("administrator > user");
//        return hierarchy;
//    }
//
//    //授权
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //首页所有人都可以访问，功能页只有对应有权限的人才能访问
//        http.authorizeRequests()
//                //首页开放所有人可访问creat_ip
//                .antMatchers("/", "/login", "/api/login","/api/system/user/register").permitAll()
//                .antMatchers("/api/**").hasRole("administrator")
//                .antMatchers("/api/**").hasRole("liang");
//
////        http.formLogin()
//////                .loginPage("/toLogin") //设置跳转到的登录页面
////                .usernameParameter("account") //设置验证表单输入框的‘name’属性为 ‘username’ 为验证的用户名
////                .passwordParameter("password") //设置验证表单输入框的‘name’属性为 ‘password’ 为验证的用户名
////                .loginProcessingUrl("/api/login"); //设置处理登录请求路径
//        http.formLogin().loginProcessingUrl("/api/login");
//        http.exceptionHandling()
//                //未授权处理
//                .authenticationEntryPoint(new UnauthorizedEntryPoint())
//                .and().authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable()//这个必须开启不然报403
//                .logout().logoutUrl("/api/logout")
//                .logoutSuccessUrl("/")
////                .deleteCookies("token")
//                .and()
//                //addLogoutHandler(new TokenLogoutHandler(tokenManager))
//                .addFilter(new TokenLoginFilter(authenticationManager()))           //登录过滤，设置登录的url，对应的账户密码等
//                .addFilter(new TokenAuthenticationFilter(authenticationManager()))  //指定验证token的类
//                .httpBasic();
//        //.deleteCookies("remove").invalidateHttpSession(true) 移除所有Cookies 清空所有session
////        http.csrf().disable();  //关闭csrf功能  防止网站工具：get，post
////        http.logout().logoutSuccessUrl("/");    //注销,开启注销功能，跳到首页
//
//        //开启记住我功能 cookie,默认保存两周，自定义接收前端的参数
//        //http.rememberMe().rememberMeParameter("remember");
//    }
//
//
//    // 密码处理
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(defaultPasswordEncoder);
//    }
//
//
//    // 配置哪些请求不拦截
//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers(
////                "/login",//这里配置了的话就拦截不到这个请求了
//                "/api/test/**"
//        );
//    }
//}
