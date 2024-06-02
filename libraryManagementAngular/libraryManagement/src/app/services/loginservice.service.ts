import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../classes/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  private baseUrl = "http://localhost:8081/user/login"
  constructor(private httpClient: HttpClient) { }

  loginUser(user: User): Observable<User> {
    console.log(user);
    return this.httpClient.post<User>(`${this.baseUrl}`, user)

  }
}
