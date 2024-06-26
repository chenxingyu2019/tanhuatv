package com.itaeima;

import com.google.gson.Gson;
import com.itheima.entity.User;
import com.itheima.jellyfinApplication;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {jellyfinApplication.class})
public class TestClass {

    @Test
    public void test01(){
        System.out.println("00");
    }

    @Test
    public void test02(){
        Gson gson = new Gson();
        User user = new User();
        user.setUsername("asaobaochen");
        user.setPassword("asaobaochen");
        user.setEmail("tanglinlichen@gmail.com");
        String s = gson.toJson(user);
        System.out.println(s);

    }

}
