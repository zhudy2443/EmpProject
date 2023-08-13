package main.java.com.example.test;

import main.java.com.example.pojo.User;
import main.java.com.example.service.Impl.UserServiceImpl;
import main.java.com.example.service.UserService;
import org.junit.Test;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    
    @Test
    public void registUser(){
        userService.registUser(new User(null, "bbj16813", "666666", null));
        userService.registUser(new User(null, "abc16824", "666666", null));
    }

    @Test
    public void login() {
        System.out.println( userService.login(new User(null, "wsc123", "123456", null)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("wzg16888")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }

}
