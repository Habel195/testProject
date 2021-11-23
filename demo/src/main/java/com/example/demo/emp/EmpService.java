package com.example.demo.emp;

import java.util.List;
import java.util.Optional;

public interface EmpService {

    Integer join(Employees employees);
    void validateDuplicateName(Employees employees);

    Optional<Employees> findEmpById(int employeesId);
    Optional<Employees> findEmpByName(String ename);
    List<Employees> findAll();
    //update
    Employees update(Employees employees);

    //delete(update grade)
    Employees updateRetiree (Employees employees);


}
