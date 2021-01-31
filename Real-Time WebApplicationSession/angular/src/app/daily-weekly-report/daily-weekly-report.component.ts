import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-daily-weekly-report',
  templateUrl: './daily-weekly-report.component.html',
  styleUrls: ['./daily-weekly-report.component.scss']
})
export class DailyWeeklyReportComponent implements OnInit {

  user: any=[] ;

  constructor(
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8081/user/daily').subscribe((data)=>{
        this.user =  data ;
        console.log(data);
      });
  }

}
