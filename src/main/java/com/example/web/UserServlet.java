package main.java.com.example.web;

import main.java.com.example.pojo.User;
import main.java.com.example.service.Impl.UserServiceImpl;
import main.java.com.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    /**
     * 处理登录的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null,username,password,null));
        // 如果等于 null,说明登录 失败!
        if (loginUser==null){
            //把错误信息,和回显的表单项信息,保存到Request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            // 跳回登录页面
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else{
            // 登录 成功
            // 跳到成功页面 login_success.jsp
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

    /**
     * 处理注册的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
            if (userService.existsUsername(username)) {
                //把错误信息,和回显的表单项信息,保存到Request域中
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",username);

                System.out.println("用户名[" + username + "]已存在!");
                // 跳回注册页面
                req.getRequestDispatcher("regist.jsp").forward(req, resp);
            } else {
                // 可用
                // 调用 Sservice 保存到数据库
                userService.registUser(new User(null, username, password, null));
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
}
