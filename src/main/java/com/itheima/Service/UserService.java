package com.itheima.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.itheima.Mapper.UserMapper;
import com.itheima.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String username) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }

    public boolean registerUser(User user) {
        if (findByUsername(user.getUsername()) != null) {
            return false;
        }
        return userMapper.insert(user) > 0;
    }

    public boolean updatePassword(String username, String email, String newPassword) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username).eq("email", email));
        if (user != null) {
            user.setPassword(newPassword);
            return userMapper.updateById(user) > 0;
        }
        return false;
    }
}
