package main.java.com.example.service;

import main.java.com.example.pojo.Emp;
import main.java.com.example.pojo.Page;

import java.util.List;

public interface EmpService {
    public Page<Emp> page(int pageNo, int pageSize);
    public void addEmp(Emp emp);

    public void deleteEmpByEmpno(Integer empno);

    public void updateEmp(Emp emp);

    public Emp queryEmpByEmpno(Integer empno);

    public List<Emp> queryEmps();
}
