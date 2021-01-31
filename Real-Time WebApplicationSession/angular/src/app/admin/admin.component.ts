import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  userReport=false;
  weekReport=false;
  fakeReport=false;

  userReportFunc=()=>{
    this.userReport=true;
    this.weekReport=false;
    this.fakeReport=false;
  }
  weekReportFunc=()=>{
    this.userReport=false;
    this.weekReport=true;
    this.fakeReport=false;
  }
  fakeReportFunc=()=>{

    this.userReport=false;
    this.weekReport=false;
    this.fakeReport=true;
  }

}
