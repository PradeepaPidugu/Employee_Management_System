package com.employee.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.entities.Employee;
@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer>{

}
/*
save()=>insert and update
findAll()=>select *(to return all records)
findById()=>primary key
delete()
*/