import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchdisplayComponent } from './searchdisplay.component';

describe('SearchdisplayComponent', () => {
  let component: SearchdisplayComponent;
  let fixture: ComponentFixture<SearchdisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchdisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchdisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
