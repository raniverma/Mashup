import { QuestionserviceService } from './../../services/questionservice.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-recommend',
  templateUrl: './recommend.component.html',
  styleUrls: ['./recommend.component.css']
})
export class RecommendComponent implements OnInit {

  constructor(private token: TokenStorageService,public _route: ActivatedRoute, private router: Router, public fetchservice: QuestionserviceService) { }
  public fetch: any;
  public uname:String;
  ngOnInit(): any {
    this.uname = this.token.getUsername();
    console.log(this.uname);
    this.fetchservice.getallquestioninfo(this.uname).subscribe(
      data => {
        this.fetch = data;
      },
      error => {
        console.log(error.errorMessage);
      }
    );
  }
  openEditor(questionId) {
    this.router.navigate(['/execution', questionId]);
  }

}
