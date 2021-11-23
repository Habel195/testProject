package com.example.demo.emp;

/**
 *
 * @param eno 사원 번호
 * @param ename 이름
 * @param job 업무
 * @param hiredate 입사일
 * @param dept 부서명
 * @param grade 등급 (관리자,직원,퇴사자)
 */

public class Employees {
    private int eno;
    private String ename;
    private String job;
    private String hiredate;
    private String dept;
    private Grade grade;

    //int sale
    //int commission


/*
    public Employees(int eno, String ename, String job, String hiredate, String dept, Grade grade) {
        this.eno = eno;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.dept = dept;
        this.grade = grade;
    }*/

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hiredate='" + hiredate + '\'' +
                ", dept='" + dept + '\'' +
                ", grade=" + grade +
                '}';
    }
}
