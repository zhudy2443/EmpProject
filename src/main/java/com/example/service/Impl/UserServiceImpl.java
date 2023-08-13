package main.java.com.example.service.Impl;

import main.java.com.example.dao.Impl.UserDaoImpl;
import main.java.com.example.dao.UserDao;
import main.java.com.example.pojo.User;
import main.java.com.example.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username)==null){
            //等于null，表示没查到，没查到表示可用
            return false;
        }
        return true;
    }
}
