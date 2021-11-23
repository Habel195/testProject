package com.example.demo.emp;


import java.util.List;
import java.util.Optional;

public interface EmpRepository {
    //crud
    //create
    Employees save(Employees employees);
    //read
    Optional<Employees> findById(int employeesId);
    Optional<Employees> findByName(String ename);
    List<Employees> findAll();
    //update
    Employees update(Employees employees);

    //delete(update grade)
    Employees updateRetiree (Employees employees);

}
