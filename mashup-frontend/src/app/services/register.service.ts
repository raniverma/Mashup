import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../_models/user';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class RegisterService {
    errorHandlerService: any;
  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get<User[]>(`http://localhost:8096/api/v1/users`);
  }

  getById(id: number) {
    return this.http.get(`http://localhost:8096/api/v1/users/${id}`);
  }

  register(user: User): Observable<any> {
    console.log('user details are  : ', user);
    return this.http.post(`http://13.234.74.67:8092/registration-service/api/v1/register`, user, {responseType: 'text'});
  }

  update(user: User) {
    return this.http.put(`http://localhost:8096/api/v1/users/${user.id}`, user);
  }

  delete(id: number) {
    return this.http.delete(`http://localhost:8096/api/v1/users/${id}`);
  }
}
