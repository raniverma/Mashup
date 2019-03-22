import { SignUpInfo } from './../_components/auth/signup-info';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserprofileServiceService {
  private userProfileUrl = 'http://13.234.74.67:8092/userprofile-service/api/v1/';
  constructor(private http: HttpClient) { }
  public getUserProfile(userName): Observable <any> {

    // tslint:disable-next-lin
    console.log('USERNAME : ', userName);
    const userProfile = this.http.get('http://13.234.74.67:8092/userprofile-service/api/v1/userprofile/' + userName);
     return userProfile;
  }
  public updateProfile(updatedProfile): Observable <any> {
    // tslint:disable-next-lin
    console.log('User Profile : ', updatedProfile);
    const newProfile = this.http.post('http://13.234.74.67:8092/userprofile-service/api/v1/userprofile/', updatedProfile);
    console.log('hii');
     return newProfile;
  }
  public deleteUserProfile(username): Observable <any> {
    const deletedProfile = this.http.delete('http://13.234.74.67:8092/userprofile-service/api/v1/userprofile/' + username);
    return deletedProfile;
  }
}
