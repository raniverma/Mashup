import { Component, OnInit } from '@angular/core';
import { ScorebadgeService } from '../../services/scorebadge.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-scoreandbadge',
  templateUrl: './scoreandbadge.component.html',
  styleUrls: ['./scoreandbadge.component.css']
})
export class ScoreandbadgeComponent implements OnInit {

  public uname: string;
   // for getting data from scoreand badge service
   public userData = {};

  constructor(public scorebadgeservice: ScorebadgeService,private token: TokenStorageService) { }

  ngOnInit() {
    this.uname = this.token.getUsername();
     // call score and badge service to get data(added by pratima on 27th feb2019)
     this.scorebadgeservice.getUserData(this.uname).subscribe(data => this.userData = data);
  }

}
