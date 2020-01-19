package com.example.blog.configuration;

import com.example.blog.dao.RoleMapper;
import com.example.blog.dao.UserMapper;
import com.example.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final
    UserMapper userMapper;
    private final RoleMapper roleMapper;

    @Autowired
    public MyUserDetailsService(UserMapper userMapper, RoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.selectUserByUserName(s);
        if(user == null) throw new UsernameNotFoundException("用户不存在");
        List<SimpleGrantedAuthority> auths = new ArrayList<>(2);
        String role = roleMapper.selectByPrimaryKey(user.getRoleId()).getAttribute();
        SimpleGrantedAuthority adminAuth = new SimpleGrantedAuthority(roleMapper.selectByPrimaryKey(1).getAttribute());
        SimpleGrantedAuthority userAuth = new SimpleGrantedAuthority(roleMapper.selectByPrimaryKey(2).getAttribute());
        if(role.equals(roleMapper.selectByPrimaryKey(1).getAttribute())){
            auths.add(adminAuth);
            auths.add(userAuth);
        }else{
            auths.add(userAuth);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),auths);
    }
}
