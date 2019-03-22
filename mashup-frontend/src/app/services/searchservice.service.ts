import { Injectable } from '@angular/core';
import { QuestionserviceService } from './questionservice.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchserviceService {
  public tag;
  public fetchURL = 'http://13.234.74.67:8092/search-service/api/v1/question/';
  public getinfo = 'http://13.234.74.67:8092/search-service/api/v1/searched';
  constructor(private httpclient: HttpClient) { }

  public findQuestion(tag): Observable<any> {
    const info = this.httpclient.get(this.fetchURL + tag);
    console.log( tag + info);
    return info;
  }
}
