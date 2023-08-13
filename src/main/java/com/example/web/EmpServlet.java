package main.java.com.example.web;

import main.java.com.example.pojo.Emp;
import main.java.com.example.pojo.Page;
import main.java.com.example.service.EmpService;
import main.java.com.example.service.Impl.EmpServiceImpl;
import main.java.com.example.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/empServlet")
public class EmpServlet extends BaseServlet{

    private EmpService empService = new EmpServiceImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用 empService.page(pageNo，pageSize)：Page 对象
        Page<Emp> page = empService.page(pageNo,pageSize);
        page.setUrl("empServlet?action=page");

        //3 保存 Page 对象到 Request 域中
        req.setAttribute("page",page);
        //4 请求转发到 emp.jsp 页面
        req.getRequestDispatcher("emp.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        //1、获取请求的参数//暂时先不封装==封装成为 Emp 对象
        Emp emp = WebUtils.copyParamToBean(req.getParameterMap(), new Emp());
        String hiredate = req.getParameter("hiredate");
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(hiredate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String sal=req.getParameter("sal");
        String comm=req.getParameter("comm");
        String deptno=req.getParameter("deptno");
        emp.setHiredate(date);
        emp.setSal(Integer.parseInt(sal));
        emp.setComm(Integer.parseInt(comm));
        emp.setDeptno(Integer.parseInt(deptno));
        //2、调用 BookService.addEmp()保存员工
        empService.addEmp(emp);
        //3、跳到员工列表页面
        resp.sendRedirect(req.getContextPath() + "/empServlet?action=page&pageNo="+pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数 empno
        int empno = WebUtils.parseInt(req.getParameter("empno"),0);
        //2、调用 empService.deleteEmpByEmpno();删除员工
        empService.deleteEmpByEmpno(empno);
        //3、重定向回员工列表管理页面
        resp.sendRedirect(req.getContextPath() + "/empServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数==封装成为 Emp 对象
        Emp emp = WebUtils.copyParamToBean(req.getParameterMap(),new Emp());
        String hiredate = req.getParameter("hiredate");
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(hiredate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String sal=req.getParameter("sal");
        String comm=req.getParameter("comm");
        String deptno=req.getParameter("deptno");
        emp.setHiredate(date);
        emp.setSal(Integer.parseInt(sal));
        emp.setComm(Integer.parseInt(comm));
        emp.setDeptno(Integer.parseInt(deptno));
        //2、调用 EmpService.updateEmp( emp );修改员工
        empService.updateEmp(emp);
        //3、重定向回员工列表管理页面
        resp.sendRedirect(req.getContextPath() + "/empServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void getEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数员工编号
        int empno = WebUtils.parseInt(req.getParameter("empno"),0);
        //2 调用 empService.queryEmpByEmpno 查询员工
        Emp emp = empService.queryEmpByEmpno(empno);
        //3 保存到员工到 Request 域中
        req.setAttribute("emp",emp);
        //4 请求转发到emp_update.jsp 页面
        req.getRequestDispatcher("emp_update.jsp").forward(req,resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 通过 EmpService 查询全部员工
        List<Emp> emps = empService.queryEmps();
        //2 把全部图书保存到 Request 域中
        req.setAttribute("emps",emps);
        //3、请求转发到emp.jsp 页面
        req.getRequestDispatcher("emp.jsp").forward(req,resp);

    }
}
