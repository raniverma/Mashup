import { Component, OnInit } from '@angular/core';
import { QuestionserviceService } from '../../services/questionservice.service';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import { AlertService } from '../../services/alert.service';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import { TokenStorageService } from '../../services/token-storage.service';

@Component({
  selector: 'app-savequestion',
  templateUrl: './savequestion.component.html',
  styleUrls: ['./savequestion.component.css']
})
export class SavequestionComponent implements OnInit {

  questionForm: FormGroup;

  public uname: string;
  title = 'Question';
  submitted = false;

  levels: any  = ['-----Select Difficulty------', 'Beginner', 'Intermediate',
            'Advance', 'Expert'];

  get f() {
     return this.questionForm.controls;
  }


  // tslint:disable-next-line:max-line-length
  constructor(private token: TokenStorageService, private _route: ActivatedRoute, public questionservice: QuestionserviceService, private router: Router, private formBuilder: FormBuilder, private alertService: AlertService) { }

  ngOnInit() {
    this.questionForm = this.formBuilder.group({
      questionTitle: ['', Validators.required],
      questionDescription: ['', Validators.required],
      inputFormat: ['', Validators.required],
      outputFormat: ['', Validators.required],
      difficulty: ['', Validators.required],
      tags: ['', Validators.required],
      gitUrl: ['', Validators.required],
    });
  }
  // tslint:disable-next-line:member-ordering
  obj1: any;

  // tslint:disable-next-line:member-ordering
  add: string;
  submit(): any {
    this.submitted = true;

    if (this.questionForm.invalid) {
      alert('Question form is invalid ');
      return;
    }
   this.uname = this.token.getUsername();

   // tslint:disable-next-line:label-position
   this.add = '{"username":"' + this.uname + '"}';
    this.obj1  = JSON.parse(this.add);
    const obj2 = Object.assign(this.questionForm.value, this.obj1);
    this.questionservice.saveQuestion(obj2).pipe(first()).subscribe(
      data => {
        alert(data);
        this.router.navigate(['home']);
    },
    error => {
      alert(error);
    }
    );
  }

}
