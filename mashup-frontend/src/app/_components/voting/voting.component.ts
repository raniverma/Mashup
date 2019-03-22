import { HttpClient } from '@angular/common/http';
import { Component, OnInit,Input } from '@angular/core';
import { QuestionserviceService } from 'src/app/services/questionservice.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { HttpModule } from '@angular/http';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-voting',
  templateUrl: './voting.component.html',
  styleUrls: ['./voting.component.css']
})
export class VotingComponent implements OnInit {

  public username;
  public add;
  public obj1;
  public obj2;
  public obj3;
  public vote: string;
  @Input() question: any;
  

  constructor(private token: TokenStorageService, private http: HttpModule, public questionservice: QuestionserviceService) { }
  
  ngOnInit() {
    
  }
  myFunction1(): any {
    this.vote = 'UP';
    this.username = this.token.getUsername();

   // tslint:disable-next-line:label-position
    this.add = '{"userName":"' + this.username + '"}';
    this.obj1  = JSON.parse(this.add);

    this.add = '{"questionId":"' + this.question + '"}';
    this.obj2  = JSON.parse(this.add);

    this.add = '{"voteStatus":"' + this.vote + '"}';
    this.obj3  = JSON.parse(this.add);

    const obj4 = Object.assign(this.obj3, this.obj1);
    this.questionservice.sendVote(obj4).pipe(first()).subscribe(
      data => {
        alert('Voting Successfull');
    },
    error => {
      alert(error);
    }
    );
  }

  myFunction2(): any {
    this.vote = 'DOWN';
    this.username = this.token.getUsername();

   // tslint:disable-next-line:label-position
    this.add = '{"userName":"' + this.username + '"}';
    this.obj1  = JSON.parse(this.add);
    
    this.add = '{"questionId":"' + this.question + '"}';
    this.obj2  = JSON.parse(this.add);

    this.add = '{"voteStatus":"' + this.vote + '"}';
    this.obj3  = JSON.parse(this.add);

    const obj4 = Object.assign(this.obj3, this.obj1);
    this.questionservice.sendVote(obj4).pipe(first()).subscribe(
      data => {
        alert('Successfull');
    },
    error => {
      alert(error);
    }
    );
  }

}
