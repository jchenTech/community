package com.jchen.community.service;

import com.jchen.community.dao.UserMapper;
import com.jchen.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: jchen
 * @Date: 2021/03/28/14:23
 */
@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }
}
