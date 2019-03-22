import { Component, OnInit, ViewChild, NgModule } from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { UserprofileServiceService } from '../../services/userprofile-service.service';
import { Token } from '@angular/compiler';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { ScorebadgeService } from 'src/app/services/scorebadge.service';
import { Profile } from 'selenium-webdriver/firefox';
import { ActivatedRoute, Router } from '@angular/router';

export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}
export interface PeriodicElement {
  name: string;
  position: number;
}

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {
  profileState: string;
  public profile;
  public uname: string;

  // tslint:disable-next-line:max-line-length
  constructor( private _route: ActivatedRoute,private router: Router,private token: TokenStorageService, private userService: UserprofileServiceService) { }
  tiles: Tile[] = [
    {text: 'One', cols: 1, rows: 5, color: 'white'},
    {text: 'Two', cols: 2, rows: 1, color: 'white'},
    {text: 'three', cols: 2, rows: 4, color: 'grey'},
  ];

  ngOnInit() {
    this.uname = this.token.getUsername();
    this.userService.getUserProfile(this.uname).subscribe(data => this.profile = data);
    this.profileState = 'currentProfile';
  }

  updateProfile() {
    this.profileState = 'updatingProfile';
  }
  submitUpdatedProfile(age, gender, company, college, course, discipline) {
    this.profile.age = age;
    this.profile.gender = gender;
    this.profile.company = company;
    this.profile.college = college;
    this.profile.course = course;
    this.profile.disciple = discipline;
    this.userService.updateProfile(this.profile).subscribe();
    this.profileState = 'currentProfile';
  }

  deleteUserProfile() {
    this.token.signOut();
    this.userService.deleteUserProfile(this.profile.username).subscribe();
    location.assign("http://13.234.74.67:8030/");

  }
}
