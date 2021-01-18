import { EmpServiceService } from './../Service/emp-service.service';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-all-employees',
  templateUrl: './show-all-employees.component.html',
  styleUrls: ['./show-all-employees.component.css']
})
export class ShowAllEmployeesComponent implements OnInit,OnDestroy{

  constructor(private empService:EmpServiceService,private router:Router) { }
  employees=[];

  ngOnInit(): void {
    this.employees=this.empService.showAllEmployee();
  }

  ngOnDestroy(){
    this.empService.upDateList(this.employees);
  }

  listFilter(id){
    this.employees=this.employees.filter((emp)=>{
      if(emp.empId!==id){
        return true;
      }
    })
  }

  onEdit(id){
    this.router.navigate(['addEmployee',id]);
  }

  onDelete(id){
      this.listFilter(id);
  }

}
