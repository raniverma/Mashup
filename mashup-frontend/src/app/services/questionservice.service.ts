import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuestionserviceService {

  public questionPopulatorApidUrl = 'http://13.234.74.67:8092/question-service/api/v1/';
  public getallquestionUrl = 'http://13.234.74.67:8092/recommendation-service/rest/neo4j/questions';
  constructor(private _http: HttpClient) {
    console.log('http service got called');
  }

  public saveQuestion(questionObj): Observable<any> {
    // tslint:disable-next-line:prefer-const
    console.log('QUESTION : ', questionObj);
    const savedQuestionObj = this._http.post(this.questionPopulatorApidUrl + 'question', questionObj, {responseType: 'text'});
    console.log(savedQuestionObj);
    return savedQuestionObj;
  }
  public getallquestioninfo(uname): Observable<any>  {
    console.log('Inside recommendation service & URL : ',this.getallquestionUrl+"/"+uname);
    console.log('uname : ',uname);
    const allinfo = this._http.get(this.getallquestionUrl+"/"+uname);
    console.log(allinfo);
    return allinfo;
  }

  public sendVote(questionObj): Observable<any> {
    // tslint:disable-next-line:prefer-const
    console.log('QUESTION : ', questionObj);
    const savedQuestionObj = this._http.post('http://13.234.74.67:8092/voting-service/api/v1/vote', questionObj, {responseType: 'text'});
    console.log(savedQuestionObj);
    return savedQuestionObj;
  }
}
