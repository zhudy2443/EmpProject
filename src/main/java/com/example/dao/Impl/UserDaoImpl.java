package main.java.com.example.dao.Impl;

import main.java.com.example.dao.UserDao;
import main.java.com.example.pojo.User;
import main.java.com.example.utils.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`) values(?,?)";
        return update(sql,user.getUsername(),user.getPassword());
    }
}
