package com.liang.gateway.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用于登录成功后进来授权的
 *
 */
@Service
@AllArgsConstructor
public class SpringDataUserDetailsServiceImpl implements UserDetailsService {

//    private IUserService userService;
//    private IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*//查询数据库的用户
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lambda().eq(User::getAccount, username);
        User user = userService.getOne(qw);
        if (Objects.isNull(user)) {
            //没有查到用户交给provider来抛异常
            return null;
        }
        Role role = roleService.getById(user.getRoleId());
        //设置red缓存 需修改

        //授权 这里是返回的数据 TokenLoginFilter中这个方法successfulAuthentication
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getAccount())
//                .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                .password(user.getPassword())
//                .authorities(role.getRoleAlias())
                .authorities("ROLE_" + role.getRoleAlias())
                .build();
        return userDetails;*/



        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername("admin")
//                .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                .password("admin")
//                .authorities(role.getRoleAlias())
                .authorities("ROLE_administrator")
                .build();
        return userDetails;
    }

}
