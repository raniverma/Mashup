import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ScorebadgeService {

  public scoreBadgeApidUrl = 'http://13.234.74.67:8092/score-badge-service/api/v1/';

  constructor(private _http: HttpClient) {
    console.log('http service got called');
  }

  public getUserData(userName): Observable<any> {
    // tslint:disable-next-line:prefer-const
    let getUserData = this._http.get(this.scoreBadgeApidUrl + 'getTotalScore' + '/' + userName);
    console.log(getUserData);
    return getUserData;
  }

}
