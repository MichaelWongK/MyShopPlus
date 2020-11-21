package com.micheal.myshop.plus.business.service;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author <a href="mailto:wangmk13@163.com">micheal.wang</a>
 * @date 2020/11/19 22:34
 * @Description
 */
@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final String username = "admin";

    public static final String password = "$2a$10$5V18ymgmsQwFX9umcRw.1eHKSG.8tG31ZVQcXkgVSPICR9TQ06i0S";

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        // 用户名匹配
        if (s.equals(username)) {
            List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
            grantedAuthorities.add(grantedAuthority);
            return new User(username, password, grantedAuthorities);
        }
        return null;
    }
}
