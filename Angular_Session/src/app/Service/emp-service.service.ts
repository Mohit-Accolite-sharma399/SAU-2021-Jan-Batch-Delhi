import { Injectable, OnDestroy } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmpServiceService {

  empList=[];

  constructor(){
   }



  addEmployee(emp):Boolean{


    var id=emp.empId;
    var found:Boolean=false;
    this.empList.forEach((e)=>{
      if(e.empId===id){
        found=true;
      }
    });

    if(!found){
      this.empList.push(emp);
    }
    else{
      alert("Employee with this Id is Already Present!");
      return false;
    }

    return true;
  }

  showAllEmployee(){
    return this.empList;
  }

  getEmployeeById(id){

    return this.empList.find((emp)=>{
      if(emp.empId===id){
        return emp;
      }
    });
  }

  editEmployeeDetail(emp):Boolean{
    var found=false;
    var tmp:any;
    for(var i=0;i<this.empList.length;i++){
      tmp=this.empList[i];

      if(tmp.empId===emp.empId){
        this.empList[i]=emp;
        found=true;
        break;
      }
    }

    return found;
  }

  upDateList(newList:Array<any>){
   this.empList=newList;
  }

}
