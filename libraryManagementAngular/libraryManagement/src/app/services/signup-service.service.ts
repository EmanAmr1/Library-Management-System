import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../classes/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignupServiceService {
private baseUrl="http://localhost:8081/user/signup";
  constructor(private httpClient:HttpClient) { }

/*signupUser(user:User):Observable<object>{
  console.log(user);
  return this.httpClient.post(`${this.baseUrl}`,user)
}*/

// modify HTTP request to treat the response as text instead of JSON
signupUser(user: any): Observable<any> {
  console.log(user);
  return this.httpClient.post(`${this.baseUrl}`, user, { responseType: 'text' });
}

}
