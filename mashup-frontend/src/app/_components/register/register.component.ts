import { RegisterService } from './../../services/register.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertService } from '../../services/alert.service';
import { AuthenticationService } from '../../services/authentication.service';
import { DialogService } from 'src/app/services/dialog.service';

@Component({ templateUrl: 'register.component.html' })
export class RegisterComponent implements OnInit {
  submitted = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;


  constructor(
      private formBuilder: FormBuilder,
      private dialogService: DialogService,
      private router: Router,
      private authenticationService: AuthenticationService,
      private registerService: RegisterService,
      private alertService: AlertService
    ) {
        // redirect to home if already logged in
        if (this.authenticationService.currentUserValue) {
          this.router.navigate(['/']);
        }
      }

  ngOnInit() {
    this.firstFormGroup = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      emailId: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(7)]],
      interest: ['', Validators.required],
      username: ['', Validators.required],
    });
    this.secondFormGroup = this.formBuilder.group({
      gender: [''],
      age: [''],
      college: [''],
      course: [''],
      discipline: [''],
      company: ['']
    });
  }

  onSubmit() {
      this.submitted = true;

      // stop here if form is invalid
      if (this.firstFormGroup.invalid) {
        alert('register form is invalid ');
        return;
      }
      const object = Object.assign(this.firstFormGroup.value, this.secondFormGroup.value);
      
      this.dialogService.openConfirmDialog("Are you sure ?")
      .afterClosed().subscribe(res =>{
        if(res){
          this.registerService.register(object).subscribe(
             data => {
              this.alertService.success(data, true);
              // alert(data);
              this.router.navigate(['/auth/login']);
            },
          error => {
            this.alertService.error('user already exists');
            alert('error');
        }
      );
        }
      });
    }
  }
