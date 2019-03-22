import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SavequestionComponent } from './savequestion.component';

describe('SavequestionComponent', () => {
  let component: SavequestionComponent;
  let fixture: ComponentFixture<SavequestionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SavequestionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SavequestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
