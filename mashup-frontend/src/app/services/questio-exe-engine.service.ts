
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class QuestioExeEngineService {
  private url = './assets/question.json';
  private url3 = 'http://13.234.74.67:8092/question-service/api/v1/question/';
  private url2 = 'http://13.234.74.67:8023/rest/neo4j/questions/2';
  private url4 = 'http://13.234.74.67:8092/submission-service/api/v1/submission';
  private url5 = 'http://13.234.74.67:8025/api/v1/question';
  private url6 = 'http://13.234.74.67:8025/api/v1';
  constructor(private _http: HttpClient) { }


  public removeNodemon(username) {
    this._http.post(this.url6 + '/' + username, {}).subscribe();
  }
  public getcode(gitUrl, username): any {
       return this._http.put(this.url5 + '/' + username, { "gitUrl" : gitUrl});
          }

  public sendDatatoSubmission(quesresultdata){
    console.log(quesresultdata);
    console.log("oye kishlay data bhej raha hu accept karle");
               this._http.post(this.url4,quesresultdata).subscribe();
  }
  public getQuestionById(id): any {
    console.log('ID : ' + id);
    const quest = this._http.get(this.url3 + id);
    console.log(quest);
    return quest;
  }
  public  findques(): any {
    const trackinfo = this._http.get(this.url);
    return trackinfo;
     }
}

