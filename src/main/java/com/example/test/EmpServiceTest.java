package main.java.com.example.test;

import main.java.com.example.pojo.Emp;
import main.java.com.example.service.EmpService;
import main.java.com.example.service.Impl.EmpServiceImpl;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmpServiceTest {
    private EmpService empService = new EmpServiceImpl();

    @Test
    public void addBook() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate = dateFormat.parse("2001-04-16");
        empService.addEmp(new Emp(99992,"ZHUDY1","KING1",9991,hireDate,8000,6000,10));
    }

    @Test
    public void deleteBookById() {
        empService.deleteEmpByEmpno(99992);
    }

    @Test
    public void updateBook() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate = dateFormat.parse("1981-09-28");
        empService.updateEmp(new Emp(7654,"MARTIN","SALESMAN",7698,hireDate,1250,1400,30));
    }

    @Test
    public void queryBookById() {
        System.out.println(empService.queryEmpByEmpno(7654));
    }

    @Test
    public void queryBooks() {
        for (Emp queryBook : empService.queryEmps()) {
            System.out.println(queryBook);
        }
    }
}
