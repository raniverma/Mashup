import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditaudioComponent } from './editaudio.component';

describe('EditaudioComponent', () => {
  let component: EditaudioComponent;
  let fixture: ComponentFixture<EditaudioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditaudioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditaudioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
