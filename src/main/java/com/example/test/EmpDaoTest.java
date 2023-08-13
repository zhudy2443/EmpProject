package main.java.com.example.test;

import main.java.com.example.dao.EmpDao;
import main.java.com.example.dao.Impl.EmpDaoImpl;
import main.java.com.example.pojo.Emp;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class EmpDaoTest {
    private EmpDao empDao = new EmpDaoImpl();

    @Test
    public void addEmp() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate = dateFormat.parse("2001-04-16");
        empDao.addEmp(new Emp(99991,"ZHUDY","KING",9991,hireDate,8000,6000,10));
    }

    @Test
    public void deleteEmpByEmpno() {
        empDao.deleteEmpByEmpno(7369);
    }

    @Test
    public void updateEmp() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate = dateFormat.parse("1981-09-28");
        empDao.updateEmp(new Emp(7654,"MARTIN","SALESMAN",7698,hireDate,12500,14000,30));
    }

    @Test
    public void queryEmpByEmpno() {
        System.out.println(empDao.queryEmpByEmpno(7499));
    }

    @Test
    public void queryEmps() {
        for (Emp queryEmp : empDao.queryEmps()) {
            System.out.println(queryEmp);
        }
    }
}
