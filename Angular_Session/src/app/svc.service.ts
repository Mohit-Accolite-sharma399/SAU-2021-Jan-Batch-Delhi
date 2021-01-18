import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SvcService {
  num=0;
  numBS= new BehaviorSubject(0);
  obs= this.numBS.asObservable();
  constructor() { }

  increment(){
    this.num=this.num+1;
    this.numBS.next(this.num);
    console.log(this.num);
  }

  getNum():number{
    return this.num;
  }

}
