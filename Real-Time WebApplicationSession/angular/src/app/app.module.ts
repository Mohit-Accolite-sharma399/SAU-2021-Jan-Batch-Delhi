import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DailyWeeklyReportComponent } from './daily-weekly-report/daily-weekly-report.component';
import { UserReportComponent } from './user-report/user-report.component';
import { FakeUserReportComponent } from './fake-user-report/fake-user-report.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
@NgModule({
  declarations: [
    AppComponent,
    DailyWeeklyReportComponent,
    UserReportComponent,
    FakeUserReportComponent,
    LoginComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
