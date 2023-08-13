package main.java.com.example.pojo;

import java.util.Date;

public class Emp {
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private int sal;
    private int comm;
    private int deptno;

    public Emp() {
    }

    public Emp(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    /**
     * 获取
     * @return empno
     */
    public int getEmpno() {
        return empno;
    }

    /**
     * 设置
     * @param empno
     */
    public void setEmpno(int empno) {
        this.empno = empno;
    }

    /**
     * 获取
     * @return ename
     */
    public String getEname() {
        return ename;
    }

    /**
     * 设置
     * @param ename
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * 获取
     * @return job
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置
     * @param job
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 获取
     * @return mgr
     */
    public int getMgr() {
        return mgr;
    }

    /**
     * 设置
     * @param mgr
     */
    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    /**
     * 获取
     * @return hiredate
     */
    public Date getHiredate() {
        return hiredate;
    }

    /**
     * 设置
     * @param hiredate
     */
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    /**
     * 获取
     * @return sal
     */
    public int getSal() {
        return sal;
    }

    /**
     * 设置
     * @param sal
     */
    public void setSal(int sal) {
        this.sal = sal;
    }

    /**
     * 获取
     * @return comm
     */
    public int getComm() {
        return comm;
    }

    /**
     * 设置
     * @param comm
     */
    public void setComm(int comm) {
        this.comm = comm;
    }

    /**
     * 获取
     * @return deptno
     */
    public int getDeptno() {
        return deptno;
    }

    /**
     * 设置
     * @param deptno
     */
    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String toString() {
        return "Emp{empno = " + empno + ", ename = " + ename + ", job = " + job + ", mgr = " + mgr + ", hiredate = " + hiredate + ", sal = " + sal + ", comm = " + comm + ", deptno = " + deptno + "}";
    }
}
