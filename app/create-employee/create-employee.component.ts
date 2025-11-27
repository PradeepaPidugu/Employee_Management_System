import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrl: './create-employee.component.css'
})
export class CreateEmployeeComponent implements OnInit {
  employee :Employee=new Employee();
  constructor(private employeeService: EmployeeService, private route:Router){}
  ngOnInit(): void {
    
  }
  onSubmit(){
    this.insertEmployee();
  }
  insertEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(data => {
      this.goToEmployeeList();
    })
  }
  goToEmployeeList(){
    this.route.navigate(['/employees']);
  }
}
