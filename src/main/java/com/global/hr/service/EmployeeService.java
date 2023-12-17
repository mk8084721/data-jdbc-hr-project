package com.global.hr.service;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> findByName(String name){
        return employeeRepo.findByName(name);
    }

    public List<Employee> findByNameAndSalary(String name ,Double salary){
        return employeeRepo.findByNameAndSalary(name, salary);
    }

    public List<Employee> findBymySalary(Double salary){
        return employeeRepo.findBymySalary(salary);
    }

    public void deleteById(Long id){
        employeeRepo.deleteById(id);
    }

    public Employee update(Employee emp){
        return employeeRepo.save(emp);
    }
/////////////////////////
    public Employee addEmp(Employee emp){
        return employeeRepo.save(emp);
    }

    public long countEmp(){
        return employeeRepo.count();
    }

    public Iterable<Employee> findAll(){
        return employeeRepo.findAll();
    }

//    public Employee findById(Long id ,String acceptLanguage){
//
//        log.info("Accept Language is "+acceptLanguage);
//        return employeeRepo.findById(id).get();
//    }

}
