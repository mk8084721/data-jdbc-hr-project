package com.global.hr.controller;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;
import com.global.hr.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepo employeeRepo;
    private EmployeeService employeeService;

//    @GetMapping("/count")
    @RequestMapping(method = RequestMethod.GET ,path = "/count")
    public long countEmp(){
        return employeeRepo.count();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id ,@RequestHeader("accept-language") String acceptLanguage){

        log.info("Accept Language is "+acceptLanguage);
        return employeeRepo.findById(id).get();
    }

    @GetMapping("")
    public Iterable<Employee> findAll(){
        return employeeService.findAll();
    }

    @PostMapping("")
    public Employee addEmp(@RequestBody Employee emp){return employeeService.addEmp(emp);}

    @PutMapping("")
    public Employee update(@RequestBody Employee emp){return employeeService.update(emp);}

    @DeleteMapping("/{empId}")
    public void deleteEmp(@PathVariable(name = "empId") Long id){
        employeeService.deleteById(id);
    }

    @GetMapping("filter")
    public List<Employee> filter(@RequestParam String name ,@RequestParam Double salary){
        return employeeService.findByNameAndSalary(name,salary);
    }
    @GetMapping("filter/{salary}")
    public List<Employee> specialQuery(@PathVariable Double salary){
        return employeeService.findBymySalary(salary);
    }


}
