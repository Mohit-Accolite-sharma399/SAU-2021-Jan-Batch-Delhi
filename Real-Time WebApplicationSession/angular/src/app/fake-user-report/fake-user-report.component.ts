import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-fake-user-report',
  templateUrl: './fake-user-report.component.html',
  styleUrls: ['./fake-user-report.component.scss']
})
export class FakeUserReportComponent implements OnInit {

  user: any=[] ;

  constructor(
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8081/user/fake').subscribe((data)=>{
        this.user =  data ;
        console.log(data);
      });
  }

}
