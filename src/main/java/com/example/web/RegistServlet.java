package main.java.com.example.web;

import main.java.com.example.pojo.User;
import main.java.com.example.service.Impl.UserServiceImpl;
import main.java.com.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (userService.existsUsername(username)) {
            System.out.println("用户名[" + username + "]已存在!");
            // 跳回注册页面
            req.getRequestDispatcher("regist.jsp").forward(req, resp);
        } else {
            // 可用
            // 调用 Sservice 保存到数据库
            userService.registUser(new User(null, username, password,null));
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
