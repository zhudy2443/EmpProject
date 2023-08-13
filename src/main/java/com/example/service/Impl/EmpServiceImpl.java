package main.java.com.example.service.Impl;

import main.java.com.example.dao.EmpDao;
import main.java.com.example.dao.Impl.EmpDaoImpl;
import main.java.com.example.pojo.Emp;
import main.java.com.example.pojo.Page;
import main.java.com.example.service.EmpService;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();
    @Override
    public Page<Emp> page(int pageNo, int pageSize) {
        Page<Emp> page = new Page<>();
        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = empDao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;

        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }

        // 设置总页码
        page.setPageTotal(pageTotal);

        page.setpageNo(pageNo);
        // 求当前页数据的开始索引
        int begin = (page.getpageNo() - 1) * pageSize;
        // 求当前页数据
        List<Emp> items = empDao.queryForPageItems(begin,pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public void addEmp(Emp emp) {
        empDao.addEmp(emp);
    }

    @Override
    public void deleteEmpByEmpno(Integer empno) {
        empDao.deleteEmpByEmpno(empno);
    }

    @Override
    public void updateEmp(Emp emp) {
        empDao.updateEmp(emp);
    }

    @Override
    public Emp queryEmpByEmpno(Integer empno) {
        return empDao.queryEmpByEmpno(empno);
    }

    @Override
    public List<Emp> queryEmps() {
        return empDao.queryEmps();
    }
}
