package com.itheima.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users") // 指定表名为users
public class User {
    private String username;
    private String password;
    private String email;
    // 其他字段省略
}

