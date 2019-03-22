import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SubmissionService {
  public username;
  public questionId;

  public getSub = 'http://13.234.74.67:8092/submission-service/api/v1/';

  constructor(private httpclient: HttpClient) { }

  public getSubmission(username,questionId): Observable<any> {
    console.log('username:',username);
    console.log('questionId:',questionId);
    const submissionData = this.httpclient.get(this.getSub + 'submission/' + username + '/' + questionId);
    console.log('submissionData:',submissionData);
    return submissionData;
  }
}
