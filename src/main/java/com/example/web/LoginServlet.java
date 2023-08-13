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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null,username,password,null));
        // 如果等于 null,说明登录 失败!
        if (loginUser==null){
            // 跳回登录页面
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else{
            // 登录 成功
            // 跳到成功页面 login_success.html
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
