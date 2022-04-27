package com.hz.gc;

import com.hz.gc.dao.UserDao;
import com.hz.gc.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private UserDao userdao;


    @Test
    public void testBCry() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        /*String encode = passwordEncoder.encode("1001");
        //$2a$10$hS6.Hr2QhKKBlQLIDzgkaun30hjuo6DUrTIU2XAg2IpZbEvbMbZJ
        System.out.println("encode = " + encode);*/
        boolean matches = passwordEncoder.matches("1001", "$2a$10$FKKyjjwGfLIl5AcwDuzBce5I5q.tOvK2UlhqnJi6xitHR652fuNKq");
        System.out.println("matches = " + matches);
    }

    @Test
    public void testUserMapper(){
        List<User> users = userdao.selectList(null);
        System.out.println(users);
    }
}
