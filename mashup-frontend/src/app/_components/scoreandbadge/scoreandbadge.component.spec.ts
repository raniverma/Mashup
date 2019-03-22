import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScoreandbadgeComponent } from './scoreandbadge.component';

describe('ScoreandbadgeComponent', () => {
  let component: ScoreandbadgeComponent;
  let fixture: ComponentFixture<ScoreandbadgeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScoreandbadgeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScoreandbadgeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
