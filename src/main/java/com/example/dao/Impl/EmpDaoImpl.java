package main.java.com.example.dao.Impl;

import main.java.com.example.dao.EmpDao;
import main.java.com.example.pojo.Emp;
import main.java.com.example.utils.BaseDao;

import java.util.List;

public class EmpDaoImpl extends BaseDao implements EmpDao {
    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from emp";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Emp> queryForPageItems(int begin, int pageSize) {
        String sql = "select `empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno` from emp limit ?,?";
        return queryForList(Emp.class,sql,begin,pageSize);
    }
    @Override
    public int addEmp(Emp emp) {
        String sql ="insert into emp(`empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno`)values(?,?,?,?,?,?,?,?)";
        return update(sql,emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno());
    }

    @Override
    public int deleteEmpByEmpno(Integer empno) {
        String sql = "delete from emp where empno = ?";
        return update(sql,empno);
    }

    @Override
    public int updateEmp(Emp emp) {
        String sql = "update emp set `ename`=?,`job`=?,`mgr`=?,`hiredate`=?,`sal`=?,`comm`=?,`deptno`=? where empno = ?";
        return update(sql,emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno());
    }

    @Override
    public Emp queryEmpByEmpno(Integer empno) {
        String sql = "select `empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno` from emp where empno = ?";
        return queryForOne(Emp.class, sql,empno);
    }

    @Override
    public List<Emp> queryEmps() {
        String sql = "select `empno`,`ename`,`job`,`mgr`,`hiredate`,`sal`,`comm`,`deptno` from emp";
        return queryForList(Emp.class, sql);
    }
}
