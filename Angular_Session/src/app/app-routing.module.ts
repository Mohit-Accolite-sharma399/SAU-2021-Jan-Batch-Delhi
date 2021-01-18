import { ShowAllEmployeesComponent } from './show-all-employees/show-all-employees.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';



const routes: Routes = [
  {path: 'addEmployee/:id',component:AddEmployeeComponent},
  {path: 'showAll',component:ShowAllEmployeesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
