package com.example.demo.emp;

import java.util.*;

public class MemoryEmpRepository implements EmpRepository{

    private static Map<Integer,Employees> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public Employees save(Employees employees) {
        employees.setEno(++sequence);
        store.put(employees.getEno(),employees);

        return employees;
    }

    @Override
    public Optional<Employees> findById(int employeesId) {
        return Optional.ofNullable(store.get(employeesId));
    }

    @Override
    public Optional<Employees> findByName(String ename) {
        return store.values().stream()
                .filter(employees -> employees.getEname().equals(ename))
                .findAny();
    }

    @Override
    public List<Employees> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Employees update(Employees employees) {
        store.replace(employees.getEno(),employees);

        return employees;
    }

    @Override
    public Employees updateRetiree(Employees employees) {
        employees.setGrade(Grade.RETIREE); // 여기서 정해도 되는지...?
        store.replace(employees.getEno(),employees);

        return employees;
    }

    public void clearStore() {
        store.clear();
    }
}
