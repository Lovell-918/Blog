package com.example.blog.service.impl;

import com.example.blog.dao.UserMapper;
import com.example.blog.entity.User;
import com.example.blog.entity.vo.RegisterForm;
import com.example.blog.entity.vo.ResponseVO;
import com.example.blog.entity.vo.UserVO;
import com.example.blog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final UserMapper userMapper;

    @Autowired
    public AccountServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public ResponseVO register(RegisterForm registerForm) {
        if(userMapper.selectUserByUserName(registerForm.getUsername())!=null){
            return ResponseVO.fail("用户已存在");
        }
        if(!registerForm.getPassword1().equals(registerForm.getPassword2())){
            return ResponseVO.fail("两次输入的密码不一致");
        }
        User user = new User();
        user.setUsername(registerForm.getUsername());
        user.setNickname(registerForm.getNickname());
        user.setPassword(registerForm.getPassword1());
        if(user.getUsername().equals("admin")) user.setRoleId(1);
        else user.setRoleId(2);
        if(userMapper.insertSelective(user)==0){
            return ResponseVO.fail("注册失败");
        }
        return ResponseVO.success();
    }

    @Override
    public UserVO getUserVOByUsername(String username) {
        User user = userMapper.selectUserByUserName(username);
        if(user == null) return null;
        return new UserVO(user.getUsername(),user.getNickname(),user.getPassword());
    }
}
