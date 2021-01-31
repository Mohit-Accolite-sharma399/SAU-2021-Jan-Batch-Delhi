import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  login=false;
  register=false;
  email='';
  password='';
  name='';
  loggedIn=true;
  transaction=false;
  admin=false;
  amount=0;
  cnid='';
  bname='';

  constructor(
    private http: HttpClient,
    private route: Router
  ) { }

  ngOnInit(): void {
  }

  showLogin=()=>{
    this.login=true;
    this.register=false;
    this.email='';
    this.password='';
    this.name='';
    console.log(this.email,this.password);

  }

  showReg=()=>{
    this.login=false;
    this.register=true;
    this.email='';
    this.password='';
    this.name='';
    console.log(this.name,this.email,this.password);
  }

  regfunc=()=>{
    this.http.post('http://localhost:8081/register',
    {name:this.name,email:this.email,password:this.password},
    { responseType: 'text'})
    .subscribe(data=>{
      if(data==="true"){
        console.log(data);
        alert("Move back to Login Page")
      }
      else{
        alert("Error Try again")
        console.log(data);
      }
    });
  }

  loginfunc=()=>{

    if(this.email==="admin" && this.password==="admin"){
        alert("Admin");
        this.admin=true;
        this.loggedIn=false;
        this.route.navigate(['/admin']);

    }
    else{
    this.http.post('http://localhost:8081/login',
    {email:this.email,password:this.password},
    { responseType: 'text'})
    .subscribe(data=>{
      if(data==="Matched"){

        this.transaction=true;
        this.loggedIn=false;


      }
      else{
        console.log(data);
      }
    });
  }

  }

  submit=()=>{
    if((this.amount%500==0) || (this.amount%1000==0)){
    const d=new Date;
    const date= d.getFullYear()+"/"+(d.getMonth()+1)+"/"+d.getDate();
    this.http.post('http://localhost:8081/user',{branchname:this.bname,
    email:this.email,amount:this.amount,currency_id:this.cnid,timestamp: date},
    {responseType:"text"})
    .subscribe(data=>{
      alert("Done");
      console.log(data);
    })
  }
  else{
    alert("Enter amount either multiple of 500 or  1000")
  }
  }

}
