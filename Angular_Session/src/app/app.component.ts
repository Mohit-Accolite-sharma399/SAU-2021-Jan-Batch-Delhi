import { SvcService } from './svc.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Mohit';
  count=0;
  date=Date.now();
  constructor(private svc:SvcService){

  }

  add(){
    this.count++;
  }
  subtract(){
    this.count--;
  }

  exceed5(event:any){
    alert(event);
  }

  increment(){
    this.svc.increment();
  }
}
