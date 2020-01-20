package com.example.blog.service;

import com.example.blog.entity.vo.RegisterForm;
import com.example.blog.entity.vo.ResponseVO;
import com.example.blog.entity.vo.UserVO;

public interface AccountService {
    /**
     * 注册，登录等用户相关的服务
     */
    ResponseVO register(RegisterForm registerForm);
    UserVO getUserVOByUsername(String username);
    ResponseVO login(String username, String password);
}
