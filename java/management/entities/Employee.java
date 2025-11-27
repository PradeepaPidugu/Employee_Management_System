package com.employee.management.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data//it is for setter, getter and tostring()
@Entity
@Table(name="employees")
public class Employee {
	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	@Column(name="emp_name")
	private String empName;
	@Column(name = "designation")
	private String designation;
	@Column(name = "emp_salary")
	private int empSalary;
}
