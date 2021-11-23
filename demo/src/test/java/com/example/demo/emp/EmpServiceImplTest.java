package com.example.demo.emp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmpServiceImplTest {

    EmpServiceImpl empService;
    MemoryEmpRepository empRepository;

    @BeforeEach
    public void beforeEach(){
        empRepository = new MemoryEmpRepository();
        empService = new EmpServiceImpl(empRepository);
    }

    @AfterEach
    public void afterEach(){
        empRepository.clearStore();
    }
    @Test
    void join() {

        //given
        Employees employee = new Employees();
        employee.setEname("박보검");
        employee.setJob("CEO");
        employee.setHiredate("2020-01-01");
        employee.setDept("IT");
        employee.setGrade(Grade.NORMAL);

        //when
        Integer id = empService.join(employee);

        //then
        Employees findEmployee = empService.findEmpById(id).get();
        assertThat(employee.getEname()).isEqualTo(findEmployee.getEname());


    }

    @Test
    void validateDuplicateName() {
        //given
        Employees employee1 = new Employees();
        employee1.setEname("박보검");

        Employees employee2 = new Employees();
        employee2.setEname("박보검");

        //when
        empService.join(employee1);

        //then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> empService.join(employee2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 사원 입니다.");


    }

    @Test
    void findEmpById() {

        Employees employees1 = new Employees();
        employees1.setEname("박보검1");
        employees1.setJob("CEO");
        employees1.setHiredate("2020-01-01");
        employees1.setDept("IT");
        employees1.setGrade(Grade.NORMAL);
        empService.join(employees1);

        Employees employees2 = new Employees();
        employees2.setEname("조인성");
        employees2.setJob("CEO");
        employees2.setHiredate("2020-01-01");
        employees2.setDept("IT");
        employees2.setGrade(Grade.NORMAL);
        empService.join(employees2);

        Employees result = empService.findEmpById(employees1.getEno()).get();
        assertThat(result).isEqualTo(employees1);
    }

    @Test
    void findEmpByName() {


        Employees employees1 = new Employees();
        employees1.setEname("박보검1");
        employees1.setJob("CEO");
        employees1.setHiredate("2020-01-01");
        employees1.setDept("IT");
        employees1.setGrade(Grade.NORMAL);
        empService.join(employees1);

        Employees employees2 = new Employees();
        employees2.setEname("조인성");
        employees2.setJob("CEO");
        employees2.setHiredate("2020-01-01");
        employees2.setDept("IT");
        employees2.setGrade(Grade.NORMAL);
        empService.join(employees2);

        Employees result = empService.findEmpByName(employees1.getEname()).get();
        assertThat(result).isEqualTo(employees1);
    }

    @Test
    void findAll() {

        Employees employees = new Employees();
        employees.setEname("조인성");
        employees.setJob("Engineer");
        employees.setHiredate("2020-01-01");
        employees.setDept("IT");
        employees.setGrade(Grade.NORMAL);

        empService.join(employees);


        Employees employees1 = new Employees();
        employees1.setEname("박서준");
        employees1.setJob("Programmer");
        employees1.setHiredate("2020-01-01");
        employees1.setDept("IT");
        employees1.setGrade(Grade.NORMAL);

        empService.join(employees1);

        List<Employees> result = empService.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void update() {

        //given
        Employees employees1 = new Employees();
        employees1.setEname("박서준");
        employees1.setJob("Programmer");
        employees1.setHiredate("2020-01-01");
        employees1.setDept("IT");
        employees1.setGrade(Grade.NORMAL);

        empService.join(employees1);

        //when

        Employees employees = empService.findEmpById(employees1.getEno()).get();
        employees.setJob("CEO");

        empService.update(employees);
        Employees result = empService.findEmpById(employees1.getEno()).get();
        //then
        assertThat(employees).isEqualTo(result);
    }

    @Test
    void updateRetiree() {

        //given
        Employees employees1 = new Employees();
        employees1.setEname("박서준");
        employees1.setJob("Programmer");
        employees1.setHiredate("2020-01-01");
        employees1.setDept("IT");
        employees1.setGrade(Grade.NORMAL);
        empService.join(employees1);

        //when
        empService.updateRetiree(employees1);

        //then
        Employees result = empService.findEmpById(employees1.getEno()).get();
        assertThat(result.getGrade()).isEqualTo(Grade.RETIREE);
    }
}