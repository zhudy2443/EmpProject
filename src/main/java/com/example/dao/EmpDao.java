package main.java.com.example.dao;

import main.java.com.example.pojo.Emp;

import java.util.List;

public interface EmpDao {
    public Integer queryForPageTotalCount();

    public List<Emp> queryForPageItems(int begin, int pageSize);

    public int addEmp(Emp emp);

    public int deleteEmpByEmpno(Integer empno);

    public int updateEmp(Emp emp);

    public Emp queryEmpByEmpno(Integer empno);

    public List<Emp> queryEmps();
}
