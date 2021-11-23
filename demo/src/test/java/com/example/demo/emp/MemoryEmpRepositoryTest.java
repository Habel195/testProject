package com.example.demo.emp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MemoryEmpRepositoryTest {
    MemoryEmpRepository repository = new MemoryEmpRepository();
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Employees employees = new Employees();
        /**
         *
         * @param eno 사원 번호
         * @param ename 이름
         * @param job 업무
         * @param hiredate 입사일
         * @param dept 부서명
         * @param grade 등급 (관리자,직원,퇴사자)
         */


        employees.setEname("박보검");
        employees.setJob("CEO");
        employees.setHiredate("2020-01-01");
        employees.setDept("IT");
        employees.setGrade(Grade.NORMAL);

        repository.save(employees);

        Employees result= repository.findById(employees.getEno()).get();
        assertThat(employees).isEqualTo(result);



        Employees employees1 = new Employees();
        employees1.setEname("박보검1");
        employees1.setJob("CEO");
        employees1.setHiredate("2020-01-01");
        employees1.setDept("IT");
        employees1.setGrade(Grade.NORMAL);

        repository.save(employees1);

        Employees result1 = repository.findById(employees1.getEno()).get();
        assertThat(employees1).isEqualTo(result1);
        // Assertions.assertThat static import

    }
    @Test
    public void findById(){
        Employees employees1 = new Employees();
        employees1.setEname("박보검1");
        employees1.setJob("CEO");
        employees1.setHiredate("2020-01-01");
        employees1.setDept("IT");
        employees1.setGrade(Grade.NORMAL);
        repository.save(employees1);

        Employees employees2 = new Employees();
        employees2.setEname("조인성");
        employees2.setJob("CEO");
        employees2.setHiredate("2020-01-01");
        employees2.setDept("IT");
        employees2.setGrade(Grade.NORMAL);
        repository.save(employees2);

        Employees result = repository.findById(employees1.getEno()).get();
        assertThat(result).isEqualTo(employees1);

    }
    @Test
    public void findByName(){
        Employees employees1 = new Employees();
        employees1.setEname("박보검1");
        employees1.setJob("CEO");
        employees1.setHiredate("2020-01-01");
        employees1.setDept("IT");
        employees1.setGrade(Grade.NORMAL);
        repository.save(employees1);

        Employees employees2 = new Employees();
        employees2.setEname("조인성");
        employees2.setJob("CEO");
        employees2.setHiredate("2020-01-01");
        employees2.setDept("IT");
        employees2.setGrade(Grade.NORMAL);
        repository.save(employees2);

        Employees result = repository.findByName(employees1.getEname()).get();
        assertThat(result).isEqualTo(employees1);

    }

    @Test
    public void findAll(){

        Employees employees = new Employees();
        employees.setEname("조인성");
        employees.setJob("Engineer");
        employees.setHiredate("2020-01-01");
        employees.setDept("IT");
        employees.setGrade(Grade.NORMAL);

        repository.save(employees);


        Employees employees1 = new Employees();
        employees1.setEname("박서준");
        employees1.setJob("Programmer");
        employees1.setHiredate("2020-01-01");
        employees1.setDept("IT");
        employees1.setGrade(Grade.NORMAL);

        repository.save(employees1);

        List<Employees> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }

    @Test
    public void update(){
        //given
        Employees employees1 = new Employees();
        employees1.setEname("박서준");
        employees1.setJob("Programmer");
        employees1.setHiredate("2020-01-01");
        employees1.setDept("IT");
        employees1.setGrade(Grade.NORMAL);

        repository.save(employees1);

        //when

        Employees employees = repository.findById(employees1.getEno()).get();
        employees.setJob("CEO");

        repository.update(employees);
        Employees result = repository.findById(employees1.getEno()).get();
        //then
        assertThat(employees).isEqualTo(result);

    }

    @Test
    public void updateRetiree(){
        //given
        Employees employees1 = new Employees();
        employees1.setEname("박서준");
        employees1.setJob("Programmer");
        employees1.setHiredate("2020-01-01");
        employees1.setDept("IT");
        employees1.setGrade(Grade.NORMAL);
        repository.save(employees1);

        //when
        repository.updateRetiree(employees1);

        //then
        Employees result = repository.findById(employees1.getEno()).get();
        assertThat(result.getGrade()).isEqualTo(Grade.RETIREE);
    }







}
