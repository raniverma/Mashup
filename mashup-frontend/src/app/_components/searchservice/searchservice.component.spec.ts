import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchserviceComponent } from './searchservice.component';

describe('SearchserviceComponent', () => {
  let component: SearchserviceComponent;
  let fixture: ComponentFixture<SearchserviceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchserviceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchserviceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
