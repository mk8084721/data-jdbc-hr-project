package com.global.hr.repository;

import com.global.hr.entity.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee , Long > {

    public List<Employee> findByName(String name);

    public List<Employee> findByNameAndSalary(String name ,Double salary);
    @Query("select * from employees where salary>=:mysalary;")
    public List<Employee> findBymySalary(@Param("mysalary")Double salary);


}
