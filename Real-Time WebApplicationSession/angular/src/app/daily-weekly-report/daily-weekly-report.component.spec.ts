import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyWeeklyReportComponent } from './daily-weekly-report.component';

describe('DailyWeeklyReportComponent', () => {
  let component: DailyWeeklyReportComponent;
  let fixture: ComponentFixture<DailyWeeklyReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DailyWeeklyReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyWeeklyReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
